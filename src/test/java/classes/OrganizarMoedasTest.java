package classes;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrganizarMoedasTest {
    @Test
    public void deve_retornar_a_quantidade_correta_de_moedas_de_cinquenta_centavos() {
        OrganizarMoedas organizarMoedas = new OrganizarMoedas(50);
        organizarMoedas.organizar();

        Integer valores = organizarMoedas.retornarQuantidadeDeMoedas();

assertEquals((Integer) 1, valores);
    }

}