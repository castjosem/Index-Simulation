package proyectofinal;
public interface Metodos {

    public boolean compararData (Object elemento);

    public String tipoDeDato ();

    public boolean vacia();

    public Data obtenerDato (Object elemento);

    public String getCedula (Object elemento);

    public int getCedula (String cedula);

    public int setIndex (int cedula);

    public int setIndex (String cedula);

    public boolean validarCedula( String cedula);

    public boolean comprobarExistencia(NodoArbol arbol,String cedula);

    public void mostrarDato (Object elemento, javax.swing.JTextArea texto );
}
