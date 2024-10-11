public class App {
    public static void main(String[] args) throws Exception {
        for(int i = 1; i < 201; i++){
            if(i % 2 == 0){
                System.out.println(i + "= par");
            } else{
                System.out.println(i + "= impar");
            }
        }
    }
}
