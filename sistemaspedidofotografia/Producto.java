public abstract class Producto {
    protected int numero;
    protected String nombre;
    protected double precio;
    protected String descripcion;

    public Producto(int numero, String nombre, double precio, String descripcion) {
        this.numero = numero;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public abstract double calcularPrecio();
    public abstract String obtenerDetalles();
    public abstract String mostrarDetalles();

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

     @Override
    public String toString() {
        return mostrarDetalles();
    }

}
