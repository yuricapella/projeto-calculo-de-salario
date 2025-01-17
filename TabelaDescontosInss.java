public enum TabelaDescontosInss {
    FAIXA_SALARIAL_1(1212.00,7.5),
    FAIXA_SALARIAL_2(2427.35,9),
    FAIXA_SALARIAL_3(3641.03,12),
    FAIXA_SALARIAL_4(7087.22,14),
    FAIXA_SALARIAL_5(Double.MAX_VALUE,14);

    private final double limite;
    private final double desconto;

    TabelaDescontosInss(double limite, double desconto){
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
        for (TabelaDescontosInss faixa : TabelaDescontosInss.values()) {
            if (salarioBruto <= faixa.getValorLimite()) {
                return faixa.getDescontoPercentual();
            }
        }
        return 0;
    }
}
