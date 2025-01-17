import java.util.Scanner;

public class CalculoDeSalarios {
    public static void main(String[] args) {
        double[] salariosBrutos = obterSalariosBrutos();
        double[] descontosInss = calcularDescontosInss(salariosBrutos);
        double[] descontosImpostoDeRenda = calcularDescontosImpostoDeRenda(salariosBrutos);
        double[] salariosLiquidos = calcularSalariosLiquidos(salariosBrutos, descontosInss, descontosImpostoDeRenda);

        exibirResultados(salariosBrutos,descontosInss,descontosImpostoDeRenda,salariosLiquidos);
    }

    public static double[] obterSalariosBrutos() {
        Scanner entrada = new Scanner(System.in);
        double[] salariosBrutos = new double[5];

        System.out.println("Digite os 5 salários separados por espaço (Exemplo: 1212 2103.23 3200.77 4350.93 7500):");
        String[] entradaSalarios = entrada.nextLine().split(" ");

        for(int i = 0; i < entradaSalarios.length; i++){
            salariosBrutos[i] = Double.parseDouble(entradaSalarios[i]);
        }
        entrada.close();
        return salariosBrutos;
    }

    public static double[] calcularDescontosInss(double[] salariosBrutos){
        double[] descontosInss = new double[salariosBrutos.length];

        for (int i = 0; i < salariosBrutos.length; i++) {
            descontosInss[i] = salariosBrutos[i] * (TabelaDescontosInss.obterDescontoPercentual(salariosBrutos[i]) / 100);
        }
        return descontosInss;
    }

    public static double[] calcularDescontosImpostoDeRenda(double[] salariosBrutos){
        double[] descontosImpostoDeRenda = new double[salariosBrutos.length];

        for(int i = 0; i < salariosBrutos.length; i++){
            descontosImpostoDeRenda[i] = salariosBrutos[i] * (TabelaDescontosImpostoDeRenda.obterDescontoPercentual(salariosBrutos[i]) / 100);
        }
        return descontosImpostoDeRenda;
    }

    public static double[] calcularSalariosLiquidos(double[] salariosBrutos,double[] descontosInss,double[] descontosImpostoDeRenda) {
        double[] salariosLiquidos = new double[salariosBrutos.length];

        for(int i = 0; i < salariosBrutos.length; i++){
            salariosLiquidos[i] = salariosBrutos[i] - descontosInss[i] - descontosImpostoDeRenda[i];
        }
        return salariosLiquidos;
    }

    public static void exibirResultados(double[] salariosBrutos, double[] descontosInss, double[] descontosImpostoDeRenda, double[] salariosLiquidos) {
        System.out.println("----------------------------------");
        for (int i = 0; i < salariosBrutos.length; i++) {
            System.out.printf(
                "Salário bruto %d: R$ %7.2f\n" +
                " - INSS (%4.1f%%): R$ %7.2f\n" +
                " - IR   (%4.1f%%): R$ %7.2f\n" +
                "Salário liquido: R$ %7.2f\n" +
                "----------------------------------\n",
                i+1, salariosBrutos[i],
                TabelaDescontosInss.obterDescontoPercentual(salariosBrutos[i]),descontosInss[i],
                TabelaDescontosImpostoDeRenda.obterDescontoPercentual(salariosBrutos[i]),descontosImpostoDeRenda[i],
                salariosLiquidos[i]);
        }
    }
}
