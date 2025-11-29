package model;

import java.io.Serializable;

public abstract class Financing implements Serializable { // SUPER-Classe Abstrata do tipo Financiamento

    // ATRIBUTOS
    protected int id;                    // Número de identificação do Financiamento
    protected double propertyValue;      // Valor do imóvel
    protected int loanTerm;              // Prazo do Financiamento
    protected double annualInterestRate; // Taxa de Juros Anual

    // CONSTRUTOR - Para criar o Objeto Financiamento.
    public Financing(int id, double propertyValue, int loanTerm, double annualInterestRate){
        this.id = id;
        this.propertyValue = propertyValue;
        this.loanTerm = loanTerm;
        this.annualInterestRate = annualInterestRate;
    }

    // GETTER para o Valor do ID do Financiamento.
    public int getId() { return this.id; }

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

    // METODO para calcular o Pagamento Mensal.
    public double calculateMonthlyPayment(){
       return ( (this.getPropertyValue() / (this.getLoanTerm() * 12)) // Valor da parcela sem Juros (Amortização)
                * (1 + (this.getAnnualInterestRate() / 12)) );        // Juros
    };

    // METODO para calcular o valor Total do Financiamento.
     public double calculateTotalFinancingValue(){
        return this.calculateMonthlyPayment() * getLoanTerm() * 12;
    }

    // METODO que agrupará os valores dos atributos em uma String
    public String toString(){
         StringBuilder builder = new StringBuilder();

         builder.append("Nº " + this.getId() + ", ");
         builder.append("Valor Imóvel: R$ " + this.getPropertyValue() + ", ");
         builder.append("Valor Total: R$ " + this.calculateTotalFinancingValue() + ", ");
         builder.append("Taxa: " + (this.getAnnualInterestRate() * 100) + "%, ");
         builder.append("Prazo: " + this.getLoanTerm() + " anos, ");

         return builder.toString();
    }

}
