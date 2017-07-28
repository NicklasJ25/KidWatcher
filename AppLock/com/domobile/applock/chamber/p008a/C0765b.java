package com.domobile.applock.chamber.p008a;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.C0886a;
import java.util.ArrayList;

public class C0765b extends Adapter<ViewHolder> {
    private ArrayList<C0886a> f999a = new ArrayList();
    private C0763a f1000b;

    public interface C0763a {
        void mo2431a(int i);
    }

    private class C0764b extends ViewHolder implements OnClickListener {
        ImageView f994a;
        ImageView f995b;
        TextView f996c;
        TextView f997d;
        final /* synthetic */ C0765b f998e;

        C0764b(C0765b c0765b, View view) {
            this.f998e = c0765b;
            super(view);
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setOnClickListener(this);
            this.f994a = (ImageView) view.findViewById(R.id.imvIcon);
            this.f996c = (TextView) view.findViewById(R.id.txvTitle);
            this.f997d = (TextView) view.findViewById(R.id.txvDesc);
            this.f995b = (ImageView) view.findViewById(R.id.imvRemind);
        }

        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition != -1 && this.f998e.f1000b != null) {
                this.f998e.f1000b.mo2431a(adapterPosition);
            }
        }
    }

    public C0886a m1129a(int i) {
        return (C0886a) this.f999a.get(i);
    }

    public void m1130a(C0763a c0763a) {
        this.f1000b = c0763a;
    }

    public void m1131a(ArrayList<C0886a> arrayList) {
        this.f999a = arrayList;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f999a.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C0764b c0764b = (C0764b) viewHolder;
        C0886a c0886a = (C0886a) this.f999a.get(i);
        c0764b.f994a.setImageResource(c0886a.f1307b);
        c0764b.f996c.setText(c0886a.f1308c);
        c0764b.f997d.setText(c0886a.f1309d);
        c0764b.f995b.setVisibility(c0886a.f1310e ? 0 : 4);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0764b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_chamber_list_item, viewGroup, false));
    }
}
