package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

class ProductoMenuTest {

    private ProductoMenu productoMenu;

    @BeforeEach
    void setUp() {
        productoMenu = new ProductoMenu("Hamburguesa Clásica", 12000);
    }

    @Test
    void testGetNombre() {
        assertEquals("Hamburguesa Clásica", productoMenu.getNombre());
    }

    @Test
    void testGetPrecio() {
        assertEquals(12000, productoMenu.getPrecio());
    }

    @Test
    void testGenerarTextoFactura() {
        String facturaEsperada = "Hamburguesa Clásica\n" +
                                  "            12000\n";
        
        assertEquals(facturaEsperada, productoMenu.generarTextoFactura());
    }
}
