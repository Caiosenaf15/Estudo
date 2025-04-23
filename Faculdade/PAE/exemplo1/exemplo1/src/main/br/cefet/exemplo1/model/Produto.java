package br.cefet.exemplo1.model;

public class Produto {
    private int id;
    private String nome;
    private float valor;
    private Categoria categoria;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public float desconto (float percentual){
        if(percentual <= 0 || percentual > 100)
            return 0;
        else 
            return this.valor - this.valor * (percentual / 100);
    }
}
