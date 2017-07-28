package com.domobile.applock.chamber.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.domobile.applock.AgentActivity;
import com.domobile.applock.C0400d;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.C0886a;
import com.domobile.applock.chamber.p008a.C0765b;
import com.domobile.applock.chamber.p008a.C0765b.C0763a;
import com.domobile.widget.recyclerview.C1412b;
import java.io.File;
import java.util.ArrayList;

public class C0843d extends C0400d implements C0763a {
    private C0765b f1173a;

    private int m1406b(@DimenRes int i) {
        return getResources().getDimensionPixelSize(i);
    }

    private void m1407b() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcvItemList);
        LayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        ItemDecoration c1412b = new C1412b(this.mActivity);
        c1412b.m3583a((m1406b(R.dimen.PaddingSizeLarge) * 2) + m1406b(R.dimen.icon_size_sdo));
        recyclerView.addItemDecoration(c1412b);
        this.f1173a = new C0765b();
        this.f1173a.m1130a((C0763a) this);
        recyclerView.setAdapter(this.f1173a);
    }

    @NonNull
    private ArrayList<C0886a> m1408c() {
        boolean z = true;
        ArrayList<C0886a> arrayList = new ArrayList();
        C0886a c0886a = new C0886a();
        c0886a.f1306a = 0;
        c0886a.f1307b = R.drawable.icon_browser;
        c0886a.f1308c = getString(R.string.traceless_browser_title);
        c0886a.f1309d = getString(R.string.traceless_browser_desc);
        c0886a.f1310e = false;
        arrayList.add(c0886a);
        c0886a = new C0886a();
        c0886a.f1306a = 1;
        c0886a.f1307b = R.drawable.icon_private_sns;
        c0886a.f1308c = getString(R.string.privacy_social_title);
        c0886a.f1309d = getString(R.string.privacy_social_desc);
        c0886a.f1310e = false;
        arrayList.add(c0886a);
        Object t = C1150y.m2655t(this.mActivity);
        C0886a c0886a2 = new C0886a();
        c0886a2.f1306a = 2;
        c0886a2.f1307b = R.drawable.icon_intruder;
        c0886a2.f1308c = getString(R.string.intruder_hint_title);
        c0886a2.f1309d = getString(R.string.intruder_hint_desc);
        if (TextUtils.isEmpty(t) || !new File(t).exists()) {
            z = false;
        }
        c0886a2.f1310e = z;
        arrayList.add(c0886a2);
        return arrayList;
    }

    public void mo2431a(int i) {
        C0886a a = this.f1173a.m1129a(i);
        if (a.f1306a == 0) {
            this.b.m80e();
            startActivity(new Intent(this.mActivity, BrowserMainActivity.class));
        } else if (a.f1306a == 1) {
            this.b.m80e();
            BrowserHostActivity.m1312b(this.mActivity);
        } else if (a.f1306a == 2) {
            this.b.m80e();
            startActivity(AgentActivity.m570a(this.mActivity, 306));
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.init(layoutInflater, viewGroup, bundle);
        this.rootView = layoutInflater.inflate(R.layout.fragment_chamber_main, null);
        m1407b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.secret_chamber);
        C1150y.m2605b(this.mActivity, (int) R.string.event_chamber_main);
    }

    public void onResume() {
        super.onResume();
        this.f1173a.m1131a(m1408c());
    }
}
