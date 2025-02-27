import java.util.ArrayList;
public class Usuario {
    private String nombre;
    private String email;
    private ArrayList<Evento> eventosInscritos; 


    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.eventosInscritos = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public ArrayList<Evento> getEventosInscritos() {
        return eventosInscritos;
    }
    
    public void apuntarAEvento(Evento evento) {
        boolean yaInscrito = false;

        for (int i = 0; i < eventosInscritos.size(); i++) {
            if (eventosInscritos.get(i).equals(evento)) {
                yaInscrito = true;
                break;
            }
        }

        if (!yaInscrito) {
            eventosInscritos.add(evento);
            System.out.println(nombre + " se ha apuntado al evento: " + evento.getNombre());
        } else {
            System.out.println(nombre + " ya está apuntado a este evento.");
        }
    }
    public void desapuntarDeEvento(int eveSelect2) {
    	eventosInscritos.remove(eveSelect2);

        }
    
    public void mostrarEventosInscritos() {
        if (eventosInscritos.isEmpty()) {
            System.out.println(nombre + " no está inscrito en ningún evento.");
        } else {
            System.out.println("Eventos en los que está inscrito " + nombre + ":");
            for (int i = 0; i < eventosInscritos.size(); i++) {
                System.out.println(i + ". " + eventosInscritos.get(i).getNombre());
            }
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "nombre='" + nombre + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}

