package documentos;

/**
 *  Se implementará una pila que maneje las etiquetas
 * y además una
 * @author Daniel
 */
public class ManejadorEtiquetas {
    //Etiquetas que dan formato al documento(después de ellas hay un salto de linea)
    String[] etiquetasDocApertura={"{T}", "{P}", "{I}", "{C}", "{S}"};
    String[] etiquetasDocCierre={"{#T}", "{#P}", "{#I}", "{#C}", "{#S}"};
    //Etiquetas que dan formato al texto(pueden combinarse varias, y dentro de las etiquetas
    //que dan formato al documento y no hay salto de línea)
    String[] etiquetasTextApertura={"{b}", "{i}", "{u}", "{n}"};
    String[] etiquetasTextCierre={"{#b}", "{#i}", "{#u}", "{#n}"};
}
