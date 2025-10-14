package com.mycompany.dao;

/**
 *
 * @author yurikfeitosa
 */
import java.sql.Connection;

public interface ConexaoInterface {
    
    Connection obterConexao() throws Exception;
    
    void fecharConexao(Connection conexao) throws Exception;
}