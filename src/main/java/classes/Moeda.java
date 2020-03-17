package classes;

public enum Moeda {
    SETENTAECINCO(0.75),
    CINQUENTA(0.50),
    VINTEECINCO(0.25),
    DEZ(0.10),
    CINCO(0.5),
    UM(0.1);
    private double valor;
    private String nomeMoeda;

    Moeda(double valor) {
        this.valor = valor;
        this.nomeMoeda = this.valor == 0.1 ? this.valor + " centavo" : this.valor + " Centavos";
    }

    public double getValor() {
        return valor;
    }

    public String getNomeMoeda() {
        return nomeMoeda;
    }
}
