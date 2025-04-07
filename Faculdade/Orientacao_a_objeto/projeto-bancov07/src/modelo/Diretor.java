package modelo;

public class Diretor extends Gerente{

    public Diretor(String nome) {
        super(nome);
    }

    @Override
    public double getBonificacaoNatalina() {
        return super.salario * 0.50;
        //Bonificacao de um gerente (30%) + 1000,00
        //return ((this.salario * 0.30)+1000);
        //return super.getBonificacaoNatalina()+1000.0;
    }
    
}
