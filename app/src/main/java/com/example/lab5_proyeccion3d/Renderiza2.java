package com.example.lab5_proyeccion3d;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.lab5_proyeccion3d.Cuaternion.ArcBall;
import com.example.lab5_proyeccion3d.Cuaternion.Cuaternion;
import com.example.lab5_proyeccion3d.Cuaternion.Matriz4;
import com.example.lab5_proyeccion3d.FenceGate.Gate1;
import com.example.lab5_proyeccion3d.FenceGate.Gate2;
import com.example.lab5_proyeccion3d.FenceGate.GateLarge;
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
 * @version 1.0 13/03/2014
 *
 */
public class Renderiza2 extends GLSurfaceView implements Renderer {

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

	float rotZ = 0;
//	float rotX = 0;
//	float rotY = 0;

	private float rotX;
	private float rotY;
	private float antX;
	private float antY;

	private Context ctx;


	//CUATERNION
	private int ancho, alto;
	
	private ArcBall arcBall = new ArcBall(640.0f, 480.0f);
	private float[] MatrizRotacion = new float[16];
	private float[] B = new float[16];
    
    public Renderiza2(Context contexto) {
        super(contexto);
		this.ctx = contexto;
        /* Se inicia el renderizado */
        this.setRenderer(this);
        /* La ventana solicita recibir una entrada */
        this.requestFocus();
        /* Se establece que la ventana detecte el modo táctil */
        this.setFocusableInTouchMode(true);
        /* Se renderizará al inicio o cuando se llame a requestRender() */
        this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {

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
		
		
		
		
		
		Matriz4.identidad(B);
		/* Deshabilita dithering, no se limita la paleta de colores */
		gl.glDisable(GL10.GL_DITHER);
		/* Habilita el modo de sombreado plano */
		gl.glShadeModel(GL10.GL_FLAT);
		/* Habilita el ocultamiento de superficies */
		gl.glEnable(GL10.GL_DEPTH_TEST);
		/* Limpia el buffer de profundidad con el valor de 1.0 */
		gl.glClearDepthf(1.0f);
		/* Acepta si valor Z de entrada es igual al valor Z del buffer de profundidad */
		gl.glDepthFunc(GL10.GL_LEQUAL);
		/* Color de fondo */
		gl.glClearColor(0, 0, 0, 0);
	}
	
	@Override
	public void onDrawFrame(GL10 gl) {

		/* Inicializa el buffer de color */
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		gl.glLoadIdentity();
		gl.glMultMatrixf(MatrizRotacion, 0);


		gl.glPushMatrix();
		gl.glTranslatef(0, 0, 0);
		gl.glRotatef(rotY, 1.0f, 0.0f, 0.0f);
		gl.glRotatef(rotX, 0.0f, 1.0f, 0.0f);
//		gl.glRotatef(rotZ, 0.0f, 0.0f, 1.0f);
//		gl.glScalef(0.8f,0.8f,0.8f);
		rectangulo2.dibuja(gl);
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

			gl.glTranslatef(30, -3, -100);
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

			gl.glTranslatef(80, 0, 20);
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

	}
	
	@Override
	public void onSurfaceChanged(GL10 gl, int w, int h) {
	 
		ancho = w;
		alto = h;
		
		/* Ventana de despliegue */
		gl.glViewport(0, 0, w, h);
	 
		/* Matriz de Proyecci�n */
		gl.glMatrixMode(GL10.GL_PROJECTION);
	 
		/* Inicializa la Matriz de Proyecci�n */
		gl.glLoadIdentity();
	 
		/* Proyecci�n paralela */
		//          -x, x, -y, y, -z, z
		gl.glOrthof(-80, 80, -120, 120, -200, 200);
	 
		/* Matriz del Modelo-Vista */
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		/* Inicializa la Matriz del Modelo-Vista */
		gl.glLoadIdentity();
		Matriz4.identidad(MatrizRotacion);
		/* Ajusta el ancho a [-1..1] y el alto a [-1..1] */
		arcBall.ajusta(ancho, alto);
	}

    @Override
    public boolean onTouchEvent(MotionEvent e) {
    	float x = e.getX();
		float y = e.getY();
		switch (e.getAction()) {
			case MotionEvent.ACTION_DOWN:
			/* B = MatrizRotacion */
			Matriz4.copia(B, MatrizRotacion);
			arcBall.primerPunto(x, y);
			break;
			case MotionEvent.ACTION_MOVE:
			/* Actualiza el segundo vector y obtiene el cuaterni�n */
			Cuaternion q = arcBall.segundoPunto(x, y);
			/* Convierte el cuaterni�n a una matriz de rotaci�n */
			Cuaternion.rota(MatrizRotacion, q);
			/* MatrizRotacion = MatrizRotacion * B */
			Matriz4.multiplica(MatrizRotacion, MatrizRotacion, B);
			requestRender();
		}
		return true;
	}
}
