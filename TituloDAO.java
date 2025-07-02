import java.sql.*;
import java.util.*;

public class TituloDAO {

    public void crear(Titulo titulo) {
        String sql = "INSERT INTO titulos (id_categoria, nombre_titulo, cantidad) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, titulo.getId_categoria());
            stmt.setString(2, titulo.getNombre_titulo());
            stmt.setInt(3, titulo.getCantidad());
            stmt.executeUpdate();
            System.out.println("Título registrado");
        } catch (Exception e) {
            System.out.println("Error al registrar título: " + e.getMessage());
        }
    }

    public List<Titulo> listar() {
        List<Titulo> lista = new ArrayList<>();
        String sql = "SELECT * FROM titulos";
        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Titulo t = new Titulo();
                t.setId_titulo(rs.getInt("id_titulo"));
                t.setId_categoria(rs.getInt("id_categoria"));
                t.setNombre_titulo(rs.getString("nombre_titulo"));
                t.setCantidad(rs.getInt("cantidad"));
                lista.add(t);
            }
        } catch (Exception e) {
            System.out.println("Error al listar títulos: " + e.getMessage());
        }
        return lista;
    }

    public void actualizar(Titulo titulo) {
        String sql = "UPDATE titulos SET id_categoria = ?, nombre_titulo = ?, cantidad = ? WHERE id_titulo = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, titulo.getId_categoria());
            stmt.setString(2, titulo.getNombre_titulo());
            stmt.setInt(3, titulo.getCantidad());
            stmt.setInt(4, titulo.getId_titulo());
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Título actualizado");
            } else {
                System.out.println("No se encontró un título con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar título: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM titulos WHERE id_titulo = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Título eliminado");
            } else {
                System.out.println("No se encontró un título con ese ID");
            }
        } catch (SQLException e) {
            if (e.getSQLState().equals("23503")) {
                System.out.println("No se puede eliminar: el título está relacionado con otras tablas.");
            } else {
                System.out.println("Error al eliminar título: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
