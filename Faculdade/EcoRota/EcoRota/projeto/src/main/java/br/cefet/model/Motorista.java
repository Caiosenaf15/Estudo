// src/main/java/br/cefet/model/Motorista.java
package br.cefet.model;

public class Motorista {
    private int id;
    private String nome;
    private int idade; // Campo adicionado
    private String matricula;

    // Construtor padrão (necessário para alguns frameworks e para instanciar vazio)
    public Motorista() {
    }

    // Construtor para criar um novo Motorista (sem ID, que será gerado pelo DB)
    public Motorista(String nome, int idade, String matricula) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
    }

    // Construtor completo (para carregar Motorista do banco de dados)
    public Motorista(int id, String nome, int idade, String matricula) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
    }

    // Getters e Setters
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Motorista [id=" + id + ", nome=" + nome + ", idade=" + idade + ", matricula=" + matricula + "]";
    }
}