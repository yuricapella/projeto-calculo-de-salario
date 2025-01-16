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
        
        for(int i = 0; i < salarioBruto.length; i++){
            if(salarioBruto[i] <= 1212){
                descontos[i] += (salarioBruto[i] * 0.075);
            }else if (salarioBruto[i] >= 1212.01 && salarioBruto[i] <= 2427.35) {
                descontos[i] += (salarioBruto[i] * 0.09);
            }else if (salarioBruto[i] >= 2427.36 && salarioBruto[i] <= 3641.03) {
                descontos[i] += (salarioBruto[i] * 0.12);
            }else{
                descontos[i] += (salarioBruto[i] * 0.14);
            }
        }
        return descontos;
    }

    public static double[] obterDescontoImpostoDeRenda(double[] salarioBruto){
        double[] descontos = new double[salarioBruto.length];

        for(int i = 0; i < salarioBruto.length; i++){
            if(salarioBruto[i] <= 1903.98){
                descontos[i] += 0;
            }else if (salarioBruto[i] >= 1903.99 && salarioBruto[i] <= 2826.65) {
                descontos[i] += (salarioBruto[i] * 0.075);
            }else if (salarioBruto[i] >= 2826.66 && salarioBruto[i] <= 3751.05) {
                descontos[i] += (salarioBruto[i] * 0.15);
            }else if (salarioBruto[i] >= 3751.06 && salarioBruto[i] <= 4664.68) {
                descontos[i] += (salarioBruto[i] * 0.2250);
            }else{
                descontos[i] += (salarioBruto[i] * 0.2750);
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
