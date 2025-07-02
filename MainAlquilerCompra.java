import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class MainAlquilerCompra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🎬 Películas disponibles para alquilar o comprar:");
        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement()) {
            String sql = "SELECT p.id_pelicula, t.nombre_titulo FROM peliculas p JOIN titulos t ON p.id_titulo = t.id_titulo WHERE p.disponible = true";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_pelicula") + " | Título: " + rs.getString("nombre_titulo"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar películas disponibles: " + e.getMessage());
            return;
        }

        System.out.print("Ingrese el ID de la película a procesar: ");
        int idPelicula = sc.nextInt();
        sc.nextLine();

        System.out.print("¿Desea alquilar (A) o comprar (V) esta película? Ingrese A o V: ");
        String opcion = sc.nextLine().trim().toUpperCase();

        if (!opcion.equals("A") && !opcion.equals("V")) {
            System.out.println("❌ Opción inválida. Solo se permite 'A' o 'V'.");
            return;
        }

        try (Connection conn = Conexion.conectar()) {
            String sql = "UPDATE peliculas SET disponible = false, estado = ?, fecha_ultimo_alquiler = ? WHERE id_pelicula = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, opcion);
            stmt.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
            stmt.setInt(3, idPelicula);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                if (opcion.equals("A")) {
                    System.out.println("✅ La película fue alquilada exitosamente.");
                } else {
                    System.out.println("✅ La película fue vendida exitosamente.");
                }
            } else {
                System.out.println("❌ No se encontró la película con ese ID o ya no está disponible.");
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar película: " + e.getMessage());
        }

        sc.close();
    }
}
