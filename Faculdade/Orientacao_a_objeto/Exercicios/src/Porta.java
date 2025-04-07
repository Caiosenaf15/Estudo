public class Porta {
    private boolean aberta;
    private String cor;
    private double largura, altura;

    void abre(){
        this.aberta = true;
    }

    void fecha(){
        this.aberta = false;
    }

    void pinta(String cor){
        this.cor = cor;
    }

    String  getCor(){
        return this.cor;
    }

    boolean estaAberta(){
        return this.aberta;
    }

    public double getLargura() {
        return this.largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    void mostraDados(){
        System.out.println("Cor: "+this.cor);
        System.out.println("Dimensoes: "+this.altura+"m x "+this.largura+"m");
        System.out.println("Esta aberta: "+this.estaAberta());
    }
}
