package Principal;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;

public class Panel extends JPanel implements ActionListener {

	private JButton boton[][];
	private final int filas = 8, columnas = 8;
	@SuppressWarnings("unused")
	private Principal principal;
	private final int Njugadores = 2;
	private final int Npeon = 8;
	private final int Ntorre = 2;
	private final int Narfil = 2;
	private String turno = "blancas";
	private Peon peon[][];
	private Torre torre[][];
	private Arfil arfil[][];
	private boolean movimiento = false;
	private int turnot, ienemigas;

	public void set_peones(Peon enemigas[]) {
		peon[ienemigas] = enemigas;
	}

	public void set_torres(Torre enemigas[]) {
		torre[ienemigas] = enemigas;
	}
	
	public Panel(Principal Pprincipal) {
		principal = Pprincipal;
		iniciar();
		alinear();
		ajustarFichas();
		DibujarEnLosBotones();

	}

	public void iniciar() {
		boton = new JButton[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				boton[i][j] = new JButton();
				boton[i][j].setBorderPainted(false);
				boton[i][j].setContentAreaFilled(false);
				boton[i][j].setOpaque(false);
				boton[i][j].addActionListener(this);
			}
		}
		peon = new Peon[Njugadores][Npeon];
		torre = new Torre[Njugadores][Ntorre];
		arfil = new Arfil[Njugadores][Narfil];
		
	}

	public void alinear() {
		setLayout(new GridLayout(8, 8));
		for (int i = 0; i < boton.length; i++) {
			for (int j = 0; j < boton.length; j++) {
				add(boton[i][j]);
			}
		}
	}
	
	public void ajustarFichas() {
		for (int i = 0; i < columnas; i++) {
			peon[0][i] = new Peon(1, i);
		}
		for (int i = 0; i < columnas; i++) {
			peon[1][i] = new Peon(6, i);
		}

//		peon[1][0].setPocisionX(4);
//		peon[1][0].setPosicionY(4);
//		
//		peon[1][1].setPocisionX(3);
//		peon[1][1].setPosicionY(5);
//		
//		peon[1][7].setPocisionX(4);
//		peon[1][7].setPosicionY(0);
//		
//		peon[1][5].setPocisionX(5);
//		peon[1][5].setPosicionY(5);
//		
//		peon[1][7].setPocisionX(4);
//		peon[1][7].setPosicionY(6);
		
		
		
		torre[0][0] = new Torre(0, 0);
		torre[0][1] = new Torre(0, 7);

		torre[1][0] = new Torre(7, 0);
		torre[1][1] = new Torre(7, 7);
		
		arfil[0][0] = new Arfil(0, 2);
		arfil[0][1] = new Arfil(0, 5);
		
		arfil[1][0] = new Arfil(7, 2);
		arfil[1][1] = new Arfil(7, 5);
		
	}

	public void DibujarEnLosBotones() {
		String imagen;
		for (int i2 = 0; i2 < Njugadores; i2++) {

			for (int j2 = 0; j2 < Npeon; j2++) {

				if (!peon[i2][j2].isEliminado()) {

					if (i2 == 0) {
						imagen = "./datos/imagenes/PeonNegro.png";
					} else {
						imagen = "./datos/imagenes/PeonBlanco.png";
					}
					boton[peon[i2][j2].getPocisionX()][peon[i2][j2].getPosicionY()].setIcon(new ImageIcon(imagen));
				}
			}

			for (int j2 = 0; j2 < Ntorre; j2++) {

				if (!torre[i2][j2].isEliminado()) {

					if (i2 == 0) {
						imagen = "./datos/imagenes/TorreNegra.png";
					} else {
						imagen = "./datos/imagenes/TorreBlanca.png";
					}
					boton[torre[i2][j2].getPocisionX()][torre[i2][j2].getPosicionY()].setIcon(new ImageIcon(imagen));
				}
			}
			
			for (int j2 = 0; j2 < Narfil; j2++) {

				if (!arfil[i2][j2].isEliminado()) {

					if (i2 == 0) {
						imagen = "./datos/imagenes/ArfilNegro.png";
					} else {
						imagen = "./datos/imagenes/ArfilBlanco.png";
					}
					boton[arfil[i2][j2].getPocisionX()][arfil[i2][j2].getPosicionY()].setIcon(new ImageIcon(imagen));
				}
			}
			
		}
	}
	

	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g.drawImage(new ImageIcon("./datos/imagenes/Tablero.png").getImage(), 0, 0, 480, 480, new ImageObserver() {

			public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
				return false;
			}
		});
	}

	// metodos de las fichas

	

	public void cambiar_turnos() {
		// System.out.println(turno);
		DibujarEnLosBotones();
		movimiento = false;
		
		
		if (turno.equals("negras")) {
			turnot = 0;
			turno = "blancas";
		} else if (turno.equals("blancas")) {
			turnot = 1;
			turno = "negras";
		}

	}

	public void terminar_procesos_peones(int h) {
		peon[turnot][h].setSelector(false);
		boton[peon[turnot][h].getPocisionXAntigua()][peon[turnot][h].getPosicionYantigua()].setIcon(new ImageIcon(""));
	}
	
	public void terminar_procesos_torres(int h) {
		torre[turnot][h].setSelector(false);
		boton[torre[turnot][h].getPocisionXAntigua()][torre[turnot][h].getPosicionYantigua()].setIcon(new ImageIcon(""));
	}
	
	public void terminar_procesos_arfiles(int h) {
		arfil[turnot][h].setSelector(false);
		boton[arfil[turnot][h].getPocisionXAntigua()][arfil[turnot][h].getPosicionYantigua()].setIcon(new ImageIcon(""));
	}
	
	public void de_seleccionar() {
		for (int k = 0; k < Njugadores; k++) {
			for (int k2 = 0; k2 < Npeon; k2++) {
				peon[k][k2].setSelector(false);
			}
		}
		
		for (int k = 0; k < Njugadores; k++) {
			for (int k2 = 0; k2 < Ntorre; k2++) {
				torre[k][k2].setSelector(false);
			}
		}
		
		for (int k = 0; k < Njugadores; k++) {
			for (int k2 = 0; k2 < Ntorre; k2++) {
				arfil[k][k2].setSelector(false);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < boton.length; i++) {
			for (int j = 0; j < boton.length; j++) {
				if (boton[i][j] == e.getSource()) {

					if (turno.equals("negras")) {
						turnot = 0;
						ienemigas = 1;
					} else {
						turnot = 1;
						ienemigas = 0;
					}

					// cambiar el estado de la ficha a seleccionado
					for (int i2 = 0; i2 < Njugadores; i2++) {
						for (int j2 = 0; j2 < Npeon; j2++) {
							if (peon[i2][j2].getPocisionX() == i && peon[i2][j2].getPosicionY() == j && i2 != turnot
									&& !peon[i2][j2].isEliminado()) {
								if (!movimiento) {
									JOptionPane.showMessageDialog(principal, "Turno De Las " + turno);
								}
							}
						}
						for (int j2 = 0; j2 < Ntorre; j2++) {
							if (torre[i2][j2].getPocisionX() == i && torre[i2][j2].getPosicionY() == j && i2 != turnot
									&& !torre[i2][j2].isEliminado()) {
								if (!movimiento) {
									JOptionPane.showMessageDialog(principal, "Turno De Las " + turno);
								}
							}
						}
						for (int j2 = 0; j2 < Narfil; j2++) {
							if (arfil[i2][j2].getPocisionX() == i && arfil[i2][j2].getPosicionY() == j && i2 != turnot
									&& !torre[i2][j2].isEliminado()) {
								if (!movimiento) {
									JOptionPane.showMessageDialog(principal, "Turno De Las " + turno);
								}
							}
						}
					}

					// peones{
					for (int h = 0; h < Npeon; h++) {
						if (i == peon[turnot][h].getPocisionX() && j == peon[turnot][h].getPosicionY()) {
							for (int k = 0; k < boton.length; k++) {
								if (!peon[turnot][k].isEliminado()) {
									peon[turnot][h].setSelector(true);
									movimiento = true;
								}
							}
						} else {
							// inicia la verificaciones y empieza la jugada de las fichas{
							if (peon[turnot][h].isSelector()) {
								if (peon[turnot][h].jugar(i, j, turnot, peon[ienemigas])) {
									terminar_procesos_peones(h);
									cambiar_turnos();
								} else {
									if (peon[turnot][h].eliminaciones_peones(i, j, turnot, peon[ienemigas],this)) {
										terminar_procesos_peones(h);
										cambiar_turnos();
										
									} else {
										de_seleccionar();
										movimiento = false;
										JOptionPane.showMessageDialog(principal, "Jugada No Valida :)");
									}
								}
							}
							// }
						}
					}
					// }

					// torres{
					for (int h = 0; h < Ntorre; h++) {
						if (i == torre[turnot][h].getPocisionX() && j == torre[turnot][h].getPosicionY()) {
							for (int k = 0; k < Ntorre; k++) {
								if (!torre[turnot][k].isEliminado()) {
									torre[turnot][h].setSelector(true);
									movimiento = true;
								}
							}
						} else {
							if (torre[turnot][h].isSelector()) {
								if (torre[turnot][h].jugar(i, j, turnot, torre,peon,this)) {
									terminar_procesos_torres(h);
									cambiar_turnos();
								}else {
									de_seleccionar();
									movimiento = false;
									JOptionPane.showMessageDialog(principal, "Jugada No Valida :)");
								}
							}
						}
					}
					// }
					
					// arfiles{
					for (int h = 0; h < Narfil; h++) {
						if (i == arfil[turnot][h].getPocisionX() && j == arfil[turnot][h].getPosicionY()) {
							for (int k = 0; k < Narfil; k++) {
								if (!arfil[turnot][k].isEliminado()) {
									arfil[turnot][h].setSelector(true);
									movimiento = true;
								}
							}
						} else {
							if (arfil[turnot][h].isSelector()) {
								if (arfil[turnot][h].jugar(i, j, turnot, torre,peon,this)) {
									terminar_procesos_arfiles(h);
									cambiar_turnos();
								}else {
									de_seleccionar();
									movimiento = false;
									JOptionPane.showMessageDialog(principal, "Jugada No Valida :)");
								}
							}
						}
					}
					// }
				}
			}
		}
	}
}
