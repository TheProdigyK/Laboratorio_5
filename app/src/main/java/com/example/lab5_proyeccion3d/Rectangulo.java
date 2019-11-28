package com.example.lab5_proyeccion3d;

import android.view.MotionEvent;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Clase Triangulo (OpenGL 1.x)
 * 
 * Con arreglos de v�rtices, colores e �ndices
 * 
 * @author Jhonny Felipez
 * @version 1.0 13/03/2014
 * 
 */
public class Rectangulo {
	
	

	/* Coordenadas cartesianas (x, y, z) */
	private float vertices[] = new float [] {

			//Base
			-2,  1, -1,		//0 A
			 2,  1, -1,		//1 B
			 2, -1, -1,		//2 C
			-2, -1, -1,		//3 D

			//ARRIBA
			-2,  1,  1,		//4 E
			 2,  1,  1,		//5 F

			//IZQUIERDA
			-2,  1,  1,		//6 G
			-2, -1,  1,		//7 H

			//DERECHA
			 2,  1,  1,		//8 I
			 2, -1,  1,		//9 J

			//ABAJO
			 2, -1,  1,		//10 K
			-2, -1,  1,		//11 L

			// TECHO
			-2,  1,  1,		//12 A
			 2,  1,  1,		//13 B
			 2, -1,  1,		//14 C
			-2, -1,  1,		//15 D

			//IZQUIERDA

			-1,  0,  2,		//16 E

			//DERECHA

			 1,  0,  2,		//17 F

			//ARRIBA

			 1,  0,  2,		//18 G
			-1,  0,  2,		//19 H

			//ABAJO

			-1,  0,  2,		//20 I
			 1,	 0,	 2,		//21 J


			//PUERTA

			1f, -1.001f, -0.75f,					//22 M
			1.5f, -1.001f, -0.75f,					//23 N
			1.5f, -1.001f, 0.5f,					//24 O
			1f, -1.001f, 0.5f,						//25 P

			//VENTANA

			-0f, -1.005f, 0.75f,				//26 Q
			-0f, -1.005f, -0.75f,				//27 R
			-1.5f, -1.005f, -0.75f,				//28 S
			-1.5f, -1.005f, 0.75f,				//29 T

			//PISO
			-4, 4, -1.001f,				//30 U
			4, 4, -1.001f,				//31 V
			4, -3, -1.001f,				//32 W
			-4, -3, -1.001f,			//33 Z











	};

	byte maxColor = (byte)255;
	
	/* Los colores x c/v�rtice (r,g,b,a) */
	private byte colores[] = new byte[] {

			//base
			maxColor, 0, 0, 1, // 0
			maxColor, 0, 0, 1, // 1
			maxColor, 0, 0, 1, // 2
			maxColor, 0, 0, 1, // 3


			maxColor, 0, 0, 1, // 0
			maxColor, 0, 0, 1, // 1

			0, 0, maxColor, 1, // 0
			0, 0, maxColor, 1, // 1


			0, 0, maxColor, 1, // 0
			0, 0, maxColor, 1, // 1


			maxColor, 0, 0, 1, // 0
			maxColor, 0, 0, 1, // 1

//			(byte) 153, 0, 0, 1, // 0
//			(byte) 153, 0, 0, 1, // 1
//
//			(byte) 153, 0, 0, 1, // 0
//			(byte) 153, 0, 0, 1, // 1
//
//
//			(byte) 153, 0, 0, 1, // 0
//			(byte) 153, 0, 0, 1, // 1
//
//
//			(byte) 153, 0, 0, 1, // 0
//			(byte) 153, 0, 0, 1, // 1



			//TECHO
//			(byte) 102, (byte) 51, 0, 1, // 0
//			(byte) 102, (byte) 51, 0, 1, // 0
//			(byte) 102, (byte) 51, 0, 1, // 0
//			(byte) 102, (byte) 51, 0, 1, // 0
//
//			(byte) 102, (byte) 51, 0, 1, // 0
//			(byte) 102, (byte) 51, 0, 1, // 0
//
//			(byte) 102, (byte) 51, 0, 1, // 0
//			(byte) 102, (byte) 51, 0, 1, // 0
//
//
//			(byte) 102, (byte) 51, 0, 1, // 0
//			(byte) 102, (byte) 51, 0, 1, // 0

			(byte) 102, (byte) 51, 0, 1, // 0
			(byte) 102, (byte) 51, 0, 1, // 0
			(byte) 102, (byte) 51, 0, 1, // 0
			(byte) 102, (byte) 51, 0, 1, // 0

			maxColor, maxColor, 0, 1, // 0

			maxColor, maxColor, 0, 1, // 0

			(byte) 102, (byte) 51, 0, 1, // 0
			(byte) 102, (byte) 51, 0, 1, // 0

			(byte) 102, (byte) 51, 0, 1, // 0
			(byte) 102, (byte) 51, 0, 1, // 0



			maxColor, maxColor, maxColor, 1, // 1
			maxColor, maxColor, maxColor, 1, // 1
			maxColor, maxColor, maxColor, 1, // 1
			maxColor, maxColor, maxColor, 1, // 1

			maxColor, maxColor, maxColor, 1, // 1
			maxColor, maxColor, maxColor, 1, // 1
			maxColor, maxColor, maxColor, 1, // 1
			maxColor, maxColor, maxColor, 1, // 1


			//PISO
			0, maxColor, 0, 1,
			0, maxColor, 0, 1,
			0, maxColor, 0, 1,
			0, maxColor, 0, 1,





	};
	

	
	/* Indices */
	private short indices[] = new short [] {

			//BASE
			0, 1, 2, 0, 2, 3,
			0, 1, 5, 0, 5, 4,
			0, 3, 7, 0, 7, 6,
			1, 2, 9, 1, 9, 8,
			2, 3, 11, 2, 11, 10,

			//TECHO
			12, 13, 14, 12, 14, 15,
			12, 15, 16,
			13, 14, 17,
			12, 13, 19, 13, 18, 19,
			14, 15, 21, 15, 20, 21,

			//PUERTA
			22, 23, 24, 22, 24, 25,

			//VENTANA
			26, 27, 28, 26, 28, 29,

			//PISO
			30, 31, 32, 30, 32, 33,




	};
	
	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;

	public Rectangulo() {
		
		/* Lee los v�rtices */
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte nativo
		bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
		bufVertices.put(vertices);
		bufVertices.rewind(); // puntero al principio del buffer

		/* Lee los colores */
		bufColores = ByteBuffer.allocateDirect(colores.length);
		bufColores.put(colores);
		bufColores.position(0); // puntero al principio del buffer
		
		/* Lee los indices */
		bufByte = ByteBuffer.allocateDirect(indices.length * 2);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
		bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
		bufIndices.put(indices);
		bufIndices.rewind(); // puntero al principio del buffer
		
	}
	
	public void dibuja(GL10 gl) {
		
		/* Se habilita el acceso al arreglo de v�rtices */
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

		/* Se habilita el acceso al arreglo de colores */
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		
		/* Se especifica los datos del arreglo de v�rtices */
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);

		/* Se especifica los datos del arreglo de colores */
		gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);

		/* Renderiza las primitivas desde los datos de los arreglos (v�rtices,
		 * colores e �ndices) */
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);

		/* Se deshabilita el acceso al arreglo de v�rtices */
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		//* Se deshabilita el acceso al arreglo de colores */
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		
	}


}
