package display;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//Importaciones para mostrar el pdf

/**
 *
 * @author Daniel
 */
public class MenuPrincipal extends JFrame{
    
    private JDesktopPane escritorio;
    
    //Elementos para la barra de menus
    private JMenuBar barra;
    private JMenu menuArchivo, menuVer, menuAcercaDe;
    private JMenuItem abrirTextoItem, abrirPDFItem, salirItem, verEtiquetasItem,
            desarrolladoresItem;
    
    public MenuPrincipal(){
        super("PDF Generator :v :v");
        
        
                //*****************Ventana interna**************************
        escritorio= new JDesktopPane();  //Crea el panel de escritorio, es como el panel de la ventana Padre, 
//        que almacenará ventanas hijas
        add(escritorio);  //Añadimos el panel padre a la ventana
        escritorio.setBackground(Color.DARK_GRAY);
        
        barra= new JMenuBar();//Instanciamos nuestra barra de menu
        
        menuArchivo= new JMenu("Archivo");
        menuArchivo.setMnemonic('A');
        barra.add(menuArchivo); //Añadimos el menuArchivo a la barra de menus
        
        abrirTextoItem= new JMenuItem("Abrir Texto");
        abrirTextoItem.addActionListener(new HandlerAbrirTexto());
        menuArchivo.add(abrirTextoItem); //lo añadimos al menuArchivo el item de menu abrirTextoItem
        
        abrirPDFItem= new JMenuItem("Aabrir PDF");
        abrirPDFItem.addActionListener(new HandlerAbrirPDF());
        menuArchivo.add(abrirPDFItem);
        
        salirItem= new JMenuItem("Salir");
        menuArchivo.add(salirItem);
        salirItem.addActionListener(new ActionListener(){ //Clase interna anonima
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Hasta Pronto Compa :v \n:)");
                System.exit(0);
            }
        }); //Fin de la clase anonima para salirItem
               
        menuVer= new JMenu("Ver Etiquetas");
        menuVer.setMnemonic('V');
        barra.add(menuVer);
        
        verEtiquetasItem= new JMenuItem("Significado");
        verEtiquetasItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Etiquetas que dan forma al documento:\n" +
                    "{T} Esta etiqueta nos sirve para producir un Titulo, "
                        + "el texto que compone el titulo es el que esta entre esta etiqueta y "
                        + "su etiqueta de cierre.\n No se pueden contener etiquetas dentro del texto del titulo.\n" +
                    "{P} Esta etiqueta nos sirve para producir un Párrafo, "
                        + "el texto que compone el párrafo es el que esta entre esta etiqueta y"
                        + " su etiqueta de cierre.\n Esta etiqueta solo puede contener etiquetas que "
                        + "le den forma al texto.\n" +
                    "{I} Esta etiqueta nos sirve para agregar una imagen al documento."
                        + " El nombre del archivo de la imagen debe es el que esta entre esta etiqueta y su cierre.\n" +
                    "{C} Esta etiqueta nos sirve para producir un titulo que indique"
                        + " el inicio de un capitulo, el texto que compone el titulo del capitulo\n"
                        + " es el que esta entre esta etiqueta y su etiqueta de cierre."
                        + " No se pueden contener etiquetas dentro del texto del titulo.\n" +
                    "{S} Esta etiqueta nos sirve para producir un titulo que indique el "
                        + "inicio de una sección ó sub-capitulo, el texto que compone el titulo\n"
                        + " dela sección es el que esta entre esta etiqueta y su etiqueta de cierre."
                        + " No se pueden contener etiquetas dentro del texto del titulo.\n \n" +
                    "Etiquetas que dan formato al texto:\n" +
                    "{b} Esta etiqueta nos sirve para indicar que el texto"
                        + " entre esta etiqueta y su cierre debe de estar en negritas.\n" +
                    "{i} Esta etiqueta nos sirve para indicar que el texto"
                        + " entre esta etiqueta y su cierre debe de estar en itálica.\n" +
                    "{u} Esta etiqueta nos sirve para indicar que el texto"
                        + " entre esta etiqueta y su cierre debe de estar subrayado.\n" +
                    "{n} Esta etiqueta nos sirve para indicar un cambio de linea, no lleva etiqueta de cierre.");
            }
            
        });
        menuVer.add(verEtiquetasItem);
        
        
        menuAcercaDe= new JMenu("Acerca de...");
        menuAcercaDe.setMnemonic('D');
        barra.add(menuAcercaDe);
        
        desarrolladoresItem= new JMenuItem("Desarrolladores");
        desarrolladoresItem.addActionListener((ActionEvent ae) -> {
            //Clase interna anónima
            JOptionPane.showMessageDialog(null, "Desarroladores de la aplicación:\n"
                    + "-> Daniel Dávalos Romero\n");
        });// fin de la clase interna anónima por medio de una expresión Lambda
        menuAcercaDe.add(desarrolladoresItem);  
    
        setJMenuBar(barra); //Añadimos labarra al frame
        
    }//Fin del constructor
    
    private class HandlerAbrirTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            JInternalFrame marcoInterno= new JInternalFrame("Archivo .TXT",
                    true, true, true, true);

            PanelText panelAux= new PanelText();
            marcoInterno.add(panelAux);
            marcoInterno.pack();//Establece el frame intern al tamaño del contenido
            //En caso de que no dimensione correctamente la ventana
            marcoInterno.setSize(600, 450);
            escritorio.add(marcoInterno);
            marcoInterno.setVisible(true);
        }
        
    }
    
    private class HandlerAbrirPDF implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            JInternalFrame marcoInterno= new JInternalFrame("Archivo .PDF :O",
                        true, true, true, true);
                
                PanelPDF panelAux= new PanelPDF();
                marcoInterno.add(panelAux);
                marcoInterno.pack();//Establece el frame intern al tamaño del contenido
                escritorio.add(marcoInterno);
                marcoInterno.setVisible(true);
                
//            JOptionPane.showMessageDialog(null, "Probando escucha");
        }
        
    }// fin de la clase HandlerAbrirPDF
    
    private class HandlerEditarTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
        
    }
    
    private class HandlerBotonGenerar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
        
    }
    
}//Fin de la clase menuPrincipal

//Modulo de prueba de la ventana
class testMenuPrincipal{
    
    public static void main(String[] args){
        MenuPrincipal app= new MenuPrincipal();
        app.setSize(900, 650);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        app.setLocationRelativeTo(null);
        
        app.setVisible(true);
    }
}
