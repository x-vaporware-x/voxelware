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
package voxelware.Cubes;

/**
 *
 * @author Francisco M. Garcia S. - B. <https://github.com/OhEsPaco>
 */
public class AirCube implements Cube {

    @Override
    public byte getType() {
        return Cube.AIR_CUBE;
    }

    @Override
    public float[] getTextureCoordinatesTop() {
        return null;
    }

    @Override
    public float[] getTextureCoordinatesBottom() {
        return null;
    }

    @Override
    public float[] getTextureCoordinatesLeft() {
        return null;
    }

    @Override
    public float[] getTextureCoordinatesRight() {
        return null;
    }

    @Override
    public float[] getTextureCoordinatesFront() {
        return null;
    }

    @Override
    public float[] getTextureCoordinatesBack() {
        return null;
    }

}
