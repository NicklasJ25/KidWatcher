package com.domobile.applock;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.domobile.frame.C0399d;
import com.domobile.frame.ui.C1288c;

public class C0400d extends C0399d implements OnPageChangeListener, OnClickListener {
    private boolean f70a;
    public C0386c f71b;
    public boolean f72c;
    protected Toast f73d;

    public void mo2402a() {
    }

    public void m109a(Fragment fragment, int i) {
        this.f71b.m80e();
        fragment.startActivityForResult(new Intent(this.mActivity, ScenesEditorActivity.class), i);
    }

    protected void m110a(SwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#009688"), Color.parseColor("#31a99e"), Color.parseColor("#63bdb4"), Color.parseColor("#94d0cb"), Color.parseColor("#63bdb4"), Color.parseColor("#31a99e"));
    }

    public void m111a(CharSequence charSequence) {
        m112a(charSequence, 0);
    }

    public void m112a(CharSequence charSequence, int i) {
        if (this.f73d != null) {
            this.f73d.cancel();
        }
        this.f73d = Toast.makeText(getContext(), charSequence, i);
        this.f73d.show();
    }

    public C1288c a_(int i) {
        if (i <= 0) {
            i = R.string.billing_feature_message;
        }
        return !C1150y.m2539D(this.mActivity) ? C1150y.m2571a(this.f71b, this.mActivity.getString(i)) : null;
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
    }

    public void onClick(View view) {
        if (this.mActionBar.m3003a(view)) {
            this.f71b.f46c = true;
            this.mActivity.finish();
            return;
        }
        super.onClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mActivity instanceof C0386c) {
            this.f71b = (C0386c) this.mActivity;
            this.mActionBar.m3009d().setOnClickListener(this);
            return;
        }
        Log.e("eLock", "BaseDoMoFragment的持有者必须是BaseDoMoActivity");
        this.mActivity.finish();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f72c = true;
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
    }

    public void onResume() {
        super.onResume();
        this.mActionBar.m3006b(false);
        this.f71b.m69u();
        this.f70a = true;
    }

    public void ui(int i, Message message) {
    }
}
