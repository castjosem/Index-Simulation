package proyectofinal;

public class NodoArbol {
    
    private NodoArbol izq;
    private NodoArbol der;
    private int index;
    private NodoLista lista;
    private NodoLista listaFin;
    
    public NodoArbol (int index, NodoLista lista){
        izq = der = null;
	this.index = index;
	this.lista = listaFin = lista;
    }

    public NodoLista getListaFin () {
        return listaFin;
    }

    public void setListaFin (NodoLista listaFin) {
        this.listaFin = listaFin;
    }

    public NodoArbol getIzq () {
        return izq;
    }

    public void setIzq (NodoArbol izq) {
        this.izq = izq;
    }
    
    public NodoArbol getDer () {
        return der;
    }

    public void setDer (NodoArbol der) {
        this.der = der;
    }

    public int getIndex () {
        return index;
    }

    public void setIndex (int index){
        this.index = index;
    }
	
    public NodoLista getLista () {
        return lista;
    }
    
    public void setLista (NodoLista lista) {
        this.lista = lista;
    }
    
}
