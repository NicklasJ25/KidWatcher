package com.domobile.applock.adapter;

import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.PointerIconCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.domobile.applock.AgentActivity;
import com.domobile.applock.C0386c;
import com.domobile.applock.C1150y;
import com.domobile.applock.MainTabFragmentActivity;
import com.domobile.applock.R;
import com.domobile.applock.p003a.C0621h;
import com.domobile.applock.p003a.C0621h.C0619a;
import com.domobile.eframe.ui.SlidingLeftMenu.C1236a;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1257b.C0421b;
import com.domobile.frame.ui.C1288c;
import com.domobile.lockbean.C1370i;
import com.domobile.widget.AppLockSwitch;
import com.domobile.widget.LockerHeaderItemView;
import com.domobile.widget.OverscrollRecyclerView.C0652a;
import com.domobile.widget.RecommendAdsView;
import com.facebook.ads.C0657e;
import com.facebook.ads.C1453b;
import com.facebook.ads.C1459c;
import com.facebook.ads.C1460d;
import com.facebook.ads.C1903l;
import java.util.ArrayList;
import java.util.List;

public class C0653c extends C0652a<C0680d> implements OnClickListener, C0421b {
    private int[] f622a = new int[]{R.string.sys_lock, R.string.switcher_lock, R.string.app_lock};
    private C0386c f623b;
    private LayoutInflater f624c;
    private PackageManager f625k;
    private Handler f626l;
    private int[] f627m = new int[]{0, 0, 0};
    private ArrayList<C1370i> f628n = new ArrayList();
    private boolean f629o = false;
    private boolean f630p = false;
    private View f631q;
    private View f632r;
    private OnClickListener f633s = null;
    private OnCheckedChangeListener f634t = null;
    private ArrayList<C0619a> f635u = new ArrayList();
    private C0621h f636v;
    private RecyclerView f637w;
    private boolean f638x = true;

    class C06722 implements OnClickListener {
        final /* synthetic */ C0653c f711a;

        C06722(C0653c c0653c) {
            this.f711a = c0653c;
        }

        public void onClick(View view) {
        }
    }

    class C06733 implements OnClickListener {
        final /* synthetic */ C0653c f712a;

        C06733(C0653c c0653c) {
            this.f712a = c0653c;
        }

        public void onClick(View view) {
            this.f712a.f623b.m80e();
            MainTabFragmentActivity.m627a(this.f712a.f623b, (int) FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            C1150y.m2647p(this.f712a.f623b, "advance_protection");
        }
    }

    class C06744 implements OnClickListener {
        final /* synthetic */ C0653c f713a;

        C06744(C0653c c0653c) {
            this.f713a = c0653c;
        }

        public void onClick(View view) {
            this.f713a.f623b.m80e();
            this.f713a.f623b.m78a(false);
        }
    }

    class C06755 implements OnClickListener {
        final /* synthetic */ C0653c f714a;

        C06755(C0653c c0653c) {
            this.f714a = c0653c;
        }

        public void onClick(View view) {
            this.f714a.m782d();
        }
    }

    class C06766 implements OnClickListener {
        final /* synthetic */ C0653c f715a;

        C06766(C0653c c0653c) {
            this.f715a = c0653c;
        }

        public void onClick(View view) {
            this.f715a.m784e();
        }
    }

    class C06788 implements OnClickListener {
        final /* synthetic */ C0653c f719a;

        C06788(C0653c c0653c) {
            this.f719a = c0653c;
        }

        public void onClick(View view) {
        }
    }

    class C06799 implements OnClickListener {
        final /* synthetic */ C0653c f720a;

        C06799(C0653c c0653c) {
            this.f720a = c0653c;
        }

        public void onClick(View view) {
            ((MainTabFragmentActivity) this.f720a.f623b).m636a((int) R.string.category_enable_saving_power);
            C1150y.m2647p(this.f720a.f623b, "power_save");
        }
    }

    private class C0681a extends C0680d implements C0657e {
        LinearLayout f728a;
        ImageView f729b;
        TextView f730c;
        TextView f731d;
        TextView f732e;
        LinearLayout f733f;
        C1903l f734g;
        final /* synthetic */ C0653c f735h;

        public C0681a(C0653c c0653c, View view) {
            this.f735h = c0653c;
            super(view);
            view.setLayoutParams(new LayoutParams(-1, -2));
            this.f728a = (LinearLayout) view.findViewById(R.id.native_ad_container);
            this.f729b = (ImageView) view.findViewById(R.id.native_ad_icon);
            this.f730c = (TextView) view.findViewById(R.id.native_ad_title);
            this.f731d = (TextView) view.findViewById(R.id.native_ad_body);
            this.f732e = (TextView) view.findViewById(R.id.native_ad_call_to_action);
            this.f733f = (LinearLayout) view.findViewById(R.id.ad_choices_container);
            this.f734g = new C1903l(c0653c.f623b, "970977059658692_1343861222370272");
            this.f734g.m5407a((C0657e) this);
            this.f734g.m5411b();
        }

        public void mo2390a(C1453b c1453b) {
            this.f730c.setText(this.f734g.m5416g());
            this.f731d.setText(this.f734g.m5417h());
            this.f732e.setText(this.f734g.m5418i());
            C1903l.m5376a(this.f734g.m5414e(), this.f729b);
            this.f733f.addView(new C1459c(this.f735h.f623b, this.f734g, true));
            this.f728a.setVisibility(0);
            List arrayList = new ArrayList();
            arrayList.add(this.f730c);
            arrayList.add(this.f732e);
            arrayList.add(this.f729b);
            this.f734g.m5405a(this.itemView, arrayList);
        }

        public void mo2391a(C1453b c1453b, C1460d c1460d) {
        }

        public void mo2392b(C1453b c1453b) {
            this.f735h.f623b.m80e();
        }

        public void mo2393c(C1453b c1453b) {
        }
    }

    public C0653c(C0386c c0386c, OnClickListener onClickListener, OnCheckedChangeListener onCheckedChangeListener) {
        this.f623b = c0386c;
        this.f626l = new Handler(c0386c.getMainLooper());
        this.f625k = c0386c.getPackageManager();
        this.f624c = LayoutInflater.from(c0386c);
        this.f633s = onClickListener;
        this.f634t = onCheckedChangeListener;
        this.f632r = this.f624c.inflate(R.layout.domo_empty_view, null);
        this.f632r.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f623b.getResources().getDimensionPixelSize(R.dimen.action_toolbar_height)));
        this.f632r.setVisibility(0);
    }

    private void m779a(LockerHeaderItemView lockerHeaderItemView, final RecommendAdsView recommendAdsView) {
        final C1236a a = RecommendAdsView.m3558a(this.f623b, this.f638x);
        if (a.f2461j == 10) {
            lockerHeaderItemView.setImageDrawable(ContextCompat.getDrawable(this.f623b, R.drawable.icon_account_center));
            lockerHeaderItemView.setTitle(this.f623b.getString(R.string.binlling_center));
            lockerHeaderItemView.setOnClickListener(new C06744(this));
            lockerHeaderItemView.setVisibility(0);
            ((View) recommendAdsView.getParent()).setVisibility(8);
        } else if (a.f2461j == 11) {
            if (!C1150y.m2554S(this.f623b)) {
                lockerHeaderItemView.setImageDrawable(ContextCompat.getDrawable(this.f623b, R.drawable.icon_protect_power_save));
                lockerHeaderItemView.setTitle(this.f623b.getString(R.string.save_power_mode));
                lockerHeaderItemView.setOnClickListener(new C06755(this));
            }
            lockerHeaderItemView.setVisibility(0);
            ((View) recommendAdsView.getParent()).setVisibility(8);
        } else if (a.f2461j == 12) {
            if (!C1150y.m2542G(this.f623b)) {
                lockerHeaderItemView.setImageDrawable(ContextCompat.getDrawable(this.f623b, R.drawable.icon_protect_advance));
                lockerHeaderItemView.setTitle(this.f623b.getString(R.string.device_admin));
                lockerHeaderItemView.setOnClickListener(new C06766(this));
            }
            lockerHeaderItemView.setVisibility(0);
            ((View) recommendAdsView.getParent()).setVisibility(8);
        } else {
            recommendAdsView.setAdsBean(a);
            recommendAdsView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C0653c f718c;

                public void onClick(View view) {
                    this.f718c.f623b.m80e();
                    RecommendAdsView.m3561a(this.f718c.f623b, recommendAdsView.getAdsBean());
                    C1150y.m2647p(this.f718c.f623b, a.f2453b);
                }
            });
            lockerHeaderItemView.setVisibility(8);
            ((View) recommendAdsView.getParent()).setVisibility(0);
        }
        this.f638x = false;
    }

    private void m782d() {
        C1288c c1288c = new C1288c(this.f623b);
        c1288c.m3101a((int) R.string.save_power_mode);
        c1288c.m3123d((int) R.string.save_power_mode_summary);
        c1288c.m3102a(17039360, new C06788(this));
        c1288c.m3114b((int) R.string.on, new C06799(this));
        c1288c.m3122d();
    }

    private void m784e() {
        C1288c c1288c = new C1288c(this.f623b);
        c1288c.m3101a((int) R.string.device_admin);
        c1288c.m3123d((int) R.string.device_admin_summary);
        c1288c.m3102a(17039360, new C06722(this));
        c1288c.m3114b((int) R.string.on, new C06733(this));
        c1288c.m3122d();
    }

    protected int mo2385a() {
        return (this.f635u == null || this.f635u.size() <= 0) ? 1 : 2;
    }

    public BitmapDrawable mo2069a(Object obj) {
        return (obj == null || !(obj instanceof C1370i)) ? null : (BitmapDrawable) ((C1370i) obj).m3452a(this.f625k);
    }

    public C0680d m787a(ViewGroup viewGroup, int i) {
        if (i == 3) {
            View view = new View(this.f623b);
            view.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(0, 0));
            return new C0680d(view);
        }
        int i2;
        if (i == 4) {
            i2 = R.layout.fragment_infos_card_item_header;
        } else if (i == 0) {
            i2 = R.layout.fragment_locker_header;
        } else if (i == 10) {
            return new C0681a(this, View.inflate(viewGroup.getContext(), R.layout.layout_facebook_native_ad_app_list, null));
        } else {
            C0680d c0680d = new C0680d(this.f624c.inflate(R.layout.fragment_locker_item, viewGroup, false));
            c0680d.f724l.m3044a((C0421b) this).m3046a(true).m3043a(ResourcesCompat.getDrawable(this.f623b.getResources(), 17301651, null));
            return c0680d;
        }
        View inflate = this.f624c.inflate(i2, viewGroup, false);
        if (inflate.findViewById(R.id.locker_header_container) != null) {
            view = inflate.findViewById(R.id.locker_header_container);
            view.setTag(Integer.valueOf(PointerIconCompat.TYPE_CROSSHAIR));
            view.findViewById(R.id.locker_media_safe).setOnClickListener(this.f633s);
            view.findViewById(R.id.locker_backroom).setOnClickListener(this.f633s);
            view.findViewById(R.id.locker_header_more).setOnClickListener(this.f633s);
            m779a((LockerHeaderItemView) view.findViewById(R.id.locker_header_func), (RecommendAdsView) view.findViewById(R.id.imvRecommend));
        }
        return new C0680d(inflate);
    }

    public C1370i m788a(int i) {
        int i2 = 0;
        int a = mo2385a();
        if (i < a) {
            return null;
        }
        int i3 = i - a;
        int length = this.f627m.length;
        a = 0;
        while (i2 < length) {
            a += this.f627m[i2];
            if (i3 < a) {
                return (C1370i) this.f628n.get(i3);
            }
            i2++;
        }
        return null;
    }

    public String m789a(boolean z, String str) {
        int i = z ? R.string.protect_startup : R.string.protect_stop;
        return C1147a.m2480a(this.f623b.getString(i), str);
    }

    public void m790a(C0621h c0621h, ArrayList<C0619a> arrayList) {
        this.f636v = c0621h;
        if (arrayList != null) {
            this.f635u.clear();
            this.f635u.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    public void m791a(ArrayList<C1370i> arrayList, ArrayList<C1370i> arrayList2, ArrayList<C1370i> arrayList3, boolean z) {
        this.f629o = z;
        this.f628n.clear();
        if (arrayList != null) {
            this.f628n.addAll(arrayList);
            this.f627m[0] = arrayList.size();
        }
        if (arrayList2 != null) {
            this.f628n.addAll(arrayList2);
            this.f627m[1] = arrayList2.size();
        }
        if (arrayList3 != null) {
            this.f628n.addAll(arrayList3);
            this.f627m[2] = arrayList3.size();
        }
        notifyDataSetChanged();
    }

    public void m792a(boolean z) {
        int i = 0;
        this.f630p = !z;
        if (this.f631q != null) {
            View view = this.f631q;
            if (!z) {
                i = 8;
            }
            view.setVisibility(i);
        }
        notifyDataSetChanged();
    }

    public void m793b() {
        View findViewWithTag = this.f637w.findViewWithTag(Integer.valueOf(PointerIconCompat.TYPE_CROSSHAIR));
        if (findViewWithTag != null) {
            m779a((LockerHeaderItemView) findViewWithTag.findViewById(R.id.locker_header_func), (RecommendAdsView) findViewWithTag.findViewById(R.id.imvRecommend));
        }
    }

    public void m794b(int i) {
        C1370i a = m788a(i);
        if (a != null && this.f637w != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f637w.getLayoutManager();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            while (findFirstVisibleItemPosition < findLastVisibleItemPosition && findFirstVisibleItemPosition != -1) {
                if (findFirstVisibleItemPosition != i) {
                    C1370i a2 = m788a(findFirstVisibleItemPosition);
                    if (a2 != null && TextUtils.equals(a.f2953c, a2.f2953c)) {
                        bindViewHolder(this.f637w.findViewHolderForAdapterPosition(this.f637w.getChildAdapterPosition(linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition))), findFirstVisibleItemPosition);
                    }
                }
                findFirstVisibleItemPosition++;
            }
        }
    }

    public int getItemCount() {
        return (!this.f629o ? 1 : 0) + (this.f628n.size() + mo2385a());
    }

    public int getItemViewType(int i) {
        int a = mo2385a();
        if (i < a) {
            return this.f630p ? 3 : (a == 2 && i == 0) ? 4 : 0;
        } else {
            C1370i a2 = m788a(i);
            return (a2 == null || !a2.f2957g) ? 1 : 10;
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f637w = recyclerView;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C0680d c0680d = (C0680d) viewHolder;
        int itemViewType = c0680d.getItemViewType();
        if (itemViewType == 1) {
            itemViewType = i - mo2385a();
            if (itemViewType == this.f627m[0] - 1 || itemViewType == (this.f627m[0] + this.f627m[1]) - 1 || i == getItemCount() - 1) {
                c0680d.f726n.setVisibility(0);
            } else {
                c0680d.f726n.setVisibility(8);
            }
            if (this.f622a.length != 0) {
                c0680d.f721i.setVisibility(0);
                if (itemViewType == 0 && this.f627m[0] > 0) {
                    c0680d.f721i.setText(this.f622a[0]);
                } else if (itemViewType == this.f627m[0] && this.f627m[1] > 0) {
                    c0680d.f721i.setText(this.f622a[1]);
                } else if (itemViewType != this.f627m[0] + this.f627m[1] || this.f627m[2] <= 0) {
                    c0680d.f721i.setText("");
                    c0680d.f721i.setVisibility(8);
                } else {
                    c0680d.f721i.setText(this.f622a[2]);
                }
            }
            if (this.f632r.getParent() != null) {
                ((ViewGroup) this.f632r.getParent()).removeView(this.f632r);
            }
            if (i == getItemCount() - 1) {
                if (!this.f629o && this.f622a.length > 2) {
                    c0680d.f721i.setText(this.f622a[2]);
                    ((ViewGroup) c0680d.f721i.getParent()).addView(this.f632r, 1);
                    ((View) c0680d.f722j.getParent()).setVisibility(8);
                }
                c0680d.f726n.setVisibility(8);
                if (this.f633s != null) {
                    c0680d.f727o.setVisibility(0);
                }
            } else {
                c0680d.f727o.setVisibility(8);
            }
            C1370i a = m788a(i);
            if (a != null && !a.f2957g) {
                View findViewById = c0680d.itemView.findViewById(R.id.locker_item_event);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
                findViewById.setTag(a);
                c0680d.f725m.setOnCheckedChangeListener(null);
                c0680d.f722j.setText(a.f2952b);
                c0680d.f723k.setText(a.f2951a);
                c0680d.f724l.setTag(a);
                Drawable a2 = a.m3451a();
                if (a2 != null) {
                    c0680d.f724l.setImageDrawable(a2);
                } else {
                    c0680d.f724l.setImage(a);
                }
                c0680d.f725m.setTag(a);
                c0680d.f725m.setTag(R.id.tag_object, Integer.valueOf(i));
                c0680d.f725m.setChecked(a.f2955e);
                c0680d.f725m.setOnCheckedChangeListener(this.f634t);
            }
        } else if (itemViewType == 4 && mo2385a() > 1) {
            ((C0619a) this.f635u.get(0)).m722a(c0680d.itemView);
            c0680d.itemView.findViewById(R.id.fragment_infos_card_item_cardview).setOnClickListener(this);
            c0680d.itemView.findViewById(R.id.fragment_infos_card_item_details).setOnClickListener(this);
            c0680d.itemView.findViewById(R.id.fragment_infos_card_item_more).setOnClickListener(this);
        }
    }

    public void onClick(View view) {
        if (view.getTag() instanceof C1370i) {
            AppLockSwitch appLockSwitch = (AppLockSwitch) view.findViewById(R.id.list_item_permission);
            appLockSwitch.setCheckedFromUser(!appLockSwitch.isChecked());
        } else if (view.getTag() instanceof C0619a) {
            final C0619a c0619a = (C0619a) view.getTag();
            if (view.getId() != R.id.fragment_infos_card_item_more) {
                this.f623b.m80e();
                ContextCompat.startActivity(this.f623b, AgentActivity.m570a(this.f623b, 273).putExtra("com.domobile.applock.EXTRA_DATA_JSON", c0619a.f558a.toString()), ActivityOptionsCompat.makeSceneTransitionAnimation(this.f623b, this.f623b.findViewById(R.id.fragment_infos_card_item), "info_card").toBundle());
            }
            this.f636v.m735a(this.f623b, c0619a);
            this.f626l.postDelayed(new Runnable(this) {
                final /* synthetic */ C0653c f710b;

                public void run() {
                    this.f710b.f635u.remove(c0619a);
                    this.f710b.notifyDataSetChanged();
                }
            }, 300);
        }
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m787a(viewGroup, i);
    }
}
