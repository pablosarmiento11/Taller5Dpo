package uniandes.dpoo.hamburguesas.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

import java.util.ArrayList;

public class ComboTest {
    
    private Combo combo;
    private ArrayList<ProductoMenu> itemsCombo;

    @BeforeEach
    void setUp() {
        itemsCombo = new ArrayList<>();
        
        ProductoMenu producto1 = new ProductoMenu("Hamburguesa sencilla", 10000);
        ProductoMenu producto2 = new ProductoMenu("Papas fritas", 5000);
        
        itemsCombo.add(producto1);
        itemsCombo.add(producto2);
        
        combo = new Combo("Combo Especial", 0.90, itemsCombo);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Combo Especial", combo.getNombre(), "El nombre del combo debería ser Combo Especial");
    }

    @Test
    public void testGetPrecio() {
        
        int precioEsperado = (int) (15000 * 0.90); 
        assertEquals(precioEsperado, combo.getPrecio(), "El precio del combo debería ser 13500");
    }

    @Test
    public void testGenerarTextoFactura() {
        String facturaEsperada = "Combo Combo Especial\n Descuento: 0.9\n            " + combo.getPrecio() + "\n";
        assertEquals(facturaEsperada, combo.generarTextoFactura());
    }
}
