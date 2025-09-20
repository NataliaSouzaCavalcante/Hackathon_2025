package br.com.orbitall.channels.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "CUSTOMERS")
@Data
public class Customer {
    @Id private UUID id;
    @NotBlank(message = "O nome não pode ser vazio")
    @Size(min = 3, max = 255, message = "O nome deve ter entre 3 e 100 caracteres")
    private String fullName;
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email deve ser válido")
    @Size(min = 0, max = 100)
    private String email;
    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter apenas números e ter 10 ou 11 dígitos")
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean active;
}
