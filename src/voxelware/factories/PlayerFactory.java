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
package voxelware.factories;

import com.jme3.scene.Node;
import voxelware.controls.PlayerControl;

/**
 *
 * @author Francisco M. Garcia S. - B. <https://github.com/OhEsPaco>
 */
public class PlayerFactory {

    public static Node create(int health) {
        Node player = new Node();
        player.setUserData("health", health);
        player.addControl(new PlayerControl());
        return player;
    }
}
