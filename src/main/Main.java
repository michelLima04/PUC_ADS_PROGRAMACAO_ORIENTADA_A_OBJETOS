// Instituição: Pontifícia Universidade Católica do Paraná PUCPR
// Curso: Tecnologia em Análise e Desenvolvimento de Sistemas
// Disciplina: Programação Orientada a Objetos (1ºPeríodo)
// Aluno/Autor: Michel Urban Rosendo de Lima
// Tema: Sistema de Financiamento Imobiliário em JAVA

package main;
import model.Financing;
import util.UserInterface;

public class Main {
    public static void main(String[] args){

        UserInterface userInterface = new UserInterface(); // Criação do objeto Interface do Usuário

        double propertyValue = userInterface.askPropertyValue(); // Metodo para solicitar o Valor do Imóvel
        int loanTerm = userInterface.askLoanTerm();              // Metodo para solicitar o Prazo do Financiamento
        double interestRate = userInterface.askInterestRate();   // Metodo para solicitar a Taxa de Juros (anual)

        Financing newFinancing = new Financing(propertyValue, loanTerm, interestRate); // Criação do objeto Financiamento com bases nos dados obtidos anteriormente.

        newFinancing.displayFinancingData(); // Chamando o metodo que irá mostrar todos os dados do Financiamento

    }
}
