package br.com.ifs.edu.guarda_sementes.enums;

public enum StockCategory {
    MILHO("milho"),
    FEIJÃO("feijão");

    private String category;

    StockCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }
}
