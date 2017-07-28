package com.domobile.applock.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.domobile.applock.AgentActivity;
import com.domobile.applock.C0386c;
import com.domobile.applock.C1150y;
import com.domobile.applock.MainTabFragmentActivity;
import com.domobile.applock.OpenAdvanceProtectActivity;
import com.domobile.applock.PluginsPagerSimpleFragment.C0605a;
import com.domobile.applock.PluginsPagerSimpleFragment.PluginBean;
import com.domobile.applock.R;
import com.domobile.frame.http.image.CacheImageView;
import com.domobile.frame.p000a.C1148d;
import com.domobile.lib_blurview.BlurView;
import com.domobile.lib_blurview.C1332f;
import com.domobile.libs_ads.C1342b;
import com.domobile.widget.PageIndicator;
import com.facebook.ads.C0657e;
import com.facebook.ads.C0665a;
import com.facebook.ads.C1453b;
import com.facebook.ads.C1459c;
import com.facebook.ads.C1460d;
import com.facebook.ads.C1903l;
import com.facebook.ads.MediaView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.NativeExpressAdView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PluginsListAdapter extends Adapter<ViewHolder> {
    private C0386c f698a;
    private PackageManager f699b;
    private ArrayList<C0605a> f700c = new ArrayList();

    public static class ChildLinearLayoutManager extends LinearLayoutManager {
        public ChildLinearLayoutManager(Context context) {
            super(context);
        }

        public ChildLinearLayoutManager(Context context, int i, boolean z) {
            super(context, i, z);
        }

        public ChildLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
            super(context, attributeSet, i, i2);
        }

        public boolean canScrollVertically() {
            return false;
        }
    }

    public static class GroupLinearLayoutManager extends LinearLayoutManager {
        public GroupLinearLayoutManager(Context context) {
            super(context);
        }

        public GroupLinearLayoutManager(Context context, int i, boolean z) {
            super(context, i, z);
        }

        public GroupLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
            super(context, attributeSet, i, i2);
        }

        public boolean canScrollHorizontally() {
            return false;
        }
    }

    private class C0660a extends Adapter<ViewHolder> {
        final /* synthetic */ PluginsListAdapter f678a;
        private ArrayList<PluginBean> f679b;

        private class C0658a extends ViewHolder implements C0657e {
            LinearLayout f665a;
            ImageView f666b;
            TextView f667c;
            TextView f668d;
            LinearLayout f669e;
            C1903l f670f;
            final /* synthetic */ C0660a f671g;

            public C0658a(C0660a c0660a, View view) {
                this.f671g = c0660a;
                super(view);
                view.setLayoutParams(new LayoutParams(-2, -2));
                this.f665a = (LinearLayout) view.findViewById(R.id.native_ad_container);
                this.f666b = (ImageView) view.findViewById(R.id.native_ad_icon);
                this.f667c = (TextView) view.findViewById(R.id.native_ad_title);
                this.f668d = (TextView) view.findViewById(R.id.native_ad_call_to_action);
                this.f669e = (LinearLayout) view.findViewById(R.id.ad_choices_container);
                this.f670f = new C1903l(c0660a.f678a.f698a, "970977059658692_1353368001419594");
                this.f670f.m5407a((C0657e) this);
                this.f670f.m5411b();
            }

            public void mo2390a(C1453b c1453b) {
                this.f667c.setText(this.f670f.m5416g());
                this.f668d.setText(this.f670f.m5418i());
                C1903l.m5376a(this.f670f.m5414e(), this.f666b);
                this.f669e.addView(new C1459c(this.f671g.f678a.f698a, this.f670f, true));
                this.f665a.setVisibility(0);
                List arrayList = new ArrayList();
                arrayList.add(this.f667c);
                arrayList.add(this.f668d);
                arrayList.add(this.f666b);
                this.f670f.m5405a(this.itemView, arrayList);
            }

            public void mo2391a(C1453b c1453b, C1460d c1460d) {
            }

            public void mo2392b(C1453b c1453b) {
                this.f671g.f678a.f698a.m80e();
            }

            public void mo2393c(C1453b c1453b) {
            }
        }

        private class C0659b extends ViewHolder implements OnClickListener {
            View f672a;
            CacheImageView f673b;
            TextView f674c;
            RatingBar f675d;
            TextView f676e;
            final /* synthetic */ C0660a f677f;

            public C0659b(C0660a c0660a, View view) {
                this.f677f = c0660a;
                super(view);
                int i = view.getResources().getDisplayMetrics().widthPixels;
                view.setLayoutParams(new LayoutParams(-2, -2));
                this.f672a = view.findViewById(R.id.vgItemLayer);
                ViewGroup.LayoutParams layoutParams = this.f672a.getLayoutParams();
                layoutParams.width = (int) (((float) i) / 3.5f);
                this.f672a.setLayoutParams(layoutParams);
                this.f673b = (CacheImageView) view.findViewById(R.id.imvIcon);
                this.f674c = (TextView) view.findViewById(R.id.txvName);
                this.f675d = (RatingBar) view.findViewById(R.id.rabRating);
                this.f676e = (TextView) view.findViewById(R.id.txvAction);
                this.f676e.setOnClickListener(this);
                view.setOnClickListener(this);
            }

            public void m842a() {
                int adapterPosition = getAdapterPosition();
                if (adapterPosition != -1) {
                    PluginBean pluginBean = (PluginBean) this.f677f.f679b.get(adapterPosition);
                    this.f673b.setImage(Uri.parse(pluginBean.f509c));
                    this.f674c.setText(pluginBean.f508b);
                    this.f675d.setRating((float) pluginBean.f517k);
                    this.f676e.setSelected(pluginBean.f514h);
                    this.f676e.setText(pluginBean.f514h ? this.itemView.getResources().getString(R.string.open) : pluginBean.f516j);
                }
            }

            public void onClick(View view) {
                int adapterPosition = getAdapterPosition();
                if (adapterPosition != -1) {
                    this.f677f.f678a.m861a((PluginBean) this.f677f.f679b.get(adapterPosition));
                }
            }
        }

        private C0660a(PluginsListAdapter pluginsListAdapter) {
            this.f678a = pluginsListAdapter;
        }

        public void m844a(ArrayList<PluginBean> arrayList) {
            this.f679b = arrayList;
            notifyDataSetChanged();
        }

        public int getItemCount() {
            return this.f679b == null ? 0 : this.f679b.size();
        }

        public int getItemViewType(int i) {
            return (this.f679b == null || !((PluginBean) this.f679b.get(i)).f522p) ? 0 : 1;
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            if (getItemViewType(i) == 0) {
                ((C0659b) viewHolder).m842a();
            }
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return i == 1 ? new C0658a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_facebook_native_ad_recommend_list, viewGroup, false)) : new C0659b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_plugins_list_item, viewGroup, false));
        }
    }

    private class C0661b extends ViewHolder {
        TextView f680a;
        View f681b;
        C0660a f682c;
        final /* synthetic */ PluginsListAdapter f683d;

        public C0661b(PluginsListAdapter pluginsListAdapter, View view) {
            this.f683d = pluginsListAdapter;
            super(view);
            view.setLayoutParams(new LayoutParams(-1, -2));
            this.f680a = (TextView) view.findViewById(R.id.txvName);
            this.f681b = view.findViewById(R.id.divider);
            this.f682c = new C0660a();
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcvPluginsList);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 0, false));
            recyclerView.setAdapter(this.f682c);
        }

        public void m845a() {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition != -1) {
                C0605a c0605a = (C0605a) this.f683d.f700c.get(adapterPosition);
                this.f680a.setText(c0605a.f523a);
                if (this.f683d.m866a(adapterPosition)) {
                    this.f681b.setVisibility(8);
                } else {
                    this.f681b.setVisibility(0);
                }
                this.f682c.m844a(c0605a.f524b);
            }
        }
    }

    private class C0667c extends PagerAdapter {
        final /* synthetic */ PluginsListAdapter f690a;
        private LinkedList<CacheImageView> f691b = new LinkedList();
        private ArrayList<PluginBean> f692c = new ArrayList();

        class C06632 extends AdListener {
            final /* synthetic */ C0667c f686a;

            C06632(C0667c c0667c) {
                this.f686a = c0667c;
            }

            public void onAdOpened() {
                super.onAdOpened();
                this.f686a.f690a.f698a.m80e();
            }
        }

        public C0667c(PluginsListAdapter pluginsListAdapter) {
            this.f690a = pluginsListAdapter;
        }

        private void m856a(final FrameLayout frameLayout) {
            int d = C1342b.m3337d(this.f690a.f698a);
            if (d == 0) {
                View nativeExpressAdView = new NativeExpressAdView(this.f690a.f698a);
                int b = C1342b.m3332b(this.f690a.f698a, (float) this.f690a.f698a.getResources().getDisplayMetrics().widthPixels);
                nativeExpressAdView.setAdSize(new AdSize(b, b / 2));
                nativeExpressAdView.setAdUnitId("ca-app-pub-2172680244283609/8164358971");
                nativeExpressAdView.setAdListener(new C06632(this));
                nativeExpressAdView.loadAd(new Builder().build());
                frameLayout.addView(nativeExpressAdView);
            } else if (d == 1) {
                final C1903l c1903l = new C1903l(this.f690a.f698a, "970977059658692_1353367611419633");
                c1903l.m5407a(new C0665a(this) {
                    final /* synthetic */ C0667c f689c;

                    public void mo2390a(C1453b c1453b) {
                        super.mo2390a(c1453b);
                        View inflate = View.inflate(this.f689c.f690a.f698a, R.layout.layout_facebook_native_ad_recommend_head, null);
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
                        ((LinearLayout) inflate.findViewById(R.id.ad_choices_container)).addView(new C1459c(this.f689c.f690a.f698a, c1903l, true));
                        List arrayList = new ArrayList();
                        arrayList.add(textView);
                        arrayList.add(textView3);
                        arrayList.add(imageView);
                        arrayList.add(mediaView);
                        c1903l.m5405a(frameLayout, arrayList);
                        if (VERSION.SDK_INT >= 17) {
                            BlurView blurView = (BlurView) inflate.findViewById(R.id.blurView);
                            blurView.m3272a(frameLayout).m3267a(frameLayout.getBackground()).m3268a(new C1332f(this.f689c.f690a.f698a)).m3266a(16.0f);
                            return;
                        }
                        ((BlurView) inflate.findViewById(R.id.blurView)).setBackgroundColor(ContextCompat.getColor(this.f689c.f690a.f698a, R.color.adColorOverlay));
                    }

                    public void mo2392b(C1453b c1453b) {
                        super.mo2392b(c1453b);
                        this.f689c.f690a.f698a.m80e();
                    }
                });
                c1903l.m5411b();
            }
        }

        @Nullable
        public CacheImageView m857a() {
            return this.f691b.size() == 0 ? null : (CacheImageView) this.f691b.pollFirst();
        }

        public void m858a(ArrayList<PluginBean> arrayList) {
            this.f692c = arrayList;
            notifyDataSetChanged();
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof CacheImageView) {
                CacheImageView cacheImageView = (CacheImageView) obj;
                viewGroup.removeView(cacheImageView);
                this.f691b.addLast(cacheImageView);
            }
        }

        public int getCount() {
            return this.f692c.size();
        }

        public int getItemPosition(Object obj) {
            return -2;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            final PluginBean pluginBean = (PluginBean) this.f692c.get(i);
            if (pluginBean.f522p) {
                FrameLayout frameLayout = new FrameLayout(this.f690a.f698a);
                m856a(frameLayout);
                viewGroup.addView(frameLayout);
                return frameLayout;
            }
            View a = m857a();
            if (a == null) {
                a = new CacheImageView(viewGroup.getContext());
                a.setScaleType(ScaleType.CENTER_CROP);
            }
            a.setImage(Uri.parse(pluginBean.f519m));
            a.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C0667c f685b;

                public void onClick(View view) {
                    this.f685b.f690a.m861a(pluginBean);
                }
            });
            viewGroup.addView(a);
            return a;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    private class C0668d extends ViewHolder implements OnPageChangeListener, Runnable {
        ViewPager f693a;
        PageIndicator f694b;
        C0667c f695c;
        final /* synthetic */ PluginsListAdapter f696d;
        private final int f697e = 5000;

        public C0668d(PluginsListAdapter pluginsListAdapter, View view) {
            this.f696d = pluginsListAdapter;
            super(view);
            int i = view.getResources().getDisplayMetrics().widthPixels;
            view.setLayoutParams(new LayoutParams(-1, -2));
            this.f693a = (ViewPager) view.findViewById(R.id.vgRecommendList);
            ViewGroup.LayoutParams layoutParams = this.f693a.getLayoutParams();
            layoutParams.height = i / 2;
            this.f693a.setLayoutParams(layoutParams);
            this.f694b = (PageIndicator) view.findViewById(R.id.indicator);
            this.f694b.setActiveColor(R.color.primary_textcolor);
            this.f694b.setNormalColor(R.color.divider_background);
            this.f694b.setRadius(R.dimen.PaddingSizeSmallest);
            this.f694b.setPadding(R.dimen.PaddingSizeSmall);
            this.f695c = new C0667c(pluginsListAdapter);
            this.f693a.setAdapter(this.f695c);
            this.f693a.setOffscreenPageLimit(3);
            this.f693a.addOnPageChangeListener(this);
        }

        public void m859a() {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition != -1) {
                this.f695c.m858a(((C0605a) this.f696d.f700c.get(adapterPosition)).f524b);
                this.f694b.m3556a(this.f695c.getCount());
                this.f694b.m3557b(0);
                this.itemView.postDelayed(this, 5000);
            }
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            this.f694b.m3557b(i);
            if (this.f695c != null && this.f695c.getCount() > 1) {
                this.itemView.removeCallbacks(this);
                this.itemView.postDelayed(this, 5000);
            }
        }

        public void run() {
            try {
                this.f693a.setCurrentItem((this.f693a.getCurrentItem() + 1) % this.f695c.getCount(), true);
            } catch (Exception e) {
            }
        }
    }

    public PluginsListAdapter(C0386c c0386c) {
        this.f698a = c0386c;
        this.f699b = c0386c.getPackageManager();
    }

    private void m861a(@Nullable PluginBean pluginBean) {
        if (pluginBean != null) {
            this.f698a.m80e();
            C1150y.m2652r(this.f698a, pluginBean.f510d);
            if (pluginBean.f520n || pluginBean.m653a(this.f699b)) {
                m864b(pluginBean);
            } else {
                C1148d.m2493E(this.f698a, pluginBean.f510d);
            }
        }
    }

    private void m864b(@Nullable PluginBean pluginBean) {
        if (pluginBean != null) {
            if (pluginBean.f515i == 1) {
                Intent a;
                Object obj = null;
                if (pluginBean.f520n) {
                    a = AgentActivity.m570a(this.f698a, pluginBean.f521o);
                } else if (TextUtils.isEmpty(pluginBean.f511e)) {
                    Intent intent = new Intent("com.domobile.applock.plugins.ACTION_OPEN_HIDED_ACTIVITY");
                    intent.setPackage(pluginBean.f510d);
                    a = intent;
                    int i = 1;
                } else {
                    a = new Intent();
                    a.setClassName(pluginBean.f510d, pluginBean.f511e);
                }
                try {
                    this.f698a.startActivity(a);
                } catch (Exception e) {
                    if (obj != null) {
                        try {
                            this.f698a.startActivity(this.f699b.getLaunchIntentForPackage(pluginBean.f510d));
                        } catch (Exception e2) {
                        }
                    }
                }
            } else if (!TextUtils.equals(pluginBean.f510d, "com.domobile.applockwatcher")) {
            } else {
                if (C1150y.m2542G(this.f698a)) {
                    OpenAdvanceProtectActivity.m645a(this.f698a);
                    return;
                }
                this.f698a.m80e();
                MainTabFragmentActivity.m627a(this.f698a, (int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            }
        }
    }

    public void m865a(ArrayList<C0605a> arrayList) {
        this.f700c = arrayList;
        notifyDataSetChanged();
    }

    public boolean m866a(int i) {
        return i == getItemCount() + -1;
    }

    public int getItemCount() {
        return this.f700c.size();
    }

    public int getItemViewType(int i) {
        return i == 0 ? 10 : 0;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == 10) {
            ((C0668d) viewHolder).m859a();
        } else {
            ((C0661b) viewHolder).m845a();
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 10 ? new C0668d(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_plugins_recommend, viewGroup, false)) : new C0661b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_plugins_category, viewGroup, false));
    }
}
