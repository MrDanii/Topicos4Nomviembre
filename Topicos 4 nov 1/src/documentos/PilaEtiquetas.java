package documentos;

/**
 *  Es la clase que solo evaluará los cierres de las etiquetas por medio de una pila
 * @author Daniel
 */
public class PilaEtiquetas {
    private Nodo raiz;
    
    
    class Nodo{
        char caracter;
        Nodo siguiente;
    }
    
    
    public void insertar(char caracter){
        Nodo nuevo= new Nodo();
        nuevo.caracter= caracter;
        if(isEmpty()){
            nuevo.siguiente= null;
            raiz= nuevo;  
        }else{
            nuevo.siguiente= raiz;
            raiz= nuevo;
        }
    }
    
    public char extraer(){
        
        if(isEmpty()){
            return Character.MAX_VALUE;
        }else{
            char caracter= raiz.caracter;
            raiz= raiz.siguiente;
            return caracter;
        }
    }
    
    public boolean isEmpty(){
        return raiz==null;
    }
}
