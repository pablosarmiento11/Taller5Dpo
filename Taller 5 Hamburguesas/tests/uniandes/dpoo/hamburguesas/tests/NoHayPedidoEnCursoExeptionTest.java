package uniandes.dpoo.hamburguesas.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;

class NoHayPedidoEnCursoExceptionTest {

    @Test
    void testLanzamientoNoHayPedidoEnCursoException() {
        NoHayPedidoEnCursoException exception = assertThrows(NoHayPedidoEnCursoException.class, () -> {
            throw new NoHayPedidoEnCursoException();
        });

        String expectedMessage = "Actualmente no hay un pedido en curso";
        assertEquals(expectedMessage, exception.getMessage(),
                "El mensaje de la excepción no es el esperado");
    }
}
