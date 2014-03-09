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
        setDisplayFps(false);
        setDisplayStatView(false);
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
        brightnessSlider();
        wifiSlider();
        volumeSlider();
    }
    
    private void brightnessImg() {
        Picture brightness = new Picture("Brightness");
        brightness.setImage(assetManager, "Brightness.png", false);
        brightness.move(20, settings.getHeight()/2-100, 0);
        brightness.setWidth(600);
        brightness.setHeight(200);
        guiNode.attachChild(brightness);
    }
    
    private void wifiImg() {
        Picture wifi = new Picture("Brightness");
        wifi.setImage(assetManager, "Wifi.png", false);
        wifi.move(20, settings.getHeight()/2+110, 0);
        wifi.setWidth(600);
        wifi.setHeight(200);
        guiNode.attachChild(wifi);
    }
    
    private void volumeImg() {
        Picture volume = new Picture("Brightness");
        volume.setImage(assetManager, "Volume.png", false);
        volume.move(20, settings.getHeight()/2+320, 0);
        volume.setWidth(600);
        volume.setHeight(200);
        guiNode.attachChild(volume);
    }
    
    private void brightnessSlider() {
        Picture bSlide = new Picture("bSlide");
        bSlide.setImage(assetManager, "Sliderbar.png", false);
        bSlide.move(700, settings.getHeight()/2-50, 0);
        bSlide.setWidth(1200);
        bSlide.setHeight(100);
        guiNode.attachChild(bSlide);
    }
    
    private void wifiSlider() {
        Picture wSlide = new Picture("wSlide");
        wSlide.setImage(assetManager, "Sliderbar.png", false);
        wSlide.move(700, settings.getHeight()/2+160, 0);
        wSlide.setWidth(1200);
        wSlide.setHeight(100);
        guiNode.attachChild(wSlide);

    }
    private void volumeSlider() {
        Picture vSlide = new Picture("vSlide");
        vSlide.setImage(assetManager, "Sliderbar.png", false);
        vSlide.move(700, settings.getHeight()/2+370, 0);
        vSlide.setWidth(1200);
        vSlide.setHeight(100);
        guiNode.attachChild(vSlide);

    }
    
}