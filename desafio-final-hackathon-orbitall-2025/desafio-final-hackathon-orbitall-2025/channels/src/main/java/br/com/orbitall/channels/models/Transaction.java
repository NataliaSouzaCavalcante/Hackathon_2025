package br.com.orbitall.channels.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "TRANSACTIONS")
@Data
public class Transaction {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull(message = "customerId é obrigatório")
    @Column(nullable = false)
    private UUID customerId;

    @NotNull(message = "amount é obrigatório")
    @DecimalMin(value = "0.01", message = "amount deve ser maior que zero")
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @NotBlank(message = "cardType é obrigatório")
    @Pattern(regexp="(?i)DEBITO|CREDITO", message = "Cartão deve ser DEBITO ou CREDITO.")
    @Column(nullable = false, length = 10)
    private String cardType;

    private LocalDateTime createdAt;
    private boolean active;
}
