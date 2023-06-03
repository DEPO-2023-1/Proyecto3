package GUI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
//import java.awt.GridLayout;//

public class PanelNorteLogin extends JPanel{

    private JLabel titulo;
    
    public PanelNorteLogin(){

        titulo = new JLabel("LOG IN");
        
        Font auxFont=titulo.getFont();

        titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
        add(titulo);

    }
}
