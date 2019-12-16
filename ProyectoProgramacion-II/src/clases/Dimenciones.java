package clases;

public class Dimenciones {
	protected int x;
	protected int y;
	protected int altoImagen;
	protected int anchoImagen;
	protected int xImagen;
	protected int yImagen;
	protected String indiceImagen;
	protected int velocidad;
	protected String animacionActual;
	protected int puntuacion = 0;

	public Dimenciones(int x, int y, int altoImagen, int anchoImagen, int xImagen, int yImagen, String indiceImagen,
			int velocidad) {

		this.x = x;
		this.y = y;
		this.altoImagen = altoImagen;
		this.anchoImagen = anchoImagen;
		this.xImagen = xImagen;
		this.yImagen = yImagen;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
	}

	public Dimenciones(int x, int y, String indiceImagen, int velocidad, String animacionActual) {

		this.x = x;
		this.y = y;
		this.animacionActual = animacionActual;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
	}

	public Dimenciones(int x, int y) {

		this.x = x;
		this.y = y;
	}

	public Dimenciones(int x, int y, String indiceImagen, int velocidad) {

		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
	}

	public String getAnimacionActual() {
		return animacionActual;
	}

	public void setAnimacionActual(String animacionActual) {
		this.animacionActual = animacionActual;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAltoImagen() {
		return altoImagen;
	}

	public void setAltoImagen(int altoImagen) {
		this.altoImagen = altoImagen;
	}

	public int getAnchoImagen() {
		return anchoImagen;
	}

	public void setAnchoImagen(int anchoImagen) {
		this.anchoImagen = anchoImagen;
	}

	public int getxImagen() {
		return xImagen;
	}

	public void setxImagen(int xImagen) {
		this.xImagen = xImagen;
	}

	public int getyImagen() {
		return yImagen;
	}

	public void setyImagen(int yImagen) {
		this.yImagen = yImagen;
	}

	public String getIndiceImagen() {
		return indiceImagen;
	}

	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String toString() {
		return "Dimenciones [x=" + x + ", y=" + y + ", altoImagen=" + altoImagen + ", anchoImagen=" + anchoImagen
				+ ", xImagen=" + xImagen + ", yImagen=" + yImagen + ", indiceImagen=" + indiceImagen + ", velocidad="
				+ velocidad + ", animacionActual=" + animacionActual + ", puntuacion=" + puntuacion + "]";
	}

}
