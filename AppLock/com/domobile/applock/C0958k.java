package com.domobile.applock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.domobile.applock.adapter.C0419f;
import com.domobile.applock.p003a.C0621h;
import com.domobile.applock.p003a.C0621h.C0619a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.widget.recyclerview.NpaLinearLayoutManager;
import java.util.ArrayList;

public class C0958k extends C0704e {
    private LayoutInflater f1520a;
    private RecyclerView f1521e;
    private C0621h f1522f;
    private ArrayList<C0619a> f1523g = new ArrayList();
    private Point f1524h;
    private BroadcastReceiver f1525i = new C09551(this);

    class C09551 extends BroadcastReceiver {
        final /* synthetic */ C0958k f1513a;

        C09551(C0958k c0958k) {
            this.f1513a = c0958k;
        }

        public void onReceive(Context context, Intent intent) {
            if ("com.domobile.applock.ACTION_INFOS_CENTER_RELOAD_COMPLETE".equals(intent.getAction())) {
                this.f1513a.m1728c();
            }
        }
    }

    public class C0956a extends ViewHolder {
        public TextView f1514a;
        public TextView f1515b;
        public TextView f1516c;
        public TextView f1517d;
        final /* synthetic */ C0958k f1518e;

        public C0956a(C0958k c0958k, View view) {
            this.f1518e = c0958k;
            super(view);
            try {
                this.f1514a = (TextView) view.findViewById(R.id.fragment_infos_card_item_title);
                this.f1515b = (TextView) view.findViewById(R.id.fragment_infos_card_item_message);
                this.f1516c = (TextView) view.findViewById(R.id.fragment_infos_card_item_details);
                this.f1517d = (TextView) view.findViewById(R.id.fragment_infos_card_item_more);
            } catch (Exception e) {
            }
        }
    }

    private class C0957b extends C0419f implements OnClickListener {
        final /* synthetic */ C0958k f1519a;

        private C0957b(C0958k c0958k) {
            this.f1519a = c0958k;
        }

        public C0619a m1723a(int i) {
            return (C0619a) this.f1519a.f1523g.get(i);
        }

        public C0956a m1724a(ViewGroup viewGroup, int i) {
            int i2 = R.layout.fragment_infos_card_item;
            if (i == 0) {
                i2 = R.layout.domo_empty_view;
            }
            return new C0956a(this.f1519a, this.f1519a.f1520a.inflate(i2, viewGroup, false));
        }

        public int getItemCount() {
            return this.f1519a.f1523g.isEmpty() ? 1 : this.f1519a.f1523g.size();
        }

        public int getItemViewType(int i) {
            return this.f1519a.f1523g.isEmpty() ? 0 : 1;
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            C0956a c0956a = (C0956a) viewHolder;
            if (c0956a.getItemViewType() == 0) {
                c0956a.itemView.getLayoutParams().height = (int) (((float) this.f1519a.f1524h.y) * 0.75f);
                c0956a.itemView.setVisibility(0);
                View findViewById = c0956a.itemView.findViewById(R.id.empty_loading_noitems_image);
                c0956a.itemView.findViewById(R.id.empty_loading_progress).setVisibility(8);
                findViewById.setVisibility(0);
                return;
            }
            findViewById = c0956a.itemView;
            if (i == 0) {
                findViewById.setPadding(findViewById.getPaddingLeft(), (int) (((double) findViewById.getPaddingBottom()) * 1.5d), findViewById.getPaddingRight(), findViewById.getPaddingBottom());
            } else {
                findViewById.setPadding(findViewById.getPaddingLeft(), 0, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
            }
            c0956a.itemView.findViewById(R.id.fragment_infos_card_item_event).setOnClickListener(this);
            c0956a.f1517d.setOnClickListener(this);
            c0956a.f1516c.setVisibility(8);
            c0956a.f1517d.setText(R.string.details);
            C0619a a = m1723a(i);
            c0956a.itemView.findViewById(R.id.fragment_infos_card_item_event).setTag(a);
            c0956a.f1517d.setTag(a);
            c0956a.f1514a.setText(a.m724b());
            c0956a.f1515b.setText(a.m725c());
        }

        public void onClick(View view) {
            View view2 = view.getId() == R.id.fragment_infos_card_item_more ? (View) view.getParent().getParent() : view;
            C0619a c0619a = (C0619a) view.getTag();
            this.f1519a.b.m80e();
            ContextCompat.startActivity(this.f1519a.mActivity, AgentActivity.m570a(this.f1519a.mActivity, 273).putExtra("com.domobile.applock.EXTRA_DATA_JSON", c0619a.f558a.toString()), ActivityOptionsCompat.makeSceneTransitionAnimation(this.f1519a.mActivity, view2, "info_card").toBundle());
        }

        public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return m1724a(viewGroup, i);
        }
    }

    private void m1728c() {
        if (MainTabFragmentActivity.m633l() != null) {
            this.f1522f = MainTabFragmentActivity.m633l().m644n();
            this.f1523g = this.f1522f.m738b();
            if (this.f1521e.getAdapter() != null) {
                this.f1521e.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1520a = layoutInflater;
        this.f1524h = C1148d.m2500a(this.mActivity.getWindowManager());
        this.f1521e = new RecyclerView(this.mActivity);
        this.f1521e.setLayoutParams(new LayoutParams(-1, -1));
        this.f1521e.setPadding(0, this.b.h.getHeight(), 0, 0);
        this.f1521e.setLayoutManager(new NpaLinearLayoutManager(this.mActivity));
        this.f1521e.setAdapter(new C0957b());
        this.rootView = this.f1521e;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1150y.m2605b(this.mActivity, (int) R.string.event_infos_center);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        C1148d.m2509a(this.mActivity, this.f1525i);
    }

    public void onResume() {
        super.onResume();
        this.b.m56b(R.string.applock_news);
        m1728c();
        this.mActivity.registerReceiver(this.f1525i, new IntentFilter("com.domobile.applock.ACTION_INFOS_CENTER_RELOAD_COMPLETE"));
    }
}
