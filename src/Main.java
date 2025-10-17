// Instituição: Pontifícia Universidade Católica do Paraná PUCPR
// Curso: Tecnologia em Análise e Desenvolvimento de Sistemas
// Disciplina: Programação Orientada a Objetos (1ºPeríodo)
// Aluno/Autor: Michel Urban Rosendo de Lima
// Tema: Sistema de Financiamento Imobiliário em JAVA

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Financing{ // Classe Financiamento

    // ATRIBUTOS
    double propertyValue;      // 1º atributo - Valor do imóvel
    int loanTerm;              // 2° atributo - Prazo do Financiamento
    double annualInterestRate; // 3° atributo - Taxa de Juros Anual

    // CONSTRUTOR - Para inicializar os atributos
    Financing(double propertyValue, int loanTerm, double annualInterestRate){
        this.propertyValue = propertyValue;
        this.loanTerm = loanTerm;
        this.annualInterestRate = annualInterestRate;
    }
    // METODO para calcular o Pagamento Mensal.
    double calculateMonthlyPayment(){
        return (this.propertyValue / (this.loanTerm * 12)) * (1 + (this.annualInterestRate/12));
    }
    // METODO para calcular Total do Pagamento.
    double calculateTotalPayment(){
        return this.calculateMonthlyPayment() * this.loanTerm * 12;
    }
    //METODO para imprimir os dados do Financiamento.
    void displayFinancingData(){
        System.out.println("----------------------------------");
        System.out.println("----------[FINANCIAMENTO]---------");
        System.out.println("----------------------------------");
        System.out.println(" > DADOS:");
        System.out.println(" - Valor do Imóvel: R$" + propertyValue);
        System.out.println(" - Prazo do Financiamento: " + loanTerm + " anos");
        System.out.println(" - Taxa de Juros anual: " + annualInterestRate + "%");
        System.out.println("----------------------------------");
        System.out.println(" > PAGAMENTO P/ MÊS: R$" + calculateMonthlyPayment());
        System.out.println("----------------------------------");
        System.out.println(" > PAGAMENTO TOTAL: R$" + calculateTotalPayment());
        System.out.println("----------------------------------");
    }
}

class UserInterface{ // Classe de Interface com o Usuário
    Scanner sc = new Scanner(System.in); // Inicializando a variável responsável por printar na tela

    // METODO para solicitar ao Usuário o Valor do Imóvel desejado.
    double askPropertyValue(){
        System.out.print("> Informe o Valor do Imóvel: >>R$");
        return sc.nextDouble();
    }
    // METODO para solicitar ao Usuário o Prazo do Financiamento.
    int askLoanTerm(){
        System.out.print("> Informe o Prazo do Financiamento (anos): >>");
        return sc.nextInt();
    }
    // METODO para solicitar ao Usuário a Taxa de Juros (anual) para o seu financiamento.
    double askInterestRate(){
        System.out.print("> Informe a Taxa de Juros (%): >>");
        return sc.nextDouble();
    }
}
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
