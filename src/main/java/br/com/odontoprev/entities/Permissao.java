package br.com.odontoprev.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "permissao")
public class Permissao implements GrantedAuthority {

    // GrantedAuthority	Representa uma permissão do usuário (ROLE_ADMIN, ROLE_USER, ROLE_MANAGER, etc)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public String getAuthority() {
        return "ROLE_" + this.role.name();
        // getAuthority()	Retorna a String da role
    }
}
