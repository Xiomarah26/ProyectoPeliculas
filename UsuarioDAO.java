import java.sql.*;
import java.util.*;

public class UsuarioDAO {

    public void crear(Usuario u) {
        String sql = "INSERT INTO usuarios (cedula, nombre_completo, numero_celular, direccion) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, u.getCedula());
            stmt.setString(2, u.getNombre_completo());
            stmt.setLong(3, u.getNumero_celular());
            stmt.setString(4, u.getDireccion());
            stmt.executeUpdate();
            System.out.println("Usuario registrado");
        } catch (Exception e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setCedula(rs.getLong("cedula"));
                u.setNombre_completo(rs.getString("nombre_completo"));
                u.setNumero_celular(rs.getLong("numero_celular"));
                u.setDireccion(rs.getString("direccion"));
                lista.add(u);
            }
        } catch (Exception e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }

    public void actualizar(Usuario u) {
        String sql = "UPDATE usuarios SET nombre_completo = ?, numero_celular = ?, direccion = ? WHERE cedula = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, u.getNombre_completo());
            stmt.setLong(2, u.getNumero_celular());
            stmt.setString(3, u.getDireccion());
            stmt.setLong(4, u.getCedula());
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario actualizado");
            } else {
                System.out.println("No se encontró un usuario con esa cédula");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    public void eliminar(long cedula) {
        String sql = "DELETE FROM usuarios WHERE cedula = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, cedula);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario eliminado");
            } else {
                System.out.println("No se encontró un usuario con esa cédula");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}
