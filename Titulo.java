public class Titulo {
    private int id_titulo;
    private int id_categoria;
    private String nombre_titulo;
    private int cantidad;

    public Titulo() {}

    public Titulo(int id_titulo, int id_categoria, String nombre_titulo, int cantidad) {
        this.id_titulo = id_titulo;
        this.id_categoria = id_categoria;
        this.nombre_titulo = nombre_titulo;
        this.cantidad = cantidad;
    }

    public int getId_titulo() {
        return id_titulo;
    }

    public void setId_titulo(int id_titulo) {
        this.id_titulo = id_titulo;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_titulo() {
        return nombre_titulo;
    }

    public void setNombre_titulo(String nombre_titulo) {
        this.nombre_titulo = nombre_titulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
