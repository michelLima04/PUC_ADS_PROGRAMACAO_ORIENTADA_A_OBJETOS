package model;

// Sub-classe para Financiamento de Terrenos, recebe a herança da Super-classe 'Financing'
public class Lot extends Financing{

    // Atributos
    private String typeZone; // Tipo de Zona (residencial / comercial).

    // Construtor
    public Lot(int newId, double newPropertyValue, int newLoanTerm, double newAnnualInterestRate, String newTypeZone){
        super(newId, newPropertyValue, newLoanTerm, newAnnualInterestRate);
        this.typeZone = newTypeZone;
    }

    // Metodo GETTER.
    public String getTypeZone(){
        return this.typeZone;
    }

    // Metodo sobrescrito para calcular o Pagamento Mensal do Terreno (OBS: com adicional de 2% do valor do Terreno para cada parcela).
    @Override
    public double calculateMonthlyPayment(){
        // Calculo base para calcular o Financimanto.
        return super.calculateMonthlyPayment() * 1.02;
    }

    // METODO sobrescrito que agrupará os valores dos atributos do Terreno em uma String
    @Override
    public String toString(){

        // Abaixo, utilizando o metodo 'super', chamamos o toString() da classe Pai (Financing), para trazer os atributos que lá foram pré-definidos.
        StringBuilder builder = new StringBuilder(super.toString());

        builder.insert(0, "Tipo: Terreno, ");
        builder.append("Zona: " + this.getTypeZone());

        return builder.toString();
    }

}


