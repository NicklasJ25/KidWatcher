package com.google.android.exoplayer2.p042d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.google.android.exoplayer2.p043j.C2273r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class C2108d {
    private static final C2098a f5914a = C2098a.m6376a("OMX.google.raw.decoder");
    private static final Pattern f5915b = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<C2103a, List<C2098a>> f5916c = new HashMap();
    private static final Map<Integer, Integer> f5917d = new HashMap();
    private static final Map<Integer, Integer> f5918e = new HashMap();
    private static final Map<String, Integer> f5919f = new HashMap();
    private static int f5920g = -1;

    private static final class C2103a {
        public final String f5910a;
        public final boolean f5911b;

        public C2103a(String str, boolean z) {
            this.f5910a = str;
            this.f5911b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != C2103a.class) {
                return false;
            }
            C2103a c2103a = (C2103a) obj;
            return TextUtils.equals(this.f5910a, c2103a.f5910a) && this.f5911b == c2103a.f5911b;
        }

        public int hashCode() {
            return (this.f5911b ? 1231 : 1237) + (((this.f5910a == null ? 0 : this.f5910a.hashCode()) + 31) * 31);
        }
    }

    public static class C2104b extends Exception {
        private C2104b(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    private interface C2105c {
        int mo3004a();

        MediaCodecInfo mo3005a(int i);

        boolean mo3006a(String str, CodecCapabilities codecCapabilities);

        boolean mo3007b();
    }

    private static final class C2106d implements C2105c {
        private C2106d() {
        }

        public int mo3004a() {
            return MediaCodecList.getCodecCount();
        }

        public MediaCodecInfo mo3005a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        public boolean mo3006a(String str, CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }

        public boolean mo3007b() {
            return false;
        }
    }

    @TargetApi(21)
    private static final class C2107e implements C2105c {
        private final int f5912a;
        private MediaCodecInfo[] f5913b;

        public C2107e(boolean z) {
            this.f5912a = z ? 1 : 0;
        }

        private void m6400c() {
            if (this.f5913b == null) {
                this.f5913b = new MediaCodecList(this.f5912a).getCodecInfos();
            }
        }

        public int mo3004a() {
            m6400c();
            return this.f5913b.length;
        }

        public MediaCodecInfo mo3005a(int i) {
            m6400c();
            return this.f5913b[i];
        }

        public boolean mo3006a(String str, CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        public boolean mo3007b() {
            return true;
        }
    }

    static {
        f5917d.put(Integer.valueOf(66), Integer.valueOf(1));
        f5917d.put(Integer.valueOf(77), Integer.valueOf(2));
        f5917d.put(Integer.valueOf(88), Integer.valueOf(4));
        f5917d.put(Integer.valueOf(100), Integer.valueOf(8));
        f5918e.put(Integer.valueOf(10), Integer.valueOf(1));
        f5918e.put(Integer.valueOf(11), Integer.valueOf(4));
        f5918e.put(Integer.valueOf(12), Integer.valueOf(8));
        f5918e.put(Integer.valueOf(13), Integer.valueOf(16));
        f5918e.put(Integer.valueOf(20), Integer.valueOf(32));
        f5918e.put(Integer.valueOf(21), Integer.valueOf(64));
        f5918e.put(Integer.valueOf(22), Integer.valueOf(128));
        f5918e.put(Integer.valueOf(30), Integer.valueOf(256));
        f5918e.put(Integer.valueOf(31), Integer.valueOf(512));
        f5918e.put(Integer.valueOf(32), Integer.valueOf(1024));
        f5918e.put(Integer.valueOf(40), Integer.valueOf(2048));
        f5918e.put(Integer.valueOf(41), Integer.valueOf(4096));
        f5918e.put(Integer.valueOf(42), Integer.valueOf(8192));
        f5918e.put(Integer.valueOf(50), Integer.valueOf(16384));
        f5918e.put(Integer.valueOf(51), Integer.valueOf(32768));
        f5918e.put(Integer.valueOf(52), Integer.valueOf(65536));
        f5919f.put("L30", Integer.valueOf(1));
        f5919f.put("L60", Integer.valueOf(4));
        f5919f.put("L63", Integer.valueOf(16));
        f5919f.put("L90", Integer.valueOf(64));
        f5919f.put("L93", Integer.valueOf(256));
        f5919f.put("L120", Integer.valueOf(1024));
        f5919f.put("L123", Integer.valueOf(4096));
        f5919f.put("L150", Integer.valueOf(16384));
        f5919f.put("L153", Integer.valueOf(65536));
        f5919f.put("L156", Integer.valueOf(262144));
        f5919f.put("L180", Integer.valueOf(1048576));
        f5919f.put("L183", Integer.valueOf(AccessibilityEventCompat.TYPE_WINDOWS_CHANGED));
        f5919f.put("L186", Integer.valueOf(16777216));
        f5919f.put("H30", Integer.valueOf(2));
        f5919f.put("H60", Integer.valueOf(8));
        f5919f.put("H63", Integer.valueOf(32));
        f5919f.put("H90", Integer.valueOf(128));
        f5919f.put("H93", Integer.valueOf(512));
        f5919f.put("H120", Integer.valueOf(2048));
        f5919f.put("H123", Integer.valueOf(8192));
        f5919f.put("H150", Integer.valueOf(32768));
        f5919f.put("H153", Integer.valueOf(131072));
        f5919f.put("H156", Integer.valueOf(524288));
        f5919f.put("H180", Integer.valueOf(2097152));
        f5919f.put("H183", Integer.valueOf(8388608));
        f5919f.put("H186", Integer.valueOf(33554432));
    }

    private static int m6405a(int i) {
        switch (i) {
            case 1:
            case 2:
                return 25344;
            case 8:
                return 101376;
            case 16:
                return 101376;
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
                return 414720;
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
                return 2097152;
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
                return 9437184;
            default:
                return -1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> m6406a(java.lang.String r6) {
        /*
        r0 = 0;
        r1 = 0;
        if (r6 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = "\\.";
        r3 = r6.split(r2);
        r4 = r3[r1];
        r2 = -1;
        r5 = r4.hashCode();
        switch(r5) {
            case 3006243: goto L_0x0032;
            case 3006244: goto L_0x003c;
            case 3199032: goto L_0x001f;
            case 3214780: goto L_0x0028;
            default: goto L_0x0015;
        };
    L_0x0015:
        r1 = r2;
    L_0x0016:
        switch(r1) {
            case 0: goto L_0x001a;
            case 1: goto L_0x001a;
            case 2: goto L_0x0046;
            case 3: goto L_0x0046;
            default: goto L_0x0019;
        };
    L_0x0019:
        goto L_0x0004;
    L_0x001a:
        r0 = com.google.android.exoplayer2.p042d.C2108d.m6407a(r6, r3);
        goto L_0x0004;
    L_0x001f:
        r5 = "hev1";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x0015;
    L_0x0027:
        goto L_0x0016;
    L_0x0028:
        r1 = "hvc1";
        r1 = r4.equals(r1);
        if (r1 == 0) goto L_0x0015;
    L_0x0030:
        r1 = 1;
        goto L_0x0016;
    L_0x0032:
        r1 = "avc1";
        r1 = r4.equals(r1);
        if (r1 == 0) goto L_0x0015;
    L_0x003a:
        r1 = 2;
        goto L_0x0016;
    L_0x003c:
        r1 = "avc2";
        r1 = r4.equals(r1);
        if (r1 == 0) goto L_0x0015;
    L_0x0044:
        r1 = 3;
        goto L_0x0016;
    L_0x0046:
        r0 = com.google.android.exoplayer2.p042d.C2108d.m6413b(r6, r3);
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.d.d.a(java.lang.String):android.util.Pair<java.lang.Integer, java.lang.Integer>");
    }

    private static Pair<Integer, Integer> m6407a(String str, String[] strArr) {
        if (strArr.length < 4) {
            Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        Matcher matcher = f5915b.matcher(strArr[1]);
        if (matcher.matches()) {
            int i;
            String group = matcher.group(1);
            if ("1".equals(group)) {
                i = 1;
            } else if (GpsMeasureMode.MODE_2_DIMENSIONAL.equals(group)) {
                i = 2;
            } else {
                Log.w("MediaCodecUtil", "Unknown HEVC profile string: " + group);
                return null;
            }
            Integer num = (Integer) f5919f.get(strArr[3]);
            if (num != null) {
                return new Pair(Integer.valueOf(i), num);
            }
            Log.w("MediaCodecUtil", "Unknown HEVC level string: " + matcher.group(1));
            return null;
        }
        Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
        return null;
    }

    public static C2098a m6408a() {
        return f5914a;
    }

    public static C2098a m6409a(String str, boolean z) {
        List b = C2108d.m6414b(str, z);
        return b.isEmpty() ? null : (C2098a) b.get(0);
    }

    private static List<C2098a> m6410a(C2103a c2103a, C2105c c2105c) {
        String name;
        try {
            List<C2098a> arrayList = new ArrayList();
            String str = c2103a.f5910a;
            int a = c2105c.mo3004a();
            boolean b = c2105c.mo3007b();
            loop0:
            for (int i = 0; i < a; i++) {
                MediaCodecInfo a2 = c2105c.mo3005a(i);
                name = a2.getName();
                if (C2108d.m6411a(a2, name, b)) {
                    for (String str2 : a2.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            CodecCapabilities capabilitiesForType = a2.getCapabilitiesForType(str2);
                            boolean a3 = c2105c.mo3006a(str, capabilitiesForType);
                            if ((!b || c2103a.f5911b != a3) && (b || c2103a.f5911b)) {
                                if (!b && a3) {
                                    arrayList.add(C2098a.m6377a(name + ".secure", str, capabilitiesForType));
                                    break loop0;
                                }
                            }
                            arrayList.add(C2098a.m6377a(name, str, capabilitiesForType));
                        }
                    }
                    continue;
                }
            }
            return arrayList;
        } catch (Exception e) {
            if (C2273r.f6478a > 23 || arrayList.isEmpty()) {
                Log.e("MediaCodecUtil", "Failed to query codec " + name + " (" + str2 + ")");
                throw e;
            }
            Log.e("MediaCodecUtil", "Skipping codec " + name + " (failed to query capabilities)");
        } catch (Throwable e2) {
            throw new C2104b(e2);
        }
    }

    private static boolean m6411a(MediaCodecInfo mediaCodecInfo, String str, boolean z) {
        return !mediaCodecInfo.isEncoder() ? (z || !str.endsWith(".secure")) ? (C2273r.f6478a >= 21 || !("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) ? (C2273r.f6478a >= 18 || !"OMX.SEC.MP3.Decoder".equals(str)) ? (C2273r.f6478a < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && "a70".equals(C2273r.f6479b)) ? false : (C2273r.f6478a == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(C2273r.f6479b) || "protou".equals(C2273r.f6479b) || "ville".equals(C2273r.f6479b) || "villeplus".equals(C2273r.f6479b) || "villec2".equals(C2273r.f6479b) || C2273r.f6479b.startsWith("gee") || "C6602".equals(C2273r.f6479b) || "C6603".equals(C2273r.f6479b) || "C6606".equals(C2273r.f6479b) || "C6616".equals(C2273r.f6479b) || "L36h".equals(C2273r.f6479b) || "SO-02E".equals(C2273r.f6479b))) ? false : (C2273r.f6478a == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(C2273r.f6479b) || "C1505".equals(C2273r.f6479b) || "C1604".equals(C2273r.f6479b) || "C1605".equals(C2273r.f6479b))) ? false : (C2273r.f6478a > 19 || !((C2273r.f6479b.startsWith("d2") || C2273r.f6479b.startsWith("serrano") || C2273r.f6479b.startsWith("jflte") || C2273r.f6479b.startsWith("santos")) && "samsung".equals(C2273r.f6480c) && "OMX.SEC.vp8.dec".equals(str))) ? (C2273r.f6478a <= 19 && C2273r.f6479b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) ? false : true : false : false : false : false : false;
    }

    public static int m6412b() {
        int i = 0;
        if (f5920g == -1) {
            C2098a a = C2108d.m6409a("video/avc", false);
            if (a != null) {
                CodecProfileLevel[] a2 = a.m6383a();
                int length = a2.length;
                int i2 = 0;
                while (i < length) {
                    i2 = Math.max(C2108d.m6405a(a2[i].level), i2);
                    i++;
                }
                i = Math.max(i2, 172800);
            }
            f5920g = i;
        }
        return f5920g;
    }

    private static Pair<Integer, Integer> m6413b(String str, String[] strArr) {
        if (strArr.length < 2) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            Object valueOf;
            Object valueOf2;
            if (strArr[1].length() == 6) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                Integer valueOf3 = Integer.valueOf(Integer.parseInt(strArr[2]));
            } else {
                Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            Integer num = (Integer) f5917d.get(valueOf);
            if (num == null) {
                Log.w("MediaCodecUtil", "Unknown AVC profile: " + valueOf);
                return null;
            }
            Integer num2 = (Integer) f5918e.get(valueOf2);
            if (num2 != null) {
                return new Pair(num, num2);
            }
            Log.w("MediaCodecUtil", "Unknown AVC level: " + valueOf2);
            return null;
        } catch (NumberFormatException e) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    public static synchronized List<C2098a> m6414b(String str, boolean z) {
        List<C2098a> list;
        synchronized (C2108d.class) {
            C2103a c2103a = new C2103a(str, z);
            list = (List) f5916c.get(c2103a);
            if (list == null) {
                List a = C2108d.m6410a(c2103a, C2273r.f6478a >= 21 ? new C2107e(z) : new C2106d());
                if (z && a.isEmpty() && 21 <= C2273r.f6478a && C2273r.f6478a <= 23) {
                    List a2 = C2108d.m6410a(c2103a, new C2106d());
                    if (!a2.isEmpty()) {
                        Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((C2098a) a2.get(0)).f5901a);
                    }
                    a = a2;
                }
                list = Collections.unmodifiableList(a);
                f5916c.put(c2103a, list);
            }
        }
        return list;
    }
}
