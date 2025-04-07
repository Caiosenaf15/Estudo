package modelo;
public class Conta {
    protected int numero;//IMUTAVEL
    protected Cliente titular = new Cliente();//IMUTÁVEL
    protected double saldo;

    public void atualiza(double taxa){
        this.saldo -= taxa;
    }
    
    //Sobrecarga de construtores
    private Conta() {
        this.saldo = 500;
    }
    public Conta(int numero) {
        this();
        this.setNumero(numero);
    }

    private void setNumero(int numero) {
        if (numero < 1)
            return;// Early return
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public boolean saca(double valor) {
        // valor = valor + 0.10;
        if (valor > this.saldo || valor <= 0)
            return false;
        else {
            this.saldo -= valor;
            return true;
        }
    }

    public boolean deposita(double valor) {
        if (valor <= 0) {
            return false;
        }
        this.saldo += valor;
        return true;
    }

    public boolean transferePara(Conta contaDestino, double valor) {
        // Conta contaOrigem = this;
        if (!this.saca(valor))
            return false;
        if (!contaDestino.deposita(valor))
            return false;
        return true;
    }

    public void mostrarDados() {
        System.out.println("Numero: " + this.getNumero());
        System.out.println("Saldo: R$: " + this.saldo);
        System.out.println("Dados do titular: ");
        this.titular.mostrarDados();
    }
}
