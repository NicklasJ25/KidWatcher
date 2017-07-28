package com.domobile.applock.adapter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.aj.C0721a;
import com.domobile.frame.http.image.CacheImageView;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1257b.C0421b;
import com.domobile.lockbean.Scene;
import java.util.ArrayList;
import java.util.Arrays;

public class C0688g extends C0419f implements C0421b {
    private OnClickListener f752a;
    private OnItemClickListener f753b;
    private OnItemLongClickListener f754c;
    private ArrayList<Scene> f755k;
    private ArrayList<Scene> f756l;
    private Drawable f757m;
    private boolean f758n;
    private Context f759o;
    private Resources f760p;
    private PackageManager f761q;
    private boolean f762r;
    private Drawable f763s;

    private class C0687a extends ViewHolder implements OnClickListener, OnLongClickListener {
        View f744a;
        View f745b;
        ImageView f746c;
        TextView f747d;
        TextView f748e;
        ImageView f749f;
        ViewGroup f750g;
        final /* synthetic */ C0688g f751h;

        private C0687a(C0688g c0688g, View view) {
            this.f751h = c0688g;
            super(view);
            this.f747d = (TextView) view.findViewById(R.id.scenes_item_title);
            this.f748e = (TextView) view.findViewById(R.id.scenes_item_summary);
            this.f746c = (ImageView) view.findViewById(R.id.scenes_item_icon);
            this.f749f = (ImageView) view.findViewById(R.id.scenes_item_more);
            this.f750g = (ViewGroup) view.findViewById(R.id.scenes_item_apps);
            this.f745b = view.findViewById(R.id.scenes_item_parent);
            this.f744a = view.findViewById(R.id.divider);
            this.f749f.setOnClickListener(this);
            this.f745b.setOnClickListener(this);
            this.f745b.setOnLongClickListener(this);
        }

        public void onClick(View view) {
            if (view.getTag() != null) {
                if (view == this.f745b) {
                    if (this.f751h.f753b != null) {
                        int indexOf = this.f751h.f755k.indexOf(view.getTag());
                        this.f751h.f753b.onItemClick(null, view, indexOf, (long) indexOf);
                    }
                } else if (this.f751h.f752a != null) {
                    this.f751h.f752a.onClick(view);
                }
            }
        }

        public boolean onLongClick(View view) {
            if (view.getTag() == null || this.f751h.f754c == null) {
                return false;
            }
            int indexOf = this.f751h.f755k.indexOf(view.getTag());
            return this.f751h.f754c.onItemLongClick(null, view, indexOf, (long) indexOf);
        }
    }

    public C0688g(Context context, ArrayList<Scene> arrayList) {
        this(context, arrayList, false);
    }

    public C0688g(Context context, ArrayList<Scene> arrayList, boolean z) {
        this.f755k = new ArrayList();
        this.f756l = new ArrayList();
        this.f759o = context;
        this.f762r = z;
        this.f761q = context.getPackageManager();
        this.f760p = context.getResources();
        this.f763s = new BitmapDrawable(this.f760p, BitmapFactory.decodeResource(this.f760p, 17301651));
        if (arrayList != null) {
            this.f755k.addAll(arrayList);
        }
        this.f757m = ResourcesCompat.getDrawable(this.f760p, R.drawable.toolbar_ok, null).mutate();
        this.f757m.setColorFilter(ResourcesCompat.getColor(this.f760p, R.color.accent_material_light, null), Mode.SRC_ATOP);
    }

    private void m888a(C0687a c0687a, int i) {
        if (i >= 0) {
            c0687a.f750g.setVisibility(i == 0 ? 8 : 0);
            c0687a.f748e.setVisibility(i == 0 ? 0 : 8);
            c0687a.f744a.setVisibility(m890b(i) ? 8 : 0);
            Scene scene = (Scene) this.f755k.get(i);
            c0687a.f747d.setText(scene.f2923b);
            c0687a.itemView.setTag(scene);
            c0687a.f745b.setTag(scene);
            c0687a.f749f.setTag(scene);
            if (i == 0) {
                c0687a.f746c.setImageResource(R.drawable.toolbar_unlock_all);
            } else if (i == 1) {
                c0687a.f746c.setImageResource(R.drawable.toolbar_guest);
            } else {
                c0687a.f746c.setImageResource(R.drawable.toolbar_profile1);
            }
            C1150y.m2586a(c0687a.f746c, (int) R.color.actionbar_toolbar_background, 0);
            String a = scene.m3392a();
            if (TextUtils.isEmpty(a)) {
                c0687a.f750g.removeAllViews();
            } else if (!a.equals(c0687a.f750g.getTag())) {
                int dimensionPixelSize = this.f760p.getDimensionPixelSize(R.dimen.PaddingSizeSmallest);
                int i2 = c0687a.f750g.getLayoutParams().height - (dimensionPixelSize * 2);
                String[] split = a.split(",");
                if (split != null) {
                    Arrays.sort(split);
                }
                c0687a.f750g.removeAllViews();
                for (int min = Math.min(split != null ? split.length : 0, 8) - 1; min > -1; min--) {
                    if (!TextUtils.isEmpty(split[min])) {
                        View cacheImageView = new CacheImageView(this.f759o);
                        cacheImageView.m3044a((C0421b) this).m3046a(true).m3043a(this.f763s);
                        cacheImageView.setLayoutParams(new LayoutParams(i2, i2));
                        ((LayoutParams) cacheImageView.getLayoutParams()).setMargins(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                        cacheImageView.setImage(split[min]);
                        cacheImageView.setTag(split[min]);
                        c0687a.f750g.addView(cacheImageView);
                    }
                }
            }
            c0687a.f750g.setTag(a);
            if (this.f762r) {
                c0687a.f749f.setVisibility(8);
            } else if (this.f758n) {
                c0687a.f749f.setOnClickListener(null);
                c0687a.f749f.setClickable(false);
                if (this.f756l.contains(scene)) {
                    c0687a.f749f.setVisibility(0);
                    c0687a.f749f.setImageDrawable(this.f757m);
                    return;
                }
                c0687a.f749f.setVisibility(8);
            } else {
                c0687a.f749f.setOnClickListener(c0687a);
                c0687a.f749f.setVisibility(0);
                c0687a.f749f.setImageResource(R.drawable.toolbar_more);
                C1150y.m2586a(c0687a.f749f, (int) R.color.Theme_Default_textColorSummaryLight, 0);
            }
        }
    }

    private boolean m890b(int i) {
        return i >= getItemCount() + -1;
    }

    public BitmapDrawable mo2069a(Object obj) {
        if (obj == null || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        try {
            return "com.domobile.notification".equals(str) ? (BitmapDrawable) C1148d.m2502a(this.f759o.getResources(), (int) R.drawable.icon_notification_lock_small) : (BitmapDrawable) this.f761q.getPackageInfo(str, 0).applicationInfo.loadIcon(this.f761q);
        } catch (Exception e) {
            r1 = ResourcesCompat.getColor(this.f760p, R.color.actionbar_toolbar_background, null);
            r0 = C0721a.m999c(this.f759o, str).mutate();
            if (r0 != null) {
                int color;
                Drawable mutate;
                mutate.setColorFilter(color, Mode.SRC_ATOP);
            }
            return (BitmapDrawable) mutate;
        }
    }

    public Scene m894a(int i) {
        return (Scene) this.f755k.get(i);
    }

    public ArrayList<Scene> m895a() {
        return this.f756l;
    }

    public void m896a(OnClickListener onClickListener) {
        this.f752a = onClickListener;
    }

    public void m897a(OnItemClickListener onItemClickListener) {
        this.f753b = onItemClickListener;
    }

    public void m898a(OnItemLongClickListener onItemLongClickListener) {
        this.f754c = onItemLongClickListener;
    }

    public void m899a(ArrayList<Scene> arrayList) {
        this.f755k.clear();
        this.f755k.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void m900a(boolean z, Scene scene) {
        this.f758n = z;
        this.f756l.clear();
        if (scene != null) {
            this.f756l.add(scene);
        }
        mo2399j();
    }

    public ArrayList<Scene> m901b() {
        return this.f755k;
    }

    public boolean m902c() {
        return this.f758n;
    }

    public int getItemCount() {
        return this.f755k.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void mo2399j() {
        try {
            for (int childCount = this.j.getChildCount() - 1; childCount > -1; childCount--) {
                View childAt = this.j.getChildAt(childCount);
                m888a((C0687a) this.j.getChildViewHolder(childAt), this.f755k.indexOf(childAt.getTag()));
            }
        } catch (Exception e) {
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        m888a((C0687a) viewHolder, i);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0687a(LayoutInflater.from(this.f759o).inflate(R.layout.scenes_item, viewGroup, false));
    }
}
