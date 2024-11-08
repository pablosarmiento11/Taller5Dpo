package uniandes.dpoo.hamburguesas.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;

class YaHayUnPedidoEnCursoExceptionTest {

    @Test
    void testYaHayUnPedidoEnCursoException() {
        String nombreCliente = "Carlos";
        String nombreNuevoCliente = "Juan";

        YaHayUnPedidoEnCursoException exception = assertThrows(YaHayUnPedidoEnCursoException.class, () -> {
            throw new YaHayUnPedidoEnCursoException(nombreCliente, nombreNuevoCliente);
        });

        String expectedMessage = "Ya existe un pedido en curso, para el cliente Carlos así que no se puede crear un pedido para Juan";
        assertEquals(expectedMessage, exception.getMessage(),
                "El mensaje de la excepción no es el esperado");
    }
}
