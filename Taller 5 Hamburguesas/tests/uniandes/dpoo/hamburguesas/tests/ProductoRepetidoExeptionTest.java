package uniandes.dpoo.hamburguesas.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.ProductoRepetidoException;

class ProductoRepetidoExceptionTest {

    @Test
    void testProductoRepetidoException() {
        String nombreProducto = "Hamburguesa Clásica";

        ProductoRepetidoException exception = assertThrows(ProductoRepetidoException.class, () -> {
            throw new ProductoRepetidoException(nombreProducto);
        });

        String expectedMessage = "El producto Hamburguesa Clásica está repetido";
        assertEquals(expectedMessage, exception.getMessage(),
                "El mensaje de la excepción no es el esperado");
    }
}
