package com.domobile.libs_ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.domobile.frame.http.image.C1277a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.libs_ads.C1347c.C1345c;
import com.domobile.libs_ads.C1347c.C1346d;
import java.io.File;
import org.json.JSONObject;

public class DoMobileFullScreenAdActivity extends Activity {
    private JSONObject f2885a;
    private Bitmap f2886b;

    class C13361 implements OnClickListener {
        final /* synthetic */ DoMobileFullScreenAdActivity f2883a;

        C13361(DoMobileFullScreenAdActivity doMobileFullScreenAdActivity) {
            this.f2883a = doMobileFullScreenAdActivity;
        }

        public void onClick(View view) {
            try {
                this.f2883a.m3314a(this.f2883a, this.f2883a.f2885a.optInt("action_type"), this.f2883a.f2885a.optString("ad_link"));
                this.f2883a.finish();
            } catch (Exception e) {
            }
        }
    }

    class C13372 implements OnClickListener {
        final /* synthetic */ DoMobileFullScreenAdActivity f2884a;

        C13372(DoMobileFullScreenAdActivity doMobileFullScreenAdActivity) {
            this.f2884a = doMobileFullScreenAdActivity;
        }

        public void onClick(View view) {
            this.f2884a.finish();
        }
    }

    private void m3314a(Context context, int i, String str) {
        switch (i) {
            case 1:
                C1148d.ag(context);
                return;
            case 3:
                C1148d.m2496H(context, null);
                return;
            case 4:
                C1148d.m2493E(context, str);
                return;
            case 5:
                C1148d.m2492D(context, str);
                return;
            default:
                return;
        }
    }

    public void onBackPressed() {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2885a = C1342b.m3348j(this);
        if (this.f2885a == null) {
            finish();
            return;
        }
        Object optString = this.f2885a.optString("ad_pic");
        if (TextUtils.isEmpty(optString)) {
            finish();
            return;
        }
        File file = new File(C1277a.m3057a((String) optString));
        if (file == null || !file.exists()) {
            finish();
            return;
        }
        this.f2886b = BitmapFactory.decodeFile(file.getAbsolutePath());
        if (this.f2886b == null) {
            finish();
            return;
        }
        C1342b.m3326a((Context) this, "domobile_custom_ad_showed", optString);
        setContentView(C1346d.domobile_fullscreen_ad);
        ImageView imageView = (ImageView) findViewById(C1345c.domobile_fullscreen_ad_pic);
        imageView.setScaleType(ScaleType.FIT_CENTER);
        imageView.setImageBitmap(this.f2886b);
        imageView.setOnClickListener(new C13361(this));
        findViewById(C1345c.domobile_fullscreen_ad_close).setOnClickListener(new C13372(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f2886b != null) {
            this.f2886b.recycle();
        }
    }
}
