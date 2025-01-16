public enum DescontoInss{
    FAIXA_INSS_1(1212.00,7.5),
    FAIXA_INSS_2(2427.35,9),
    FAIXA_INSS_3(3641.03,12),
    FAIXA_INSS_4(7087.22,14),
    FAIXA_INSS_5(Double.MAX_VALUE,14);

    private final double valor;
    private final double desconto;

    DescontoInss(double valor, double desconto){
        this.valor = valor;
        this.desconto = desconto;
    }

    public double getValor() {
        return valor;
    }

    public double getDesconto() {
        return desconto;
    }
}
