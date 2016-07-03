package pe.edu.ulima.qr;

import android.content.Context;
import android.hardware.Camera;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by CarlosGabriel on 3/07/2016.
 */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private Camera cam;
    private SurfaceHolder mHold;
    public CameraPreview(Context context,Camera camera){

        super(context);
        cam=camera;
        mHold=getHolder();
        mHold.addCallback(this);
        mHold.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);




    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            cam.setPreviewDisplay(mHold);
            cam.startPreview();
        }catch (IOException e){


        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
