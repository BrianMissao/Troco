package classes;

import java.util.HashMap;
import java.util.Map;

public class OrganizarNotas implements OrganizarDinheiro {
    private double valorASerOrganizadoEmNotas;
    private double valorJaOrganizadoEmNotas;
    private Map<Notas, Integer> quantidadeDeNotasDeUmDeterminadoValor = new HashMap<Notas, Integer>();

    public OrganizarNotas(double valorASerOrganizadoEmNotas) {
        this.valorASerOrganizadoEmNotas = valorASerOrganizadoEmNotas;
        this.valorJaOrganizadoEmNotas = 0.00;
    }

    @Override
    public void organizar() {
        Notas[] notas = Notas.values();
        int contador = 0;
        while (valorJaOrganizadoEmNotas < valorASerOrganizadoEmNotas && contador < notas.length && valorASerOrganizadoEmNotas - valorJaOrganizadoEmNotas >= 1.00) {
            if (notas[contador].getValor() <= valorASerOrganizadoEmNotas) {
                adicionarNotaAoPagamento(notas[contador]);
            }
            contador++;
        }
    }

    private void adicionarNotaAoPagamento(Notas nota) {
        Integer numeroDeNotasAdicionadas = 0;
        while (nota.getValor() + valorJaOrganizadoEmNotas <= valorASerOrganizadoEmNotas) {
            valorJaOrganizadoEmNotas += nota.getValor();
            numeroDeNotasAdicionadas++;
        }
        quantidadeDeNotasDeUmDeterminadoValor.put(nota, numeroDeNotasAdicionadas);
    }

    @Override
    public double getValorOrganizado() {
        return valorJaOrganizadoEmNotas;
    }
    public Integer retornarQuantidadeDeNotas(Notas nota) {
        Integer valores = null;
        valores = quantidadeDeNotasDeUmDeterminadoValor.get(nota);
        return valores;
    }

    @Override
    public Map<Notas, Integer> getQuantidade() {
        return quantidadeDeNotasDeUmDeterminadoValor;
    }
}
