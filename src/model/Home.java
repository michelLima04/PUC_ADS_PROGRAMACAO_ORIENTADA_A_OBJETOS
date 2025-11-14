package model;

// Sub-classe para Financiamento de Casas, recebe a herança da Super-classe 'Financing'.
public class Home extends Financing{

    // Atributos
    private double builtArea; // Área Contruída.
    private double lotSize;   // Tamanho do Terreno.

    // Construtor
    public Home(double newPropertyValue, int newLoanTerm, double newAnnualInterestRate, double newBuiltArea, double newLotSize){
        super(newPropertyValue, newLoanTerm, newAnnualInterestRate);
        this.builtArea = newBuiltArea;
        this.lotSize = newLotSize;
    }

    // Metodos GETTER.
    public double getBuiltArea(){
        return this.builtArea;
    }
    public double getLotSize(){
        return this.lotSize;
    }

    // Metodo sobrescrito para calcular o Pagamento Mensal da Casa (OBS: com adicional de 80,00 para cada parcela).
    @Override
    public double calculateMonthlyPayment(){

        // Calculo base para calcular o Financimanto.
        double monthlyPayment = (super.getPropertyValue() / (super.getLoanTerm() * 12)) * (1 + (super.getAnnualInterestRate() / 12));

        return monthlyPayment + 80;
    }
}
