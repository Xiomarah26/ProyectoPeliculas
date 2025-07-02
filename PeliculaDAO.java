import java.sql.*;
import java.util.*;

public class PeliculaDAO {

    public void crear(Pelicula p) {
        String sql = "INSERT INTO peliculas (id_titulo, fecha_adquisicion, fecha_ultimo_alquiler, disponible, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, p.getId_titulo());
            stmt.setDate(2, java.sql.Date.valueOf(p.getFecha_adquisicion()));
            stmt.setDate(3, java.sql.Date.valueOf(p.getFecha_ultimo_alquiler()));
            stmt.setBoolean(4, p.isDisponible());
            stmt.setString(5, p.getEstado());
            stmt.executeUpdate();
            System.out.println("Pelicula registrada");
        } catch (Exception e) {
            System.out.println("Error al registrar pelicula: " + e.getMessage());
        }
    }

    public List<Pelicula> listar() {
        List<Pelicula> lista = new ArrayList<>();
        String sql = "SELECT * FROM peliculas";
        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pelicula p = new Pelicula();
                p.setId_pelicula(rs.getInt("id_pelicula"));
                p.setId_titulo(rs.getInt("id_titulo"));
                p.setFecha_adquisicion(rs.getString("fecha_adquisicion"));
                p.setFecha_ultimo_alquiler(rs.getString("fecha_ultimo_alquiler"));
                p.setDisponible(rs.getBoolean("disponible"));
                p.setEstado(rs.getString("estado"));
                p.setNombre_titulo(obtenerNombreTitulo(conn, p.getId_titulo()));
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error al listar peliculas: " + e.getMessage());
        }
        return lista;
    }

    private String obtenerNombreTitulo(Connection conn, int idTitulo) {
        String nombre = "Desconocido";
        String sql = "SELECT nombre_titulo FROM titulos WHERE id_titulo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTitulo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("nombre_titulo");
            }
        } catch (Exception e) {
            System.out.println("Error al obtener nombre del título: " + e.getMessage());
        }
        return nombre;
    }

    public void actualizar(Pelicula p) {
        String sql = "UPDATE peliculas SET id_titulo = ?, fecha_adquisicion = ?, fecha_ultimo_alquiler = ?, disponible = ?, estado = ? WHERE id_pelicula = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, p.getId_titulo());
            stmt.setDate(2, java.sql.Date.valueOf(p.getFecha_adquisicion()));
            stmt.setDate(3, java.sql.Date.valueOf(p.getFecha_ultimo_alquiler()));
            stmt.setBoolean(4, p.isDisponible());
            stmt.setString(5, p.getEstado());
            stmt.setInt(6, p.getId_pelicula());
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Pelicula actualizada");
            } else {
                System.out.println("No se encontró una pelicula con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar pelicula: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM peliculas WHERE id_pelicula = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Pelicula eliminada");
            } else {
                System.out.println("No se encontró una pelicula con ese ID");
            }
        } catch (SQLException e) {
            if (e.getSQLState().equals("23503")) {
                System.out.println("No se puede eliminar: la pelicula está relacionada con otras tablas.");
            } else {
                System.out.println("Error al eliminar pelicula: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
