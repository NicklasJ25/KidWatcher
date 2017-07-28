package com.android.camera;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.android.camera.gallery.C0449h;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.adapter.C0420b;
import com.domobile.frame.http.image.CacheImageView;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1257b.C0421b;
import com.domobile.frame.p000a.C1257b.C0422e;
import java.util.ArrayList;

public class C0423j extends C0420b implements OnClickListener, C0421b, C0422e {
    private static int f124n = 0;
    private ArrayList<C0449h> f125a;
    public LayoutInflater f126b;
    protected Context f127c;
    private ArrayList<C0449h> f128k;
    private C0408b f129l;
    private boolean f130m;

    public interface C0408b {
        void mo2064a(C0423j c0423j, C0449h c0449h, boolean z);
    }

    public class C0481a extends ViewHolder {
        public View f291a;
        public ImageView f292b;
        public CacheImageView f293c;
        public ProgressBar f294d;
        public View f295e;
        final /* synthetic */ C0423j f296f;

        public C0481a(C0423j c0423j, View view) {
            this.f296f = c0423j;
            super(view);
            this.f291a = view.findViewById(R.id.image_gallery_root);
            this.f293c = (CacheImageView) view.findViewById(R.id.thumbnail);
            this.f294d = (ProgressBar) view.findViewById(R.id.image_gallery_item_progress);
            this.f295e = view.findViewById(R.id.image_gallery_play_video);
            this.f292b = C0423j.m174a(view);
        }
    }

    public C0423j(Context context, ArrayList<C0449h> arrayList) {
        this(context, arrayList, false);
    }

    public C0423j(Context context, ArrayList<C0449h> arrayList, boolean z) {
        this.f125a = new ArrayList();
        this.f128k = new ArrayList();
        this.f126b = LayoutInflater.from(context);
        this.f127c = context;
        this.f130m = z;
        if (arrayList != null) {
            this.f125a.addAll(arrayList);
        }
    }

    public static int m173a() {
        if (f124n == 0) {
            f124n = C1150y.m2548M(AppLockApplication.m578c()).x;
        }
        return f124n;
    }

    public static ImageView m174a(View view) {
        return (ImageView) view.findViewById(R.id.image_gallery_item_state);
    }

    private void m175a(ViewHolder viewHolder, int i) {
        C0449h c0449h = (C0449h) this.f125a.get(i);
        C0481a c0481a = (C0481a) viewHolder;
        if (this.f130m) {
            c0481a.f292b.setVisibility(0);
            c0481a.f292b.setSelected(this.f128k.contains(c0449h));
        } else {
            c0481a.f292b.setVisibility(8);
        }
        if (c0449h != c0481a.f291a.getTag()) {
            c0481a.f291a.setTag(c0449h);
            c0481a.f293c.setImageResource(R.drawable.transparent);
            if (c0449h != null) {
                c0481a.f293c.setImage(c0449h);
            }
        }
    }

    public BitmapDrawable mo2069a(Object obj) {
        return !(obj instanceof C0449h) ? null : new BitmapDrawable(this.f127c.getResources(), ((C0449h) obj).mo2089f());
    }

    public void m177a(C0408b c0408b) {
        this.f129l = c0408b;
    }

    public void m178a(boolean z) {
        if (this.f130m != z) {
            this.f130m = z;
            mo2399j();
        }
    }

    public boolean mo2070a(CacheImageView cacheImageView, BitmapDrawable bitmapDrawable) {
        if (bitmapDrawable == null) {
            return false;
        }
        Drawable a = C1150y.m2565a(bitmapDrawable, null, Color.parseColor("#44000000"));
        Drawable a2 = C1148d.m2503a(a);
        cacheImageView.setScaleType(ScaleType.CENTER_CROP);
        cacheImageView.setImageDrawable(a2);
        a2.startTransition(100);
        cacheImageView.setImageDrawable(a);
        return true;
    }

    public boolean m180b() {
        return this.f130m;
    }

    public void m181c() {
        this.f128k.clear();
        this.f128k.addAll(this.f125a);
        mo2399j();
    }

    public void m182d() {
        this.f128k.clear();
        mo2399j();
    }

    public ArrayList m183e() {
        return this.f128k;
    }

    public int m184f() {
        return this.f128k.size();
    }

    public ArrayList m185g() {
        return this.f125a;
    }

    public int getItemCount() {
        return this.f125a.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        try {
            m175a(viewHolder, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (this.f130m && tag != null && (tag instanceof C0449h)) {
            View a = C0423j.m174a(view);
            a.setSelected(!a.isSelected());
            if (a.isSelected()) {
                this.f128k.add((C0449h) tag);
            } else {
                this.f128k.remove(tag);
            }
            if (this.f129l != null) {
                this.f129l.mo2064a(this, (C0449h) tag, a.isSelected());
            }
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewHolder c0481a = new C0481a(this, this.f126b.inflate(R.layout.image_gallery_item, viewGroup, false));
        LayoutParams layoutParams = c0481a.itemView.getLayoutParams();
        layoutParams.width = C0420b.m170b(this.f127c);
        layoutParams.height = layoutParams.width;
        c0481a.itemView.setLayoutParams(layoutParams);
        c0481a.f293c.m3044a((C0421b) this).m3045a((C0422e) this);
        c0481a.f291a.setOnClickListener(this);
        return c0481a;
    }
}
