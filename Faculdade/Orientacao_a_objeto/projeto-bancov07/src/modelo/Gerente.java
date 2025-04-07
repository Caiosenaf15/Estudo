package modelo;
public class Gerente extends FuncionarioAutenticavel {
    

    /*public boolean autentica(String login, int senha){
        return (login == "cefet" && senha == this.senha);
    }*/

    public Gerente(String nome) {
        super(nome);
    }

    public Gerente(String nome, double salario) {
        this(nome);
        this.setSalario(salario);
    }



    /*public Gerente() {
        super();
    }*/

    //sobrescrita ou reescrita
    @Override
    public double getBonificacaoNatalina() {
        return super.salario * 0.30;
    }
    // Métodos get e set (métodos acessores, getters and setters

}
