package org.itstep;

public enum Color {
    RED("#f00"),
    GREEN("#0f0"),
    BLUE("#00f"),
    WHITE("#fff"),
    BLACK("#000");

    private String color;
    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
