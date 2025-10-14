package com.mycompany.interfaces; 

import java.util.Scanner;
import java.sql.Connection;
import java.util.List;

import com.mycompany.dao.ConexaoMySQL; 
import com.mycompany.model.Produto;
import com.mycompany.control.PersistenciaProduto; 

public class Ecommerce {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection acessoSQL = null; 
        
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            acessoSQL = conexao.obterConexao();
            
            int opcao = 0;
            
            while(opcao != 5){
                
                menuSistemaEcommerce();
                
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("\nOPÇÃO INVÁLIDA! Digite um número de 1 a 5.");
                    scanner.nextLine();
                    continue;
                }
                
                switch (opcao){
                    case 1:
                        System.out.println("\n--- PRODUTOS DISPONÍVEIS ---");
                        listarProdutos(acessoSQL);
                        break;
                        
                    case 2:
                        System.out.println("\n** MÓDULO DE CARRINHO **");
                        System.out.println("Funcionalidade de ADICIONAR PRODUTO ao carrinho ainda não implementada.");
                        break;
                        
                    case 3:
                        System.out.println("\n** MÓDULO DE CARRINHO **");
                        System.out.println("Funcionalidade de VER CARRINHO ainda não implementada.");
                        break;
                    
                    case 4:
                        menuFinalizarCompra();
                        
                        int subOpcao = 0;
                        if (scanner.hasNextInt()) {
                             subOpcao = scanner.nextInt();
                        }
                       
                        if(subOpcao == 1) {
                            System.out.println("\nFinalizando Compra... Funcionalidade não implementada.");
                        } else if (subOpcao == 0) {
                            System.out.println("\nVoltando ao menu principal...");
                        } else {
                            System.out.println("\nOpção inválida na finalização de compra. Voltando ao menu.");
                        }
                        scanner.nextLine();
                        break;
                        
                    case 5:
                        System.out.println("\nSistema finalizado. Até logo!");
                        break;
                        
                    default:
                        System.out.println("\nOPÇÃO INVÁLIDA! Por favor, escolha uma opção de 1 a 5.");
                        break;
                }
            }
            
        } catch (Exception e) {
            System.err.println("\nERRO CRÍTICO NO SISTEMA: " + e.getMessage());
            e.printStackTrace();
            
        } finally {
            try {
                if (acessoSQL != null) {
                    new ConexaoMySQL().fecharConexao(acessoSQL);
                }
            } catch (Exception e) {
                 System.err.println("ERRO ao fechar a conexão: " + e.getMessage());
            }
            scanner.close();
        }
    }
    
    private static void listarProdutos(Connection conexao) throws Exception {
        
        List<Produto> produtos = PersistenciaProduto.listarProdutos(conexao);
        
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-20s | %-12s | %-10s |\n", "ID", "Nome", "Preço", "Estoque");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        for (Produto produto : produtos) {
            String precoFormatado = String.format("R$%,.2f", produto.getPreco());
            String estoqueFormatado = produto.getQtd_estoque() + " unidades";
            
            System.out.printf("| %-4d | %-20s | %-12s | %-10s |\n", 
                produto.getId(), 
                produto.getNome(), 
                precoFormatado, 
                estoqueFormatado
            );
        }
        
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        
    }
    
    private static void menuSistemaEcommerce() {
        System.out.println("\n============================");
        System.out.println("  SISTEMA DE E-COMMERCE");
        System.out.println("============================");
        System.out.println("1. Listar Produtos");
        System.out.println("2. Adicionar produto ao Carrinho");
        System.out.println("3. Ver Carrinho");
        System.out.println("4. Finalizar Compra");
        System.out.println("5. Sair");
        System.out.println("----------------------------");
        System.out.print("Escolha uma opção: ");
    }
    
    private static void menuFinalizarCompra() {
        System.out.println("\n--- FINALIZAR COMPRA ---");
        System.out.println("1. Confirmar e Pagar");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
}