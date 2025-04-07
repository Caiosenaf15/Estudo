public class Professor extends Pessoa {
    private int horasDeAulaMes;
    private double valorHoraAula;
    private double salario;

    public void calcularSalario(){
        salario = this.valorHoraAula * this.horasDeAulaMes;
    }
}
