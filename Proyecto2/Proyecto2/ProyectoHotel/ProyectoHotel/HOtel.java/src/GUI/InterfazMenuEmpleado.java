package GUI;

import javax.swing.*;
import java.awt.*;

public class InterfazMenuEmpleado extends JFrame{

    private PanelNorteEmple panelNorte;
    private PanelCentroEmple panelCentro;
    private InterfazLogin interfaz;
    

    public InterfazMenuEmpleado(InterfazLogin interfaz){

        panelNorte = new PanelNorteEmple();
        panelCentro = new PanelCentroEmple(interfaz);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panelNorte, BorderLayout.NORTH);
        mainPanel.add(panelCentro, BorderLayout.CENTER);

        add(mainPanel);

        setTitle("Menu Empleados");
        setSize(1000, 850);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

}
