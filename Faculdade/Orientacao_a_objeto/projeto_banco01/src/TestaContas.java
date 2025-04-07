public class TestaContas {
    public static void main(String[] args) throws Exception {
        Conta conta1 = new Conta();
        Cliente t1 = new Cliente();
        conta1.setNumero(123);
        //conta1.setTitular(t1);
        conta1.deposita( 3000);

        Conta conta2 = new Conta();
        conta2.setNumero(456);
        //conta2.setTitular(t1);
        conta2.deposita(4000);

        Conta conta3 = new Conta();
        conta3.setNumero(789);
        //conta3.setTitular(t1);
        conta3.deposita(2500);

        conta2.deposita(-500);
        conta2.deposita(100);
        conta1.tranferePara(conta2, 5000);
        conta2.tranferePara(conta1, 200);
        conta3.tranferePara(conta3, 40);

        System.out.println("---Conta 1---");
        conta1.mostraDados();
        System.out.println("---Conta 2---");
        conta2.mostraDados();
        System.out.println("---Conta 3---");
        conta3.mostraDados();
    }
}
