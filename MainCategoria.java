import java.util.List;
import java.util.Scanner;

public class MainCategoria {
    public static void main(String[] args) {
        CategoriaDAO dao = new CategoriaDAO();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú Categorías:");
            System.out.println("1. Crear categoría");
            System.out.println("2. Listar categorías");
            System.out.println("3. Actualizar categoría");
            System.out.println("4. Eliminar categoría");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre de la categoría: ");
                    String nombre = sc.nextLine();
                    Categoria nueva = new Categoria();
                    nueva.setNombre_categoria(nombre);
                    dao.crear(nueva);
                    break;

                case 2:
                    List<Categoria> categorias = dao.listar();
                    for (Categoria c : categorias) {
                        System.out.println(c.getId_categoria() + ": " + c.getNombre_categoria());
                    }
                    break;

		case 3:
                    System.out.print("Ingrese ID de la categoría a actualizar: ");
                    int idAct = sc.nextInt();
                    sc.nextLine(); // limpiar buffer
                    System.out.print("Ingrese nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    Categoria catActualizar = new Categoria(idAct, nuevoNombre);
                    dao.actualizar(catActualizar);
                    break;

                case 4:
                    System.out.print("Ingrese ID de la categoría a eliminar: ");
                    int idDel = sc.nextInt();
                    dao.eliminar(idDel);
                    break;


                case 0:
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
