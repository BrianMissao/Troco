package classes;

import java.util.Map;

public class Pagamento {
    private double valorPago;

    private double valorASerPago;
    private double troco;
    private OrganizarDinheiro organizarNotas;
    private OrganizarDinheiro organizarMoedas;

    public Pagamento(double valorPago, double valorASerPago) {
        this.valorPago = valorPago;
        this.valorASerPago = valorASerPago;
        this.troco = calcularTroco();
        this.organizarMoedas = null;
        this.organizarNotas = null;
    }

    private double calcularTroco() {
        return this.valorPago - valorASerPago;
    }

    public void calcularEOrganizarPagamento() {
        if (troco >=1.00){
            organizarNotas = new OrganizarNotas(troco);
            organizarNotas.organizar();
        }
        if (troco < 1.0 || organizarNotas.getValorOrganizado() < troco) {
            double diferenca = this.organizarNotas != null? this.troco-organizarNotas.getValorOrganizado(): troco;
            organizarMoedas = new OrganizarMoedas(diferenca);
            organizarMoedas.organizar();
        }
    }

    public String apresentarInformacoesDePagamento() {
        String resumo = "Você deve dar "+this.troco+" ao cliente, na seguinte organização:\n";
        if (organizarNotas != null) {
            resumo = resumo+montarResumoDeNotas();
        }
        if (organizarMoedas != null) {
            resumo = resumo+montarResumoDeMoedas();
        }
        return resumo;
    }

    private String montarResumoDeMoedas() {
        String resumo = "";
        Map<Moedas, Integer> quantidadeDeMoedasOrganizadas = organizarMoedas.getQuantidade();
        for (Moedas moedas:quantidadeDeMoedasOrganizadas.keySet()) {
            resumo = resumo+quantidadeDeMoedasOrganizadas.get(moedas)+" moedas de "+moedas.getNomeMoeda()+"\n"  ;
        }
        return resumo;
    }

    private String montarResumoDeNotas() {
        Map<Notas, Integer> quantidadeDeNotasOrganizadas = organizarNotas.getQuantidade();
        String resumo = "";
        for (Notas notas:quantidadeDeNotasOrganizadas.keySet()) {
            resumo = resumo+quantidadeDeNotasOrganizadas.get(notas)+" notas de "+notas.getNomeNota()+"\n";
        }
        return resumo;
    }

}