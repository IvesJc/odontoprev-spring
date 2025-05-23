package br.com.odontoprev.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "beneficiario")
public class Beneficiario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotNull
    @Size(max = 100)
    @Column

    private String nome;

    @NotNull
    @Pattern(regexp = "^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$", message = "Email inválido")
    @Size(max = 100)
    @Column
    private String email;

    @NotNull
    @Size(max = 200)
    @Column
    private String password;

    @NotNull
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", message = "CPF inválido")
    @Column
    private String cpf;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoBeneficiarioEnum tipo;

    @NotNull
    @Pattern(regexp = "^(\\+55\\s?)?(0?(\\(?\\d{2}\\)?)?\\s?\\d{4,5}-?\\d{4}$)", message = "Telefone inválido")
    @Column
    private String telefone;

    @NotNull
    @Column
    private LocalDate dataAdesao = LocalDate.now();

    @Size(max = 300)
    @Column
    private String fotoUrl;

    @Size(max = 50)
    @Column
    private String numeroContrato;

    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;

    //EAGER |   Imediatamente junto com a entidade principal  |  Mais pesado, carrega tudo mesmo sem usar
    //LAZY	|   Somente quando for acessado no código	      |  Mais leve, mas pode causar problemas se não estiver dentro de uma transação
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "beneficiario_permissao", joinColumns = {@JoinColumn(name = "id_beneficiario")},
            inverseJoinColumns = {@JoinColumn(name = "id_permissao")})
    @Column
    private List<Permissao> permissoes;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "empresa_contratante_id")
    private EmpresaContratante empresaContratante;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissoes;
    }

    public List<String> getRoles(){
        List<String> roles = new ArrayList<>();
        for (Permissao permissao : permissoes){
            roles.add(permissao.getRole().name());
        }
        return roles;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
    @Override
    public String getPassword() {
        return this.password;
    }



    //    isAccountNonExpired()	Retorna false se a conta passou da validade (ex: conta inativa por muito tempo)
    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    //    isAccountNonLocked()	Retorna false se a conta foi bloqueada (ex: após 3 tentativas erradas de login)
    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    //    isCredentialsNonExpired()	Retorna false se a senha venceu e precisa ser trocada
    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    //    isEnabled()	Retorna false se o usuário está desativado no sistema
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

}


