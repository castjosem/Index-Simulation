package proyectofinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sistema extends javax.swing.JFrame implements Metodos{

    private static Lista lista = new Lista();
    private static Arbol arbol = new Arbol();

    public void leerArchivo (File file) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String cadena = new String();
        String array[] = new String[6];

        cadena = br.readLine();
        while ( cadena!=null )
        {
            array = cadena.split(",");
            Object dato = new Data(array);
            insertarSistema(dato);
            cadena = br.readLine();
        }

    }

    public synchronized boolean insertarSistema (Object data){
        return arbol.insertar(data,lista);
    }

    public synchronized boolean eliminarSistema(String cedula){
        if( validarCedula(cedula) )
        {
            NodoArbol auxArbol = arbol.buscarNodo(cedula);
            if(auxArbol==null) return false;
            else{
                return eliminar(auxArbol,cedula);
            }
        }
        return false;
    }

    public synchronized boolean eliminar(NodoArbol raiz,String cedula){
        if(raiz!=null) //Si no esta vacia
        {
            NodoLista inicio = raiz.getLista();
            NodoLista fin = raiz.getListaFin();
            NodoLista eliminar;

            if(cedula.compareTo(getCedula(inicio.getDato()))== 0 ){
                eliminar = inicio;
                raiz.setLista(inicio.getSigIn());
                if( fin == eliminar ) raiz.setListaFin(null);

                if( (raiz.getLista() == null)&&(raiz.getListaFin()==null) ){
                    arbol.eliminar(raiz , lista);
                }
                lista.eliminar(eliminar); // Elimino en la lista
                return true;
            }
            else if(cedula.compareTo(getCedula(fin.getDato()))== 0 )
            {
                while(inicio.getSigIn()!= fin) inicio = inicio.getSigIn();
                eliminar = inicio.getSigIn();
                inicio.setSigIn(null);
                raiz.setListaFin(inicio);

                lista.eliminar(eliminar); // Elimino en la lista
                return true;
            }
            else{
                while((inicio.getSigIn()!=null) && (cedula.compareTo(getCedula(inicio.getSigIn().getDato()))!= 0))
                    inicio = inicio.getSigIn();
                if(inicio.getSigIn()!=null){ // si existe la cedula entonces entra
                    eliminar = inicio.getSigIn();
                    inicio.setSigIn(inicio.getSigIn().getSigIn());

                    lista.eliminar(eliminar); // Elimino en la lista
                    return true;
                }
            }
        }
        return false;
    }

    public synchronized Object buscar(String cedula){ // Este object va a ser de tipo Data
        if( validarCedula(cedula) ){

            NodoArbol auxArbol = arbol.buscarNodo(cedula);
            if( auxArbol==null ) return null;
            else{
                System.out.println(cedula);
                Object aux = buscarSubLista(auxArbol,cedula);
                if( aux == null) return null;
                else 
                    return aux;
                
            }
        }
        return null;
    }

    public Object buscarSubLista(NodoArbol arbol,String cedula){
        NodoLista inicio = arbol.getLista();
        NodoLista fin = arbol.getListaFin();

        if(cedula.compareTo(getCedula(inicio.getDato()))== 0)   return inicio.getDato();
        else if(cedula.compareTo(getCedula(fin.getDato()))== 0) return fin.getDato();
        else{
            while((inicio.getSigIn()!=null) && (cedula.compareTo(getCedula(inicio.getSigIn().getDato()))!= 0))
                inicio = inicio.getSigIn();
            if(inicio.getSigIn()!=null)  return inicio.getSigIn().getDato();
        }
        return null;
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

    public void mostrarLista (javax.swing.JTextArea texto){
        lista.mostrar(texto);
    }

    public void mostrarSubLista(NodoLista inicio,javax.swing.JTextArea texto){
        lista.mostrarSub(inicio,texto);
    }

    public void mostrarIndicesSubLista(NodoArbol raiz,javax.swing.JTextArea texto){
        texto.append(System.getProperty("line.separator"));
        texto.append("Indices "+raiz.getIndex()+" : "+ lista.cantidadIndices(raiz.getLista() , raiz.getListaFin()));
        texto.append(System.getProperty("line.separator"));
        texto.append(System.getProperty("line.separator"));
    }

    public void mostrarArbol(int tipoDeRecorrido , javax.swing.JTextArea texto){
        switch(tipoDeRecorrido){
            case 0:{
                arbol.mostrarPreOrden(arbol.getIni() , texto , lista);
                break;
            }
            case 1:{
                arbol.mostrarInOrden(arbol.getIni() , texto , lista);
                break;
            }
            case 2:{
                arbol.mostrarPostOrden(arbol.getIni(), texto, lista);
                break;
            }
            case 3:{
                arbol.mostrarPorIndices(arbol.getIni(), texto, lista);
            }
            default:
                break;
        }
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
    public boolean Vacia(){
        return arbol.vacia();
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

    public boolean vacia() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
