package com.domobile.applock.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.frame.p000a.C1148d;

public class StepWindowService extends Service implements ViewPropertyAnimatorListener, OnClickListener {
    private View f1990a;
    private WindowManager f1991b;
    private LayoutParams f1992c;
    private Handler f1993d = new C10651(this);
    private BroadcastReceiver f1994e = new C10662(this);

    class C10651 extends Handler {
        final /* synthetic */ StepWindowService f1988a;

        C10651(StepWindowService stepWindowService) {
            this.f1988a = stepWindowService;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 256:
                    ViewCompat.animate(this.f1988a.f1990a.findViewById(16908290)).alpha(0.0f).setDuration(300).setListener(this.f1988a).start();
                    return;
                case InputDeviceCompat.SOURCE_KEYBOARD /*257*/:
                    C1150y.m2594a(this.f1988a.f1991b, this.f1988a.f1990a, this.f1988a.f1992c);
                    View findViewById = this.f1988a.f1990a.findViewById(16908290);
                    ViewCompat.setAlpha(findViewById, 0.0f);
                    ViewCompat.animate(findViewById).alpha(1.0f).setDuration(300).setListener(null).start();
                    sendEmptyMessageDelayed(256, 5000);
                    return;
                default:
                    return;
            }
        }
    }

    class C10662 extends BroadcastReceiver {
        final /* synthetic */ StepWindowService f1989a;

        C10662(StepWindowService stepWindowService) {
            this.f1989a = stepWindowService;
        }

        public void onReceive(Context context, Intent intent) {
            if ("com.domobile.applock.ACTION_REMOVE_POWER_MODE_GUIDE_WINDOW".equals(intent.getAction()) && this.f1989a.f1990a != null && this.f1989a.f1990a.getParent() != null) {
                this.f1989a.f1993d.removeMessages(256);
                this.f1989a.f1993d.sendEmptyMessage(256);
            }
        }
    }

    private void m2248a(int i) {
        if (this.f1991b == null) {
            this.f1991b = (WindowManager) getSystemService("window");
            this.f1992c = new LayoutParams();
            this.f1992c.type = 2003;
            this.f1992c.format = 1;
            this.f1992c.flags = 168;
            this.f1992c.format = -3;
            this.f1992c.height = -1;
            this.f1992c.width = -1;
            this.f1992c.gravity = 17;
            if (i == -5) {
                this.f1990a = LayoutInflater.from(this).inflate(R.layout.permission_guide_window, null);
            } else {
                this.f1990a = LayoutInflater.from(this).inflate(R.layout.enable_accessability_guide_window, null);
            }
            ((TextView) this.f1990a.findViewById(16908310)).setText(R.string.app_name);
            this.f1990a.setOnClickListener(this);
        }
        if (i == -4) {
            this.f1990a.findViewById(16908294).setVisibility(0);
            ((TextView) this.f1990a.findViewById(16908304)).setText(R.string.off);
            ((TextView) this.f1990a.findViewById(16908299)).setText(R.string.enable_usage_stats_guide);
        } else if (i == -5) {
            ((TextView) this.f1990a.findViewById(16908299)).setText(R.string.enable_accessibility_service_guide);
        } else if (i == -6) {
            ((TextView) this.f1990a.findViewById(16908299)).setText(R.string.enable_accessibility_service_guide);
        } else {
            ((TextView) this.f1990a.findViewById(16908304)).setText(C1150y.m2554S(this) ? R.string.on : R.string.off);
        }
        this.f1993d.sendEmptyMessage(InputDeviceCompat.SOURCE_KEYBOARD);
    }

    public static void m2249a(Context context, int i) {
        Intent intent = new Intent(context, StepWindowService.class);
        intent.putExtra("com.domobile.applock.EXTRA_STEP", i);
        context.startService(intent);
    }

    public void onAnimationCancel(View view) {
    }

    public void onAnimationEnd(View view) {
        if (this.f1990a.getParent() != null) {
            this.f1991b.removeView(this.f1990a);
        }
        stopSelf();
    }

    public void onAnimationStart(View view) {
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onClick(View view) {
        if (view == this.f1990a) {
            this.f1993d.removeMessages(256);
            this.f1993d.sendEmptyMessage(256);
        }
    }

    public void onCreate() {
        super.onCreate();
        setTheme(R.style.Theme_Default);
        registerReceiver(this.f1994e, new IntentFilter("com.domobile.applock.ACTION_REMOVE_POWER_MODE_GUIDE_WINDOW"));
    }

    public void onDestroy() {
        super.onDestroy();
        C1148d.m2509a((Context) this, this.f1994e);
    }

    @Deprecated
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        try {
            int intExtra = intent.getIntExtra("com.domobile.applock.EXTRA_STEP", 1);
            if (intExtra == -3 || intExtra == -4 || intExtra == -5 || intExtra == -6) {
                m2248a(intExtra);
            } else {
                stopSelf(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            stopSelf(i);
        }
    }
}
