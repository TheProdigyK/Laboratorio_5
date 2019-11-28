package com.example.lab5_proyeccion3d;

import android.content.Context;
import android.icu.text.Transliterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public final class ObjLoader {

    public final int numFaces;
    public int changeColor = 0, changeColor2 = 0;

    public final short[] normals;
    public final float[] positions;

    public ObjLoader(Context context, String file) {

        Vector<Float> vertices = new Vector<>();
        Vector<Float> normals = new Vector<>();
        Vector<Float> textures = new Vector<>();
        Vector<String> faces = new Vector<>();

        BufferedReader reader = null;
        try {
            InputStreamReader in = new InputStreamReader(context.getAssets().open(file));
            reader = new BufferedReader(in);

            // read file until EOF
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                switch (parts[0]) {
                    case "v":
                        // vertices
                        for(int i=1; i<parts.length; i++)
                        {
                            vertices.add(Float.valueOf(parts[i]));
                        }
//                        vertices.add(Float.valueOf(parts[1]));
//                        vertices.add(Float.valueOf(parts[2]));
//                        vertices.add(Float.valueOf(parts[3]));
                        break;
                    case "vt":
                        // textures
                        textures.add(Float.valueOf(parts[1]));
                        textures.add(Float.valueOf(parts[2]));
                        break;
                    case "vn":
                        // normals
                        normals.add(Float.valueOf(parts[1]));
                        normals.add(Float.valueOf(parts[2]));
                        normals.add(Float.valueOf(parts[3]));
                        break;
                    case "f":
                        // faces: vertex/texture/normal
                        for(int i=1; i<parts.length; i++)
                        {
                            faces.add(parts[i]);
                        }
//                        faces.add(parts[1]);
//                        faces.add(parts[2]);
//                        faces.add(parts[3]);
                        break;
                    case "this":
                        changeColor = normals.size();
                        break;
                }
            }
        } catch (IOException e) {
            // cannot load or read file
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        numFaces = faces.size();
        this.normals = new short[numFaces];
        positions = new float[vertices.size()];
        int NormalsIndex = 0;
        for (String face : faces) {
            String[] parts = face.split("/");
            int index = (Short.valueOf(parts[0]) - 1);
            this.normals[NormalsIndex] = (short) index;
            NormalsIndex++;
        }

        for(int i = 0; i<vertices.size(); i++)
        {
            positions[i] = vertices.get(i);
        }
    }
}
