package testes;

import modelo.Conta;
import modelo.ContaCorrente;
import modelo.ContaPoupanca;

public class TestaContas {
    public static void main(String[] args) {
        Conta c = new Conta(1);
        c.deposita(1000);

        ContaCorrente cc = new ContaCorrente(2);
        cc.deposita(1000);

        ContaPoupanca cp = new ContaPoupanca(3);
        cp.deposita(1000);

        c.transferePara(cp, 500);

        Conta[] contas = new Conta[3];
        contas[0] = c;//1000
        contas[1] = cc;//990
        contas[2] = cp;//2000

        for(Conta con:contas){
            con.mostrarDados();
        }


        /*System.out.println("Saldo das contas antes de atualizar...");

        System.out.println(c.getSaldo());
        System.out.println(cc.getSaldo());
        System.out.println(cp.getSaldo());

        System.out.println("Saldo das contas DEPOIS de atualizar...");

        c.atualiza(0.01);
        cc.atualiza(0.01);
        cp.atualiza(0.01);

        System.out.println(c.getSaldo());
        System.out.println(cc.getSaldo());
        System.out.println(cp.getSaldo());*/
    }
}
