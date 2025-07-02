import java.util.*;

public class MainUsuario {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de Usuarios:");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Cédula: ");
                    long cedula = sc.nextLong(); sc.nextLine();
                    System.out.print("Nombre completo: ");
                    String nombre = sc.nextLine();
                    System.out.print("Número celular: ");
                    long celular = sc.nextLong(); sc.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = sc.nextLine();
                    dao.crear(new Usuario(cedula, nombre, celular, direccion));
                    break;

                case 2:
                    List<Usuario> lista = dao.listar();
                    for (Usuario u : lista) {
                        System.out.println(
                            u.getCedula() + " | " + u.getNombre_completo() +
                            " | Celular: " + u.getNumero_celular() +
                            " | Dirección: " + u.getDireccion()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Cédula del usuario a actualizar: ");
                    long cedulaUpdate = sc.nextLong(); sc.nextLine();
                    System.out.print("Nuevo nombre completo: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nuevo número celular: ");
                    long nuevoCelular = sc.nextLong(); sc.nextLine();
                    System.out.print("Nueva dirección: ");
                    String nuevaDireccion = sc.nextLine();
                    dao.actualizar(new Usuario(cedulaUpdate, nuevoNombre, nuevoCelular, nuevaDireccion));
                    break;

                case 4:
                    System.out.print("Cédula del usuario a eliminar: ");
                    long cedulaDelete = sc.nextLong(); sc.nextLine();
                    dao.eliminar(cedulaDelete);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
