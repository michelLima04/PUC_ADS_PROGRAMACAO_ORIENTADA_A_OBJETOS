package model;

// Sub-classe para Financiamento de Terrenos, recebe a herança da Super-classe 'Financing'
public class Lot extends Financing{

    public Lot(double newPropertyValue, int newLoanTerm, double newAnnualInterestRate){
        super(newPropertyValue, newLoanTerm, newAnnualInterestRate);
    }

    @Override
    public double calculateMonthlyPayment(){
        return super.calculateMonthlyPayment() * 1.02;
    }
}


