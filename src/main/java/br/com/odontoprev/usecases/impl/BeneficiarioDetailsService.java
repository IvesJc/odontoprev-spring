package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.repositories.BeneficiarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeneficiarioDetailsService implements UserDetailsService {

    private final BeneficiarioRepository beneficiarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return beneficiarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Beneficiário não encontrado"));
    }
}
