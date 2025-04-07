public class TestaHeranca {
    public static void main(String[] args) throws Exception {
        Professor p = new Pessoa();
        
        p.setCpf(123);
        p.calcularSalario();
    }
}
