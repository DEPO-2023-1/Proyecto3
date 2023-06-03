package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCalendario extends JPanel{
	
	private int[][] tablero;
	private ArrayList<Integer> matriz;
	private JLabel enero;

	
	public PanelCalendario(ArrayList<Integer> matriz) {
		
		setPreferredSize(new Dimension(230,100));

		enero = new JLabel("Enero");
		
		add(enero);
		
		this.matriz = matriz;
		
		
	}
	
	public void paint(Graphics g) {
		
		super.paint(g); 
		Graphics2D g2d = (Graphics2D) g; 
		
		int longitud = (int) 700/73;
		int canFilas = 73;
		int canColumnas = 5;
		
		tablero = new int[canFilas][canColumnas];
		for (int i = 0; i < canFilas; i++)
			for (int ii = 0; ii < canColumnas; ii++){
				tablero[i][ii] = 0;
		}
		
		int n = 0;
        while (n < matriz.size()) {
        	int fila = (int)5/n;
        	int columna = (int)73/fila;
			for (int df = -1; df < 2; df++)
			{
				for (int dc = -1; dc < 2; dc++)
				{
					int f = fila + df;
					int c = columna + dc;
					if (f >= 0 && f < canFilas && c >= 0 && c < canColumnas)
					{
						tablero[f][c] += 1;
					}
				}
			}
        }
        
        for (int i = 0; i < canFilas; i++)
			for (int j = 0; j < canColumnas; j++){
				if ( tablero[i][j] == 0) {
					Rectangle2D.Double Rectangulo = new Rectangle2D.Double(j*longitud+50,i*longitud,longitud,longitud);
					g2d.setColor(Color.WHITE);
					g2d.fill(Rectangulo);
					g2d.setColor(Color.BLACK);
					g2d.draw(Rectangulo);
				}
				else if ( tablero[i][j] <= 3) {
					Rectangle2D.Double Rectangulo = new Rectangle2D.Double(j*longitud+50,i*longitud,longitud,longitud);
					g2d.setColor(Color.GRAY);
					g2d.fill(Rectangulo);
					g2d.setColor(Color.BLACK);
					g2d.draw(Rectangulo);
				}
				else if ( tablero[i][j] <= 5) {
					Rectangle2D.Double Rectangulo = new Rectangle2D.Double(j*longitud+50,i*longitud,longitud,longitud);
					g2d.setColor(Color.GREEN);
					g2d.fill(Rectangulo);
					g2d.setColor(Color.BLACK);
					g2d.draw(Rectangulo);
				}
				else if ( tablero[i][j] > 5) {
					Rectangle2D.Double Rectangulo = new Rectangle2D.Double(j*longitud+50,i*longitud,longitud,longitud);
					g2d.setColor(Color.RED);
					g2d.fill(Rectangulo);
					g2d.setColor(Color.BLACK);
					g2d.draw(Rectangulo);
				}
		}
		
	}
	
	
	
	
}
