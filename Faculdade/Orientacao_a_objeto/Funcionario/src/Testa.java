public class Testa {
    public static void main(String[] args) throws Exception {
        Gerente gerente = new Gerente("Caco");
        gerente.setSalario(1000);
        System.out.println(gerente.getBonificacao());
    }
}
