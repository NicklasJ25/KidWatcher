package com.domobile.applock.chamber.p009c;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.WindowManager;
import com.android.gallery3d.ui.FadeTexture;
import com.domobile.frame.p000a.C1258c;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(21)
public class C0809e extends C0785a {
    private static final SparseIntArray f1069d = new SparseIntArray();
    private String f1070e;
    private ImageReader f1071f;
    private HandlerThread f1072g;
    private Handler f1073h;
    private File f1074i;
    private CameraDevice f1075j;
    private Builder f1076k;
    private CaptureRequest f1077l;
    private int f1078m = 0;
    private Semaphore f1079n = new Semaphore(1);
    private boolean f1080o;
    private int f1081p;
    private CameraCaptureSession f1082q;
    private SurfaceTexture f1083r;
    private Handler f1084s = new C08011(this);
    private AtomicBoolean f1085t = new AtomicBoolean(false);
    private CaptureCallback f1086u = new C08044(this);
    private final StateCallback f1087v = new C08055(this);
    private final OnImageAvailableListener f1088w = new C08066(this);

    class C08011 extends Handler {
        final /* synthetic */ C0809e f1060a;

        C08011(C0809e c0809e) {
            this.f1060a = c0809e;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            this.f1060a.f1085t.set(true);
        }
    }

    class C08022 extends CameraCaptureSession.StateCallback {
        final /* synthetic */ C0809e f1061a;

        C08022(C0809e c0809e) {
            this.f1061a = c0809e;
        }

        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            if (this.f1061a.f1075j != null) {
                try {
                    this.f1061a.f1082q = cameraCaptureSession;
                    this.f1061a.f1076k.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
                    this.f1061a.f1077l = this.f1061a.f1076k.build();
                    this.f1061a.f1082q.setRepeatingRequest(this.f1061a.f1077l, this.f1061a.f1086u, this.f1061a.f1073h);
                    this.f1061a.m1275h();
                    this.f1061a.f1085t.set(false);
                    this.f1061a.f1084s.sendEmptyMessageDelayed(0, 1500);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                }
            }
        }
    }

    class C08033 extends CaptureCallback {
        final /* synthetic */ C0809e f1062a;

        C08033(C0809e c0809e) {
            this.f1062a = c0809e;
        }

        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            this.f1062a.m1279j();
        }
    }

    class C08044 extends CaptureCallback {
        final /* synthetic */ C0809e f1063a;

        C08044(C0809e c0809e) {
            this.f1063a = c0809e;
        }

        private void m1255a(CaptureResult captureResult) {
            Integer num;
            switch (this.f1063a.f1078m) {
                case 1:
                    if (this.f1063a.f1085t.get()) {
                        C1258c.m2987b("**** 超时拍照 ****");
                        this.f1063a.f1085t.set(false);
                        this.f1063a.f1084s.removeCallbacksAndMessages(null);
                        this.f1063a.f1078m = 4;
                        this.f1063a.m1278i();
                        return;
                    }
                    num = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num == null) {
                        return;
                    }
                    if (num.intValue() == 2 || num.intValue() == 3 || num.intValue() == 4 || num.intValue() == 5) {
                        C1258c.m2987b("**** 正常拍照 ****");
                        this.f1063a.f1085t.set(false);
                        this.f1063a.f1084s.removeCallbacksAndMessages(null);
                        this.f1063a.f1078m = 4;
                        this.f1063a.m1278i();
                        return;
                    }
                    return;
                case 2:
                    num = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num == null || num.intValue() == 5 || num.intValue() == 4) {
                        this.f1063a.f1078m = 3;
                        return;
                    }
                    return;
                case 3:
                    num = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num == null || num.intValue() != 5) {
                        this.f1063a.f1078m = 4;
                        this.f1063a.m1278i();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            m1255a(totalCaptureResult);
        }

        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            m1255a(captureResult);
        }
    }

    class C08055 extends StateCallback {
        final /* synthetic */ C0809e f1064a;

        C08055(C0809e c0809e) {
            this.f1064a = c0809e;
        }

        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            this.f1064a.f1079n.release();
            cameraDevice.close();
            this.f1064a.f1075j = null;
        }

        public void onError(@NonNull CameraDevice cameraDevice, int i) {
            this.f1064a.f1079n.release();
            cameraDevice.close();
            this.f1064a.f1075j = null;
        }

        public void onOpened(@NonNull CameraDevice cameraDevice) {
            this.f1064a.f1079n.release();
            this.f1064a.f1075j = cameraDevice;
            this.f1064a.m1274g();
        }
    }

    class C08066 implements OnImageAvailableListener {
        final /* synthetic */ C0809e f1065a;

        C08066(C0809e c0809e) {
            this.f1065a = c0809e;
        }

        public void onImageAvailable(ImageReader imageReader) {
            this.f1065a.f1073h.post(new C0808b(this.f1065a, imageReader.acquireNextImage(), this.f1065a.f1074i));
        }
    }

    private static class C0807a implements Comparator<Size> {
        private C0807a() {
        }

        public int m1256a(Size size, Size size2) {
            return Long.signum((((long) size.getWidth()) * ((long) size.getHeight())) - (((long) size2.getWidth()) * ((long) size2.getHeight())));
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1256a((Size) obj, (Size) obj2);
        }
    }

    private class C0808b implements Runnable {
        final /* synthetic */ C0809e f1066a;
        private final Image f1067b;
        private final File f1068c;

        public C0808b(C0809e c0809e, Image image, File file) {
            this.f1066a = c0809e;
            this.f1067b = image;
            this.f1068c = file;
        }

        public void run() {
            C1258c.m2987b("Camera2 onPictureTaken success");
            ByteBuffer buffer = this.f1067b.getPlanes()[0].getBuffer();
            byte[] bArr = new byte[buffer.remaining()];
            buffer.get(bArr);
            C0814g.m1298a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), this.f1068c.getAbsolutePath());
            this.f1066a.m1214a();
            this.f1066a.m1266c();
            this.f1066a.m1270e();
        }
    }

    static {
        f1069d.append(0, 90);
        f1069d.append(1, FadeTexture.DURATION);
        f1069d.append(2, 270);
        f1069d.append(3, 0);
    }

    public C0809e(Context context) {
        super(context);
    }

    private int m1257a(int i) {
        return ((f1069d.get(i) + this.f1081p) + 270) % 360;
    }

    private void m1264b() {
        m1272f();
        CameraManager cameraManager = (CameraManager) this.b.getSystemService("camera");
        try {
            if (this.f1079n.tryAcquire(2500, TimeUnit.MILLISECONDS)) {
                cameraManager.openCamera(this.f1070e, this.f1087v, this.f1073h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1266c() {
        /*
        r2 = this;
        r0 = r2.f1079n;	 Catch:{ Exception -> 0x003b }
        r0.acquire();	 Catch:{ Exception -> 0x003b }
        r0 = r2.f1082q;	 Catch:{ Exception -> 0x003b }
        if (r0 == 0) goto L_0x0011;
    L_0x0009:
        r0 = r2.f1082q;	 Catch:{ Exception -> 0x003b }
        r0.close();	 Catch:{ Exception -> 0x003b }
        r0 = 0;
        r2.f1082q = r0;	 Catch:{ Exception -> 0x003b }
    L_0x0011:
        r0 = r2.f1075j;	 Catch:{ Exception -> 0x003b }
        if (r0 == 0) goto L_0x001d;
    L_0x0015:
        r0 = r2.f1075j;	 Catch:{ Exception -> 0x003b }
        r0.close();	 Catch:{ Exception -> 0x003b }
        r0 = 0;
        r2.f1075j = r0;	 Catch:{ Exception -> 0x003b }
    L_0x001d:
        r0 = r2.f1071f;	 Catch:{ Exception -> 0x003b }
        if (r0 == 0) goto L_0x0029;
    L_0x0021:
        r0 = r2.f1071f;	 Catch:{ Exception -> 0x003b }
        r0.close();	 Catch:{ Exception -> 0x003b }
        r0 = 0;
        r2.f1071f = r0;	 Catch:{ Exception -> 0x003b }
    L_0x0029:
        r0 = r2.f1083r;	 Catch:{ Exception -> 0x003b }
        if (r0 == 0) goto L_0x0035;
    L_0x002d:
        r0 = r2.f1083r;	 Catch:{ Exception -> 0x003b }
        r0.release();	 Catch:{ Exception -> 0x003b }
        r0 = 0;
        r2.f1083r = r0;	 Catch:{ Exception -> 0x003b }
    L_0x0035:
        r0 = r2.f1079n;
        r0.release();
    L_0x003a:
        return;
    L_0x003b:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0045 }
        r0 = r2.f1079n;
        r0.release();
        goto L_0x003a;
    L_0x0045:
        r0 = move-exception;
        r1 = r2.f1079n;
        r1.release();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.domobile.applock.chamber.c.e.c():void");
    }

    private void m1268d() {
        this.f1072g = new HandlerThread("CameraBackground");
        this.f1072g.start();
        this.f1073h = new Handler(this.f1072g.getLooper());
    }

    private void m1270e() {
        this.f1072g.quitSafely();
        try {
            this.f1072g.join();
            this.f1072g = null;
            this.f1073h = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m1272f() {
        CameraManager cameraManager = (CameraManager) this.b.getSystemService("camera");
        try {
            for (String str : cameraManager.getCameraIdList()) {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                if (num != null && num.intValue() == 0) {
                    StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                    if (streamConfigurationMap != null) {
                        Size size = (Size) Collections.max(Arrays.asList(streamConfigurationMap.getOutputSizes(256)), new C0807a());
                        this.f1071f = ImageReader.newInstance(size.getWidth(), size.getHeight(), 256, 2);
                        this.f1071f.setOnImageAvailableListener(this.f1088w, this.f1073h);
                        this.f1081p = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
                        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
                        this.f1080o = bool == null ? false : bool.booleanValue();
                        this.f1070e = str;
                        return;
                    }
                }
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (Exception e2) {
        }
    }

    private void m1274g() {
        try {
            this.f1083r = new SurfaceTexture(10);
            this.f1083r.setDefaultBufferSize(1, 1);
            Surface surface = new Surface(this.f1083r);
            this.f1076k = this.f1075j.createCaptureRequest(1);
            this.f1076k.addTarget(surface);
            this.f1075j.createCaptureSession(Arrays.asList(new Surface[]{surface, this.f1071f.getSurface()}), new C08022(this), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m1275h() {
        try {
            this.f1076k.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
            this.f1078m = 1;
            this.f1082q.capture(this.f1076k.build(), this.f1086u, this.f1073h);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (Exception e2) {
        }
    }

    private void m1278i() {
        try {
            if (this.f1075j != null) {
                Builder createCaptureRequest = this.f1075j.createCaptureRequest(2);
                createCaptureRequest.addTarget(this.f1071f.getSurface());
                createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
                createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(m1257a(((WindowManager) this.b.getSystemService("window")).getDefaultDisplay().getRotation())));
                CaptureCallback c08033 = new C08033(this);
                this.f1082q.stopRepeating();
                this.f1082q.capture(createCaptureRequest.build(), c08033, null);
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (Exception e2) {
        }
    }

    private void m1279j() {
        try {
            this.f1076k.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
            this.f1082q.capture(this.f1076k.build(), this.f1086u, this.f1073h);
            this.f1078m = 0;
            this.f1082q.setRepeatingRequest(this.f1077l, this.f1086u, this.f1073h);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (Exception e2) {
        }
    }

    public void mo2423a(String str) {
        m1289b(str);
    }

    public void m1289b(String str) {
        C1258c.m2987b("Camera2 takePicture");
        this.f1074i = new File(str);
        m1268d();
        m1264b();
    }
}
