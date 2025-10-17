import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int numeroPedido;
    private Cliente cliente;
    private List<Producto> productos;
    private Date fecha;
    private int numeroTarjetaCredito;
    private String estado;
    private double total;

    public Pedido(Cliente cliente) {
        this.numeroPedido = contador++;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.fecha = new Date(); // Fecha en tiempo real
        this.estado = "Pendiente";
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        calcularTotal();
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
        calcularTotal();
    }

    public void calcularTotal() {
        total = 0;
        for (Producto p : productos) {
            total += p.calcularPrecio();
        }
    }

    public void confirmarPedido(int numeroTarjetaCredito) {
        this.numeroTarjetaCredito = numeroTarjetaCredito;
        this.estado = "Confirmado";
        System.out.println(" Pedido confirmado. Cobro realizado con tarjeta terminada en " +
                (numeroTarjetaCredito % 10000));
    }

    public void cancelarPedido() {
        estado = "Cancelado";
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Pedido #" + numeroPedido + " | Estado: " + estado +
                " | Total: $" + total + " | Fecha: " + formato.format(fecha);
    }
}
