public class Foto {
    private String fichero;
    private String resolucion;
    private String tamaño;
    private String formato;

    public Foto(String fichero, String resolucion, String tamaño, String formato) {
        this.fichero = fichero;
        this.resolucion = resolucion;
        this.tamaño = tamaño;
        this.formato = formato;
    }

    public void print() {
        System.out.println("Imprimiendo foto: " + fichero);
    }

    public double calcularPrecio() {
        return 5.0;
    }

    @Override
    public String toString() {
        return fichero + " (" + resolucion + ", " + formato + ")";
    }
}
