public class ExercicioX {
    public static void main(String[] args) throws Exception {
        for(int i = 100; i < 201; i++ ){
            //System.out.println(i);
        }
        int soma = 0;
        for(int i = 0; i < 501; i++){
            soma = soma + i;
        }
        System.out.println(soma);
        int qtd = 0;
        for(int i = 1; i < 3001; i++){
            if(i % 5 == 0)
                qtd++;
                System.out.println(i);
        }
        System.out.println(qtd);
    }
        
} 
