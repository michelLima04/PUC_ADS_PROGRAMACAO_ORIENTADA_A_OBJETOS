package model;

public abstract class Financing{ // SUPER-Classe Abstrata do tipo Financiamento

    // ATRIBUTOS
    protected double propertyValue;      // Valor do imóvel
    protected int loanTerm;              // Prazo do Financiamento
    protected double annualInterestRate; // Taxa de Juros Anual

    // CONSTRUTOR - Para criar o Objeto Financiamento.
    public Financing(double propertyValue, int loanTerm, double annualInterestRate){
        this.propertyValue = propertyValue;
        this.loanTerm = loanTerm;
        this.annualInterestRate = annualInterestRate;
    }

    // GETTER para o Valor do Imovel para o Financiamento.
    public double getPropertyValue() {
        return this.propertyValue;
    }

    // GETTER para o Prazo do Financiamento.
    public int getLoanTerm(){
        return this.loanTerm;
    }

    // GETTER para a Taxa de Juros do Financiamento.
    public double getAnnualInterestRate(){
        return this.annualInterestRate/100;
    }

    // METODO Abstrato para calcular o Pagamento Mensal.
    public abstract double calculateMonthlyPayment();

    // METODO para calcular o valor Total do Financiamento.
     public double calculateTotalFinancingValue(){
        return this.calculateMonthlyPayment() * getLoanTerm() * 12;
    }
}
