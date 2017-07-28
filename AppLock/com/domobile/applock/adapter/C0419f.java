package com.domobile.applock.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;

public abstract class C0419f<VH extends ViewHolder> extends Adapter {
    protected final int f117d = 0;
    protected final int f118e = 1;
    protected final int f119f = 2;
    protected final int f120g = 3;
    protected final int f121h = 4;
    protected final int f122i = 10;
    protected RecyclerView f123j;

    class C06851 implements Runnable {
        final /* synthetic */ C0419f f743a;

        C06851(C0419f c0419f) {
            this.f743a = c0419f;
        }

        public void run() {
            this.f743a.mo2399j();
        }
    }

    public void m165a(long j) {
        if (this.f123j != null) {
            this.f123j.postDelayed(new C06851(this), j);
        }
    }

    public RecyclerView m166i() {
        return this.f123j;
    }

    public void mo2399j() {
        if (this.f123j != null) {
            for (int childCount = this.f123j.getChildCount() - 1; childCount > -1; childCount--) {
                ViewHolder childViewHolder = this.f123j.getChildViewHolder(this.f123j.getChildAt(childCount));
                if (!(childViewHolder == null || childViewHolder.getAdapterPosition() == -1)) {
                    onBindViewHolder(childViewHolder, childViewHolder.getAdapterPosition());
                }
            }
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f123j = recyclerView;
        this.f123j.setItemViewCacheSize(0);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f123j = null;
    }
}
