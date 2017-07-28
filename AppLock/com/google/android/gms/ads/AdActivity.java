package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.va;
import com.google.android.gms.p065a.C2312b;

public class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private va f6668a;

    private void m7331a() {
        if (this.f6668a != null) {
            try {
                this.f6668a.zzbo();
            } catch (Throwable e) {
                aad.m8424c("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.f6668a.onActivityResult(i, i2, intent);
        } catch (Throwable e) {
            aad.m8424c("Could not forward onActivityResult to ad overlay:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.f6668a != null) {
                z = this.f6668a.zzhF();
            }
        } catch (Throwable e) {
            aad.m8424c("Could not forward onBackPressed to ad overlay:", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.f6668a.zzo(C2312b.m7327a((Object) configuration));
        } catch (Throwable e) {
            aad.m8424c("Failed to wrap configuration.", e);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6668a = ol.m12981b().m12978b((Activity) this);
        if (this.f6668a == null) {
            aad.m8426e("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.f6668a.onCreate(bundle);
        } catch (Throwable e) {
            aad.m8424c("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.f6668a != null) {
                this.f6668a.onDestroy();
            }
        } catch (Throwable e) {
            aad.m8424c("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.f6668a != null) {
                this.f6668a.onPause();
            }
        } catch (Throwable e) {
            aad.m8424c("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.f6668a != null) {
                this.f6668a.onRestart();
            }
        } catch (Throwable e) {
            aad.m8424c("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.f6668a != null) {
                this.f6668a.onResume();
            }
        } catch (Throwable e) {
            aad.m8424c("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.f6668a != null) {
                this.f6668a.onSaveInstanceState(bundle);
            }
        } catch (Throwable e) {
            aad.m8424c("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.f6668a != null) {
                this.f6668a.onStart();
            }
        } catch (Throwable e) {
            aad.m8424c("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.f6668a != null) {
                this.f6668a.onStop();
            }
        } catch (Throwable e) {
            aad.m8424c("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        m7331a();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        m7331a();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        m7331a();
    }
}
