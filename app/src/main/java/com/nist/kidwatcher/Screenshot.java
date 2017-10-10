package com.nist.kidwatcher;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by nist on 25-07-2017.
 */

public class Screenshot extends AppCompatActivity
{
    private View v;

    public Screenshot()
    {
        v = getWindow().getDecorView().findViewById(android.R.id.content);
    }

    //Take screenshot
    public Bitmap TakeScreenshot()
    {
        Bitmap screenshot = null;

        try
        {

            //Get width and height of view
            int width = v.getMeasuredWidth();
            int height = v.getMeasuredHeight();

            screenshot = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

            //Draw to canvas
            Canvas canvas = new Canvas(screenshot);
            v.draw(canvas);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return screenshot;
    }

    //save to external storage
    private void saveScreenshot(Bitmap bitmap)
    {
        ByteArrayOutputStream baos = null;
        File file = null;

        try
        {
            //Compres and write to output stream
            baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 40, baos);

            //Write as a file to SD card
            file = new File(Environment.getExternalStorageDirectory() + File.separator + "Test.png");
            file.createNewFile();

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baos.toByteArray());
            fos.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
