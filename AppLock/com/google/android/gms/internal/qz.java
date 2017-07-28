package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public interface qz {

    public interface C3180a {
        void mo3923a(qz qzVar);

        String mo3933k();

        String mo3934l();

        qq mo3935m();

        View mo3937o();
    }

    public interface C3181b extends C3180a {
        List mo3924b();
    }

    View mo3959a(OnClickListener onClickListener, boolean z);

    void mo3960a(MotionEvent motionEvent);

    void mo3961a(View view);

    void mo3962a(View view, qw qwVar);

    void mo3963a(View view, String str, JSONObject jSONObject, Map<String, WeakReference<View>> map, View view2);

    void mo3964a(View view, Map<String, WeakReference<View>> map);

    void mo3965a(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, View view2);

    boolean mo3966a();

    void mo3967b(View view, Map<String, WeakReference<View>> map);

    void mo3968c(View view, Map<String, WeakReference<View>> map);

    View mo3969e();

    Context mo3970f();
}
