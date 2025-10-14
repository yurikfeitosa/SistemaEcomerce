package com.mycompany.model;

/**
 *
 * @author yurikfeitosa
 */

import java.sql.Timestamp;

public class Produto {
    
    private int id;
    private String nome;
    private String descricao;
    private float preco;
    private int qtd_estoque;
    private Timestamp data_cadastro;
    
    public Produto (int id, String nome, String descricao, float preco, int qtd_estoque, Timestamp data_cadastro){
        
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtd_estoque = qtd_estoque;
        this.data_cadastro = data_cadastro; 
    }
    
    // Método para exibir informações
    public void mostrarInformacoes(){
        
        System.out.println(id + "  " + nome + "  " + descricao + "  " + preco + "  " + qtd_estoque + "  " + data_cadastro);
        
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getPreco() {
        return preco;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public Timestamp getData_cadastro() {
        return data_cadastro;
    }
    
    // Setters (Opcionais, mas úteis caso queira modificar o objeto)
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    // O id e a data_cadastro geralmente não são alterados após a criação,
    // mas se precisar de setters para eles, é só me dizer.
}