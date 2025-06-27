package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TempConverterTest {

    @Test void teste1(){
        TempConverter converter = new TempConverter();
        assertThrows(IllegalArgumentException.class, ()->{

            converter.setTipoConversao("");
        });
    }

    @Test
    void teste2() {
        TempConverter converter = new TempConverter();
        converter.setTipoConversao("CELSIUS");

        assertThrows(IllegalArgumentException.class, () -> {
            converter.setConversao(-500.0);
        });
    }

    @Test void teste3(){
        double esperado = 89.6;
        TempConverter converter = new TempConverter();
        converter.setTipoConversao("FAHRENHEIT");
        converter.setConversao(32.00);
        assertEquals(esperado, converter.getConversao(), 1);
    }

    @Test void teste4(){
        double esperado = 46.11;
        TempConverter converter = new TempConverter();
        converter.setTipoConversao("CELSIUS");
        converter.setConversao(115.00);
        assertEquals(esperado, converter.getConversao(), 1);
    }
}
