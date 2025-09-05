package org.example;

import org.example.dao.ContatoDAO;
import org.example.model.Contato;
import org.example.utils.Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) {
        inicio();
    }

    public static void inicio() {
        boolean sair = false;

        System.out.println("-------------------Lista Telefonica-------------------");
        System.out.println("\n1. Cadastrar contato: Nome, Telefone, Email, Observação.");
        System.out.println("2. Listar todos os contatos cadastrados.");
        System.out.println("3. Buscar contato por nome.");
        System.out.println("4. Atualizar dados de um contato (telefone, email, observação).");
        System.out.println("5. Remover contato.");
        System.out.println("6. Sair do sistema.");

        int opcao = SC.nextInt();
        SC.nextLine();

        switch (opcao) {
            case 1:{
                cadastrarContato();
                break;
            }
            case 2:{
                listarContatos();
                break;
            }
            case 3:{
                buscarContatoPorNome();
                break;
            }
            case 6:{
                sair = true;
                break;
            }
        }

        if (!sair) {
            inicio();
        }
    }

    public static void cadastrarContato(){
        System.out.println ("\n\n--------Cadastrar Contato--------\n\n");

        System.out.println ("\nDigite o nome do contato: ");
        String nome = SC.nextLine();

        System.out.println ("Digite o telefone do contato: ");
        String telefone = SC.nextLine();

        System.out.println ("Digite o email do contato: ");
        String email = SC.nextLine();

        System.out.println ("Digite a oberservação sobre o contato: ");
        String observacao = SC.nextLine();

        var contato = new Contato(nome, telefone, email, observacao);
        var contatoDao = new ContatoDAO();

        try {
            contatoDao.inserirContato(contato);
        }catch (SQLException e) {
            System.out.println ("Ocorreu um erro no banco de dados!");
            e.printStackTrace();
        }
    }

    public static void listarContatos() {
        System.out.println("\n\n--------Listar Contatos--------\n\n");
        List<Contato> contatos = new ArrayList<>();
        var contatoDao = new ContatoDAO();
        try {
            contatos = contatoDao.listarContatos();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro no banco de dados!");
            e.printStackTrace();
        }
        Utils.exibirContatos(contatos);
    }

    public static void buscarContatoPorNome() {
        System.out.println("---- Buscar Contato Por Nome ----");
        System.out.println("Digite o nome do contato que voce quer buscar: ");
        String nome = SC.nextLine();
        List<Contato> contatos = new ArrayList<>();
        try {
            var contatoDAO = new ContatoDAO();
            contatos = contatoDAO.buscarContatosPorNome(nome);
        } catch (SQLException e){
            System.out.println("Ocorreu um erro no banco de dados!");
            e.printStackTrace();
        }
        Utils.exibirContatos(contatos);
    }
}