package display;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import documentos.Lector;    //El lector que creamos para leer un archivo de texto

/**
 *
 * @author Daniel
 */
public class PanelText extends JPanel {
   
        //elementos para la ventana principal (de donde modifiaremos)
    private JLabel etiquetaNombreA, etiquetaUbicacion;
    private JTextField campoNombre, campoUbicacion;
    private JButton botonAbrir;
    private JButton botonGenerar;
    private JTextArea areaDocText;
    private JScrollPane scroll;
    
    private JFileChooser selector;
    
    
    
    public PanelText(){
        setLayout(null);
        
        //*********************componentes de la ventana********************
        etiquetaNombreA= new JLabel("Nombre del archivo:");
        etiquetaNombreA.setBounds(10, 10, 200, 30);
        add(etiquetaNombreA);
        
        campoNombre= new JTextField("");
        campoNombre.setToolTipText("Nombre del archivo de texto plano");
        campoNombre.setBounds(220, 10, 200, 30);
        campoNombre.setEditable(false);
        add(campoNombre);
        
        etiquetaUbicacion= new JLabel("Ubicación del archivo:");
        etiquetaUbicacion.setBounds(10, 50, 200, 30);
        add(etiquetaUbicacion);
        
        campoUbicacion= new JTextField("");
        campoUbicacion.setToolTipText("Ubicación del archivo de texto plano");
        campoUbicacion.setBounds(220, 50, 200, 30);
        campoUbicacion.setEditable(false);
        add(campoUbicacion);
        
        botonGenerar= new JButton("Generar PDF");
        botonGenerar.setToolTipText("Al dar click, se generará un pdf con el texto\n"
                + "con el mismo nombre del archivo\n"
                + "y en la misma ubicación");
        botonGenerar.setBounds(450, 50, 90, 30);
        botonGenerar.addActionListener(new HandlerBotonGenerar());
        add(botonGenerar);
        
        botonAbrir= new JButton("Abrir .TXT");
        botonAbrir.setToolTipText("Al dar click, se desplegará el explorador de archivo"
                + " para selecionar el archivo de texto plano (.txt)");
        botonAbrir.setBounds(450, 10, 90, 30);
        botonAbrir.addActionListener(new HandlerBotonAbrir());
        add(botonAbrir);
        
        areaDocText= new JTextArea();
        scroll= new JScrollPane(areaDocText);
        scroll.setBounds(10, 90, 450, 300);
        add(scroll);
        
    }//Fin del constructor
    
    private class HandlerBotonAbrir implements ActionListener{
        String nombreArchivo;       //Variable con el nombre del archivo
        String ubicacionArchivo;    //Variable con la ubicacion del archivo en cadena
        String []textoArchivo;        //Variable con el texto del archivo que abramos y que se mostrará en el textArea
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            selector=new JFileChooser();
            
            int op=selector.showOpenDialog(null); //Así es como lanzamos el buscador de archivos
            if(op==JFileChooser.APPROVE_OPTION){
                File file1= selector.getSelectedFile();
                nombreArchivo=selector.getName(file1);
                ubicacionArchivo= file1.getPath();
                
                campoNombre.setText(nombreArchivo);
                campoUbicacion.setText(ubicacionArchivo);
            }
            Lector lector1= new Lector();
            textoArchivo= lector1.leer(ubicacionArchivo);
            String texto= new String();
            for(int i=0; i<textoArchivo.length; i++){
                texto+= textoArchivo[i]+"\n";
            }
            areaDocText.setText(texto);
        } 
    }//Fin de la clase interna privada HandlerBotonAbrir
    
    private class HandlerBotonGenerar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
        
    }
    
}//Fin de la clase Panel Text
