package uniandes.dpoo.hamburguesas.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.ProductoFaltanteException;

class ProductoFaltanteExceptionTest {

    @Test
    void testProductoFaltanteException() {
        String nombreProducto = "Hamburguesa Vegana";

        ProductoFaltanteException exception = assertThrows(ProductoFaltanteException.class, () -> {
            throw new ProductoFaltanteException(nombreProducto);
        });

        String expectedMessage = "El producto Hamburguesa Vegana no aparece en la información del restaurante";
        assertEquals(expectedMessage, exception.getMessage(),
                "El mensaje de la excepción no es el esperado");
    }
}
