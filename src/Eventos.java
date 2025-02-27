public class Evento {
    private String nombre;
    private String tipo;
    private String fecha;
    private String ubicacion;
    private Organizador organizador;

    public Evento(String nombre,String tipo, String fecha, String ubicacion, Organizador organizador) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.organizador = organizador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    @Override
    public String toString() {
        return "Evento{" +
               "nombre='" + nombre + '\'' +
               ", fecha=" + fecha +
               ", ubicacion='" + ubicacion + '\'' +
               ", organizador=" + organizador.getNombre() +
               '}';
    }
}
