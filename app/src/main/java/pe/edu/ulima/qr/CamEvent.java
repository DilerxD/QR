package pe.edu.ulima.qr;

import android.graphics.Bitmap;
import android.hardware.Camera;

import net.sourceforge.zbar.Config;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.SymbolSet;

/**
 * Created by CarlosGabriel on 3/07/2016.
 */
public class CamEvent implements Camera.PreviewCallback {
    private  ImageScanner scanner;

    public CamEvent(){
        scanner=new ImageScanner();
        scanner.setConfig(0, Config.X_DENSITY,3);
        scanner.setConfig(0,Config.Y_DENSITY,3);
        scanner.setConfig(0,Config.ENABLE,0);
        scanner.setConfig(Symbol.QRCODE,Config.ENABLE,1);
    }

    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {
        Camera.Parameters camPara = camera.getParameters();
        Camera.Size size= camPara.getPreviewSize();
        int width=size.width;
        int height=size.height;

        Image image=new Image(width,height,"Y8000");
        image.setData(data);
        int result=scanner.scanImage(image);
        String value="";

        if(result !=0 && result!=-1){
            SymbolSet symbols = scanner.getResults();
            for(Symbol sym:symbols){
                value=sym.getData();
                break;

            }

            camera.setPreviewCallback(null);
            camera.stopPreview();

        }
    }
}
