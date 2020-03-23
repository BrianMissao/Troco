package classes;

import java.util.HashMap;
import java.util.Map;

public class OrganizarMoedas implements OrganizarDinheiro {
    private double valorASerOrganizadoEmMoedas;
    private double valorJaOrganizadoEmMoedas;
    private Map<Moedas, Integer> quantidadeDeMoedasDeUmDeterminadoValor = new HashMap<Moedas, Integer>();

    public OrganizarMoedas(double valorASerOrganizadoEmMoedas) {
        this.valorASerOrganizadoEmMoedas = valorASerOrganizadoEmMoedas;
        this.valorJaOrganizadoEmMoedas = 0.00;
    }

    @Override
    public void organizar() {
        Moedas[] moedas = Moedas.values();
        int contador = 0;
        while (valorJaOrganizadoEmMoedas < valorASerOrganizadoEmMoedas && contador< moedas.length) {
            if (moedas[contador].getValor() <= valorASerOrganizadoEmMoedas) {
                adicionaMoedaAoPagamento(moedas[contador]);
            }
            contador++;
        }
    }

    private void adicionaMoedaAoPagamento(Moedas moeda) {
        Integer numeroDeMoedasAdicionadas = 0;
        while (moeda.getValor()+ valorJaOrganizadoEmMoedas <= valorASerOrganizadoEmMoedas) {
            valorJaOrganizadoEmMoedas += moeda.getValor();
            numeroDeMoedasAdicionadas++;
        }
        quantidadeDeMoedasDeUmDeterminadoValor.put(moeda, numeroDeMoedasAdicionadas);
    }

    public Integer retornaQuantidadeMoedas() {
        Integer valores = null;
        valores = quantidadeDeMoedasDeUmDeterminadoValor.get(Moedas.values()[1]);
        return valores;
    }

    @Override
    public String retornarInformacoesAoUsuario() {
        return null;
    }

    @Override
    public double getValorOrganizado() {
        return valorJaOrganizadoEmMoedas;
    }

    @Override
    public Map<Moedas, Integer> getQuantidade() {
        return quantidadeDeMoedasDeUmDeterminadoValor;
    }
}
