package io.github.mahjoubech.post.dto.request;

import io.github.mahjoubech.post.model.enums.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = "Le nom complet est obligatoire.")
    private String nomComplet;
    @Email
    @NotBlank(message = "L'email est obligatoire.")
    private String email;
    @NotBlank(message = "Le mot de passe est obligatoire.")
    private String password;
    @NotBlank(message = "La confirmation du mot de passe est obligatoire.")
    private String confirmPassword;
    @NotBlank(message = "Le rôle est obligatoire.")
    private Roles role;
}
