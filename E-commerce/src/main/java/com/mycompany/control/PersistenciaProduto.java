package com.mycompany.control;

/**
 *
 * @author yurikfeitosa
 */

import java.util.ArrayList;
import java.util.List;
import com.mycompany.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class PersistenciaProduto {
    
    public static List<Produto> listarProdutos( Connection conexao) throws Exception{
        
        List<Produto> produtos = new ArrayList<Produto>();
        
        String sql = "SELECT * FROM produtos";
        
        try {
            
            PreparedStatement codigoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = codigoSQL.executeQuery();
            
            while(resultado.next()){
                
                int id = resultado.getInt("ID");
                String nome = resultado.getString("nome");
                String descricao = resultado.getString("descricao");
                float preco = resultado.getFloat("preco");
                int qtd_estoque = resultado.getInt("quantidade_estoque");
                Timestamp data_cadastro = resultado.getTimestamp("data_cadastro");
        
                produtos.add(new Produto(id, nome, descricao, preco, qtd_estoque, data_cadastro));
                
            }
            
            
        } catch (SQLException e){
            
            throw new Exception("Erro ao consultar dados: " + e.getMessage());
            
        }
        
        return produtos;
        
    }
}