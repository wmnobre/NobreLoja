/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;

/**
 *
 * @author 181301765
 */
public class CategoriaDAO {

    public static List<Categoria> getCategoriacodigo;
    
    
    public static void inserir(Categoria categoria){
        String sql = "INSERT INTO categoria ( nome ) "
                + " VALUES ( '" + categoria.getNome() + "'  ) ";
        boolean retorno = Conexao.executar( sql );
        if( !retorno ){
            JOptionPane.showMessageDialog(null, "Erro ao inserir categoria");
        }
        
    }
    
    public static void editar(Categoria categoria){
        String sql = "UPDATE categoria SET  "
                + " nome =  '" + categoria.getNome() + "'"
                + " WHERE codigo = " + categoria.getCodigo();
        boolean retorno = Conexao.executar( sql );
        if( !retorno ){
            JOptionPane.showMessageDialog(null, "Erro ao editar categoria ");
        }
        
    }
    
    public static void excluir(Categoria categoria){
        String sql = "DELETE FROM categoria  "
                  + " WHERE codigo = " + categoria.getCodigo();
        boolean retorno = Conexao.executar( sql );
        if( !retorno ){
            JOptionPane.showMessageDialog(null, "Erro ao excluir categoria ");
        }
        
    }
    
    
    public static List<Categoria> getCategorias(){
        String sql = " SELECT c.codigo, c.nome "
                   + " FROM categoria c "
                   + " ORDER BY c.nome ";
        
        
        List<Categoria> lista = new ArrayList<>();
        ResultSet rs = Conexao.consultar( sql );
        if( rs != null ){
            try {
                while ( rs.next() ) {                    
                    Categoria categoria = new Categoria();
                    categoria.setCodigo( rs.getInt( 1 ) );
                    categoria.setNome( rs.getString( 2 ) );
                    lista.add(categoria);
                                    }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
   
    
    public static Categoria getCategoriaByCodigo(int codigo){
        String sql = " SELECT c.codigo, c.nome "
                   + " FROM categoria c "
                   + " WHERE c.codigo = " + codigo;
        ResultSet rs = Conexao.consultar( sql );
        if( rs != null ){
            try {
                 rs.next();                    
                    Categoria categoria = new Categoria();
                    categoria.setCodigo( rs.getInt( 1 ) );
                    categoria.setNome( rs.getString( 0 ) );
                    
                    
                    return categoria;
            } catch (Exception e) {
                
            }
        }
        return null;
    }
   
}
    
