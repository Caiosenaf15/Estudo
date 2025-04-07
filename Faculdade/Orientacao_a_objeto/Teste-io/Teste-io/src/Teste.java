import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Teste {
    public static void main(String[] args) throws IOException{
             File diretorio=new File("C:\\java\\");
             if(!diretorio.isDirectory()){
             System.out.println("Diretório não existe.");
             if(diretorio.mkdir())
             System.out.println("Diretório "+diretorio+" criado.");
             }
            
             File arquivo=new File(diretorio, "meuArquivo.txt");
             if(diretorio.exists()){
             System.out.println("Diretório "+diretorio+" existe");
             if(arquivo.exists())
             System.out.println("Arquivo "+arquivo+" existe");
             else
             if(arquivo.createNewFile())
             System.out.println("O arquivo "+arquivo+"acaba de ser criado.");
             }
            
             File files=new File("C:\\java\\");
             //Verifica arquivos e diretórios em files
             for (File file : files.listFiles()) {
             System.out.println(file);
             }
            
             FileWriter fw = new FileWriter(arquivo,true);
             PrintWriter pw = new PrintWriter(fw);
             pw.println("Linha 1");
             pw.println("Linha 2");
             //Libera a escrita do arquivo
             pw.flush();
             //fecha o arquivo
             pw.close();
             }
            }
