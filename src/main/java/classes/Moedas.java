package classes;

public enum Moedas {
    CINQUENTA (0.50),
    VINTEECINCO (0.25),
    DEZ (0.10),
    CINCO (0.05),
    UM (0.01);

    private double valor;
    private String nomeMoeda;
    Moedas(double valor){
        this.valor = valor;
        this.nomeMoeda = this.valor == 1? this.valor+" Centavo": this.valor+" Centavos";
    }


    public double getValor() {
        return valor;
    }

    public String getNomeMoeda() {
        return nomeMoeda;
    }
}
