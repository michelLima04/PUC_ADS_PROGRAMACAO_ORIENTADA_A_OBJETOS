// Instituição: Pontifícia Universidade Católica do Paraná PUCPR
// Curso: Tecnologia em Análise e Desenvolvimento de Sistemas
// Disciplina: Programação Orientada a Objetos (1ºPeríodo)
// Aluno/Autor: Michel Urban Rosendo de Lima
// Tema: Sistema de Financiamento Imobiliário em JAVA

package main;                // Pasta Main.
import model.Financing;      // Importa o arquivo Financing da pasta model.
import util.UserInterface;   // Importa o arquivo UserInterface da pasta util.
import java.util.ArrayList;  // Importa a classe ArrayList dos utilitários do Java para o seu uso.

public class Main {
    public static void main(String[] args) {

        // Criação da lista que armazenará os objetos do tipo Financiamentos
        ArrayList<Financing> financingList = new ArrayList<>();

        // Criação do objeto do tipo Interface do Usuário.
        UserInterface userInterface = new UserInterface();

        // Variavel que armazenará o Valor de Todos os Imóveis.
        double allPropertiesValue = 0.0;
        // Variavel que armazenara o Valor de Todos os Financiamentos
        double allFinancingsValue = 0.0;

        // Utilizei este for que se repetirá 4x vezes para criar 4 financiamentos em seguida.
        for (int i = 1; i <= 4; i++) {

            System.out.println("> FINANCIAMENTO " + i + ":");

            // Metodo para solicitar o Valor do Imóvel
            double propertyValue = userInterface.askPropertyValue();
            // Metodo para solicitar o Prazo do Financiamento
            int loanTerm = userInterface.askLoanTerm();
            // Metodo para solicitar a Taxa de Juros (anual)
            double interestRate = userInterface.askInterestRate();

            // Criação do objeto Financiamento com bases nos dados obtidos anteriormente.
            Financing currentFinancing = new Financing(propertyValue, loanTerm, interestRate);

            // Metodo para adicionar na Lista de Financiamentos, o financiamento corrente.
            financingList.add(currentFinancing);

            // Váriavel que somarará o valor de Todos os Imóveis;
            allPropertiesValue += currentFinancing.getPropertyValue();
            // Váriavel que somarará o valor de Todos os Financiamentos.
            allFinancingsValue += currentFinancing.calculateTotalFinancingValue();

            System.out.println("--------------------------------------------------");
        }

        int cont = 1;
        System.out.println("----------------[FINANCIAMENTOS]------------------\n");

        // Estrutura FOR-EACH que irá percorrer os objetos dentro do ArrayList de Financimentos.
        for(Financing financing : financingList){
            double currentPropertyValue = financing.getPropertyValue();
            int currentLoanTerm = financing.getLoanTerm();
            double currentFinancingValue = financing.calculateTotalFinancingValue();
            System.out.printf("> Financimento %d: \n  - Valor do Imóvel: R$%,.3f\n  - Prazo(anos): %d\n  - Valor Total do Financimento: R$%,.3f\n", cont, currentPropertyValue, currentLoanTerm, currentFinancingValue);
            cont++;
        }
        System.out.println("--------------------------------------------------");
        System.out.printf("> TOTAL DE TODOS OS IMÓVEIS: R$%,.3f\n", allPropertiesValue);
        System.out.printf("> TOTAL DE TODOS OS FINANCIAMENTOS: R$%,.3f\n", allFinancingsValue);
    }
}
