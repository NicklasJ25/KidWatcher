package com.domobile.applock.p003a;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.android.gallery3d.data.DownloadEntry.Columns;
import com.android.gallery3d.util.GalleryUtils;
import com.domobile.applock.chamber.model.FileInfo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.regex.Pattern;

public class C0614e {
    private static final Pattern f547a = Pattern.compile("[\\w%+,./=_-]+");

    public static File m701a(String str, String str2) {
        File file;
        OutputStream outputStream;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        try {
            file = new File(str2);
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                OutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream2, "utf-8"));
                    bufferedWriter.write(str);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    outputStream = fileOutputStream2;
                    if (file != null) {
                        try {
                            file.delete();
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                    return file;
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e4) {
                if (file != null) {
                    file.delete();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return file;
            }
        } catch (IOException e5) {
            file = null;
            if (file != null) {
                file.delete();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return file;
        }
        return file;
    }

    public static String m702a(long j) {
        BigDecimal bigDecimal = new BigDecimal(j);
        float floatValue = bigDecimal.divide(new BigDecimal(1048576), 1, 0).floatValue();
        if (floatValue > 1.0f) {
            return floatValue + "MB";
        }
        return bigDecimal.divide(new BigDecimal(1024), 1, 0).floatValue() + "KB";
    }

    @SuppressLint({"NewApi"})
    public static String m703a(Context context, Uri uri) {
        Uri uri2 = null;
        if ((VERSION.SDK_INT >= 19 ? 1 : 0) == 0 || !DocumentsContract.isDocumentUri(context, uri)) {
            return "content".equalsIgnoreCase(uri.getScheme()) ? C0614e.m704a(context, uri, null, null) : "file".equalsIgnoreCase(uri.getScheme()) ? uri.getPath() : null;
        } else {
            String[] split;
            if (C0614e.m708a(uri)) {
                split = DocumentsContract.getDocumentId(uri).split(":");
                return "primary".equalsIgnoreCase(split[0]) ? Environment.getExternalStorageDirectory() + "/" + split[1] : null;
            } else if (C0614e.m711b(uri)) {
                return C0614e.m704a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
            } else if (!C0614e.m713c(uri)) {
                return null;
            } else {
                Object obj = DocumentsContract.getDocumentId(uri).split(":")[0];
                if ("image".equals(obj)) {
                    uri2 = Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(obj)) {
                    uri2 = Video.Media.EXTERNAL_CONTENT_URI;
                } else if (FileInfo.MIME_AUDIO.equals(obj)) {
                    uri2 = Audio.Media.EXTERNAL_CONTENT_URI;
                }
                String str = "_id=?";
                return C0614e.m704a(context, uri2, "_id=?", new String[]{split[1]});
            }
        }
    }

    public static String m704a(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        Cursor cursor = null;
        String str2 = Columns.DATA;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{Columns.DATA}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str2 = query.getString(query.getColumnIndexOrThrow(Columns.DATA));
                        if (query == null) {
                            return str2;
                        }
                        query.close();
                        return str2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static String m705a(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        String str;
        Exception e;
        Throwable th;
        String str2 = "";
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                str = "";
                str = str2;
                while (true) {
                    try {
                        str2 = bufferedReader.readLine();
                        if (str2 == null) {
                            break;
                        }
                        str = str + str2;
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e = e4;
                str = str2;
                try {
                    e.printStackTrace();
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e322) {
                            e322.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e42) {
            inputStreamReader = null;
            e = e42;
            str = str2;
            e.printStackTrace();
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th;
        }
        return str;
    }

    private static void m706a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void m707a(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static boolean m708a(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean m709a(File file, File file2) {
        Closeable fileOutputStream;
        Closeable channel;
        IOException e;
        Closeable closeable;
        Closeable closeable2;
        Throwable th;
        Closeable closeable3 = null;
        Closeable fileInputStream;
        try {
            if (file2.exists()) {
                file2.delete();
            }
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    channel = fileInputStream.getChannel();
                } catch (IOException e2) {
                    e = e2;
                    channel = fileOutputStream;
                    closeable = null;
                    closeable2 = null;
                    closeable3 = fileInputStream;
                    try {
                        e.printStackTrace();
                        C0614e.m706a(closeable3);
                        C0614e.m706a(closeable2);
                        C0614e.m706a(channel);
                        C0614e.m706a(closeable);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = closeable3;
                        closeable3 = channel;
                        channel = closeable2;
                        C0614e.m706a(fileInputStream);
                        C0614e.m706a(channel);
                        C0614e.m706a(closeable3);
                        C0614e.m706a(closeable);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = null;
                    channel = null;
                    closeable3 = fileOutputStream;
                    C0614e.m706a(fileInputStream);
                    C0614e.m706a(channel);
                    C0614e.m706a(closeable3);
                    C0614e.m706a(closeable);
                    throw th;
                }
                try {
                    closeable = fileOutputStream.getChannel();
                } catch (IOException e3) {
                    e = e3;
                    closeable = null;
                    closeable2 = channel;
                    channel = fileOutputStream;
                    closeable3 = fileInputStream;
                    e.printStackTrace();
                    C0614e.m706a(closeable3);
                    C0614e.m706a(closeable2);
                    C0614e.m706a(channel);
                    C0614e.m706a(closeable);
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    closeable = null;
                    closeable3 = fileOutputStream;
                    C0614e.m706a(fileInputStream);
                    C0614e.m706a(channel);
                    C0614e.m706a(closeable3);
                    C0614e.m706a(closeable);
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                channel = null;
                closeable = null;
                closeable2 = null;
                closeable3 = fileInputStream;
                e.printStackTrace();
                C0614e.m706a(closeable3);
                C0614e.m706a(closeable2);
                C0614e.m706a(channel);
                C0614e.m706a(closeable);
                return false;
            } catch (Throwable th5) {
                th = th5;
                closeable = null;
                channel = null;
                C0614e.m706a(fileInputStream);
                C0614e.m706a(channel);
                C0614e.m706a(closeable3);
                C0614e.m706a(closeable);
                throw th;
            }
            try {
                channel.transferTo(0, channel.size(), closeable);
                C0614e.m706a(fileInputStream);
                C0614e.m706a(channel);
                C0614e.m706a(fileOutputStream);
                C0614e.m706a(closeable);
                return true;
            } catch (IOException e5) {
                e = e5;
                closeable3 = fileInputStream;
                closeable2 = channel;
                channel = fileOutputStream;
                e.printStackTrace();
                C0614e.m706a(closeable3);
                C0614e.m706a(closeable2);
                C0614e.m706a(channel);
                C0614e.m706a(closeable);
                return false;
            } catch (Throwable th6) {
                th = th6;
                closeable3 = fileOutputStream;
                C0614e.m706a(fileInputStream);
                C0614e.m706a(channel);
                C0614e.m706a(closeable3);
                C0614e.m706a(closeable);
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            channel = null;
            closeable = null;
            closeable2 = null;
            e.printStackTrace();
            C0614e.m706a(closeable3);
            C0614e.m706a(closeable2);
            C0614e.m706a(channel);
            C0614e.m706a(closeable);
            return false;
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
            closeable = null;
            channel = null;
            C0614e.m706a(fileInputStream);
            C0614e.m706a(channel);
            C0614e.m706a(closeable3);
            C0614e.m706a(closeable);
            throw th;
        }
    }

    public static void m710b(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                for (File delete : file.listFiles()) {
                    delete.delete();
                }
            }
        }
    }

    public static boolean m711b(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static String m712c(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf == -1 ? "" : str.substring(lastIndexOf);
    }

    public static boolean m713c(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    @NonNull
    public static String m714d(String str) {
        Object obj = null;
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(C0614e.m712c(str));
        if (fileExtensionFromUrl != null) {
            obj = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return TextUtils.isEmpty(obj) ? GalleryUtils.MIME_TYPE_ALL : obj;
    }
}
