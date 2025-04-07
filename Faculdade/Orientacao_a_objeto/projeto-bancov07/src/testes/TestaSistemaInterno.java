package testes;

import modelo.Diretor;
import modelo.Gerente;
import modelo.SistemaInterno;
import modelo.Tesoureiro;

public class TestaSistemaInterno {
    public static void main(String[] args) {
        Gerente g1 = new Gerente("Joao Pedro");
        g1.setSenha(555);
        g1.setSalario(20000);

        Gerente g2 = new Gerente("Andrew");
        g2.setSenha(554);
        g2.setSalario(30000);

        Diretor d1 = new Diretor("Aymeê");
        d1.setSenha(555);
        d1.setSalario(80000);

        Tesoureiro t1 = new Tesoureiro("Liliane");
        t1.setSalario(35000);
        t1.setSenha(555);

        SistemaInterno si = new SistemaInterno();

        si.login(g1);//ok
        si.login(g2);//não
        si.login(d1);//ok
        si.login(t1);//ok

    }
    
}
