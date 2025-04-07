package modelo;
public class Cliente {
    //atributos
    private String nome;
    private String cpf;
    private String email;

    public Cliente() {
    }

    //getters and setters
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        if(nome.length()<5)
            return;
        this.nome = nome;
    }
    public String getCpf() {
        return this.cpf;
    }

    //método encapsulado
    private boolean validaCpf(String cpf){
        if(cpf.length()!=11)
            return false;
        return true;
    }
    public void setCpf(String cpf) {
        if(this.validaCpf(cpf))
            this.cpf = cpf;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void mostrarDados(){
        System.out.println("Nome: "+this.nome);
        System.out.println("Cpf: "+this.getCpf());
        System.out.println("E-mail: "+this.email);
    }

    
}
