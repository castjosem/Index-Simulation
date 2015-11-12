package proyectofinal;

public class Lista implements Metodos{

    private NodoLista inicio;
    private NodoLista fin;

    public Lista (){
        inicio = fin = null;
    }

    public Lista (NodoLista nodo){
        inicio = fin =  nodo;
    }
    public synchronized void insertar (NodoLista nuevo){
        if( vacia() ){
            inicio = fin = nuevo;
        }
        else {
            fin.setSig(nuevo);
            fin = nuevo;
        }
    }

    public synchronized void eliminar (NodoLista eliminar){
        if(!vacia()) //Si no esta vacia
        {
            NodoLista aux = inicio;

            if(inicio == eliminar){
                inicio = inicio.getSig();
                if(fin == eliminar) fin = null;
            }
            else if(fin == eliminar)
            {
                while(aux.getSig()!= fin) aux = aux.getSig();
                aux.setSig(null);
                fin = aux;
            }
            else{
                while((aux!=null) && (aux.getSig()!=eliminar)) aux = aux.getSig();
                if(aux!=null){
                    aux.setSig(aux.getSig().getSig());
                }
            }
        }
    }

    public void mostrar (javax.swing.JTextArea texto){
        if ( !vacia() ){
            NodoLista aux = inicio;
            while(aux!=null){

                Object objeto = aux.getDato();
                if( compararData(objeto) )
                    mostrarDato(objeto,texto);
                aux=aux.getSig();            
            }
        }
    }

    public void mostrarSub (NodoLista lista,javax.swing.JTextArea texto){
        if ( lista!=null ){
            NodoLista aux =lista;
            while(aux!=null){
                Object objeto = aux.getDato();
                if( compararData(objeto) )
                    mostrarDato(objeto,texto);
                aux=aux.getSigIn();
            }
        }
    }

    public void mostrarIndicesSubLista(NodoArbol raiz,javax.swing.JTextArea texto){
        texto.append(System.getProperty("line.separator"));
        texto.append("Indices "+raiz.getIndex()+" : "+ cantidadIndices(raiz.getLista() , raiz.getListaFin()));
        texto.append(System.getProperty("line.separator"));
        texto.append(System.getProperty("line.separator"));
    }

    public void mostrarNodoLista (NodoLista lista,javax.swing.JTextArea texto){
        if ( lista!=null ){
            Object objeto = lista.getDato();
            if( compararData(objeto) )
                mostrarDato(objeto,texto);
        }
    }
    
    public int cantidadIndices(NodoLista inicio, NodoLista fin){
        if ( inicio == null ) return 0;
        else{
            if(inicio == fin) return 1;

            int count = 0;
            NodoLista aux = inicio;
            while(aux!=null){
                aux = aux.getSigIn();
                count++;
            }
            return count;
        }
    }
    
    public NodoLista getIni (){
        return inicio;
    }

    public boolean compararData (Object elemento){
        String tipoDeObjeto = elemento.getClass().getSimpleName();
        if( tipoDeObjeto.equals( tipoDeDato() ) )
            return true;
        return false;
    }

    public String tipoDeDato (){
        return "Data";
    }
    public boolean vacia(){
        return (inicio == null);
    }

    public Data obtenerDato (Object elemento){
        Data aux = (Data)elemento;
        return aux;
    }

    public String getCedula (Object elemento){
        Data aux = (Data)elemento;
        return aux.getCedula();
    }

    public int getCedula (String cedula){
        int num = Integer.parseInt(cedula);
        return num;
    }

    public int setIndex (int cedula){
        cedula=(int)(cedula/1000000);
        return cedula;
    }

    public int setIndex (String cedula){
        int num = (int)(getCedula(cedula)/1000000);
        return num;
    }

    public boolean validarCedula( String cedula){
        cedula = cedula.trim();
        boolean ok = true;
        if((cedula.length()>0) && (cedula.length()<=8))
        {
            for(int i = 0 ; i < cedula.length() ; i++){
                if( !((cedula.charAt(i) >= '0')&&(cedula.charAt(i)<= '9')) ){
                    ok = false;
                }
            }
            return ok;
        }
        return false;
    }

    public boolean comprobarExistencia(NodoArbol arbol,String cedula){
        NodoLista inicio = arbol.getLista();
        NodoLista fin = arbol.getListaFin();

        if(cedula.compareTo(getCedula(inicio.getDato()))== 0)   return true;
        else if(cedula.compareTo(getCedula(fin.getDato()))== 0) return true;
        else{
            while((inicio.getSigIn()!=null) && (cedula.compareTo(getCedula(inicio.getSigIn().getDato()))!= 0))
                inicio = inicio.getSigIn();
            if(inicio.getSigIn()!=null)  return true;
        }
        return false;
    }

    public void mostrarDato (Object elemento, javax.swing.JTextArea texto ){
        Data aux = obtenerDato(elemento);

        texto.append( aux.getCedula());
        texto.append(System.getProperty("line.separator"));
        texto.append( aux.getNombre());
        texto.append(System.getProperty("line.separator"));
        texto.append( aux.getApellido());
        texto.append(System.getProperty("line.separator"));
        texto.append( aux.getSector());
        texto.append(System.getProperty("line.separator"));
        texto.append( aux.getTelefono());
        texto.append(System.getProperty("line.separator"));
        texto.append( aux.getEmail());
        texto.append(System.getProperty("line.separator"));
        texto.append(System.getProperty("line.separator"));

    }


}
