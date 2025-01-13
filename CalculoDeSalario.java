import java.util.Scanner;

public class CalculoDeSalario {
    //Pensei em fazer tratamento de erros porém como ainda não chegamos la e o projeto não pediu,
    // Deixei simples mesmo.
    public static void main(String[] args) {
        double[] salarios = recebeSalario();

        System.out.println(salarios[0] + " = " + salarios[1]);
    }

    public static double[] recebeSalario() {
        Scanner entrada = new Scanner(System.in);
        double[] salariosDouble = new double[5];

        System.out.println("Digite os 5 salários: (Exemplo: 2000.0 5395.95 2900.35 1500.7896 8975.12");
        String[] salariosString = entrada.nextLine().split(" ");

        for(int i = 0; i < salariosString.length; i++){
            salariosDouble[i] = Double.parseDouble(salariosString[i]);
        }
        entrada.close();

        return salariosDouble;
    }



}
