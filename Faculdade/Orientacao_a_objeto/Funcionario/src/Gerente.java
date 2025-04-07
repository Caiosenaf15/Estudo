public class Gerente extends Funcionario{
    private int senha;
    private int numeroDeFuncionariosGerenciados;

    
    public double getBonificacao(){
        return super.getBonificacao() + 1000;
    }

    public Gerente(String nome){
        super(nome);
    }
}
