package com.domobile.applock;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import com.android.camera.C0433g;
import com.domobile.applock.adapter.C0653c;
import com.domobile.applock.aj.C0721a;
import com.domobile.applock.p012e.C0898c;
import com.domobile.applock.service.LockService;
import com.domobile.frame.C0655a;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1257b;
import com.domobile.frame.ui.C1288c;
import com.domobile.lockbean.C1370i;
import com.domobile.lockbean.C1371j;
import com.domobile.lockbean.Scene;
import com.domobile.widget.ActionImageView;
import com.domobile.widget.AppLockSwitch;
import com.domobile.widget.recyclerview.NpaLinearLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ad extends C0400d implements OnQueryTextListener, C0655a {
    private C1370i f640A;
    private OnCheckedChangeListener f641B = new C06517(this);
    byte[] f642a = new byte[1];
    private LayoutInflater f643e;
    private PackageManager f644f;
    private EditText f645g;
    private View f646h;
    private RecyclerView f647i;
    private SwipeRefreshLayout f648j;
    private ActionImageView f649k;
    private LinearLayoutManager f650l;
    private ArrayList<C1370i> f651m = new ArrayList();
    private ArrayList<C1370i> f652n = new ArrayList();
    private ArrayList<C1370i> f653o = new ArrayList();
    private ArrayList<C1370i> f654p = new ArrayList();
    private ArrayList<C1370i> f655q = new ArrayList();
    private ArrayList<C1370i> f656r = new ArrayList();
    private ArrayList<C1371j> f657s = new ArrayList();
    private C0654a f658t;
    private long f659u;
    private String f660v;
    private boolean f661w = false;
    private int f662x = 0;
    private boolean f663y = false;
    private boolean f664z = false;

    class C06431 implements OnRefreshListener {
        final /* synthetic */ ad f610a;

        C06431(ad adVar) {
            this.f610a = adVar;
        }

        public void onRefresh() {
            Collections.sort(this.f610a.f651m, C1370i.m3450c());
            Collections.sort(this.f610a.f652n, C1370i.m3450c());
            this.f610a.call(3);
        }
    }

    class C06442 implements OnClickListener {
        final /* synthetic */ ad f611a;

        C06442(ad adVar) {
            this.f611a = adVar;
        }

        public void onClick(View view) {
            this.f611a.mActivity.finish();
        }
    }

    class C06453 implements OnClickListener {
        final /* synthetic */ ad f612a;

        C06453(ad adVar) {
            this.f612a = adVar;
        }

        public void onClick(View view) {
            this.f612a.m818m();
        }
    }

    class C06464 implements Runnable {
        final /* synthetic */ ad f613a;

        C06464(ad adVar) {
            this.f613a = adVar;
        }

        public void run() {
            C1148d.m2511a(this.f613a.mActivity, this.f613a.f645g);
        }
    }

    class C06475 extends Thread {
        final /* synthetic */ ad f614a;

        C06475(ad adVar) {
            this.f614a = adVar;
        }

        public void run() {
            synchronized (this.f614a.f642a) {
                if (this.f614a.f657s.isEmpty()) {
                    this.f614a.m832i();
                }
                this.f614a.f655q = (ArrayList) this.f614a.m823r();
                this.f614a.f656r = (ArrayList) C1026o.m2045a(this.f614a.mActivity);
                Iterator it = this.f614a.f656r.iterator();
                while (it.hasNext()) {
                    C1370i c1370i = (C1370i) it.next();
                    if (this.f614a.f661w) {
                        c1370i.f2955e = C0721a.m998b(this.f614a.mActivity, c1370i.f2953c);
                    } else {
                        c1370i.f2955e = this.f614a.f657s.contains(new C1371j(c1370i.f2953c));
                    }
                }
                this.f614a.f654p = (ArrayList) this.f614a.m822q();
                this.f614a.call(6);
            }
        }
    }

    class C06486 implements Runnable {
        final /* synthetic */ ad f615a;

        C06486(ad adVar) {
            this.f615a = adVar;
        }

        public void run() {
            this.f615a.m831h();
        }
    }

    class C06517 implements OnCheckedChangeListener {
        final /* synthetic */ ad f621a;

        C06517(ad adVar) {
            this.f621a = adVar;
        }

        public void onCheckedChanged(final CompoundButton compoundButton, boolean z) {
            if (((AppLockSwitch) compoundButton).m3528a()) {
                final C1370i c1370i = (C1370i) compoundButton.getTag();
                if (z && "com.domobile.notification".equals(c1370i.f2953c) && MainTabFragmentActivity.m631b(this.f621a.b)) {
                    try {
                        int intValue = ((Integer) compoundButton.getTag(R.id.tag_object)).intValue();
                        this.f621a.f658t.notifyItemChanged(intValue);
                        this.f621a.f640A = this.f621a.f658t.m788a(intValue);
                    } catch (Exception e) {
                    }
                } else if (!z && LockService.f1931a && "com.android.settings".equals(c1370i.f2953c)) {
                    C1150y.m2570a(this.f621a.b, new OnClickListener(this) {
                        final /* synthetic */ C06517 f617b;

                        public void onClick(View view) {
                            compoundButton.setChecked(true);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ C06517 f620c;

                        public void onClick(View view) {
                            this.f620c.f621a.m802a(compoundButton, c1370i);
                        }
                    });
                } else {
                    this.f621a.m802a(compoundButton, c1370i);
                }
            }
        }
    }

    private class C0654a extends C0653c {
        final /* synthetic */ ad f639a;

        public C0654a(ad adVar, C0386c c0386c) {
            this.f639a = adVar;
            super(c0386c, null, adVar.f641B);
        }

        protected int mo2385a() {
            return 0;
        }
    }

    private void m801a(RecyclerView recyclerView) {
        try {
            recyclerView.stopScroll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m802a(CompoundButton compoundButton, C1370i c1370i) {
        String str;
        m824s();
        String str2 = c1370i.f2952b;
        c1370i.f2955e = !c1370i.f2955e;
        if (c1370i.f2954d != null) {
            str = str2;
            for (int i = 0; i < this.f654p.size(); i++) {
                C1370i c1370i2 = (C1370i) this.f654p.get(i);
                if (c1370i2.f2953c.equals(c1370i.f2953c) && c1370i2.f2955e != c1370i.f2955e) {
                    c1370i2.f2955e = c1370i.f2955e;
                    str = C1147a.m2480a(str, ", ", c1370i2.f2952b);
                }
            }
        } else {
            str = str2;
        }
        C1147a.m2487w(this.mActivity, this.f658t.m789a(c1370i.f2955e, str));
        try {
            this.f658t.m794b(((Integer) compoundButton.getTag(R.id.tag_object)).intValue());
        } catch (Exception e) {
        }
        call(5);
    }

    private void m816k() {
        C1288c c1288c = new C1288c(this.mActivity);
        c1288c.m3102a((int) R.string.no, new C06442(this));
        c1288c.m3114b((int) R.string.save, new C06453(this));
        c1288c.m3123d((int) R.string.ask_save_when_back).m3117b(true).m3122d();
    }

    private boolean m817l() {
        Iterator it = this.f655q.iterator();
        while (it.hasNext()) {
            if (((C1370i) it.next()).f2955e) {
                return true;
            }
        }
        it = this.f654p.iterator();
        while (it.hasNext()) {
            if (((C1370i) it.next()).f2955e) {
                return true;
            }
        }
        it = this.f656r.iterator();
        while (it.hasNext()) {
            if (((C1370i) it.next()).f2955e) {
                return true;
            }
        }
        C1147a.m2485d(this.mActivity, R.string.select_one_limit);
        return false;
    }

    private void m818m() {
        if (!m817l()) {
            return;
        }
        if (TextUtils.isEmpty(this.f645g.getText())) {
            this.f645g.startAnimation(AnimationUtils.loadAnimation(this.mActivity, R.anim.shake));
            this.f645g.requestFocus();
            this.f645g.postDelayed(new C06464(this), 200);
            return;
        }
        m819n();
        if (this.f659u == -1) {
            C1147a.m2485d(this.mActivity, R.string.operation_failed);
            return;
        }
        showLoadingDialog();
        C1017n.m2031a(this.f659u);
        HashMap hashMap = new HashMap();
        Iterator it = this.f655q.iterator();
        while (it.hasNext()) {
            C1370i c1370i = (C1370i) it.next();
            if (c1370i.f2955e) {
                hashMap.put(c1370i.f2953c, Integer.valueOf(c1370i.m3455b()));
            }
        }
        it = this.f654p.iterator();
        while (it.hasNext()) {
            c1370i = (C1370i) it.next();
            if (c1370i.f2955e) {
                hashMap.put(c1370i.f2953c, Integer.valueOf(c1370i.m3455b()));
            }
        }
        it = this.f656r.iterator();
        while (it.hasNext()) {
            c1370i = (C1370i) it.next();
            if (c1370i.f2955e) {
                hashMap.put(c1370i.f2953c, Integer.valueOf(2));
            }
        }
        if (C1150y.O >= 19 && hashMap.containsKey("com.android.providers.downloads.ui")) {
            hashMap.put("com.android.documentsui", Integer.valueOf(1));
        }
        C1017n.m2033a(this.f659u, hashMap);
        hideLoadingDialog();
        this.f662x = -1;
        this.mActivity.finish();
    }

    private void m819n() {
        if (!TextUtils.equals(this.f660v, this.f645g.getText())) {
            this.f660v = this.f645g.getText().toString();
            if (this.f659u < 0) {
                this.f659u = Scene.insertScenes(this.f660v);
            } else {
                Scene.updateScenes(this.f659u, this.f660v);
            }
            this.f662x = -1;
        }
    }

    private void m820o() {
        this.f658t.m791a(this.f651m, this.f653o, this.f652n, !this.f654p.isEmpty());
        this.f658t.notifyDataSetChanged();
        this.f648j.setRefreshing(false);
    }

    private void m821p() {
        C0433g.m245a(this.mActivity, this.mActivity.getString(!this.f663y ? R.string.all_protect : R.string.all_unprotect), this.mActivity.getString(R.string.confirm_all_protect, new Object[]{this.mActivity.getString(!this.f663y ? R.string.all_protect : R.string.all_unprotect)}), new C06486(this));
    }

    private List<C1370i> m822q() {
        List<C1370i> arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        List queryIntentActivities = this.f644f.queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
            return arrayList;
        }
        HashMap b = C1150y.m2566a(this.mActivity).m587b(this.mActivity);
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
            String str = resolveInfo.activityInfo.packageName;
            String str2 = resolveInfo.activityInfo.name;
            if (!(b.containsKey(str) || str.contains("com.domobile.applock") || C1150y.m2628g(str))) {
                C1370i c1370i = new C1370i(false);
                c1370i.f2952b = C1150y.m2576a(this.mActivity, this.f644f, resolveInfo);
                c1370i.f2954d = new ComponentName(str, str2);
                c1370i.f2953c = str;
                c1370i.f2955e = this.f657s.contains(new C1371j(c1370i.f2953c));
                if ((resolveInfo.activityInfo.applicationInfo.flags & 1) != 0) {
                    c1370i.f2951a = R.string.system_app;
                } else {
                    c1370i.f2951a = R.string.third_party_app;
                }
                arrayList.add(c1370i);
            }
        }
        Collections.sort(arrayList, C1370i.m3450c());
        return arrayList;
    }

    private List<C1370i> m823r() {
        List<C1370i> arrayList = new ArrayList();
        C1370i c1370i = new C1370i(true);
        try {
            c1370i.m3454a(this.f644f.getApplicationIcon("com.android.phone"));
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        c1370i.f2952b = this.mActivity.getString(R.string.in_call);
        c1370i.f2953c = "com.android.phone";
        c1370i.f2954d = new ComponentName(c1370i.f2953c, c1370i.f2953c);
        c1370i.f2955e = this.f661w ? C1150y.m2614c(this.mActivity, "incall_locked") : this.f657s.contains(new C1371j(c1370i.f2953c));
        c1370i.f2951a = R.string.in_call_desc;
        arrayList.add(c1370i);
        try {
            c1370i = new C1370i(true);
            ApplicationInfo applicationInfo = this.f644f.getApplicationInfo("com.android.settings", 0);
            c1370i.f2953c = "com.android.settings";
            c1370i.f2952b = C1150y.m2575a(this.mActivity, this.f644f, applicationInfo);
            c1370i.f2954d = new ComponentName(c1370i.f2953c, c1370i.f2953c);
            c1370i.m3454a(this.f644f.getApplicationIcon(applicationInfo));
            c1370i.f2951a = R.string.app_details_info;
            boolean z = this.f657s.contains(new C1371j(c1370i.f2953c)) || this.f657s.contains(new C1371j("com.domobile.elock.appdetail"));
            c1370i.f2955e = z;
            if (this.f659u == -1 && LockService.f1931a) {
                c1370i.f2955e = true;
            }
            arrayList.add(c1370i);
        } catch (NameNotFoundException e2) {
            e2.printStackTrace();
        }
        C1026o.m2046a(this.mActivity, this.f644f, arrayList, this.f657s);
        Collections.sort(arrayList, C1370i.m3450c());
        return arrayList;
    }

    private void m824s() {
        this.f664z = true;
        if (C1150y.m2596b(this.mActivity, "actived_profile", -100) == this.f659u) {
            C1148d.m2534y(this.mActivity, "actived_profile");
        }
    }

    public int m825b() {
        return this.f662x;
    }

    public void m826c() {
        new C06475(this).start();
    }

    public void m827d() {
        this.f651m.clear();
        this.f652n.clear();
        this.f653o.clear();
        this.f651m.addAll(this.f655q);
        this.f652n.addAll(this.f654p);
        this.f653o.addAll(this.f656r);
        m820o();
        m828e();
    }

    public void m828e() {
        int size = this.f651m.size() - 1;
        int i = 0;
        while (size > -1) {
            int i2 = ((C1370i) this.f651m.get(size)).f2955e ? i + 1 : i;
            size--;
            i = i2;
        }
        size = this.f652n.size() - 1;
        while (size > -1) {
            i2 = ((C1370i) this.f652n.get(size)).f2955e ? i + 1 : i;
            size--;
            i = i2;
        }
        size = this.f656r.size() - 1;
        while (size > -1) {
            i2 = ((C1370i) this.f656r.get(size)).f2955e ? i + 1 : i;
            size--;
            i = i2;
        }
        if (i == (this.f651m.size() + this.f652n.size()) + this.f653o.size()) {
            this.f649k.setContentDescription(this.mActivity.getString(R.string.all_unprotect));
            this.f649k.setImageResource(R.drawable.scenes_editor_unselect_all);
            this.f663y = true;
            return;
        }
        this.f649k.setContentDescription(this.mActivity.getString(R.string.all_protect));
        this.f649k.setImageResource(R.drawable.scenes_editor_select_all);
        this.f663y = false;
    }

    public void mo2386f() {
        findViewById(R.id.bottom_layout).setVisibility(8);
        this.b.m66r().setBackgroundColor(ResourcesCompat.getColor(this.mActivity.getResources(), R.color.scenes_editor_search_actionbar_background, null));
    }

    public void mo2387g() {
        m833j();
        this.b.m66r().setBackgroundColor(ResourcesCompat.getColor(this.mActivity.getResources(), R.color.actionbar_toolbar_background, null));
    }

    public void m831h() {
        m824s();
        int size = this.f651m.size();
        int size2 = size + this.f652n.size();
        int i = 0;
        while (i < size2) {
            C1370i c1370i = i < size ? (C1370i) this.f651m.get(i) : (C1370i) this.f652n.get(i - size);
            if (this.f663y) {
                if (c1370i.f2955e) {
                    c1370i.f2955e = false;
                }
            } else if (!c1370i.f2955e) {
                c1370i.f2955e = true;
            }
            i++;
        }
        Iterator it = this.f656r.iterator();
        while (it.hasNext()) {
            c1370i = (C1370i) it.next();
            if (this.f663y) {
                c1370i.f2955e = false;
            } else {
                c1370i.f2955e = true;
            }
        }
        call(3);
        call(5);
    }

    public void m832i() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0019 in list [B:16:0x002d]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = r4.f657s;
        r0.clear();
        r0 = r4.f661w;
        if (r0 != 0) goto L_0x001a;
    L_0x0009:
        r0 = r4.f659u;
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x001a;
    L_0x0011:
        r0 = r4.f659u;
        r2 = -2;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 == 0) goto L_0x001a;
    L_0x0019:
        return;
    L_0x001a:
        r1 = 0;
        r0 = r4.f661w;	 Catch:{ all -> 0x0073 }
        if (r0 == 0) goto L_0x0031;	 Catch:{ all -> 0x0073 }
    L_0x001f:
        r1 = com.domobile.applock.C1017n.m2032a();	 Catch:{ all -> 0x0073 }
    L_0x0023:
        if (r1 == 0) goto L_0x002b;	 Catch:{ all -> 0x0073 }
    L_0x0025:
        r0 = r1.getCount();	 Catch:{ all -> 0x0073 }
        if (r0 != 0) goto L_0x0038;
    L_0x002b:
        if (r1 == 0) goto L_0x0019;
    L_0x002d:
        r1.close();
        goto L_0x0019;
    L_0x0031:
        r2 = r4.f659u;	 Catch:{ all -> 0x0073 }
        r1 = com.domobile.applock.C1017n.m2038b(r2);	 Catch:{ all -> 0x0073 }
        goto L_0x0023;	 Catch:{ all -> 0x0073 }
    L_0x0038:
        r0 = r1.moveToNext();	 Catch:{ all -> 0x0073 }
        if (r0 == 0) goto L_0x007a;	 Catch:{ all -> 0x0073 }
    L_0x003e:
        r0 = new com.domobile.lockbean.j;	 Catch:{ all -> 0x0073 }
        r0.<init>();	 Catch:{ all -> 0x0073 }
        r2 = 0;	 Catch:{ all -> 0x0073 }
        r2 = r1.getString(r2);	 Catch:{ all -> 0x0073 }
        if (r2 == 0) goto L_0x0051;	 Catch:{ all -> 0x0073 }
    L_0x004a:
        r2 = 0;	 Catch:{ all -> 0x0073 }
        r2 = r1.getInt(r2);	 Catch:{ all -> 0x0073 }
        r0.f2960a = r2;	 Catch:{ all -> 0x0073 }
    L_0x0051:
        r2 = 1;	 Catch:{ all -> 0x0073 }
        r2 = r1.getString(r2);	 Catch:{ all -> 0x0073 }
        if (r2 == 0) goto L_0x005f;	 Catch:{ all -> 0x0073 }
    L_0x0058:
        r2 = 1;	 Catch:{ all -> 0x0073 }
        r2 = r1.getString(r2);	 Catch:{ all -> 0x0073 }
        r0.f2962c = r2;	 Catch:{ all -> 0x0073 }
    L_0x005f:
        r2 = 2;	 Catch:{ all -> 0x0073 }
        r2 = r1.getString(r2);	 Catch:{ all -> 0x0073 }
        if (r2 == 0) goto L_0x006d;	 Catch:{ all -> 0x0073 }
    L_0x0066:
        r2 = 2;	 Catch:{ all -> 0x0073 }
        r2 = r1.getInt(r2);	 Catch:{ all -> 0x0073 }
        r0.f2961b = r2;	 Catch:{ all -> 0x0073 }
    L_0x006d:
        r2 = r4.f657s;	 Catch:{ all -> 0x0073 }
        r2.add(r0);	 Catch:{ all -> 0x0073 }
        goto L_0x0038;
    L_0x0073:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0079;
    L_0x0076:
        r1.close();
    L_0x0079:
        throw r0;
    L_0x007a:
        if (r1 == 0) goto L_0x0019;
    L_0x007c:
        r1.close();
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.domobile.applock.ad.i():void");
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1257b.m2966a(this.mActivity).m2980a(1);
        if (this.f659u == -2) {
            this.f645g.setEnabled(false);
            C1148d.m2514a((View) this.f645g.getParent(), null);
        }
        if (TextUtils.isEmpty(this.f660v)) {
            this.f645g.setHint(!this.f661w ? R.string.add_scenes : R.string.save_as_new_profile);
        } else {
            this.f645g.setText(this.f660v);
        }
        this.rootView = layoutInflater.inflate(R.layout.fragment_scenes_editor, null);
        this.f649k = (ActionImageView) findViewById(R.id.selecct_all);
        findViewById(R.id.save).setOnClickListener(this);
        this.f649k.setOnClickListener(this);
        this.f648j = (SwipeRefreshLayout) findViewById(R.id.locker_swipe_refresh);
        this.f648j.setOnRefreshListener(new C06431(this));
        m110a(this.f648j);
        this.f658t = new C0654a(this, this.b);
        this.f647i = (RecyclerView) findViewById(R.id.main_list);
        this.f650l = new NpaLinearLayoutManager(this.mActivity);
        this.f647i.setLayoutManager(this.f650l);
        this.f647i.setAdapter(this.f658t);
        this.f647i.setItemViewCacheSize(0);
        m826c();
    }

    public boolean m833j() {
        findViewById(R.id.bottom_layout).setVisibility(0);
        Collections.sort(this.f655q, C1370i.m3450c());
        Collections.sort(this.f654p, C1370i.m3450c());
        Collections.sort(this.f656r, C1370i.m3450c());
        this.f651m.clear();
        this.f652n.clear();
        this.f653o.clear();
        this.f651m.addAll(this.f655q);
        this.f653o.addAll(this.f656r);
        this.f652n.addAll(this.f654p);
        call(3);
        call(5);
        return true;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.save) {
            m818m();
        } else if (this.f649k == view) {
            m821p();
        } else if (!this.mActionBar.m3003a(view)) {
            super.onClick(view);
        } else if (this.f664z) {
            m816k();
        } else {
            this.mActivity.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m54a("");
        this.f643e = LayoutInflater.from(this.mActivity);
        this.f644f = this.mActivity.getPackageManager();
        Intent intent = this.mActivity.getIntent();
        this.f659u = intent.getLongExtra("com.domobile.elock.EXTRA_SCENE_ID", -1);
        this.f660v = intent.getStringExtra("com.domobile.elock.EXTRA_SCENE_NAME");
        this.f661w = intent.getBooleanExtra("com.domobile.applock.EXTRA_COPY_FROM_LOCKING", false);
        this.f664z = this.f661w;
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.actionbar_editor, null);
        this.f645g = (EditText) inflate.findViewById(R.id.actionbar_editor_edit);
        this.f646h = inflate.findViewById(R.id.actionbar_editor_clear);
        this.b.m66r().addView(inflate, -1, -1);
        C1150y.m2605b(this.mActivity, (int) R.string.event_scenes_editor);
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.scene_editor_actionbar_menus, menu);
        super.onCreateCustomOptionsMenus(menu, menuInflater);
        if (getActionBarHelper() != null && getActionBarHelper().getSearchItem() != null) {
            getActionBarHelper().setActionBarController(this);
            SearchView searchView = getActionBarHelper().getSearchView();
            searchView.setQueryHint(this.mActivity.getString(R.string.domo_search));
            searchView.setOnQueryTextListener(this);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (getActionBarHelper().isInSearchMode()) {
                getActionBarHelper().clearSearch();
                return true;
            } else if (this.f664z) {
                m816k();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (getActionBarHelper().isInSearchMode()) {
                getActionBarHelper().clearSearch();
                return true;
            } else if (this.f664z) {
                m816k();
                return true;
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onQueryTextChange(String str) {
        m801a(this.f647i);
        this.f651m.clear();
        this.f653o.clear();
        this.f652n.clear();
        if (TextUtils.isEmpty(str)) {
            this.f651m.addAll(this.f655q);
            this.f653o.addAll(this.f656r);
            this.f652n.addAll(this.f654p);
        } else {
            C1370i c1370i;
            CharSequence toUpperCase = str.toUpperCase();
            Iterator it = this.f655q.iterator();
            while (it.hasNext()) {
                c1370i = (C1370i) it.next();
                if (c1370i.f2952b.toUpperCase().contains(toUpperCase)) {
                    this.f651m.add(c1370i);
                }
            }
            it = this.f656r.iterator();
            while (it.hasNext()) {
                c1370i = (C1370i) it.next();
                if (c1370i.f2952b.toUpperCase().contains(toUpperCase)) {
                    this.f653o.add(c1370i);
                }
            }
            it = this.f654p.iterator();
            while (it.hasNext()) {
                c1370i = (C1370i) it.next();
                if (c1370i.f2952b.toUpperCase().contains(toUpperCase)) {
                    this.f652n.add(c1370i);
                }
            }
        }
        call(3);
        call(5);
        return true;
    }

    public boolean onQueryTextSubmit(String str) {
        return false;
    }

    public void onResume() {
        super.onResume();
        if (this.f640A != null && "com.domobile.notification".equals(this.f640A.f2953c)) {
            if (C0898c.m1570b(this.mActivity)) {
                this.f640A.f2955e = true;
                this.f658t.notifyDataSetChanged();
            }
            this.f640A = null;
        }
    }

    public void ui(int i, Message message) {
        switch (i) {
            case 3:
                m820o();
                return;
            case 5:
                m828e();
                return;
            case 6:
                m827d();
                return;
            case 7:
                m818m();
                return;
            default:
                return;
        }
    }
}
