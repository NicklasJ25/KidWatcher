package com.domobile.applock.chamber.p008a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.InvaderBean;
import com.domobile.frame.http.image.CacheImageView;
import java.util.ArrayList;

public class C0774d extends Adapter<ViewHolder> {
    private int f1019a;
    private int f1020b;
    private int f1021c;
    private ArrayList<InvaderBean> f1022d = new ArrayList();
    private C0771a f1023e;
    private C0772b f1024f;

    public interface C0771a {
        void mo2435a(int i);
    }

    public interface C0772b {
    }

    private class C0773c extends ViewHolder implements OnClickListener, OnLongClickListener {
        CacheImageView f1016a;
        FrameLayout f1017b;
        final /* synthetic */ C0774d f1018c;

        C0773c(C0774d c0774d, View view) {
            this.f1018c = c0774d;
            super(view);
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            this.f1016a = (CacheImageView) view.findViewById(R.id.imvImage);
            this.f1016a.m3052b(false);
            this.f1017b = (FrameLayout) view.findViewById(R.id.vgItemLayer);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1017b.getLayoutParams();
            layoutParams.width = c0774d.f1019a;
            layoutParams.height = c0774d.f1020b;
            this.f1017b.setLayoutParams(layoutParams);
        }

        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (this.f1018c.f1023e != null && adapterPosition != -1) {
                this.f1018c.f1023e.mo2435a(adapterPosition);
            }
        }

        public boolean onLongClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (this.f1018c.f1024f == null || adapterPosition != -1) {
            }
            return false;
        }
    }

    public C0774d(Context context) {
        this.f1021c = context.getResources().getDimensionPixelSize(R.dimen.PaddingSizeMiddle);
        m1166a(context);
    }

    public InvaderBean m1164a(int i) {
        return (InvaderBean) this.f1022d.get(i);
    }

    public ArrayList<InvaderBean> m1165a() {
        return this.f1022d;
    }

    public void m1166a(Context context) {
        int i = context.getResources().getDisplayMetrics().widthPixels;
        float f = ((float) context.getResources().getDisplayMetrics().heightPixels) / ((float) i);
        this.f1019a = (i - (this.f1021c * 3)) / 2;
        this.f1020b = (int) (((float) this.f1019a) * f);
    }

    public void m1167a(C0771a c0771a) {
        this.f1023e = c0771a;
    }

    public void m1168a(C0772b c0772b) {
        this.f1024f = c0772b;
    }

    public void m1169a(ArrayList<InvaderBean> arrayList) {
        this.f1022d = arrayList;
        notifyDataSetChanged();
    }

    public void m1170b() {
        this.f1022d.clear();
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f1022d.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ((C0773c) viewHolder).f1016a.setImage(((InvaderBean) this.f1022d.get(i)).m1520a());
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0773c(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_invader_list_item, viewGroup, false));
    }
}
