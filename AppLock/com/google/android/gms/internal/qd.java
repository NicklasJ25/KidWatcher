package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@wh
public class qd {
    BlockingQueue<qj> f10320a;
    ExecutorService f10321b;
    LinkedHashMap<String, String> f10322c = new LinkedHashMap();
    Map<String, qg> f10323d = new HashMap();
    String f10324e;
    final Context f10325f;
    final String f10326g;
    private AtomicBoolean f10327h;
    private File f10328i;

    class C31691 implements Runnable {
        final /* synthetic */ qd f10319a;

        C31691(qd qdVar) {
            this.f10319a = qdVar;
        }

        public void run() {
            this.f10319a.m13275a();
        }
    }

    public qd(Context context, String str, String str2, Map<String, String> map) {
        this.f10325f = context;
        this.f10326g = str;
        this.f10324e = str2;
        this.f10327h = new AtomicBoolean(false);
        this.f10327h.set(((Boolean) qb.f10282V.m13225c()).booleanValue());
        if (this.f10327h.get()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                this.f10328i = new File(externalStorageDirectory, "sdk_csi_data.txt");
            }
        }
        for (Entry entry : map.entrySet()) {
            this.f10322c.put((String) entry.getKey(), (String) entry.getValue());
        }
        this.f10320a = new ArrayBlockingQueue(30);
        this.f10321b = Executors.newSingleThreadExecutor();
        this.f10321b.execute(new C31691(this));
        this.f10323d.put("action", qg.f10330b);
        this.f10323d.put("ad_format", qg.f10330b);
        this.f10323d.put("e", qg.f10331c);
    }

    private void m13275a() {
        while (true) {
            try {
                qj qjVar = (qj) this.f10320a.take();
                String c = qjVar.m13309c();
                if (!TextUtils.isEmpty(c)) {
                    m13278a(m13281a(this.f10322c, qjVar.m13310d()), c);
                }
            } catch (Throwable e) {
                aad.m8424c("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    private void m13277a(@Nullable File file, String str) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (file != null) {
            try {
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.write(10);
                    try {
                        fileOutputStream.close();
                        return;
                    } catch (Throwable e2) {
                        aad.m8424c("CsiReporter: Cannot close file: sdk_csi_data.txt.", e2);
                        return;
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        aad.m8424c("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e2);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (Throwable e22) {
                                aad.m8424c("CsiReporter: Cannot close file: sdk_csi_data.txt.", e22);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e22 = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e4) {
                                aad.m8424c("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                            }
                        }
                        throw e22;
                    }
                }
            } catch (IOException e5) {
                e22 = e5;
                fileOutputStream = null;
                aad.m8424c("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e22);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                e22 = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e22;
            }
        }
        aad.m8426e("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
    }

    private void m13278a(Map<String, String> map, String str) {
        String a = m13280a(this.f10324e, map, str);
        if (this.f10327h.get()) {
            m13277a(this.f10328i, a);
        } else {
            zzw.zzcM().m15141b(this.f10325f, this.f10326g, a);
        }
    }

    public qg m13279a(String str) {
        qg qgVar = (qg) this.f10323d.get(str);
        return qgVar != null ? qgVar : qg.f10329a;
    }

    String m13280a(String str, Map<String, String> map, @NonNull String str2) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (Entry entry : map.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        StringBuilder stringBuilder = new StringBuilder(buildUpon.build().toString());
        stringBuilder.append("&").append("it").append("=").append(str2);
        return stringBuilder.toString();
    }

    Map<String, String> m13281a(Map<String, String> map, @Nullable Map<String, String> map2) {
        Map<String, String> linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, m13279a(str).mo3907a(str2, (String) entry.getValue()));
        }
        return linkedHashMap;
    }

    public void m13282a(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.f10322c.put("e", TextUtils.join(",", list));
        }
    }

    public boolean m13283a(qj qjVar) {
        return this.f10320a.offer(qjVar);
    }
}
