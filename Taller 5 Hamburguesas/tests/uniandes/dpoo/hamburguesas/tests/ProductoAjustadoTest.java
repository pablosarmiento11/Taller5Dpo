package uniandes.dpoo.hamburguesas.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;

class ProductoAjustadoTest {

    private ProductoAjustado productoAjustado;
    private ProductoMenu productoBase;
    private Ingrediente ingrediente1;
    private Ingrediente ingrediente2;

    @BeforeEach
    void setUp() {
        productoBase = new ProductoMenu("Hamburguesa Básica", 8000);
        productoAjustado = new ProductoAjustado(productoBase);
        ingrediente1 = new Ingrediente("Queso", 500);
        ingrediente2 = new Ingrediente("Tocineta", 1000);
    }

    @Test
    void testGetNombre() {
        assertEquals("Hamburguesa Básica", productoAjustado.getNombre(),
                     "El nombre del producto ajustado debería ser el mismo que el del producto base.");
    }

    @Test
    void testGetPrecios() {

        int precioEsperado = productoBase.getPrecio() + ingrediente1.getCostoAdicional() + ingrediente2.getCostoAdicional();
        assertEquals(precioEsperado, productoAjustado.getPrecio(),
                     "El precio debería ser el del producto base más el costo de los ingredientes adicionales.");
    }

    @Test
    void testGenerarTextoFactura() {

        String textoFactura = productoAjustado.generarTextoFactura();

        assertTrue(textoFactura.contains("Hamburguesa Básica"),
                   "La factura debe incluir el nombre del producto base.");
        assertTrue(textoFactura.contains("+Queso"),
                   "La factura debe indicar el ingrediente agregado con un signo '+' y su nombre.");
        assertTrue(textoFactura.contains("-Tocineta"),
                   "La factura debe indicar el ingrediente eliminado con un signo '-' y su nombre.");
        
        int precioEsperado = productoBase.getPrecio() + ingrediente1.getCostoAdicional();
        assertTrue(textoFactura.contains(String.valueOf(precioEsperado)),
                   "La factura debe reflejar el precio total correcto después de agregar y eliminar ingredientes.");
    }
}
