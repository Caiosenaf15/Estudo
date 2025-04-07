package modelo;

public class ContaCorrente extends Conta{

    public ContaCorrente(int numero) {
        super(numero);
    }

    @Override
    public void atualiza(double taxa) {
        this.saldo -= (taxa*2);
    }

    @Override
    public boolean deposita(double valor) {
        return super.deposita(valor - 0.10);
    }
    
}
