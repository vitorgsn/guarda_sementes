package br.com.ifs.edu.guarda_sementes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "instructions")
public class InstructionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String title;

    @NotNull
    private String message;

    public InstructionModel() {
    }

    public InstructionModel(String title, String message) {
        this.title = title;
        this.message = message;
    }
}
