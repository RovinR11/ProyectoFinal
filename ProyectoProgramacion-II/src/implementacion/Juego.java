package implementacion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import clases.Enemigo;
import clases.Item;
import clases.JugadorAnimado;
import clases.Puntuacion;
import clases.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Juego extends Application{
	private Scene escena;
	private Group root;
	private Canvas canvas;
	private GraphicsContext graficos;
	private JugadorAnimado jugadorAnimado;
	private Enemigo enemigo;
	public static boolean derecha=false;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static boolean abajo=false;
	
	public static HashMap<String, Image> imagenes;
	private Item item;
	private Item item2;
	private Item item3;
	private Item item4;
	private Item item5;
	private Item item6;
	private Item item7;
	private Item item8;
	private Item item9;
	private Item item10;
	private Item item11;
	private Item item12;
	private Item item13;
	private Item item14;
	
	private ArrayList<Tile> tiles;
	private int[][] mapa = {
			{1,2,3,4,5,0,0}, {0,0,0,0,0,0,0},  {0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}, {10,9,7,6,8,0,0}, {0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}, {0,0,0,0,0,0,0},  {15,14,13,12,11,0,0},
	        {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0},  {0,0,0,0,0,0,0},
			{1,2,3,4,5,0,0}, {0,0,0,0,0,0,0},  {0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}, {10,9,7,6,8,0,0}, {0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}, {0,0,0,0,0,0,0},  {15,14,13,12,11,0,0},
			{0,0,0,0,0,0,0}, {0,0,0,0,0,0,0},  {0,0,0,0,0,0,0},
			{1,2,3,4,5,0,0}, {0,0,0,0,0,0,0},  {0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}, {10,9,7,6,8,0,0}, {0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}, {0,0,0,0,0,0,0},  {15,14,13,12,11,0,0},
			{0,0,0,0,0,0,0}, {0,0,0,0,0,0,0},  {0,0,0,0,0,0,0},
			{1,2,3,4,5,0,0}, {0,0,0,0,0,0,0},  {0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}, {10,9,7,6,8,0,0}, {0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}, {0,0,0,0,0,0,0},  {15,14,13,12,11,0,0},
			{0,0,0,0,0,0,0}, {0,0,0,0,0,0,0},  {0,0,0,0,0,0,0},
			{1,2,3,4,5,0,0}, {0,0,0,0,0,0,0},  {0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}, {10,9,7,6,8,0,0}, {0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}, {0,0,0,0,0,0,0},  {15,14,13,12,11,0,0},};
	        
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		graficos = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		ventana.setScene(escena);
		ventana.setTitle("Game Learn to Fly");
		gestionarEventos();
		ventana.show();
		cicloJuego();		
	}
	
	public void guardarRegistroArchivo() {
		Puntuacion a = new Puntuacion(JOptionPane.showInputDialog("Ingrese su nombre:"), 20);
		try {
			BufferedWriter archivo = new BufferedWriter(new FileWriter("usuario.csv", true));
			archivo.write(a.tocsv);
		    archivo.flush();
		    archivo.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public void inicializarComponentes() {
		jugadorAnimado = new JugadorAnimado(50,40,"aguila",5, "volar");
		enemigo = new Enemigo(800,180,"enemigo",5, "volar");
		root = new Group();
		escena = new Scene(root,1000,500);
		canvas  = new Canvas(1000,500);
		imagenes = new HashMap<String,Image>();
		item = new Item(600,100,0,0,"item");
		item2 = new Item(200,100,0,0,"item");
		item3 = new Item(300,100,0,0,"item");
		item4 = new Item(400,100,0,0,"item");
		item5 = new Item(500,100,0,0,"item");
		item6 = new Item(700,100,0,0,"item");
		item7 = new Item(800,100,0,0,"item");
		item8 = new Item(900,100,0,0,"item");
		item9 = new Item(200,300,0,0,"item");
		item10 = new Item(300,300,0,0,"item");
		item11 = new Item(400,300,0,0,"item");
		item12 = new Item(500,300,0,0,"item");
		item13 = new Item(600,300,0,0,"item");
		item14 = new Item(700,300,0,0,"item");
		cargarImagenes();
		cargarTiles();
	}
	
	public void cargarImagenes() {
		imagenes.put("tilemap", new Image("tilemap.png"));
		imagenes.put("aguila", new Image("aguila.png"));
		imagenes.put("enemigo", new Image("enemigo.png"));
		imagenes.put("item", new Image("item.png"));
	}
	
	public void pintar() {
		graficos.setFill(Color.GRAY);
		graficos.fillRect(0, 0, 1000, 500);
		graficos.setFill(Color.BLACK);
				
		///Pintar tiles
		for (int i=0;i<tiles.size();i++)
		tiles.get(i).pintar(graficos);
		item.pintar(graficos);
		item2.pintar(graficos);
		item3.pintar(graficos);
		item4.pintar(graficos);
		item5.pintar(graficos);
		item6.pintar(graficos);
		item7.pintar(graficos);
		item8.pintar(graficos);
		item9.pintar(graficos);
		item10.pintar(graficos);
		item11.pintar(graficos);
		item12.pintar(graficos);
		item13.pintar(graficos);
		item14.pintar(graficos);
		jugadorAnimado.pintar(graficos);
		enemigo.pintar(graficos);
		

	}
	
	public void cargarTiles() {
		tiles = new ArrayList<Tile>();
		for(int i=0; i<mapa.length; i++) {
			for(int j=0; j<mapa[i].length; j++) {
				if (mapa[i][j]!=0)
					tiles.add(new Tile(mapa[i][j], i*100, j*100, "tilemap",0));
			}
		}
	}
	
	public void gestionarEventos() {
		//Evento cuando se presiona una tecla
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
					//Codigo para identificar cuando se presiono una tecla
					switch (evento.getCode().toString()) {
						case "RIGHT": //derecha
							derecha=true;
							break;
						case "LEFT": //izquieda
							izquierda=true;
							//izquierda=true;
						break;
						case "UP":
							arriba=true;
							break;
						case "DOWN":
							abajo=true;
							break;
						case "SPACE":
							jugadorAnimado.setVelocidad(10);
							jugadorAnimado.setIndiceImagen("aguila");
							break;
					}
			}			
		});
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				//Codigo para identificar cuando se soltó una tecla
				switch (evento.getCode().toString()) {
				case "RIGHT": //derecha
					derecha=false;
					break;
				case "LEFT": //izquierda
					izquierda=false;
				break;
				case "UP":
					arriba=false;
					break;
				case "DOWN":
					abajo=false;
					break;
				case "SPACE":
					jugadorAnimado.setVelocidad(1);
					jugadorAnimado.setIndiceImagen("aguila");
					break;
			}
				
			}
			
		});
		
	}
	
	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			//Esta rutina simula un ciclo de 60FPS
			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoInicial) / 1000000000.0;
				pintar();
				actualizar(t);
				
			}
			
		};
		animationTimer.start(); //Inicia el ciclo
	}
	
	public void actualizar(double t) {
		jugadorAnimado.mover();
		enemigo.actualizarAnimacion(t);
		jugadorAnimado.actualizarAnimacion(t);
		jugadorAnimado.verificarColisiones(item);
		jugadorAnimado.verificarColisiones(item2);
		jugadorAnimado.verificarColisiones(item3);
		jugadorAnimado.verificarColisiones(item4);
		jugadorAnimado.verificarColisiones(item5);
		jugadorAnimado.verificarColisiones(item6);
		jugadorAnimado.verificarColisiones(item7);
		jugadorAnimado.verificarColisiones(item8);
		jugadorAnimado.verificarColisiones(item9);
		jugadorAnimado.verificarColisiones(item10);
		jugadorAnimado.verificarColisiones(item11);
		jugadorAnimado.verificarColisiones(item12);
		jugadorAnimado.verificarColisiones(item13);
		jugadorAnimado.verificarColisiones(item14);
			
	}

}