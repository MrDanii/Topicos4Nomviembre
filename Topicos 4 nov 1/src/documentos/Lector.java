package documentos;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Lector {
    private Scanner leer;
    
    public String[] leer(String direccion){
        ArrayList<String> datos = new ArrayList();
        String[] renglones;
        try{
            leer = new Scanner(new FileInputStream(direccion),"latin1");
            
            while(leer.hasNext()){
                datos.add(leer.nextLine());
            }
            renglones = new String[datos.size()];
            for(int i=0;i<renglones.length;i++){
            renglones[i]=datos.get(i);
        }
            return renglones;
        }catch(Exception ex){
            System.out.println("El error es: "+ex);
        }
        return null;
    }
    
}
