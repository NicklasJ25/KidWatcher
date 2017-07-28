package com.domobile.applock.chamber.p008a;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.SocialInfo;
import java.util.ArrayList;

public class C0777e extends Adapter<ViewHolder> {
    private ArrayList<SocialInfo> f1028a = new ArrayList();
    private C0775a f1029b;

    public interface C0775a {
        void mo2436a(C0777e c0777e, View view, int i);

        void mo2437b(C0777e c0777e, View view, int i);
    }

    private class C0776b extends ViewHolder implements OnClickListener, OnLongClickListener {
        ImageView f1025a;
        TextView f1026b;
        final /* synthetic */ C0777e f1027c;

        C0776b(C0777e c0777e, View view) {
            this.f1027c = c0777e;
            super(view);
            view.setLayoutParams(new LayoutParams(-2, -2));
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            this.f1025a = (ImageView) view.findViewById(R.id.imvIcon);
            this.f1026b = (TextView) view.findViewById(R.id.txvName);
        }

        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition != -1 && this.f1027c.f1029b != null) {
                this.f1027c.f1029b.mo2436a(this.f1027c, view, adapterPosition);
            }
        }

        public boolean onLongClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (!(adapterPosition == -1 || this.f1027c.f1029b == null)) {
                this.f1027c.f1029b.mo2437b(this.f1027c, view, adapterPosition);
            }
            return false;
        }
    }

    public void m1174a(int i) {
        if (i != -1) {
            this.f1028a.remove(i);
            notifyItemRemoved(i);
            notifyItemRangeChanged(i, getItemCount());
        }
    }

    public void m1175a(C0775a c0775a) {
        this.f1029b = c0775a;
    }

    public void m1176a(SocialInfo socialInfo) {
        m1174a(this.f1028a.indexOf(socialInfo));
    }

    public void m1177a(ArrayList<SocialInfo> arrayList) {
        this.f1028a = arrayList;
        notifyDataSetChanged();
    }

    public SocialInfo m1178b(int i) {
        return (SocialInfo) this.f1028a.get(i);
    }

    public int getItemCount() {
        return this.f1028a.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C0776b c0776b = (C0776b) viewHolder;
        SocialInfo socialInfo = (SocialInfo) this.f1028a.get(i);
        c0776b.f1026b.setText(socialInfo.m1529b(c0776b.itemView.getContext()));
        c0776b.f1025a.setImageResource(socialInfo.m1526a().intValue());
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0776b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_social_list_item, viewGroup, false));
    }
}
