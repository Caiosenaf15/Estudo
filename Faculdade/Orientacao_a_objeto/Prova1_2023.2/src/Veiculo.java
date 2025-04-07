public abstract class Veiculo {
    protected String modelo;
    protected int ano;
    protected double valorDeMercado;
    protected Motor motor = new Motor();

    //Construtor
    public Veiculo(String modelo, int ano, double valorDeMercado){
        this.modelo = modelo;
        this.ano = ano;
        this.valorDeMercado = valorDeMercado;
    }

    abstract double getValorImposto();

}
