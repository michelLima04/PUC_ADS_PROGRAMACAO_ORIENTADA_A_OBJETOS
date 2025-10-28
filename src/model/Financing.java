package model;

public class Financing{ // Classe Financiamento

    // ATRIBUTOS
    private double propertyValue;      // 1º atributo - Valor do imóvel
    private int loanTerm;              // 2° atributo - Prazo do Financiamento
    private double annualInterestRate; // 3° atributo - Taxa de Juros Anual

    // CONSTRUTOR - Para criar o Objeto Financiamento
    public Financing(double propertyValue, int loanTerm, double annualInterestRate){
        this.propertyValue = propertyValue;
        this.loanTerm = loanTerm;
        this.annualInterestRate = annualInterestRate;
    }
    // GETTER para o Valor do Financiamento
    public double getPropertyValue() {
        return this.propertyValue;
    }
    // GETTER para o Prazo do Financiamento
    public int getLoanTerm(){
        return this.loanTerm;
    }
    // GETTER para a Taxa de Juros do Financiamento
    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }

    // METODO para calcular o Pagamento Mensal.
    public double calculateMonthlyPayment(){
        return (this.propertyValue / (this.loanTerm * 12)) * (1 + (this.annualInterestRate/12));
    }
    // METODO para calcular Total do Pagamento.
     public double calculateTotalPayment(){
        return this.calculateMonthlyPayment() * this.loanTerm * 12;
    }
    //METODO para imprimir os dados do Financiamento.
    public void displayFinancingData(){
        System.out.println("----------------------------------");
        System.out.println("----------[FINANCIAMENTO]---------");
        System.out.println("----------------------------------");
        System.out.println(" > DADOS:");
        System.out.println(" - Valor do Imóvel: R$" + propertyValue);
        System.out.println(" - Prazo do Financiamento: " + loanTerm + " anos");
        System.out.println(" - Taxa de Juros anual: " + annualInterestRate + "%");
        System.out.println("----------------------------------");
        System.out.println(" > PAGAMENTO P/ MÊS: R$" + calculateMonthlyPayment());
        System.out.println("----------------------------------");
        System.out.println(" > PAGAMENTO TOTAL: R$" + calculateTotalPayment());
        System.out.println("----------------------------------");
    }
}
