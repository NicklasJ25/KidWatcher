package com.domobile.applock.chamber.controller;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.domobile.applock.AgentActivity;
import com.domobile.applock.C0400d;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.InvaderBean;
import com.domobile.applock.chamber.p008a.C0774d;
import com.domobile.applock.chamber.p008a.C0774d.C0771a;
import com.domobile.applock.chamber.p008a.C0774d.C0772b;
import com.domobile.applock.chamber.p009c.C0814g;
import com.domobile.applock.p003a.C0614e;
import com.domobile.frame.p000a.C1148d;
import com.domobile.widget.recyclerview.C1411a;
import java.util.ArrayList;
import java.util.Iterator;

public class C0863h extends C0400d implements C0771a, C0772b {
    private SwitchCompat f1222a;
    private View f1223e;
    private C0774d f1224f;
    private RecyclerView f1225g;

    class C08611 extends AsyncTask<Object, Object, ArrayList<InvaderBean>> {
        final /* synthetic */ C0863h f1220a;

        C08611(C0863h c0863h) {
            this.f1220a = c0863h;
        }

        protected ArrayList<InvaderBean> m1452a(Object... objArr) {
            return C0814g.m1303b(this.f1220a.mActivity);
        }

        protected void m1453a(ArrayList<InvaderBean> arrayList) {
            super.onPostExecute(arrayList);
            this.f1220a.f1224f.m1169a((ArrayList) arrayList);
            this.f1220a.m1459e();
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m1452a(objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m1453a((ArrayList) obj);
        }
    }

    class C08622 extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ C0863h f1221a;

        C08622(C0863h c0863h) {
            this.f1221a = c0863h;
        }

        protected Object doInBackground(Object... objArr) {
            Iterator it = this.f1221a.f1224f.m1165a().iterator();
            while (it.hasNext()) {
                C0614e.m707a(((InvaderBean) it.next()).f1297a);
            }
            return null;
        }

        protected void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            this.f1221a.f1224f.m1170b();
            this.f1221a.m1459e();
        }

        protected void onPreExecute() {
            super.onPreExecute();
        }
    }

    private void m1455b() {
        findViewById(R.id.vgHeaderLayer).setOnClickListener(this);
        this.f1222a = (SwitchCompat) findViewById(R.id.swhCheckbox);
        this.f1223e = findViewById(R.id.vgEmptyLayer);
    }

    private void m1457c() {
        this.f1225g = (RecyclerView) findViewById(R.id.rcvInvaderList);
        LayoutManager gridLayoutManager = new GridLayoutManager(this.mActivity, 2);
        gridLayoutManager.setOrientation(1);
        this.f1225g.setLayoutManager(gridLayoutManager);
        this.f1225g.addItemDecoration(new C1411a(this.mActivity.getResources().getDimensionPixelSize(R.dimen.PaddingSizeMiddle)));
    }

    private void m1458d() {
        this.f1224f = new C0774d(this.mActivity);
        this.f1224f.m1167a((C0771a) this);
        this.f1224f.m1168a((C0772b) this);
        this.f1225g.setAdapter(this.f1224f);
    }

    private void m1459e() {
        if (this.f1224f.getItemCount() == 0) {
            this.f1223e.setVisibility(0);
        } else {
            this.f1223e.setVisibility(8);
        }
        this.b.invalidateOptionsMenu();
    }

    private void m1460f() {
        C1148d.m2521b(new C08611(this), new Object[0]);
    }

    private void m1461g() {
        C1148d.m2521b(new C08622(this), new Object[0]);
    }

    public void mo2435a(int i) {
        this.b.m80e();
        startActivity(AgentActivity.m570a(this.mActivity, 307).putExtra("EXTRA_INVADER", this.f1224f.m1164a(i)));
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.init(layoutInflater, viewGroup, bundle);
        this.rootView = layoutInflater.inflate(R.layout.fragment_invader_main, null);
        m1455b();
        m1457c();
    }

    public void onClick(View view) {
        boolean z = false;
        super.onClick(view);
        if (view.getId() == R.id.vgHeaderLayer && a_(0) == null) {
            SwitchCompat switchCompat = this.f1222a;
            if (!this.f1222a.isChecked()) {
                z = true;
            }
            switchCompat.setChecked(z);
            C1150y.m2615c(this.mActivity, this.f1222a.isChecked());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m1458d();
        m1460f();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.intruder_hint_title);
        C1150y.m2651r(this.mActivity);
        C1150y.m2605b(this.mActivity, (int) R.string.event_invader_main);
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.invader_main_menus, menu);
        super.onCreateCustomOptionsMenus(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_action_clear) {
            return false;
        }
        m1461g();
        return true;
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem findItem = menu.findItem(R.id.menu_action_clear);
        if (this.f1224f.getItemCount() > 0) {
            findItem.setEnabled(true);
            Drawable drawable = ContextCompat.getDrawable(this.mActivity, R.drawable.icon_clear_while);
            drawable.setAlpha(255);
            findItem.setIcon(drawable);
            return;
        }
        findItem.setEnabled(false);
        drawable = ContextCompat.getDrawable(this.mActivity, R.drawable.icon_clear_while);
        drawable.setAlpha(85);
        findItem.setIcon(drawable);
    }

    public void onStart() {
        super.onStart();
        this.f1222a.setChecked(C1150y.m2658u(this.mActivity));
        m1458d();
        m1460f();
    }
}
