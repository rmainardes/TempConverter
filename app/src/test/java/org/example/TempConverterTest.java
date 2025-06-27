package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TempConverterTest {

    @Test void teste1(){
        assertThrows(IllegalArgumentException.class, ()->{
            TempConverter converter = new TempConverter();
            converter.setTipoConversao("");
        });
    }

    @Test void teste2(){
        assertThrows(IllegalArgumentException.class, ()->{
            TempConverter converter = new TempConverter();
            converter.setTipoConversao("CELSIUS");
            converter.setConversao(-288.0);
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
