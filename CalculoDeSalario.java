import java.util.Scanner;

public class CalculoDeSalario {
    // A versão atual está simplificada sem validação de entrada, conforme enunciado do projeto.
    public static void main(String[] args) {
        double[] salarios = obterSalarios();
        double[] descontoInss = obterDescontoInss(salarios);
        double[] descontoImpostoDeRenda = obterDescontoImpostoDeRenda(salarios);

        for (int i = 0; i < salarios.length; i++) {
            System.out.printf("Salário %d: %.2f\nDesconto Inss de %.2f%%\nDesconto Imposto de Renda de %.2f%%\n---------------\n",i+1, salarios[i],descontoInss[i],descontoImpostoDeRenda[i]);
        }
    }

    public static double[] obterSalarios() {
        Scanner entrada = new Scanner(System.in);
        double[] salarios = new double[5];

        System.out.println("Digite os 5 salários: (Exemplo: 1212 2103.23 3200.77 4350.93 7500)");
        String[] entradaSalarios = entrada.nextLine().split(" ");
        entrada.close();

        for(int i = 0; i < entradaSalarios.length; i++){
            salarios[i] = Double.parseDouble(entradaSalarios[i]);
        }
        return salarios;
    }

    public static double[] obterDescontoInss(double[] salarios){
        double[] descontos = new double[salarios.length];
        
        for(int i = 0; i < salarios.length; i++){
            if(salarios[i] <= 1212){
                descontos[i] += 7.5;
            }else if (salarios[i] >= 1212.01 && salarios[i] <= 2427.35) {
                descontos[i] += 9;
            }else if (salarios[i] >= 2427.36 && salarios[i] <= 3641.03) {
                descontos[i] += 12;
            }else{
                descontos[i] += 14;
            }
        }
        return descontos;
    }

    public static double[] obterDescontoImpostoDeRenda(double[] salarios){
        double[] descontos = new double[salarios.length];

        for(int i = 0; i < salarios.length; i++){
            if(salarios[i] <= 1903.98){
                descontos[i] += 0;
            }else if (salarios[i] >= 1903.99 && salarios[i] <= 2826.65) {
                descontos[i] += 7.5;
            }else if (salarios[i] >= 2826.66 && salarios[i] <= 3751.05) {
                descontos[i] += 15;
            }else if (salarios[i] >= 3751.06 && salarios[i] <= 4664.68) {
                descontos[i] += 22.50;
            }else{
                descontos[i] += 27.50;
            }
        }
        return descontos;
    }
}
