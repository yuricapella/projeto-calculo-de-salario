public enum DescontoImpostoDeRenda {
    FAIXA_IR_1(1903.98,0),
    FAIXA_IR_2(2826.65,7.5),
    FAIXA_IR_3(3751.05,15),
    FAIXA_IR_4(4664.68,22.5),
    FAIXA_IR_5(Double.MAX_VALUE,27.5);

    private final double valor;
    private final double desconto;

    DescontoImpostoDeRenda(double valor, double desconto) {
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
