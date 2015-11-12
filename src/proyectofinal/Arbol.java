package proyectofinal;

public class Arbol implements Metodos{

    private NodoArbol raiz;
    
    public Arbol(){
        raiz = null;
    }

    public synchronized boolean insertar (Object data, Lista lista){
        if( compararData(data))
        {
            NodoArbol auxArbol = buscarNodo(getCedula(data));// Variable para recibir posible Indice existente en el arbol
            NodoLista nuevo = new NodoLista(data);
            if(auxArbol==null){ // No encontro indice dentro del arbol
                insertar( new NodoArbol(setIndex(getCedula(data)),nuevo) , lista ); //Inserta en arbol
                return true;
            }
            
            else{
                    // Encontro el indice dentro del arbol
                  if( comprobarExistencia(auxArbol,getCedula(data)) )  {
                    return false;
                    }
                else{
                    NodoLista aux = auxArbol.getListaFin();
                    aux.setSigIn(nuevo);
                    auxArbol.setListaFin(nuevo);
                    lista.insertar(nuevo);
                    
                    return true;
                }
            }
        }
        return false;
    }
    
    public synchronized void insertar (NodoArbol nuevo , Lista lista){
        if( vacia() ){
            raiz = nuevo;
            lista.insertar(nuevo.getLista());
        }
        else
            insertar(raiz, nuevo , lista);
    }
    
    private synchronized void insertar (NodoArbol raiz, NodoArbol nuevo , Lista lista) {
        if( nuevo.getIndex() < raiz.getIndex() ){
            if( raiz.getIzq()==null ){
                    raiz.setIzq( nuevo );
                    
                    lista.insertar(nuevo.getLista());
                    
            }
            else
                insertar( raiz.getIzq() , nuevo , lista );
        }
        else{
            if( raiz.getDer()==null ){
                    raiz.setDer( nuevo );

                    lista.insertar(nuevo.getLista());
                    
            }
            else
                insertar( raiz.getDer() , nuevo , lista);
        }
    }

    public boolean eliminar (NodoArbol nodo , Lista lista){
        return eliminar (raiz, nodo , lista) != null; //retorna true si se elimino, false en caso contrario
    }

    private synchronized NodoArbol eliminar (NodoArbol raiz, NodoArbol nodo , Lista lista){
        NodoArbol aux =  raiz;
        if (nodo == null) return null; // el nodo no existe
        if  (raiz == null) return null; //arbol vacio  ANTES ESTABA
        else {
             if (raiz.getIndex() == nodo.getIndex()){
                NodoArbol padre = buscarPadre(this.raiz, nodo);
                if (padre == null){ //intento borrar la raiz del arbol

                    if (raiz.getIzq() != null || raiz.getDer() != null){//la raiz tiene hijos
                        NodoArbol temp, temp2;
                        temp = raiz.getIzq(); temp2 = raiz.getDer();
                        this.raiz = reemplazar(raiz , lista);

                        if( this.raiz != temp )     this.raiz.setIzq(temp);
                        if( this.raiz != temp2 )    this.raiz.setDer(temp2);
                        return nodo;
                    }
                    else {//la raiz no tiene hijos (el arbol queda vacio)
                        this.raiz = null;
                        return nodo;
                    }
                }
                else { //el nodo tiene padre
                    if (nodo.getIzq()==null && nodo.getDer()==null){ //borrar nodo hoja
                        if (padre.getIzq() == nodo) padre.setIzq(null);
                        else padre.setDer(null);
                        return nodo;
                    }
                    else {//borrar nodo con hijos
                        NodoArbol nuevaRaiz, temp, temp2;
                        nuevaRaiz = reemplazar(raiz , lista);
                        temp = nodo.getIzq(); temp2 = nodo.getDer();
                        nodo.setIzq(null); nodo.setDer(null);

                        if( nuevaRaiz.getIzq() != temp)
                            nuevaRaiz.setIzq(temp);

                        if( nuevaRaiz.getDer() != temp)
                            nuevaRaiz.setDer(temp2);

                        if (padre.getIzq() == nodo)  padre.setIzq(nuevaRaiz);
                        else  padre.setDer(nuevaRaiz);

                        return nodo;
                    }
                }
             }
             else if (nodo.getIndex() < raiz.getIndex()){
                 return eliminar (aux.getIzq(), nodo , lista);
             }
             else {
                 return eliminar (aux.getDer(), nodo , lista);
             }
        }

    }

    public NodoArbol reemplazar (NodoArbol raiz , Lista lista) { //Retorna el Mayor de los Menores o el Menor de los Mayores en su defecto
        NodoArbol aux, aux2, hijo;
        
        if (raiz.getIzq()!=null){ //mayor de los menores
            aux=raiz.getIzq();
            aux2=raiz.getIzq();
            if (aux.getDer() != null){
                while (aux.getDer() != null)
                    aux=aux.getDer();
                while (aux2.getDer() != aux)
                    aux2=aux2.getDer();
                if (aux.getIzq() != null){
                    hijo = aux.getIzq();
                    aux.setIzq(null);
                    aux2.setDer(null);

                    insertar (hijo , lista);
                }
                else
                    aux2.setDer(null);
                return (aux);
            }
            else { // no hay mayores que el hijo izq
                if (aux.getIzq() != null) {// el hijo izq del nodo a eliminar tiene solo hijo izq
                    raiz.setIzq(aux.getIzq());
                    aux.setIzq(null);
                    return (aux);
                }
                else if (aux.getIzq() == null) {//el hijo izq del nodo a eliminar es hoja
                    raiz.setIzq(null);
                    return (aux);
                }
            }
        }
        else { //menor de los mayores
            if (raiz.getDer()!= null){
                aux=raiz.getDer();
                aux2=raiz.getDer();
                if (aux.getIzq() != null){
                    while (aux.getIzq() != null)
                        aux=aux.getIzq();
                    while (aux2.getIzq() != aux)
                        aux2=aux2.getIzq();
                    if (aux.getDer() != null){
                        hijo = aux.getDer();
                        aux.setDer(null);
                        aux2.setIzq(null);
                        insertar (hijo , lista);
                    }
                    else
                        aux2.setIzq(null);
                    return (aux);
                }
                else { // aux.getDer == null
                    if (aux.getDer() != null) {// el hijo derecho del nodo a eliminar tiene solo hijo derecho
                        raiz.setDer(aux.getDer());
                        aux.setDer(null);
                        return (aux);
                    }
                    else if (aux.getDer() == null) {//el hijo derecho del nodo a eliminar es hoja
                        raiz.setDer(null);
                        return (aux);
                    }
                }
            }
        }
        return (null); //recibio un nodo hoja;
    }

    private NodoArbol buscarPadre (NodoArbol raiz, NodoArbol nodoHijo){
        if (raiz != null){
            NodoArbol nodoPadre = raiz;
            if(raiz.getIndex() == nodoHijo.getIndex()) return null;
            if ((nodoPadre.getIzq()!=null) && (nodoPadre.getIzq().getIndex()) == nodoHijo.getIndex() ||
                (nodoPadre.getDer()!=null) && (nodoPadre.getDer().getIndex()) == nodoHijo.getIndex())
                return nodoPadre;

            else if ( nodoPadre.getIndex() > nodoHijo.getIndex() )
                return buscarPadre (nodoPadre.getIzq(), nodoHijo);
            else
                return buscarPadre (nodoPadre.getDer(), nodoHijo);
        }
        else
            return null; //intento borrar la*ra*z
    }

    public synchronized void mostrarPreOrden (NodoArbol raiz, javax.swing.JTextArea texto , Lista lista ){
        if( raiz!=null ){
            lista.mostrarSub(raiz.getLista(), texto);
            mostrarPreOrden(raiz.getIzq(), texto , lista);
            mostrarPreOrden(raiz.getDer(), texto, lista);
        }
    }

    public synchronized void mostrarInOrden (NodoArbol raiz, javax.swing.JTextArea texto , Lista lista){
        if( raiz!=null ){
            mostrarInOrden(raiz.getIzq() , texto , lista);
            lista.mostrarSub(raiz.getLista(), texto);
            mostrarInOrden(raiz.getDer(), texto, lista);
        }
    }
    
    public synchronized void mostrarPostOrden (NodoArbol raiz, javax.swing.JTextArea texto, Lista lista){
        if( raiz!=null ){
            mostrarPostOrden(raiz.getIzq(), texto, lista);
            mostrarPostOrden(raiz.getDer(), texto, lista);
            lista.mostrarSub(raiz.getLista(), texto);
        }
    }

    public synchronized void mostrarPorIndices(NodoArbol raiz, javax.swing.JTextArea texto, Lista lista){
        if( raiz!=null )
        {
            mostrarPorIndices(raiz.getIzq(), texto, lista);
            lista.mostrarIndicesSubLista(raiz, texto);
            mostrarPorIndices(raiz.getDer(), texto, lista);
        }
    }

    public NodoArbol getIni (){
        return raiz;
    }

    public synchronized NodoArbol buscarNodo (String cedula){
        int index = setIndex(cedula);
        return buscarNodo (index, raiz);
    }

    private synchronized NodoArbol buscarNodo(int index, NodoArbol raiz){
        if (raiz != null){
            int num = raiz.getIndex();
            if( num == index ) return raiz;
            else if (num > index) return buscarNodo (index,raiz.getIzq());
            else
                return buscarNodo (index,raiz.getDer());
        }
        return null;
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
        return  (raiz == null);
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