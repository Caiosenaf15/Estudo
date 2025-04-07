import java.io.*;

public class App {
    public static void main(String[] args) {
        //Para estar no escopo do finally
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            InputStream is = new FileInputStream("arquivo.txt");
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            

            String linha;
            do{
                linha = br.readLine();
                if(linha != null){
                    System.out.println(linha);
                }
            } while(linha != null);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (IOException e) {
                System.err.println("Erro ao fechar os recursos: " + e.getMessage());
            }
        }
    }
}

