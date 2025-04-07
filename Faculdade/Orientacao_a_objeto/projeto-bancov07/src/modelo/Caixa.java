package modelo;
public final class Caixa extends Funcionario{
    public Caixa(String nome){
        super(nome);
    }

    private int numeroDoGuiche;

    public int getNumeroDoGuiche() {
        return this.numeroDoGuiche;
    }
    public void setNumeroDoGuiche(int numeroDoGuiche) {
        this.numeroDoGuiche = numeroDoGuiche;
    }

    @Override
    public double getBonificacaoNatalina() {
        return this.salario * 0.15;
    }
    
}
