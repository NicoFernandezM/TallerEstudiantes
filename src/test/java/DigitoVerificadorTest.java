import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.DigitoVerificador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DigitoVerificadorTest {
    private String [] rutIngresados;
    private String [] casosDePrueba;
    private boolean [] resultadosEsperados;

    @BeforeEach
    public void init() {
        rutIngresados = new String[] {"103336015", "157079484"};
        casosDePrueba = new String[] {"10333601", "1570794"};
        resultadosEsperados = new boolean[] {true, false};// caso exitoso y caso fallido
    }

    @Test
    public void obtenerRutSinDigitoTest() {
        boolean coincidencias;

        for(int i = 0; i < rutIngresados.length; i++) {
            coincidencias = DigitoVerificador.obtenerRutSinDigito(rutIngresados[i]).equals(casosDePrueba[i]);
            assertEquals(coincidencias, resultadosEsperados[i]);
        }
    }

}
