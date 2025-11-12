package model;

// Sub-classe para Financiamento de Apartamentos, recebe a herança da Super-classe 'Financing'
public class Apartment extends Financing{

    public Apartment(double newPropertyValue, int newLoanTerm, double newAnnualInterestRate){
        super(newPropertyValue, newLoanTerm, newAnnualInterestRate);
    }


    // METODO para calcular o Pagamento Mensal.
    @Override
    public double calculateMonthlyPayment(){

        // Variável quer armazenará a Taxa Mensal do Financiamento.
        double monthlyInterestRate = (super.getAnnualInterestRate()/12);

        // Variável que armazenará o total de meses do Financiamento.
        int totalMonths = super.getLoanTerm() * 12;

        // Fórmula alterada para a o Financiamento de Apartamento com base no sistema de amortização PRICE.
        return ((super.getPropertyValue() * monthlyInterestRate * Math.pow((1 + monthlyInterestRate), totalMonths)) / (Math.pow((1 + monthlyInterestRate), totalMonths) - 1));
    }
}
