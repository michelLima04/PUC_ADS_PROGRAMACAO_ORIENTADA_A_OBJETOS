// Instituição: Pontifícia Universidade Católica do Paraná PUCPR
// Curso: Tecnologia em Análise e Desenvolvimento de Sistemas
// Disciplina: Programação Orientada a Objetos (1ºPeríodo)
// Aluno/Autor: Michel Urban Rosendo de Lima
// Tema: Sistema de Financiamento Imobiliário em JAVA

package main;
import model.Financing;      // Importa o arquivo Financing da pasta model.
import util.UserInterface;   // Importa o arquivo UserInterface da pasta util.
import java.util.ArrayList;  // Importa a classe ArrayList dos utilitários do Java para o seu uso.

public class Main {

    public static void main(String[] args) {

        // Criação da lista que armazenará os objetos do tipo Financiamentos.
        ArrayList<Financing> financingList = new ArrayList<>();

        // Criação do objeto do tipo Interface do Usuário.
        UserInterface userInterface = new UserInterface();

        // 1° Financiamento Manual
        double propertyValue = userInterface.askPropertyValue(); // Metodo para solicitar o Valor do Imóvel
        int loanTerm = userInterface.askLoanTerm();             // Metodo para solicitar o Prazo do Financiamento.
        double interestRate = userInterface.askInterestRate(); // Metodo para solicitar a Taxa de Juros (anual).
        financingList.add(new model.Home(1, propertyValue, loanTerm, interestRate, 150, 300));

        // Demais Financiamento setados automaticamente (1x Casa, 2x Apartamento e 2x Terrenos).
        financingList.add(new model.Home( 2,500000, 20, 10, 200, 400));
        financingList.add(new model.Apartment(3,300000, 15, 9, 1, 5));
        financingList.add(new model.Apartment(4,800000, 10, 12, 3, 15));
        financingList.add(new model.Lot(5,150000, 5, 11, "Comercial"));
        financingList.add(new model.Lot(6,250000, 12, 10, "Residencial"));

        // Váriavel que somarará o valor de Todos os Imóveis;
        double allPropertiesValue = 0.0;
        // Váriavel que somarará o valor de Todos os Financiamentos.
        double allFinancingsValue = 0.0;
        int cont = 1;

        // Calculo geral de Todos os Financiamentos
        System.out.println("\n----------------[ FINANCIAMENTOS ]------------------");

        // Estrutura FOR-EACH que irá percorrer os Objetos do tipo Financiamento dentro do ArrayList de Financimentos.
        for(Financing financing : financingList){

            allPropertiesValue += financing.getPropertyValue();
            allFinancingsValue += financing.calculateTotalFinancingValue();

            // Pesquisei esta função na internet (instanceof), para diferenciar cada tipo de Objeto de Financiamento presente no ArrayList.
            String typeFinancing = "";
            if(financing instanceof model.Home){
                typeFinancing = "Casa";
            }
            else if(financing instanceof model.Apartment){
                typeFinancing = "Apartamento";
            }
            else if(financing instanceof model.Lot){
                typeFinancing = "Terreno";
            }

            System.out.printf("\n> Financiamento %d: %s\n", cont, typeFinancing);

            System.out.println(financing.toString());

            cont++;
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.printf(" > VALOR TOTAL DE TODOS OS IMÓVEIS: R$%,.3f\n", allPropertiesValue);
        System.out.printf(" > VALOR TOTAL DE TODOS OS FINANCIAMENTOS: R$%,.3f\n", allFinancingsValue);
        System.out.println("-----------------------------------------------------------------");

        // Processo de salvar todos os Financiamentos no arquivo.txt
        util.FileManager.saveDataAsText("ListaFinanciamentos.txt", financingList);

        // Processo de realizar a leitura e print do arquivo.txt
        util.FileManager.readTextData("ListaFinanciamentos.txt");

        // Processo de serializar a lista de objetos do Tipo Financiamento para binário
        util.FileManager.saveSerializedData("ListaFinanciamentos.dat", financingList);

        // Processo de des-serializar os dados e imprimir no terminal.
        util.FileManager.readSerializedData("ListaFinanciamentos.dat");

    }
}
