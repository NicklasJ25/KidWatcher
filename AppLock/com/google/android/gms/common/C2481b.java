package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.C2315a.C2306a;
import com.google.android.gms.C2315a.C2307b;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.C2540n;
import com.google.android.gms.common.internal.C2541o;
import com.google.android.gms.common.util.C2583h;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.internal.C3459z;
import com.google.android.gms.internal.C3459z.C2884a;
import com.google.android.gms.internal.af;

public class C2481b extends C2480k {
    public static final int f7316a = C2480k.f7315b;
    private static final C2481b f7317c = new C2481b();

    @SuppressLint({"HandlerLeak"})
    private class C2479a extends Handler {
        final /* synthetic */ C2481b f7312a;
        private final Context f7313b;

        public C2479a(C2481b c2481b, Context context) {
            this.f7312a = c2481b;
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f7313b = context.getApplicationContext();
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    int a = this.f7312a.mo3314a(this.f7313b);
                    if (this.f7312a.mo3317a(a)) {
                        this.f7312a.m7830a(this.f7313b, a);
                        return;
                    }
                    return;
                default:
                    Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + message.what);
                    return;
            }
        }
    }

    C2481b() {
    }

    public static C2481b m7820a() {
        return f7317c;
    }

    public int mo3314a(Context context) {
        return super.mo3314a(context);
    }

    public Dialog m7822a(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        return m7824a((Context) activity, i, C2541o.m8064a(activity, mo3320b(activity, i, "d"), i2), onCancelListener);
    }

    public Dialog m7823a(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(C2540n.m8061c(activity, 18));
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        m7829a(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    Dialog m7824a(Context context, int i, C2541o c2541o, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new Builder(context, 5);
        }
        if (builder == null) {
            builder = new Builder(context);
        }
        builder.setMessage(C2540n.m8061c(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        CharSequence e = C2540n.m8063e(context, i);
        if (e != null) {
            builder.setPositiveButton(e, c2541o);
        }
        e = C2540n.m8057a(context, i);
        if (e != null) {
            builder.setTitle(e);
        }
        return builder.create();
    }

    @Nullable
    public PendingIntent mo3315a(Context context, int i, int i2) {
        return super.mo3315a(context, i, i2);
    }

    @Nullable
    public PendingIntent mo3316a(Context context, int i, int i2, @Nullable String str) {
        return super.mo3316a(context, i, i2, str);
    }

    @Nullable
    public PendingIntent m7827a(Context context, ConnectionResult connectionResult) {
        return connectionResult.m7712a() ? connectionResult.m7715d() : mo3315a(context, connectionResult.m7714c(), 0);
    }

    @Nullable
    public C3459z m7828a(Context context, C2884a c2884a) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        BroadcastReceiver c3459z = new C3459z(c2884a);
        context.registerReceiver(c3459z, intentFilter);
        c3459z.m14978a(context);
        if (m7813a(context, "com.google.android.gms")) {
            return c3459z;
        }
        c2884a.mo3648a();
        c3459z.m14977a();
        return null;
    }

    void m7829a(Activity activity, Dialog dialog, String str, OnCancelListener onCancelListener) {
        boolean z;
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
            z = false;
        }
        if (z) {
            C2491f.m7876a(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
            return;
        }
        C2444a.m7717a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    public void m7830a(Context context, int i) {
        m7831a(context, i, null);
    }

    public void m7831a(Context context, int i, String str) {
        m7832a(context, i, str, mo3316a(context, i, 0, "n"));
    }

    @TargetApi(20)
    void m7832a(Context context, int i, String str, PendingIntent pendingIntent) {
        if (i == 18) {
            m7842c(context);
        } else if (pendingIntent != null) {
            Notification build;
            int i2;
            CharSequence b = C2540n.m8060b(context, i);
            CharSequence d = C2540n.m8062d(context, i);
            Resources resources = context.getResources();
            if (C2583h.m8294b(context)) {
                C2513c.m7937a(C2590o.m8313h());
                build = new Notification.Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(b).setStyle(new BigTextStyle().bigText(d)).addAction(C2306a.common_full_open_on_phone, resources.getString(C2307b.common_open_on_phone), pendingIntent).build();
            } else {
                build = new NotificationCompat.Builder(context).setSmallIcon(17301642).setTicker(resources.getString(C2307b.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(pendingIntent).setContentTitle(b).setContentText(d).setLocalOnly(true).setStyle(new NotificationCompat.BigTextStyle().bigText(d)).build();
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                    C2489m.f7347f.set(false);
                    i2 = 10436;
                    break;
                default:
                    i2 = 39789;
                    break;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (str == null) {
                notificationManager.notify(i2, build);
            } else {
                notificationManager.notify(str, i2, build);
            }
        } else if (i == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    public final boolean mo3317a(int i) {
        return super.mo3317a(i);
    }

    public boolean m7834a(Activity activity, @NonNull af afVar, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m7824a((Context) activity, i, C2541o.m8065a(afVar, mo3320b(activity, i, "d"), i2), onCancelListener);
        if (a == null) {
            return false;
        }
        m7829a(activity, a, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public boolean m7835a(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent a = m7827a(context, connectionResult);
        if (a == null) {
            return false;
        }
        m7832a(context, connectionResult.m7714c(), null, GoogleApiActivity.m7718a(context, a, i));
        return true;
    }

    public int mo3318b(Context context) {
        return super.mo3318b(context);
    }

    @Nullable
    @Deprecated
    public Intent mo3319b(int i) {
        return super.mo3319b(i);
    }

    @Nullable
    public Intent mo3320b(Context context, int i, @Nullable String str) {
        return super.mo3320b(context, i, str);
    }

    public boolean m7839b(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m7822a(activity, i, i2, onCancelListener);
        if (a == null) {
            return false;
        }
        m7829a(activity, a, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public boolean mo3321b(Context context, int i) {
        return super.mo3321b(context, i);
    }

    public final String mo3322c(int i) {
        return super.mo3322c(i);
    }

    void m7842c(Context context) {
        new C2479a(this, context).sendEmptyMessageDelayed(1, 120000);
    }
}
