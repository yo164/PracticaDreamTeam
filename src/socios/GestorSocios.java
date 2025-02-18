package socios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import crud.CRUD;

public class GestorSocios implements CRUD<Socio>{
    private static final Socio socio = null;
        private Connection conn;
    
        public GestorSocios(Connection conn) {
            this.conn = conn;
        }
    
        @Override
        public ArrayList<Socio> query(String column, String value) throws SQLException {
            List<String> validColumns = Arrays.asList("nombre", "localidad");
            if (!validColumns.contains(column)) throw new SQLException("Columna no válida");
            
            ArrayList<Socio> result = new ArrayList<Socio>();
            String sqlQuery = "SELECT * FROM socio WHERE " + column + " = ?";
    
            try (PreparedStatement stmt = this.conn.prepareStatement(sqlQuery)){
                stmt.setString(1, value);
    
                //Ejecución de la consulta
            ResultSet querySet = stmt.executeQuery();
            //Recorrido del resultado de la consulta
            while (querySet.next()) {
                int socioID = querySet.getInt("socioID");
                String nombre = querySet.getString("nombre");
                int estatura = querySet.getInt("edad");
                int edad = querySet.getInt("edad");
                String localidad = querySet.getString("localidad");
                result.add(new Socio(socioID, nombre, estatura, edad, localidad));
            }
            
            return result;
    
            } catch (Exception e) {
                throw e;
            }
        
        }
    
    
    
        @Override
        public ArrayList<Socio> requestAll(String sortedBy) throws SQLException {
            ArrayList<Socio> result = new ArrayList<Socio>();
            String sqlQuery = "SELECT * FROM socio";
            if (!sortedBy.isEmpty()) sqlQuery += " ORDER BY " + sortedBy;
    
            try (Statement stmt = this.conn.createStatement()) {
                ResultSet querySet =  stmt.executeQuery(sqlQuery);
                //Recorrido del resultado de la consulta
                while (querySet.next()) {
                    int socioID = querySet.getInt("socioID");
                    String nombre = querySet.getString("nombre");
                    int estatura = querySet.getInt("estatura");
                    int edad = querySet.getInt("edad");
                    String localidad = querySet.getString("localidad");
                    Socio socio = new Socio(socioID, nombre, estatura, edad, localidad);
                    result.add(socio);
                }
                return result;
            } catch(Exception e){
                String error = e.getMessage();
                System.out.print(error);
                return null;
            }
        }
    
        @Override
        public Socio requestById(int id) throws SQLException {
            Socio socio = null;
            String sqlQuery = "SELECT * FROM socio WHERE socioID = ?";
            
            try (Statement stmt = this.conn.createStatement()){
                ResultSet querySet = stmt.executeQuery(sqlQuery);
                int socioID = querySet.getInt("socioID");
                String nombre = querySet.getString("nombre");
                int estatura = querySet.getInt("estatura");
                int edad = querySet.getInt("edad");
                String localidad = querySet.getString("localidad");
                socio = new Socio(socioID, nombre, estatura, edad, localidad);
//return socio
            } catch (Exception e) {
                System.out.println(e.getMessage());
      //return socio          
            }
            return socio;

                        
        }
    //CREAR NUEVO SOCIO
        @Override
        public boolean create(Socio socio) throws SQLException {
            int socioID = socio.getSocioID();
            String nombre = socio.getNombre();
            int estatura = socio.getEstatura();
            int edad = socio.getEdad();
            String localidad = socio.getLocalidad();
    
            String sqlQuery = "INSERT INTO socio (socioID, nombre, estatura, edad, localidad) VALUES(?,?,?,?,?)";
            try (PreparedStatement stmt = this.conn.prepareStatement(sqlQuery)) {
                stmt.setInt(1, socioID);
                stmt.setString(2,nombre);
                stmt.setInt(3, estatura);
                stmt.setInt(4, edad);
                stmt.setString(5,localidad);
    
                //EJECUCIÓN DE LA CONSULTA
                int affectedRows = stmt.executeUpdate();
                if (affectedRows == 0) throw new SQLException("Falló la creación del nuevo socio.");{
    
                    return affectedRows ==1;
                }
            } catch (SQLException e) {
                throw e;
            }
        }
    //ACTUALIZAR UN SOCIO
        @Override
        public boolean update(Socio socio) throws SQLException {
            int socioID = socio.getSocioID();
            String nombre = socio.getNombre();
            int estatura = socio.getEstatura();
            int edad = socio.getEdad();
            String localidad = socio.getLocalidad();
    
            String sqlQuery = ("UPDATE socio SET nombre = ?, estatura = ?, edad = ?, localidad = ?, WHERE socioID = ?");
            try (PreparedStatement stmt = this.conn.prepareStatement(sqlQuery)){
                stmt.setString(1, nombre);
                stmt.setInt(2, estatura);
                stmt.setInt(3, edad);
                stmt.setString(4, localidad);
                stmt.setInt(5, socioID);
                
                //Ejecución de la consulta
                int affectedRows = stmt.executeUpdate();
                if( affectedRows == 0 ) throw new SQLException("Fallo la actualización del Socio.");
                
            } catch (Exception e) {
                // TODO: handle exception
            }
                    return false;
    
        }
    //BORRAR UN SOCIO
        @Override
        public boolean delete(int id) throws SQLException {
            
            int socioID =   socio.getSocioID();

        String sqlQuery = ("DELETE FROM socio WHERE socioID = ?");
         try (PreparedStatement stmt = this.conn.prepareStatement(sqlQuery)) {
        int affectedRows = stmt.executeUpdate();
        if(affectedRows == 0) throw new SQLException("Fallo la eliminacion del Socio");  
            return true;
         } catch (Exception e) {
           System.out.println(e.getMessage());
           return false;
         }



    }

        @Override
        public ArrayList<Socio> query(String column, int value) throws SQLException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'query'");
        }


     


 
   
    

}