package Principal;

import javax.swing.JOptionPane;

public class Torre extends Fichas {

	private Panel panel;
	
	public Torre(int pocisionX, int posicionY) {
		super(pocisionX, posicionY);
	}

	public boolean jugar(int i, int j, int turnot, Torre[][] torre, Peon[][] peon, Panel mipanel) {
		this.panel= mipanel;
		int pasa = 0;
		int enemigas;
		
		if(turnot == 0) {
			enemigas = 1;
		}else {
			enemigas = 0;
		}
		
		setPocisionXAntigua(getPocisionX());
		setPosicionYantigua(getPosicionY());
		
		//detectar peon
		for (int k = 0; k < peon.length; k++) {
			for (int k2 = 0; k2 < peon[0].length; k2++) {
				if(i < getPocisionX() && j == getPosicionY()) {
					if(j == peon[k][k2].getPosicionY()) {
						if(peon[k][k2].getPocisionX() < getPocisionX() && peon[k][k2].getPocisionX() > i) {//arriba
							pasa++;
						}
					}
				}else if(i > getPocisionX() && j == getPosicionY()) {
					if(j == peon[k][k2].getPosicionY()) {
						if(peon[k][k2].getPocisionX() > getPocisionX() && peon[k][k2].getPocisionX() < i) {//abajo
							pasa++;
						}
					}
				}else if(i == getPocisionX() && j > getPosicionY()) {//derecha
					if(i == peon[k][k2].getPocisionX()) {
						if(getPosicionY() < peon[k][k2].getPosicionY() && j > peon[k][k2].getPosicionY()) {
							pasa++;
						}
					}
				}else if(i == getPocisionX() && j < getPosicionY()) {//izquierda
					if(i == peon[k][k2].getPocisionX()) {
						if(getPosicionY() > peon[k][k2].getPosicionY() && j < peon[k][k2].getPosicionY()) {
							pasa++;
						}
					}
				}else {
					pasa++;
				}				
			}
		}
		for (int k2 = 0; k2 < peon[0].length; k2++) {
			//eliminar peon
			if(j == peon[enemigas][k2].getPosicionY() && i == peon[enemigas][k2].getPocisionX() && pasa == 0) {
				peon[enemigas][k2].setPocisionX(50);
				peon[enemigas][k2].setPosicionY(50);
				peon[enemigas][k2].setEliminado(true);
				panel.set_peones(peon[enemigas]);
			}
		}
		for (int k2 = 0; k2 < peon[0].length; k2++) {
			//evitar los peones aliados
			if(j == peon[turnot][k2].getPosicionY() && i == peon[turnot][k2].getPocisionX() && pasa == 0) {
				pasa++;
			}
		}
		//detectar torre
		for (int k = 0; k < torre.length; k++) {
			for (int k2 = 0; k2 < torre[0].length; k2++) {
				if(i < getPocisionX() && j == getPosicionY()) {
					if(j == torre[k][k2].getPosicionY()) {
						if(torre[k][k2].getPocisionX() < getPocisionX() && torre[k][k2].getPocisionX() > i) {//arriba
							pasa++;
						}
					}
				}else if(i > getPocisionX() && j == getPosicionY()) {
					if(j == torre[k][k2].getPosicionY()) {
						if(torre[k][k2].getPocisionX() > getPocisionX() && torre[k][k2].getPocisionX() < i) {//abajo
							pasa++;
						}
					}
				}else if(i == getPocisionX() && j > getPosicionY()) {//derecha
					if(i == torre[k][k2].getPocisionX()) {
						if(getPosicionY() < torre[k][k2].getPosicionY() && j > torre[k][k2].getPosicionY()) {
							pasa++;
						}
					}
				}else if(i == getPocisionX() && j < getPosicionY()) {//izquierda
					if(i == torre[k][k2].getPocisionX()) {
						if(getPosicionY() > torre[k][k2].getPosicionY() && j < torre[k][k2].getPosicionY()) {
							pasa++;
						}
					}
				}else {
					pasa++;
				}				
			}
		}
		
		for (int k2 = 0; k2 < torre[0].length; k2++) {
			//eliminar Torres
			if(j == torre[enemigas][k2].getPosicionY() && i == torre[enemigas][k2].getPocisionX() && pasa == 0) {
				torre[enemigas][k2].setPocisionX(50);
				torre[enemigas][k2].setPosicionY(50);
				torre[enemigas][k2].setEliminado(true);
				panel.set_torres(torre[enemigas]);
			}
		}
		for (int k2 = 0; k2 < torre[0].length; k2++) {
			//evitar los Torres aliados
			if(j == torre[turnot][k2].getPosicionY() && i == torre[turnot][k2].getPocisionX() && pasa == 0) {
				pasa++;
			}
		}
		
		
		//cambiar la posicion de la torre
		if(pasa == 0) {
			setPocisionX(i);
			setPosicionY(j);
			return true;
		}
		return false;
	}

	public boolean mover(int i, int j) {
		setPocisionX(i);
		setPosicionY(j);
		return true;
	}

}
