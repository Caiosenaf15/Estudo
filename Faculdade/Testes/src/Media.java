import java.util.*;
public class Media {
    public static void main(String[] args) throws Exception {
        Aluno aluno1 = new Aluno();
        System.out.println("Qual a primeira nota? ");
        Scanner sc = new Scanner(System.in);
        int nota1 = sc.nextInt();
        aluno1.setNota1(nota1);
        System.out.println("Qual a segunda nota? ");
        int nota2 = sc.nextInt();
        aluno1.setNota2(nota2);
        sc.close();
        int media;
        media = (aluno1.nota1 + aluno1.nota2) / 2;
        System.out.println("A media do aluno e: " + media);
    }
}
