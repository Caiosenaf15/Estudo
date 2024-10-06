public class ExercicioX {
    public static void main(String[] args) throws Exception {
        for(int i = 100; i < 201; i++ ){
            System.out.println(i); //Printa os numeros de 100 a 200
        }
        int soma = 0;
        for(int i = 0; i < 501; i++){
            soma = soma + i; 
        }
        System.out.println(soma); //Printa a soma dos numeros de 1 a 500
        int qtd = 0;
        for(int i = 1; i < 3001; i++){
            if(i % 5 == 0)
                qtd++;
                System.out.println(i); //Printa os numeros divisiveis por 5
        }
        System.out.println(qtd); //Printa a quantidade dos divisiveis por 5
    }
        
} 
