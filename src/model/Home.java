package model;

import util.IncreaseExceedsInterestException;

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

    private void validateIncreaseAmount(double interest, double increase) throws IncreaseExceedsInterestException {
        //implementar lógica para validar
        if(increase > (interest/2)) {
            throw new IncreaseExceedsInterestException("O acréscimo de X é maior que o juros de Y !");
        }
    }

    // Metodo sobrescrito para calcular o Pagamento Mensal da Casa (OBS: com adicional de 80,00 para cada parcela).
    @Override
    public double calculateMonthlyPayment(){

        // Obter valor dos Juros da parcela
        double interest = ( super.getPropertyValue() / (super.getLoanTerm() * 12) ) * ( super.getAnnualInterestRate() / 12 );
        // Valor do Acréscimo
        double increase = 80;

        try{
            validateIncreaseAmount(interest, increase);
        }catch(IncreaseExceedsInterestException e){
            //alterar o valor do acressimo para igual ao valor do juros
            increase = interest;
        }

        // Calcular o Financimanto.
        return super.calculateMonthlyPayment() + increase;
    }
}
