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
package voxelware.math;

import voxelware.Cubes.Cube;

/**
 *
 * @author Francisco M. Garcia S. - B. <https://github.com/OhEsPaco>
 */
public class CubeArrayLinear extends CubeArray {

    private final int width;
    private final int height;
    private final int depth;
    private final int widthTimesDepth;
    private Cube[] voxels;

    public CubeArrayLinear(int width, int height, int depth) {
        this.voxels = new Cube[width * height * depth];
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.widthTimesDepth = width * depth;
    }

    @Override
    public Cube get(int x, int y, int z) {
        if (x < 0 || x >= width) {
            return null;
        }
        if (y < 0 || y >= height) {
            return null;
        }
        if (z < 0 || z >= depth) {
            return null;
        }
        return voxels[x + z * width + y * widthTimesDepth];

    }

    @Override
    public void set(int x, int y, int z, Cube cubes) {
        if (x < 0 || x >= width) {
            return;
        }
        if (y < 0 || y >= height) {
            return;
        }
        if (z < 0 || z >= depth) {
            return;
        }

        voxels[x + z * width + y * widthTimesDepth] = cubes;

    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getDepth() {
        return depth;
    }

}
