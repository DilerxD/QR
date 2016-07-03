package pe.edu.ulima.qr;


import android.content.pm.ActivityInfo;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private Camera camera;
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
        initialize();
    }

    protected void initialize(){

        camera = Camera.open();
        Camera.Parameters camPara= camera.getParameters();
        camera.setDisplayOrientation(90);

        camera.setParameters(camPara);

        CameraPreview cameraPreview = new CameraPreview(this,camera);
        camera.setPreviewCallback(new CamEvent());

        frameLayout = (FrameLayout) findViewById(R.id.Camera);
        frameLayout.addView(cameraPreview);

    }
}
