package util;
import model.Financing;
import java.io.*;
import java.util.ArrayList;

// Classe responsável por operar a manipulação de Arquivos (Escrever e Ler)
public class FileManager {

    // Metodo responsavel por CRIAR/ESCREVER o arquivo.txt
    public static void saveDataAsText(String fileName, ArrayList<Financing> list){
        FileWriter arq = null;
        PrintWriter out = null;

        try{

          arq = new FileWriter(fileName);
          out = new PrintWriter(arq);

          // FOR-EACH que percorrerá o ArrayList que possue salvo os Financiamentos
          for(Financing financing : list){
              out.println(financing.toString());
          }

          out.close();
          arq.close();
          System.out.println("\n-> Dados salvo com sucesso!");

        }catch(FileNotFoundException e){
            e.printStackTrace(); // Se não for encontrado o arquivo, dará a MSG de erro.
        }catch(IOException e) {
            e.printStackTrace(); // Captura e mostra qualquer outro tipo de erro encontrado.
        }
    }

    // Metodo responsavel por LER o arquivo.txt
    public static void readTextData(String fileName){
        BufferedReader in = null;
        String line;

        System.out.println("-> Realizando a leitura do Arquivo (" + fileName + ") ...\n");

        try{
            in = new BufferedReader(new FileReader(fileName));

            while ((line = in.readLine()) != null){
                System.out.println(line);
            }

            in.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void saveSerializedData(String fileName, ArrayList<Financing> list){

        ObjectOutputStream outputStream = null;

        try{
            outputStream = new ObjectOutputStream(new FileOutputStream(fileName));

            // Salvando a lista do Objeto completa.
            outputStream.writeObject(list);

            outputStream.flush(); // Limpa possíveis lixos
            outputStream.close(); // Encerra o Stream
            System.out.println("\n-> Dados serializados com sucesso!");

        }catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void readSerializedData(String fileName){
        ObjectInputStream inputStream = null;

        System.out.println("-> Realizando a leitura do Arquivo Serializado (" + fileName + ") ...\n");

        try{

            inputStream = new ObjectInputStream(new FileInputStream(fileName));

            // Realizando a leitura do Objeto
            Object obj = inputStream.readObject();

            // Verifica se é um ArrayList
            if(obj instanceof ArrayList) {

                ArrayList<Financing> retrievedList = (ArrayList<Financing>) obj;

                // FOR-EACH que percorrerá a Lista recuperada e imprimirá na tela.
                for(Financing financing : retrievedList) {
                    System.out.println(financing.toString());
                }
            }

            inputStream.close();

        }catch (EOFException ex) {
            System.out.println("-> Final do arquivo alcançado.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
