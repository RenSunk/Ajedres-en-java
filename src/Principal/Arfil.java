package Principal;

public class Arfil extends Fichas{

	private Panel panel;
	
	public Arfil(int pocisionX, int posicionY) {
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
				if(i < getPocisionX() && j > getPosicionY()) {
					
					if(j > peon[k][k2].getPosicionY() && getPosicionY() < peon[k][k2].getPosicionY() && getPocisionX() > peon[k][k2].getPocisionX() && i < peon[k][k2].getPocisionX()) {
						//derecha-arriba
						System.out.println(peon[k][k2].getPocisionX()+","+peon[k][k2].getPosicionY()+"\n"+getPocisionX()+","+getPosicionY()+"\n"+i+","+j);
							pasa++;
					}
					
				}else if(i < getPocisionX() && j < getPosicionY()) {
					if(j < peon[k][k2].getPosicionY() && getPosicionY() > peon[k][k2].getPosicionY()) {
						if(getPocisionX() > peon[k][k2].getPocisionX() && i < peon[k][k2].getPocisionX()) {//izquierda-arriba
							pasa++;
						}
					}
				}else if(i > getPocisionX() && j < getPosicionY()) {
					if(j < peon[k][k2].getPosicionY() && getPosicionY() > peon[k][k2].getPosicionY()) {
						if(getPocisionX() < peon[k][k2].getPocisionX() && i > peon[k][k2].getPocisionX()) {//izquierda-abajo
							pasa++;
						}
					}
				}else if(i > getPocisionX() && j > getPosicionY()) {
					if(j > peon[k][k2].getPosicionY() && getPosicionY() < peon[k][k2].getPosicionY()) {
						if(getPocisionX() < peon[k][k2].getPocisionX() && i > peon[k][k2].getPocisionX()) {//derecha-abajo
							pasa++;
						}
					}
				}else {
					pasa++;
				}
			}
		}
		
		
		//cambiar la posicion del arfil
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
