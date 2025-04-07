package modelo;

public class Tesoureiro extends FuncionarioAutenticavel{

    public Tesoureiro(String nome) {
        super(nome);
    }

    @Override
    public double getBonificacaoNatalina() {
        return this.salario * 0.20;
    }
    
}
