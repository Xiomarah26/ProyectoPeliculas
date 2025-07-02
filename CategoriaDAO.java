import java.sql.*;
import java.util.*;

public class CategoriaDAO {

    public void crear(Categoria categoria) {
        String sql = "INSERT INTO categorias (nombre_categoria) VALUES (?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNombre_categoria());
            stmt.executeUpdate();
            System.out.println("Categoría registrada");
        } catch (Exception e) {
            System.out.println("Error al registrar categoría: " + e.getMessage());
        }
    }

    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias";
        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId_categoria(rs.getInt("id_categoria"));
                c.setNombre_categoria(rs.getString("nombre_categoria"));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al listar categorías: " + e.getMessage());
        }
        return lista;
    }

    public void actualizar(Categoria categoria) {
        String sql = "UPDATE categorias SET nombre_categoria = ? WHERE id_categoria = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNombre_categoria());
            stmt.setInt(2, categoria.getId_categoria());
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Categoría actualizada");
            } else {
                System.out.println("No se encontró una categoría con ese ID");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar categoría: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM categorias WHERE id_categoria = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Categoría eliminada");
            } else {
                System.out.println("No se encontró una categoría con ese ID");
            }
        } catch (SQLException e) {
            if (e.getSQLState().equals("23503")) {
                System.out.println("No se puede eliminar: la categoría está relacionada con otras tablas.");
            } else {
                System.out.println("Error al eliminar categoría: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}

