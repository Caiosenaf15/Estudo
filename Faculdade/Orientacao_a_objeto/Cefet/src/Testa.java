public class Testa {
    public static void main(String[] args) throws Exception {
        FuncionarioDoCefet fc = new FuncionarioDoCefet();

        fc.setNome("Caco");
        fc.setSalario(20000);
        System.out.println(fc.getInfo());

        ProfessorDoCefet pc = new ProfessorDoCefet();
        
        pc.setNome("Fulano");
        pc.setSalario(10000);
        System.out.println(pc.getInfo());
    }
}
