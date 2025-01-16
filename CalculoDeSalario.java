import java.util.Scanner;

public class CalculoDeSalario {
    //Pensei em fazer tratamento de erros porém como ainda não chegamos la e o projeto não pediu,
    // Deixei simples mesmo.
    public static void main(String[] args) {
        double[] salarios = recebeSalario();
        double[] porcentagemDescontoInss = descontoInss(salarios);
        
        System.out.printf("Salário 1: %.2f\nSalário 2: %.2f\nSalário 3: %.2f\nSalário 4: %.2f\nSalário 5: %.2f\n", salarios[0], salarios[1],salarios[2],salarios[3],salarios[4]);
        System.out.printf("Desconto 1: %.2f\nDesconto 2: %.2f\nDesconto 3: %.2f\nDesconto 4: %.2f\nDesconto 5: %.2f\n",porcentagemDescontoInss[0],porcentagemDescontoInss[1],porcentagemDescontoInss[2],porcentagemDescontoInss[3],porcentagemDescontoInss[4]);
    }

    public static double[] recebeSalario() {
        Scanner entrada = new Scanner(System.in);
        double[] salariosDouble = new double[5];

        System.out.println("Digite os 5 salários: (Exemplo: 800.53 1330.23 2500.77 3877.93 1212");
        String[] salariosString = entrada.nextLine().split(" ");

        for(int i = 0; i < salariosString.length; i++){
            salariosDouble[i] = Double.parseDouble(salariosString[i]);
        }
        entrada.close();

        return salariosDouble;
    }

    public static double[] descontoInss(double[] salarios){
        double[] descontos = new double[salarios.length];
        
        for(int i = 0; i < salarios.length; i++){
            if(salarios[i] <= 1212){
                descontos[i] += 0.075;
            }else if (salarios[i] > 1212.01 && salarios[i] <= 2427.35) {
                descontos[i] += 0.09;
            }else if (salarios[i] > 2427.36 && salarios[i] <= 3641.03) {
                descontos[i] += 0.12;
            }else{
                descontos[i] += 0.14;
            }
        }
        return descontos;
    }



}
