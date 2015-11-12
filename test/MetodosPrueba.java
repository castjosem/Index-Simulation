public class MetodosPrueba {

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
