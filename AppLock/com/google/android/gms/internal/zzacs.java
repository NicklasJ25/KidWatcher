package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C2512b;
import com.google.android.gms.common.internal.C2512b.C2511a;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2578c;
import com.google.android.gms.common.util.C2587l;
import com.google.android.gms.common.util.C2588m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class zzacs {

    public interface C3510a<I, O> {
        I mo4272a(O o);
    }

    public static class zza<I, O> extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final bb CREATOR = new bb();
        protected final int f11763a;
        protected final boolean f11764b;
        protected final int f11765c;
        protected final boolean f11766d;
        protected final String f11767e;
        protected final int f11768f;
        protected final Class<? extends zzacs> f11769g;
        protected final String f11770h;
        private final int f11771i;
        private zzacw f11772j;
        private C3510a<I, O> f11773k;

        zza(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, zzacn com_google_android_gms_internal_zzacn) {
            this.f11771i = i;
            this.f11763a = i2;
            this.f11764b = z;
            this.f11765c = i3;
            this.f11766d = z2;
            this.f11767e = str;
            this.f11768f = i4;
            if (str2 == null) {
                this.f11769g = null;
                this.f11770h = null;
            } else {
                this.f11769g = zzacz.class;
                this.f11770h = str2;
            }
            if (com_google_android_gms_internal_zzacn == null) {
                this.f11773k = null;
            } else {
                this.f11773k = com_google_android_gms_internal_zzacn.m15288b();
            }
        }

        public int m15296a() {
            return this.f11771i;
        }

        public I m15297a(O o) {
            return this.f11773k.mo4272a(o);
        }

        public void m15298a(zzacw com_google_android_gms_internal_zzacw) {
            this.f11772j = com_google_android_gms_internal_zzacw;
        }

        public int m15299b() {
            return this.f11763a;
        }

        public boolean m15300c() {
            return this.f11764b;
        }

        public int m15301d() {
            return this.f11765c;
        }

        public boolean m15302e() {
            return this.f11766d;
        }

        public String m15303f() {
            return this.f11767e;
        }

        public int m15304g() {
            return this.f11768f;
        }

        public Class<? extends zzacs> m15305h() {
            return this.f11769g;
        }

        String m15306i() {
            return this.f11770h == null ? null : this.f11770h;
        }

        public boolean m15307j() {
            return this.f11773k != null;
        }

        zzacn m15308k() {
            return this.f11773k == null ? null : zzacn.m15286a(this.f11773k);
        }

        public Map<String, zza<?, ?>> m15309l() {
            C2513c.m7932a(this.f11770h);
            C2513c.m7932a(this.f11772j);
            return this.f11772j.m15325a(this.f11770h);
        }

        public String toString() {
            C2511a a = C2512b.m7930a((Object) this).m7928a("versionCode", Integer.valueOf(this.f11771i)).m7928a("typeIn", Integer.valueOf(this.f11763a)).m7928a("typeInArray", Boolean.valueOf(this.f11764b)).m7928a("typeOut", Integer.valueOf(this.f11765c)).m7928a("typeOutArray", Boolean.valueOf(this.f11766d)).m7928a("outputFieldName", this.f11767e).m7928a("safeParcelFieldId", Integer.valueOf(this.f11768f)).m7928a("concreteTypeName", m15306i());
            Class h = m15305h();
            if (h != null) {
                a.m7928a("concreteType.class", h.getCanonicalName());
            }
            if (this.f11773k != null) {
                a.m7928a("converterName", this.f11773k.getClass().getCanonicalName());
            }
            return a.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            bb.m9094a(this, parcel, i);
        }
    }

    private void m15310a(StringBuilder stringBuilder, zza com_google_android_gms_internal_zzacs_zza, Object obj) {
        if (com_google_android_gms_internal_zzacs_zza.m15299b() == 11) {
            stringBuilder.append(((zzacs) com_google_android_gms_internal_zzacs_zza.m15305h().cast(obj)).toString());
        } else if (com_google_android_gms_internal_zzacs_zza.m15299b() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(C2587l.m8303a((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private void m15311a(StringBuilder stringBuilder, zza com_google_android_gms_internal_zzacs_zza, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m15310a(stringBuilder, com_google_android_gms_internal_zzacs_zza, obj);
            }
        }
        stringBuilder.append("]");
    }

    protected <O, I> I m15312a(zza<I, O> com_google_android_gms_internal_zzacs_zza_I__O, Object obj) {
        return com_google_android_gms_internal_zzacs_zza_I__O.f11773k != null ? com_google_android_gms_internal_zzacs_zza_I__O.m15297a(obj) : obj;
    }

    protected abstract Object mo4273a(String str);

    public abstract Map<String, zza<?, ?>> mo4275a();

    protected boolean m15315a(zza com_google_android_gms_internal_zzacs_zza) {
        return com_google_android_gms_internal_zzacs_zza.m15301d() == 11 ? com_google_android_gms_internal_zzacs_zza.m15302e() ? m15319d(com_google_android_gms_internal_zzacs_zza.m15303f()) : m15318c(com_google_android_gms_internal_zzacs_zza.m15303f()) : mo4274b(com_google_android_gms_internal_zzacs_zza.m15303f());
    }

    protected Object m15316b(zza com_google_android_gms_internal_zzacs_zza) {
        String f = com_google_android_gms_internal_zzacs_zza.m15303f();
        if (com_google_android_gms_internal_zzacs_zza.m15305h() == null) {
            return mo4273a(com_google_android_gms_internal_zzacs_zza.m15303f());
        }
        mo4273a(com_google_android_gms_internal_zzacs_zza.m15303f());
        C2513c.m7939a(true, "Concrete field shouldn't be value object: %s", com_google_android_gms_internal_zzacs_zza.m15303f());
        com_google_android_gms_internal_zzacs_zza.m15302e();
        try {
            char toUpperCase = Character.toUpperCase(f.charAt(0));
            f = String.valueOf(f.substring(1));
            return getClass().getMethod(new StringBuilder(String.valueOf(f).length() + 4).append("get").append(toUpperCase).append(f).toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract boolean mo4274b(String str);

    protected boolean m15318c(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean m15319d(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public String toString() {
        Map a = mo4275a();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : a.keySet()) {
            zza com_google_android_gms_internal_zzacs_zza = (zza) a.get(str);
            if (m15315a(com_google_android_gms_internal_zzacs_zza)) {
                Object a2 = m15312a(com_google_android_gms_internal_zzacs_zza, m15316b(com_google_android_gms_internal_zzacs_zza));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a2 != null) {
                    switch (com_google_android_gms_internal_zzacs_zza.m15301d()) {
                        case 8:
                            stringBuilder.append("\"").append(C2578c.m8270a((byte[]) a2)).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(C2578c.m8271b((byte[]) a2)).append("\"");
                            break;
                        case 10:
                            C2588m.m8304a(stringBuilder, (HashMap) a2);
                            break;
                        default:
                            if (!com_google_android_gms_internal_zzacs_zza.m15300c()) {
                                m15310a(stringBuilder, com_google_android_gms_internal_zzacs_zza, a2);
                                break;
                            }
                            m15311a(stringBuilder, com_google_android_gms_internal_zzacs_zza, (ArrayList) a2);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
