package com.facebook.ads.internal.p023d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.ads.internal.p018m.ai;
import com.facebook.ads.internal.p030j.p031a.C1633p;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class C1552c {
    private static final String f3784a = C1552c.class.getSimpleName();
    private static C1552c f3785b;
    private final Context f3786c;

    private C1552c(Context context) {
        this.f3786c = context;
    }

    public static C1552c m4311a(Context context) {
        if (f3785b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f3785b == null) {
                    f3785b = new C1552c(applicationContext);
                }
            }
        }
        return f3785b;
    }

    private static void m4312a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    @Nullable
    private Bitmap m4313b(String str) {
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(new FileInputStream(str.substring("file://".length())), null, null);
            m4316a(str, decodeStream);
            return decodeStream;
        } catch (Throwable e) {
            Log.e(f3784a, "Failed to copy local image into cache (url=" + str + ").", e);
            return null;
        }
    }

    @Nullable
    private Bitmap m4314c(String str) {
        InputStream open;
        Bitmap decodeStream;
        Throwable th;
        C1633p c1633p = null;
        if (str.startsWith("asset:///")) {
            try {
                open = this.f3786c.getAssets().open(str.substring(9, str.length()));
                try {
                    decodeStream = BitmapFactory.decodeStream(open);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return decodeStream;
                } catch (Throwable th2) {
                    th = th2;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                open = c1633p;
                if (open != null) {
                    open.close();
                }
                return decodeStream;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                open = c1633p;
                th = th4;
                if (open != null) {
                    open.close();
                }
                throw th;
            }
        }
        byte[] d = ai.m4825a(this.f3786c).m4548a(str, c1633p).m4591d();
        decodeStream = BitmapFactory.decodeByteArray(d, 0, d.length);
        m4316a(str, decodeStream);
        return decodeStream;
    }

    @Nullable
    public Bitmap m4315a(String str) {
        File file = new File(this.f3786c.getCacheDir(), str.hashCode() + ".png");
        return !file.exists() ? str.startsWith("file://") ? m4313b(str) : m4314c(str) : BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public void m4316a(String str, Bitmap bitmap) {
        Closeable byteArrayOutputStream;
        Closeable fileOutputStream;
        Throwable e;
        Closeable closeable = null;
        File file = new File(this.f3786c.getCacheDir(), str.hashCode() + ".png");
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                if (byteArrayOutputStream.size() >= 3145728) {
                    Log.d(f3784a, "Bitmap size exceeds max size for storage");
                    C1552c.m4312a(byteArrayOutputStream);
                    C1552c.m4312a(null);
                    return;
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    byteArrayOutputStream.writeTo(fileOutputStream);
                    fileOutputStream.flush();
                    C1552c.m4312a(byteArrayOutputStream);
                    C1552c.m4312a(fileOutputStream);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    closeable = fileOutputStream;
                    fileOutputStream = byteArrayOutputStream;
                    try {
                        Log.e(f3784a, "Bad output destination (file=" + file.getAbsolutePath() + ").", e);
                        C1552c.m4312a(fileOutputStream);
                        C1552c.m4312a(closeable);
                    } catch (Throwable th) {
                        e = th;
                        byteArrayOutputStream = fileOutputStream;
                        C1552c.m4312a(byteArrayOutputStream);
                        C1552c.m4312a(closeable);
                        throw e;
                    }
                } catch (IOException e3) {
                    e = e3;
                    closeable = fileOutputStream;
                    try {
                        Log.e(f3784a, "Unable to write bitmap to file (url=" + str + ").", e);
                        C1552c.m4312a(byteArrayOutputStream);
                        C1552c.m4312a(closeable);
                    } catch (Throwable th2) {
                        e = th2;
                        C1552c.m4312a(byteArrayOutputStream);
                        C1552c.m4312a(closeable);
                        throw e;
                    }
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    closeable = fileOutputStream;
                    Log.e(f3784a, "Unable to write bitmap to output stream", e);
                    C1552c.m4312a(byteArrayOutputStream);
                    C1552c.m4312a(closeable);
                } catch (Throwable th3) {
                    e = th3;
                    closeable = fileOutputStream;
                    C1552c.m4312a(byteArrayOutputStream);
                    C1552c.m4312a(closeable);
                    throw e;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileOutputStream = byteArrayOutputStream;
                Log.e(f3784a, "Bad output destination (file=" + file.getAbsolutePath() + ").", e);
                C1552c.m4312a(fileOutputStream);
                C1552c.m4312a(closeable);
            } catch (IOException e6) {
                e = e6;
                Log.e(f3784a, "Unable to write bitmap to file (url=" + str + ").", e);
                C1552c.m4312a(byteArrayOutputStream);
                C1552c.m4312a(closeable);
            } catch (OutOfMemoryError e7) {
                e = e7;
                Log.e(f3784a, "Unable to write bitmap to output stream", e);
                C1552c.m4312a(byteArrayOutputStream);
                C1552c.m4312a(closeable);
            }
        } catch (FileNotFoundException e8) {
            e = e8;
            fileOutputStream = null;
            Log.e(f3784a, "Bad output destination (file=" + file.getAbsolutePath() + ").", e);
            C1552c.m4312a(fileOutputStream);
            C1552c.m4312a(closeable);
        } catch (IOException e9) {
            e = e9;
            byteArrayOutputStream = null;
            Log.e(f3784a, "Unable to write bitmap to file (url=" + str + ").", e);
            C1552c.m4312a(byteArrayOutputStream);
            C1552c.m4312a(closeable);
        } catch (OutOfMemoryError e10) {
            e = e10;
            byteArrayOutputStream = null;
            Log.e(f3784a, "Unable to write bitmap to output stream", e);
            C1552c.m4312a(byteArrayOutputStream);
            C1552c.m4312a(closeable);
        } catch (Throwable th4) {
            e = th4;
            byteArrayOutputStream = null;
            C1552c.m4312a(byteArrayOutputStream);
            C1552c.m4312a(closeable);
            throw e;
        }
    }
}
