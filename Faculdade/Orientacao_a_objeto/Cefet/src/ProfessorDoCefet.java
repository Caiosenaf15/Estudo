public class ProfessorDoCefet extends FuncionarioDoCefet{
    private double auxilioAlimentacao = 400.0;

    //Override
    public double getGastos(){
        return this.auxilioAlimentacao + super.getGastos();
    }

    //Override
    public String getInfo(){
        return super.getInfo() + " ( " + this.auxilioAlimentacao + " referente ao auxilio alimentacao )";
    }
}
