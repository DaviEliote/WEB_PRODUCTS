/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author davieliote
 */
public class Produto {
    
    private int id;
    private String descricao;
    private double preco;
    private int quantidade;
    private String categoria;
    private String marca;
    private double peso;
    private java.sql.Date validade;
    private String cor;
    private String fornecedor;

    // Construtor padrão
    public Produto() {}
    
    public Produto(String descricao, double preco, int quantidade, String categoria,
            String marca, double peso, java.sql.Date validade, String cor, String fornecedor) {
        
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.marca = marca;
        this.peso = peso;
        this.validade = validade;
        this.cor = cor;
        this.fornecedor = fornecedor;
        
    }

    // Construtor com todos os atributos
    public Produto(int id, String descricao, double preco, int quantidade, String categoria,
                   String marca, double peso, java.sql.Date validade, String cor, String fornecedor) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.marca = marca;
        this.peso = peso;
        this.validade = validade;
        this.cor = cor;
        this.fornecedor = fornecedor;
    }
    
    
    public Produto(String descricao, double preco, int quantidade, String categoria,
                   String marca, double peso, java.sql.Date validade, String cor, String fornecedor, int id) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.marca = marca;
        this.peso = peso;
        this.validade = validade;
        this.cor = cor;
        this.fornecedor = fornecedor;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public java.sql.Date getValidade() {
        return validade;
    }

    public void setValidade(java.sql.Date validade) {
        this.validade = validade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
}


