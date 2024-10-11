import java.util.Scanner;

public class EscadaDoMario {
    public static void main(String[] args) throws Exception {
        System.out.println("Qual o tamanho da escada? ");
        Scanner sc = new Scanner(System.in);
        int tamanho = sc.nextInt();
        sc.close();
        for(int i = 0; i <= tamanho; i++){
            int j = i;
            while (j != 0) {
                System.out.print("#");
                j--;
            }
            System.out.println(" ");
        }
    }
}
