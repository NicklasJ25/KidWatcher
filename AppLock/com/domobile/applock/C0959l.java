package com.domobile.applock;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.domobile.applock.p003a.C0621h.C0619a;

public class C0959l extends C0400d {
    private LayoutInflater f1526a;
    private C0619a f1527e;

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1526a = layoutInflater;
        this.rootView = this.f1526a.inflate(R.layout.fragment_infos_card_detail, null);
        if (this.f1527e != null) {
            ((TextView) this.rootView.findViewById(R.id.fragment_infos_card_title)).setText(this.f1527e.m724b());
            ((TextView) this.rootView.findViewById(R.id.fragment_infos_card_message)).setText(this.f1527e.m725c());
            TextView textView = (TextView) this.rootView.findViewById(R.id.fragment_infos_card_button1);
            textView.setOnClickListener(this);
            if (TextUtils.isEmpty(this.f1527e.m721a(this.mActivity))) {
                textView.setVisibility(8);
            } else {
                textView.setText(this.f1527e.m721a(this.mActivity));
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() != R.id.fragment_infos_card_button1) {
            super.onClick(view);
        } else if (this.f1527e != null) {
            this.b.m80e();
            this.f1527e.m723a(this.b);
        }
    }

    public void onCreate(android.os.Bundle r5) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        super.onCreate(r5);
        r0 = r4.b;
        r1 = 2131296342; // 0x7f090056 float:1.8210598E38 double:1.0530003037E-314;
        r0.m56b(r1);
        r0 = r4.mActivity;
        r1 = 2131296813; // 0x7f09022d float:1.8211553E38 double:1.0530005364E-314;
        com.domobile.applock.C1150y.m2605b(r0, r1);
        r0 = r4.mActivity;
        r0 = r0.getIntent();
        r1 = "com.domobile.applock.EXTRA_DATA_JSON";
        r0 = r0.getStringExtra(r1);
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x004b, all -> 0x006c }
        r1.<init>(r0);	 Catch:{ Exception -> 0x004b, all -> 0x006c }
        r0 = new com.domobile.applock.a.h$a;	 Catch:{ Exception -> 0x004b, all -> 0x006c }
        r0.<init>(r1);	 Catch:{ Exception -> 0x004b, all -> 0x006c }
        r4.f1527e = r0;	 Catch:{ Exception -> 0x004b, all -> 0x006c }
        r0 = r4.f1527e;
        if (r0 != 0) goto L_0x0035;
    L_0x002f:
        r0 = r4.b;
        r0.mo2042a();
    L_0x0034:
        return;
    L_0x0035:
        r0 = com.domobile.applock.MainTabFragmentActivity.m633l();
        if (r0 == 0) goto L_0x0034;
    L_0x003b:
        r0 = com.domobile.applock.MainTabFragmentActivity.m633l();
        r0 = r0.m644n();
        r1 = r4.mActivity;
        r2 = r4.f1527e;
        r0.m735a(r1, r2);
        goto L_0x0034;
    L_0x004b:
        r0 = move-exception;
        r0 = r4.f1527e;
        if (r0 != 0) goto L_0x0056;
    L_0x0050:
        r0 = r4.b;
        r0.mo2042a();
        goto L_0x0034;
    L_0x0056:
        r0 = com.domobile.applock.MainTabFragmentActivity.m633l();
        if (r0 == 0) goto L_0x0034;
    L_0x005c:
        r0 = com.domobile.applock.MainTabFragmentActivity.m633l();
        r0 = r0.m644n();
        r1 = r4.mActivity;
        r2 = r4.f1527e;
        r0.m735a(r1, r2);
        goto L_0x0034;
    L_0x006c:
        r0 = move-exception;
        r1 = r4.f1527e;
        if (r1 != 0) goto L_0x0077;
    L_0x0071:
        r0 = r4.b;
        r0.mo2042a();
        goto L_0x0034;
    L_0x0077:
        r1 = com.domobile.applock.MainTabFragmentActivity.m633l();
        if (r1 == 0) goto L_0x008c;
    L_0x007d:
        r1 = com.domobile.applock.MainTabFragmentActivity.m633l();
        r1 = r1.m644n();
        r2 = r4.mActivity;
        r3 = r4.f1527e;
        r1.m735a(r2, r3);
    L_0x008c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.domobile.applock.l.onCreate(android.os.Bundle):void");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.b.m80e();
        ActivityCompat.finishAfterTransition(this.mActivity);
        return true;
    }
}
