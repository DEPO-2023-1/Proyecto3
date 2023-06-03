package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

public class FrameCargaManual extends JFrame{

    private PanelSurCargaManual PanelSur;
    private InterfazLogin interfaz;
    private JLabel titulo;

    public FrameCargaManual(InterfazLogin interfaz){

        this.interfaz=interfaz;
        JPanel PanelNorte = new JPanel();
        titulo = new JLabel("CARGA MANUAL");
        Font auxFont=titulo.getFont();
        titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 60));
        PanelNorte.add(titulo);

        PanelSur = new PanelSurCargaManual(interfaz);

        setLayout(new BorderLayout());
		add(PanelNorte, BorderLayout.NORTH);
		add(PanelSur, BorderLayout.CENTER);

        setSize(new Dimension(1000, 650));
        setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }
    
}

