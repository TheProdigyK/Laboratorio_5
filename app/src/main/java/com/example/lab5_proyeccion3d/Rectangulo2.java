package com.example.lab5_proyeccion3d;

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
public class Rectangulo2 {



	/* Coordenadas cartesianas (x, y, z) */
	private float vertices[] = new float [] {
			-70, 0, -120,
			70, 0, -120,
			-70, 0, 120,
			70, 0, 120,






	};

	byte maxColor = (byte)255;

	/* Los colores x c/v�rtice (r,g,b,a) */
	private byte colores[] = new byte[] {

			//base
			(byte) 45, (byte)  100, (byte) 51, 1, // 0
			(byte) 45, (byte)  100, (byte) 51, 1, // 1
			(byte) 45, (byte)  100, (byte) 51, 1, // 2
			(byte) 239, (byte) 239, (byte) 239, 1, // 3

	};



	/* Indices */
	private short indices[] = new short [] {
		//PISO
			0, 1, 3, 0, 3, 2
	};

	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;

	public Rectangulo2() {
		
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
