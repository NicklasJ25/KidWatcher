package com.domobile.eframe.ui;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.domobile.applock.AgentActivity;
import com.domobile.applock.C0386c;
import com.domobile.applock.C0634a;
import com.domobile.applock.C1150y;
import com.domobile.applock.MainTabFragmentActivity;
import com.domobile.applock.R;
import com.domobile.applock.p003a.C0632l;
import com.domobile.frame.http.C0607f;
import com.domobile.frame.http.C1275d;
import com.domobile.frame.http.C1276e;
import com.domobile.frame.http.image.C1277a;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.lib_blurview.BlurView;
import com.domobile.lib_blurview.C1332f;
import com.domobile.libs_ads.C1342b;
import com.facebook.ads.C0665a;
import com.facebook.ads.C1453b;
import com.facebook.ads.C1459c;
import com.facebook.ads.C1903l;
import com.facebook.ads.MediaView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.NativeExpressAdView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SlidingLeftMenu extends FrameLayout implements OnClickListener, C0607f {
    public View f2475a;
    private Context f2476b;
    private MainTabFragmentActivity f2477c;
    private boolean f2478d;
    private C1238c f2479e;
    private ArrayList<C1237b> f2480f = new ArrayList();
    private ListView f2481g;
    private View f2482h;
    private ImageView f2483i;
    private ArrayList<C1236a> f2484j = new ArrayList();
    private int f2485k = 0;
    private boolean f2486l = false;
    private boolean f2487m = true;
    private int f2488n;

    class C12341 implements Runnable {
        final /* synthetic */ SlidingLeftMenu f2449a;

        class C12331 extends AdListener {
            final /* synthetic */ C12341 f2448a;

            C12331(C12341 c12341) {
                this.f2448a = c12341;
            }

            public void onAdOpened() {
                super.onAdOpened();
                this.f2448a.f2449a.f2477c.m80e();
            }
        }

        C12341(SlidingLeftMenu slidingLeftMenu) {
            this.f2449a = slidingLeftMenu;
        }

        public void run() {
            View nativeExpressAdView = new NativeExpressAdView(this.f2449a.f2476b);
            nativeExpressAdView.setAdSize(new AdSize(C1342b.m3332b(this.f2449a.f2476b, (float) this.f2449a.getMeasuredWidth()), 220));
            nativeExpressAdView.setAdUnitId("ca-app-pub-2172680244283609/8164358971");
            this.f2449a.f2481g.addFooterView(nativeExpressAdView);
            nativeExpressAdView.setAdListener(new C12331(this));
            nativeExpressAdView.loadAd(new Builder().build());
        }
    }

    public static class C1236a {
        public long f2452a;
        public String f2453b;
        public String f2454c;
        public int f2455d = -1;
        public int f2456e;
        public int f2457f;
        public int f2458g;
        public int f2459h;
        public boolean f2460i = true;
        public int f2461j;

        public C1236a(JSONObject jSONObject) {
            this.f2452a = jSONObject.optLong("id", 0);
            this.f2453b = jSONObject.optString("promo_link");
            this.f2454c = jSONObject.optString("promo_pic");
            if (jSONObject.has("promo_pic_id")) {
                this.f2455d = jSONObject.optInt("promo_pic_id", -1);
            }
            this.f2456e = jSONObject.optInt("action_type", 6);
            this.f2457f = jSONObject.optInt("app_type", 0);
            this.f2458g = jSONObject.optInt("gift_flag", 0);
            this.f2459h = jSONObject.optInt("new_version_code", 0);
            this.f2460i = jSONObject.optBoolean("record_click", true);
        }

        private void m2903b(Context context) {
            if (context instanceof C0386c) {
                ((C0386c) context).m80e();
            }
        }

        public void m2904a(Context context) {
            switch (this.f2456e) {
                case 1:
                    m2903b(context);
                    C1148d.ag(context);
                    return;
                case 2:
                    MainTabFragmentActivity.m624a(context);
                    return;
                case 3:
                    m2903b(context);
                    C1148d.m2496H(context, null);
                    return;
                case 4:
                    m2903b(context);
                    C1148d.m2493E(context, this.f2453b);
                    return;
                case 5:
                    m2903b(context);
                    C1148d.m2492D(context, this.f2453b);
                    return;
                case 6:
                    if (context instanceof C0386c) {
                        ((C0386c) context).m78a(false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public class C1237b {
        public int f2462a;
        public int f2463b;
        final /* synthetic */ SlidingLeftMenu f2464c;

        public C1237b(SlidingLeftMenu slidingLeftMenu, int i, int i2) {
            this.f2464c = slidingLeftMenu;
            this.f2462a = i;
            this.f2463b = i2;
        }
    }

    public class C1238c extends BaseAdapter implements OnClickListener {
        final /* synthetic */ SlidingLeftMenu f2465a;
        private ArrayList<C1237b> f2466b;
        private LayoutInflater f2467c;

        public C1238c(SlidingLeftMenu slidingLeftMenu, ArrayList<C1237b> arrayList) {
            this.f2465a = slidingLeftMenu;
            this.f2466b = arrayList;
            this.f2467c = LayoutInflater.from(slidingLeftMenu.getContext());
        }

        public C1237b m2905a(int i) {
            return (C1237b) this.f2466b.get(i);
        }

        public int getCount() {
            return this.f2466b.size();
        }

        public /* synthetic */ Object getItem(int i) {
            return m2905a(i);
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f2467c.inflate(R.layout.sliding_menu_left_item, null);
                view.setOnClickListener(this);
            }
            C1237b a = m2905a(i);
            ((TextView) view.findViewById(16908308)).setText(a.f2462a);
            ((ImageView) view.findViewById(16908294)).setImageResource(a.f2463b);
            view.setTag(a);
            return view;
        }

        public void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof C1237b)) {
                if (this.f2465a.f2477c != null) {
                    this.f2465a.f2477c.m80e();
                }
                switch (((C1237b) view.getTag()).f2462a) {
                    case R.string.domo_rate:
                        C1148d.m2527d(this.f2465a.f2477c);
                        C1150y.m2653s(this.f2465a.f2477c, "rate");
                        return;
                    case R.string.domo_setting:
                        this.f2465a.f2477c.startActivity(AgentActivity.m570a(this.f2465a.f2477c, 274));
                        return;
                    case R.string.domo_share:
                        MainTabFragmentActivity.m624a(this.f2465a.f2477c);
                        C1150y.m2653s(this.f2465a.f2477c, "share");
                        return;
                    case R.string.feedback:
                        C1148d.m2496H(this.f2465a.f2477c, null);
                        C1150y.m2653s(this.f2465a.f2477c, "contact");
                        return;
                    case R.string.facebook:
                        C0634a.m756a(this.f2465a.f2477c);
                        C1150y.m2653s(this.f2465a.f2477c, "facebook");
                        return;
                    case R.string.goole_plus:
                        C1148d.m2492D(this.f2465a.f2477c, this.f2465a.f2477c.getString(R.string.url_goole_plus));
                        C1150y.m2653s(this.f2465a.f2477c, "google+");
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public class C1240d implements Runnable {
        final /* synthetic */ SlidingLeftMenu f2470a;
        private Context f2471b;
        private C1236a f2472c;
        private boolean f2473d;
        private ImageView f2474e;

        public C1240d(SlidingLeftMenu slidingLeftMenu, Context context, C1236a c1236a, ImageView imageView, boolean z) {
            this.f2470a = slidingLeftMenu;
            this.f2472c = c1236a;
            this.f2471b = context;
            this.f2473d = z;
            this.f2474e = imageView;
        }

        public void run() {
            if (this.f2472c != null && !TextUtils.isEmpty(this.f2472c.f2454c)) {
                this.f2470a.f2486l = true;
                Bitmap a = C1277a.m3056a(this.f2472c.f2454c, false, CompressFormat.JPEG);
                this.f2470a.f2486l = false;
                if (a != null && this.f2473d) {
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f2471b.getResources(), a);
                    this.f2470a.f2481g.post(new Runnable(this) {
                        final /* synthetic */ C1240d f2469b;

                        public void run() {
                            SlidingLeftMenu.m2914d(this.f2469b.f2470a);
                            this.f2469b.f2474e.setTag(R.id.tag_object, this.f2469b.f2472c);
                            this.f2469b.f2474e.setImageDrawable(bitmapDrawable);
                            if (this.f2469b.f2470a.f2481g.getFooterViewsCount() <= 0) {
                                try {
                                    this.f2469b.f2470a.f2481g.setAdapter(null);
                                    this.f2469b.f2470a.f2481g.addFooterView(this.f2469b.f2470a.f2482h);
                                    this.f2469b.f2470a.f2481g.setAdapter(this.f2469b.f2470a.f2479e);
                                } catch (Exception e) {
                                    this.f2469b.f2470a.f2481g.setAdapter(this.f2469b.f2470a.f2479e);
                                    this.f2469b.f2470a.f2481g.removeFooterView(this.f2469b.f2470a.f2482h);
                                    this.f2469b.f2470a.f2481g.addFooterView(this.f2469b.f2470a.f2482h);
                                    this.f2469b.f2470a.f2481g.setAdapter(this.f2469b.f2470a.f2479e);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public SlidingLeftMenu(Context context) {
        super(context);
        setupView(context);
    }

    public SlidingLeftMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setupView(context);
    }

    public SlidingLeftMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setupView(context);
    }

    private void m2911b(String str) {
        try {
            this.f2484j.clear();
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                this.f2484j.add(new C1236a(jSONArray.optJSONObject(i)));
            }
            this.f2485k = 0;
            m2921a(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m2913c() {
        findViewById(R.id.drawer_userinfo).setOnClickListener(this);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.leftmenu_header, null);
        bitmapDrawable.setTileModeXY(TileMode.REPEAT, TileMode.CLAMP);
        C1148d.m2514a(findViewById(R.id.drawer_userinfo), (Drawable) bitmapDrawable);
        PackageManager packageManager = this.f2476b.getPackageManager();
        boolean z = !C1150y.m2593a(packageManager, "com.facebook.katana") && C1150y.m2593a(packageManager, "com.google.android.apps.plus");
        this.f2487m = z;
        this.f2479e = new C1238c(this, this.f2480f);
        this.f2481g = (ListView) findViewById(R.id.drawer_listview);
        this.f2481g.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.cardview_light_background, null));
        this.f2481g.setAdapter(this.f2479e);
    }

    static /* synthetic */ int m2914d(SlidingLeftMenu slidingLeftMenu) {
        int i = slidingLeftMenu.f2485k + 1;
        slidingLeftMenu.f2485k = i;
        return i;
    }

    private void m2915d() {
        C0632l.m755a(this, new C12341(this));
    }

    private void m2917e() {
        final C1903l c1903l = new C1903l(this.f2476b, "970977059658692_1336324133123981");
        c1903l.m5407a(new C0665a(this) {
            final /* synthetic */ SlidingLeftMenu f2451b;

            public void mo2390a(C1453b c1453b) {
                super.mo2390a(c1453b);
                ViewGroup frameLayout = new FrameLayout(this.f2451b.f2476b);
                this.f2451b.f2481g.addFooterView(frameLayout);
                View inflate = View.inflate(this.f2451b.f2476b, R.layout.layout_facebook_native_ad_left_menu, null);
                frameLayout.addView(inflate);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.native_ad_icon);
                TextView textView = (TextView) inflate.findViewById(R.id.native_ad_title);
                MediaView mediaView = (MediaView) inflate.findViewById(R.id.native_ad_media);
                TextView textView2 = (TextView) inflate.findViewById(R.id.native_ad_body);
                TextView textView3 = (TextView) inflate.findViewById(R.id.native_ad_call_to_action);
                textView.setText(c1903l.m5416g());
                textView2.setText(c1903l.m5417h());
                textView3.setText(c1903l.m5418i());
                C1903l.m5376a(c1903l.m5414e(), imageView);
                mediaView.setNativeAd(c1903l);
                ((LinearLayout) inflate.findViewById(R.id.ad_choices_container)).addView(new C1459c(this.f2451b.f2476b, c1903l, true));
                List arrayList = new ArrayList();
                arrayList.add(textView);
                arrayList.add(textView3);
                arrayList.add(imageView);
                arrayList.add(mediaView);
                c1903l.m5405a((View) frameLayout, arrayList);
                if (VERSION.SDK_INT >= 17) {
                    BlurView blurView = (BlurView) inflate.findViewById(R.id.blurView);
                    blurView.m3272a(frameLayout).m3267a(frameLayout.getBackground()).m3268a(new C1332f(this.f2451b.f2476b)).m3266a(16.0f);
                    return;
                }
                ((BlurView) inflate.findViewById(R.id.blurView)).setBackgroundColor(ContextCompat.getColor(this.f2451b.f2476b, R.color.adColorOverlay));
            }

            public void mo2392b(C1453b c1453b) {
                super.mo2392b(c1453b);
                this.f2451b.f2477c.m80e();
            }
        });
        c1903l.m5411b();
    }

    private void m2919f() {
        this.f2482h = LayoutInflater.from(this.f2476b).inflate(R.layout.activity_material_promt_view, null);
        this.f2483i = (ImageView) this.f2482h.findViewById(R.id.drawer_promt_imageview);
        this.f2483i.setOnClickListener(this);
        try {
            String b = C1150y.m2602b(this.f2476b, "sliding_right_menu_promo");
            if (!TextUtils.isEmpty(b)) {
                m2911b(b);
            }
        } catch (Exception e) {
        }
        C1148d.m2516a(new C1276e(), this);
    }

    private void setupView(Context context) {
        if (!this.f2478d) {
            this.f2478d = true;
            this.f2476b = context;
            this.f2475a = LayoutInflater.from(context).inflate(R.layout.sliding_menu_left, null);
            addView(this.f2475a);
            m2913c();
            m2922a(this.f2476b);
            this.f2488n = C1342b.m3316a(this.f2476b);
            if (this.f2488n == 2) {
                m2919f();
            } else if (!C1150y.m2645n(this.f2476b)) {
            } else {
                if (this.f2488n == 0) {
                    m2915d();
                } else if (this.f2488n == 1) {
                    m2917e();
                }
            }
        }
    }

    public C1275d mo2363a() {
        return new C1275d(C1147a.m2480a("https://www.domobile.com/", "apps/promo/", this.f2476b.getPackageName(), "_215.json"));
    }

    public void m2921a(int i) {
        if (!this.f2486l && !this.f2484j.isEmpty()) {
            new Thread(new C1240d(this, this.f2476b, (C1236a) this.f2484j.get((this.f2485k + i) % this.f2484j.size()), this.f2483i, true)).start();
        }
    }

    public void m2922a(Context context) {
        ((TextView) findViewById(R.id.drawer_email)).setText(C1150y.aa(context));
    }

    public void mo2364a(String str) {
        m2911b(str);
        if (this.f2484j.isEmpty()) {
            m2911b(C1150y.m2602b(this.f2476b, "sliding_right_menu_promo"));
        } else if (this.f2476b != null) {
            C1148d.m2520b(this.f2476b, "sliding_right_menu_promo", (Object) str);
        }
    }

    public void m2924b() {
        C1150y.m2566a(this.f2477c);
        this.f2480f.add(new C1237b(this, R.string.domo_setting, R.drawable.toolbar_settings));
        this.f2480f.add(new C1237b(this, R.string.domo_rate, R.drawable.toolbar_rating));
        this.f2480f.add(new C1237b(this, R.string.domo_share, R.drawable.toolbar_share));
        if (this.f2487m) {
            this.f2480f.add(new C1237b(this, R.string.goole_plus, R.drawable.toolbar_google_plus));
        } else {
            this.f2480f.add(new C1237b(this, R.string.facebook, R.drawable.toolbar_facebook));
        }
        this.f2480f.add(new C1237b(this, R.string.feedback, R.drawable.toolbar_send));
        this.f2479e.notifyDataSetChanged();
    }

    public C1238c getDrawerItemAdapter() {
        return this.f2479e;
    }

    public ArrayList<C1237b> getDrawerItems() {
        return this.f2480f;
    }

    public ListAdapter getListAdapter() {
        return this.f2481g.getAdapter();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.drawer_userinfo) {
            this.f2477c.m78a(false);
        } else if (view == this.f2483i) {
            Object tag = view.getTag(R.id.tag_object);
            if (tag != null && (tag instanceof C1236a)) {
                C1236a c1236a = (C1236a) tag;
                c1236a.m2904a(this.f2476b);
                C1150y.m2650q(this.f2476b, c1236a.f2453b);
            }
        }
    }

    public void setActivity(MainTabFragmentActivity mainTabFragmentActivity) {
        this.f2477c = mainTabFragmentActivity;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f2481g.setOnItemClickListener(onItemClickListener);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0 && this.f2477c.m68t().isInSearchMode()) {
            this.f2477c.m68t().clearSearch();
        }
    }
}
