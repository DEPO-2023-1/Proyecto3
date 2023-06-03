package GUI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelNorteAdmin extends JPanel{
    private JLabel titulo;

    public PanelNorteAdmin(){

        titulo = new JLabel("HOTEL");
        
        Font auxFont=titulo.getFont();

        titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 60));
        add(titulo);

    }
}
