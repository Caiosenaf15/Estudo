public class TestaFaturamentoTrimestral {
    public static void main(String[] args) throws Exception {
        int faturamentoJaneiro = 20000;
        int faturamentoFevereiro = 40000;
        int faturamentoMarco = 15000;
        int faturamentoTrimestral = faturamentoJaneiro + faturamentoFevereiro + faturamentoMarco;
        float faturamentoMedio = faturamentoTrimestral / 3;
        System.out.print(faturamentoMedio);
        
    }
}


