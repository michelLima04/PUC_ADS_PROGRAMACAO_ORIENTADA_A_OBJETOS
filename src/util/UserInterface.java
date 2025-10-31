package util;
import java.util.Scanner;

public class UserInterface{ // Classe de Interface com o Usuário
    Scanner sc = new Scanner(System.in); // Variável responsável que lê o input do Usuaário.

    // METODO para solicitar ao Usuário o Valor do Imóvel desejado.
    public double askPropertyValue() {
        double propertyValue;

        while (true) {
            System.out.print("> Informe o Valor do Imóvel: >> R$");
            // Fazendo a leitura do input como uma String, para a próxima validação.
            String inputPropertyValue = sc.nextLine();

            try{
                // Validação try/catch para garantir que o input seja um número, e não aceite Strings ou Char como input (Obs: Pesquisei na internet para fazer esta validação mais completa e realista.)

                // Tentativa de converter o input String para um Double.
                propertyValue = Double.parseDouble(inputPropertyValue);

                // Se a conversão foi um sucesso, logo o input é um número, e ele validará para aceitar apenas valores positivos.
                if (propertyValue > 0) {
                    break;
                } else {
                    System.out.println("> Erro - Valor inválido!");
                }
            }catch(NumberFormatException e){
                // Se a conversão falhou, logo o input não é um número.
                System.out.println("Erro - Digite apenas números!");
            }
        }
        return propertyValue;
    }
    // METODO para solicitar ao Usuário o Prazo do Financiamento.
    public int askLoanTerm(){
        int loanTerm;

        while(true){
            System.out.print("> Informe o Prazo do Financiamento (anos): >> ");
            String inputLoanTerm = sc.nextLine();

            try{
                // Tentativa de convertar o input String para Int
                loanTerm = Integer.parseInt(inputLoanTerm);

                // Se a conversão foi um sucesso, logo o input é um número, e ele validará para aceitar apenas valores positivos.
                if(loanTerm > 0){
                    break;
                }
                else{
                    System.out.println("> Erro - Valor inválido!");
                }

            }catch(NumberFormatException e){
                // Se a conversão falhou, logo o input não é um número.
                System.out.println("Erro - Digite apenas números!");
            }
        }
        return loanTerm;
    }
    // METODO para solicitar ao Usuario a Taxa de Juros Anual.
    public double askInterestRate(){
        double interestRate;

        while(true){
            System.out.print("> Informe a Taxa de Juros (%): >> ");
            String inputInterestRate = sc.nextLine();

            try {
                // Tentativa de converter o input String para um Double.
                interestRate = Double.parseDouble(inputInterestRate);

                // Se a conversão foi um sucesso, logo o input é um número, e ele validará para aceitar apenas valores positivos.
                if(interestRate > 0){
                    break;
                }
                else{
                    System.out.println("> Erro - Valor inválido!");
                }
            }catch(NumberFormatException e){
                // Se a conversão falhou, logo o input não é um número.
                System.out.println("Erro - Digite apenas números!");
            }
        }
        return interestRate;
    }
}