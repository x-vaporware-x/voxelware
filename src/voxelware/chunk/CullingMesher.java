/*
 * Copyright (C) 2019 Francisco M. Garcia S. - B. <https://github.com/OhEsPaco>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package voxelware.chunk;

import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer;
import com.jme3.util.BufferUtils;
import voxelware.Cubes.Cube;
import voxelware.math.CubeArray;

/**
 *
 * @author Francisco M. Garcia S. - B. <https://github.com/OhEsPaco>
 */
public class CullingMesher implements ChunkMesher {

    private int numVertex = 0;
    private int vertexOffset = 0;
    private int indexOffset = 0;
    private int textureOffset = 0;
    private int normalsOffset = 0;

    @Override
    public Mesh createMesh(CubeArray cubes, Vector3f offset) {
        vertexOffset = 0;

        indexOffset = 0;
        numVertex = 0;

        textureOffset = 0;
        normalsOffset = 0;

        float[] vertices = new float[cubes.getHeight() * cubes.getDepth() * cubes.getWidth() * 6 * 6];
        float[] normals = new float[cubes.getHeight() * cubes.getDepth() * cubes.getWidth() * 6 * 6];
        float[] textureCoords = new float[cubes.getHeight() * cubes.getDepth() * cubes.getWidth() * 6 * 6];
        int len = cubes.getHeight() * cubes.getDepth() * cubes.getWidth() * 6 * 6 / 3;

        int[] indices = new int[len];

        for (int y = 0; y < cubes.getHeight(); y++) {
            for (int z = 0; z < cubes.getDepth(); z++) {
                for (int x = 0; x < cubes.getWidth(); x++) {
                    Cube currentBlock = cubes.get(x, y, z);

                    if (currentBlock.getType() == Cube.AIR_CUBE) {
                        continue;
                    }

                    if (y < cubes.getHeight() - 1) {
                        if (cubes.get(x, y + 1, z).getType() == Cube.AIR_CUBE) {
                            //TOP
                            generateFace(vertices, offset, indices, x, y, z, 0, 0, 1, 0, 1, 0, 1, 1, 2, 1, 1, 1, 3, 1, 1, 0, currentBlock.getTextureCoordinatesTop(), textureCoords, normals, 0, 1, 0);
                        }
                    } else {
                        generateFace(vertices, offset, indices, x, y, z, 0, 0, 1, 0, 1, 0, 1, 1, 2, 1, 1, 1, 3, 1, 1, 0, currentBlock.getTextureCoordinatesTop(), textureCoords, normals, 0, 1, 0);
                    }

                    if (y > 0) {
                        if (cubes.get(x, y - 1, z).getType() == Cube.AIR_CUBE) {
                            //BOTTOM
                            generateFace(vertices, offset, indices, x, y, z, 4, 0, 0, 0, 7, 1, 0, 0, 6, 1, 0, 1, 5, 0, 0, 1, currentBlock.getTextureCoordinatesBottom(), textureCoords, normals, 0, -1, 0);
                        }
                    } else {
                        //BOTTOM
                        generateFace(vertices, offset, indices, x, y, z, 4, 0, 0, 0, 7, 1, 0, 0, 6, 1, 0, 1, 5, 0, 0, 1, currentBlock.getTextureCoordinatesBottom(), textureCoords, normals, 0, -1, 0);

                    }

                    if (z > 0) {
                        if (cubes.get(x, y, z - 1).getType() == Cube.AIR_CUBE) {
                            //LEFT
                            generateFace(vertices, offset, indices, x, y, z, 4, 0, 0, 0, 0, 0, 1, 0, 3, 1, 1, 0, 7, 1, 0, 0, currentBlock.getTextureCoordinatesLeft(), textureCoords, normals, 0, 0, -1);
                        }
                    } else {
                        //LEFT
                        generateFace(vertices, offset, indices, x, y, z, 4, 0, 0, 0, 0, 0, 1, 0, 3, 1, 1, 0, 7, 1, 0, 0, currentBlock.getTextureCoordinatesLeft(), textureCoords, normals, 0, 0, -1);
                    }
                    if (z < cubes.getWidth() - 1) {
                        if (cubes.get(x, y, z + 1).getType() == Cube.AIR_CUBE) {
                            //RIGHT
                            generateFace(vertices, offset, indices, x, y, z, 5, 0, 0, 1, 6, 1, 0, 1, 2, 1, 1, 1, 1, 0, 1, 1, currentBlock.getTextureCoordinatesRight(), textureCoords, normals, 0, 0, 1);
                        }
                    } else {
                        //RIGHT
                        generateFace(vertices, offset, indices, x, y, z, 5, 0, 0, 1, 6, 1, 0, 1, 2, 1, 1, 1, 1, 0, 1, 1, currentBlock.getTextureCoordinatesRight(), textureCoords, normals, 0, 0, 1);
                    }

                    if (x > 0) {

                        if (cubes.get(x - 1, y, z).getType() == Cube.AIR_CUBE) {
                            //FRONT
                            generateFace(vertices, offset, indices, x, y, z, 4, 0, 0, 0, 5, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, currentBlock.getTextureCoordinatesFront(), textureCoords, normals, -1, 0, 0);
                        }

                    } else {
                        //FRONT
                        generateFace(vertices, offset, indices, x, y, z, 4, 0, 0, 0, 5, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, currentBlock.getTextureCoordinatesFront(), textureCoords, normals, -1, 0, 0);
                    }
                    if (x < cubes.getDepth() - 1) {
                        if (cubes.get(x + 1, y, z).getType() == Cube.AIR_CUBE) {
                            //BACK
                            generateFace(vertices, offset, indices, x, y, z, 7, 1, 0, 0, 3, 1, 1, 0, 2, 1, 1, 1, 6, 1, 0, 1, currentBlock.getTextureCoordinatesBack(), textureCoords, normals, 1, 0, 1);
                        }
                    } else {
                        //BACK
                        generateFace(vertices, offset, indices, x, y, z, 7, 1, 0, 0, 3, 1, 1, 0, 2, 1, 1, 1, 6, 1, 0, 1, currentBlock.getTextureCoordinatesBack(), textureCoords, normals, 1, 0, 1);
                    }

                }
            }
        }

        Mesh mesh = new Mesh();
        mesh.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(vertices));
        mesh.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(textureCoords));
        mesh.setBuffer(VertexBuffer.Type.Index, 3, BufferUtils.createIntBuffer(indices));
        mesh.setBuffer(VertexBuffer.Type.Normal, 3, BufferUtils.createFloatBuffer(normals));
        mesh.updateBound();

        return mesh;
    }

    public void generateFace(float[] vertices, Vector3f offset, int[] indices, int x, int y, int z,
            int p1, int x1, int y1, int z1,
            int p2, int x2, int y2, int z2,
            int p3, int x3, int y3, int z3,
            int p4, int x4, int y4, int z4, float[] coords, float[] textureCoords, float[] normals, int n1, int n2, int n3) {

        vertices[vertexOffset++] = offset.x + x + x1;
        vertices[vertexOffset++] = offset.y + y + y1;
        vertices[vertexOffset++] = offset.z + z + z1;
        indices[indexOffset + 0] = numVertex;
        indices[indexOffset + 5] = numVertex;
        numVertex++;

        vertices[vertexOffset++] = offset.x + x + x2;
        vertices[vertexOffset++] = offset.y + y + y2;
        vertices[vertexOffset++] = offset.z + z + z2;
        indices[indexOffset + 1] = numVertex;
        numVertex++;

        vertices[vertexOffset++] = offset.x + x + x3;
        vertices[vertexOffset++] = offset.y + y + y3;
        vertices[vertexOffset++] = offset.z + z + z3;
        indices[indexOffset + 2] = numVertex;
        indices[indexOffset + 3] = numVertex;
        numVertex++;

        vertices[vertexOffset++] = offset.x + x + x4;
        vertices[vertexOffset++] = offset.y + y + y4;
        vertices[vertexOffset++] = offset.z + z + z4;
        indices[indexOffset + 4] = numVertex;
        numVertex++;

        textureCoords[textureOffset] = coords[0];
        textureCoords[textureOffset + 1] = coords[1];
        textureCoords[textureOffset + 2] = coords[2];
        textureCoords[textureOffset + 3] = coords[3];
        textureCoords[textureOffset + 4] = coords[4];
        textureCoords[textureOffset + 5] = coords[5];
        textureCoords[textureOffset + 6] = coords[6];
        textureCoords[textureOffset + 7] = coords[7];

        for (int i = 0; i < 12; i = i + 3) {
            normals[normalsOffset + i] = n1;
            normals[normalsOffset + i + 1] = n2;
            normals[normalsOffset + i + 2] = n3;
        }

        indexOffset = indexOffset + 6;
        textureOffset = textureOffset + 8;
        normalsOffset = normalsOffset + 12;

    }

}
