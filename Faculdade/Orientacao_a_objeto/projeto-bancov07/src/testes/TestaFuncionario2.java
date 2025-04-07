package testes;
import modelo.Funcionario;

public class TestaFuncionario2 {
    public static void main(String[] args){
       Funcionario f1 = new Funcionario("Fulano");
       //f1.setNome("Beltrano");
       f1.setSalario(1000);

       System.out.println();
       System.out.println("Nome: "+f1.getNome());
       System.out.println("Salario: R$"+f1.getSalario());
       System.out.println("Bonificacao: R$" + f1.getBonificacaoNatalina());
    }
}
