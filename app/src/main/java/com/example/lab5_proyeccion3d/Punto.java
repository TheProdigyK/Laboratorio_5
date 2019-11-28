package com.example.lab5_proyeccion3d;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Punto {
/**
* 3 --------- 2
* /| /|
* / | / |
* 7 --------- 6 |
* | | | |
* | 0 ------|-- 1
* | / | /
* |/ |/
* 4 --------- 5
*/
/* Coordenadas cartesianas (x, y, z) */
private float vertices[] = new float[] {
		1.15f, -1.007f, 0f,		//0




};
/* Indices */
private short indices[] = new short [] {
		0, 0

};
private FloatBuffer bufVertices;
private ShortBuffer bufIndices;
public Punto() {
/* Lee los v�rtices */
ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
bufVertices.put(vertices);
bufVertices.rewind(); // puntero al principio del buffer
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
	/* Se especifica los datos del arreglo de v�rtices */
	gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
	/* Se establece el color en (r,g,b,a) */
	gl.glColor4f(1, 0, 0, 0);
	/* Dibuja el cubo */
	gl.glDrawElements(GL10.GL_POINTS, indices.length,
	GL10.GL_UNSIGNED_SHORT, bufIndices);
	/* Se deshabilita el acceso al arreglo de v�rtices */
	gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}
}