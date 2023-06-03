package GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelSurLogin extends JPanel implements ActionListener{

    private static final String LOGIN = "login";
    private final static String ADMIN = "admin";
	private final static String EMPLEADO = "empleado";
	private final static String RECEPCIONISTA= "recepcionista";
	private JLabel labAdmin;
	private JLabel labEmpleado;
	private JLabel labRecepcionista;
	private JRadioButton butAdmin;
	private JRadioButton butEmpleado;
	private JRadioButton butRecepcionista;
	private JButton butLogin;
	private InterfazLogin interfaz;
	private int tipo;

    public PanelSurLogin(InterfazLogin interfaz){
    	tipo = 1;
    	
    	this.interfaz = interfaz;
    	
    	labAdmin = new JLabel("        Administrador:");
		labRecepcionista = new JLabel("          Resepcionista:");
		labEmpleado = new JLabel("        Empleado:");
		
		
		butAdmin = new JRadioButton();
		butAdmin.addActionListener(this);
		butAdmin.setActionCommand(ADMIN);	
		
		butRecepcionista = new JRadioButton();
		butRecepcionista.addActionListener(this);
		butRecepcionista.setActionCommand(RECEPCIONISTA);	

		butEmpleado = new JRadioButton();
		butEmpleado.addActionListener(this);
		butEmpleado.setActionCommand(EMPLEADO);	
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(butAdmin);
		grupo.add(butRecepcionista);
		grupo.add(butEmpleado);
        
		butLogin = new JButton("Login");
		butLogin.addActionListener(this);
		butLogin.setActionCommand(LOGIN);

        add(labAdmin);
        add(butAdmin);
        add(labRecepcionista);
        add(butRecepcionista);
		add(labEmpleado);
        add(butEmpleado);
        add(butLogin);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		if (grito.equals(ADMIN)) {
			tipo = 1;
		}
		
		if (grito.equals(RECEPCIONISTA)) {
			tipo = 2;
		}
		
		if (grito.equals(EMPLEADO)) {
			tipo = 3;
		}
		
		if (grito.equals(LOGIN)) {
			
			boolean x = interfaz.login(tipo);
			
			if (x == false){
			JOptionPane.showInternalMessageDialog(null, "Usuario y/o contraseña incorrectas", "error", 1, null);
			
		}
	
		}
		
	}
    
}
