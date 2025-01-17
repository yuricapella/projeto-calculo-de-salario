# Cálculo de Salários

## Descrição

Este projeto tem como objetivo obter os salários brutos de 5 funcionários, levando em consideração os descontos de INSS e Imposto de Renda e calcular os salários liquidos. O programa foi desenvolvido como parte da disciplina **Lógica de Programação I** no programa **Desenvolva+** da Ada & Mercado Livre.

## Funcionalidades

- Entrada de 5 salários brutos.
- Cálculo dos descontos de **INSS** de acordo com as faixas salariais.
- Cálculo dos descontos de **Imposto de Renda** de acordo com as faixas salariais.
- Exibição dos resultados detalhados com salário bruto, descontos de INSS e IR, e salário líquido.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para o desenvolvimento do projeto.
- **Scanner**: Utilizado para capturar a entrada do usuário.
- **Enums**: Para definir as faixas salariais e descontos de INSS e Imposto de Renda.

## Como Rodar o Projeto

### Pré-requisitos

- JDK 8 ou superior instalado.
- Editor de código (ex: IntelliJ, Eclipse, VSCode).

### Passos

1. Clone o repositório:

    ```bash
    git clone https://github.com/yuricapella/projeto-calculo-de-salario.git
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd repositorio
    ```

3. Compile e execute o projeto:

    ```bash
    javac CalculoDeSalarios.java
    java CalculoDeSalarios
    ```

4. O programa solicitará que você digite 5 salários brutos separados por espaço. Após isso, os resultados serão exibidos no console.

## Estrutura do Projeto

- **CalculoDeSalarios.java**: Classe principal que contém a lógica para obter salários brutos, calcular descontos e calcular salários liquidos e exibir resultados.
- **TabelaDescontosInss.java**: Enum que define as faixas salariais e as porcentagens de desconto do INSS.
- **TabelaDescontosImpostoDeRenda.java**: Enum que define as faixas salariais e as porcentagens de desconto do Imposto de Renda.
  
