package usuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import pool.ConnectionPool;
import socios.GestorSocios;
import socios.Socio;

public interface Interactuador {

    //Configuración de la conexión a la base de datos
    final String URL = "\"jdbc:mariadb://localhost:3306/baloncesto\"";
    final String USUARIO = "root";
    final String CLAVE = "";

    ConnectionPool pool = new ConnectionPool(URL, USUARIO, CLAVE);
    GestorSocios miGestor = new GestorSocios(pool.getConnection());
    Scanner sc = new Scanner(System.in);

    //Consulta de socios filtrada
    public static void consultaFiltrada() {
        ArrayList<Socio> lista = null;
        System.out.print("Escriba la columna por la que filtrar: ");
        String columna = sc.nextLine().toLowerCase();
        try {
            switch (columna) {
                case "nombre":
                System.out.print("Escriba el nombre del Socio: ");
                String nombre = sc.nextLine();
                lista = miGestor.query(columna, nombre);
                    
                    break;
                
                case "localidad":
                System.out.print("Escriba la localidad del Socio: ");
                String localidad = sc.nextLine();
                lista = miGestor.query(columna, localidad);
                    break;
                  
                case "estatura":
                System.out.print("Escriba la estatura del Socio: ");
                int estatura = Integer.parseInt(sc.nextLine());
                lista = miGestor.query(columna, estatura);
                
                    break;

                case "edad":
                System.out.print("Escriba la edad del Socio: ");
                int edad = Integer.parseInt(sc.nextLine());
                lista = miGestor.query(columna, edad);
                    break;

                case "socioID":
                System.out.print("Escriba el ID del Socio: ");
                int id = Integer.parseInt(sc.nextLine());
                lista = miGestor.query(columna, id);
            
                default:
                    break;
            }
            if(lista.isEmpty()) System.out.println("No se encuentran socios con esos criterios");
            for (Socio socio : lista){
                System.out.println(socio);
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }

    public static void consultaOrdenada() {
        ArrayList<Socio> lista = null;
        System.out.print("Escriba el criterio de ordenación");
        String criterio = sc.nextLine();
        try {
            lista = miGestor.requestAll(criterio);
            if(lista.isEmpty()) System.out.println("No se encuentran socios con esos criterios");
            for(Socio socio : lista) {
                System.out.println(socio);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public static void consultarPorID() throws SQLException {
        System.out.print("\nEscriba el ID del socio: ");
        int id = Integer.parseInt(sc.nextLine());
        try {
            System.out.println(miGestor.requestById(id));
            
        } catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
        }
        


    }
     public static void altaSocio(){
        
        try {
        System.out.println("Introduzca el nombre del Socio:");
        String nombre = sc.nextLine();
        System.out.println("Introduzca la estatura del Socio:");
        int estatura = Integer.parseInt(sc.nextLine());
        System.out.println("Introduzca la edad del Socio:");
        int edad = Integer.parseInt(sc.nextLine());
        System.out.println("Introduzca la localidad del Socio:");
        String locadliad = sc.nextLine();
        System.out.println("Introduzca la ID del nuevo Socio");
        int socioID = Integer.parseInt(locadliad);
        Socio socio = new Socio(socioID, nombre, estatura, edad, locadliad);
        socio.create(socio);
        System.out.println("El socio ha sido dado de Alta");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
     }

     public static void bajaSocio() throws SQLException {
        try {
            System.out.println("Introduce la Id del Socio.");
            System.out.print(">> ");
            int id = solicitarid(Integer.parseInt(sc.nextLine()));
            miGestor.delete(id);
            System.out.println("El Socio ha sido Eliminado");
            sc.close();
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error");
        }

     }

     public static void modificaSocio(){
        try {
            System.out.println("Introduzca el id del socio que desea modificar");
            System.out.print(">> ");
            int id = 0;
             Interactuador.solicitarid(id);
            System.out.println("Introduzca el nombre del Socio a modificar");
            System.out.print(">> ");
            String nombre = sc.nextLine();
            System.out.println("Introduzca la estatura del socio");
            System.out.print(">> ");
            int estatura = 0;
            Interactuador.solicitarid(estatura);
            System.out.println("Introduzca la edad del Socio");
            System.out.print(">> ");
            int edad = solicitarid(Integer.parseInt(sc.nextLine()));
            
            System.out.println("Introduzca la localidad del Socio");
            System.out.print(">> ");
            String localidad = sc.nextLine();

            Socio socio = new Socio(id, nombre, estatura, edad, localidad);
            miGestor.update(socio);
        } catch (Exception e) {
            System.err.println("Ha ocurrido un eror");
        }
     }


    
     public static int solicitarid(int id){
    
        try{
            System.out.println("Introduzca una opción válida");
            id = Integer.parseInt(sc.nextLine());
            sc.close();
            if(id < 0){
                System.out.println("Opción no Válida");
            }
        } catch(Exception e) {
            System.out.println("Opción Inválida");
        }
            return id;
     }

}