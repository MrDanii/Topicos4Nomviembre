package pruebas;

import display.PanelPDF;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Daniel
 */
public class TestPanelPDF extends JFrame{
    PanelPDF verPDF= new PanelPDF();
        
    
    public TestPanelPDF(){
        super("Ventana de prueba");
        setLayout(new BorderLayout());
        
        add(verPDF, BorderLayout.CENTER);
        
    }
    
    public void iniciarVentanaPDF(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(500, 500);
        setLocationRelativeTo(null); //para centra la ventana
        setVisible(true);
    }
    
    public static void main(String[] args){
        TestPanelPDF verPDF= new TestPanelPDF();
        verPDF.iniciarVentanaPDF();
        
        
    }
}
