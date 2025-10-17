import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear lista de productos disponibles
        List<Producto> catalogo = new ArrayList<>();
        catalogo.add(new Camara(1, "Cámara Canon EOS 90D", 1200.0, "Cámara réflex profesional", "Canon", "EOS 90D", 32, "DSLR"));
        catalogo.add(new Camara(2, "Cámara Sony Alpha A7", 1500.0, "Cámara sin espejo full-frame", "Sony", "A7", 24, "Mirrorless"));
        catalogo.add(new Impresion(3, "Impresión Brillante", 2.5, "Foto en papel brillante", "Color", "Brillante", 1, null));
        catalogo.add(new Impresion(4, "Impresión Mate", 2.0, "Foto en papel mate", "Blanco y negro", "Mate", 1, null));


        System.out.println("=== Bienvenido al sistema de pedidos ===");

        // Crear cliente
        System.out.print("Ingrese su cédula: ");
        String cedula = sc.nextLine();
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese su teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Ingrese su email: ");
        String email = sc.nextLine();
        System.out.print("Ingrese su dirección: ");
        String direccion = sc.nextLine();

        Cliente cliente = new Cliente(cedula, nombre, telefono, email, direccion);

        String opcionMenu;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Realizar un nuevo pedido");
            System.out.println("2. Consultar mis pedidos");
            System.out.println("3. Ver mis datos");
            System.out.println("4. Actualizar mis datos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcionMenu = sc.nextLine();

            switch (opcionMenu) {
                case "1":
                    Pedido pedido = cliente.realizarPedido();
                    System.out.println("\n=== Catálogo de productos ===");
                    for (Producto p : catalogo) {
                        System.out.println(p.mostrarDetalles());
                    }

                    String continuar;
                    do {
                        System.out.print("\nIngrese el número del producto que desea agregar: ");
                        int opcion = sc.nextInt();
                        sc.nextLine();

                        for (Producto p : catalogo) {
                            if (p.numero == opcion) {
                                pedido.agregarProducto(p);
                                System.out.println("Producto agregado: " + p.getNombre());
                            }
                        }

                        System.out.print("¿Desea agregar otro producto? (s/n): ");
                        continuar = sc.nextLine();
                    } while (continuar.equalsIgnoreCase("s"));

                    System.out.println("\nTotal del pedido: $" + pedido.getTotal());
                    System.out.print("Ingrese su número de tarjeta para realizar el pago: ");
                    int tarjeta = sc.nextInt();
                    sc.nextLine();
                    pedido.confirmarPedido(tarjeta);
                    break;

                case "2":
                    System.out.println("\n=== Pedidos del cliente ===");
                    if (cliente.consultarPedidos().isEmpty()) {
                        System.out.println("Aún no tiene pedidos registrados.");
                    } else {
                        for (Pedido p : cliente.consultarPedidos()) {
                            System.out.println(p);
                        }
                    }
                    break;

                case "3":
                    cliente.mostrarDatos();
                    break;

                case "4":
                    System.out.println("\n=== Actualizar datos del cliente ===");
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTel = sc.nextLine();
                    System.out.print("Nuevo email: ");
                    String nuevoEmail = sc.nextLine();
                    System.out.print("Nueva dirección: ");
                    String nuevaDir = sc.nextLine();
                    cliente.actualizarDatos(nuevoTel, nuevoEmail, nuevaDir);
                    break;

                case "5":
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println(" Opción no válida, intente nuevamente.");
            }

        } while (!opcionMenu.equals("5"));

        sc.close();
    }
}
