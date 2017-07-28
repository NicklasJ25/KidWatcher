package com.facebook.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.C1614i;
import com.facebook.ads.internal.C1674k;
import com.facebook.ads.internal.p018m.C1722n;
import com.facebook.ads.internal.p018m.C1723o;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.C1730t;
import com.facebook.ads.internal.p018m.aj;
import com.facebook.ads.internal.p018m.aj.C1444a;
import com.facebook.ads.internal.p018m.ak;
import com.facebook.ads.internal.p020a.C1468a;
import com.facebook.ads.internal.p020a.C1469b;
import com.facebook.ads.internal.p021b.C1520p;
import com.facebook.ads.internal.p021b.C1524q;
import com.facebook.ads.internal.p022h.C1609q;
import com.facebook.ads.internal.view.C1523c;
import com.facebook.ads.internal.view.C1523c.C1436a;
import com.facebook.ads.internal.view.C1756b;
import com.facebook.ads.internal.view.C1756b.C1447b;
import com.facebook.ads.internal.view.C1853e;
import com.facebook.ads.internal.view.C1857g;
import com.facebook.ads.internal.view.C1878j;
import com.facebook.ads.internal.view.C1886m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AudienceNetworkActivity extends Activity {
    private static final String f3321a = AudienceNetworkActivity.class.getSimpleName();
    private String f3322b;
    private String f3323c;
    private C1756b f3324d;
    private boolean f3325e = false;
    private RelativeLayout f3326f;
    private Intent f3327g;
    private C1614i f3328h;
    private int f3329i = -1;
    private String f3330j;
    private C1449b f3331k;
    private long f3332l;
    private long f3333m;
    private int f3334n;
    private C1523c f3335o;
    private List<C1439a> f3336p = new ArrayList();

    class C14351 implements OnClickListener {
        final /* synthetic */ AudienceNetworkActivity f3305a;

        C14351(AudienceNetworkActivity audienceNetworkActivity) {
            this.f3305a = audienceNetworkActivity;
        }

        public void onClick(View view) {
            this.f3305a.finish();
        }
    }

    class C14372 implements C1436a {
        final /* synthetic */ AudienceNetworkActivity f3306a;

        C14372(AudienceNetworkActivity audienceNetworkActivity) {
            this.f3306a = audienceNetworkActivity;
        }

        public void mo2616a(View view) {
            this.f3306a.f3326f.addView(view);
            if (this.f3306a.f3328h != null) {
                this.f3306a.f3326f.addView(this.f3306a.f3328h);
            }
        }

        public void mo2617a(String str) {
            this.f3306a.m3706a(str);
        }

        public void mo2618a(String str, C1609q c1609q) {
            this.f3306a.m3707a(str, c1609q);
        }
    }

    class C14383 implements C1436a {
        final /* synthetic */ AudienceNetworkActivity f3307a;

        C14383(AudienceNetworkActivity audienceNetworkActivity) {
            this.f3307a = audienceNetworkActivity;
        }

        public void mo2616a(View view) {
            this.f3307a.f3326f.addView(view);
        }

        public void mo2617a(String str) {
            this.f3307a.m3706a(str);
            if (str.equals(C1674k.REWARDED_VIDEO_END_ACTIVITY.m4768a())) {
                this.f3307a.finish();
            }
        }

        public void mo2618a(String str, C1609q c1609q) {
            this.f3307a.m3706a(str);
            if (str.startsWith(C1674k.REWARDED_VIDEO_COMPLETE.m4768a())) {
                if (!str.equals(C1674k.REWARDED_VIDEO_COMPLETE_WITHOUT_REWARD.m4768a())) {
                    this.f3307a.m3710b();
                }
                this.f3307a.f3325e = true;
                this.f3307a.m3711c();
                this.f3307a.m3713d();
            }
        }
    }

    public interface C1439a {
        boolean mo2619a();
    }

    class C14404 implements C1439a {
        final /* synthetic */ AudienceNetworkActivity f3308a;

        C14404(AudienceNetworkActivity audienceNetworkActivity) {
            this.f3308a = audienceNetworkActivity;
        }

        public boolean mo2619a() {
            return !this.f3308a.f3325e;
        }
    }

    class C14415 implements C1436a {
        final /* synthetic */ AudienceNetworkActivity f3309a;

        C14415(AudienceNetworkActivity audienceNetworkActivity) {
            this.f3309a = audienceNetworkActivity;
        }

        public void mo2616a(View view) {
            this.f3309a.f3326f.addView(view);
            if (this.f3309a.f3328h != null) {
                this.f3309a.f3326f.addView(this.f3309a.f3328h);
            }
        }

        public void mo2617a(String str) {
            this.f3309a.m3706a(str);
        }

        public void mo2618a(String str, C1609q c1609q) {
            this.f3309a.m3707a(str, c1609q);
        }
    }

    class C14426 implements C1436a {
        final /* synthetic */ AudienceNetworkActivity f3310a;

        C14426(AudienceNetworkActivity audienceNetworkActivity) {
            this.f3310a = audienceNetworkActivity;
        }

        public void mo2616a(View view) {
            this.f3310a.f3326f.addView(view);
            if (this.f3310a.f3328h != null) {
                this.f3310a.f3326f.addView(this.f3310a.f3328h);
            }
        }

        public void mo2617a(String str) {
            this.f3310a.m3706a(str);
        }

        public void mo2618a(String str, C1609q c1609q) {
            this.f3310a.m3707a(str, c1609q);
        }
    }

    class C14437 implements C1436a {
        final /* synthetic */ AudienceNetworkActivity f3311a;

        C14437(AudienceNetworkActivity audienceNetworkActivity) {
            this.f3311a = audienceNetworkActivity;
        }

        public void mo2616a(View view) {
            this.f3311a.f3326f.addView(view);
        }

        public void mo2617a(String str) {
            this.f3311a.m3706a(str);
        }

        public void mo2618a(String str, C1609q c1609q) {
            this.f3311a.m3707a(str, c1609q);
        }
    }

    class C14458 implements C1444a {
        final /* synthetic */ AudienceNetworkActivity f3312a;

        C14458(AudienceNetworkActivity audienceNetworkActivity) {
            this.f3312a = audienceNetworkActivity;
        }

        public void mo2620a() {
            this.f3312a.m3706a(C1674k.REWARD_SERVER_FAILED.m4768a());
        }

        public void mo2621a(ak akVar) {
            if (akVar == null || !akVar.m4842a()) {
                this.f3312a.m3706a(C1674k.REWARD_SERVER_FAILED.m4768a());
            } else {
                this.f3312a.m3706a(C1674k.REWARD_SERVER_SUCCESS.m4768a());
            }
        }
    }

    class C14489 implements C1447b {
        final /* synthetic */ AudienceNetworkActivity f3314a;

        class C14461 implements Runnable {
            final /* synthetic */ C14489 f3313a;

            C14461(C14489 c14489) {
                this.f3313a = c14489;
            }

            public void run() {
                if (this.f3313a.f3314a.f3324d.m5018e()) {
                    Log.w(AudienceNetworkActivity.f3321a, "Webview already destroyed, cannot activate");
                } else {
                    this.f3313a.f3314a.f3324d.loadUrl("javascript:" + this.f3313a.f3314a.f3323c);
                }
            }
        }

        C14489(AudienceNetworkActivity audienceNetworkActivity) {
            this.f3314a = audienceNetworkActivity;
        }

        public void mo2622a() {
            if (this.f3314a.f3324d != null && !TextUtils.isEmpty(this.f3314a.f3323c)) {
                this.f3314a.f3324d.post(new C14461(this));
            }
        }

        public void mo2623a(int i) {
        }

        public void mo2624a(String str, Map<String, String> map) {
            Uri parse = Uri.parse(str);
            if ("fbad".equals(parse.getScheme()) && parse.getAuthority().equals("close")) {
                this.f3314a.finish();
                return;
            }
            if ("fbad".equals(parse.getScheme()) && C1469b.m3802a(parse.getAuthority())) {
                this.f3314a.m3706a(C1674k.REWARDED_VIDEO_AD_CLICK.m4768a());
            }
            C1468a a = C1469b.m3801a(this.f3314a, this.f3314a.f3322b, parse, map);
            if (a != null) {
                try {
                    a.mo2642b();
                } catch (Throwable e) {
                    Log.e(AudienceNetworkActivity.f3321a, "Error executing action", e);
                }
            }
        }

        public void mo2625b() {
        }
    }

    public enum C1449b {
        DISPLAY,
        VIDEO,
        REWARDED_VIDEO,
        NATIVE,
        BROWSER
    }

    private void m3703a(Intent intent, Bundle bundle) {
        if (bundle != null) {
            this.f3329i = bundle.getInt("predefinedOrientationKey", -1);
            this.f3330j = bundle.getString("uniqueId");
            this.f3331k = (C1449b) bundle.getSerializable("viewType");
            return;
        }
        this.f3329i = intent.getIntExtra("predefinedOrientationKey", -1);
        this.f3330j = intent.getStringExtra("uniqueId");
        this.f3331k = (C1449b) intent.getSerializableExtra("viewType");
        this.f3334n = intent.getIntExtra("skipAfterSeconds", 0) * 1000;
    }

    private void m3706a(String str) {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(str + ":" + this.f3330j));
    }

    private void m3707a(String str, C1609q c1609q) {
        Intent intent = new Intent(str + ":" + this.f3330j);
        intent.putExtra("event", c1609q);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void m3710b() {
        if (!TextUtils.isEmpty(this.f3327g.getStringExtra("rewardServerURL"))) {
            aj ajVar = new aj(new HashMap());
            ajVar.m4840a(new C14458(this));
            ajVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{r0});
        }
    }

    private void m3711c() {
        Object a = C1729s.m4966a(this.f3327g.getByteArrayExtra("facebookRewardedVideoEndCardMarkup"));
        if (!TextUtils.isEmpty(a)) {
            this.f3324d = new C1756b(this, new C14489(this), 1);
            this.f3324d.setLayoutParams(new LayoutParams(-1, -1));
            this.f3323c = this.f3327g.getStringExtra("facebookRewardedVideoEndCardActivationCommand");
            this.f3324d.loadDataWithBaseURL(C1730t.m4977a(), a, "text/html", "utf-8", null);
        }
    }

    private void m3713d() {
        if (this.f3324d == null) {
            finish();
            return;
        }
        this.f3326f.removeAllViews();
        this.f3335o.mo2680b();
        this.f3335o = null;
        this.f3326f.addView(this.f3324d);
    }

    public void m3720a(C1439a c1439a) {
        this.f3336p.add(c1439a);
    }

    public void m3721b(C1439a c1439a) {
        this.f3336p.remove(c1439a);
    }

    public void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f3333m += currentTimeMillis - this.f3332l;
        this.f3332l = currentTimeMillis;
        if (this.f3333m > ((long) this.f3334n)) {
            Object obj = null;
            for (C1439a a : this.f3336p) {
                obj = a.mo2619a() ? 1 : obj;
            }
            if (obj == null) {
                super.onBackPressed();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.f3335o instanceof C1524q) {
            ((C1524q) this.f3335o).m4070a(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        this.f3326f = new RelativeLayout(this);
        this.f3326f.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        setContentView(this.f3326f, new LayoutParams(-1, -1));
        this.f3327g = getIntent();
        if (this.f3327g.getBooleanExtra("useNativeCloseButton", false)) {
            this.f3328h = new C1614i(this);
            this.f3328h.setId(100002);
            this.f3328h.setOnClickListener(new C14351(this));
        }
        this.f3322b = this.f3327g.getStringExtra("clientToken");
        m3703a(this.f3327g, bundle);
        if (this.f3331k == C1449b.VIDEO) {
            C1523c c1886m = new C1886m(this, new C14372(this));
            c1886m.m5334a(this.f3326f);
            this.f3335o = c1886m;
        } else if (this.f3331k == C1449b.REWARDED_VIDEO) {
            this.f3335o = new C1878j(this, new C14383(this));
            m3720a(new C14404(this));
        } else if (this.f3331k == C1449b.DISPLAY) {
            this.f3335o = new C1857g(this, new C14415(this));
        } else if (this.f3331k == C1449b.BROWSER) {
            this.f3335o = new C1853e(this, new C14426(this));
        } else if (this.f3331k == C1449b.NATIVE) {
            this.f3335o = C1520p.m4043a(this.f3327g.getStringExtra("uniqueId"));
            if (this.f3335o == null) {
                C1723o.m4943a(C1722n.m4940a(null, "Unable to find view"));
                m3706a("com.facebook.ads.interstitial.error");
                finish();
                return;
            }
            this.f3335o.mo2717a(new C14437(this));
        } else {
            C1723o.m4943a(C1722n.m4940a(null, "Unable to infer viewType from intent or savedInstanceState"));
            m3706a("com.facebook.ads.interstitial.error");
            finish();
            return;
        }
        this.f3335o.mo2715a(this.f3327g, bundle, this);
        m3706a("com.facebook.ads.interstitial.displayed");
        this.f3332l = System.currentTimeMillis();
    }

    protected void onDestroy() {
        this.f3326f.removeAllViews();
        if (this.f3335o != null) {
            C1520p.m4044a(this.f3335o);
            this.f3335o.mo2680b();
            this.f3335o = null;
        }
        if (this.f3324d != null) {
            C1730t.m4978a(this.f3324d);
            this.f3324d.destroy();
            this.f3324d = null;
            this.f3323c = null;
        }
        if (this.f3331k == C1449b.REWARDED_VIDEO) {
            m3706a(C1674k.REWARDED_VIDEO_CLOSED.m4768a());
        } else {
            m3706a("com.facebook.ads.interstitial.dismissed");
        }
        super.onDestroy();
    }

    public void onPause() {
        this.f3333m += System.currentTimeMillis() - this.f3332l;
        if (!(this.f3335o == null || this.f3325e)) {
            this.f3335o.mo2719i();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f3332l = System.currentTimeMillis();
        if (this.f3335o != null) {
            this.f3335o.mo2720j();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f3335o != null) {
            this.f3335o.mo2716a(bundle);
        }
        bundle.putInt("predefinedOrientationKey", this.f3329i);
        bundle.putString("uniqueId", this.f3330j);
        bundle.putSerializable("viewType", this.f3331k);
    }

    public void onStart() {
        super.onStart();
        if (this.f3329i != -1) {
            setRequestedOrientation(this.f3329i);
        }
    }
}
