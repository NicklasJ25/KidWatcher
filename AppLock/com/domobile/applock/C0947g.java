package com.domobile.applock;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.camera.C0487k;
import com.domobile.applock.ai.C0718a;
import com.domobile.applock.p003a.C0632l;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.p001a.C0581a;
import com.domobile.p001a.C0581a.C0569a;
import com.domobile.p001a.p002a.C0576d;
import com.domobile.p001a.p002a.C0577e;
import com.domobile.p001a.p002a.C0578f;
import com.domobile.p001a.p002a.C0580h;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class C0947g extends C0704e implements C0569a {
    private final int f1469a = R.string.advance_user_monthly;
    private final int f1470e = R.string.advance_user_yearly;
    private View f1471f;
    private View f1472g;
    private View f1473h;
    private View f1474i;
    private boolean f1475j = false;
    private ArrayList<C0946e> f1476k;
    private AppLockApplication f1477l;
    private boolean f1478m = false;
    private String f1479n = "$0.99";
    private String f1480o = "$5.99";
    private TextView f1481p;
    private ViewPropertyAnimatorListener f1482q = new C09404(this);

    class C09371 implements Runnable {
        final /* synthetic */ C0947g f1453a;

        C09371(C0947g c0947g) {
            this.f1453a = c0947g;
        }

        public void run() {
            ViewCompat.setY(this.f1453a.f1474i, (float) this.f1453a.f1474i.getMeasuredHeight());
            this.f1453a.f1474i.setVisibility(0);
        }
    }

    class C09382 implements Runnable {
        final /* synthetic */ C0947g f1454a;

        C09382(C0947g c0947g) {
            this.f1454a = c0947g;
        }

        public void run() {
            C1148d.m2520b(this.f1454a.mActivity, "billing_mode", (Object) Integer.valueOf(1));
            C1147a.m2485d(this.f1454a.mActivity, R.string.billing_ad_mode_summary);
            C1150y.m2598b(this.f1454a.mActivity).f2220B = false;
            this.f1454a.m1687g();
        }
    }

    class C09393 implements C0718a {
        final /* synthetic */ C0947g f1455a;

        C09393(C0947g c0947g) {
            this.f1455a = c0947g;
        }

        public void mo2445a() {
            this.f1455a.m1674a((C0946e) this.f1455a.f1476k.get(0));
        }

        public void mo2446b() {
            if (!this.f1455a.f1477l.f430e) {
                this.f1455a.m1674a((C0946e) this.f1455a.f1476k.get(1));
            }
        }
    }

    class C09404 implements ViewPropertyAnimatorListener {
        final /* synthetic */ C0947g f1456a;

        C09404(C0947g c0947g) {
            this.f1456a = c0947g;
        }

        public void onAnimationCancel(View view) {
            this.f1456a.f1475j = false;
        }

        public void onAnimationEnd(View view) {
            this.f1456a.f1475j = false;
        }

        public void onAnimationStart(View view) {
        }
    }

    private class C0941a extends ClickableSpan {
        final /* synthetic */ C0947g f1457a;

        private C0941a(C0947g c0947g) {
            this.f1457a = c0947g;
        }

        public void onClick(View view) {
            this.f1457a.f1472g.performClick();
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    private class C0942b extends ClickableSpan {
        final /* synthetic */ C0947g f1458a;

        private C0942b(C0947g c0947g) {
            this.f1458a = c0947g;
        }

        public void onClick(View view) {
            this.f1458a.m1689i();
        }
    }

    private class C0943c extends ClickableSpan {
        final /* synthetic */ C0947g f1459a;

        private C0943c(C0947g c0947g) {
            this.f1459a = c0947g;
        }

        public void onClick(View view) {
            this.f1459a.f1471f.performClick();
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    private class C0945d extends Adapter<ViewHolder> {
        String[] f1462a;
        final /* synthetic */ C0947g f1463b;

        class C0944a extends ViewHolder {
            TextView f1460a;
            final /* synthetic */ C0945d f1461b;

            C0944a(C0945d c0945d, View view) {
                this.f1461b = c0945d;
                super(view);
                view.setLayoutParams(new LayoutParams(-1, -2));
                this.f1460a = (TextView) view.findViewById(R.id.txvDesc);
            }
        }

        public C0945d(C0947g c0947g) {
            this.f1463b = c0947g;
            this.f1462a = c0947g.getResources().getStringArray(R.array.premium_features_arrary);
        }

        public int getItemCount() {
            return this.f1462a.length;
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            ((C0944a) viewHolder).f1460a.setText(this.f1462a[i]);
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0944a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_premium_list_item, viewGroup, false));
        }
    }

    private class C0946e {
        public String f1464a;
        public String f1465b;
        public String f1466c;
        public boolean f1467d;
        final /* synthetic */ C0947g f1468e;

        public C0946e(C0947g c0947g, String str, String str2, String str3) {
            this.f1468e = c0947g;
            this.f1464a = str2;
            this.f1465b = str3;
            this.f1466c = str;
            this.f1467d = C0581a.m555c(c0947g.mActivity, str2);
        }

        public String m1671a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("title", this.f1465b);
                jSONObject.put("productId", this.f1464a);
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        }

        public boolean equals(Object obj) {
            return ((obj instanceof C0946e) && TextUtils.equals(this.f1464a, ((C0946e) obj).f1464a)) ? true : super.equals(obj);
        }
    }

    public static Intent m1672a(Context context, boolean z) {
        C1150y.m2598b(context).f2220B = z;
        return AgentActivity.m570a(context, 290);
    }

    private void m1674a(C0946e c0946e) {
        try {
            this.f1477l.f429d.m559a(this.mActivity, (Fragment) this, new C0580h(c0946e.f1466c, c0946e.m1671a()));
            this.b.m80e();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void m1679c() {
        this.f1476k = new ArrayList();
        this.f1476k.add(new C0946e(this, "subs", "applock_subs_monthly", this.mActivity.getString(R.string.advance_user_monthly)));
        this.f1476k.add(new C0946e(this, "subs", "applock_subscription_yearly", this.mActivity.getString(R.string.advance_user_yearly)));
        this.f1476k.add(new C0946e(this, "subs", "applock_subs_yearly", this.mActivity.getString(R.string.advance_user_yearly)));
        this.f1477l = C1150y.m2566a(this.mActivity);
        ArrayList arrayList = new ArrayList();
        arrayList.add("applock_subs_monthly");
        arrayList.add("applock_subscription_yearly");
        arrayList.add("applock_subs_yearly");
        String h = C1150y.m2630h(this.mActivity, this.mActivity.getString(R.string.encode_base64_key));
        this.f1477l.f429d = new C0581a(this.mActivity, h, arrayList, this, false);
    }

    private void m1681d() {
        this.f1471f = findViewById(R.id.vgSubsMode);
        this.f1472g = findViewById(R.id.vgAdsMode);
        this.f1473h = findViewById(R.id.vgFreeMode);
        this.f1471f.setOnClickListener(this);
        this.f1472g.setOnClickListener(this);
        this.f1473h.setOnClickListener(this);
        findViewById(R.id.vgPremiumTitle).setOnClickListener(this);
        findViewById(R.id.txvCancelSubs).setOnClickListener(this);
        this.f1474i = findViewById(R.id.vgPremiumList);
        this.f1481p = (TextView) findViewById(R.id.txvSubsPrice);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcvPremiumList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new C0945d(this));
        TextView textView = (TextView) findViewById(R.id.txvAdsDesc);
        String string = this.mActivity.getString(R.string.premium_features);
        String string2 = this.mActivity.getString(R.string.billing_ad_mode_summary);
        int indexOf = string2.indexOf(string);
        int length = string.length() + indexOf;
        CharSequence spannableString = new SpannableString(string2);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#169588")), indexOf, length, 33);
        spannableString.setSpan(new UnderlineSpan(), indexOf, length, 33);
        spannableString.setSpan(new C0942b(), indexOf, length, 33);
        if (indexOf > 0) {
            spannableString.setSpan(new C0941a(), 0, indexOf - 1, 33);
        }
        if (length < string2.length() - 1) {
            spannableString.setSpan(new C0941a(), length, string2.length() - 1, 33);
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        this.f1474i.setVisibility(4);
        C0632l.m755a(this.rootView, new C09371(this));
        this.f1474i.setOnClickListener(this);
    }

    private void m1682e() {
        if ((C0487k.m420b() <= 0) && !C1150y.m2598b(this.mActivity).f2220B) {
            m1687g();
        } else if (C1150y.m2635j(this.mActivity) == 1 || this.f1477l.f430e) {
            m1687g();
        } else {
            this.f1472g.setSelected(true);
            this.mHandler.postDelayed(new C09382(this), 1000);
        }
    }

    private void m1685f() {
        String str;
        if (this.f1477l.f430e) {
            ((View) this.f1481p.getParent()).setVisibility(0);
            String string = this.mActivity.getString(R.string.billing_advance_user_now);
            if (!this.f1477l.f431f) {
                this.f1481p.setText(this.mActivity.getString(R.string.advance_user_monthly, new Object[]{this.f1479n}));
                str = string;
            } else if (C0581a.m555c(this.mActivity, "applock_subscription_yearly")) {
                this.f1481p.setText(this.mActivity.getString(R.string.advance_user_yearly, new Object[]{this.f1480o}));
                str = string;
            } else {
                this.f1481p.setText(this.mActivity.getString(R.string.advance_user_yearly, new Object[]{C1148d.m2524c(this.mActivity, "applock_subs_yearly", "$2.99")}));
                str = string;
            }
        } else {
            ((View) this.f1481p.getParent()).setVisibility(8);
            str = this.mActivity.getString(R.string.general_user_info);
        }
        TextView textView = (TextView) findViewById(R.id.txvSubsDesc);
        String string2 = this.mActivity.getString(R.string.premium_features);
        int indexOf = str.indexOf(string2);
        int length = string2.length() + indexOf;
        CharSequence spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#169588")), indexOf, length, 33);
        spannableString.setSpan(new UnderlineSpan(), indexOf, length, 33);
        spannableString.setSpan(new C0942b(), indexOf, length, 33);
        if (indexOf > 0) {
            spannableString.setSpan(new C0943c(), 0, indexOf - 1, 33);
        }
        if (length < str.length() - 1) {
            spannableString.setSpan(new C0943c(), length, str.length() - 1, 33);
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
    }

    private void m1687g() {
        this.f1471f.setSelected(false);
        this.f1472g.setSelected(false);
        this.f1473h.setSelected(false);
        if (this.f1477l.f430e) {
            this.f1471f.setSelected(true);
        } else if (C1150y.m2635j(this.mActivity) == 1) {
            this.f1472g.performClick();
        } else {
            this.f1473h.performClick();
        }
    }

    private boolean m1688h() {
        if (!this.f1477l.f430e) {
            return true;
        }
        C1150y.m2567a(this.mActivity, (int) R.string.advance_user, (int) R.string.billing_advance_user_now, 17039370).m3113b((int) R.drawable.icon_dialog_alert_holo_light);
        return false;
    }

    private void m1689i() {
        if (!this.f1475j) {
            this.f1475j = true;
            ViewCompat.animate(this.f1474i).translationY(0.0f).setListener(this.f1482q).start();
        }
    }

    private void m1690j() {
        if (!this.f1475j) {
            this.f1475j = true;
            ViewCompat.animate(this.f1474i).translationY((float) this.f1474i.getHeight()).setListener(this.f1482q).start();
        }
    }

    public void mo2447a(C0576d c0576d) {
        if (c0576d == null || c0576d.m527c()) {
            hideLoadingDialog();
        }
    }

    public void mo2448a(C0577e c0577e, C0576d c0576d) {
        if (c0576d == null || c0576d.m527c() || c0577e == null) {
            hideLoadingDialog();
            return;
        }
        this.f1478m = true;
        C0580h a = c0577e.m528a("applock_subs_monthly");
        C0580h a2 = c0577e.m528a("applock_subs_yearly");
        C0580h a3 = c0577e.m528a("applock_subscription_yearly");
        if (a != null) {
            this.f1479n = a.m542c();
            C1148d.m2520b(this.mActivity, a.m541b(), (Object) a.m542c());
        }
        if (a3 != null) {
            this.f1480o = a3.m542c();
            C1148d.m2520b(this.mActivity, a3.m541b(), (Object) a3.m542c());
        }
        if (a2 != null) {
            C1148d.m2520b(this.mActivity, a2.m541b(), (Object) a2.m542c());
        }
        Iterator it = this.f1476k.iterator();
        while (it.hasNext()) {
            C0946e c0946e = (C0946e) it.next();
            c0946e.f1467d = this.f1477l.f429d.m561a(c0577e, c0946e.f1464a);
            C0578f b = c0577e.m531b(c0946e.f1464a);
            if (b != null) {
                C0581a.m545a(this.mActivity, b);
            } else {
                C0581a.m553b(this.mActivity, c0946e.f1464a);
            }
        }
        AppLockApplication.m577b().m583a();
        m1685f();
        hideLoadingDialog();
    }

    public void mo2449a(C0578f c0578f, C0576d c0576d) {
        if (c0576d != null && c0576d.m526b() && c0578f != null) {
            C0581a.m545a(this.mActivity, c0578f);
            for (int i = 0; i < this.f1476k.size(); i++) {
                C0946e c0946e = (C0946e) this.f1476k.get(i);
                if (c0578f.m535b().equals(c0946e.f1464a)) {
                    c0946e.f1467d = true;
                }
            }
            AppLockApplication.m577b().m583a();
            m1687g();
            m1685f();
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.init(layoutInflater, viewGroup, bundle);
        this.rootView = layoutInflater.inflate(R.layout.fragment_billing_center, null);
        m1679c();
        m1681d();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.f1477l.f429d.m560a(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.vgPremiumTitle) {
            m1690j();
        } else if (view.getId() == R.id.txvCancelSubs) {
            this.b.m80e();
            C1148d.af(this.mActivity);
        } else if (view == this.f1471f) {
            ai.m990a(getChildFragmentManager(), this.f1479n, this.f1480o).m993a(new C09393(this));
        } else if (view == this.f1472g) {
            if (m1688h()) {
                this.f1472g.setSelected(true);
                this.f1473h.setSelected(false);
                if (!C1150y.m2641l(this.mActivity)) {
                    C1147a.m2485d(this.mActivity, R.string.billing_ad_mode_summary);
                }
                C1148d.m2520b(this.mActivity, "billing_mode", (Object) Integer.valueOf(1));
                C1148d.m2489A(this.mActivity, "com.domobile.elock.action.ACTION_PURCHASE_STATE_CHANGED");
                m1685f();
            }
        } else if (view == this.f1473h && m1688h()) {
            if (C0487k.m420b() <= 0) {
                this.f1473h.setSelected(true);
                this.f1472g.setSelected(false);
                if (!C1150y.m2643m(this.mActivity)) {
                    C1147a.m2485d(this.mActivity, R.string.billing_free_mode_summary);
                }
                C1148d.m2520b(this.mActivity, "billing_mode", (Object) Integer.valueOf(2));
                C1148d.m2489A(this.mActivity, "com.domobile.elock.action.ACTION_PURCHASE_STATE_CHANGED");
                m1685f();
                C1150y.m2615c(this.mActivity, false);
                return;
            }
            C1150y.m2567a(this.mActivity, (int) R.string.notice, (int) R.string.need_revert_hided_medias, 17039370).m3113b((int) R.drawable.icon_dialog_alert_holo_light).m3122d();
            this.f1472g.performClick();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.binlling_center);
        C1150y.m2605b(this.mActivity, (int) R.string.event_billing_center);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f1477l.f429d.m564d();
    }

    public void onResume() {
        if (this.b.getRequestedOrientation() != 1) {
            this.b.setRequestedOrientation(1);
        }
        super.onResume();
        m1682e();
        m1685f();
        if (this.f1477l.f429d == null) {
            return;
        }
        if (!this.f1477l.f429d.m562b()) {
            this.f1477l.f429d.m558a();
        } else if (!this.f1478m) {
            this.f1477l.f429d.m563c();
        }
    }
}
