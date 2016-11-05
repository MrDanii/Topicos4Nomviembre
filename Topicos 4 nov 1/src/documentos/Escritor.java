package documentos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Escritor {
    private FileWriter libreta;
    private BufferedWriter hoja;
    private PrintWriter pluma;
    
    private void algo(){
        Lector leer = new Lector();
        String[] datos;
        datos=leer.leer("dieccion");
        
    }
    
    public void escribir(String datos,String direccion){
        try{
            libreta = new FileWriter(direccion);
            hoja = new BufferedWriter(libreta);
            pluma = new PrintWriter(hoja);
            
            pluma.println(datos);
            hoja.close();
            libreta.close();
            
            
            
        }catch(Exception ex){
            System.out.println("El error es: "+ex);
            
        }
    }
}
