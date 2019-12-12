package com.example;

public class Product {
    private String raca;
    private double valor;
    private int quantidade;
    public Product(String raca, double valor, int quantidade) {
        this.raca = raca;
        this.valor = 0.00;
        this.quantidade = 0;
    }

    public Product(String string) {
	}

	/** 
     * @return the raca
     */
    
    public String getRaca() {
        return this.raca;
    }

    /** 
     * @param raca the raca to set
    */

    public void setRaca(String raca) {
        this.raca = raca;
    }
    
    public double getValor() {
        return this.valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public double getQuantidade() {
        return this.quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}