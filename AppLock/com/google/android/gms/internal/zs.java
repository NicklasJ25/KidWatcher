package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.wx.C3415a;
import com.google.android.gms.internal.wx.C3416b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;

@wh
public class zs {
    public static final C3379a<Void> f11738a = new C35011();
    private static wc f11739b;
    private static final Object f11740c = new Object();

    public interface C3379a<T> {
        T mo4178b();

        T mo4179b(InputStream inputStream);
    }

    class C35011 implements C3379a<Void> {
        C35011() {
        }

        public /* bridge */ /* synthetic */ Object mo4178b() {
            return null;
        }

        public /* bridge */ /* synthetic */ Object mo4179b(InputStream inputStream) {
            return null;
        }
    }

    private static class C3507b<T> extends vb<InputStream> {
        private final C3379a<T> f11736a;
        private final C3416b<T> f11737b;

        class C35041 implements C3415a {
            final /* synthetic */ C3416b f11730a;
            final /* synthetic */ C3379a f11731b;

            C35041(C3416b c3416b, C3379a c3379a) {
                this.f11730a = c3416b;
                this.f11731b = c3379a;
            }

            public void mo4268a(abi com_google_android_gms_internal_abi) {
                this.f11730a.mo4271a(this.f11731b.mo4178b());
            }
        }

        public C3507b(String str, C3379a<T> c3379a, C3416b<T> c3416b) {
            super(0, str, new C35041(c3416b, c3379a));
            this.f11736a = c3379a;
            this.f11737b = c3416b;
        }

        protected wx<InputStream> mo3502a(sz szVar) {
            return wx.m14581a(new ByteArrayInputStream(szVar.f10641b), abo.m8803a(szVar));
        }

        protected void m15268a(final InputStream inputStream) {
            final aaj a = zk.m15080a(new Callable<T>(this) {
                final /* synthetic */ C3507b f11733b;

                public T call() {
                    return this.f11733b.f11736a.mo4179b(inputStream);
                }
            });
            a.mo3378b(new Runnable(this) {
                final /* synthetic */ C3507b f11735b;

                public void run() {
                    try {
                        this.f11735b.f11737b.mo4271a(a.get());
                    } catch (Throwable e) {
                        aad.m8422b("Error occured while dispatching http response in getter.", e);
                        zzw.zzcQ().m15000a(e, "HttpGetter.deliverResponse.1");
                    }
                }
            });
        }

        protected /* synthetic */ void mo3503a(Object obj) {
            m15268a((InputStream) obj);
        }
    }

    private class C3508c<T> extends aag<T> implements C3416b<T> {
        private C3508c(zs zsVar) {
        }

        public void mo4271a(@Nullable T t) {
            super.m8436b((Object) t);
        }
    }

    public zs(Context context) {
        m15271a(context);
    }

    private static wc m15271a(Context context) {
        wc wcVar;
        synchronized (f11740c) {
            if (f11739b == null) {
                f11739b = bf.m9106a(context.getApplicationContext());
            }
            wcVar = f11739b;
        }
        return wcVar;
    }

    public aaj<String> m15272a(int i, final String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        final Object c3508c = new C3508c();
        final byte[] bArr2 = bArr;
        final Map<String, String> map2 = map;
        f11739b.m14468a(new av(this, i, str, c3508c, new C3415a(this) {
            public void mo4268a(abi com_google_android_gms_internal_abi) {
                String str = str;
                String valueOf = String.valueOf(com_google_android_gms_internal_abi.toString());
                aad.m8426e(new StringBuilder((String.valueOf(str).length() + 21) + String.valueOf(valueOf).length()).append("Failed to load URL: ").append(str).append("\n").append(valueOf).toString());
                c3508c.mo4271a(null);
            }
        }) {
            public Map<String, String> mo4269f() {
                return map2 == null ? super.mo4269f() : map2;
            }

            public byte[] mo4270k() {
                return bArr2 == null ? super.mo4270k() : bArr2;
            }
        });
        return c3508c;
    }

    public <T> aaj<T> m15273a(String str, C3379a<T> c3379a) {
        Object c3508c = new C3508c();
        f11739b.m14468a(new C3507b(str, c3379a, c3508c));
        return c3508c;
    }

    public aaj<String> m15274a(String str, Map<String, String> map) {
        return m15272a(0, str, map, null);
    }
}
