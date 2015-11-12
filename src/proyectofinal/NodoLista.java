package proyectofinal;

public class NodoLista {

    private NodoLista sig;
    private NodoLista sigIn;
    private Object dato;
    
    public NodoLista (Object elemento){
        dato = elemento;
        sig = null;
        sigIn = null;
    }

    public NodoLista (Object elemento, NodoLista siguiente){
        dato = elemento;
        sig = siguiente;
        sig = null;
    }

    public NodoLista (Object elemento, NodoLista siguiente, NodoLista siguienteIn){
        dato = elemento;
        sig = siguiente;
        sigIn = siguienteIn;
    }

    public NodoLista getSigIn () {
        return sigIn;
    }

    public void setSigIn (NodoLista sigIn) {
        this.sigIn = sigIn;
    }

    public Object getDato () {
        return dato;
    }

    public void setDato (Object dato){
        this.dato=dato;
    }

    public NodoLista getSig () {
        return sig;
    }

    public void setSig (NodoLista sig) {
        this.sig = sig;
    }
	
}