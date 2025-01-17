import java.util.Scanner;

public class CalculoDeSalario {
    public static void main(String[] args) {
        double[] salarioBruto = obterSalarios();
        double[] descontoInss = obterDescontoInss(salarioBruto);
        double[] descontoImpostoDeRenda = obterDescontoImpostoDeRenda(salarioBruto);
        double[] salarioLiquido = calcularSalarioLiquido(salarioBruto, descontoInss, descontoImpostoDeRenda);

        for (int i = 0; i < salarioBruto.length; i++) {
            System.out.printf("Salário bruto %d: %.2f\nDesconto Inss: %.2f\nDesconto Imposto de Renda: %.2f\nSalário liquido: %.2f\n---------------\n",i+1, salarioBruto[i],descontoInss[i],descontoImpostoDeRenda[i],salarioLiquido[i]);
        }
    }

    public static double[] obterSalarios() {
        Scanner entrada = new Scanner(System.in);
        double[] salarios = new double[5];

        System.out.println("Digite os 5 salários: (Exemplo: 1212 2103.23 3200.77 4350.93 7500)");
        String[] entradaSalarios = entrada.nextLine().split(" ");
        System.out.println("---------------");

        for(int i = 0; i < entradaSalarios.length; i++){
            salarios[i] = Double.parseDouble(entradaSalarios[i]);
        }
        entrada.close();
        return salarios;
    }

    public static double[] obterDescontoInss(double[] salarioBruto){
        double[] descontos = new double[salarioBruto.length];
        for (int i = 0; i < salarioBruto.length; i++) {
            for (DescontoInss faixa : DescontoInss.values()) {
                if (salarioBruto[i] <= faixa.getValor()) {
                    descontos[i] = salarioBruto[i] * (faixa.getDesconto() / 100);
                    break;
                }
            }
        }
        return descontos;
    }

    public static double[] obterDescontoImpostoDeRenda(double[] salarioBruto){
        double[] descontos = new double[salarioBruto.length];

        for(int i = 0; i < salarioBruto.length; i++){
           for(DescontoImpostoDeRenda faixa : DescontoImpostoDeRenda.values()){
                if (salarioBruto[i] <= faixa.getValor()) {
                    descontos[i] = salarioBruto[i] * (faixa.getDesconto() / 100);
                    break;
                }
           }
        }
        return descontos;
    }

    public static double[] calcularSalarioLiquido(double[] salarioBruto,double[] descontoInss,double[] descontoImpostoDeRenda) {
        double[] salarioLiquido = new double[salarioBruto.length];

        for(int i = 0; i < salarioBruto.length; i++){
            salarioLiquido[i] += (salarioBruto[i] - descontoInss[i] - descontoImpostoDeRenda[i]);
        }
        return salarioLiquido;
    }
}
