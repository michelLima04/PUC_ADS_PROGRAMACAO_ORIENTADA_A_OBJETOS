package model;

public class Financing{ // Classe Financiamento

    // ATRIBUTOS
    private double propertyValue;      // Valor do imóvel
    private int loanTerm;              // Prazo do Financiamento
    private double annualInterestRate; // Taxa de Juros Anual

    // CONSTRUTOR - Para criar o Objeto Financiamento
    public Financing(double propertyValue, int loanTerm, double annualInterestRate){
        this.propertyValue = propertyValue;
        this.loanTerm = loanTerm;
        this.annualInterestRate = annualInterestRate;
    }

    // GETTER para o Valor do Imovel para o Financiamento
    public double getPropertyValue() {
        return this.propertyValue;
    }

    // GETTER para o Prazo do Financiamento
    public int getLoanTerm(){
        return this.loanTerm;
    }

    // GETTER para a Taxa de Juros do Financiamento
    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }

    // METODO para calcular o Pagamento Mensal.
    public double calculateMonthlyPayment(){
        return (getPropertyValue() / (getLoanTerm() * 12)) * (1 + (getAnnualInterestRate()/12));
    }
    // METODO para calcular o valor Total do Financiamento.
     public double calculateTotalFinancingValue(){
        return this.calculateMonthlyPayment() * getLoanTerm() * 12;
    }
}
