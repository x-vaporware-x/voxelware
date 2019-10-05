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
public class DirtCube implements Cube {

    private static final int ROW_TOP = 0;
    private static final int ROW_BOTTOM = 0;
    private static final int ROW_LEFT = 0;
    private static final int ROW_RIGHT = 0;
    private static final int ROW_FRONT = 0;
    private static final int ROW_BACK = 0;

    private static final int COLUMN_TOP = 2;
    private static final int COLUMN_BOTTOM = 2;
    private static final int COLUMN_LEFT = 2;
    private static final int COLUMN_RIGHT = 2;
    private static final int COLUMN_FRONT = 2;
    private static final int COLUMN_BACK = 2;

    public static final float[] TOP_FACE = new float[]{(COLUMN_TOP + 0) * TEXTURE_SCALE, (ROW_TOP + 1) * TEXTURE_SCALE,
        (COLUMN_TOP + 1) * TEXTURE_SCALE, (ROW_TOP + 1) * TEXTURE_SCALE,
        (COLUMN_TOP + 1) * TEXTURE_SCALE, (ROW_TOP + 0) * TEXTURE_SCALE,
        (COLUMN_TOP + 0) * TEXTURE_SCALE, (ROW_TOP + 0) * TEXTURE_SCALE};

    public static final float[] BOTTOM_FACE = new float[]{(COLUMN_BOTTOM + 1) * TEXTURE_SCALE, (ROW_BOTTOM + 1) * TEXTURE_SCALE,
        (COLUMN_BOTTOM + 1) * TEXTURE_SCALE, (ROW_BOTTOM + 0) * TEXTURE_SCALE,
        (COLUMN_BOTTOM + 0) * TEXTURE_SCALE, (ROW_BOTTOM + 0) * TEXTURE_SCALE,
        (COLUMN_BOTTOM + 0) * TEXTURE_SCALE, (ROW_BOTTOM + 1) * TEXTURE_SCALE};

    public static final float[] LEFT_FACE = new float[]{(COLUMN_LEFT + 1) * TEXTURE_SCALE, (ROW_LEFT + 1) * TEXTURE_SCALE,
        (COLUMN_LEFT + 1) * TEXTURE_SCALE, (ROW_LEFT + 0) * TEXTURE_SCALE,
        (COLUMN_LEFT + 0) * TEXTURE_SCALE, (ROW_LEFT + 0) * TEXTURE_SCALE,
        (COLUMN_LEFT + 0) * TEXTURE_SCALE, (ROW_LEFT + 1) * TEXTURE_SCALE};

    public static final float[] RIGHT_FACE = new float[]{(COLUMN_RIGHT + 0) * TEXTURE_SCALE, (ROW_RIGHT + 1) * TEXTURE_SCALE,
        (COLUMN_RIGHT + 1) * TEXTURE_SCALE, (ROW_RIGHT + 1) * TEXTURE_SCALE,
        (COLUMN_RIGHT + 1) * TEXTURE_SCALE, (ROW_RIGHT + 0) * TEXTURE_SCALE,
        (COLUMN_RIGHT + 0) * TEXTURE_SCALE, (ROW_RIGHT + 0) * TEXTURE_SCALE};

    public static final float[] FRONT_FACE = new float[]{(COLUMN_FRONT + 0) * TEXTURE_SCALE, (ROW_FRONT + 1) * TEXTURE_SCALE,
        (COLUMN_FRONT + 1) * TEXTURE_SCALE, (ROW_FRONT + 1) * TEXTURE_SCALE,
        (COLUMN_FRONT + 1) * TEXTURE_SCALE, (ROW_FRONT + 0) * TEXTURE_SCALE,
        (COLUMN_FRONT + 0) * TEXTURE_SCALE, (ROW_FRONT + 0) * TEXTURE_SCALE};

    public static final float[] BACK_FACE = new float[]{(COLUMN_BACK + 1) * TEXTURE_SCALE, (ROW_BACK + 1) * TEXTURE_SCALE,
        (COLUMN_BACK + 1) * TEXTURE_SCALE, (ROW_BACK + 0) * TEXTURE_SCALE,
        (COLUMN_BACK + 0) * TEXTURE_SCALE, (ROW_BACK + 0) * TEXTURE_SCALE,
        (COLUMN_BACK + 0) * TEXTURE_SCALE, (ROW_BACK + 1) * TEXTURE_SCALE};

    @Override
    public float[] getTextureCoordinatesTop() {
        return TOP_FACE;
    }

    @Override
    public float[] getTextureCoordinatesBottom() {
        return BOTTOM_FACE;
    }

    @Override
    public float[] getTextureCoordinatesLeft() {
        return LEFT_FACE;
    }

    @Override
    public float[] getTextureCoordinatesRight() {
        return RIGHT_FACE;
    }

    @Override
    public float[] getTextureCoordinatesFront() {
        return FRONT_FACE;
    }

    @Override
    public float[] getTextureCoordinatesBack() {
        return BACK_FACE;
    }

    @Override
    public byte getType() {
        return Cube.DIRT_CUBE;
    }
}
