package br.com.ifs.edu.guarda_sementes.enums;

public enum Role {
    ADMIN(1),
    USER(2);

    int roleId;

    Role(int roleId) {
        this.roleId = roleId;
    };
}
