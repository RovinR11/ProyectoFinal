package clases;

import java.util.HashMap;

import javax.swing.JOptionPane;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Enemigo extends Dimenciones {
	private boolean capturado;
	private HashMap<String, Animacion> animaciones;
	//Coordenadas para el fragmento de la imagen a pintar
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	
	public Enemigo(int x, int y, String indiceImagen, int velocidad, String animacionActual) {
		super(x, y, indiceImagen, velocidad, animacionActual);
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		this.animacionActual = animacionActual;
		inicializarEnemigo();
	}
	
	
	//Obtener las coordenas del fragmento de la imagen a pintar
	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
	
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x, this.y,
				this.anchoImagen, this.altoImagen
		);
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	
	public void inicializarEnemigo() {
			animaciones = new HashMap<String, Animacion>();	
			Rectangle coordenadasVolar[]= {
					new Rectangle(0, 71, 169, 66),
					new Rectangle(0, 71, 169, 66),
					new Rectangle(191, 64, 194, 80),
					new Rectangle(191, 64, 194, 80),
					new Rectangle(387, 1, 160, 146),
					new Rectangle(387, 1, 160, 146),
					new Rectangle(12, 184, 156, 104),
					new Rectangle(12, 184, 156, 104),
					new Rectangle(196, 179, 152, 156),
					new Rectangle(373, 175, 191, 122),
					new Rectangle(381, 334, 179, 72),
				
			};
					
			Animacion animacionVolar = new Animacion("volar",coordenadasVolar,0.10);
			animaciones.put("volar",animacionVolar);
	}
	
	public void verificarColisiones(Enemigo enemigo) {
		if (this.obtenerRectangulo().intersects(enemigo.obtenerRectangulo().getBoundsInLocal())) {
				if (!enemigo.isCapturado())
					this.puntuacion--;
					JOptionPane.showMessageDialog(null, "El juego termino");
				enemigo.setCapturado(true);				
		}
	}
	
	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
	
}
