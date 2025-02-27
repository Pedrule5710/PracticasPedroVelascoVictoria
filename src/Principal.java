import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	static Scanner sc = new Scanner(System.in);
	static Scanner sc2 = new Scanner(System.in);

	public static void main(String [] args) {

		ArrayList<Organizador> Organizadores = new ArrayList<>();
		ArrayList<Evento> eventos = new ArrayList<>();
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Organizador admin = new Organizador("Admin", "1234", "1234", "1234");
		Organizadores.add(admin);

		
		 int opcion;
		    
		    do {
		        System.out.println("\nBienvenido");
		        System.out.println("Seleccione a qué perfil desea acceder:");
		        System.out.println("1. Usuario");
		        System.out.println("2. Organizador");
		        System.out.println("3. Salir");
		        System.out.print("Elige una opción: ");
		        
		        opcion = sc.nextInt();
		        sc.nextLine(); 
		        
		        switch (opcion) {
		            case 1:
		        		MenuUsuario(eventos, usuarios);
		                break;
		            case 2:
		        		MenuOrganizadores(Organizadores, eventos);
		                break;
		            case 3:
		                System.out.println("Saliendo del sistema...");
		                break;
		            default:
		                System.out.println("Opción no válida, intente de nuevo.");
		        }
		    } while (opcion != 3);
}



	private static void MenuOrganizadores(ArrayList<Organizador> Organizadores, ArrayList<Evento> eventos) {
		System.out.println("Bienvenido a la pagina de organizadores(entra con admin, contraseña 1234. Una vez dentro podras crear mas organizadores)");
		System.out.println("Seleccione su usuario de Organizacion:");
		int orgSelect=0;
		String pass;
		for(int i=0; i< Organizadores.size();i++) {
			System.out.println( i + "." + Organizadores.get(i));
		}
		orgSelect= sc.nextInt();
		
		System.out.println("Escriba la contraseña de " + Organizadores.get(orgSelect).getNombre());
		pass=sc.next();
		
		if(Organizadores.get(orgSelect).getContraseña().equals(pass)) {
			int opcion=0;
			do {
				 System.out.println("\n--- Menu Organizadores ---");
		            System.out.println("1. Crear Organizador");
		            System.out.println("2. Ver eventos disponibles");
		            System.out.println("3. Ver Organizadores");
		            System.out.println("4. Crear Evento");
		            System.out.println("5. Eliminar Evento");
		            System.out.println("6. Salir");
		            System.out.print("Elige una opción: ");
		            opcion = sc.nextInt();
		            switch (opcion) {
	                case 1:
	                	CrearOrganizador(Organizadores);
	                    break;
	                case 2:
	                	VerEventos(eventos);
	                    break;
	                case 3:
	                	verOrganizadores(Organizadores);
	                	break;
	                case 4:
	                	CrearEvento(Organizadores, eventos);
	                    break;
	                case 5:
	                    eliminarEvento(eventos);
	                    break;
	                case 6:
	                    System.out.println("Saliendo del menú...");
	                    break;
	                default:
	                    System.out.println("Opción no válida, intenta de nuevo.");
	            }
	 } while (opcion != 6);
			

		}else {
			System.out.println("Contraseña Incorrecta");
		}
	}



	private static void verOrganizadores(ArrayList<Organizador> Organizadores) {
		for(int i=0;i<Organizadores.size(); i++) {
			System.out.println(Organizadores.get(i).toString());
		}
	}



	private static void eliminarEvento(ArrayList<Evento> eventos) {
		int eveElim;
		System.out.println("Que evento deseas eliminar?");
		VerEventos(eventos);
		eveElim = sc.nextInt();
		eventos.remove(eveElim);
		System.out.println("Evento eliminado");

	}



	private static void VerEventos(ArrayList<Evento> eventos) {
		if(eventos.isEmpty()) {
			System.out.println("La lista de eventos esta vacia");

		}else {
			for(int i=0;i<eventos.size(); i++) {
				System.out.println(i + "." + eventos.get(i).toString());
			}
		}
		
	}



	private static void MenuUsuario(ArrayList<Evento> eventos, ArrayList<Usuario> usuarios) {
		int res=0;
		do {
			 System.out.println("\n--- MENÚ ---");
	            System.out.println("1. Crear usuario");
	            System.out.println("2. Ver usuarios e informacion");
	            System.out.println("3. Ver eventos disponibles");
	            System.out.println("4. Apuntar usuario a evento");
	            System.out.println("5. Desapuntar usuario de evento");
	            System.out.println("6. Mostrar eventos de un usuario");
	            System.out.println("7. Salir");
	            System.out.print("Elige una opción: ");
	            res = sc.nextInt();
		 switch (res) {
         case 1:
     		CrearUsuario(usuarios);
     		break;
         case 2:
        	 if(usuarios.isEmpty()) {
 	            System.out.println("No hay usuarios en la lista");

        	 }else {
        		 for(int i=0;i<usuarios.size(); i++) {
          			System.out.println(usuarios.get(i).toString());
          		}
        	 }
        	 
        	 break;
         case 3:
        	 VerEventos(eventos);
        	 break;
         case 4:
        	 ApuntarseEvento(eventos, usuarios);
             break;
         case 5:
        	 Desapuntar(usuarios);
        	 break;
         case 6:
        	 ComprobarEventosInscritos(usuarios);
             break;
         case 7:
             System.out.println("Saliendo del programa...");
             break;
         default:
             System.out.println("Opción no válida, intenta de nuevo.");
     }
 } while (res != 7);
	}


	private static void ComprobarEventosInscritos(ArrayList<Usuario> usuarios) {
		if(usuarios.isEmpty()) {
			System.out.println("No hay usuarios");
		}else {
			System.out.println("De que usuario quieres comprobar sus eventos inscritos?");

			int usuSelec3=0;
			for(int i=0; i<usuarios.size();i++) {
				System.out.println(i + "." + usuarios.get(i));
			}
			usuSelec3 = sc2.nextInt();
			
	        usuarios.get(usuSelec3).mostrarEventosInscritos();
	
		}
	}


	private static void Desapuntar(ArrayList<Usuario> usuarios) {
		if(usuarios.isEmpty()) {
			System.out.println("No hay usuarios");
		}else {
			System.out.println("A que usuario quieres desapuntar de un evento?");

			int usuSelec4=0, eveSelect2=0;
			for(int i=0; i<usuarios.size();i++) {
				System.out.println(i + "." + usuarios.get(i));
			}
			usuSelec4 = sc2.nextInt();
			System.out.println("A que evento lo quieres desapuntar");
	        usuarios.get(usuSelec4).mostrarEventosInscritos();
	        eveSelect2= sc.nextInt();
	        
	        usuarios.get(usuSelec4).desapuntarDeEvento(eveSelect2);
			System.out.println("Se ha desapuntado al usuario del evento.");
		}
	}
	

	private static void ApuntarseEvento(ArrayList<Evento> eventos, ArrayList<Usuario> usuarios) {
		if(usuarios.isEmpty() || eventos.isEmpty()){
			System.out.println("La lista de usuarios o eventos esta vacia no se puede asociar ningun evento a ningun usuario");

		}else {
			System.out.println("Que usuario se quiere apuntar al evento?");

			int usuSelec=0, eveSelec=0;
			for(int i=0; i<usuarios.size();i++) {
				System.out.println(i + "." + usuarios.get(i));
			}
			usuSelec = sc2.nextInt();
			System.out.println("A que evento lo quieres apuntar");

			
			for(int i=0; i<eventos.size();i++) {
				System.out.println(i + "." + eventos.get(i));
			}
			
			eveSelec = sc2.nextInt();
			
			usuarios.get(eveSelec).apuntarAEvento(eventos.get(eveSelec));
		}
	}

	private static void CrearUsuario(ArrayList<Usuario> usuarios) {
		String nUsuario, eUsuario;
		System.out.println("Como se llama el Usuario?");
		nUsuario = sc.next();
		System.out.println("Cual es el mail del Usuario?");
		eUsuario = sc.next();
		
		Usuario user = new Usuario(nUsuario, eUsuario);
		usuarios.add(user);
	}

	private static void CrearOrganizador(ArrayList<Organizador> Organizadores) {
		String nOrganizador, eOrganizador, tOrganizador, cOrganizador;
		System.out.println("Como se llama el organizador?");
		nOrganizador = sc.next();
		System.out.println("Cual es el mail del organizador");
		eOrganizador = sc.next();
		System.out.println("Cual es el numero del organizador");
		tOrganizador = sc.next();
		System.out.println("Que contraseña desea poner a su cuenta");
		cOrganizador = sc.next();
		
		Organizador orga = new Organizador(nOrganizador, eOrganizador, tOrganizador, cOrganizador);
		Organizadores.add(orga);
		
	}

	private static void CrearEvento(ArrayList<Organizador> Organizadores, ArrayList<Evento> eventos) {
		Organizador evOrganizador;
		String tEvento = null, tUbicacion, tFecha;
		int opt=0, tDia=0, tMes=0, tAnio=0, tIntorganizador=0;
		System.out.println("Cual es el nombre del evento?");
		String nEvento = sc.next();
		
		do {
			System.out.println("Que tipo de evento quieres?");
			System.out.println("1.Taller");
			System.out.println("2.Conferencia");
			opt = sc.nextInt();
			switch(opt) {
				case 1:
					tEvento = "Taller";
					break;
				case 2:
					tEvento= "Conferencia";
					break;
			}
		}while(opt!=1 && opt!=2);
		
		
		System.out.println("Cuando seria el evento?");
		System.out.println("Que año seria el evento?");
		tAnio= sc.nextInt();
		System.out.println("Que mes es el evento?");
		tMes=sc.nextInt();
		System.out.println("Que dia es el evento?");
		tDia=sc.nextInt();
		tFecha = tDia + "/" + tMes + "/" + tAnio;
		
		System.out.println("Donde seria el evento?");
		tUbicacion = sc.next();
		
		
		for(int i=0; i<Organizadores.size(); i++) {
			System.out.println(i + "." + Organizadores.get(i));
		}
		System.out.println("Pulsa el numero del organizador que organiza el evento");
		tIntorganizador = sc.nextInt();
		evOrganizador = Organizadores.get(tIntorganizador);
		
		Evento evento = new Evento(nEvento,tEvento, tFecha, tUbicacion, evOrganizador);
		eventos.add(evento);
	}

}