package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.google.android.gms.ads.internal.zzg.zza;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.aat;
import com.google.android.gms.internal.aau.C2340a;
import com.google.android.gms.internal.qt;
import com.google.android.gms.internal.qu;
import com.google.android.gms.internal.rd;
import com.google.android.gms.internal.rd.C3178a;
import com.google.android.gms.internal.sc;
import com.google.android.gms.internal.tv;
import com.google.android.gms.internal.uf;
import com.google.android.gms.internal.ug;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.yy;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

@wh
public class zzp {

    class C23901 implements C2340a {
        final /* synthetic */ qt f7009a;
        final /* synthetic */ String f7010b;
        final /* synthetic */ aat f7011c;

        C23901(qt qtVar, String str, aat com_google_android_gms_internal_aat) {
            this.f7009a = qtVar;
            this.f7010b = str;
            this.f7011c = com_google_android_gms_internal_aat;
        }

        public void mo3168a(aat com_google_android_gms_internal_aat, boolean z) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("headline", this.f7009a.mo3922a());
                jSONObject.put("body", this.f7009a.mo3925c());
                jSONObject.put("call_to_action", this.f7009a.mo3927e());
                jSONObject.put("price", this.f7009a.mo3930h());
                jSONObject.put("star_rating", String.valueOf(this.f7009a.mo3928f()));
                jSONObject.put("store", this.f7009a.mo3929g());
                jSONObject.put("icon", zzp.m7545a(this.f7009a.mo3926d()));
                JSONArray jSONArray = new JSONArray();
                List<Object> b = this.f7009a.mo3924b();
                if (b != null) {
                    for (Object a : b) {
                        jSONArray.put(zzp.m7545a(zzp.m7552b(a)));
                    }
                }
                jSONObject.put("images", jSONArray);
                jSONObject.put("extras", zzp.m7555b(this.f7009a.mo3936n(), this.f7010b));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("assets", jSONObject);
                jSONObject2.put("template_id", GpsMeasureMode.MODE_2_DIMENSIONAL);
                this.f7011c.mo3385a("google.afma.nativeExpressAds.loadAssets", jSONObject2);
            } catch (Throwable e) {
                aad.m8424c("Exception occurred when loading assets", e);
            }
        }
    }

    class C23912 implements C2340a {
        final /* synthetic */ qu f7012a;
        final /* synthetic */ String f7013b;
        final /* synthetic */ aat f7014c;

        C23912(qu quVar, String str, aat com_google_android_gms_internal_aat) {
            this.f7012a = quVar;
            this.f7013b = str;
            this.f7014c = com_google_android_gms_internal_aat;
        }

        public void mo3168a(aat com_google_android_gms_internal_aat, boolean z) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("headline", this.f7012a.mo3939a());
                jSONObject.put("body", this.f7012a.mo3940c());
                jSONObject.put("call_to_action", this.f7012a.mo3942e());
                jSONObject.put("advertiser", this.f7012a.mo3943f());
                jSONObject.put("logo", zzp.m7545a(this.f7012a.mo3941d()));
                JSONArray jSONArray = new JSONArray();
                List<Object> b = this.f7012a.mo3924b();
                if (b != null) {
                    for (Object a : b) {
                        jSONArray.put(zzp.m7545a(zzp.m7552b(a)));
                    }
                }
                jSONObject.put("images", jSONArray);
                jSONObject.put("extras", zzp.m7555b(this.f7012a.mo3946i(), this.f7013b));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("assets", jSONObject);
                jSONObject2.put("template_id", "1");
                this.f7014c.mo3385a("google.afma.nativeExpressAds.loadAssets", jSONObject2);
            } catch (Throwable e) {
                aad.m8424c("Exception occurred when loading assets", e);
            }
        }
    }

    class C23923 implements sc {
        final /* synthetic */ CountDownLatch f7015a;

        C23923(CountDownLatch countDownLatch) {
            this.f7015a = countDownLatch;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            this.f7015a.countDown();
            com_google_android_gms_internal_aat.mo3405b().setVisibility(0);
        }
    }

    class C23934 implements sc {
        final /* synthetic */ CountDownLatch f7016a;

        C23934(CountDownLatch countDownLatch) {
            this.f7016a = countDownLatch;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            aad.m8426e("Adapter returned an ad, but assets substitution failed");
            this.f7016a.countDown();
            com_google_android_gms_internal_aat.destroy();
        }
    }

    class C23945 implements sc {
        final /* synthetic */ uf f7017a;
        final /* synthetic */ zza f7018b;
        final /* synthetic */ ug f7019c;

        C23945(uf ufVar, zza com_google_android_gms_ads_internal_zzg_zza, ug ugVar) {
            this.f7017a = ufVar;
            this.f7018b = com_google_android_gms_ads_internal_zzg_zza;
            this.f7019c = ugVar;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            Object b = com_google_android_gms_internal_aat.mo3405b();
            if (b != null) {
                try {
                    if (this.f7017a != null) {
                        if (this.f7017a.mo4098k()) {
                            zzp.m7556b(com_google_android_gms_internal_aat);
                            return;
                        }
                        this.f7017a.mo4086a(C2312b.m7327a(b));
                        this.f7018b.onClick();
                    } else if (this.f7019c == null) {
                    } else {
                        if (this.f7019c.mo4113i()) {
                            zzp.m7556b(com_google_android_gms_internal_aat);
                            return;
                        }
                        this.f7019c.mo4103a(C2312b.m7327a(b));
                        this.f7018b.onClick();
                    }
                } catch (Throwable e) {
                    aad.m8424c("Unable to call handleClick on mapper", e);
                }
            }
        }
    }

    private static qt m7539a(uf ufVar) {
        return new qt(ufVar.mo4085a(), ufVar.mo4087b(), ufVar.mo4089c(), ufVar.mo4091d(), ufVar.mo4092e(), ufVar.mo4093f(), ufVar.mo4094g(), ufVar.mo4095h(), null, ufVar.mo4099l(), null, null);
    }

    private static qu m7540a(ug ugVar) {
        return new qu(ugVar.mo4102a(), ugVar.mo4104b(), ugVar.mo4106c(), ugVar.mo4108d(), ugVar.mo4109e(), ugVar.mo4110f(), null, ugVar.mo4114j(), null, null);
    }

    static sc m7542a(@Nullable uf ufVar, @Nullable ug ugVar, zza com_google_android_gms_ads_internal_zzg_zza) {
        return new C23945(ufVar, com_google_android_gms_ads_internal_zzg_zza, ugVar);
    }

    static sc m7543a(CountDownLatch countDownLatch) {
        return new C23923(countDownLatch);
    }

    private static String m7544a(@Nullable Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            aad.m8426e("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String valueOf = String.valueOf("data:image/png;base64,");
        encodeToString = String.valueOf(encodeToString);
        return encodeToString.length() != 0 ? valueOf.concat(encodeToString) : new String(valueOf);
    }

    static String m7545a(@Nullable rd rdVar) {
        if (rdVar == null) {
            aad.m8426e("Image is null. Returning empty string");
            return "";
        }
        try {
            Uri b = rdVar.mo3920b();
            if (b != null) {
                return b.toString();
            }
        } catch (RemoteException e) {
            aad.m8426e("Unable to get image uri. Trying data uri next");
        }
        return m7554b(rdVar);
    }

    private static void m7548a(aat com_google_android_gms_internal_aat, qt qtVar, String str) {
        com_google_android_gms_internal_aat.mo3424l().m8547a(new C23901(qtVar, str, com_google_android_gms_internal_aat));
    }

    private static void m7549a(aat com_google_android_gms_internal_aat, qu quVar, String str) {
        com_google_android_gms_internal_aat.mo3424l().m8547a(new C23912(quVar, str, com_google_android_gms_internal_aat));
    }

    private static void m7550a(aat com_google_android_gms_internal_aat, CountDownLatch countDownLatch) {
        com_google_android_gms_internal_aat.mo3424l().m8552a("/nativeExpressAssetsLoaded", m7543a(countDownLatch));
        com_google_android_gms_internal_aat.mo3424l().m8552a("/nativeExpressAssetsLoadingFailed", m7553b(countDownLatch));
    }

    private static boolean m7551a(aat com_google_android_gms_internal_aat, tv tvVar, CountDownLatch countDownLatch) {
        View b = com_google_android_gms_internal_aat.mo3405b();
        if (b == null) {
            aad.m8426e("AdWebView is null");
            return false;
        }
        b.setVisibility(4);
        List list = tvVar.f10828b.f10785o;
        if (list == null || list.isEmpty()) {
            aad.m8426e("No template ids present in mediation response");
            return false;
        }
        m7550a(com_google_android_gms_internal_aat, countDownLatch);
        uf h = tvVar.f10829c.mo4079h();
        ug i = tvVar.f10829c.mo4080i();
        if (list.contains(GpsMeasureMode.MODE_2_DIMENSIONAL) && h != null) {
            m7548a(com_google_android_gms_internal_aat, m7539a(h), tvVar.f10828b.f10784n);
        } else if (!list.contains("1") || i == null) {
            aad.m8426e("No matching template id and mapper");
            return false;
        } else {
            m7549a(com_google_android_gms_internal_aat, m7540a(i), tvVar.f10828b.f10784n);
        }
        String str = tvVar.f10828b.f10782l;
        String str2 = tvVar.f10828b.f10783m;
        if (str2 != null) {
            com_google_android_gms_internal_aat.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
        } else {
            com_google_android_gms_internal_aat.loadData(str, "text/html", "UTF-8");
        }
        return true;
    }

    @Nullable
    private static rd m7552b(Object obj) {
        return obj instanceof IBinder ? C3178a.m13348a((IBinder) obj) : null;
    }

    static sc m7553b(CountDownLatch countDownLatch) {
        return new C23934(countDownLatch);
    }

    private static String m7554b(rd rdVar) {
        try {
            C2309a a = rdVar.mo3919a();
            if (a == null) {
                aad.m8426e("Drawable is null. Returning empty string");
                return "";
            }
            Drawable drawable = (Drawable) C2312b.m7328a(a);
            if (drawable instanceof BitmapDrawable) {
                return m7544a(((BitmapDrawable) drawable).getBitmap());
            }
            aad.m8426e("Drawable is not an instance of BitmapDrawable. Returning empty string");
            return "";
        } catch (RemoteException e) {
            aad.m8426e("Unable to get drawable. Returning empty string");
            return "";
        }
    }

    private static JSONObject m7555b(@Nullable Bundle bundle, String str) {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            if (bundle.containsKey(str2)) {
                if ("image".equals(jSONObject2.getString(str2))) {
                    Object obj = bundle.get(str2);
                    if (obj instanceof Bitmap) {
                        jSONObject.put(str2, m7544a((Bitmap) obj));
                    } else {
                        aad.m8426e("Invalid type. An image type extra should return a bitmap");
                    }
                } else if (bundle.get(str2) instanceof Bitmap) {
                    aad.m8426e("Invalid asset type. Bitmap should be returned only for image type");
                } else {
                    jSONObject.put(str2, String.valueOf(bundle.get(str2)));
                }
            }
        }
        return jSONObject;
    }

    private static void m7556b(aat com_google_android_gms_internal_aat) {
        OnClickListener D = com_google_android_gms_internal_aat.mo3389D();
        if (D != null) {
            D.onClick(com_google_android_gms_internal_aat.mo3405b());
        }
    }

    public static void zza(@Nullable yy yyVar, zza com_google_android_gms_ads_internal_zzg_zza) {
        ug ugVar = null;
        if (yyVar != null && zzh(yyVar)) {
            aat com_google_android_gms_internal_aat = yyVar.f11527b;
            Object b = com_google_android_gms_internal_aat != null ? com_google_android_gms_internal_aat.mo3405b() : null;
            if (b == null) {
                aad.m8426e("AdWebView is null");
                return;
            }
            try {
                List list = yyVar.f11540o != null ? yyVar.f11540o.f10785o : null;
                if (list == null || list.isEmpty()) {
                    aad.m8426e("No template ids present in mediation response");
                    return;
                }
                uf h = yyVar.f11541p != null ? yyVar.f11541p.mo4079h() : null;
                if (yyVar.f11541p != null) {
                    ugVar = yyVar.f11541p.mo4080i();
                }
                if (list.contains(GpsMeasureMode.MODE_2_DIMENSIONAL) && h != null) {
                    h.mo4088b(C2312b.m7327a(b));
                    if (!h.mo4097j()) {
                        h.mo4096i();
                    }
                    com_google_android_gms_internal_aat.mo3424l().m8552a("/nativeExpressViewClicked", m7542a(h, null, com_google_android_gms_ads_internal_zzg_zza));
                } else if (!list.contains("1") || ugVar == null) {
                    aad.m8426e("No matching template id and mapper");
                } else {
                    ugVar.mo4105b(C2312b.m7327a(b));
                    if (!ugVar.mo4112h()) {
                        ugVar.mo4111g();
                    }
                    com_google_android_gms_internal_aat.mo3424l().m8552a("/nativeExpressViewClicked", m7542a(null, ugVar, com_google_android_gms_ads_internal_zzg_zza));
                }
            } catch (Throwable e) {
                aad.m8424c("Error occurred while recording impression and registering for clicks", e);
            }
        }
    }

    public static boolean zza(aat com_google_android_gms_internal_aat, tv tvVar, CountDownLatch countDownLatch) {
        boolean z = false;
        try {
            z = m7551a(com_google_android_gms_internal_aat, tvVar, countDownLatch);
        } catch (Throwable e) {
            aad.m8424c("Unable to invoke load assets", e);
        } catch (RuntimeException e2) {
            countDownLatch.countDown();
            throw e2;
        }
        if (!z) {
            countDownLatch.countDown();
        }
        return z;
    }

    @Nullable
    public static View zzg(@Nullable yy yyVar) {
        if (yyVar == null) {
            aad.m8423c("AdState is null");
            return null;
        } else if (zzh(yyVar) && yyVar.f11527b != null) {
            return yyVar.f11527b.mo3405b();
        } else {
            try {
                C2309a a = yyVar.f11541p != null ? yyVar.f11541p.mo4062a() : null;
                if (a != null) {
                    return (View) C2312b.m7328a(a);
                }
                aad.m8426e("View in mediation adapter is null.");
                return null;
            } catch (Throwable e) {
                aad.m8424c("Could not get View from mediation adapter.", e);
                return null;
            }
        }
    }

    public static boolean zzh(@Nullable yy yyVar) {
        return (yyVar == null || !yyVar.f11539n || yyVar.f11540o == null || yyVar.f11540o.f10782l == null) ? false : true;
    }
}
