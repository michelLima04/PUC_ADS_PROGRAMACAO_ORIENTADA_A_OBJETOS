package model;

// Sub-classe para Financiamento de Casas, recebe a herança da Super-classe 'Financing'
public class Home extends Financing{

    public Home(double newPropertyValue, int newLoanTerm, double newAnnualInterestRate){
        super(newPropertyValue, newLoanTerm, newAnnualInterestRate);
    }

    // METODO sobrescrito para calcular o Pagamento Mensal da Casa (OBS: com adicional de 80,00 para cada parcela).
    @Override
    public double calculateMonthlyPayment(){
        return super.calculateMonthlyPayment() + 80;
    }
}
