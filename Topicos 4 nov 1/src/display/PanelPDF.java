package display;

import java.awt.BorderLayout;           //Diseño para el panel
import java.awt.event.ActionEvent;      //Evento del panel
import java.awt.event.ActionListener;   //Escucha del panel
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import javax.swing.JButton;
import javax.swing.JFileChooser;  //Importaciones Swing para seleccionar un archivo
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.pdfview.*;     //Biblioteca que contiene todas las clases
                              //necesarias para poder ver un archivo PDF
/**
 *
 * @author Daniel
 */
public class PanelPDF extends JPanel{
    
    PagePanel panelpdf;         //panel que usaremos para movernos en el PDF
    JFileChooser selector;      //JFileChooser nos ayuda a seleccionar un archivo
    PDFFile pdffile;
    int indice=0;
    
    public PanelPDF(){
        panelpdf=new PagePanel();
        JButton botonBuscarArchivo= new JButton("Buscar Aarchivo");
        botonBuscarArchivo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                indice=0;
                selector=new JFileChooser();
                int op=selector.showOpenDialog(PanelPDF.this); //Así es como lanzamos el buscador de archivos
                if(op==JFileChooser.APPROVE_OPTION){
                    try{
                    File file = selector.getSelectedFile();
                       RandomAccessFile raf = new RandomAccessFile(file, "r");
//                       JOptionPane.showMessageDialog(null, file.getPath());   //prueba para ver la ubicación
//                       JOptionPane.showMessageDialog(null, selector.getName(file));
                       FileChannel channel = raf.getChannel();
                       ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,0, channel.size());
                       pdffile = new PDFFile(buf);
                       PDFPage page = pdffile.getPage(indice);
                       panelpdf.showPage(page);
                       repaint();
                    }catch(IOException ioe){
                        JOptionPane.showMessageDialog(null, "Error al abrir el archivo");
                    } //Fin del catch ya que puede haber errores al abrir un archivo
                }//si el directorio es válido
            }
        });
        
        
        JPanel pabajo=new JPanel(); //Panel que cntendrá el panel con los dos botones
        JButton bsiguiente=new JButton("Siguiente");        //El boton siguiente es para avanzar en la página
        bsiguiente.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            indice++;           //Si avanzamos, suma 1 a la página actual
            PDFPage page = pdffile.getPage(indice);
               panelpdf.showPage(page);
            }
        });
        
        JButton banterior=new JButton("Anterior");
            banterior.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            indice--;           //Si damos anterior, resta 1 a la página actual
            PDFPage page = pdffile.getPage(indice);
               panelpdf.showPage(page);
            }
        });
            
        pabajo.add(banterior);  //Añadimos al panel el botón anterior
        pabajo.add(bsiguiente); //Añadimos al panel el botón siguiente
        add(botonBuscarArchivo, BorderLayout.NORTH); //Lo añadimos a nuestro panel prncipal
        add(panelpdf);          //Añadimos el panel del PDF que verá los documentos
        add(pabajo,BorderLayout.SOUTH);     //añadimos a nuestro panel principal
            
        }//Fin del constructor  
    
    public String getNombreArchivo(){
        return selector.getName(selector.getSelectedFile());
    }

}
