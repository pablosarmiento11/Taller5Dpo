package uniandes.dpoo.hamburguesas.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.IngredienteRepetidoException;

class IngredienteRepetidoExceptionTest {

    @Test
    void testIngredienteRepetidoException() {
        String nombreIngrediente = "Queso";

        IngredienteRepetidoException exception = assertThrows(IngredienteRepetidoException.class, () -> {
            throw new IngredienteRepetidoException(nombreIngrediente);
        });

        String expectedMessage = "El ingrediente Queso está repetido";
        assertEquals(expectedMessage, exception.getMessage(),
                "El mensaje de la excepción no es el esperado");
    }
}
