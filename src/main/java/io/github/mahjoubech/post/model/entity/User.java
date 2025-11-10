package io.github.mahjoubech.post.model.entity;

import io.github.mahjoubech.post.model.enums.Roles;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public abstract class  User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected String id;
    @Column(name = "nom_complet", nullable = false)
    protected  String nomComplet;
    @Column(name = "email", nullable = false, unique = true)
    protected String email;
    @Column(name = "password", nullable = false)
    protected String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    protected Roles role;
    @Column(name = "date_creation", nullable = false, updatable = false)
    protected ZonedDateTime dateCreated;
    @PrePersist
    public void prePersist() {
        if (dateCreated == null) {
            dateCreated = ZonedDateTime.now();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public String getPassword() {
        return password;
    }

}
