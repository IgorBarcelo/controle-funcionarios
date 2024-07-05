import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        //Insere todos os funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        //Remove o funcionário “João” da lista
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        //Imprimir todos os funcionários com todas suas informações
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        funcionarios.forEach(funcionario -> {
            String dataFormatada = funcionario.getDataNascimento().format(formatter);
            String salarioFormatado = String.format("%,.2f", funcionario.getSalario());
            System.out.println("Nome: " + funcionario.getNome() + ", Data de Nascimento: " + dataFormatada +
                    ", Salário: " + salarioFormatado + ", Função: " + funcionario.getFuncao());
        });

        //10% de aumento de salário
        funcionarios.forEach(funcionario -> {
            BigDecimal novoSalario = funcionario.getSalario().multiply(new BigDecimal("1.10"));
            funcionario.setSalario(novoSalario);
        });

        //Agrupar os funcionários por função em um MAP
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        //Imprimir os funcionários, agrupados por função
        funcionariosPorFuncao.forEach((funcao, listaFuncionarios) -> {
            System.out.println("\nFunção: " + funcao);
            listaFuncionarios.forEach(funcionario -> System.out.println("  " + funcionario.getNome()));
        });

        //Imprimir os funcionários que fazem aniversário no mês 10 e 12
        System.out.println("\nAniversariantes de Outubro e Dezembro:");
        funcionarios.stream()
                .filter(funcionario -> funcionario.getDataNascimento().getMonthValue() == 10 ||
                        funcionario.getDataNascimento().getMonthValue() == 12)
                .forEach(funcionario -> System.out.println(funcionario.getNome()));

        //Imprimir o funcionário com a maior idade
        Funcionario maisVelho = Collections.min(funcionarios, Comparator.comparing(Funcionario::getDataNascimento));
        int idade = LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear();
        System.out.println("\nFuncionário com maior idade: " + maisVelho.getNome() + ", Idade: " + idade);

        //Imprimir a lista de funcionários por ordem alfabética
        System.out.println("\nFuncionários em ordem alfabética:");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(funcionario -> System.out.println(funcionario.getNome()));

        //Imprimir o total dos salários dos funcionários
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos salários: " + String.format("%,.2f", totalSalarios));

        //Imprimir quantos salários mínimos ganha cada funcionário
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        funcionarios.forEach(funcionario -> {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println("\n" + funcionario.getNome() + " ganha " + salariosMinimos + " salários mínimos.");
        });
    }
}
