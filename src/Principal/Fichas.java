package Principal;

public class Fichas {

	private int pocisionX,posicionY,pocisionXAntigua,posicionYantigua;
	
	private boolean selector,eliminado;

	public Fichas(int pocisionX, int posicionY) {
		this.pocisionX = pocisionX;
		this.posicionY = posicionY;
		this.selector = false;
		this.eliminado = false;
	}
	
	public int getPocisionXAntigua() {
		return pocisionXAntigua;
	}

	public void setPocisionXAntigua(int pocisionXAntigua) {
		this.pocisionXAntigua = pocisionXAntigua;
	}

	public int getPosicionYantigua() {
		return posicionYantigua;
	}

	public void setPosicionYantigua(int posicionYantigua) {
		this.posicionYantigua = posicionYantigua;
	}

	public int getPocisionX() {
		return pocisionX;
	}

	public void setPocisionX(int pocisionX) {
		this.pocisionX = pocisionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	public boolean isSelector() {
		return selector;
	}

	public void setSelector(boolean selector) {
		this.selector = selector;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
}
