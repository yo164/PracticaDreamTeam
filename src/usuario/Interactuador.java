package usuario;

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
    
    public static void consultarPorID() {
        System.out.print("\nEscriba el ID del socio: ");
        int id = Integer.parseInt(sc.nextLine());
        Socio socio = miGestor.requestById(id);



    }
     public static void altaSocio(){
        System.out.println("")
     }

     public static void bajaSocio() {

     }

     public static int solicitarEleccion(int OPCION_MAX){
        int eleccion = 0;
        try{
            System.out.println("Introduzca una opción válida");
            eleccion = Integer.parseInt(sc.nextLine());
            if(OPCION_MAX < 0 ||)
        } catch(Exception e) {
            System.out.println("Opción Inválida");
        }
                return eleccion;
     }

}