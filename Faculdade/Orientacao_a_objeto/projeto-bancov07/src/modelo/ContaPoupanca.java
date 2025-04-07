package modelo;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(int numero) {
        super(numero);
    }

    @Override
    public void atualiza(double taxa) {
        super.atualiza(taxa*3);
    }
    
}
