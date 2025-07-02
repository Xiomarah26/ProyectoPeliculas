public class Usuario {
    private long cedula;
    private String nombre_completo;
    private long numero_celular;
    private String direccion;

    public Usuario() {}

    public Usuario(long cedula, String nombre_completo, long numero_celular, String direccion) {
        this.cedula = cedula;
        this.nombre_completo = nombre_completo;
        this.numero_celular = numero_celular;
        this.direccion = direccion;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public long getNumero_celular() {
        return numero_celular;
    }

    public void setNumero_celular(long numero_celular) {
        this.numero_celular = numero_celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
