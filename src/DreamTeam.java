import pool.ConnectionPool;
import socios.GestorSocios;
import socios.Socio;
import usuario.Interactuador;

public class DreamTeam {
    public static void main(String[] args) {
        final String URL = "\"jdbc:mariadb://localhost:3306/baloncesto\"";
        final String USUARIO = "root";
        final String CLAVE = "";

        ConnectionPool pool = new ConnectionPool(URL, USUARIO, CLAVE);
        GestorSocios miGestor = new GestorSocios(pool.getConnection());
        final int OPCIÓN_MAX = 7;
        int elección = 0;
        Socio miSocio = new Socio(0, "", 0, 0, "");
        // menú
        do {
            System.out.println("DREAM TEAM");
            System.out.println("-----------");
            System.out.println("1. Dar de Alta un Socio");
            System.out.println("2. Dar de Baja un Socio");
            System.out.println("3. Modificar un Socio");
            System.out.println("4. Mostrar Socios");
            System.out.println("5. Mostrar un Socio");
            System.out.println("6. Saliendo");
            System.out.println("------------");
            System.out.println("Elige una opción (1-6)");
            System.out.print(">> ");
            elección = DreamTeam.verificarOpcion(elección);

            switch (elección) {
                case 1:
                    DreamTeam.altaSocio();
                    break;
                case 2:
                    DreamTeam.bajaSocio();
                    break;
                case 3:
                    DreamTeam.modificarSocio();
                    break;
                case 4:
                    DreamTeam.mostrarSocios();
                    break;
                case 5:
                    DreamTeam.mostrarUnSocio();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (elección != 6);
    }
                    
    private static void modificarSocio() {
    
    }
                    
    private static void mostrarUnSocio() {
        
    }

    private static void mostrarSocios() {

    }                                         

    

    private static void bajaSocio() {
        
    }

    public static void altaSocio() {
        System.out.println("Introduce el Nombre del Socio: ");
        System.out.print(">> ");
        String nombre = System.console().readLine();
        System.out.println("Introduce la Estarura del Socio: ");
        int estatura = 0;
        estatura = DreamTeam.verificarEntero(estatura);
        System.out.println("Introduce la Edad del Socio: ");
        System.out.print(">> ");
        int edad = 0;
        edad = DreamTeam.verificarEntero(edad);
        System.out.println("Introduzca la localidad del Socio: ");
        System.out.print(">> ");
        String localidad = System.console().readLine();
        System.out.println("Introduce la ID del Socio: ");
        System.out.print(">> ");
        int id = 0;
        id = DreamTeam.verificarEntero(id);
        Socio socioAlta = new Socio(id, nombre, estatura, edad, localidad);
        socioAlta.create(socioAlta);
        System.out.println("El Socio ha sido dado de alta: ");
    }

    public static int verificarOpcion(int opcion) {

        try {
            opcion = verificarEntero(opcion);
            if (opcion < 1 || opcion > 6) {
                throw new IllegalArgumentException("Introduzca una opción válida (1-6)");
            }

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.getMessage());

        }
        return opcion;

    }

    public static int verificarEntero(int entero) {
        boolean datoValido = false;
        do {
            
            try {
                entero = Integer.parseInt(System.console().readLine());
                datoValido = true;
            } catch (Exception e) {
                System.out.println("Error\n" + e.getClass() + "\n" + e.getMessage());
            }
        } while (!datoValido);
        return entero;
    }
}
