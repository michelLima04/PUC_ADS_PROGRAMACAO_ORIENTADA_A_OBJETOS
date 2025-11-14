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

        // Variavel que armazenará o Valor de Todos os Imóveis.
        double allPropertiesValue = 0.0;
        // Variavel que armazenara o Valor de Todos os Financiamentos.
        double allFinancingsValue = 0.0;

        // Metodo para solicitar o Valor do Imóvel
        double propertyValue = userInterface.askPropertyValue();
        // Metodo para solicitar o Prazo do Financiamento.
        int loanTerm = userInterface.askLoanTerm();
        // Metodo para solicitar a Taxa de Juros (anual).
        double interestRate = userInterface.askInterestRate();

        // Criação dos Objetos de Financiamento, 2x Casas, 2x Apartamento e 1x Terreno. (OBS: Todos os 5x Financiamentos terão seus valores de atributos IGUAIS, por enquanto).
        financingList.add(new model.Home(propertyValue, loanTerm, interestRate, 120.8, 180.8));
        financingList.add(new model.Home(propertyValue, loanTerm, interestRate, 139.5, 159.5));
        financingList.add(new model.Apartment(propertyValue, loanTerm, interestRate, 120, 30));
        financingList.add(new model.Apartment(propertyValue, loanTerm, interestRate, 150, 50));
        financingList.add(new model.Lot(propertyValue, loanTerm, interestRate, "Comercial"));

        // Váriavel que somarará o valor de Todos os Imóveis;
        allPropertiesValue = 0;
        // Váriavel que somarará o valor de Todos os Financiamentos.
        allFinancingsValue = 0;

        int cont = 1;
        String typeFinancing = "";
        System.out.println("\n----------------[FINANCIAMENTOS]------------------");
        // Estrutura FOR-EACH que irá percorrer os Objetos do tipo Financiamento dentro do ArrayList de Financimentos.
        for(Financing financing : financingList){

            double currentPropertyValue = financing.getPropertyValue();
            int currentLoanTerm = financing.getLoanTerm();
            double currentMonthPayment = financing.calculateMonthlyPayment();
            double currentFinancingValue = financing.calculateTotalFinancingValue();

            // Pesquisei esta função na internet (instanceof), para diferenciar cada tipo de Objeto de Financiamento presente no ArrayList.
            if(financing instanceof model.Home){
                typeFinancing = "Casa";
            }
            else if(financing instanceof model.Apartment){
                typeFinancing = "Apartamento";
            }
            else if(financing instanceof model.Lot){
                typeFinancing = "Terreno";
            }

            System.out.printf("\n> Financiamento %d: " + typeFinancing +
                              "\n  - Valor do Imóvel: R$%,.3f" +
                              "\n  - Prazo(anos): %d" +
                              "\n  - Valor da Parcela: RS%,.3f" +
                              "\n  - Valor Total do Financimento: R$%,.3f\n", cont,currentPropertyValue, currentLoanTerm, currentMonthPayment,currentFinancingValue);

            allPropertiesValue += currentPropertyValue;
            allFinancingsValue += currentFinancingValue;

            cont++;
        }
        System.out.println("--------------------------------------------------");
        System.out.printf("> VALOR TOTAL DE TODOS OS IMÓVEIS: R$%,.3f\n", allPropertiesValue);
        System.out.printf("> VALOR TOTAL DE TODOS OS FINANCIAMENTOS: R$%,.3f\n", allFinancingsValue);
    }
}
