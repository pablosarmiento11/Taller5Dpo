package uniandes.dpoo.hamburguesas.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.HamburguesaException;

class HamburguesaExceptionTest {

    @Test
    void testLanzamientoHamburguesaException() {
        HamburguesaException exception = assertThrows(HamburguesaException.class, () -> {
            throw new HamburguesaException();
        }, "Se esperaba que se lanzara una HamburguesaException");
        
        assertEquals(null, exception.getMessage(), "El mensaje de la excepción debería ser null");
    }
}
