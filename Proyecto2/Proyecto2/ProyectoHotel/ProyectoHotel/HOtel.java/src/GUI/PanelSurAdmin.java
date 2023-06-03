package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelSurAdmin extends JPanel implements ActionListener{
	
	private static final String archivos = "CARGAR INFO ARCHIVOS";
	private static final String manual = "CARGAR INFO MANUAL";
	private static final String actualizar = "ACTUALIZARINFO";
	private static final String salir = "SALIR";
	private InterfazLogin interfaz;

	
	private JButton archivosButton;
	private JButton manualButton;
	private JButton actualizarButton;
	private JButton salirButton;
	
	
	public PanelSurAdmin(InterfazLogin interfaz) {
		this.interfaz=interfaz;
		
		setLayout(null);
		
		archivosButton = new JButton("CARGAR INFO ARCHIVOS");
		archivosButton.setBounds(100, 180, 300, 100);
		archivosButton.addActionListener(this);
		archivosButton.setActionCommand(archivos);
		
		manualButton = new JButton("CARGAR ARCHIVOS MANUAL");
		manualButton.setBounds(100, 380, 300, 100);
		manualButton.addActionListener(this);
		manualButton.setActionCommand(manual);
		
		actualizarButton = new JButton("ACTUALIZAR INFO");
		actualizarButton.setBounds(600, 180, 300, 100);
		actualizarButton.addActionListener(this);
		actualizarButton.setActionCommand(actualizar);
		
		salirButton = new JButton("SALIR");
		salirButton.setBounds(600, 380, 300, 100);
		salirButton.addActionListener(this);
		salirButton.setActionCommand(salir);

		
		add(archivosButton);
		add(manualButton);
		add(actualizarButton);
		add(salirButton);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		if (grito.equals(archivos)) {
			
			String habitaciones = JOptionPane.showInputDialog("Ingrese la ruta de archivo con la informacion de las habitaciones");
			String inventario = JOptionPane.showInputDialog("Ingrese la ruta de archivo con la informacion del inventario");
    		String Servicio = JOptionPane.showInputDialog("Ingrese la ruta de archivo con la informacion de los servicios");
    		String restaurante = JOptionPane.showInputDialog("Ingrese la ruta de archivo con la informacion de los productos del restaurante");
    		String temporada = JOptionPane.showInputDialog("Ingrese la ruta de archivo con la informacion de las temporada");
			interfaz.cargarHotel(habitaciones, inventario, Servicio, restaurante, temporada);
			JOptionPane.showMessageDialog(interfaz,"Se cargaron los archivos con exito");
		}
		if (grito.equals(manual)) {
			
			FrameCargaManual cargaManual = new FrameCargaManual(interfaz);
		}
		if (grito.equals(actualizar)) {
			JOptionPane.showMessageDialog(interfaz,"Esta opción no está disponible, lo sentimos");
			
		}
		if (grito.equals(salir)) {
			System.exit(0);
		}
		
		
	}
}