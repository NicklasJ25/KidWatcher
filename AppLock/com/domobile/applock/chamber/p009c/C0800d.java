package com.domobile.applock.chamber.p009c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.PictureCallback;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.domobile.applock.p003a.C0613d;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1258c;

public class C0800d extends C0785a {
    private Camera f1057d;
    private int f1058e;
    private SurfaceTexture f1059f;

    public C0800d(Context context) {
        super(context);
    }

    private void m1250b() {
        try {
            if (this.f1057d != null) {
                this.f1057d.setPreviewCallback(null);
                this.f1057d.stopPreview();
                this.f1057d.release();
                this.f1057d = null;
            }
            if (this.f1059f != null) {
                this.f1059f.release();
                this.f1059f = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m1252c(final String str) {
        C1148d.m2521b(new AsyncTask<Object, Object, Object>(this) {
            final /* synthetic */ C0800d f1056b;

            class C07981 implements PictureCallback {
                final /* synthetic */ C07993 f1054a;

                C07981(C07993 c07993) {
                    this.f1054a = c07993;
                }

                public void onPictureTaken(byte[] bArr, Camera camera) {
                    C1258c.m2987b("Camera1 onPictureTaken success");
                    this.f1054a.f1056b.m1250b();
                    C0814g.m1301a(bArr, str, this.f1054a.f1056b.f1058e);
                    this.f1054a.f1056b.m1214a();
                }
            }

            protected Object doInBackground(Object... objArr) {
                try {
                    SystemClock.sleep(250);
                    this.f1056b.f1057d.takePicture(null, null, new C07981(this));
                } catch (Exception e) {
                    e.printStackTrace();
                    this.f1056b.m1250b();
                }
                return null;
            }
        }, new Object[0]);
    }

    public void mo2423a(final String str) {
        C1148d.m2521b(new AsyncTask<Object, Object, Object>(this) {
            final /* synthetic */ C0800d f1053b;

            protected Object doInBackground(Object... objArr) {
                this.f1053b.m1254b(str);
                return null;
            }
        }, new Object[0]);
    }

    public void m1254b(final String str) {
        int i = 0;
        C1258c.m2987b("Camera1 takePicture");
        if (C0613d.m699a(this.b)) {
            try {
                CameraInfo cameraInfo = new CameraInfo();
                int numberOfCameras = Camera.getNumberOfCameras();
                while (i < numberOfCameras) {
                    Camera.getCameraInfo(i, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        this.f1058e = (360 - ((cameraInfo.orientation + C0613d.m700b(this.b)) % 360)) % 360;
                        this.f1057d = Camera.open(i);
                        this.f1057d.setDisplayOrientation(this.f1058e);
                        break;
                    }
                    i++;
                }
                if (this.f1057d != null) {
                    this.f1059f = new SurfaceTexture(10);
                    if (VERSION.SDK_INT >= 15) {
                        this.f1059f.setDefaultBufferSize(1, 1);
                    }
                    this.f1057d.setPreviewTexture(this.f1059f);
                    this.f1057d.startPreview();
                    this.f1057d.autoFocus(new AutoFocusCallback(this) {
                        final /* synthetic */ C0800d f1051b;

                        public void onAutoFocus(boolean z, Camera camera) {
                            C1258c.m2987b("onAutoFocus success:" + z);
                            this.f1051b.m1252c(str);
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
                m1250b();
            }
        }
    }
}
