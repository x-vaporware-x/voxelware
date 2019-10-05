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
import voxelware.Cubes.Cube;
import voxelware.factories.CubeFactory;
import voxelware.math.CubeArray;
import voxelware.math.CubeArrayLinear;

/**
 *
 * @author Francisco M. Garcia S. - B. <https://github.com/OhEsPaco>
 */
public class Chunk {

    private CubeArray cubes;
    private Mesh mesh;
    private Vector3f offset;
    private ChunkMesher mesher;
    private boolean dirty;

    public Chunk(int width, int height, int depth, Vector3f offset, ChunkMesher mesher) {
        this.cubes = new CubeArrayLinear(width, height, depth);
        for (int y = 0; y < cubes.getHeight(); y++) {
            for (int z = 0; z < cubes.getDepth(); z++) {
                for (int x = 0; x < cubes.getWidth(); x++) {
                    cubes.set(x, y, z, CubeFactory.createCube(Cube.AIR_CUBE));
                }
            }
        }

        this.offset = offset;
        this.mesher = mesher;
        this.dirty = true;
    }

    public Chunk(int width, int height, int depth, Vector3f offset) {
        this(width, height, depth, offset, new CullingMesher());
    }

    public void update() {
        if (dirty) {
            this.dirty = false;
            this.mesh = mesher.createMesh(cubes, offset);

        }

    }

    public void forceUpdate() {
        this.dirty = false;
        this.mesh = mesher.createMesh(cubes, offset);
    }

    public Mesh getMesh() {
        return mesh;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    public void randomize() {
        for (int y = 0; y < cubes.getHeight(); y++) {
            for (int z = 0; z < cubes.getDepth(); z++) {
                for (int x = 0; x < cubes.getWidth(); x++) {
                    switch (getRandomNumberInRange(0, 1)) {
                        case 0:
                            cubes.set(x, y, z, CubeFactory.createCube(Cube.DIRT_CUBE));
                            break;
                    }
                }
            }
        }
    }

    public int getRandomNumberInRange(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));

    }
}
