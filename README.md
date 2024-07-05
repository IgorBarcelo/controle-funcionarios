# Projeto de Gerenciamento de Funcionários

## Descrição

Este projeto é um exercício prático de programação em Java que implementa um sistema de gerenciamento de funcionários para uma indústria. Ele permite a manipulação de uma lista de funcionários, incluindo operações como inserção, remoção, atualização de salário, agrupamento por função e várias outras funcionalidades de consulta e formatação.

## Requisitos

- Java 8 ou superior

## Estrutura do Projeto

O projeto é composto pelas seguintes classes:

1. **Pessoa**
   - Atributos: `nome` (String), `dataNascimento` (LocalDate)
   - Métodos: Getters e Setters

2. **Funcionario**
   - Herda da classe `Pessoa`
   - Atributos: `salario` (BigDecimal), `funcao` (String)
   - Métodos: Getters e Setters

3. **Principal**
   - Classe principal para execução do programa
   - Funcionalidades:
     - Inserir funcionários
     - Remover um funcionário específico
     - Imprimir todos os funcionários com formatação específica
     - Atualizar salários dos funcionários
     - Agrupar funcionários por função
     - Imprimir aniversariantes de meses específicos
     - Identificar o funcionário mais velho
     - Ordenar e imprimir funcionários por ordem alfabética
     - Calcular e imprimir o total dos salários
     - Calcular e imprimir quantos salários mínimos cada funcionário recebe

## Execução

### Inserir Funcionários

Os funcionários são inseridos na mesma ordem e com as mesmas informações especificadas na tabela do exercício.

### Remover Funcionário

Remove o funcionário chamado "João" da lista.

### Imprimir Funcionários

Imprime todos os funcionários com as seguintes formatações:
- Data de nascimento no formato `dd/MM/yyyy`
- Salário no formato brasileiro com separador de milhar como ponto e decimal como vírgula

### Aumentar Salários

Aumenta o salário de todos os funcionários em 10%.

### Agrupar por Função

Agrupa os funcionários por função em um mapa, onde a chave é a função e o valor é a lista de funcionários.

### Aniversariantes

Imprime os funcionários que fazem aniversário nos meses 10 (Outubro) e 12 (Dezembro).

### Funcionário Mais Velho

Identifica e imprime o funcionário com a maior idade.

### Ordenar e Imprimir por Ordem Alfabética

Imprime a lista de funcionários ordenada por nome.

### Total dos Salários

Calcula e imprime o total dos salários de todos os funcionários.

### Salários Mínimos

Calcula e imprime quantos salários mínimos cada funcionário recebe, considerando o salário mínimo de R$1212.00.   