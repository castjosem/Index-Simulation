package proyectofinal;

public class Data {
    
    private String cedula;
    private String nombre;
    private String apellido;
    private String sector;
    private String telefono;
    private String email;
    
    public Data (String array[]){
        this.cedula = array[0];
        this.nombre = array[1];
        this.apellido = array[2];
        this.sector = array[3];
        this.telefono = array[4];
        this.email = array[5];
    }

    public Data (String cedula, String nombre, String apellido, String sector, String telefono, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sector = sector;
        this.telefono = telefono;
        this.email = email;
    }

    public String getCedula () {
        return cedula;
    }

    public String getNombre () {
        return nombre;
    }

    public String getApellido () {
        return apellido;
    }

    public String getSector () {
        return sector;
    }

    public String getTelefono () {
        return telefono;
    }
        
    public String getEmail () {
        return email;
    }
	
    public void mostrarDatos (){
        System.out.println(cedula);
        System.out.println(nombre);
        System.out.println(apellido);
        System.out.println(sector);
        System.out.println(telefono);
        System.out.println(email);
    }

}
