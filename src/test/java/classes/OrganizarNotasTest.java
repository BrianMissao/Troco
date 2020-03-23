package classes;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrganizarNotasTest {
    @Test
    public void deve_retornar_o_numero_correto_de_notas_de_um_real() {
        OrganizarNotas organizarNotas = new OrganizarNotas(1000.00);
        Notas[] notas = Notas.values();

        organizarNotas.organizar();
        Integer valores = organizarNotas.retornarQuantidadeDeNotas(Notas.values()[0]);

        assertEquals((Integer) 10, valores);
    }

}