public class VeiculoUtilitario extends Veiculo{
    private int capacidadeDeCarga;

    public VeiculoUtilitario(String modelo, int ano, double valorDeMercado, int capacidadeDeCarga){
        super(modelo, ano, valorDeMercado);
        this.capacidadeDeCarga = capacidadeDeCarga;
    }

    public double getValorImposto(){
        return super.valorDeMercado * 0.20;
    }
}
