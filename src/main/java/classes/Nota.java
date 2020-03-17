package classes;

public enum Nota {
    CEM (100.0),
    CINQUENTA (50.0),
    VINTE (20.0),
    DEZ (10.0),
    CINCO (5.0),
    DOIS (2.0),
    UM (1.0);
    private double valor;
    private String nomeNota;
    Nota(double valor) {
        this.valor = valor;
        this.nomeNota = this.valor == 1.0? this.valor+" Real": this.valor+" reais";
    }

    public double getValor() {
        return valor;
    }

    public String getNomeNota() {
        return nomeNota;
    }
}
