public class SomadorDeImposto {
    private static double acumularGastosComImposto = 0;

    public void totalDeGastosComImpostos(Veiculo v){
        acumularGastosComImposto += v.getValorImposto();
    }

    public double getTotalDeGastosComImpostos(){
        return acumularGastosComImposto;
    }
}
