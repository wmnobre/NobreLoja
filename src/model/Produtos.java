/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 181301765
 */
  
    
    
/**
 *
 * @author assparremberger
 */
public class Produtos {
    
    private int codigo;
    private String nome;
    private double preco,quantidade;
    private Categoria categoria;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
   
    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public Produtos() {
        
    }

    public Produtos(int codigo, String nome, Estado estado) {
        this.codigo = codigo;
        this.nome = nome;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Object getProdutos(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    
    

    
    
    
    
    
    
    


    

