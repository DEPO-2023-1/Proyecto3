package GUI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
//import java.awt.GridLayout;//

public class PanelNorteEmple extends JPanel{

    private JLabel titulo;
    
    public PanelNorteEmple(){

        titulo = new JLabel("MENU EMPLEADOS");
        
        Font auxFont=titulo.getFont();

        titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
        add(titulo);

    }
}