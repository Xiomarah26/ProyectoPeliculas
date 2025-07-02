public class Pelicula {
    private int id_pelicula;
    private int id_titulo;
    private String fecha_adquisicion;
    private String fecha_ultimo_alquiler;
    private boolean disponible;
    private String estado;
    private String nombre_titulo;

    public Pelicula() {}

    public Pelicula(int id_pelicula, int id_titulo, String fecha_adquisicion, String fecha_ultimo_alquiler, boolean disponible, String estado) {
        this.id_pelicula = id_pelicula;
        this.id_titulo = id_titulo;
        this.fecha_adquisicion = fecha_adquisicion;
        this.fecha_ultimo_alquiler = fecha_ultimo_alquiler;
        this.disponible = disponible;
        this.estado = estado;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public int getId_titulo() {
        return id_titulo;
    }

    public void setId_titulo(int id_titulo) {
        this.id_titulo = id_titulo;
    }

    public String getFecha_adquisicion() {
        return fecha_adquisicion;
    }

    public void setFecha_adquisicion(String fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }

    public String getFecha_ultimo_alquiler() {
        return fecha_ultimo_alquiler;
    }

    public void setFecha_ultimo_alquiler(String fecha_ultimo_alquiler) {
        this.fecha_ultimo_alquiler = fecha_ultimo_alquiler;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre_titulo() {
        return nombre_titulo;
    }

    public void setNombre_titulo(String nombre_titulo) {
        this.nombre_titulo = nombre_titulo;
    }
}
