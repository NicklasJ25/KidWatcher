package com.domobile.libs_ads;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.domobile.frame.p000a.C1258c;
import com.domobile.lib_blurview.BlurView;
import com.domobile.lib_blurview.C1332f;
import com.domobile.libs_ads.C1347c.C1343a;
import com.domobile.libs_ads.C1347c.C1344b;
import com.domobile.libs_ads.C1347c.C1345c;
import com.domobile.libs_ads.C1347c.C1346d;
import com.facebook.ads.C0657e;
import com.facebook.ads.C1453b;
import com.facebook.ads.C1459c;
import com.facebook.ads.C1460d;
import com.facebook.ads.C1903l;
import com.facebook.ads.MediaView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class C1350e extends FrameLayout implements C0657e {
    private static final HashMap<String, C1903l> f2897f = new HashMap();
    private C1903l f2898a;
    private View f2899b;
    private int f2900c;
    private boolean f2901d = true;
    private Handler f2902e = new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ C1350e f2896a;

        public void handleMessage(Message message) {
            super.handleMessage(message);
            C1342b.m3327a(this.f2896a.getContext(), false);
            C1350e.f2897f.clear();
        }
    };

    public C1350e(@NonNull Context context, boolean z) {
        super(context);
        this.f2901d = z;
        m3353a(context);
    }

    private void m3352a(int i, int i2) {
        removeAllViews();
        if (i > i2) {
            int i3 = (int) ((((float) i) * 0.5f) * 0.7f);
            int i4 = (int) ((((float) i) * 0.25f) - (((float) i3) * 0.5f));
            LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, (int) (((float) i3) * 0.5625f));
            layoutParams.leftMargin = i4;
            layoutParams.gravity = 16;
            addView(this.f2899b, layoutParams);
            return;
        }
        i3 = (int) (((float) i) * 0.7f);
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i3, (int) (((float) i3) * 0.5625f));
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = this.f2900c;
        addView(this.f2899b, layoutParams2);
    }

    private void m3353a(Context context) {
        this.f2900c = getResources().getDimensionPixelSize(C1344b.unlock_adview_margin_top);
        C1342b.m3327a(getContext(), true);
        this.f2899b = View.inflate(getContext(), C1346d.layout_facebook_native_ad_unlock_page, null);
        C1903l c1903l = (C1903l) f2897f.get("KEY_CACHE_AD");
        if (c1903l != null) {
            this.f2898a = c1903l;
            if (this.f2901d) {
                m3356a();
                return;
            }
            return;
        }
        this.f2898a = new C1903l(context, "970977059658692_1353366124753115");
        this.f2898a.m5407a((C0657e) this);
        this.f2898a.m5411b();
    }

    private void m3355d() {
        if (this.f2898a != null && this.f2898a.m5413d()) {
            f2897f.clear();
            f2897f.put("KEY_CACHE_AD", this.f2898a);
        }
    }

    public void m3356a() {
        this.f2902e.sendEmptyMessageDelayed(0, 3000);
        ImageView imageView = (ImageView) this.f2899b.findViewById(C1345c.native_ad_icon);
        TextView textView = (TextView) this.f2899b.findViewById(C1345c.native_ad_title);
        MediaView mediaView = (MediaView) this.f2899b.findViewById(C1345c.native_ad_media);
        TextView textView2 = (TextView) this.f2899b.findViewById(C1345c.native_ad_body);
        TextView textView3 = (TextView) this.f2899b.findViewById(C1345c.native_ad_call_to_action);
        textView.setText(this.f2898a.m5416g());
        textView2.setText(this.f2898a.m5417h());
        textView3.setText(this.f2898a.m5418i());
        C1903l.m5376a(this.f2898a.m5414e(), imageView);
        mediaView.setNativeAd(this.f2898a);
        ((LinearLayout) this.f2899b.findViewById(C1345c.ad_choices_container)).addView(new C1459c(getContext(), this.f2898a, true));
        List arrayList = new ArrayList();
        arrayList.add(textView);
        arrayList.add(textView3);
        arrayList.add(imageView);
        arrayList.add(mediaView);
        this.f2898a.m5405a((View) this, arrayList);
        if (VERSION.SDK_INT >= 17) {
            BlurView blurView = (BlurView) this.f2899b.findViewById(C1345c.blurView);
            blurView.m3272a((ViewGroup) this.f2899b).m3267a(this.f2899b.getBackground()).m3268a(new C1332f(getContext())).m3266a(16.0f);
            return;
        }
        ((BlurView) this.f2899b.findViewById(C1345c.blurView)).setBackgroundColor(ContextCompat.getColor(getContext(), C1343a.adColorOverlay));
    }

    public void mo2390a(C1453b c1453b) {
        C1258c.m2987b("Unlock Ad onAdLoaded");
        m3355d();
        if (getParent() != null && this.f2901d) {
            m3356a();
        }
    }

    public void mo2391a(C1453b c1453b, C1460d c1460d) {
        C1258c.m2987b("Unlock Ad onError");
    }

    public void m3359b() {
        if (this.f2898a != null) {
            this.f2898a.m5412c();
        }
    }

    public void mo2392b(C1453b c1453b) {
    }

    public void mo2393c(C1453b c1453b) {
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2902e.removeCallbacksAndMessages(null);
        if (f2897f.isEmpty()) {
            m3359b();
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m3352a(i, i2);
    }
}
