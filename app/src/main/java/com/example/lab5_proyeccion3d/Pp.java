package com.example.lab5_proyeccion3d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;
public class Pp {
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
-2, 1, -1, // 0		//A
2, 1, -1, // 1		//B
2, -1, -1, // 2		//C
-2, -1, -1, // 3	//D

-2, 1, 1, // 4		//E
2, 1, 1, // 5		//F
2, 1, 1, // 6		//G
2, 1, 1, // 7		//H
2, -1, 1,// 8		//I
-2, -1, 1, //9		//J
-2, -1, 1, //10		//K
-2, 1, 1 //11		//L

};
/* Indices */
private short indices[] = new short [] {
		0, 1, 1, 2, 2, 0,	//BASE
		1, 2, 2, 3, 3, 1,
		0, 1, 1, 5, 5, 0,	//ARRIBA
		0, 4, 4, 5, 5, 0,
		1, 2, 2, 6, 6, 1,	//DERECHA
		2, 6, 6, 7, 7, 2,
		2, 3, 3, 8, 8, 2,	//ABAJO
		3, 8, 8, 9, 9, 3,
		0, 3, 3, 10, 10, 0,	//IZQUIERDA
		0, 10, 10, 11, 11, 0
		
};
private FloatBuffer bufVertices;
private ShortBuffer bufIndices;
public Pp() {
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
public void dibuja(GL10 gl, boolean malla) {
/* Se habilita el acceso al arreglo de v�rtices */
gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
/* Se especifica los datos del arreglo de v�rtices */
gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
/* Se establece el color en (r,g,b,a) */
gl.glColor4f(0, 1, 0, 0);
/* Dibuja el cubo */
gl.glDrawElements(GL10.GL_LINES, indices.length,
GL10.GL_UNSIGNED_SHORT, bufIndices);
/* Se deshabilita el acceso al arreglo de v�rtices */
gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
}
}