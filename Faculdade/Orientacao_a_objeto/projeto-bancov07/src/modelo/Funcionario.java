package modelo;
public abstract class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome) {
        this.setNome(nome);
    }

    //comportamento
   public abstract double getBonificacaoNatalina();
    //Métodos get e set (métodos acessores, getters and setters)

    public String getNome() {
        return this.nome;
    }

    public final void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void mostraDados(){
        System.out.println();
        System.out.println("Nome: " + this.getNome());
        System.out.println("Salario: R$" + this.salario);
        System.out.println("Bonificacao: R$" + this.getBonificacaoNatalina());
    }
    

    
}
