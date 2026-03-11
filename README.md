# Sistema de Simulação de Financiamento Imobiliário 🏦☕

Este projeto foi desenvolvido como requisito para a disciplina de **Programação Orientada a Objetos (POO)** do curso de Tecnologia em Análise e Desenvolvimento de Sistemas da PUCPR. 

O objetivo principal do sistema é simular financiamentos de imóveis para um banco, abstraindo conceitos da vida real para o código e aplicando os pilares da Programação Orientada a Objetos utilizando a linguagem **Java**. O desenvolvimento ocorreu de forma incremental, evoluindo desde a lógica estrutural básica até a persistência de dados em arquivos.

## 🚀 Funcionalidades

O sistema permite a simulação de financiamentos para três tipos de imóveis, cada um com suas regras específicas de cálculo e amortização:
* 🏠 **Casas:** Acréscimo no valor da parcela com validação de limite de juros.
* 🏢 **Apartamentos:** Cálculo de financiamento baseado no sistema de amortização PRICE.
* 🏕️ **Terrenos:** Acréscimo de 2% sobre o valor da parcela mensal.

As simulações utilizam as seguintes variáveis:
* Valor do imóvel.
* Prazo do financiamento (em anos/meses).
* Taxa de juros anual.

## 🧠 Conceitos e Tecnologias Aplicadas

O projeto foi construído inteiramente em **Java** e demonstra o domínio dos seguintes conceitos:

* **Orientação a Objetos:** Uso intenso de Classes, Objetos, Métodos e Atributos.
* **Encapsulamento e Modulares:** Organização do projeto em pacotes lógicos (`main`, `model`, `util`) e uso adequado de modificadores de acesso (`private`, `protected`, `public`).
* **Herança e Classes Abstratas:** Criação de uma super-classe abstrata `Financing` que dita as regras gerais, herdadas pelas sub-classes `Home`, `Apartment` e `Lot`.
* **Polimorfismo:** Sobrescrita de métodos (como `calculateMonthlyPayment()` e `toString()`) para aplicar regras de negócios específicas dependendo do tipo de imóvel instanciado.
* **Tratamento de Exceções:** Implementação de blocos `try/catch` para capturar erros de input do usuário (`NumberFormatException`) e criação de exceções customizadas (ex: `IncreaseExceedsInterestException`) para regras de negócio.
* **Coleções:** Utilização de `ArrayList` para manipulação e armazenamento em memória de múltiplos objetos de financiamento.
* **Persistência de Dados (I/O):**
  * Leitura e escrita de dados em arquivos de texto plano (`.txt`).
  * Serialização e desserialização de objetos em arquivos binários (`.dat`).

## 💻 Como Executar o Projeto

1. Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) instalado na sua máquina.
2. Clone este repositório:
   ```bash
   git clone [https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git](https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git)

## 👨‍💻 Autor

**Michel Urban Rosendo de Lima**
Estudante de Análise e Desenvolvimento de Sistemas (1º Período/2025)
