package Principal;

public class Peon extends Fichas {

	private Panel mipanel;

	public Peon(int pocisionX, int posicionY) {
		super(pocisionX, posicionY);
	}

	public boolean jugar(int x, int y, int turno, Peon[] enemigosP) {
		setPocisionXAntigua(getPocisionX());
		setPosicionYantigua(getPosicionY());

		if (turno == 0) {
			// movimiento de los peones negros

			if (getPocisionX() == 1 && getPosicionY() == y) {
				if (getPocisionX() + 2 == x && getPosicionY() == y) {
					setPocisionX(x);
					setPosicionY(y);
					return true;
				}
			}
			boolean pasa = true;
			if (getPocisionX() + 1 == x && getPosicionY() == y) {
				for (int i = 0; i < enemigosP.length; i++) {
					if (enemigosP[i].getPocisionX() == x && enemigosP[i].getPosicionY() == y) {
						pasa = false;
					}
				}
				if (pasa) {
					setPocisionX(x);
					setPosicionY(y);
					return true;
				}
			}
			// movimiento de eliminacion de los peones negros
		} else {
			// movimiento de los peones blancos
			if (getPocisionX() == 6) {
				if (getPocisionX() - 2 == x && getPosicionY() == y) {
					setPocisionX(x);
					setPosicionY(y);
					return true;
				}
			}
			boolean pasa = true;
			if (getPocisionX() - 1 == x && getPosicionY() == y) {
				for (int i = 0; i < enemigosP.length; i++) {
					if (enemigosP[i].getPocisionX() == x && enemigosP[i].getPosicionY() == y) {
						pasa = false;
					}
				}
				if (pasa) {
					setPocisionX(x);
					setPosicionY(y);
					return true;
				}
			}
			// movimiento de eliminacion de los peones blancos
		}
		return false;
	}

	public boolean eliminaciones_peones(int x, int y, int turno, Peon[] enemigosP, Panel miPanel) {
		boolean pasa = false;
		if (turno == 0) {
			// eliminciones para las negras
			if (getPocisionX() + 1 == x && getPosicionY() + 1 == y) {
				for (int i = 0; i < enemigosP.length && !pasa; i++) {
					if (enemigosP[i].getPocisionX() == x && enemigosP[i].getPosicionY() == y) {
						algoritmo_para_eliminar_peones(turno, x, y, enemigosP, i, miPanel);
						pasa = true;
						return true;
					}
				}
			} else if (getPocisionX() + 1 == x && getPosicionY() - 1 == y) {
				for (int i = 0; i < enemigosP.length && !pasa; i++) {
					if (enemigosP[i].getPocisionX() == x && enemigosP[i].getPosicionY() == y) {
						algoritmo_para_eliminar_peones(turno, x, y, enemigosP, i, miPanel);
						pasa = true;
						return true;
					}
				}
			}
		} else {
			// eliminacion para las blanca
			if (getPocisionX() - 1 == x && getPosicionY() + 1 == y) {
				for (int i = 0; i < enemigosP.length && !pasa; i++) {
					if (enemigosP[i].getPocisionX() == x && enemigosP[i].getPosicionY() == y) {
						algoritmo_para_eliminar_peones(turno, x, y, enemigosP, i, miPanel);
						pasa = true;
						return true;
					}
				}
			} else if (getPocisionX() - 1 == x && getPosicionY() - 1 == y) {
				for (int i = 0; i < enemigosP.length && !pasa; i++) {
					if (enemigosP[i].getPocisionX() == x && enemigosP[i].getPosicionY() == y) {
						algoritmo_para_eliminar_peones(turno, x, y, enemigosP, i, miPanel);
						pasa = true;
						return true;
					}
				}
			}
		}
		return false;
	}

	public void algoritmo_para_eliminar_peones(int turno, int x, int y, Peon[] enemigosP, int i, Panel miPanel) {
		this.mipanel = miPanel;
		setPocisionX(x);
		setPosicionY(y);
		enemigosP[i].setEliminado(true);
		enemigosP[i].setPocisionX(50);
		enemigosP[i].setPosicionY(50);
		miPanel.set_peones(enemigosP);
	}
}
