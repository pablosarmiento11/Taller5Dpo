package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.Producto;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

class PedidoTest {

    private Pedido pedido;
    private Producto producto1;
    private Producto producto2;
    private int IdPedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido("Juan Perez", "Calle 123");
        producto1 = new ProductoMenu("Hamburguesa Básica", 8000);
        producto2 = new ProductoMenu("Papas Fritas", 3000);
        IdPedido= 001;
    }

    @Test
    void testGetIdPedido() {
        Pedido nuevoPedido = new Pedido("Ana Gomez", "Avenida 456");
        assertEquals(IdPedido + 1, nuevoPedido.getIdPedido(),
                     "El ID del nuevo pedido debería ser uno más que el del pedido anterior.");
    }

    @Test
    void testGetNombreCliente() {
        assertEquals("Juan Perez", pedido.getNombreCliente(),
                     "El nombre del cliente debería ser 'Juan Perez'.");
    }

    @Test
    void testAgregarProducto() {
        
    }

    @Test
    void testGetPrecioTotalPedido() {
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        int precioNeto = producto1.getPrecio() + producto2.getPrecio();
        int precioIVA = (int) (precioNeto * 0.19);
        int precioTotalEsperado = precioNeto + precioIVA;

        assertEquals(precioTotalEsperado, pedido.getPrecioTotalPedido(),
                     "El precio total debería incluir el IVA sobre el precio neto de los productos.");
    }

    @Test
    void testGenerarTextoFactura() {
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        String factura = pedido.generarTextoFactura();

        assertTrue(factura.contains("Cliente: Juan Perez"),
                   "La factura debe incluir el nombre del cliente.");
        assertTrue(factura.contains("Dirección: Calle 123"),
                   "La factura debe incluir la dirección del cliente.");
        assertTrue(factura.contains("Hamburguesa Básica"),
                   "La factura debe incluir el nombre del primer producto.");
        assertTrue(factura.contains("Papas Fritas"),
                   "La factura debe incluir el nombre del segundo producto.");
        assertTrue(factura.contains("Precio Neto: " + (producto1.getPrecio() + producto2.getPrecio())),
                   "La factura debe mostrar el precio neto correcto.");
        assertTrue(factura.contains("IVA: " + (int) ((producto1.getPrecio() + producto2.getPrecio()) * 0.19)),
                   "La factura debe mostrar el IVA correcto.");
        assertTrue(factura.contains("Precio Total: " + pedido.getPrecioTotalPedido()),
                   "La factura debe mostrar el precio total correcto.");
    }

    @Test
    void testGuardarFactura() throws FileNotFoundException {
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        File archivoFactura = new File("factura_test.txt");
        pedido.guardarFactura(archivoFactura);

        try (Scanner scanner = new Scanner(archivoFactura)) {
            StringBuilder contenidoFactura = new StringBuilder();
            while (scanner.hasNextLine()) {
                contenidoFactura.append(scanner.nextLine()).append("\n");
            }

            String facturaGenerada = pedido.generarTextoFactura();
            assertEquals(facturaGenerada.trim(), contenidoFactura.toString().trim(),
                         "El contenido del archivo debe coincidir con la factura generada.");
        } finally {
            archivoFactura.delete();
        }
    }
}
