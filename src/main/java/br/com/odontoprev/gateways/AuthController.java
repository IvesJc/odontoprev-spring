package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.login.LoginRequest;
import br.com.odontoprev.dto.login.LoginResponse;
import br.com.odontoprev.dto.register.RegisterRequest;
import br.com.odontoprev.entities.Beneficiario;
import br.com.odontoprev.entities.TipoBeneficiarioEnum;
import br.com.odontoprev.repositories.BeneficiarioRepository;
import br.com.odontoprev.usecases.impl.JwtService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Endpoints destinados para a Autenticação")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final BeneficiarioRepository beneficiarioRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.senha())
        );

        UserDetails user = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(user);

        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        if (beneficiarioRepository.findByEmail(request.email()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já cadastrado.");
        }

        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setNome(request.nome());
        beneficiario.setEmail(request.email());
        beneficiario.setCpf(request.cpf());
        beneficiario.setTelefone(request.telefone());
        beneficiario.setTipo(TipoBeneficiarioEnum.fromValue(request.tipoBeneficiario()));
        beneficiario.setPassword(passwordEncoder.encode(request.password()));

        beneficiarioRepository.save(beneficiario);

        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso.");
    }

}
