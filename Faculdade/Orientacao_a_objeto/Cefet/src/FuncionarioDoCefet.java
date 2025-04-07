public class FuncionarioDoCefet extends Funcionario{
    private int matriculaSiape;

    public double getGastos(){
        return super.getSalario();
    }

    public String getInfo(){
        return "Nome: "+super.getNome()+", salario: "+super.getSalario();
    }

    public int getMatriculaSiape() {
        return matriculaSiape;
    }

    public void setMatriculaSiape(int matriculaSiape) {
        this.matriculaSiape = matriculaSiape;
    }

    
}
