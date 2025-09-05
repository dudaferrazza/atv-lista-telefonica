package org.example.model;

public class Contato {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String observacao;

    public Contato(String nome, int id, String telefone, String email, String observacao) {
        this.nome = nome;
        this.id = id;
        this.telefone = telefone;
        this.email = email;
        this.observacao = observacao;
    }
    public Contato(String nome, String telefone, String email, String observacao) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}