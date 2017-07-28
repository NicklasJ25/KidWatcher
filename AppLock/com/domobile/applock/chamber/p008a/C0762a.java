package com.domobile.applock.chamber.p008a;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.BookmarkInfo;
import com.domobile.frame.http.image.CacheImageView;
import java.util.ArrayList;

public class C0762a extends Adapter<ViewHolder> {
    private ArrayList<BookmarkInfo> f989a = new ArrayList();
    private ArrayList<BookmarkInfo> f990b = new ArrayList();
    private boolean f991c = false;
    private C0759a f992d;
    private C0760b f993e;

    public interface C0759a {
        void mo2428a(int i);

        void mo2429a(View view, int i);
    }

    public interface C0760b {
        void a_();
    }

    private class C0761c extends ViewHolder implements OnClickListener {
        CacheImageView f983a;
        ImageView f984b;
        ImageView f985c;
        TextView f986d;
        TextView f987e;
        final /* synthetic */ C0762a f988f;

        C0761c(C0762a c0762a, View view) {
            this.f988f = c0762a;
            super(view);
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setOnClickListener(this);
            this.f983a = (CacheImageView) view.findViewById(R.id.imvIcon);
            this.f986d = (TextView) view.findViewById(R.id.txvTitle);
            this.f987e = (TextView) view.findViewById(R.id.txvUrl);
            this.f984b = (ImageView) view.findViewById(R.id.imvMore);
            this.f985c = (ImageView) view.findViewById(R.id.imvState);
            this.f984b.setOnClickListener(this);
        }

        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition != -1) {
                if (view == this.f984b) {
                    if (this.f988f.f992d != null) {
                        this.f988f.f992d.mo2429a(view, adapterPosition);
                    }
                } else if (this.f988f.m1123c()) {
                    BookmarkInfo bookmarkInfo = (BookmarkInfo) this.f988f.f989a.get(adapterPosition);
                    if (this.f988f.f990b.contains(bookmarkInfo)) {
                        this.f988f.f990b.remove(bookmarkInfo);
                        this.f985c.setSelected(false);
                    } else {
                        this.f988f.f990b.add(bookmarkInfo);
                        this.f985c.setSelected(true);
                    }
                    if (this.f988f.f993e != null) {
                        this.f988f.f993e.a_();
                    }
                } else if (this.f988f.f992d != null) {
                    this.f988f.f992d.mo2428a(adapterPosition);
                }
            }
        }
    }

    public void m1114a() {
        if (m1124d()) {
            this.f990b.clear();
        } else {
            this.f990b.clear();
            this.f990b.addAll(this.f989a);
        }
        notifyDataSetChanged();
        if (this.f993e != null) {
            this.f993e.a_();
        }
    }

    public void m1115a(int i) {
        if (i != -1) {
            this.f989a.remove(i);
            notifyItemRemoved(i);
            notifyItemRangeChanged(i, getItemCount());
        }
    }

    public void m1116a(C0759a c0759a) {
        this.f992d = c0759a;
    }

    public void m1117a(C0760b c0760b) {
        this.f993e = c0760b;
    }

    public void m1118a(BookmarkInfo bookmarkInfo) {
        m1115a(this.f989a.indexOf(bookmarkInfo));
    }

    public void m1119a(ArrayList<BookmarkInfo> arrayList) {
        this.f989a = arrayList;
        notifyDataSetChanged();
    }

    public void m1120a(boolean z) {
        this.f991c = z;
        if (!this.f991c) {
            this.f990b.clear();
        }
        notifyDataSetChanged();
    }

    public BookmarkInfo m1121b(int i) {
        return (BookmarkInfo) this.f989a.get(i);
    }

    public boolean m1122b() {
        m1120a(!this.f991c);
        return this.f991c;
    }

    public boolean m1123c() {
        return this.f991c;
    }

    public boolean m1124d() {
        return this.f989a.size() == this.f990b.size();
    }

    public ArrayList<BookmarkInfo> m1125e() {
        return this.f990b;
    }

    public ArrayList<BookmarkInfo> m1126f() {
        return this.f989a;
    }

    public int getItemCount() {
        return this.f989a.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C0761c c0761c = (C0761c) viewHolder;
        Context context = c0761c.itemView.getContext();
        BookmarkInfo bookmarkInfo = (BookmarkInfo) this.f989a.get(i);
        c0761c.f984b.setImageResource(R.drawable.toolbar_more);
        C1150y.m2586a(c0761c.f984b, (int) R.color.Theme_Default_textColorSummaryLight, 0);
        c0761c.f983a.m3043a(ContextCompat.getDrawable(context, R.drawable.toolbar_browser)).setImage(bookmarkInfo.m1509b(context));
        c0761c.f986d.setText(bookmarkInfo.m1511c());
        c0761c.f987e.setText(bookmarkInfo.f1282b);
        if (this.f991c) {
            c0761c.f985c.setVisibility(0);
            c0761c.f985c.setSelected(this.f990b.contains(bookmarkInfo));
            return;
        }
        c0761c.f985c.setVisibility(8);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0761c(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_bookmark_list_item, viewGroup, false));
    }
}
