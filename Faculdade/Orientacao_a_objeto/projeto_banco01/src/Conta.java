public class Conta {
    private Cliente titular;
    private int numero;
    private double saldo;

    private Conta(){
        this.saldo = 500;
        this.titular = new Cliente();
    }

    //Overload
    public Conta(int numero){
        this();//Invocando o construtor default
        this.setNumero(numero);
    }

    /*public void setTitular(Cliente titular){
        this.titular = titular;
    }*/
    public Cliente getTitular(){
        return this.titular;
    }
    private void setNumero(int numero){
        this.numero = numero;
    }
    public int getNumero(){
        return this.numero;
    }
    public void deposita(double saldo){
        if(saldo > 0)
            this.saldo += saldo;
        else
            System.out.println("Deposito invalido!");
    }
    public double getSaldo(){
        return this.saldo;
    }
    public void saque(double saque){
        if(saque > 0 && this.saldo > saque)
            this.saldo -= saque;
        else
            System.out.println("Saque invalido!");
    }
    public void tranferePara(Conta conta, double saldo){
        if(this.saldo > saldo && saldo > 0 && this.numero != conta.numero){
            this.saldo -= saldo;
            conta.saldo += saldo;
        } else
            System.out.println("Transferencia invalida!");
    }
    public void mostraDados(){
        System.out.println("Numero: "+this.getNumero());
        System.out.println("Titular: "+this.getTitular());
        System.out.println("Saldo: "+this.getSaldo());
        System.out.println("-----------------------------");
    }
}
