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