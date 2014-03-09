package New.Interface;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import java.util.ArrayList;


/**
 *
 * @authors Connor Rice, Jack Dimmit, Evan Mega
 */

public class GUIAppState extends AbstractAppState {
    private Box univ_box = new Box(1,1,1);
    private SimpleApplication app;
    private Ray ray = new Ray();
    private Camera cam;
    private Node rootNode;
    private AssetManager assetManager;
    private ArrayList<Spatial> objectList = new ArrayList<Spatial>();
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;
        this.cam = this.app.getCamera();
        this.rootNode = this.app.getRootNode();
        this.assetManager = this.app.getAssetManager();
    }
    
    @Override
    public void update(float tpf) {
        //TODO: implement behavior during runtime
    }
    
    public void layoutObjects() {
        brightness();
        wifi();
        volume();
    }
    
    public void brightness() {
        Geometry brightness_geom = new Geometry("Creep", univ_box);
        Material brightness_mat = new Material(assetManager, 
                "Common/MatDefs/Misc/Unshaded.j3md");
        brightness_mat.setColor("Color", ColorRGBA.Gray);
        brightness_geom.setMaterial(brightness_mat);
        brightness_geom.setLocalScale(1.0f,1.0f,1.0f);
        brightness_geom.setLocalTranslation(1.0f,1.0f,1.0f);
        Spatial brightness = brightness_geom;
        objectList.add(brightness);
        rootNode.attachChild(brightness);
    }
    
    public void wifi() {
        Geometry wifi_geom = new Geometry("Creep", univ_box);
        Material wifi_mat = new Material(assetManager, 
                "Common/MatDefs/Misc/Unshaded.j3md");
        wifi_mat.setColor("Color", ColorRGBA.Gray);
        wifi_geom.setMaterial(wifi_mat);
        wifi_geom.setLocalScale(1.0f,1.0f,1.0f);
        wifi_geom.setLocalTranslation(1.0f,0.0f,1.0f);
        Spatial wifi = wifi_geom;
        objectList.add(wifi);
        rootNode.attachChild(wifi);
    }
    
    public void volume() {
        Geometry volume_geom = new Geometry("Creep", univ_box);
        Material volume_mat = new Material(assetManager, 
                "Common/MatDefs/Misc/Unshaded.j3md");
        volume_mat.setColor("Color", ColorRGBA.Gray);
        volume_geom.setMaterial(volume_mat);
        volume_geom.setLocalScale(1.0f,1.0f,1.0f);
        volume_geom.setLocalTranslation(1.0f,-1.0f,1.0f);
        Spatial volume = volume_geom;
        objectList.add(volume);
        rootNode.attachChild(volume);
    }
    
    @Override
    public void cleanup() {
        super.cleanup();
        rootNode.detachAllChildren();
    }
}
