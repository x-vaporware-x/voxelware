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
public abstract class CubeArray {

    public abstract Cube get(int x, int y, int z);

    public abstract void set(int x, int y, int z, Cube cube);

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract int getDepth();

    public boolean compareVoxelArrays(CubeArray v1, CubeArray v2) {

        for (int x = 0; x < v1.getWidth(); x++) {
            for (int y = 0; y < v2.getHeight(); y++) {
                for (int z = 0; z < v1.getDepth(); z++) {
                    if (v1.get(x, y, z) != v2.get(x, y, z)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
