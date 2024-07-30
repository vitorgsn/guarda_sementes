package br.com.ifs.edu.guarda_sementes.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity(name = "contacts")
public class ContactModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserModel user;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    public ContactModel() {
    }

    public ContactModel(String email, String phone, UserModel user) {
        this.email = email;
        this.phone = phone;
        this.user = user;
    }
}
