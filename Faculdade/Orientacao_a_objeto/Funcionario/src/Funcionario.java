//public class Funcionario {
    protected String nome, departamento;
    protected String cpf;
    protected double salario;
    protected boolean ativo;
    protected  Data dataDeNascimento = new Data();
    protected static int identificador;

    public Funcionario(String nome){
        this.nome = nome;
        identificador++;
    }

    public double getBonificacao(){
        return this.salario * 0.10;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
