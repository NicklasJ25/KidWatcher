package com.domobile.applock;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.domobile.applock.adapter.C0688g;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1257b;
import com.domobile.lockbean.Scene;
import com.domobile.widget.recyclerview.NpaLinearLayoutManager;
import java.util.ArrayList;

public class ac extends C0400d {
    private PackageManager f605a;
    private Resources f606e;
    private RecyclerView f607f;
    private C0688g f608g;
    private Runnable f609h = new C06422(this);

    class C06401 implements OnItemClickListener {
        final /* synthetic */ ac f601a;

        C06401(ac acVar) {
            this.f601a = acVar;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f601a.mActivity.setResult(-1, this.f601a.f608g.m894a(i).m3394b(this.f601a.mActivity, false));
            this.f601a.mActivity.finish();
        }
    }

    class C06422 implements Runnable {
        final /* synthetic */ ac f604a;

        C06422(ac acVar) {
            this.f604a = acVar;
        }

        public void run() {
            final ArrayList a = Scene.m3389a(this.f604a.mActivity, false);
            this.f604a.mHandler.post(new Runnable(this) {
                final /* synthetic */ C06422 f603b;

                public void run() {
                    this.f603b.f604a.f608g.m899a(a);
                }
            });
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.scenes_activity, null);
        this.f607f = (RecyclerView) findViewById(R.id.scenes_list);
        this.f607f.setLayoutManager(new NpaLinearLayoutManager(this.mActivity));
        findViewById(R.id.scenes_add).setVisibility(8);
        this.f608g = new C0688g(this.mActivity, null, true);
        this.f607f.setAdapter(this.f608g);
        this.f608g.m897a(new C06401(this));
    }

    public void onClick(View view) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1148d.m2520b(this.mActivity, "latest_leave_app_timemills", (Object) Long.valueOf(System.currentTimeMillis()));
        this.b.m56b(R.string.scenes_mode);
        this.f606e = getResources();
        this.f605a = this.mActivity.getPackageManager();
        C1257b.m2966a(this.mActivity).m2980a(1);
        C1150y.m2605b(this.mActivity, (int) R.string.event_scenes_shortcut);
    }

    public void onResume() {
        super.onResume();
        new Thread(this.f609h).start();
    }

    public void ui(int i, Message message) {
    }
}
