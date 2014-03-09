package New.Interface;

import android.content.pm.ActivityInfo;
import com.jme3.app.AndroidHarness;
import com.jme3.system.android.AndroidConfigChooser.ConfigType;
import java.util.logging.Level;
import java.util.logging.LogManager;
 
public class MainActivity extends AndroidHarness{

    public MainActivity(){
        appClass = "New.Interface.GUIMain";
        eglConfigType = ConfigType.BEST;
        exitDialogTitle = "Exit?";
        exitDialogMessage = "Press Yes";
        eglConfigVerboseLogging = false;
        screenOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        mouseEventsEnabled = true;
        LogManager.getLogManager().getLogger("").setLevel(Level.INFO);
    }
 
}
