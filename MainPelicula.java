import java.util.*;

public class MainPelicula {
    public static void main(String[] args) {
        PeliculaDAO dao = new PeliculaDAO();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n📽️ Menú de Películas:");
            System.out.println("1. Registrar película");
            System.out.println("2. Listar películas");
            System.out.println("3. Actualizar película");
            System.out.println("4. Eliminar película");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID del título: ");
                    int idTitulo = sc.nextInt(); sc.nextLine();
                    System.out.print("Fecha de adquisición (YYYY-MM-DD): ");
                    String fechaAdq = sc.nextLine();
                    System.out.print("Fecha del último alquiler (YYYY-MM-DD): ");
                    String fechaUlt = sc.nextLine();
                    System.out.print("¿Disponible? (true/false): ");
                    boolean disp = sc.nextBoolean(); sc.nextLine();
                    System.out.print("Estado (ej. A, D): ");
                    String estado = sc.nextLine();
                    dao.crear(new Pelicula(0, idTitulo, fechaAdq, fechaUlt, disp, estado));
                    break;

                case 2:
                    List<Pelicula> lista = dao.listar();
                    for (Pelicula p : lista) {
                        System.out.println(
                            p.getId_pelicula() + " | Título: " + p.getNombre_titulo() +
                            " | Fecha Adq.: " + p.getFecha_adquisicion() +
                            " | Último alquiler: " + p.getFecha_ultimo_alquiler() +
                            " | Disponible: " + p.isDisponible() +
                            " | Estado: " + p.getEstado()
                        );
                    }
                    break;

                case 3:
                    System.out.print("ID de la película a actualizar: ");
                    int idUp = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo ID del título: ");
                    int idTitNew = sc.nextInt(); sc.nextLine();
                    System.out.print("Nueva fecha de adquisición (YYYY-MM-DD): ");
                    String nuevaFechaAdq = sc.nextLine();
                    System.out.print("Nueva fecha último alquiler (YYYY-MM-DD): ");
                    String nuevaFechaUlt = sc.nextLine();
                    System.out.print("¿Disponible? (true/false): ");
                    boolean disponible = sc.nextBoolean(); sc.nextLine();
                    System.out.print("Nuevo estado (ej. A, D): ");
                    String nuevoEstado = sc.nextLine();
                    dao.actualizar(new Pelicula(idUp, idTitNew, nuevaFechaAdq, nuevaFechaUlt, disponible, nuevoEstado));
                    break;

                case 4:
                    System.out.print("ID de la película a eliminar: ");
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
