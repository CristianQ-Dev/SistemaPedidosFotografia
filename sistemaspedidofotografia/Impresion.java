import java.util.List;

public class Impresion extends Producto {
    private String color;
    private String tipo;
    private int numCopias;
    private Foto foto;
    private int cantidad;

   public Impresion(int numero, String nombre, double precio, String descripcion,
                     String color, String tipoPapel, int cantidad, List<Foto> fotos) {
        super(numero, nombre, precio, descripcion);
        this.color = color;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }
    public void imprimir() {
        if (foto != null) {
            foto.print();
            System.out.println("Se imprimieron " + numCopias + " copias en " + color);
        }
    }

    @Override
    public double calcularPrecio() {
        return precio * numCopias;
    }

    @Override
    public String obtenerDetalles() {
        return "Impresión tipo " + tipo + " en color " + color;
    }

     @Override
    public String mostrarDetalles() {
        return String.format(
            "Número: %d | Nombre: %s | Tipo de papel: %s | Color: %s | Cantidad: %d | Precio por unidad: $%.2f | Descripción: %s",
            numero, nombre, tipo, color, cantidad, precio, descripcion
        );
    }
}
