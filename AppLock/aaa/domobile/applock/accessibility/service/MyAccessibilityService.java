package aaa.domobile.applock.accessibility.service;

import android.accessibilityservice.AccessibilityService;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import com.domobile.applock.C1150y;
import com.domobile.applock.service.LockService;
import com.domobile.frame.p000a.C1148d;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyAccessibilityService extends AccessibilityService {
    private final String f0a = "statusbar";
    private final String f1b = "FrameLayout";
    private final String f2c = "android.app.Dialog";
    private final String f3d = "android.inputmethodservice";
    private final String f4e = "permission.ui";
    private final String f5f = "android";

    private static class C0001a implements Comparator<RunningServiceInfo> {
        private C0001a() {
        }

        public int m0a(RunningServiceInfo runningServiceInfo, RunningServiceInfo runningServiceInfo2) {
            return runningServiceInfo.service.getClassName().compareTo(runningServiceInfo2.service.getClassName());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m0a((RunningServiceInfo) obj, (RunningServiceInfo) obj2);
        }
    }

    public static boolean m1a(Context context, String str) {
        if (str == null) {
            return false;
        }
        List<RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        Collections.sort(runningServices, new C0001a());
        for (RunningServiceInfo runningServiceInfo : runningServices) {
            if (str.equals(runningServiceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    private boolean m2a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence2 == null ? false : (!"com.android.systemui".equals(charSequence) || (TextUtils.indexOf(charSequence2, "statusbar") < 0 && TextUtils.indexOf(charSequence2, "FrameLayout") < 0)) ? (!"com.google.android.packageinstaller".equals(charSequence) || TextUtils.indexOf(charSequence2, "permission.ui") < 0) ? TextUtils.indexOf(charSequence2, "android.inputmethodservice") >= 0 || TextUtils.indexOf(charSequence2, "android.app.Dialog") >= 0 : true : true;
    }

    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        switch (accessibilityEvent.getEventType()) {
            case 32:
                CharSequence packageName = accessibilityEvent.getPackageName();
                if (packageName != null && !"android".equals(packageName)) {
                    CharSequence className = accessibilityEvent.getClassName();
                    if (!m2a(packageName, className)) {
                        try {
                            if (LockService.m2176b() != null) {
                                LockService.m2176b().m2224a(className != null ? className.toString() : null, packageName);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (C1150y.m2566a((Context) this).f434i) {
            C1148d.m2520b((Context) this, "enable_power_save_mode", (Object) Boolean.valueOf(false));
        }
        C1148d.m2489A(this, "com.domobile.applock.ACTION_POWER_SAVE_MODE_CHANGED");
        if (LockService.m2176b() != null) {
            LockService.m2176b().m2225a(false);
        }
    }

    public void onInterrupt() {
    }

    protected void onServiceConnected() {
        super.onServiceConnected();
        C1148d.m2510a((Context) this, new Intent("com.domobile.applock.ACTION_POWER_SAVE_MODE_CHANGED").putExtra("com.domobile.elock.EXTRA_VALUE", true));
        if (LockService.m2176b() == null) {
            startService(new Intent(this, LockService.class));
        } else {
            LockService.m2176b().m2225a(true);
        }
    }
}
