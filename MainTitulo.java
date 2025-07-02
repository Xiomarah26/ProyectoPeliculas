import java.util.*;

public class MainTitulo {
    public static void main(String[] args) {
        TituloDAO dao = new TituloDAO();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n📋 Menú de Títulos:");
            System.out.println("1. Registrar título");
            System.out.println("2. Listar títulos");
            System.out.println("3. Actualizar título");
            System.out.println("4. Eliminar título");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("ID de categoría: ");
                    int idCat = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre del título: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt(); sc.nextLine();
                    dao.crear(new Titulo(0, idCat, nombre, cantidad));
                    break;

                case 2:
                    List<Titulo> lista = dao.listar();
                    for (Titulo t : lista) {
                        System.out.println(
                            t.getId_titulo() + " | " +
                            "Categoría: " + t.getId_categoria() + " | " +
                            "Título: " + t.getNombre_titulo() + " | " +
                            "Cantidad: " + t.getCantidad()
                        );
                    }
                    break;

                case 3:
                    System.out.print("ID del título a actualizar: ");
                    int idUp = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo ID de categoría: ");
                    int nuevaCat = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo nombre del título: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = sc.nextInt(); sc.nextLine();
                    dao.actualizar(new Titulo(idUp, nuevaCat, nuevoNombre, nuevaCantidad));
                    break;

                case 4:
                    System.out.print("ID del título a eliminar: ");
                    int idDel = sc.nextInt(); sc.nextLine();
                    dao.eliminar(idDel);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("❌ Opción inválida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
