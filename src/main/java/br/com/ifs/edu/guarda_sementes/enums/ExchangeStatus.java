package br.com.ifs.edu.guarda_sementes.enums;

public enum ExchangeStatus {
    ABERTA("aberta"),
    PENDENTE("pendente"),
    ACEITA("aceita"),
    FINALIZADA("finalizada"),
    CANCELADA("cancelada");

    private String status;

    ExchangeStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
