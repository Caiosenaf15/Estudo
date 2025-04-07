public class VeiculoDePasseio extends Veiculo {
    
    public VeiculoDePasseio(String modelo, int ano, double valorDeMercado){
        super(modelo, ano, valorDeMercado);
    }

    public double getValorImposto(){
        return super.valorDeMercado * 0.10;
    }
}
