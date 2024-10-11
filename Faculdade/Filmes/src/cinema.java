import java.util.Scanner;

public class cinema {
    public static void main(String[] args) throws Exception {
        filme filme1 = new filme();
        filme filme2 = new filme();
        filme2.titulo = "SHREK";
        filme1.titulo = "Jogador N1";
        filme1.categoria = "Aventura";
        filme1.imdb = 10;
        filme2.categoria = "Animacao";
        filme2.imdb = 9.8;
        System.out.println("Qual o titulo do filme?");
        Scanner sc = new Scanner(System.in);
        String titulo3 = sc.nextLine();
        filme filme3 = new filme();
        filme3.titulo = titulo3;
        System.out.println(filme1.titulo);
        System.out.println(filme1.categoria);
        System.out.println(filme1.imdb);
        System.out.println(filme2.titulo);
        System.out.println(filme2.categoria);
        System.out.println(filme2.imdb);
        System.out.println(filme3.titulo);
    }
}
