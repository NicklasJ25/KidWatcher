package com.domobile.applock.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.domobile.applock.R;
import com.domobile.applock.p012e.C0899d;
import com.domobile.frame.http.image.CacheImageView;
import java.util.ArrayList;

public class C0684e extends Adapter<ViewHolder> {
    private ArrayList<C0899d> f741a = new ArrayList();
    private C0682a f742b;

    public interface C0682a {
        void mo2477b(int i);
    }

    private class C0683b extends ViewHolder implements OnClickListener {
        CacheImageView f736a;
        TextView f737b;
        TextView f738c;
        TextView f739d;
        final /* synthetic */ C0684e f740e;

        C0683b(C0684e c0684e, View view) {
            this.f740e = c0684e;
            super(view);
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setOnClickListener(this);
            this.f736a = (CacheImageView) view.findViewById(R.id.imvIcon);
            this.f737b = (TextView) view.findViewById(R.id.txvTitle);
            this.f738c = (TextView) view.findViewById(R.id.txvContent);
            this.f739d = (TextView) view.findViewById(R.id.txvPostTime);
        }

        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition != -1 && this.f740e.f742b != null) {
                this.f740e.f742b.mo2477b(adapterPosition);
            }
        }
    }

    public void m882a() {
        this.f741a.clear();
        notifyDataSetChanged();
    }

    public void m883a(int i) {
        notifyItemRemoved(i);
        this.f741a.remove(i);
        notifyItemRangeChanged(i, getItemCount());
    }

    public void m884a(C0682a c0682a) {
        this.f742b = c0682a;
    }

    public void m885a(ArrayList<C0899d> arrayList) {
        this.f741a = arrayList;
        notifyDataSetChanged();
    }

    public C0899d m886b(int i) {
        return (C0899d) this.f741a.get(i);
    }

    public int getItemCount() {
        return this.f741a.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C0683b c0683b = (C0683b) viewHolder;
        Context context = c0683b.itemView.getContext();
        C0899d c0899d = (C0899d) this.f741a.get(i);
        c0683b.f737b.setText(c0899d.f1344e);
        c0683b.f738c.setText(c0899d.f1345f);
        c0683b.f739d.setText(c0899d.m1577b());
        c0683b.f736a.setImage(c0899d.m1576b(context));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0683b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_notification_list_item, viewGroup, false));
    }
}
