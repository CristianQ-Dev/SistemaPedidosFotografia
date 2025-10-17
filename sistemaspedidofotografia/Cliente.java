import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String cedula;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    private List<Pedido> pedidos;

    public Cliente(String cedula, String nombre, String telefono, String email, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.pedidos = new ArrayList<>();
    }

    public Pedido realizarPedido() {
        Pedido pedido = new Pedido(this);
        pedidos.add(pedido);
        return pedido;
    }

    public List<Pedido> consultarPedidos() {
        return pedidos;
    }

    public void actualizarDatos(String telefono, String email, String direccion) {
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        System.out.println("Datos del cliente actualizados correctamente.\n");
        mostrarDatos();
    }

    public void mostrarDatos() {
        System.out.println("=== DATOS DEL CLIENTE ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Cédula: " + cedula);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("Dirección: " + direccion);
        System.out.println("=========================");
    }

    @Override
    public String toString() {
        return nombre + " (" + cedula + ")";
    }
}
