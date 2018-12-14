/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Produtos;



/**
 *
 * @author 181301765
 */
  
    
/**
 *
 * @author assparremberger
 */
public class ProdutoDAO {
    
   
    
    public static void inserir(Produtos produtos){
        String sql = "INSERT INTO produtos (  nome, preco, quantidade, codCategoria ) "
                + " VALUES ( "
                + " '" + produtos.getNome() + "' , "
                       + produtos.getPreco()+ " , "
                       + produtos.getQuantidade()  + " , "                     
                       + produtos.getCategoria().getCodigo() 
                + " )" ;
               
        boolean retorno = Conexao.executar( sql );
        if( !retorno ){
            JOptionPane.showMessageDialog(null, "Erro ao inserir a produto");
        }
        
    }
    
    public static void editar(Produtos produtos){
        String sql = "UPDATE produtos SET  "
                + " codigo, nome, preco, quantidade =  '" + produtos.getCodigo()+ "' , "
                + " WHERE codigo = " + produtos.getCodigo();
        boolean retorno = Conexao.executar( sql );
        if( !retorno ){
            JOptionPane.showMessageDialog(null, "Erro ao editar a produto");
        }
        
    }
    
    public static void excluir(Produtos produtos){
        String sql = "DELETE FROM produtos  "
                  + " WHERE codigo = " + produtos.getCodigo();
        boolean retorno = Conexao.executar( sql );
        if( !retorno ){
            JOptionPane.showMessageDialog(null, "Erro ao excluir a produto");
        }
        
    }
    
    
    public static List<Produtos> getProdutos(int codigoCategoria){
        String sql = " SELECT p.codigo, p.nome, p.preco, p.quantidade, p.codCategoria "
                   + " FROM produtos p "
                   + " INNER JOIN categoria c   "
                   + " ON p.codCategoria = c.codigo"
                   + "WHERE p.codCategoria = " + codigoCategoria
                   + " ORDER BY p.nome ";
        List<Produtos> lista = new ArrayList<>();
        ResultSet rs = Conexao.consultar( sql );
        if( rs != null ){
            try {
                while ( rs.next() ) {                    
                    Categoria cat = new Categoria();
                    cat.setCodigo( rs.getInt( 5 ) );
                    cat.setNome( rs.getString( 6 ) );
                    
                    Produtos pro = new Produtos();
                    pro.setCodigo( rs.getInt(1) );
                    pro.setNome( rs.getString(2) );
                    pro.setPreco(rs.getDouble(3) );
                    pro.setQuantidade(rs.getDouble(4) );
                    pro.setCategoria(cat);
                    lista.add( pro );
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    
    
    
    public static Produtos getProdutosByCodigo(int codigo){
        String sql = " SELECT p.codigo, p.nome, p.preco, p.quantidade, p.codCategoria "
                   + " FROM produtos p "
                   + " INNER JOIN categoria c   "
                   + " ON p.codCategoria = c.codigo "
                   + "WHERE p.codCategoria = " + codigo
                   + " ORDER BY p.nome ";
        ResultSet rs = Conexao.consultar( sql );
        if( rs != null ){
            try {
                 rs.next();                    
                    Produtos pro = new Produtos();
                    pro.setCodigo( rs.getInt( 3 ) );
                    pro.setNome( rs.getString( 4 ) );                                      
                    pro.setCodigo( rs.getInt(1) );
                    pro.setNome( rs.getString(2) );
                   
                    return pro;
            } catch (Exception e) {
                
            }
        }
        return null;
    }
   
}

    
}

