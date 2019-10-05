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
package voxelware;

import voxelware.factories.PlayerFactory;
import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import com.jme3.texture.Texture;
import java.util.logging.Level;
import java.util.logging.Logger;
import voxelware.chunk.Chunk;

public class Main extends SimpleApplication {

    private Node player;

    public static void main(String[] args) {
        Logger.getLogger("").setLevel(Level.FINE);

        Main app = new Main();

        app.showSettings = false;
        AppSettings appSettings = new AppSettings(true);
        appSettings.put("Width", 1280);
        appSettings.put("Height", 720);
        appSettings.put("Title", "Voxelware");
        app.setSettings(appSettings);

        app.start();

    }

    @Override
    public void simpleInitApp() {
        viewPort.setBackgroundColor(new ColorRGBA(135/255f,206/255f,235/255f,1f));

        Chunk c = new Chunk(16, 256, 16, new Vector3f(0, 0, 0));
        c.randomize();
        c.update();

        Geometry testChunk = new Geometry("testChunk", c.getMesh());

        Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        Texture tex = assetManager.loadTexture("Textures/Blocks/blockAtlas.png");
        tex.setMagFilter(Texture.MagFilter.Nearest);
        tex.setMinFilter(Texture.MinFilter.NearestNoMipMaps);
        mat.setTexture("DiffuseMap", tex);
        testChunk.setMaterial(mat);

        flyCam.setMoveSpeed(50);

        player = PlayerFactory.create(100);
        rootNode.attachChild(testChunk);
        rootNode.attachChild(player);
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(2, -1, 3).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //int health=player.getControl(PlayerControl.class).getHealth();
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
