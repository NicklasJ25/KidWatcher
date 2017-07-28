package com.domobile.applock;

import android.os.Bundle;
import com.domobile.frame.p000a.C1148d;

public class ScenesEditorActivity extends C0386c {
    private ad f538d;

    public void mo2041d() {
    }

    public void finish() {
        C1148d.m2489A(this, "com.domobile.elock.action.ACTION_NEW_SCENE_ADDED");
        this.c = true;
        setResult(this.f538d.m825b());
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f538d = new ad();
        m52a(this.f538d);
    }
}
