package com.example.lab5_proyeccion3d;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.view.MotionEvent;

import com.example.lab5_proyeccion3d.FenceGate.Gate1;
import com.example.lab5_proyeccion3d.FenceGate.Gate2;
import com.example.lab5_proyeccion3d.FenceGate.GateLarge;
import com.example.lab5_proyeccion3d.Lab5.Cubo;
import com.example.lab5_proyeccion3d.Lab5.Piso;
import com.example.lab5_proyeccion3d.Sprunce.Arbol1;
import com.example.lab5_proyeccion3d.Sprunce.Arbol2;
import com.example.lab5_proyeccion3d.Sprunce.Arbol3;
import com.example.lab5_proyeccion3d.Sprunce.SprunceWood;
import com.example.lab5_proyeccion3d.Tree.Tree1;
import com.example.lab5_proyeccion3d.Tree.Tree2;
import com.example.lab5_proyeccion3d.Tree.Tree3;
import com.example.lab5_proyeccion3d.Tree.TreeWood;

/**
 * Clase Renderiza (OpenGL 1.x)
 * 
 * @author Jhonny Felipez
 * @version 1.0 02/04/2014
 *
 */
public class Renderiza extends GLSurfaceView implements Renderer {

	/* Objeto */
	private Cubo cubo;
	private Piso piso;
	private Circulo circulo;
	
	/* Inicializa ubicaci�n de la vista del observador */
	private final float[] vectorEntrada = { 0, 0, -1, 1 };
	private static float posicion[] = { 0, 0, 0 };
	private final float[] direccion = new float[4];

	/* Tama�o de la ventana en pixeles */
	private int alto;
	private int ancho;
	
	/* Para la rotaci�n y traslaci�n */
	private float rotY;
	private	float antX;
	
	final float[] matriz = new float[16];

	//
	// DISEÑO//
	//		//
	/* Objeto */
	private Rectangulo piramide;
	private Rectangulo2 rectangulo2;
	private Lineas lineas;
	private Punto punto;

	private Objexample2 objexample;

	//Diseños
	private Arbol1 arbol1;
	private Arbol2 arbol2;
	private Arbol3 arbol3;
	private SprunceWood sprunceWood;

	private Tree1 tree1;
	private Tree2 tree2;
	private Tree3 tree3;
	private TreeWood treeWood;

	private Gate1 gate1;
	private Gate2 gate2;

	private GateLarge gateLarge;

	private House house;

	private Context ctx;
	
	/* Contexto */
	Context contexto;
	
	public Renderiza(Context contexto) {
		super(contexto);
		this.contexto = contexto;
		this.ctx = contexto;
		this.setRenderer(this);
		this.requestFocus();
		this.setFocusableInTouchMode(true);
		this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
		
		cubo = new Cubo();
		piso = new Piso();
		circulo = new Circulo(5f, 360, true);

		//diseños//

		piramide = new Rectangulo();
		lineas = new Lineas();
		punto = new Punto();

		objexample = new Objexample2(ctx);

		rectangulo2 = new Rectangulo2();

		//OBJ
		arbol1 = new Arbol1(ctx);
		arbol2 = new Arbol2(ctx);
		arbol3 = new Arbol3(ctx);
		sprunceWood = new SprunceWood(ctx);

		tree1 = new Tree1(ctx);
		tree2 = new Tree2(ctx);
		tree3 = new Tree3(ctx);
		treeWood = new TreeWood(ctx);

		gate1 = new Gate1(ctx);
		gate2 = new Gate2(ctx);

		gateLarge = new GateLarge(ctx);

		house = new House(ctx);

        
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glClearColor(180/255f, 255/255f, 247/256f, 0);

	}
	
	@Override
	public void onDrawFrame(GL10 gl) {

		/* Borra el buffer de la ventana y del z-buffer */
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		/* Botones de las opciones */
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrthof(-80, 80, -120, 120, -200, 200);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		
		// Bot�n avanza
		gl.glPushMatrix();
		gl.glTranslatef(0, -95, 0);
		circulo.dibuja(gl);
		gl.glPopMatrix();
		
		// Bot�n retrocede
		gl.glPushMatrix();
		gl.glTranslatef(0, -110f, 0);
		circulo.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluPerspective(gl, 67, ancho / (float)alto, 1f, 200f);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glRotatef(-rotY, 0, 1, 0);
		gl.glTranslatef(-posicion[0], -posicion[1], -posicion[2]);
		// Piso
		gl.glPushMatrix();
		gl.glTranslatef(0, 0, -6);

		gl.glPopMatrix();

		// Piso
		gl.glPushMatrix();
		gl.glTranslatef(-100, -10, 0);
		//gl.glRotatef(-1, 0, 0, 1);
		rectangulo2.dibuja(gl);
//		gl.glPopMatrix();
//
//		gl.glPushMatrix();
//		gl.glTranslatef(100, 0, 0);
//		gl.glRotatef(0, 0, 0, 1);
			gl.glPushMatrix();

			gl.glTranslatef(0, 0, 0);
			gl.glScalef(0.23f,0.23f,0.23f);
			house.dibuja(gl);

			gl.glPopMatrix();

			gl.glPushMatrix();

			gl.glTranslatef(-50, -3, 100);
			gl.glScalef(4f,4f,4f);
			arbol1.dibuja(gl);


			gl.glPopMatrix();

			gl.glPushMatrix();

			gl.glTranslatef(-10, -3, 100);
			gl.glScalef(4f,4f,4f);
			arbol1.dibuja(gl);


			gl.glPopMatrix();

			gl.glPushMatrix();

			gl.glTranslatef(-50, -3, 60);
			gl.glScalef(5.5f,5.5f,5.5f);
			arbol1.dibuja(gl);


			gl.glPopMatrix();

			gl.glPushMatrix();

			gl.glTranslatef(30, 0, 60);
			gl.glScalef(5f,5f,5f);
			arbol2.dibuja(gl);


			gl.glPopMatrix();

			gl.glPushMatrix();

			gl.glTranslatef(10, 0, 100);
			gl.glScalef(4f,4f,4f);
			arbol2.dibuja(gl);

			gl.glPopMatrix();


			gl.glPushMatrix();

			gl.glTranslatef(30, -5, -100);
			gl.glScalef(6f,6f,6f);
			arbol3.dibuja(gl);


			gl.glPopMatrix();

			gl.glPushMatrix();

			gl.glTranslatef(50, -3, -70);
			gl.glScalef(4f,4f,4f);
			arbol3.dibuja(gl);

			gl.glPopMatrix();


			gl.glPushMatrix();

			gl.glTranslatef(-10, -3, -100);
			gl.glScalef(4f,4f,4f);
			arbol3.dibuja(gl);


			gl.glPopMatrix();

			gl.glPushMatrix();

			gl.glTranslatef(35, -5, 100);
			gl.glScalef(4f,4f,4f);
			sprunceWood.dibuja(gl);

			gl.glPopMatrix();

			gl.glPushMatrix();

			gl.glTranslatef(40, -5, 100);
			gl.glScalef(4f,4f,4f);
			sprunceWood.dibuja(gl);

			gl.glPopMatrix();

			gl.glPushMatrix();

			gl.glTranslatef(45, -5, 100);
			gl.glScalef(4f,4f,4f);
			sprunceWood.dibuja(gl);

			gl.glPopMatrix();


			gl.glPushMatrix();

			gl.glTranslatef(-50, -8, -30);
			gl.glScalef(4f,4f,4f);
			tree1.dibuja(gl);

			gl.glPopMatrix();


			gl.glPushMatrix();

			gl.glTranslatef(-37, -8, -50);
			gl.glScalef(5f,5f,5f);
			tree1.dibuja(gl);

			gl.glPopMatrix();


			gl.glPushMatrix();

			gl.glTranslatef(-35, -8, -50);
			gl.glScalef(4f,4f,4f);
			tree2.dibuja(gl);

			gl.glPopMatrix();

			gl.glPushMatrix();

			gl.glTranslatef(60, -8, 0);
			gl.glScalef(4f,4f,4f);
			tree3.dibuja(gl);

			gl.glPopMatrix();


			gl.glPushMatrix();

			gl.glTranslatef(60, -8, 40);
			gl.glScalef(4f,4f,4f);
			tree3.dibuja(gl);

			gl.glPopMatrix();


			gl.glPushMatrix();

			gl.glTranslatef(80, -5, 20);
			gl.glScalef(4f,4f,4f);
			treeWood.dibuja(gl);

			gl.glPopMatrix();


			gl.glPushMatrix();

			gl.glTranslatef(50, -3, 20);
			gl.glScalef(4f,4f,4f);
			gateLarge.dibuja(gl);

			gl.glPopMatrix();

			gl.glPushMatrix();

			gl.glTranslatef(80, -3, -65);
			gl.glRotatef(90,0,1,0);
			gl.glScalef(4f,4f,4f);
			gateLarge.dibuja(gl);

			gl.glPopMatrix();

			gl.glPushMatrix();

			gl.glTranslatef(80, -3, -35);
			gl.glRotatef(90,0,1,0);
			gl.glScalef(4f,4f,4f);
			gateLarge.dibuja(gl);


			gl.glPopMatrix();

			gl.glPushMatrix();

			gl.glTranslatef(50, -3, 90);
			gl.glScalef(4f,4f,4f);
			gateLarge.dibuja(gl);

			gl.glPopMatrix();

		gl.glPopMatrix();





		gl.glFlush();

	}
	
	@Override
	public void onSurfaceChanged(GL10 gl, int w, int h) {
		
		ancho = w;
		alto = h;
		
		gl.glViewport(0, 0, ancho, alto);
		
		GLU.gluLookAt(gl, 0, 0, 0, 0, 0, -1, 0, 1, 0);

	}
	
	/**
	 * Maneja los eventos del movimiento en la pantalla t�ctil. 
	 */
	@Override
	public boolean onTouchEvent(MotionEvent e) {
		
		/* Obtiene la coordenada de la pantalla */
		float posx = e.getX();
		float posy = e.getY();
		
		/* Se considera cuando se levanta el dedo de la pantalla. */ 
		if (e.getAction() == MotionEvent.ACTION_MOVE) {
			
			/* En coordenadas del OpenGL */
			//gl.glOrthof(-80, 80, -120, 120, -200, 200);
			posx = ((posx / (float) ancho) * 160) - 80;
			posy = ((1 - posy / (float) alto) * 240) - 120;

			/* Verifica �rea elegida */
			if (puntoEstaDentroDelCirculo(posx, posy, 0, -95f, 5f)) { // Avanza
				Matrix.setIdentityM(matriz, 0);
				Matrix.rotateM(matriz, 0, rotY, 0, 1, 0);
				Matrix.multiplyMV(direccion, 0, matriz, 0, vectorEntrada, 0);
				
				posicion[0] = posicion[0] + direccion[0] * 1f;
				posicion[1] = posicion[1] + direccion[1] * 1f;
				posicion[2] = posicion[2] + direccion[2] * 1f;
				
			} else if (puntoEstaDentroDelCirculo(posx, posy, 0, -110f, 5f)) { // Retrocede
				Matrix.setIdentityM(matriz, 0);
				Matrix.rotateM(matriz, 0, rotY, 0, 1, 0);
				Matrix.multiplyMV(direccion, 0, matriz, 0, vectorEntrada, 0);
				
				posicion[0] = posicion[0] - direccion[0] * 1f;
				posicion[1] = posicion[1] - direccion[1] * 1f;
				posicion[2] = posicion[2] - direccion[2] * 1f;
			}
			if(antX == -1) {
				antX = posx;
			} else {
				rotY = rotY + (posx - antX) / 2;
				antX = posx;
			}
			requestRender();
		} else {
			antX = -1;
		}	
		return true;
	}
	
	private boolean puntoEstaDentroDelCirculo(float posx, float posy, float x,
			float y, float radio) {
		return (distancia2(posx, posy, x, y) < radio * radio);
	}

	public float distancia2(float x1, float y1, float x2, float y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
}
