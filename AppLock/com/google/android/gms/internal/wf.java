package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.wg.C3392a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;

@wh
public class wf implements wg {
    private static final Object f11160a = new Object();
    private static wg f11161b = null;
    private final Object f11162c = new Object();
    private final String f11163d;
    private final zzqh f11164e;
    private final WeakHashMap<Thread, Boolean> f11165f = new WeakHashMap();

    wf(String str, zzqh com_google_android_gms_internal_zzqh) {
        this.f11163d = str;
        this.f11164e = com_google_android_gms_internal_zzqh;
        m14483b();
        m14482a();
    }

    public static wg m14481a(Context context, zzqh com_google_android_gms_internal_zzqh) {
        synchronized (f11160a) {
            if (f11161b == null) {
                if (((Boolean) qb.f10294g.m13225c()).booleanValue()) {
                    String str = EnvironmentCompat.MEDIA_UNKNOWN;
                    try {
                        str = context.getApplicationContext().getPackageName();
                    } catch (Throwable th) {
                        aad.m8426e("Cannot obtain package name, proceeding.");
                    }
                    f11161b = new wf(str, com_google_android_gms_internal_zzqh);
                } else {
                    f11161b = new C3392a();
                }
            }
        }
        return f11161b;
    }

    private void m14482a() {
        final UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler(this) {
            final /* synthetic */ wf f11157b;

            public void uncaughtException(java.lang.Thread r3, java.lang.Throwable r4) {
                /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = r2.f11157b;	 Catch:{ Throwable -> 0x000f, all -> 0x001f }
                r0.m14487a(r3, r4);	 Catch:{ Throwable -> 0x000f, all -> 0x001f }
                r0 = r0;
                if (r0 == 0) goto L_0x000e;
            L_0x0009:
                r0 = r0;
                r0.uncaughtException(r3, r4);
            L_0x000e:
                return;
            L_0x000f:
                r0 = move-exception;
                r0 = "AdMob exception reporter failed reporting the exception.";	 Catch:{ Throwable -> 0x000f, all -> 0x001f }
                com.google.android.gms.internal.aad.m8423c(r0);	 Catch:{ Throwable -> 0x000f, all -> 0x001f }
                r0 = r0;
                if (r0 == 0) goto L_0x000e;
            L_0x0019:
                r0 = r0;
                r0.uncaughtException(r3, r4);
                goto L_0x000e;
            L_0x001f:
                r0 = move-exception;
                r1 = r0;
                if (r1 == 0) goto L_0x0029;
            L_0x0024:
                r1 = r0;
                r1.uncaughtException(r3, r4);
            L_0x0029:
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.wf.1.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
            }
        });
    }

    private void m14483b() {
        m14486a(Looper.getMainLooper().getThread());
    }

    private Throwable m14484c(Throwable th) {
        if (((Boolean) qb.f10295h.m13225c()).booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th2 = null;
        while (!linkedList.isEmpty()) {
            Throwable th3;
            Throwable th4 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th4.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
            int i = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (m14489a(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    i = 1;
                } else if (m14492b(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                } else {
                    arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                }
            }
            if (i != 0) {
                th3 = th2 == null ? new Throwable(th4.getMessage()) : new Throwable(th4.getMessage(), th2);
                th3.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            } else {
                th3 = th2;
            }
            th2 = th3;
        }
        return th2;
    }

    String m14485a(Class cls, Throwable th, String str) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT)).appendQueryParameter("device", zzw.zzcM().m15154e()).appendQueryParameter("js", this.f11164e.f12081a).appendQueryParameter("appid", this.f11163d).appendQueryParameter("exceptiontype", cls.getName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", qb.m13267a())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "155828604").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", zzw.zzcQ().m14989a()).toString();
    }

    public void m14486a(Thread thread) {
        if (thread != null) {
            synchronized (this.f11162c) {
                this.f11165f.put(thread, Boolean.valueOf(true));
            }
            final UncaughtExceptionHandler uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
            thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler(this) {
                final /* synthetic */ wf f11159b;

                public void uncaughtException(java.lang.Thread r3, java.lang.Throwable r4) {
                    /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f11159b;	 Catch:{ Throwable -> 0x000f, all -> 0x001f }
                    r0.m14487a(r3, r4);	 Catch:{ Throwable -> 0x000f, all -> 0x001f }
                    r0 = r0;
                    if (r0 == 0) goto L_0x000e;
                L_0x0009:
                    r0 = r0;
                    r0.uncaughtException(r3, r4);
                L_0x000e:
                    return;
                L_0x000f:
                    r0 = move-exception;
                    r0 = "AdMob exception reporter failed reporting the exception.";	 Catch:{ Throwable -> 0x000f, all -> 0x001f }
                    com.google.android.gms.internal.aad.m8423c(r0);	 Catch:{ Throwable -> 0x000f, all -> 0x001f }
                    r0 = r0;
                    if (r0 == 0) goto L_0x000e;
                L_0x0019:
                    r0 = r0;
                    r0.uncaughtException(r3, r4);
                    goto L_0x000e;
                L_0x001f:
                    r0 = move-exception;
                    r1 = r0;
                    if (r1 == 0) goto L_0x0029;
                L_0x0024:
                    r1 = r0;
                    r1.uncaughtException(r3, r4);
                L_0x0029:
                    throw r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.wf.2.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
                }
            });
        }
    }

    protected void m14487a(Thread thread, Throwable th) {
        if (m14490a(th)) {
            m14491b(th);
        }
    }

    public void mo4182a(Throwable th, String str) {
        Throwable c = m14484c(th);
        if (c != null) {
            Class cls = th.getClass();
            List arrayList = new ArrayList();
            arrayList.add(m14485a(cls, c, str));
            zzw.zzcM().m15126a(arrayList, zzw.zzcQ().m15020i());
        }
    }

    protected boolean m14489a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith((String) qb.f10296i.m13225c())) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(wh.class);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "Fail to check class type for class ";
            String valueOf = String.valueOf(str);
            aad.m8419a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            return false;
        }
    }

    protected boolean m14490a(Throwable th) {
        boolean z = true;
        if (th == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (m14489a(stackTraceElement.getClassName())) {
                    z3 = true;
                }
                if (getClass().getName().equals(stackTraceElement.getClassName())) {
                    z2 = true;
                }
            }
            th = th.getCause();
        }
        if (!z3 || r2) {
            z = false;
        }
        return z;
    }

    public void m14491b(Throwable th) {
        mo4182a(th, "");
    }

    protected boolean m14492b(String str) {
        return TextUtils.isEmpty(str) ? false : str.startsWith("android.") || str.startsWith("java.");
    }
}
