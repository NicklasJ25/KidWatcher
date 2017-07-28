package com.domobile.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.gallery3d.data.MediaObject;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.service.UpdateService;
import com.domobile.eframe.ui.SlidingLeftMenu.C1236a;
import com.domobile.frame.http.image.C1277a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.libs_ads.C1342b;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Random;
import org.apache.p068a.p069a.C3613c;
import org.json.JSONArray;
import org.json.JSONObject;

public class UnlockGiftView extends ImageView implements OnClickListener, Runnable {
    private final int[] f3094a = new int[]{R.drawable.unlock_gift0, R.drawable.unlock_gift1, R.drawable.unlock_gift2, R.drawable.unlock_gift3, R.drawable.unlock_gift4, R.drawable.unlock_gift5, R.drawable.unlock_gift6};
    private final int f3095b = 272;
    private boolean f3096c = false;
    private boolean f3097d = false;
    private C1236a f3098e = null;
    private boolean f3099f = false;
    private boolean f3100g = false;
    private Handler f3101h = new C14072(this);

    class C14061 extends Thread {
        final /* synthetic */ UnlockGiftView f3092a;

        C14061(UnlockGiftView unlockGiftView) {
            this.f3092a = unlockGiftView;
        }

        public void run() {
            File file = new File(C1277a.m3057a(this.f3092a.f3098e.f2454c));
            try {
                Bitmap a;
                if (file.exists()) {
                    a = C1277a.m3054a(file);
                    if (a != null) {
                        this.f3092a.f3101h.sendMessage(this.f3092a.f3101h.obtainMessage(272, a));
                        return;
                    }
                    return;
                }
                a = C1277a.m3061c(this.f3092a.f3098e.f2454c);
                if (a != null) {
                    C1277a.m3058a(file, a, CompressFormat.PNG);
                }
            } catch (Exception e) {
            }
        }
    }

    class C14072 extends Handler {
        final /* synthetic */ UnlockGiftView f3093a;

        C14072(UnlockGiftView unlockGiftView) {
            this.f3093a = unlockGiftView;
        }

        public void handleMessage(Message message) {
            if (message.what == 272 && message.obj != null) {
                this.f3093a.f3096c = true;
                this.f3093a.setImageBitmap((Bitmap) message.obj);
            }
        }
    }

    public UnlockGiftView(Context context) {
        super(context);
        m3569b();
    }

    public UnlockGiftView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3569b();
    }

    public UnlockGiftView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3569b();
    }

    @TargetApi(21)
    public UnlockGiftView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m3569b();
    }

    public static int m3562a(Context context, JSONObject jSONObject, String str) {
        try {
            if (C1150y.m2596b(context, "unlock_page_gift", 0) >= jSONObject.optLong("id")) {
                return -1;
            }
            if (!m3567a(jSONObject, str)) {
                return 0;
            }
            if (jSONObject.optInt("action_type") == 4) {
                Object optString = jSONObject.optString("promo_link");
                if (TextUtils.equals(context.getPackageName(), optString)) {
                    long optLong = jSONObject.optLong("new_version_code", 0);
                    C1150y.m2581a(context, "new_version_code", optLong);
                    if (optLong > ((long) C1148d.ad(context))) {
                        UpdateService.m2266a(context, optLong);
                        return 1;
                    }
                }
                if (C1150y.m2639k(context, optString)) {
                    return 0;
                }
            }
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    private void m3564a() {
        C1148d.m2520b(getContext(), "unlock_page_gift", (Object) Long.valueOf(this.f3098e.f2452a));
        C1148d.m2520b(getContext(), "ads_random_value", (Object) Float.valueOf(new Random().nextFloat()));
        this.f3098e = null;
    }

    private boolean m3566a(JSONObject jSONObject) {
        float f = 0.0f;
        if (!jSONObject.has("first_day") || !jSONObject.has("scale")) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        JSONArray optJSONArray = jSONObject.optJSONArray("scale");
        long time = simpleDateFormat.parse(jSONObject.optString("first_day")).getTime();
        if (currentTimeMillis < time) {
            return false;
        }
        currentTimeMillis = (currentTimeMillis - time) / 86400000;
        if (currentTimeMillis >= ((long) optJSONArray.length())) {
            return true;
        }
        float a = C1148d.m2497a(getContext(), "ads_random_value", 0.0f);
        float length = (float) optJSONArray.length();
        float f2 = 0.0f;
        while (f2 < length) {
            f = (float) (((double) f) + optJSONArray.optDouble((int) f2));
            if (a <= f) {
                return ((float) currentTimeMillis) >= f2;
            } else {
                f2 += 1.0f;
            }
        }
        return true;
    }

    public static boolean m3567a(JSONObject jSONObject, String str) {
        if (jSONObject.optInt("min_sdk", Integer.MIN_VALUE) > C1150y.O || jSONObject.optInt("max_sdk", Integer.MAX_VALUE) < C1150y.O) {
            return false;
        }
        CharSequence toLowerCase = str.toLowerCase();
        if (jSONObject.optString("exclude_location").contains(toLowerCase)) {
            return false;
        }
        Object toLowerCase2 = jSONObject.optString("locales").toLowerCase();
        return TextUtils.equals(toLowerCase2, MediaObject.MEDIA_TYPE_ALL_STRING) || toLowerCase2.contains(toLowerCase);
    }

    private void m3569b() {
        m3570b(false);
    }

    private void m3570b(boolean z) {
        if (!this.f3097d || z) {
            this.f3097d = true;
            if (!C1342b.m3330a(getContext(), "gift_trial_day_switch", true) || C1342b.m3330a(getContext(), "trial_end_notified", false)) {
                try {
                    setOnClickListener(this);
                    String f = C3613c.m15742f(new File(getContext().getFilesDir(), "unlock_page_gift"));
                    long b = C1150y.m2596b(getContext(), "unlock_page_gift", 0);
                    JSONArray jSONArray = new JSONArray(f);
                    for (int length = jSONArray.length() - 1; length > -1; length--) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(length);
                        if (b < optJSONObject.optLong("id")) {
                            if (!m3566a(optJSONObject)) {
                                break;
                            }
                            this.f3098e = new C1236a(optJSONObject);
                            if (this.f3098e == null || this.f3098e.f2459h <= 0 || this.f3098e.f2460i || this.f3098e.f2459h > C1148d.ad(getContext())) {
                                break;
                            }
                            m3564a();
                        }
                    }
                    if (this.f3098e != null && !TextUtils.isEmpty(this.f3098e.f2454c)) {
                        m3571c();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void m3571c() {
        try {
            if (this.f3098e.f2455d > -1 && this.f3098e.f2455d < this.f3094a.length) {
                setImageResource(this.f3094a[this.f3098e.f2455d]);
                return;
            }
        } catch (Exception e) {
        }
        new C14061(this).start();
    }

    public void m3572a(boolean z) {
        this.f3099f = z;
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((MarginLayoutParams) getLayoutParams());
        layoutParams.addRule(this.f3099f ? 12 : 10);
        setLayoutParams(layoutParams);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Point a = C1148d.m2500a((WindowManager) getContext().getSystemService("window"));
        m3572a(a.x > a.y);
        if (this.f3098e != null && !this.f3100g) {
            if (!(TextUtils.isEmpty(this.f3098e.f2454c) || this.f3096c)) {
                m3571c();
            }
            setVisibility(4);
            postDelayed(this, 500);
        }
    }

    public void onClick(View view) {
        if (this.f3098e != null) {
            this.f3098e.m2904a(getContext());
            C1150y.m2646o(getContext(), this.f3098e.f2453b);
            if (this.f3098e.f2460i) {
                m3564a();
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setVisibility(4);
        clearAnimation();
        removeCallbacks(this);
        if (this.f3098e == null) {
            m3570b(true);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f3098e == null) {
            setVisibility(4);
        }
    }

    public void run() {
        Animation animationSet = new AnimationSet(true);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        Animation translateAnimation = this.f3099f ? new TranslateAnimation(0.0f, 0.0f, (float) getHeight(), 0.0f) : new TranslateAnimation(0.0f, 0.0f, (float) (-getHeight()), 0.0f);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(300);
        animationSet.addAnimation(translateAnimation);
        translateAnimation = new ScaleAnimation(1.0f, 0.6f, 1.0f, 0.6f, (float) width, (float) height);
        translateAnimation.setDuration(10);
        animationSet.addAnimation(translateAnimation);
        Animation scaleAnimation = new ScaleAnimation(1.0f, 2.17f, 1.0f, 2.17f, (float) width, (float) height);
        scaleAnimation.setDuration(500);
        scaleAnimation.setStartOffset(220);
        animationSet.addAnimation(scaleAnimation);
        translateAnimation = new ScaleAnimation(1.0f, 0.6f, 1.0f, 0.6f, (float) width, (float) height);
        translateAnimation.setDuration(450);
        translateAnimation.setStartOffset(720);
        animationSet.addAnimation(translateAnimation);
        translateAnimation = new ScaleAnimation(1.0f, 1.28f, 1.0f, 1.28f, (float) width, (float) height);
        translateAnimation.setDuration(600);
        translateAnimation.setStartOffset(1170);
        animationSet.addAnimation(translateAnimation);
        setVisibility(0);
        startAnimation(animationSet);
    }

    public void setNeverShow(boolean z) {
        this.f3100g = z;
        if (z) {
            setVisibility(4);
        }
    }
}
