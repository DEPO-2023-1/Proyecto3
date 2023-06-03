package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelSurCargaManual extends JPanel implements ActionListener{
	
	private static final String habitaciones = "CARGAR INFO HABITACIONES";
	private static final String servicios = "CARGAR INFO SERVICIOS";
	private InterfazLogin interfaz;

	
	private JButton habitacionesButton;
	private JButton serviciosButton;
	
	public PanelSurCargaManual(InterfazLogin interfaz) {
		this.interfaz=interfaz;
		
		setLayout(null);
		
		habitacionesButton = new JButton("CARGAR INFO HABITACIONES");
		habitacionesButton.setBounds(100, 280, 300, 100);
		habitacionesButton.addActionListener(this);
		habitacionesButton.setActionCommand(habitaciones);
		
		serviciosButton = new JButton("CARGAR INFO SERVICIOS");
		serviciosButton.setBounds(600, 280, 300, 100);
		serviciosButton.addActionListener(this);
		serviciosButton.setActionCommand(servicios);

		
		add(habitacionesButton);
		add(serviciosButton);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		if (grito.equals(habitaciones)) {
			
			String idHabitacion = JOptionPane.showInputDialog("Ingrese el ID de la habitacion");
			String tipo = JOptionPane.showInputDialog("Ingrese el tipo de la habitacion");
			String ubicacion = JOptionPane.showInputDialog("Ingrese la ubicacion de la habitacion");
			int capacidadNino = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad maxima de niños de la habitacion"));
			int capaciodadAdulto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad maxima de adultos de la habitacion"));
			Boolean balcon = Boolean.parseBoolean(JOptionPane.showInputDialog("Ingrese true si la habitacion tiene Balcon, si no ingrese false"));
			Boolean cocina = Boolean.parseBoolean(JOptionPane.showInputDialog("Ingrese true si la habitacion tiene Cocina, si no ingrese false"));
			Boolean vista = Boolean.parseBoolean(JOptionPane.showInputDialog("Ingrese true si la habitacion tiene Vista, si no ingrese false"));
			float PrecioI = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio base de la habitacion"));
			interfaz.cargarHabitacionesManual(idHabitacion, tipo, ubicacion, capacidadNino, capaciodadAdulto, balcon, cocina, vista, PrecioI);
            JOptionPane.showMessageDialog(interfaz,"Se cargaron los archivos con exito");
		}
		if (grito.equals(servicios)) {
			
			String tipo = JOptionPane.showInputDialog("Ingrese si es menu del comedor o del servicio a la habitacion");
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
			float precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio base del producto"));
			String horaInicio = JOptionPane.showInputDialog("Ingrese el la hora de inicio de disponibilidad del producto");
			String horaFinal = JOptionPane.showInputDialog("Ingrese el la hora final de disponibilidad del producto");
            interfaz.cargarServiciosManual(tipo, nombre, precio, horaInicio, horaFinal);
            JOptionPane.showMessageDialog(interfaz,"Se cargaron los archivos con exito");

		}
		
	}
		
		
}


