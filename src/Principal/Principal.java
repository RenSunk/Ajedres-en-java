package Principal;

import javax.swing.JFrame;

public class Principal extends JFrame{
	
	private final int ALTO=510,ANCHO=489;
	
	private Panel panel;
	
	public Principal() {
		super("Ajedres");
		iniciar();
		alinear();
		setResizable(false);
		setSize(ANCHO,ALTO);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
		setLocationRelativeTo(null);
	}
	
	public void iniciar() {
		panel = new Panel(this);
	}
	
	public void ActualizarBotones() {
		panel.DibujarEnLosBotones();
	}
	
	public void alinear() {
		add(panel);
	}
	
	public static void main(String[] args) {
		new Principal();
	}
	
}
