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
public class Categoria {
    
    private int codigo;
    private String nome;
   

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public Categoria() {
        
    }

    public Categoria(int codigo, String nome) {
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

    public Object getCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    }
