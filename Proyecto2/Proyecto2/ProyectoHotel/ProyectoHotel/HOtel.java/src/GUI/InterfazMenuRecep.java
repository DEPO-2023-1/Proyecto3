package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;


public class InterfazMenuRecep extends JFrame{
	
	private PanelBotonRecep boton;
	private InterfazLogin interfaz;
    private PanelNorteAdmin titulo;

    public InterfazMenuRecep(InterfazLogin interfaz){
    	this.interfaz = interfaz;
        boton = new PanelBotonRecep(interfaz);
        titulo = new PanelNorteAdmin();
        setLayout(new BorderLayout());
        
        
        add(boton);
        add(titulo, BorderLayout.NORTH);
        
        setSize(new Dimension(1000,850));
		setResizable(false);
		setTitle("Menu Empleado)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

    }
    
	
    
}
