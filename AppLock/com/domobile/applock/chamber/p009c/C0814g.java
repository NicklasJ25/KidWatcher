package com.domobile.applock.chamber.p009c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.InvaderBean;
import com.domobile.applock.p003a.C0614e;
import com.domobile.applock.p003a.C0615f;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1258c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class C0814g {

    static class C08122 implements Comparator<InvaderBean> {
        C08122() {
        }

        public int m1291a(InvaderBean invaderBean, InvaderBean invaderBean2) {
            return Long.valueOf(invaderBean2.f1298b).compareTo(Long.valueOf(invaderBean.f1298b));
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1291a((InvaderBean) obj, (InvaderBean) obj2);
        }
    }

    static class C08133 implements OnScanCompletedListener {
        C08133() {
        }

        public void onScanCompleted(String str, Uri uri) {
        }
    }

    @Nullable
    private static Bitmap m1292a(@NonNull Context context, @Nullable Bitmap bitmap, String str) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.view_margin_tin);
        Paint paint = new Paint(7);
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.pic_logo_watermark);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.drawBitmap(decodeResource, (float) (width - decodeResource.getWidth()), (float) (height - decodeResource.getHeight()), paint);
        TextView textView = (TextView) View.inflate(context, R.layout.layout_text_watermark, null);
        textView.setText(str);
        textView.setDrawingCacheEnabled(true);
        textView.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
        canvas.drawBitmap(textView.getDrawingCache(), (float) dimensionPixelSize, (float) dimensionPixelSize, paint);
        return createBitmap;
    }

    private static Bitmap m1293a(Bitmap bitmap) {
        float f;
        int i = 1080;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        if (width < height) {
            if (width <= 1080) {
                i = width;
            }
            f = ((float) i) / ((float) width);
        } else {
            if (height <= 1080) {
                i = height;
            }
            f = ((float) i) / ((float) height);
        }
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private static Bitmap m1294a(Bitmap bitmap, int i) {
        float f;
        int i2 = 1080;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        if (width < height) {
            if (width <= 1080) {
                i2 = width;
            }
            f = ((float) i2) / ((float) width);
        } else {
            if (height <= 1080) {
                i2 = height;
            }
            f = ((float) i2) / ((float) height);
        }
        matrix.postRotate((float) i);
        matrix.postScale(f, f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (createBitmap.getWidth() < createBitmap.getHeight()) {
            return createBitmap;
        }
        matrix = new Matrix();
        matrix.postRotate(90.0f);
        return Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix, true);
    }

    public static String m1295a(Context context) {
        return C0814g.m1304c(context) + File.separator + (System.currentTimeMillis() + ".jpg");
    }

    public static void m1296a(Context context, InvaderBean invaderBean) {
        String str = C0615f.f553f + File.separator + invaderBean.f1298b + ".jpg";
        C0814g.m1300a(str, C0814g.m1292a(context, BitmapFactory.decodeFile(invaderBean.f1297a), invaderBean.m1521b()), 100);
        C0814g.m1297a(context, str);
    }

    public static void m1297a(Context context, String str) {
        MediaScannerConnection.scanFile(context, new String[]{str}, null, new C08133());
    }

    public static void m1298a(Bitmap bitmap, String str) {
        if (bitmap != null) {
            try {
                Bitmap a = C0814g.m1293a(bitmap);
                C0814g.m1300a(str, a, 70);
                bitmap.recycle();
                a.recycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void m1299a(final String str) {
        if (!TextUtils.isEmpty(str)) {
            C1148d.m2521b(new AsyncTask<Object, Object, Object>() {
                protected Object doInBackground(Object... objArr) {
                    C1258c.m2987b("**** 正确,删除照片 ****");
                    C0614e.m707a(str);
                    return null;
                }
            }, new Object[0]);
        }
    }

    private static void m1300a(String str, Bitmap bitmap, int i) {
        IOException e;
        OutputStream outputStream;
        Throwable th;
        if (bitmap != null) {
            FileOutputStream fileOutputStream = null;
            try {
                File file = new File(str);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                OutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    bitmap.compress(CompressFormat.JPEG, i, fileOutputStream2);
                    fileOutputStream2.flush();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    outputStream = fileOutputStream2;
                    try {
                        e2.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e22 = e5;
                e22.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
        }
    }

    public static void m1301a(byte[] bArr, String str, int i) {
        try {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            Bitmap a = C0814g.m1294a(decodeByteArray, -i);
            C0814g.m1300a(str, a, 70);
            decodeByteArray.recycle();
            a.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static InvaderBean m1302b(String str) {
        File file = new File(str);
        String c = C0814g.m1305c(file.getName());
        InvaderBean invaderBean = new InvaderBean();
        invaderBean.f1298b = Long.parseLong(c);
        invaderBean.f1297a = file.getAbsolutePath();
        return invaderBean;
    }

    @NonNull
    public static ArrayList<InvaderBean> m1303b(@NonNull Context context) {
        Object arrayList = new ArrayList();
        try {
            File file = new File(C0814g.m1304c(context));
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    String c = C0814g.m1305c(file2.getName());
                    InvaderBean invaderBean = new InvaderBean();
                    invaderBean.f1298b = Long.parseLong(c);
                    invaderBean.f1297a = file2.getAbsolutePath();
                    arrayList.add(invaderBean);
                }
                Collections.sort(arrayList, new C08122());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private static String m1304c(Context context) {
        return context.getFilesDir() + File.separator + "Invader";
    }

    private static String m1305c(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf <= -1 || lastIndexOf >= str.length()) ? str : str.substring(0, lastIndexOf);
    }
}
