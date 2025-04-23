package br.cefet.model;

public class Usuario {
    private int id;
    private String usuario;
    private String senhaHash;
    private String corFundo;
    private String corFonte;

    public Usuario() {}

    public Usuario(String usuario, String senhaHash, String corFundo, String corFonte) {
        this.usuario = usuario;
        this.senhaHash = senhaHash;
        this.corFundo = corFundo;
        this.corFonte = corFonte;
    }

    public Usuario(int id, String usuario, String senhaHash, String corFundo, String corFonte) {
        this.id = id;
        this.usuario = usuario;
        this.senhaHash = senhaHash;
        this.corFundo = corFundo;
        this.corFonte = corFonte;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getSenhaHash() { return senhaHash; }
    public void setSenhaHash(String senhaHash) { this.senhaHash = senhaHash; }
    public String getCorFundo() { return corFundo; }
    public void setCorFundo(String corFundo) { this.corFundo = corFundo; }
    public String getCorFonte() { return corFonte; }
    public void setCorFonte(String corFonte) { this.corFonte = corFonte; }
} 