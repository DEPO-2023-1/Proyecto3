package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelCentroEmple extends JPanel implements ActionListener{
	
	private static final String op1 = "Agregar consumo";
	private static final String manual = "Pagar consumo";
	private static final String actualizar = "Facturar";
	private static final String salir = "Salir";
	private InterfazLogin interfaz;

	private JButton agregarConsumo;
	private JButton pagoConsumo;
	private JButton facturar;
	private JButton salirr;
	
	public PanelCentroEmple(InterfazLogin interfaz) {

		this.interfaz = interfaz;
		
		setLayout(null);
		
		agregarConsumo = new JButton("Agregar consumo");
		agregarConsumo.setBounds(150, 180, 160, 50);
		agregarConsumo.addActionListener(this);
		agregarConsumo.setActionCommand(op1);
		
		pagoConsumo = new JButton("PAGO CONSUMO");
		pagoConsumo.setBounds(750, 180, 160, 50);
		pagoConsumo.addActionListener(this);
		pagoConsumo.setActionCommand(manual);
		
		facturar = new JButton("FACTURAR");
		facturar.setBounds(450, 325, 160, 50);
		facturar.addActionListener(this);
		facturar.setActionCommand(actualizar);
		
		salirr = new JButton("SALIR");
		salirr.setBounds(150, 480, 160, 50);
		salirr.addActionListener(this);
		salirr.setActionCommand(salir);

		
		add(agregarConsumo);
		add(pagoConsumo);
		add(facturar);
		add(salirr);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		if (grito.equals(op1)) {
			
			String habitacion = JOptionPane.showInputDialog("Ingrese el numero de la habitación");
			String[] arreglo = {"Cocina", "Otro"};
			int tipoSer = JOptionPane.showOptionDialog(null, "Tipo de servicio", "Elija el tipo", 0, JOptionPane.QUESTION_MESSAGE, null, arreglo, "Cocina");
			String servicio = JOptionPane.showInputDialog("Ingrese el nombre del servicio");
			String[] resultado = interfaz.agregarConsumo(habitacion, servicio, tipoSer);

			JOptionPane.showMessageDialog(null, "Consumo de " + resultado[0] + " Cargado a la habitacion " + resultado[1], grito, 1, null);
			
			
		}
		
	}
}