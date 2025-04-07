public class Testa {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        Pessoa p2 = new Pessoa();

        p1.setNome("Caco");
        p1.setIdade(20);

        p2.setNome("Balls");
        p2.setIdade(5);

        p1.aniversario();
        p1.aniversario();
        p2.aniversario();

        p1.mostraDados();
        p2.mostraDados();

        Porta por1 = new Porta();

        por1.abre();
        por1.fecha();
        por1.abre();
        por1.pinta("Branco");
        por1.setAltura(2);
        por1.setLargura(0.5);
        por1.mostraDados();
    }
    
}
