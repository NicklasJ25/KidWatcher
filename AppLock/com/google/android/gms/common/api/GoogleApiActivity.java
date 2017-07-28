package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.C2481b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.C3424x;

public class GoogleApiActivity extends Activity implements OnCancelListener {
    protected int f7260a = 0;

    public static PendingIntent m7718a(Context context, PendingIntent pendingIntent, int i) {
        return m7719a(context, pendingIntent, i, true);
    }

    public static PendingIntent m7719a(Context context, PendingIntent pendingIntent, int i, boolean z) {
        return PendingIntent.getActivity(context, 0, m7722b(context, pendingIntent, i, z), 134217728);
    }

    private void m7720a() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
        } else if (pendingIntent != null) {
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                this.f7260a = 1;
            } catch (Throwable e) {
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                finish();
            }
        } else {
            C2481b.m7820a().m7839b(this, num.intValue(), 2, this);
            this.f7260a = 1;
        }
    }

    private void m7721a(int i, C3424x c3424x) {
        switch (i) {
            case -1:
                c3424x.m14667c();
                return;
            case 0:
                c3424x.m14665b(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                return;
            default:
                return;
        }
    }

    public static Intent m7722b(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    protected void m7723a(int i) {
        setResult(i);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f7260a = 0;
            m7723a(i2);
            if (booleanExtra) {
                m7721a(i2, C3424x.m14637a((Context) this));
            }
        } else if (i == 2) {
            this.f7260a = 0;
            m7723a(i2);
        }
        finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f7260a = 0;
        setResult(0);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f7260a = bundle.getInt("resolution");
        }
        if (this.f7260a != 1) {
            m7720a();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f7260a);
        super.onSaveInstanceState(bundle);
    }
}
