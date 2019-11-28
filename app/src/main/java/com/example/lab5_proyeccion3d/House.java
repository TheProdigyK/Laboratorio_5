package com.example.lab5_proyeccion3d;

import android.content.Context;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class House {

    private Context context;
    ObjLoader objLoader, objLoader2, objLoader3, objLoader4, objLoader5, objLoader6, objLoader7, objLoader8,
            objLoader9, objLoader10, objLoader11, objLoader12, objLoader13, objLoader14, objLoader15;


    private FloatBuffer bufVertices;
    private ShortBuffer bufIndices, bufIndices2, bufIndices3, bufIndices4, bufIndices5, bufIndices6, bufIndices7, bufIndices8,
            bufIndices9, bufIndices10, bufIndices11, bufIndices12, bufIndices13, bufIndices14, bufIndices15;
    private ByteBuffer bufColores;



    public House(Context ctx) {
        this.context = ctx;
        /* Lee los v�rtices */

        objLoader = new ObjLoader(context, "Home/3dhome.obj"); //base
        objLoader2 = new ObjLoader(context, "Home/3dhome2.obj"); //piso plomo
        objLoader3 = new ObjLoader(context, "Home/3dhome3.obj"); //techo
        objLoader4 = new ObjLoader(context, "Home/3dhome4.obj"); //door

        objLoader5 = new ObjLoader(context, "Home/3dhome5.obj"); //GRADAS
        objLoader6 = new ObjLoader(context, "Home/3dhome6.obj"); //GRADAS
        objLoader7 = new ObjLoader(context, "Home/3dhome7.obj"); //GRADAS
        objLoader8 = new ObjLoader(context, "Home/3dhome8.obj"); //VENTANA1

        objLoader9 = new ObjLoader(context, "Home/3dhome9.obj"); //
        objLoader10 = new ObjLoader(context, "Home/3dhome10.obj"); //
        objLoader11 = new ObjLoader(context, "Home/3dhome11.obj"); //
        objLoader12 = new ObjLoader(context, "Home/3dhome12.obj"); //
        objLoader13 = new ObjLoader(context, "Home/3dhome13.obj"); //
        objLoader14 = new ObjLoader(context, "Home/3dhome14.obj"); //
        objLoader15 = new ObjLoader(context, "Home/3dhome15.obj"); //



        ByteBuffer bufByte = ByteBuffer.allocateDirect(objLoader.positions.length * 4);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
        bufVertices.put(objLoader.positions);
        bufVertices.rewind(); // puntero al principio del buffer

        /* Lee los indices */
        bufByte = ByteBuffer.allocateDirect(objLoader.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices.put(objLoader.normals);
        bufIndices.rewind(); // puntero al principio del buffer


        bufByte = ByteBuffer.allocateDirect(objLoader2.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices2 = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices2.put(objLoader2.normals);
        bufIndices2.rewind(); // puntero al principio del buffer

        bufByte = ByteBuffer.allocateDirect(objLoader3.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices3 = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices3.put(objLoader3.normals);
        bufIndices3.rewind(); // puntero al principio del buffer

        bufByte = ByteBuffer.allocateDirect(objLoader4.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices4 = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices4.put(objLoader4.normals);
        bufIndices4.rewind(); // puntero al principio del buffer

        bufByte = ByteBuffer.allocateDirect(objLoader5.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices5 = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices5.put(objLoader5.normals);
        bufIndices5.rewind(); // puntero al principio del buffer

        bufByte = ByteBuffer.allocateDirect(objLoader6.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices6 = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices6.put(objLoader6.normals);
        bufIndices6.rewind(); // puntero al principio del buffer

        bufByte = ByteBuffer.allocateDirect(objLoader7.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices7 = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices7.put(objLoader7.normals);
        bufIndices7.rewind(); // puntero al principio del buffer

        bufByte = ByteBuffer.allocateDirect(objLoader8.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices8 = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices8.put(objLoader8.normals);
        bufIndices8.rewind(); // puntero al principio del buffer

        bufByte = ByteBuffer.allocateDirect(objLoader9.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices9 = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices9.put(objLoader9.normals);
        bufIndices9.rewind(); // puntero al principio del buffer

        bufByte = ByteBuffer.allocateDirect(objLoader10.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices10 = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices10.put(objLoader10.normals);
        bufIndices10.rewind(); // puntero al principio del buffer

        bufByte = ByteBuffer.allocateDirect(objLoader11.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices11 = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices11.put(objLoader11.normals);
        bufIndices11.rewind(); // puntero al principio del buffer

        bufByte = ByteBuffer.allocateDirect(objLoader12.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices12 = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices12.put(objLoader12.normals);
        bufIndices12.rewind(); // puntero al principio del buffer

        bufByte = ByteBuffer.allocateDirect(objLoader13.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices13 = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices13.put(objLoader13.normals);
        bufIndices13.rewind(); // puntero al principio del buffer

        bufByte = ByteBuffer.allocateDirect(objLoader14.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices14 = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices14.put(objLoader14.normals);
        bufIndices14.rewind(); // puntero al principio del buffer

        bufByte = ByteBuffer.allocateDirect(objLoader15.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices15 = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices15.put(objLoader15.normals);
        bufIndices15.rewind(); // puntero al principio del buffer
    }
    public void dibuja(GL10 gl) {


        /* Se habilita el acceso al arreglo de v�rtices */
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        /* Se especifica los datos del arreglo de v�rtices */
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);

        //BASE
        gl.glColor4f(254/255f, 236/255f, 222/255f, 0);

        gl.glDrawElements(GL10.GL_TRIANGLE_FAN, objLoader.normals.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices);

        // PISO PLOMO DE ABAJO
        gl.glColor4f(167/255f, 166/255f, 164/255f, 0);

        gl.glDrawElements(GL10.GL_TRIANGLE_FAN, objLoader2.normals.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices2);

        // TECHO
        gl.glColor4f(162/255f, 29/255f, 28/255f, 0);

        gl.glDrawElements(GL10.GL_TRIANGLE_FAN, objLoader3.normals.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices3);

        // PUERTA
        gl.glColor4f(101/255f, 80/255f,63/255f, 0);

        gl.glDrawElements(GL10.GL_LINE_LOOP, objLoader4.normals.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices4);



        // GRADA1
        gl.glColor4f(142/255f, 137/255f,133/255f, 0);

        gl.glDrawElements(GL10.GL_TRIANGLE_FAN, objLoader5.normals.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices5);

        // GRADA2
        gl.glColor4f(142/255f, 137/255f,133/255f, 0);

        gl.glDrawElements(GL10.GL_TRIANGLE_FAN, objLoader6.normals.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices6);

        // GRADA3
        gl.glColor4f(142/255f, 137/255f,133/255f, 0);

        gl.glDrawElements(GL10.GL_TRIANGLE_FAN, objLoader7.normals.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices7);

        // VENTANA IZQ
        gl.glColor4f(121/255f, 66/255f,44/255f, 0);

        gl.glDrawElements(GL10.GL_LINE_LOOP, objLoader8.normals.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices8);


        // VENTANA IZQ
        gl.glColor4f(0, 1,0, 0);

        gl.glDrawElements(GL10.GL_LINE_LOOP, objLoader9.normals.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices9);

        // VENTANA IZQ
        gl.glColor4f(0, 1,0, 0);

        gl.glDrawElements(GL10.GL_LINE_LOOP, objLoader10.normals.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices10);

        // VENTANA IZQ
        gl.glColor4f(0, 1,0, 0);

        gl.glDrawElements(GL10.GL_LINE_LOOP, objLoader11.normals.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices11);

        // VENTANA IZQ
        gl.glColor4f(0, 1,0, 0);

        gl.glDrawElements(GL10.GL_LINE_LOOP, objLoader12.normals.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices12);

        // VENTANA IZQ
        gl.glColor4f(0, 1,0, 0);

        gl.glDrawElements(GL10.GL_LINE_LOOP, objLoader13.normals.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices13);

        // VENTANA IZQ
        gl.glColor4f(0, 1,0, 0);

        gl.glDrawElements(GL10.GL_LINE_LOOP, objLoader14.normals.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices14);










        /* Se deshabilita el acceso al arreglo de v�rtices */
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);


    }

}
