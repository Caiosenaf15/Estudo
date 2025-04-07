package modelo;

public abstract class FuncionarioAutenticavel extends Funcionario{
    protected int senha;

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public boolean autentica(int senhaExterna) {
        if (this.senha == senhaExterna)
            return true;
        return false;
    }

    public FuncionarioAutenticavel(String nome) {
        super(nome);
    }
    
}
