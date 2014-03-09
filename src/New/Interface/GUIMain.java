package New.Interface;


/**
 *
 * @authors Connor Rice, Jack Dimmit, Evan Mega
 */
import com.jme3.app.SimpleApplication;
import com.jme3.collision.CollisionResults;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.Trigger;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.system.AppSettings;
import com.jme3.ui.Picture;


public class GUIMain extends SimpleApplication {
    
    public GUIAppState state;
    private static final Trigger TRIGGER_ACTIVATE = new MouseButtonTrigger(
            MouseInput.BUTTON_LEFT);
    private static final String MAPPING_ACTIVATE = "Touch";
    
    public static void main(String[] args) {
        AppSettings sets = new AppSettings(true);
        GUIMain app = new GUIMain();
        app.setSettings(sets);
        app.start();
    }
    
    
    @Override
    public void simpleInitApp() {
        inputManager.addMapping(MAPPING_ACTIVATE, TRIGGER_ACTIVATE);
        inputManager.addListener(analogListener, new String[]{MAPPING_ACTIVATE});
        flyCam.setDragToRotate(true);
        inputManager.setCursorVisible(true);
        flyCam.setRotationSpeed(0.0f);
        state = new GUIAppState();
        stateManager.attach(state);
        setupGUI();
    }
    
    private AnalogListener analogListener = new AnalogListener() {
        public void onAnalog(String name, float intensity, float tpf) {
            if (name.equals(MAPPING_ACTIVATE)) {
                Vector2f click2d = inputManager.getCursorPosition();
                Vector3f click3d = cam.getWorldCoordinates(new Vector2f(
                        click2d.getX(), click2d.getY()), 0f);
                CollisionResults results = new CollisionResults();
                Vector3f dir = cam.getWorldCoordinates(
                        new Vector2f(click2d.getX(), click2d.getY()), 1f);
                Ray ray = new Ray(click3d, dir);
                rootNode.collideWith(ray, results);
                for (int i = 0; i < results.size(); i++) {
                    float dist = results.getCollision(i).getDistance();
                    Vector3f pt = results.getCollision(i).getContactPoint();
                    String target = results.getCollision(i).getGeometry().getName();

                }
            }
        }
    };
    
    
    @Override
    public void simpleUpdate(float tpf) {

    }

    @Override
    public void simpleRender(RenderManager rm) {

    }
    
    private void setupGUI() {
        brightnessImg();
        wifiImg();
        volumeImg();
    }
    
    private void brightnessImg() {
        Picture brightness = new Picture("Brightness");
        brightness.setImage(assetManager, "Interface/Brightness.png", false);
        brightness.move(0, settings.getHeight()/2+100, 0);
        brightness.setWidth(250);
        brightness.setHeight(100);
        guiNode.attachChild(brightness);
    }
    
    private void wifiImg() {
        Picture wifi = new Picture("Brightness");
        wifi.setImage(assetManager, "Interface/Brightness.png", false);
        wifi.move(0, settings.getHeight()/2+100, 0);
        wifi.setWidth(250);
        wifi.setHeight(100);
        guiNode.attachChild(wifi);
    }
    
    private void volumeImg() {
        Picture volume = new Picture("Brightness");
        volume.setImage(assetManager, "Interface/Brightness.png", false);
        volume.move(0, settings.getHeight()/2+100, 0);
        volume.setWidth(250);
        volume.setHeight(100);
        guiNode.attachChild(volume);
    }
}