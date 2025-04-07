package testes;

import modelo.Caixa;
import modelo.ContabilizadorDeBonificacoes;
import modelo.Diretor;
import modelo.Funcionario;
import modelo.Gerente;
import modelo.Tesoureiro;

public class TestaContabilizadorDeBonificacoes {
    public static void main(String[] args) {
        ContabilizadorDeBonificacoes contabilizador = new ContabilizadorDeBonificacoes();
        Gerente g1 = new Gerente("Joao Pedro");g1.setSalario(3000);

        Gerente g2 = new Diretor("Andrew");g2.setSalario(4000);

        Caixa c1 = new Caixa("Aymeê");
        c1.setSalario(2000);

        Tesoureiro t1 = new Tesoureiro("Matheus");
        t1.setSalario(2500);

        //Funcionario f1 = new Funcionario("bla bla bla");

        contabilizador.contabiliza(g1);//900
        contabilizador.contabiliza(g2);//2000
        contabilizador.contabiliza(c1);//300
        contabilizador.contabiliza(t1);//500

        System.out.println("O total a ser gasto em bonificacoes é de R$"
        +contabilizador.getTotalEmBonificacoes());

        //g1.mostraDados();
        //g2.mostraDados();
    }
}
