package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.C2480k;
import com.google.android.gms.common.util.C2590o;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.StringTokenizer;

@wh
public class aac {
    public static final Handler f7622a = new Handler(Looper.getMainLooper());
    private static final String f7623b = AdView.class.getName();
    private static final String f7624c = InterstitialAd.class.getName();
    private static final String f7625d = PublisherAdView.class.getName();
    private static final String f7626e = PublisherInterstitialAd.class.getName();
    private static final String f7627f = SearchAdView.class.getName();
    private static final String f7628g = AdLoader.class.getName();

    public interface C2632a {
        void mo3376a(String str);
    }

    class C26331 implements C2632a {
        C26331(aac com_google_android_gms_internal_aac) {
        }

        public void mo3376a(final String str) {
            new Thread(this) {
                public void run() {
                    new aae().mo3376a(str);
                }
            }.start();
        }
    }

    private void m8397a(ViewGroup viewGroup, zzeg com_google_android_gms_internal_zzeg, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            View textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            View frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int a = m8398a(context, 3);
            frameLayout.addView(textView, new LayoutParams(com_google_android_gms_internal_zzeg.f11900f - a, com_google_android_gms_internal_zzeg.f11897c - a, 17));
            viewGroup.addView(frameLayout, com_google_android_gms_internal_zzeg.f11900f, com_google_android_gms_internal_zzeg.f11897c);
        }
    }

    public int m8398a(Context context, int i) {
        return m8399a(context.getResources().getDisplayMetrics(), i);
    }

    public int m8399a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    public String m8400a(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Secure.getString(contentResolver, "android_id");
        if (string == null || m8409a()) {
            string = "emulator";
        }
        return m8401a(string);
    }

    public String m8401a(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest.getInstance("MD5").update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, r1.digest())});
            } catch (NoSuchAlgorithmException e) {
                i++;
            }
        }
        return null;
    }

    String m8402a(String str, String str2, int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = i - 1;
        if (i <= 0 || !stringTokenizer.hasMoreElements()) {
            return str;
        }
        stringBuilder.append(stringTokenizer.nextToken());
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0 && stringTokenizer.hasMoreElements()) {
                stringBuilder.append(".").append(stringTokenizer.nextToken());
                i2 = i3;
            }
        }
        return stringBuilder.toString();
    }

    @Nullable
    public String m8403a(StackTraceElement[] stackTraceElementArr, String str) {
        String className;
        for (int i = 0; i + 1 < stackTraceElementArr.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            String className2 = stackTraceElement.getClassName();
            if ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (f7623b.equalsIgnoreCase(className2) || f7624c.equalsIgnoreCase(className2) || f7625d.equalsIgnoreCase(className2) || f7626e.equalsIgnoreCase(className2) || f7627f.equalsIgnoreCase(className2) || f7628g.equalsIgnoreCase(className2))) {
                className = stackTraceElementArr[i + 1].getClassName();
                break;
            }
        }
        className = null;
        if (str != null) {
            CharSequence a = m8402a(str, ".", 3);
            if (!(className == null || className.contains(a))) {
                return className;
            }
        }
        return null;
    }

    public void m8404a(Context context, @Nullable String str, String str2, Bundle bundle, boolean z) {
        m8405a(context, str, str2, bundle, z, new C26331(this));
    }

    public void m8405a(Context context, @Nullable String str, String str2, Bundle bundle, boolean z, C2632a c2632a) {
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            bundle.putString("os", VERSION.RELEASE);
            bundle.putString("api", String.valueOf(VERSION.SDK_INT));
            bundle.putString("appid", applicationContext.getPackageName());
            if (str == null) {
                str = C2480k.m7807b().mo3318b(context) + "." + 10260000;
            }
            bundle.putString("js", str);
        }
        Builder appendQueryParameter = new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str2);
        for (String str3 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        c2632a.mo3376a(appendQueryParameter.toString());
    }

    public void m8406a(ViewGroup viewGroup, zzeg com_google_android_gms_internal_zzeg, String str) {
        m8397a(viewGroup, com_google_android_gms_internal_zzeg, str, (int) ViewCompat.MEASURED_STATE_MASK, -1);
    }

    public void m8407a(ViewGroup viewGroup, zzeg com_google_android_gms_internal_zzeg, String str, String str2) {
        aad.m8426e(str2);
        m8397a(viewGroup, com_google_android_gms_internal_zzeg, str, (int) SupportMenu.CATEGORY_MASK, (int) ViewCompat.MEASURED_STATE_MASK);
    }

    public void m8408a(boolean z, HttpURLConnection httpURLConnection, @Nullable String str) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setUseCaches(false);
    }

    public boolean m8409a() {
        return Build.DEVICE.startsWith("generic");
    }

    public int m8410b(Context context, int i) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return m8411b(displayMetrics, i);
    }

    public int m8411b(DisplayMetrics displayMetrics, int i) {
        return Math.round(((float) i) / displayMetrics.density);
    }

    @Nullable
    public String m8412b(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return contentResolver == null ? null : Secure.getString(contentResolver, "android_id");
    }

    public boolean m8413b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public boolean m8414c(Context context) {
        return C2480k.m7807b().mo3314a(context) == 0;
    }

    public boolean m8415d(Context context) {
        int a = C2480k.m7807b().mo3314a(context);
        return a == 0 || a == 2;
    }

    public boolean m8416e(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < PositionController.SNAPBACK_ANIMATION_TIME;
    }

    @TargetApi(17)
    public boolean m8417f(Context context) {
        int i;
        int i2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (C2590o.m8310e()) {
            defaultDisplay.getRealMetrics(displayMetrics);
            i = displayMetrics.heightPixels;
            i2 = displayMetrics.widthPixels;
        } else {
            try {
                i = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                i2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception e) {
                return false;
            }
        }
        defaultDisplay.getMetrics(displayMetrics);
        boolean z = displayMetrics.heightPixels == i && displayMetrics.widthPixels == i2;
        return z;
    }

    public int m8418g(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
    }
}
