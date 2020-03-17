package classes;

import sun.util.resources.cldr.yav.LocaleNames_yav;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class Pagamento {
    private double valorPago;

    private double valorASerPago;
    private double troco;
    private double valorQueJafoiPago;
    private Map<Moeda, Integer> quantidadeMoedas = new HashMap<Moeda, Integer>();
    private Map<Nota, Integer> quantidadeNotas;

    public Pagamento(double valorPago, double valorASerPago) {
        this.valorPago = valorPago;
        this.valorASerPago = valorASerPago;
    }

    public String pagarOCliente() {
        this.troco = calcularTroco();
        if (this.troco > 0.0) {
            organizarDinheiro();
        }
        Moeda[] quantidade = (Moeda[]) quantidadeMoedas.keySet().toArray();
        return "O cliente deve receber"+quantidadeMoedas.values().toString();
    }

    private double calcularTroco() {
        return this.valorPago - valorASerPago;
    }

    private void organizarDinheiro() {
        while (valorQueJafoiPago < troco) {
            if (valorASerPago < 1.0) {
                organizarMoedas();
            } else {
                organizarNotas();
            }
        }
    }

    private void organizarNotas() {
        Map<Nota, Integer> quantidadeNotas = new HashMap<Nota, Integer>();
        Nota[] nota = Nota.values();
    }

    private void organizarMoedas() {
        Moeda moeda[] = Moeda.values();
        int i;
        for (i = 0; i < moeda.length; i++) {
            if (valorASerPago + moeda[i].getValor() <= valorASerPago) {
                adiciona(moeda[i]);
            }
        }
    }

    private void adiciona(Moeda moeda) {
        Integer numeroDeMoedasDeUmDeterminadoValor;
        do {
            numeroDeMoedasDeUmDeterminadoValor = quantidadeMoedas.containsKey(moeda) ? quantidadeMoedas.get(moeda) + 1 : 1;
            quantidadeMoedas.put(moeda, numeroDeMoedasDeUmDeterminadoValor);
            valorASerPago -= moeda.getValor();
            valorQueJafoiPago += moeda.getValor();
        }
        while (valorQueJafoiPago < troco || valorQueJafoiPago + moeda.getValor() <= troco);
    }
}