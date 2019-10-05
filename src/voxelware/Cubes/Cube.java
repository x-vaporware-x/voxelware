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
public interface Cube {

    byte AIR_CUBE = 0;
    byte DIRT_CUBE = 1;

    float TEXTURE_SCALE = 0.03125f;
    float CUBE_SCALE = 1f;

    //1f for full blocks
    float CUBE_SIZE = 1f;

    byte getType();

    float[] getTextureCoordinatesTop();

    float[] getTextureCoordinatesBottom();

    float[] getTextureCoordinatesLeft();

    float[] getTextureCoordinatesRight();

    float[] getTextureCoordinatesFront();

    float[] getTextureCoordinatesBack();
}
