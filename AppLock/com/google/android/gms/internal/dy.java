package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.util.C2580e;
import com.google.android.gms.common.util.C2581f;
import com.google.android.gms.internal.dz.C2829b;
import com.google.android.gms.internal.dz.C2830c;
import com.google.android.gms.internal.dz.C2831d;
import com.google.android.gms.internal.dz.C2832e;
import com.google.android.gms.internal.dz.C2833f;
import com.google.android.gms.internal.eb.C2839a;
import com.google.android.gms.internal.eb.C2840b;
import com.google.android.gms.internal.eb.C2841c;
import com.google.android.gms.internal.eb.C2842d;
import com.google.android.gms.internal.eb.C2843e;
import com.google.android.gms.internal.eb.C2844f;
import com.google.android.gms.internal.eb.C2845g;
import com.google.android.gms.measurement.AppMeasurement.C3517a;
import com.google.android.gms.measurement.AppMeasurement.C3523g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;

public class dy extends dn {
    private final AtomicLong f8706a = new AtomicLong(0);
    private int f8707b;

    dy(dk dkVar) {
        super(dkVar);
    }

    private Object m10358a(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Float ? Double.valueOf(((Float) obj).doubleValue()) : ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) ? m10392a(String.valueOf(obj), i, z) : null;
        } else {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
    }

    public static String m10359a(C2829b c2829b) {
        int i = 0;
        if (c2829b == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nevent_filter {\n");
        m10367a(stringBuilder, 0, "filter_id", c2829b.f8713a);
        m10367a(stringBuilder, 0, "event_name", c2829b.f8714b);
        m10364a(stringBuilder, 1, "event_count_filter", c2829b.f8717e);
        stringBuilder.append("  filters {\n");
        C2830c[] c2830cArr = c2829b.f8715c;
        int length = c2830cArr.length;
        while (i < length) {
            m10362a(stringBuilder, 2, c2830cArr[i]);
            i++;
        }
        m10361a(stringBuilder, 1);
        stringBuilder.append("}\n}\n");
        return stringBuilder.toString();
    }

    public static String m10360a(C2832e c2832e) {
        if (c2832e == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nproperty_filter {\n");
        m10367a(stringBuilder, 0, "filter_id", c2832e.f8729a);
        m10367a(stringBuilder, 0, "property_name", c2832e.f8730b);
        m10362a(stringBuilder, 1, c2832e.f8731c);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    private static void m10361a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
    }

    private static void m10362a(StringBuilder stringBuilder, int i, C2830c c2830c) {
        if (c2830c != null) {
            m10361a(stringBuilder, i);
            stringBuilder.append("filter {\n");
            m10367a(stringBuilder, i, "complement", c2830c.f8721c);
            m10367a(stringBuilder, i, "param_name", c2830c.f8722d);
            m10365a(stringBuilder, i + 1, "string_filter", c2830c.f8719a);
            m10364a(stringBuilder, i + 1, "number_filter", c2830c.f8720b);
            m10361a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m10363a(StringBuilder stringBuilder, int i, C2843e c2843e) {
        if (c2843e != null) {
            m10361a(stringBuilder, i);
            stringBuilder.append("bundle {\n");
            m10367a(stringBuilder, i, "protocol_version", c2843e.f8781a);
            m10367a(stringBuilder, i, "platform", c2843e.f8789i);
            m10367a(stringBuilder, i, "gmp_version", c2843e.f8797q);
            m10367a(stringBuilder, i, "uploading_gmp_version", c2843e.f8798r);
            m10367a(stringBuilder, i, "config_version", c2843e.f8779G);
            m10367a(stringBuilder, i, "gmp_app_id", c2843e.f8805y);
            m10367a(stringBuilder, i, "app_id", c2843e.f8795o);
            m10367a(stringBuilder, i, "app_version", c2843e.f8796p);
            m10367a(stringBuilder, i, "app_version_major", c2843e.f8775C);
            m10367a(stringBuilder, i, "app_version_minor", c2843e.f8776D);
            m10367a(stringBuilder, i, "app_version_release", c2843e.f8777E);
            m10367a(stringBuilder, i, "firebase_instance_id", c2843e.f8774B);
            m10367a(stringBuilder, i, "dev_cert_hash", c2843e.f8802v);
            m10367a(stringBuilder, i, "app_store", c2843e.f8794n);
            m10367a(stringBuilder, i, "upload_timestamp_millis", c2843e.f8784d);
            m10367a(stringBuilder, i, "start_timestamp_millis", c2843e.f8785e);
            m10367a(stringBuilder, i, "end_timestamp_millis", c2843e.f8786f);
            m10367a(stringBuilder, i, "previous_bundle_start_timestamp_millis", c2843e.f8787g);
            m10367a(stringBuilder, i, "previous_bundle_end_timestamp_millis", c2843e.f8788h);
            m10367a(stringBuilder, i, "app_instance_id", c2843e.f8801u);
            m10367a(stringBuilder, i, "resettable_device_id", c2843e.f8799s);
            m10367a(stringBuilder, i, "device_id", c2843e.f8778F);
            m10367a(stringBuilder, i, "limited_ad_tracking", c2843e.f8800t);
            m10367a(stringBuilder, i, "os_version", c2843e.f8790j);
            m10367a(stringBuilder, i, "device_model", c2843e.f8791k);
            m10367a(stringBuilder, i, "user_default_language", c2843e.f8792l);
            m10367a(stringBuilder, i, "time_zone_offset_minutes", c2843e.f8793m);
            m10367a(stringBuilder, i, "bundle_sequential_index", c2843e.f8803w);
            m10367a(stringBuilder, i, "service_upload", c2843e.f8806z);
            m10367a(stringBuilder, i, "health_monitor", c2843e.f8804x);
            if (c2843e.f8780H.longValue() != 0) {
                m10367a(stringBuilder, i, "android_id", c2843e.f8780H);
            }
            m10371a(stringBuilder, i, c2843e.f8783c);
            m10368a(stringBuilder, i, c2843e.f8773A);
            m10369a(stringBuilder, i, c2843e.f8782b);
            m10361a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m10364a(StringBuilder stringBuilder, int i, String str, C2831d c2831d) {
        if (c2831d != null) {
            m10361a(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (c2831d.f8723a != null) {
                Object obj = "UNKNOWN_COMPARISON_TYPE";
                switch (c2831d.f8723a.intValue()) {
                    case 1:
                        obj = "LESS_THAN";
                        break;
                    case 2:
                        obj = "GREATER_THAN";
                        break;
                    case 3:
                        obj = "EQUAL";
                        break;
                    case 4:
                        obj = "BETWEEN";
                        break;
                }
                m10367a(stringBuilder, i, "comparison_type", obj);
            }
            m10367a(stringBuilder, i, "match_as_float", c2831d.f8724b);
            m10367a(stringBuilder, i, "comparison_value", c2831d.f8725c);
            m10367a(stringBuilder, i, "min_comparison_value", c2831d.f8726d);
            m10367a(stringBuilder, i, "max_comparison_value", c2831d.f8727e);
            m10361a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m10365a(StringBuilder stringBuilder, int i, String str, C2833f c2833f) {
        if (c2833f != null) {
            m10361a(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (c2833f.f8732a != null) {
                Object obj = "UNKNOWN_MATCH_TYPE";
                switch (c2833f.f8732a.intValue()) {
                    case 1:
                        obj = "REGEXP";
                        break;
                    case 2:
                        obj = "BEGINS_WITH";
                        break;
                    case 3:
                        obj = "ENDS_WITH";
                        break;
                    case 4:
                        obj = "PARTIAL";
                        break;
                    case 5:
                        obj = "EXACT";
                        break;
                    case 6:
                        obj = "IN_LIST";
                        break;
                }
                m10367a(stringBuilder, i, "match_type", obj);
            }
            m10367a(stringBuilder, i, "expression", c2833f.f8733b);
            m10367a(stringBuilder, i, "case_sensitive", c2833f.f8734c);
            if (c2833f.f8735d.length > 0) {
                m10361a(stringBuilder, i + 1);
                stringBuilder.append("expression_list {\n");
                for (String str2 : c2833f.f8735d) {
                    m10361a(stringBuilder, i + 2);
                    stringBuilder.append(str2);
                    stringBuilder.append("\n");
                }
                stringBuilder.append("}\n");
            }
            m10361a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m10366a(StringBuilder stringBuilder, int i, String str, C2844f c2844f) {
        int i2 = 0;
        if (c2844f != null) {
            int i3;
            int i4;
            int i5 = i + 1;
            m10361a(stringBuilder, i5);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (c2844f.f8808b != null) {
                m10361a(stringBuilder, i5 + 1);
                stringBuilder.append("results: ");
                long[] jArr = c2844f.f8808b;
                int length = jArr.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length) {
                    Long valueOf = Long.valueOf(jArr[i3]);
                    int i6 = i4 + 1;
                    if (i4 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf);
                    i3++;
                    i4 = i6;
                }
                stringBuilder.append('\n');
            }
            if (c2844f.f8807a != null) {
                m10361a(stringBuilder, i5 + 1);
                stringBuilder.append("status: ");
                long[] jArr2 = c2844f.f8807a;
                int length2 = jArr2.length;
                i3 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    i4 = i3 + 1;
                    if (i3 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf2);
                    i2++;
                    i3 = i4;
                }
                stringBuilder.append('\n');
            }
            m10361a(stringBuilder, i5);
            stringBuilder.append("}\n");
        }
    }

    private static void m10367a(StringBuilder stringBuilder, int i, String str, Object obj) {
        if (obj != null) {
            m10361a(stringBuilder, i + 1);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
    }

    private static void m10368a(StringBuilder stringBuilder, int i, C2839a[] c2839aArr) {
        if (c2839aArr != null) {
            int i2 = i + 1;
            for (C2839a c2839a : c2839aArr) {
                if (c2839a != null) {
                    m10361a(stringBuilder, i2);
                    stringBuilder.append("audience_membership {\n");
                    m10367a(stringBuilder, i2, "audience_id", c2839a.f8755a);
                    m10367a(stringBuilder, i2, "new_audience", c2839a.f8758d);
                    m10366a(stringBuilder, i2, "current_data", c2839a.f8756b);
                    m10366a(stringBuilder, i2, "previous_data", c2839a.f8757c);
                    m10361a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void m10369a(StringBuilder stringBuilder, int i, C2840b[] c2840bArr) {
        if (c2840bArr != null) {
            int i2 = i + 1;
            for (C2840b c2840b : c2840bArr) {
                if (c2840b != null) {
                    m10361a(stringBuilder, i2);
                    stringBuilder.append("event {\n");
                    m10367a(stringBuilder, i2, "name", c2840b.f8761b);
                    m10367a(stringBuilder, i2, "timestamp_millis", c2840b.f8762c);
                    m10367a(stringBuilder, i2, "previous_timestamp_millis", c2840b.f8763d);
                    m10367a(stringBuilder, i2, "count", c2840b.f8764e);
                    m10370a(stringBuilder, i2, c2840b.f8760a);
                    m10361a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void m10370a(StringBuilder stringBuilder, int i, C2841c[] c2841cArr) {
        if (c2841cArr != null) {
            int i2 = i + 1;
            for (C2841c c2841c : c2841cArr) {
                if (c2841c != null) {
                    m10361a(stringBuilder, i2);
                    stringBuilder.append("param {\n");
                    m10367a(stringBuilder, i2, "name", c2841c.f8766a);
                    m10367a(stringBuilder, i2, "string_value", c2841c.f8767b);
                    m10367a(stringBuilder, i2, "int_value", c2841c.f8768c);
                    m10367a(stringBuilder, i2, "double_value", c2841c.f8770e);
                    m10361a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void m10371a(StringBuilder stringBuilder, int i, C2845g[] c2845gArr) {
        if (c2845gArr != null) {
            int i2 = i + 1;
            for (C2845g c2845g : c2845gArr) {
                if (c2845g != null) {
                    m10361a(stringBuilder, i2);
                    stringBuilder.append("user_property {\n");
                    m10367a(stringBuilder, i2, "set_timestamp_millis", c2845g.f8810a);
                    m10367a(stringBuilder, i2, "name", c2845g.f8811b);
                    m10367a(stringBuilder, i2, "string_value", c2845g.f8812c);
                    m10367a(stringBuilder, i2, "int_value", c2845g.f8813d);
                    m10367a(stringBuilder, i2, "double_value", c2845g.f8815f);
                    m10361a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    public static boolean m10372a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 4);
            return serviceInfo != null && serviceInfo.enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean m10373a(Context context, String str, boolean z) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ActivityInfo receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, str), 2);
            return (receiverInfo == null || !receiverInfo.enabled) ? false : !z || receiverInfo.exported;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    static boolean m10374a(String str) {
        C2513c.m7934a(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static boolean m10375a(long[] jArr, int i) {
        return i < jArr.length * 64 && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    public static long[] m10376a(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i * 64) + i2 < bitSet.length()) {
                if (bitSet.get((i * 64) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    public static Object m10377b(Object obj) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        if (obj == null) {
            return null;
        }
        ObjectInputStream objectInputStream;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = null;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                throw th;
            }
            try {
                Object readObject = objectInputStream.readObject();
                try {
                    objectOutputStream.close();
                    objectInputStream.close();
                    return readObject;
                } catch (IOException e) {
                    return null;
                } catch (ClassNotFoundException e2) {
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw th;
        }
    }

    public static String m10378b(C2842d c2842d) {
        if (c2842d == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (c2842d.f8771a != null) {
            for (C2843e c2843e : c2842d.f8771a) {
                if (c2843e != null) {
                    m10363a(stringBuilder, 1, c2843e);
                }
            }
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    static long m10379c(byte[] bArr) {
        long j = null;
        C2513c.m7932a((Object) bArr);
        C2513c.m7937a(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    public static boolean m10380c(String str, String str2) {
        return (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
    }

    static MessageDigest m10381j(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    public static boolean m10382l(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean m10383n(String str) {
        return str != null && str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    private int m10384r(String str) {
        return "_ldl".equals(str) ? mo3550w().m9473F() : mo3550w().m9472E();
    }

    public int m10385a(String str, Object obj, boolean z) {
        if (z && !m10406a("param", str, mo3550w().m9471D(), obj)) {
            return 17;
        }
        return m10382l(str) ? m10407a("param", str, mo3550w().m9470C(), obj, z) : m10407a("param", str, mo3550w().m9469B(), obj, z) ? 0 : 4;
    }

    public Bundle m10386a(@NonNull Uri uri) {
        Bundle bundle = null;
        if (uri != null) {
            try {
                Object queryParameter;
                Object queryParameter2;
                Object queryParameter3;
                Object queryParameter4;
                if (uri.isHierarchical()) {
                    queryParameter = uri.getQueryParameter("utm_campaign");
                    queryParameter2 = uri.getQueryParameter("utm_source");
                    queryParameter3 = uri.getQueryParameter("utm_medium");
                    queryParameter4 = uri.getQueryParameter("gclid");
                } else {
                    queryParameter4 = null;
                    queryParameter3 = null;
                    queryParameter2 = null;
                    queryParameter = null;
                }
                if (!(TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4))) {
                    bundle = new Bundle();
                    if (!TextUtils.isEmpty(queryParameter)) {
                        bundle.putString("campaign", queryParameter);
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        bundle.putString("source", queryParameter2);
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        bundle.putString("medium", queryParameter3);
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("gclid", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("utm_term");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("term", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("utm_content");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("content", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("aclid");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("aclid", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("cp1");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("cp1", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("anid");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("anid", queryParameter4);
                    }
                }
            } catch (UnsupportedOperationException e) {
                mo3548u().m9817z().m9775a("Install referrer url isn't a hierarchical URI", e);
            }
        }
        return bundle;
    }

    Bundle m10387a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object a = m10391a(str, bundle.get(str));
                if (a == null) {
                    mo3548u().m9817z().m9775a("Param value can't be null", str);
                } else {
                    m10396a(bundle2, str, a);
                }
            }
        }
        return bundle2;
    }

    public Bundle m10388a(String str, Bundle bundle, @Nullable List<String> list, boolean z, boolean z2) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        mo3550w().m9530x();
        int i = 0;
        for (String str2 : bundle.keySet()) {
            int f;
            if (list == null || !list.contains(str2)) {
                f = z ? m10428f(str2) : 0;
                if (f == 0) {
                    f = m10430g(str2);
                }
            } else {
                f = 0;
            }
            if (f != 0) {
                if (m10402a(bundle2, f)) {
                    bundle2.putString("_ev", m10392a(str2, mo3550w().m9468A(), true));
                    if (f == 3) {
                        m10395a(bundle2, (Object) str2);
                    }
                }
                bundle2.remove(str2);
            } else {
                f = m10385a(str2, bundle.get(str2), z2);
                if (f == 0 || "_ev".equals(str2)) {
                    if (m10374a(str2)) {
                        i++;
                        if (i > 25) {
                            mo3548u().m9815x().m9776a("Event can't contain more then " + 25 + " params", str, bundle);
                            m10402a(bundle2, 5);
                            bundle2.remove(str2);
                        }
                    }
                    i = i;
                } else {
                    if (m10402a(bundle2, f)) {
                        bundle2.putString("_ev", m10392a(str2, mo3550w().m9468A(), true));
                        m10395a(bundle2, bundle.get(str2));
                    }
                    bundle2.remove(str2);
                }
            }
        }
        return bundle2;
    }

    <T extends Parcelable> T m10389a(byte[] bArr, Creator<T> creator) {
        T t;
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            t = (Parcelable) creator.createFromParcel(obtain);
            return t;
        } catch (C2550a e) {
            t = mo3548u().m9815x();
            t.m9774a("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    zzatq m10390a(String str, Bundle bundle, String str2, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (m10419c(str) != 0) {
            mo3548u().m9815x().m9775a("Invalid conditional property event name", str);
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        Bundle a = m10388a(str, bundle2, C2581f.m8276a((Object) "_o"), z2, false);
        return new zzatq(str, new zzato(z ? m10387a(a) : a), str2, j);
    }

    public Object m10391a(String str, Object obj) {
        if ("_ev".equals(str)) {
            return m10358a(mo3550w().m9470C(), obj, true);
        }
        return m10358a(m10382l(str) ? mo3550w().m9470C() : mo3550w().m9469B(), obj, false);
    }

    public String m10392a(String str, int i, boolean z) {
        return str.length() > i ? z ? String.valueOf(str.substring(0, i)).concat("...") : null : str;
    }

    protected void mo3551a() {
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                mo3548u().m9817z().m9774a("Utils falling back to Random for random id");
            }
        }
        this.f8706a.set(nextLong);
    }

    public void m10394a(int i, String str, String str2, int i2) {
        m10399a(null, i, str, str2, i2);
    }

    public void m10395a(Bundle bundle, Object obj) {
        C2513c.m7932a((Object) bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    public void m10396a(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                mo3548u().m9783A().m9776a("Not putting event parameter. Invalid value type. name, type", str, obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public void m10397a(C2841c c2841c, Object obj) {
        C2513c.m7932a(obj);
        c2841c.f8767b = null;
        c2841c.f8768c = null;
        c2841c.f8770e = null;
        if (obj instanceof String) {
            c2841c.f8767b = (String) obj;
        } else if (obj instanceof Long) {
            c2841c.f8768c = (Long) obj;
        } else if (obj instanceof Double) {
            c2841c.f8770e = (Double) obj;
        } else {
            mo3548u().m9815x().m9775a("Ignoring invalid (type) event param value", obj);
        }
    }

    public void m10398a(C2845g c2845g, Object obj) {
        C2513c.m7932a(obj);
        c2845g.f8812c = null;
        c2845g.f8813d = null;
        c2845g.f8815f = null;
        if (obj instanceof String) {
            c2845g.f8812c = (String) obj;
        } else if (obj instanceof Long) {
            c2845g.f8813d = (Long) obj;
        } else if (obj instanceof Double) {
            c2845g.f8815f = (Double) obj;
        } else {
            mo3548u().m9815x().m9775a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public void m10399a(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        m10402a(bundle, i);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.n.m10030d().m9490W();
        this.n.m10040l().m10136a("auto", "_err", bundle);
    }

    public boolean m10400a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(mo3540m().mo3360a() - j) > j2;
    }

    public boolean m10401a(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    public boolean m10402a(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    @WorkerThread
    boolean m10403a(zzatq com_google_android_gms_internal_zzatq, zzatd com_google_android_gms_internal_zzatd) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatq);
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatd);
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzatd.f11798b)) {
            return true;
        }
        mo3550w().m9490W();
        return false;
    }

    boolean m10404a(String str, int i, String str2) {
        if (str2 == null) {
            mo3548u().m9815x().m9775a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() <= i) {
            return true;
        } else {
            mo3548u().m9815x().m9777a("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    boolean m10405a(String str, String str2) {
        if (str2 == null) {
            mo3548u().m9815x().m9775a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            mo3548u().m9815x().m9775a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt)) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        mo3548u().m9815x().m9776a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            mo3548u().m9815x().m9776a("Name must start with a letter. Type, name", str, str2);
            return false;
        }
    }

    boolean m10406a(String str, String str2, int i, Object obj) {
        int length;
        if (obj instanceof Parcelable[]) {
            length = ((Parcelable[]) obj).length;
        } else if (!(obj instanceof ArrayList)) {
            return true;
        } else {
            length = ((ArrayList) obj).size();
        }
        if (length <= i) {
            return true;
        }
        mo3548u().m9817z().m9777a("Parameter array is too long; discarded. Value kind, name, array length", str, str2, Integer.valueOf(length));
        return false;
    }

    boolean m10407a(String str, String str2, int i, Object obj, boolean z) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String valueOf = String.valueOf(obj);
            if (valueOf.length() <= i) {
                return true;
            }
            mo3548u().m9817z().m9777a("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
            return false;
        } else if ((obj instanceof Bundle) && z) {
            return true;
        } else {
            if ((obj instanceof Parcelable[]) && z) {
                Parcelable[] parcelableArr = (Parcelable[]) obj;
                int length = parcelableArr.length;
                int i2 = 0;
                while (i2 < length) {
                    Object obj2 = parcelableArr[i2];
                    if (obj2 instanceof Bundle) {
                        i2++;
                    } else {
                        mo3548u().m9817z().m9776a("All Parcelable[] elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof ArrayList) || !z) {
                return false;
            } else {
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!(next instanceof Bundle)) {
                        mo3548u().m9817z().m9776a("All ArrayList elements must be of type Bundle. Value type, name", next.getClass(), str2);
                        return false;
                    }
                }
                return true;
            }
        }
    }

    boolean m10408a(String str, Map<String, String> map, String str2) {
        if (str2 == null) {
            mo3548u().m9815x().m9775a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.startsWith("firebase_")) {
            mo3548u().m9815x().m9776a("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (map == null || !map.containsKey(str2)) {
            return true;
        } else {
            mo3548u().m9815x().m9776a("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    byte[] m10409a(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            return marshall;
        } finally {
            obtain.recycle();
        }
    }

    public byte[] m10410a(C2842d c2842d) {
        try {
            byte[] bArr = new byte[c2842d.m9131g()];
            lu a = lu.m12365a(bArr);
            c2842d.mo3506a(a);
            a.m12409b();
            return bArr;
        } catch (IOException e) {
            mo3548u().m9815x().m9775a("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public byte[] m10411a(byte[] bArr) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            mo3548u().m9815x().m9775a("Failed to gzip content", e);
            throw e;
        }
    }

    public Bundle[] m10412a(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        } else if (obj instanceof Parcelable[]) {
            return (Bundle[]) Arrays.copyOf((Parcelable[]) obj, ((Parcelable[]) obj).length, Bundle[].class);
        } else {
            if (!(obj instanceof ArrayList)) {
                return null;
            }
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    public int m10413b(String str) {
        return !m10405a("event", str) ? 2 : !m10408a("event", C3517a.f12109a, str) ? 13 : m10404a("event", mo3550w().m9531y(), str) ? 0 : 2;
    }

    public int m10414b(String str, Object obj) {
        return "_ldl".equals(str) ? m10407a("user property referrer", str, m10384r(str), obj, false) : m10407a("user property", str, m10384r(str), obj, false) ? 0 : 7;
    }

    @WorkerThread
    long m10415b(Context context, String str) {
        mo3532e();
        C2513c.m7932a((Object) context);
        C2513c.m7934a(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest j = m10381j("MD5");
        if (j == null) {
            mo3548u().m9815x().m9774a("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!m10422c(context, str)) {
                    PackageInfo b = bm.m9120b(context).m9118b(mo3541n().getPackageName(), 64);
                    if (b.signatures != null && b.signatures.length > 0) {
                        return m10379c(j.digest(b.signatures[0].toByteArray()));
                    }
                    mo3548u().m9817z().m9774a("Could not get signatures");
                    return -1;
                }
            } catch (NameNotFoundException e) {
                mo3548u().m9815x().m9775a("Package name not found", e);
            }
        }
        return 0;
    }

    public /* bridge */ /* synthetic */ void mo3529b() {
        super.mo3529b();
    }

    boolean m10417b(String str, String str2) {
        if (str2 == null) {
            mo3548u().m9815x().m9775a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            mo3548u().m9815x().m9775a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        mo3548u().m9815x().m9776a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            mo3548u().m9815x().m9776a("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    public byte[] m10418b(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            mo3548u().m9815x().m9775a("Failed to ungzip content", e);
            throw e;
        }
    }

    public int m10419c(String str) {
        return !m10417b("event", str) ? 2 : !m10408a("event", C3517a.f12109a, str) ? 13 : m10404a("event", mo3550w().m9531y(), str) ? 0 : 2;
    }

    public Object m10420c(String str, Object obj) {
        return "_ldl".equals(str) ? m10358a(m10384r(str), obj, true) : m10358a(m10384r(str), obj, false);
    }

    public /* bridge */ /* synthetic */ void mo3530c() {
        super.mo3530c();
    }

    boolean m10422c(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo b = bm.m9120b(context).m9118b(str, 64);
            if (!(b == null || b.signatures == null || b.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(b.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
        } catch (CertificateException e) {
            mo3548u().m9815x().m9775a("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            mo3548u().m9815x().m9775a("Package name not found", e2);
        }
        return true;
    }

    public int m10423d(String str) {
        return !m10405a("user property", str) ? 6 : !m10408a("user property", C3523g.f12111a, str) ? 15 : m10404a("user property", mo3550w().m9532z(), str) ? 0 : 6;
    }

    @WorkerThread
    public long m10424d(byte[] bArr) {
        C2513c.m7932a((Object) bArr);
        mo3532e();
        MessageDigest j = m10381j("MD5");
        if (j != null) {
            return m10379c(j.digest(bArr));
        }
        mo3548u().m9815x().m9774a("Failed to get MD5");
        return 0;
    }

    public /* bridge */ /* synthetic */ void mo3531d() {
        super.mo3531d();
    }

    public int m10426e(String str) {
        return !m10417b("user property", str) ? 6 : !m10408a("user property", C3523g.f12111a, str) ? 15 : m10404a("user property", mo3550w().m9532z(), str) ? 0 : 6;
    }

    public /* bridge */ /* synthetic */ void mo3532e() {
        super.mo3532e();
    }

    public int m10428f(String str) {
        return !m10405a("event param", str) ? 3 : !m10408a("event param", null, str) ? 14 : m10404a("event param", mo3550w().m9468A(), str) ? 0 : 3;
    }

    public /* bridge */ /* synthetic */ ck mo3533f() {
        return super.mo3533f();
    }

    public int m10430g(String str) {
        return !m10417b("event param", str) ? 3 : !m10408a("event param", null, str) ? 14 : m10404a("event param", mo3550w().m9468A(), str) ? 0 : 3;
    }

    public /* bridge */ /* synthetic */ cn mo3534g() {
        return super.mo3534g();
    }

    public /* bridge */ /* synthetic */ dp mo3535h() {
        return super.mo3535h();
    }

    public boolean m10433h(String str) {
        if (TextUtils.isEmpty(str)) {
            mo3548u().m9815x().m9774a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        } else if (m10435i(str)) {
            return true;
        } else {
            mo3548u().m9815x().m9775a("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
            return false;
        }
    }

    public /* bridge */ /* synthetic */ cz mo3536i() {
        return super.mo3536i();
    }

    boolean m10435i(String str) {
        C2513c.m7932a((Object) str);
        return str.matches("^1:\\d+:android:[a-f0-9]+$");
    }

    public /* bridge */ /* synthetic */ cs mo3537j() {
        return super.mo3537j();
    }

    public /* bridge */ /* synthetic */ dr mo3538k() {
        return super.mo3538k();
    }

    @WorkerThread
    public boolean m10438k(String str) {
        mo3532e();
        if (bm.m9120b(mo3541n()).m9112a(str) == 0) {
            return true;
        }
        mo3548u().m9785C().m9775a("Permission not granted", str);
        return false;
    }

    public /* bridge */ /* synthetic */ dq mo3539l() {
        return super.mo3539l();
    }

    public /* bridge */ /* synthetic */ C2580e mo3540m() {
        return super.mo3540m();
    }

    public boolean m10441m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String av = mo3550w().av();
        mo3550w().m9490W();
        return av.equals(str);
    }

    public /* bridge */ /* synthetic */ Context mo3541n() {
        return super.mo3541n();
    }

    public /* bridge */ /* synthetic */ da mo3542o() {
        return super.mo3542o();
    }

    boolean m10444o(String str) {
        return "1".equals(mo3545r().m9894a(str, "measurement.upload.blacklist_internal"));
    }

    public /* bridge */ /* synthetic */ cq mo3543p() {
        return super.mo3543p();
    }

    boolean m10446p(String str) {
        return "1".equals(mo3545r().m9894a(str, "measurement.upload.blacklist_public"));
    }

    public /* bridge */ /* synthetic */ dy mo3544q() {
        return super.mo3544q();
    }

    @WorkerThread
    boolean m10448q(String str) {
        C2513c.m7934a(str);
        boolean z = true;
        switch (str.hashCode()) {
            case 94660:
                if (str.equals("_in")) {
                    z = false;
                    break;
                }
                break;
            case 95025:
                if (str.equals("_ug")) {
                    z = true;
                    break;
                }
                break;
            case 95027:
                if (str.equals("_ui")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    public /* bridge */ /* synthetic */ di mo3545r() {
        return super.mo3545r();
    }

    public /* bridge */ /* synthetic */ dt mo3546s() {
        return super.mo3546s();
    }

    public /* bridge */ /* synthetic */ dj mo3547t() {
        return super.mo3547t();
    }

    public /* bridge */ /* synthetic */ dc mo3548u() {
        return super.mo3548u();
    }

    public /* bridge */ /* synthetic */ dg mo3549v() {
        return super.mo3549v();
    }

    public /* bridge */ /* synthetic */ cp mo3550w() {
        return super.mo3550w();
    }

    public long m10455x() {
        long nextLong;
        if (this.f8706a.get() == 0) {
            synchronized (this.f8706a) {
                nextLong = new Random(System.nanoTime() ^ mo3540m().mo3360a()).nextLong();
                int i = this.f8707b + 1;
                this.f8707b = i;
                nextLong += (long) i;
            }
        } else {
            synchronized (this.f8706a) {
                this.f8706a.compareAndSet(-1, 1);
                nextLong = this.f8706a.getAndIncrement();
            }
        }
        return nextLong;
    }
}
