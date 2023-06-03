package GUI;

import javax.swing.JFrame;

import java.awt.*;

public class InterfazMenuAdmin extends JFrame{

    private PanelNorteAdmin PanelNorte;
    private PanelSurAdmin PanelSur;
    private InterfazLogin interfaz;

    public InterfazMenuAdmin(InterfazLogin interfaz){

        this.interfaz=interfaz;
        PanelNorte = new PanelNorteAdmin();
        PanelSur = new PanelSurAdmin(interfaz);

        setLayout(new BorderLayout());
		add(PanelNorte, BorderLayout.NORTH);
		add(PanelSur, BorderLayout.CENTER);

        setSize(new Dimension(1000, 850));
        setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}


