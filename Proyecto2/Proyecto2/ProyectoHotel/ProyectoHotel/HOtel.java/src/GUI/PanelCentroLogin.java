package GUI;
import javax.swing.*;
import java.awt.*;


public class PanelCentroLogin extends JPanel{

	
    private JLabel lbNum1;
	private JLabel lbNum2;
	
	private JTextField txtNum1;
	private JTextField txtNum2;
	
	
	
	
	public PanelCentroLogin() {

		setPreferredSize(new Dimension(800,300));
		
		lbNum1 = new JLabel("Usuario: ");
		lbNum1.setPreferredSize(new Dimension(400, 100));
		
		txtNum1 = new JTextField();
		txtNum1 .setPreferredSize(new Dimension(400, 50));

		lbNum2 = new JLabel("Contraseña");
		lbNum2.setPreferredSize(new Dimension(400, 100));
		
		txtNum2 = new JTextField();
		txtNum2 .setPreferredSize(new Dimension(400, 50));
		
		

		setLayout(new FlowLayout());

		//setLayout(new GridLayout(2,2));
		
//		GridLayout gl = new GridLayout();
//		setLayout(gl);
		
		add(lbNum1);
		add(txtNum1);
		add(lbNum2);
		add(txtNum2);	

	}


	public String getTxtNum1() {
		return txtNum1.getText();
	}


	public String getTxtNum2() {
		return txtNum2.getText();
	}

	
}
