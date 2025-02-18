package socios;

public class Socio {
    int socioID;
    String nombre;
    int estatura;
    int edad;
    String localidad;

    public Socio() {
        this(0,"",0,0,"");
    }

    public Socio(int socioID, String nombre, int estatura, int edad, String localidad) {
        this.socioID= socioID;
        this.nombre = nombre;
        this.estatura = estatura;
        this.edad = edad;
        this.localidad = localidad;
    }

    public Socio(Socio miSocio) {
        this.socioID = miSocio.socioID;
        this.nombre = miSocio.nombre;
        this.estatura = miSocio.estatura;
        this.edad = miSocio.edad;
        this.localidad = miSocio.localidad;
    }

    public int getSocioID() {
        return socioID;
    }

    public void setSocioID(int socioID) {
        this.socioID = socioID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    public boolean create(Socio socio){
            return false;
        
    }

    public String toString(){
        return "Socio con id: " + this.socioID + " Nombre: " + this.nombre + " Estatura: " + this.estatura + " Edad " + this.edad + " Localidad: " + localidad;
    }

}      
