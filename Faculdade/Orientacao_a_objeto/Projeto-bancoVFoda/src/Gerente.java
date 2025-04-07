public class Gerente extends Funcionario{
    private int senha;

    public boolean autentica(int senha, String login){
        return (this.senha == senha && login == "cefet");
    }

    public double getBonificacaoNatalina(){
        return super.salario * 0.30;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

}
