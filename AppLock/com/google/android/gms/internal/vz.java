package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.internal.aai.C2636a;
import com.google.android.gms.internal.qz.C3180a;
import com.google.android.gms.internal.vy.C3196a;
import com.google.android.gms.internal.yy.C3457a;
import com.google.android.gms.internal.zs.C3379a;
import com.google.android.gms.p065a.C2312b;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@wh
public class vz implements Callable<yy> {
    static long f11103a = TimeUnit.SECONDS.toMillis(60);
    private final Context f11104b;
    private final zs f11105c;
    private final zzs f11106d;
    private final ed f11107e;
    private final vy f11108f;
    private final Object f11109g = new Object();
    private final C3457a f11110h;
    private final qj f11111i;
    private boolean f11112j;
    private int f11113k;
    private List<String> f11114l;
    private JSONObject f11115m;
    private String f11116n;

    public interface C3381a<T extends C3180a> {
        T mo4181a(vz vzVar, JSONObject jSONObject);
    }

    class C3382b {
        public sc f11102a;

        C3382b(vz vzVar) {
        }
    }

    public vz(Context context, zzs com_google_android_gms_ads_internal_zzs, zs zsVar, ed edVar, C3457a c3457a, qj qjVar) {
        this.f11104b = context;
        this.f11106d = com_google_android_gms_ads_internal_zzs;
        this.f11105c = zsVar;
        this.f11110h = c3457a;
        this.f11107e = edVar;
        this.f11111i = qjVar;
        this.f11108f = m14440a(context, c3457a, com_google_android_gms_ads_internal_zzs, edVar);
        this.f11108f.m14403a();
        this.f11112j = false;
        this.f11113k = -2;
        this.f11114l = null;
        this.f11116n = null;
    }

    private aaj<qs> m14424a(JSONObject jSONObject, boolean z, boolean z2) {
        final String string = z ? jSONObject.getString("url") : jSONObject.optString("url");
        final double optDouble = jSONObject.optDouble("scale", 1.0d);
        final boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        if (TextUtils.isEmpty(string)) {
            m14447a(0, z);
            return new aah(null);
        } else if (z2) {
            return new aah(new qs(null, Uri.parse(string), optDouble));
        } else {
            final boolean z3 = z;
            return this.f11105c.m15273a(string, new C3379a<qs>(this) {
                final /* synthetic */ vz f11101e;

                public qs m14419a() {
                    this.f11101e.m14447a(2, z3);
                    return null;
                }

                @TargetApi(19)
                public qs m14420a(InputStream inputStream) {
                    Bitmap decodeStream;
                    Options options = new Options();
                    options.inDensity = (int) (160.0d * optDouble);
                    if (!optBoolean) {
                        options.inPreferredConfig = Config.RGB_565;
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    try {
                        decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                    } catch (Throwable e) {
                        aad.m8422b("Error grabbing image.", e);
                        decodeStream = null;
                    }
                    if (decodeStream == null) {
                        this.f11101e.m14447a(2, z3);
                        return null;
                    }
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    if (C2590o.m8312g() && zh.m15053b()) {
                        int width = decodeStream.getWidth();
                        int height = decodeStream.getHeight();
                        zh.m15051a("Decoded image w: " + width + " h:" + height + " bytes: " + decodeStream.getAllocationByteCount() + " time: " + (uptimeMillis2 - uptimeMillis) + " on ui thread: " + (Looper.getMainLooper().getThread() == Thread.currentThread()));
                    }
                    return new qs(new BitmapDrawable(Resources.getSystem(), decodeStream), Uri.parse(string), optDouble);
                }

                public /* synthetic */ Object mo4178b() {
                    return m14419a();
                }

                @TargetApi(19)
                public /* synthetic */ Object mo4179b(InputStream inputStream) {
                    return m14420a(inputStream);
                }
            });
        }
    }

    static aat m14425a(aaj<aat> com_google_android_gms_internal_aaj_com_google_android_gms_internal_aat) {
        Throwable e;
        try {
            return (aat) com_google_android_gms_internal_aaj_com_google_android_gms_internal_aat.get((long) ((Integer) qb.cm.m13225c()).intValue(), TimeUnit.SECONDS);
        } catch (Throwable e2) {
            aad.m8424c("InterruptedException occurred while waiting for video to load", e2);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e3) {
            e2 = e3;
            aad.m8424c("Exception occurred while waiting for video to load", e2);
        } catch (TimeoutException e4) {
            e2 = e4;
            aad.m8424c("Exception occurred while waiting for video to load", e2);
        } catch (CancellationException e5) {
            e2 = e5;
            aad.m8424c("Exception occurred while waiting for video to load", e2);
        }
        return null;
    }

    private C3180a m14426a(C3381a c3381a, JSONObject jSONObject, String str) {
        if (m14449b() || c3381a == null || jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("tracking_urls_and_actions");
        String[] c = m14437c(jSONObject2, "impression_tracking_urls");
        this.f11114l = c == null ? null : Arrays.asList(c);
        this.f11115m = jSONObject2.optJSONObject("active_view");
        this.f11116n = jSONObject.optString("debug_signals");
        C3180a a = c3381a.mo4181a(this, jSONObject);
        if (a == null) {
            aad.m8423c("Failed to retrieve ad assets.");
            return null;
        }
        a.mo3923a(new ra(this.f11104b, this.f11106d, this.f11108f, this.f11107e, jSONObject, a, this.f11110h.f11509a.f12002k, str));
        return a;
    }

    private JSONObject m14429a(final String str) {
        if (m14449b()) {
            return null;
        }
        final aag com_google_android_gms_internal_aag = new aag();
        final C3382b c3382b = new C3382b(this);
        this.f11108f.m14404a(new C3196a(this) {
            final /* synthetic */ vz f11082d;

            public void mo4176a() {
                com_google_android_gms_internal_aag.m8436b(null);
            }

            public void mo3974a(final tj tjVar) {
                sc c33731 = new sc(this) {
                    final /* synthetic */ C33741 f11078b;

                    public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
                        try {
                            JSONObject jSONObject;
                            int i;
                            String str = (String) map.get("success");
                            String str2 = (String) map.get("failure");
                            if (TextUtils.isEmpty(str2)) {
                                jSONObject = new JSONObject(str);
                                i = 1;
                            } else {
                                jSONObject = new JSONObject(str2);
                                i = 0;
                            }
                            if (str.equals(jSONObject.optString("ads_id", ""))) {
                                tjVar.mo3409b("/nativeAdPreProcess", c3382b.f11102a);
                                if (i != 0) {
                                    JSONArray optJSONArray = jSONObject.optJSONArray("ads");
                                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                                        this.f11078b.f11082d.m14446a(3);
                                        com_google_android_gms_internal_aag.m8436b(null);
                                        return;
                                    }
                                    com_google_android_gms_internal_aag.m8436b(optJSONArray.getJSONObject(0));
                                    return;
                                }
                                this.f11078b.f11082d.m14446a(0);
                                C2513c.m7938a(this.f11078b.f11082d.m14449b(), (Object) "Unable to set the ad state error!");
                                com_google_android_gms_internal_aag.m8436b(null);
                            }
                        } catch (Throwable e) {
                            aad.m8422b("Malformed native JSON response.", e);
                        }
                    }
                };
                c3382b.f11102a = c33731;
                tjVar.mo3402a("/nativeAdPreProcess", c33731);
                try {
                    JSONObject jSONObject = new JSONObject(this.f11082d.f11110h.f11510b.f12037c);
                    jSONObject.put("ads_id", str);
                    tjVar.mo3385a("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
                } catch (Throwable e) {
                    aad.m8424c("Exception occurred while invoking javascript", e);
                    com_google_android_gms_internal_aag.m8436b(null);
                }
            }
        });
        return (JSONObject) com_google_android_gms_internal_aag.get(f11103a, TimeUnit.MILLISECONDS);
    }

    private void m14430a(C3180a c3180a) {
        if (c3180a instanceof qv) {
            final qv qvVar = (qv) c3180a;
            C3382b c3382b = new C3382b(this);
            final sc c33763 = new sc(this) {
                final /* synthetic */ vz f11087b;

                public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
                    this.f11087b.m14431a(qvVar, (String) map.get("asset"));
                }
            };
            c3382b.f11102a = c33763;
            this.f11108f.m14404a(new C3196a(this) {
                public void mo3974a(tj tjVar) {
                    tjVar.mo3402a("/nativeAdCustomClick", c33763);
                }
            });
        }
    }

    private void m14431a(rl rlVar, String str) {
        try {
            rp zzz = this.f11106d.zzz(rlVar.mo3934l());
            if (zzz != null) {
                zzz.mo4011a(rlVar, str);
            }
        } catch (Throwable e) {
            aad.m8424c(new StringBuilder(String.valueOf(str).length() + 40).append("Failed to call onCustomClick for asset ").append(str).append(".").toString(), e);
        }
    }

    private yy m14434b(C3180a c3180a) {
        int i;
        synchronized (this.f11109g) {
            i = this.f11113k;
            if (c3180a == null && this.f11113k == -2) {
                i = 0;
            }
        }
        return new yy(this.f11110h.f11509a.f11994c, null, this.f11110h.f11510b.f12038d, i, this.f11110h.f11510b.f12040f, this.f11114l, this.f11110h.f11510b.f12046l, this.f11110h.f11510b.f12045k, this.f11110h.f11509a.f12000i, false, null, null, null, null, null, 0, this.f11110h.f11512d, this.f11110h.f11510b.f12041g, this.f11110h.f11514f, this.f11110h.f11515g, this.f11110h.f11510b.f12049o, this.f11115m, i != -2 ? null : c3180a, null, null, null, this.f11110h.f11510b.f12023F, this.f11110h.f11510b.f12024G, null, this.f11110h.f11510b.f12027J, this.f11116n);
    }

    private Integer m14435b(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    private static List<Drawable> m14436b(List<qs> list) {
        List<Drawable> arrayList = new ArrayList();
        for (qs a : list) {
            arrayList.add((Drawable) C2312b.m7328a(a.mo3919a()));
        }
        return arrayList;
    }

    private String[] m14437c(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    public aaj<aat> m14438a(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return new aah(null);
        }
        if (!TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
            return m14442a(this.f11104b, this.f11107e, this.f11110h, this.f11111i, this.f11106d).m14464a(optJSONObject);
        }
        aad.m8426e("Required field 'vast_xml' is missing");
        return new aah(null);
    }

    public aaj<qs> m14439a(JSONObject jSONObject, String str, boolean z, boolean z2) {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return m14424a(jSONObject2, z, z2);
    }

    vy m14440a(Context context, C3457a c3457a, zzs com_google_android_gms_ads_internal_zzs, ed edVar) {
        return new vy(context, c3457a, com_google_android_gms_ads_internal_zzs, edVar);
    }

    protected C3381a m14441a(JSONObject jSONObject) {
        if (m14449b() || jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.f11110h.f11509a.f12016y != null ? this.f11110h.f11509a.f12016y.f11922b : false;
        boolean z2 = this.f11110h.f11509a.f12016y != null ? this.f11110h.f11509a.f12016y.f11924d : false;
        if (GpsMeasureMode.MODE_2_DIMENSIONAL.equals(string)) {
            return new wb(z, z2);
        }
        if ("1".equals(string)) {
            return new wd(z, z2);
        }
        if (GpsMeasureMode.MODE_3_DIMENSIONAL.equals(string)) {
            final String string2 = jSONObject.getString("custom_template_id");
            final aag com_google_android_gms_internal_aag = new aag();
            zl.f11678a.post(new Runnable(this) {
                final /* synthetic */ vz f11085c;

                public void run() {
                    com_google_android_gms_internal_aag.m8436b((rq) this.f11085c.f11106d.zzcu().get(string2));
                }
            });
            if (com_google_android_gms_internal_aag.get(f11103a, TimeUnit.MILLISECONDS) != null) {
                return new we(z);
            }
            string2 = "No handler for custom template: ";
            String valueOf = String.valueOf(jSONObject.getString("custom_template_id"));
            aad.m8423c(valueOf.length() != 0 ? string2.concat(valueOf) : new String(string2));
        } else {
            m14446a(0);
        }
        return null;
    }

    wa m14442a(Context context, ed edVar, C3457a c3457a, qj qjVar, zzs com_google_android_gms_ads_internal_zzs) {
        return new wa(context, edVar, c3457a, qjVar, com_google_android_gms_ads_internal_zzs);
    }

    public yy m14443a() {
        try {
            this.f11108f.m14405b();
            String c = m14450c();
            JSONObject a = m14429a(c);
            C3180a a2 = m14426a(m14441a(a), a, c);
            m14430a(a2);
            return m14434b(a2);
        } catch (CancellationException e) {
            if (!this.f11112j) {
                m14446a(0);
            }
            return m14434b(null);
        } catch (ExecutionException e2) {
            if (this.f11112j) {
                m14446a(0);
            }
            return m14434b(null);
        } catch (InterruptedException e3) {
            if (this.f11112j) {
                m14446a(0);
            }
            return m14434b(null);
        } catch (Throwable e4) {
            aad.m8424c("Malformed native JSON response.", e4);
            if (this.f11112j) {
                m14446a(0);
            }
            return m14434b(null);
        } catch (Throwable e42) {
            aad.m8424c("Timeout when loading native ad.", e42);
            if (this.f11112j) {
                m14446a(0);
            }
            return m14434b(null);
        }
    }

    public List<aaj<qs>> m14444a(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        List<aaj<qs>> arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            m14447a(0, z);
            return arrayList;
        }
        int length = z3 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(m14424a(jSONObject2, z, z2));
        }
        return arrayList;
    }

    public Future<qs> m14445a(JSONObject jSONObject, String str, boolean z) {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return m14424a(jSONObject2, optBoolean, z);
    }

    public void m14446a(int i) {
        synchronized (this.f11109g) {
            this.f11112j = true;
            this.f11113k = i;
        }
    }

    public void m14447a(int i, boolean z) {
        if (z) {
            m14446a(i);
        }
    }

    public aaj<qq> m14448b(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return new aah(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer b = m14435b(optJSONObject, "text_color");
        Integer b2 = m14435b(optJSONObject, "bg_color");
        final int optInt2 = optJSONObject.optInt("animation_ms", 1000);
        final int optInt3 = optJSONObject.optInt("presentation_ms", 4000);
        final int i = (this.f11110h.f11509a.f12016y == null || this.f11110h.f11509a.f12016y.f11921a < 2) ? 1 : this.f11110h.f11509a.f12016y.f11925e;
        final boolean optBoolean = optJSONObject.optBoolean("allow_pub_rendering");
        List arrayList = new ArrayList();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = m14444a(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(m14439a(optJSONObject, "image", false, false));
        }
        final String str = optString;
        final Integer num = b2;
        final Integer num2 = b;
        final int i2 = optInt;
        return aai.m8441a(aai.m8442a(arrayList), new C2636a<List<qs>, qq>(this) {
            public qq m14415a(List<qs> list) {
                qq qqVar;
                if (list != null) {
                    try {
                        if (!list.isEmpty()) {
                            qqVar = new qq(str, vz.m14436b((List) list), num, num2, i2 > 0 ? Integer.valueOf(i2) : null, optInt3 + optInt2, i, optBoolean);
                            return qqVar;
                        }
                    } catch (Throwable e) {
                        aad.m8422b("Could not get attribution icon", e);
                        return null;
                    }
                }
                qqVar = null;
                return qqVar;
            }

            public /* synthetic */ Object mo4177a(Object obj) {
                return m14415a((List) obj);
            }
        });
    }

    public boolean m14449b() {
        boolean z;
        synchronized (this.f11109g) {
            z = this.f11112j;
        }
        return z;
    }

    String m14450c() {
        return UUID.randomUUID().toString();
    }

    public /* synthetic */ Object call() {
        return m14443a();
    }
}
