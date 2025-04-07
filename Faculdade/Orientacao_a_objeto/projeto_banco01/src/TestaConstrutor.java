public class TestaConstrutor {
    public static void main(String[] args) {
        Conta c1 = new Conta(10);
        c1.getTitular().setNome("Daniel O Pensador");
        //c1.setNumero(10);
        c1.getTitular().setEmail("daniel@cefet-rj.br");
        c1.getTitular().setCpf(1234567891);

        Conta c2 = new Conta(11);
        c2.getTitular().setNome("Brenda");
        //c2.setNumero(10);
        c2.getTitular().setEmail("brenda@cefet-rj.br");
        c2.getTitular().setCpf(1234567892);

        System.out.println("A conta numero: " + c1.getNumero() + " pertence ao cliente "
        + c1.getTitular().getNome() + " e possui saldo R$" + c1.getSaldo()+ ".");

        System.out.println();

        System.out.println("A conta numero: " + c2.getNumero() + " pertence ao cliente "
        + c2.getTitular().getNome() + " e possui saldo R$" + c2.getSaldo()+ ".");
    }
}
