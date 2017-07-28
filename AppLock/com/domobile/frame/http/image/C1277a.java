package com.domobile.frame.http.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.p016c.C1170b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class C1277a {
    public static final String f2635a = C1148d.N;

    public static final Bitmap m3054a(File file) {
        FileInputStream fileInputStream;
        Bitmap bitmap = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bitmap = BitmapFactory.decodeStream(fileInputStream);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            Object obj = bitmap;
        }
        fileInputStream.close();
        return bitmap;
    }

    public static Bitmap m3055a(String str, boolean z) {
        return C1277a.m3056a(str, z, CompressFormat.PNG);
    }

    public static Bitmap m3056a(String str, boolean z, CompressFormat compressFormat) {
        File file = new File(C1277a.m3057a(str));
        Bitmap bitmap = null;
        if (file.exists()) {
            try {
                bitmap = C1277a.m3054a(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (z) {
                try {
                    bitmap = C1277a.m3062d(str);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } else {
                bitmap = C1277a.m3061c(str);
            }
            if (bitmap != null) {
                C1277a.m3058a(file, bitmap, compressFormat);
            }
        }
        return bitmap;
    }

    public static String m3057a(String str) {
        return C1147a.m2480a(f2635a, C1170b.m2682a(str));
    }

    public static final void m3058a(File file, Bitmap bitmap, CompressFormat compressFormat) {
        FileOutputStream fileOutputStream;
        FileNotFoundException e;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                if (compressFormat == CompressFormat.JPEG) {
                    bitmap.compress(compressFormat, 80, fileOutputStream);
                } else {
                    bitmap.compress(compressFormat, 100, fileOutputStream);
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream == null) {
                    try {
                        fileOutputStream.flush();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                        return;
                    }
                }
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            e.printStackTrace();
            fileOutputStream = fileOutputStream2;
            if (fileOutputStream == null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        if (fileOutputStream == null) {
            fileOutputStream.flush();
            fileOutputStream.close();
        }
    }

    private static final byte[] m3059a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
            byteArrayOutputStream.flush();
        }
    }

    public static Bitmap m3060b(String str) {
        return C1277a.m3055a(str, false);
    }

    public static final Bitmap m3061c(String str) {
        InputStream inputStream;
        Throwable th;
        Bitmap bitmap = null;
        try {
            inputStream = new URL(str).openConnection().getInputStream();
            try {
                bitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return bitmap;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            return bitmap;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            inputStream = null;
            th = th4;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
        return bitmap;
    }

    public static final Bitmap m3062d(String str) {
        InputStream inputStream;
        Bitmap decodeByteArray;
        Exception e;
        Throwable th;
        Exception exception;
        try {
            inputStream = new URL(str).openConnection().getInputStream();
            try {
                byte[] a = C1277a.m3059a(inputStream);
                int length = a.length;
                if (length > 51200) {
                    Options options = new Options();
                    int i = length / 51200;
                    if (i == 1) {
                        i = 2;
                    }
                    options.inSampleSize = i;
                    decodeByteArray = BitmapFactory.decodeByteArray(a, 0, length, options);
                } else {
                    decodeByteArray = BitmapFactory.decodeByteArray(a, 0, length);
                }
                try {
                    inputStream.close();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        return decodeByteArray;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                exception = e4;
                decodeByteArray = null;
                e = exception;
                e.printStackTrace();
                if (inputStream != null) {
                    inputStream.close();
                }
                return decodeByteArray;
            }
        } catch (Exception e42) {
            inputStream = null;
            exception = e42;
            decodeByteArray = null;
            e = exception;
            e.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
            return decodeByteArray;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
        return decodeByteArray;
    }
}
