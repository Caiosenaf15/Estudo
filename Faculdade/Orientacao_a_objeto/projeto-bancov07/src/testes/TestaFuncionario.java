package testes;
import modelo.Gerente;

public class TestaFuncionario {
    public static void main(String[] args) {
        int x=1;
        double y = x;
        Gerente f1 = new Gerente("Fulano");
        f1.setSalario(1000);
        //f1.salario = -5000;

        System.out.println();
        System.out.println("Nome: " + f1.getNome());
        System.out.println("Salario: R$" + f1.getSalario());
        System.out.println("Bonificacao: R$" + f1.getBonificacaoNatalina());
    }
}
