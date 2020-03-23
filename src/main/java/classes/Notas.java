package classes;

public enum Notas {
    CEM(100.00),

    CINQUENTA(50.00),

    VINTE(20.00),

    DEZ(10.00),

    CINCO(05.00),

    DOIS(02.00),

    UM(01.00);

    private double valor;
    private String nomeNota;

    Notas(double valor) {
        this.valor = valor;
        this.nomeNota = this.valor == 1.00 ? this.valor + " Real" : this.valor + " Reais";
    }

    public double getValor() {
        return valor;
    }

    public String getNomeNota() {
        return nomeNota;
    }
}
