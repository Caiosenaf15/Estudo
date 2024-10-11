public class App {
    public static void main(String[] args) {
        caneta umaCaneta = new caneta();
        umaCaneta.cor = "azul";
        umaCaneta.tamanho = 12;
        umaCaneta.marca = "Bic";
        
        caneta outraCaneta = new caneta();
        outraCaneta.cor = "preta";
        outraCaneta.tamanho = 12;
        outraCaneta.marca = "Bic";
        outraCaneta.tampa = true;
        System.out.println("umaCaneta tem cor "+umaCaneta.cor+" e e da marca "+umaCaneta.marca+".");
        System.out.println("outraCaneta tem cor "+outraCaneta.cor+" e e da marca "+outraCaneta.marca+".");
    }

}