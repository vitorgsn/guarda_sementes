package br.com.ifs.edu.guarda_sementes.models;

import br.com.ifs.edu.guarda_sementes.enums.ExchangeStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "exchanges")
public class ExchangeModel {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private String instructions;

    @NotNull
    private Float amount;

    @NotNull
    private ExchangeStatus status;

    @ManyToOne
    @JoinColumn(name = "sender_user_id")
    private UserModel senderUser;

    @ManyToOne
    @JoinColumn(name = "receiver_user_id")
    private UserModel receiverUser;

    @ManyToOne
    @JoinColumn(name = "seed_id", nullable = false)
    private SeedModel seed;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    public ExchangeModel() {

    }

    public ExchangeModel(UserModel senderUser, UserModel receiverUser, SeedModel seed, Float amount, String instructions) {
        this.senderUser = senderUser;
        this.receiverUser = receiverUser;
        this.seed = seed;
        this.amount = amount;
        this.instructions = instructions;
        this.status = ExchangeStatus.ABERTA;
    }
}
