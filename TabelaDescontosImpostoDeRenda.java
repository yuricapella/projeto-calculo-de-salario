public enum TabelaDescontosImpostoDeRenda {
    FAIXA_SALARIAL_1(1903.98,0),
    FAIXA_SALARIAL_2(2826.65,7.5),
    FAIXA_SALARIAL_3(3751.05,15),
    FAIXA_SALARIAL_4(4664.68,22.5),
    FAIXA_SALARIAL_5(Double.MAX_VALUE,27.5);

    private final double limite;
    private final double desconto;

    TabelaDescontosImpostoDeRenda(double limite, double desconto) {
        this.limite = limite;
        this.desconto = desconto;
    }

    public double getValorLimite() {
        return limite;
    }

    public double getDescontoPercentual() {
        return desconto;
    }

    public static double obterDescontoPercentual(double salarioBruto){
        for (TabelaDescontosImpostoDeRenda faixa : TabelaDescontosImpostoDeRenda.values()) {
            if (salarioBruto <= faixa.getValorLimite()) {
                return faixa.getDescontoPercentual();
            }
        }
        return 0;
    }
}
