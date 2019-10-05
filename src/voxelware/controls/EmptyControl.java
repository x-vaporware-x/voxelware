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
package voxelware.controls;

import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.Control;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francisco M. Garcia S. - B. <https://github.com/OhEsPaco>
 */
public abstract class EmptyControl implements Control {

    private static final Logger LOGGER = Logger.getLogger(EmptyControl.class.getName());
    protected Spatial spatial;

    @Override
    public Control cloneForSpatial(Spatial spatial) {
        return null;
    }

    @Override
    public void setSpatial(Spatial spatial) {
        this.spatial = spatial;
    }

    @Override
    public void update(float tpf) {
        //LOGGER.log(Level.WARNING, "Update called!");
    }

    @Override
    public void render(RenderManager rm, ViewPort vp) {
    }

    @Override
    public void write(JmeExporter ex) throws IOException {
    }

    @Override
    public void read(JmeImporter im) throws IOException {
    }
}
