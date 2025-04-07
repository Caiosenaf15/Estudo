public class Testa {
    public static void main(String[] args) throws Exception {
        Funcionario f1 = new Funcionario();
        f1.setNome("Lucila");
        f1.setSalario(2000);

        Gerente g1 = new Gerente();
        g1.setNome("Caco");
        g1.setSalario(2000);
        g1.setSenha(123);

        Caixa c1 = new Caixa();
        c1.setNome("Stutz");
        c1.setSalario(2500);
        c1.setNumeroDoGuiche(12);

        f1.mostraDados();
        System.out.println("Bonificacao: "+f1.getBonificacaoNatalina());
        System.out.println("###############################");

        c1.mostraDados();
        System.out.println("Guiche: "+c1.getNumeroDoGuiche());
        System.out.println("Bonificacao:"+c1.getBonificacaoNatalina());
        System.out.println("###############################");

        g1.mostraDados();
        System.out.println("Bonificacao: "+g1.getBonificacaoNatalina());
        if(g1.autentica(123,"cefet"))
            System.out.println("Acesso Liberado");
        else
            System.out.println("Acesso Negado");
        System.out.println("###############################");

    }
}
