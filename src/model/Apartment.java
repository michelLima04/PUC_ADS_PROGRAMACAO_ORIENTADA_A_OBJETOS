package model;

// Sub-classe para Financiamento de Apartamentos, recebe a herança da Super-classe 'Financing'
public class Apartment extends Financing{

    // Atributos
    private int garageSpots; // Vagas de garagens.
    private int floorNumber; // Número de andares.

    // Construtor
    public Apartment(double newPropertyValue, int newLoanTerm, double newAnnualInterestRate, int newGarageSpots, int newFloorNumber){
        super(newPropertyValue, newLoanTerm, newAnnualInterestRate);
        this.garageSpots = newGarageSpots;
        this.floorNumber = newFloorNumber;
    }

    // Metodos GETTER.
    public int getGarageSpots(){
        return this.garageSpots;
    }
    public int getFloorNumber(){
        return this.floorNumber;
    }

    // Metodo sobrescrito para calcular o Pagamento Mensal do Apartamento (OBS: Com alteração da fórmula base, utilizando o modelo PRICE)
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
