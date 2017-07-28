package com.domobile.applock.p003a;

import android.content.Context;
import android.view.WindowManager;
import com.android.gallery3d.ui.FadeTexture;

public class C0613d {
    public static boolean m699a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    public static int m700b(Context context) {
        switch (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation()) {
            case 0:
                return 0;
            case 1:
                return 90;
            case 2:
                return FadeTexture.DURATION;
            case 3:
                return 270;
            default:
                return 0;
        }
    }
}
