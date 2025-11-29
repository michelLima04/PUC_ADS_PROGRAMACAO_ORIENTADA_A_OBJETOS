package model;

// Sub-classe para Financiamento de Apartamentos, recebe a herança da Super-classe 'Financing'
public class Apartment extends Financing{

    // Atributos
    private int garageSpots; // Vagas de garagens.
    private int floorNumber; // Número de andares.

    // Construtor
    public Apartment(int newId, double newPropertyValue, int newLoanTerm, double newAnnualInterestRate, int newGarageSpots, int newFloorNumber){
        super(newId, newPropertyValue, newLoanTerm, newAnnualInterestRate);
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

    // METODO sobrescrito que agrupará os valores dos atributos do Apartamento em uma String
    @Override
    public String toString(){

        // Abaixo, utilizando o metodo 'super', chamamos o toString() da classe Pai (Financing), para trazer os atributos que lá foram pré-definidos.
        StringBuilder builder = new StringBuilder(super.toString());

        builder.insert(0, "Tipo: Apartamento, ");
        builder.append("Vagas: " + this.getGarageSpots() + ", ");
        builder.append("Andares: " + this.getFloorNumber());

        return builder.toString();
    }
}
