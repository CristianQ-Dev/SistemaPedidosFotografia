public class Camara extends Producto {
    private String marca;
    private String modelo;
    private int megapixeles;
    private String tipo;

    public Camara(int numero, String nombre, double precio, String descripcion,
                  String marca, String modelo, int megapixeles, String tipo) {
        super(numero, nombre, precio, descripcion);
        this.marca = marca;
        this.modelo = modelo;
        this.megapixeles = megapixeles;
        this.tipo = tipo;
    }

    public Foto tomarFoto(String fichero, String resolucion, String tamaño, String formato) {
        return new Foto(fichero, resolucion, tamaño, formato);
    }

    @Override
    public double calcularPrecio() {
        return precio;
    }

    @Override
    public String obtenerDetalles() {
        return "Cámara " + marca + " " + modelo + " (" + megapixeles + "MP)";
    }
     
     @Override
    public String mostrarDetalles() {
        return String.format(
            "Número: %d | Nombre: %s | Marca: %s | Modelo: %s | Tipo: %s | Megapíxeles: %d | Precio: $%.2f | Descripción: %s",
            numero, nombre, marca, modelo, tipo, megapixeles, precio, descripcion
        );
    }
}
