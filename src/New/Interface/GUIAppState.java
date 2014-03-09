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
        layoutObjects();
    }
    
    @Override
    public void update(float tpf) {
        //TODO: implement behavior during runtime
    }
    
    public void layoutObjects() {
        background();
        //brightness();
        //wifi();
        //volume();
    }
    
    public void background() {
        Box univ_box = new Box(1,1,1);
        Geometry background_geom = new Geometry("Brightness", univ_box);
        Material background_mat = new Material(assetManager, 
                "Common/MatDefs/Misc/Unshaded.j3md");
        background_mat.setColor("Color", new ColorRGBA(0.02f,0.056f,0.115f,0.5f));
        background_geom.setMaterial(background_mat);
        background_geom.setLocalScale(10.0f,10.0f,0.0f);
        background_geom.setLocalTranslation(0.0f,0.0f,0.0f);
        Spatial background = background_geom;
        objectList.add(background);
        rootNode.attachChild(background);
    }
    
    public void brightness() {
        Box univ_box = new Box(1,1,1);
        Geometry brightness_geom = new Geometry("Brightness", univ_box);
        Material brightness_mat = new Material(assetManager, 
                "Common/MatDefs/Misc/Unshaded.j3md");
        brightness_mat.setColor("Color", ColorRGBA.Gray);
        brightness_geom.setMaterial(brightness_mat);
        brightness_geom.setLocalScale(4.0f,0.5f,0.0f);
        brightness_geom.setLocalTranslation(1.5f,3.20f,0.0f);
        Spatial brightness = brightness_geom;
        objectList.add(brightness);
        rootNode.attachChild(brightness);
    }
    
    public void wifi() {
        Box univ_box = new Box(1,1,1);
        Geometry wifi_geom = new Geometry("Wifi", univ_box);
        Material wifi_mat = new Material(assetManager, 
                "Common/MatDefs/Misc/Unshaded.j3md");
        wifi_mat.setColor("Color", ColorRGBA.Gray);
        wifi_geom.setMaterial(wifi_mat);
        wifi_geom.setLocalScale(4.0f,0.5f,0.0f);
        wifi_geom.setLocalTranslation(1.5f,2.20f,0.0f);
        Spatial wifi = wifi_geom;
        objectList.add(wifi);
        rootNode.attachChild(wifi);
    }
    
    public void volume() {
        Box univ_box = new Box(1,1,1);
        Geometry volume_geom = new Geometry("Volume", univ_box);
        Material volume_mat = new Material(assetManager, 
                "Common/MatDefs/Misc/Unshaded.j3md");
        volume_mat.setColor("Color", ColorRGBA.Gray);
        volume_geom.setMaterial(volume_mat);
        volume_geom.setLocalScale(4.0f,0.5f,0.0f);
        volume_geom.setLocalTranslation(1.5f,1.20f,0.0f);
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
