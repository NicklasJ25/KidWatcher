package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2580e;
import com.google.android.gms.common.util.C2581f;
import com.google.android.gms.measurement.AppMeasurement.C2803f;
import com.google.android.gms.measurement.AppMeasurement.C2861c;
import com.google.android.gms.measurement.AppMeasurement.C3518b;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.android.gms.p004b.C2428e;
import com.google.android.gms.p004b.C2434h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public class dp extends dn {
    protected C2800a f8600a;
    private C3518b f8601b;
    private final Set<C2861c> f8602c = new CopyOnWriteArraySet();
    private boolean f8603d;
    private String f8604e = null;
    private String f8605f = null;

    class C27933 implements Callable<String> {
        final /* synthetic */ dp f8579a;

        C27933(dp dpVar) {
            this.f8579a = dpVar;
        }

        public String m10103a() {
            String C = this.f8579a.mo3549v().m9871C();
            if (C == null) {
                C = this.f8579a.mo3535h().m10148c(120000);
                if (C == null) {
                    throw new TimeoutException();
                }
                this.f8579a.mo3549v().m9882d(C);
            }
            return C;
        }

        public /* synthetic */ Object call() {
            return m10103a();
        }
    }

    @MainThread
    @TargetApi(14)
    private class C2800a implements ActivityLifecycleCallbacks {
        final /* synthetic */ dp f8599a;

        private C2800a(dp dpVar) {
            this.f8599a = dpVar;
        }

        private boolean m10104a(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.f8599a.m10139a("auto", "_ldl", (Object) str);
            return true;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            try {
                this.f8599a.mo3548u().m9786D().m9774a("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data != null && data.isHierarchical()) {
                        if (bundle == null) {
                            Bundle a = this.f8599a.mo3544q().m10386a(data);
                            String str = this.f8599a.mo3544q().m10401a(intent) ? "gs" : "auto";
                            if (a != null) {
                                this.f8599a.m10136a(str, "_cmp", a);
                            }
                        }
                        String queryParameter = data.getQueryParameter("referrer");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            Object obj = (queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content"))) ? 1 : null;
                            if (obj == null) {
                                this.f8599a.mo3548u().m9785C().m9774a("Activity created with data 'referrer' param without gclid and at least one utm field");
                                return;
                            } else {
                                this.f8599a.mo3548u().m9785C().m9775a("Activity created with referrer", queryParameter);
                                m10104a(queryParameter);
                            }
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                this.f8599a.mo3548u().m9815x().m9775a("Throwable caught in onActivityCreated", th);
            }
            this.f8599a.mo3539l().m10181a(activity, bundle);
        }

        public void onActivityDestroyed(Activity activity) {
            this.f8599a.mo3539l().m10192d(activity);
        }

        @MainThread
        public void onActivityPaused(Activity activity) {
            this.f8599a.mo3539l().m10190c(activity);
            this.f8599a.mo3546s().m10321y();
        }

        @MainThread
        public void onActivityResumed(Activity activity) {
            this.f8599a.mo3539l().m10186b(activity);
            this.f8599a.mo3546s().m10320x();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            this.f8599a.mo3539l().m10187b(activity, bundle);
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    protected dp(dk dkVar) {
        super(dkVar);
    }

    @WorkerThread
    private void m10105A() {
        try {
            m10133a(Class.forName(m10106B()));
        } catch (ClassNotFoundException e) {
            mo3548u().m9784B().m9774a("Tag Manager is not found and thus will not be used");
        }
    }

    private String m10106B() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    private Bundle m10107a(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else if (obj instanceof Parcelable[]) {
                Parcelable[] parcelableArr = (Parcelable[]) obj;
                for (r2 = 0; r2 < parcelableArr.length; r2++) {
                    if (parcelableArr[r2] instanceof Bundle) {
                        parcelableArr[r2] = new Bundle((Bundle) parcelableArr[r2]);
                    }
                }
            } else if (obj instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) obj;
                for (r2 = 0; r2 < arrayList.size(); r2++) {
                    Object obj2 = arrayList.get(r2);
                    if (obj2 instanceof Bundle) {
                        arrayList.set(r2, new Bundle((Bundle) obj2));
                    }
                }
            }
        }
        return bundle2;
    }

    private void m10112a(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        m10134a(str, str2, mo3540m().mo3360a(), bundle, z, z2, z3, str3);
    }

    @WorkerThread
    private void m10113a(String str, String str2, Object obj, long j) {
        C2513c.m7934a(str);
        C2513c.m7934a(str2);
        mo3532e();
        mo3530c();
        m9448R();
        if (!this.n.m9989G()) {
            mo3548u().m9785C().m9774a("User property not set since app measurement is disabled");
        } else if (this.n.m10026b()) {
            mo3548u().m9785C().m9776a("Setting user property (FE)", str2, obj);
            mo3538k().m10244a(new zzauq(str2, j, obj, str));
        }
    }

    private List<ConditionalUserProperty> m10114b(String str, String str2, String str3) {
        final AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            this.n.m10036h().m9938a(new Runnable(this) {
                final /* synthetic */ dp f8590e;

                public void run() {
                    this.f8590e.n.m10050v().m10247a(atomicReference, str4, str5, str6);
                }
            });
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                mo3548u().m9817z().m9776a("Interrupted waiting for get conditional user properties", str, e);
            }
        }
        List<zzatg> list = (List) atomicReference.get();
        if (list == null) {
            mo3548u().m9817z().m9775a("Timed out waiting for get conditional user properties", str);
            return Collections.emptyList();
        }
        List<ConditionalUserProperty> arrayList = new ArrayList(list.size());
        for (zzatg com_google_android_gms_internal_zzatg : list) {
            ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
            conditionalUserProperty.mAppId = str;
            conditionalUserProperty.mOrigin = str2;
            conditionalUserProperty.mCreationTimestamp = com_google_android_gms_internal_zzatg.f11815e;
            conditionalUserProperty.mName = com_google_android_gms_internal_zzatg.f11814d.f11831b;
            conditionalUserProperty.mValue = com_google_android_gms_internal_zzatg.f11814d.m15354a();
            conditionalUserProperty.mActive = com_google_android_gms_internal_zzatg.f11816f;
            conditionalUserProperty.mTriggerEventName = com_google_android_gms_internal_zzatg.f11817g;
            if (com_google_android_gms_internal_zzatg.f11818h != null) {
                conditionalUserProperty.mTimedOutEventName = com_google_android_gms_internal_zzatg.f11818h.f11826a;
                if (com_google_android_gms_internal_zzatg.f11818h.f11827b != null) {
                    conditionalUserProperty.mTimedOutEventParams = com_google_android_gms_internal_zzatg.f11818h.f11827b.m15353b();
                }
            }
            conditionalUserProperty.mTriggerTimeout = com_google_android_gms_internal_zzatg.f11819i;
            if (com_google_android_gms_internal_zzatg.f11820j != null) {
                conditionalUserProperty.mTriggeredEventName = com_google_android_gms_internal_zzatg.f11820j.f11826a;
                if (com_google_android_gms_internal_zzatg.f11820j.f11827b != null) {
                    conditionalUserProperty.mTriggeredEventParams = com_google_android_gms_internal_zzatg.f11820j.f11827b.m15353b();
                }
            }
            conditionalUserProperty.mTriggeredTimestamp = com_google_android_gms_internal_zzatg.f11814d.f11832c;
            conditionalUserProperty.mTimeToLive = com_google_android_gms_internal_zzatg.f11821k;
            if (com_google_android_gms_internal_zzatg.f11822l != null) {
                conditionalUserProperty.mExpiredEventName = com_google_android_gms_internal_zzatg.f11822l.f11826a;
                if (com_google_android_gms_internal_zzatg.f11822l.f11827b != null) {
                    conditionalUserProperty.mExpiredEventParams = com_google_android_gms_internal_zzatg.f11822l.f11827b.m15353b();
                }
            }
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    private Map<String, Object> m10115b(String str, String str2, String str3, boolean z) {
        final AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final boolean z2 = z;
            this.n.m10036h().m9938a(new Runnable(this) {
                final /* synthetic */ dp f8596f;

                public void run() {
                    this.f8596f.n.m10050v().m10248a(atomicReference, str4, str5, str6, z2);
                }
            });
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                mo3548u().m9817z().m9775a("Interrupted waiting for get user properties", e);
            }
        }
        List<zzauq> list = (List) atomicReference.get();
        if (list == null) {
            mo3548u().m9817z().m9774a("Timed out waiting for get user properties");
            return Collections.emptyMap();
        }
        Map<String, Object> arrayMap = new ArrayMap(list.size());
        for (zzauq com_google_android_gms_internal_zzauq : list) {
            arrayMap.put(com_google_android_gms_internal_zzauq.f11831b, com_google_android_gms_internal_zzauq.m15354a());
        }
        return arrayMap;
    }

    @WorkerThread
    private void m10117b(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        C2513c.m7934a(str);
        C2513c.m7934a(str2);
        C2513c.m7932a((Object) bundle);
        mo3532e();
        m9448R();
        if (this.n.m9989G()) {
            if (!this.f8603d) {
                this.f8603d = true;
                m10105A();
            }
            boolean equals = "am".equals(str);
            boolean l = dy.m10382l(str2);
            if (z && this.f8601b != null && !l && !equals) {
                mo3548u().m9785C().m9776a("Passing event to registered event handler (FE)", str2, bundle);
                this.f8601b.m15404a(str, str2, bundle, j);
                return;
            } else if (this.n.m10026b()) {
                int c = mo3544q().m10419c(str2);
                if (c != 0) {
                    this.n.m10043o().m10394a(c, "_ev", mo3544q().m10392a(str2, mo3550w().m9531y(), true), str2 != null ? str2.length() : 0);
                    return;
                }
                int i;
                Bundle a;
                List a2 = C2581f.m8276a((Object) "_o");
                Bundle a3 = mo3544q().m10388a(str2, bundle, a2, z3, true);
                List arrayList = new ArrayList();
                arrayList.add(a3);
                long nextLong = mo3549v().m9883x().nextLong();
                int i2 = 0;
                String[] strArr = (String[]) a3.keySet().toArray(new String[bundle.size()]);
                Arrays.sort(strArr);
                int length = strArr.length;
                int i3 = 0;
                while (i3 < length) {
                    int i4;
                    String str4 = strArr[i3];
                    Bundle[] a4 = mo3544q().m10412a(a3.get(str4));
                    if (a4 == null) {
                        i4 = i2;
                    } else {
                        a3.putInt(str4, a4.length);
                        for (i = 0; i < a4.length; i++) {
                            a = mo3544q().m10388a("_ep", a4[i], a2, z3, false);
                            a.putString("_en", str2);
                            a.putLong("_eid", nextLong);
                            a.putString("_gn", str4);
                            a.putInt("_ll", a4.length);
                            a.putInt("_i", i);
                            arrayList.add(a);
                        }
                        i4 = a4.length + i2;
                    }
                    i3++;
                    i2 = i4;
                }
                if (i2 != 0) {
                    a3.putLong("_eid", nextLong);
                    a3.putInt("_epc", i2);
                }
                mo3550w().m9490W();
                C2803f x = mo3539l().m10212x();
                if (!(x == null || a3.containsKey("_sc"))) {
                    x.f8614a = true;
                }
                i = 0;
                while (i < arrayList.size()) {
                    a = (Bundle) arrayList.get(i);
                    String str5 = (i != 0 ? 1 : null) != null ? "_ep" : str2;
                    a.putString("_o", str);
                    if (!a.containsKey("_sc")) {
                        dq.m10178a(x, a);
                    }
                    Bundle a5 = z2 ? mo3544q().m10387a(a) : a;
                    mo3548u().m9785C().m9776a("Logging event (FE)", str2, a5);
                    mo3538k().m10243a(new zzatq(str5, new zzato(a5), str, j), str3);
                    if (!equals) {
                        for (C2861c a6 : this.f8602c) {
                            a6.mo3588a(str, str2, new Bundle(a5), j);
                        }
                    }
                    i++;
                }
                return;
            } else {
                return;
            }
        }
        mo3548u().m9785C().m9774a("Event not sent since app measurement is disabled");
    }

    private void m10118b(String str, String str2, String str3, Bundle bundle) {
        long a = mo3540m().mo3360a();
        C2513c.m7934a(str2);
        final ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = a;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        mo3547t().m9938a(new Runnable(this) {
            final /* synthetic */ dp f8585b;

            public void run() {
                this.f8585b.m10122e(conditionalUserProperty);
            }
        });
    }

    private void m10119c(final ConditionalUserProperty conditionalUserProperty) {
        long a = mo3540m().mo3360a();
        C2513c.m7932a((Object) conditionalUserProperty);
        C2513c.m7934a(conditionalUserProperty.mName);
        C2513c.m7934a(conditionalUserProperty.mOrigin);
        C2513c.m7932a(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = a;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (mo3544q().m10426e(str) != 0) {
            mo3548u().m9815x().m9775a("Invalid conditional user property name", str);
        } else if (mo3544q().m10414b(str, obj) != 0) {
            mo3548u().m9815x().m9776a("Invalid conditional user property value", str, obj);
        } else {
            Object c = mo3544q().m10420c(str, obj);
            if (c == null) {
                mo3548u().m9815x().m9776a("Unable to normalize conditional user property value", str, obj);
                return;
            }
            conditionalUserProperty.mValue = c;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (j > mo3550w().m9481N() || j < 1) {
                mo3548u().m9815x().m9776a("Invalid conditional user property timeout", str, Long.valueOf(j));
                return;
            }
            j = conditionalUserProperty.mTimeToLive;
            if (j > mo3550w().m9482O() || j < 1) {
                mo3548u().m9815x().m9776a("Invalid conditional user property time to live", str, Long.valueOf(j));
            } else {
                mo3547t().m9938a(new Runnable(this) {
                    final /* synthetic */ dp f8583b;

                    public void run() {
                        this.f8583b.m10121d(conditionalUserProperty);
                    }
                });
            }
        }
    }

    @WorkerThread
    private void m10120c(boolean z) {
        mo3532e();
        mo3530c();
        m9448R();
        mo3548u().m9785C().m9775a("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        mo3549v().m9879b(z);
        mo3538k().m10273y();
    }

    @WorkerThread
    private void m10121d(ConditionalUserProperty conditionalUserProperty) {
        mo3532e();
        m9448R();
        C2513c.m7932a((Object) conditionalUserProperty);
        C2513c.m7934a(conditionalUserProperty.mName);
        C2513c.m7934a(conditionalUserProperty.mOrigin);
        C2513c.m7932a(conditionalUserProperty.mValue);
        if (this.n.m9989G()) {
            zzauq com_google_android_gms_internal_zzauq = new zzauq(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
            try {
                zzatq a = mo3544q().m10390a(conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0, true, false);
                mo3538k().m10242a(new zzatg(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, com_google_android_gms_internal_zzauq, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, mo3544q().m10390a(conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0, true, false), conditionalUserProperty.mTriggerTimeout, a, conditionalUserProperty.mTimeToLive, mo3544q().m10390a(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0, true, false)));
                return;
            } catch (IllegalArgumentException e) {
                return;
            }
        }
        mo3548u().m9785C().m9774a("Conditional property not sent since Firebase Analytics is disabled");
    }

    @WorkerThread
    private void m10122e(ConditionalUserProperty conditionalUserProperty) {
        mo3532e();
        m9448R();
        C2513c.m7932a((Object) conditionalUserProperty);
        C2513c.m7934a(conditionalUserProperty.mName);
        if (this.n.m9989G()) {
            zzauq com_google_android_gms_internal_zzauq = new zzauq(conditionalUserProperty.mName, 0, null, null);
            try {
                mo3538k().m10242a(new zzatg(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, com_google_android_gms_internal_zzauq, conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, null, conditionalUserProperty.mTriggerTimeout, null, conditionalUserProperty.mTimeToLive, mo3544q().m10390a(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false)));
                return;
            } catch (IllegalArgumentException e) {
                return;
            }
        }
        mo3548u().m9785C().m9774a("Conditional property not cleared since Firebase Analytics is disabled");
    }

    @Nullable
    @WorkerThread
    public synchronized String m10123a(String str) {
        String c;
        m9448R();
        mo3530c();
        if (str == null || !str.equals(this.f8605f)) {
            c = m10148c(30000);
            if (c == null) {
                c = null;
            } else {
                this.f8605f = str;
                this.f8604e = c;
                c = this.f8604e;
            }
        } else {
            c = this.f8604e;
        }
        return c;
    }

    public List<ConditionalUserProperty> m10124a(String str, String str2) {
        mo3530c();
        return m10114b(null, str, str2);
    }

    public List<ConditionalUserProperty> m10125a(String str, String str2, String str3) {
        C2513c.m7934a(str);
        mo3529b();
        return m10114b(str, str2, str3);
    }

    public Map<String, Object> m10126a(String str, String str2, String str3, boolean z) {
        C2513c.m7934a(str);
        mo3529b();
        return m10115b(str, str2, str3, z);
    }

    public Map<String, Object> m10127a(String str, String str2, boolean z) {
        mo3530c();
        return m10115b(null, str, str2, z);
    }

    protected void mo3551a() {
    }

    public void m10129a(final long j) {
        mo3530c();
        mo3547t().m9938a(new Runnable(this) {
            final /* synthetic */ dp f8598b;

            public void run() {
                this.f8598b.mo3549v().f8411h.m9859a(j);
                this.f8598b.mo3548u().m9785C().m9775a("Minimum session duration set", Long.valueOf(j));
            }
        });
    }

    public void m10130a(ConditionalUserProperty conditionalUserProperty) {
        C2513c.m7932a((Object) conditionalUserProperty);
        mo3530c();
        ConditionalUserProperty conditionalUserProperty2 = new ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            mo3548u().m9817z().m9774a("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        m10119c(conditionalUserProperty2);
    }

    @WorkerThread
    public void m10131a(C3518b c3518b) {
        mo3532e();
        mo3530c();
        m9448R();
        if (!(c3518b == null || c3518b == this.f8601b)) {
            C2513c.m7938a(this.f8601b == null, (Object) "EventInterceptor already set.");
        }
        this.f8601b = c3518b;
    }

    public void m10132a(C2861c c2861c) {
        mo3530c();
        m9448R();
        C2513c.m7932a((Object) c2861c);
        if (!this.f8602c.add(c2861c)) {
            mo3548u().m9817z().m9774a("OnEventListener already registered");
        }
    }

    @WorkerThread
    public void m10133a(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{mo3541n()});
        } catch (Exception e) {
            mo3548u().m9817z().m9775a("Failed to invoke Tag Manager's initialize() method", e);
        }
    }

    protected void m10134a(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        final Bundle a = m10107a(bundle);
        final String str4 = str;
        final String str5 = str2;
        final long j2 = j;
        final boolean z4 = z;
        final boolean z5 = z2;
        final boolean z6 = z3;
        final String str6 = str3;
        mo3547t().m9938a(new Runnable(this) {
            final /* synthetic */ dp f8568i;

            public void run() {
                this.f8568i.m10117b(str4, str5, j2, a, z4, z5, z6, str6);
            }
        });
    }

    void m10135a(String str, String str2, long j, Object obj) {
        final String str3 = str;
        final String str4 = str2;
        final Object obj2 = obj;
        final long j2 = j;
        mo3547t().m9938a(new Runnable(this) {
            final /* synthetic */ dp f8573e;

            public void run() {
                this.f8573e.m10113a(str3, str4, obj2, j2);
            }
        });
    }

    public void m10136a(String str, String str2, Bundle bundle) {
        mo3530c();
        boolean z = this.f8601b == null || dy.m10382l(str2);
        m10112a(str, str2, bundle, true, z, false, null);
    }

    public void m10137a(String str, String str2, Bundle bundle, long j) {
        mo3530c();
        m10134a(str, str2, j, bundle, false, true, true, null);
    }

    public void m10138a(String str, String str2, Bundle bundle, boolean z) {
        mo3530c();
        boolean z2 = this.f8601b == null || dy.m10382l(str2);
        m10112a(str, str2, bundle, true, z2, z, null);
    }

    public void m10139a(String str, String str2, Object obj) {
        int i = 0;
        C2513c.m7934a(str);
        long a = mo3540m().mo3360a();
        int e = mo3544q().m10426e(str2);
        String a2;
        if (e != 0) {
            a2 = mo3544q().m10392a(str2, mo3550w().m9532z(), true);
            if (str2 != null) {
                i = str2.length();
            }
            this.n.m10043o().m10394a(e, "_ev", a2, i);
        } else if (obj != null) {
            e = mo3544q().m10414b(str2, obj);
            if (e != 0) {
                a2 = mo3544q().m10392a(str2, mo3550w().m9532z(), true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.n.m10043o().m10394a(e, "_ev", a2, i);
                return;
            }
            Object c = mo3544q().m10420c(str2, obj);
            if (c != null) {
                m10135a(str, str2, a, c);
            }
        } else {
            m10135a(str, str2, a, null);
        }
    }

    public void m10140a(String str, String str2, String str3, Bundle bundle) {
        C2513c.m7934a(str);
        mo3529b();
        m10118b(str, str2, str3, bundle);
    }

    public void m10141a(final boolean z) {
        m9448R();
        mo3530c();
        mo3547t().m9938a(new Runnable(this) {
            final /* synthetic */ dp f8575b;

            public void run() {
                this.f8575b.m10120c(z);
            }
        });
    }

    public int m10142b(String str) {
        C2513c.m7934a(str);
        return mo3550w().m9479L();
    }

    public List<zzauq> m10143b(final boolean z) {
        mo3530c();
        m9448R();
        mo3548u().m9785C().m9774a("Fetching user attributes (FE)");
        final AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.n.m10036h().m9938a(new Runnable(this) {
                final /* synthetic */ dp f8578c;

                public void run() {
                    this.f8578c.mo3538k().m10249a(atomicReference, z);
                }
            });
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                mo3548u().m9817z().m9775a("Interrupted waiting for get user properties", e);
            }
        }
        List<zzauq> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        mo3548u().m9817z().m9774a("Timed out waiting for get user properties");
        return Collections.emptyList();
    }

    public /* bridge */ /* synthetic */ void mo3529b() {
        super.mo3529b();
    }

    public void m10145b(final long j) {
        mo3530c();
        mo3547t().m9938a(new Runnable(this) {
            final /* synthetic */ dp f8559b;

            public void run() {
                this.f8559b.mo3549v().f8412i.m9859a(j);
                this.f8559b.mo3548u().m9785C().m9775a("Session timeout duration set", Long.valueOf(j));
            }
        });
    }

    public void m10146b(ConditionalUserProperty conditionalUserProperty) {
        C2513c.m7932a((Object) conditionalUserProperty);
        C2513c.m7934a(conditionalUserProperty.mAppId);
        mo3529b();
        m10119c(new ConditionalUserProperty(conditionalUserProperty));
    }

    public void m10147b(String str, String str2, Bundle bundle) {
        mo3530c();
        m10118b(null, str, str2, bundle);
    }

    @Nullable
    String m10148c(long j) {
        if (mo3547t().m9964y()) {
            mo3548u().m9815x().m9774a("Cannot retrieve app instance id from analytics worker thread");
            return null;
        } else if (mo3547t().m9963x()) {
            mo3548u().m9815x().m9774a("Cannot retrieve app instance id from main thread");
            return null;
        } else {
            long b = mo3540m().mo3361b();
            String d = m10150d(j);
            b = mo3540m().mo3361b() - b;
            return (d != null || b >= j) ? d : m10150d(j - b);
        }
    }

    public /* bridge */ /* synthetic */ void mo3530c() {
        super.mo3530c();
    }

    @Nullable
    String m10150d(long j) {
        final AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            mo3547t().m9938a(new Runnable(this) {
                final /* synthetic */ dp f8581b;

                public void run() {
                    this.f8581b.mo3538k().m10246a(atomicReference);
                }
            });
            try {
                atomicReference.wait(j);
            } catch (InterruptedException e) {
                mo3548u().m9817z().m9774a("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    public /* bridge */ /* synthetic */ void mo3531d() {
        super.mo3531d();
    }

    public /* bridge */ /* synthetic */ void mo3532e() {
        super.mo3532e();
    }

    public /* bridge */ /* synthetic */ ck mo3533f() {
        return super.mo3533f();
    }

    public /* bridge */ /* synthetic */ cn mo3534g() {
        return super.mo3534g();
    }

    public /* bridge */ /* synthetic */ dp mo3535h() {
        return super.mo3535h();
    }

    public /* bridge */ /* synthetic */ cz mo3536i() {
        return super.mo3536i();
    }

    public /* bridge */ /* synthetic */ cs mo3537j() {
        return super.mo3537j();
    }

    public /* bridge */ /* synthetic */ dr mo3538k() {
        return super.mo3538k();
    }

    public /* bridge */ /* synthetic */ dq mo3539l() {
        return super.mo3539l();
    }

    public /* bridge */ /* synthetic */ C2580e mo3540m() {
        return super.mo3540m();
    }

    public /* bridge */ /* synthetic */ Context mo3541n() {
        return super.mo3541n();
    }

    public /* bridge */ /* synthetic */ da mo3542o() {
        return super.mo3542o();
    }

    public /* bridge */ /* synthetic */ cq mo3543p() {
        return super.mo3543p();
    }

    public /* bridge */ /* synthetic */ dy mo3544q() {
        return super.mo3544q();
    }

    public /* bridge */ /* synthetic */ di mo3545r() {
        return super.mo3545r();
    }

    public /* bridge */ /* synthetic */ dt mo3546s() {
        return super.mo3546s();
    }

    public /* bridge */ /* synthetic */ dj mo3547t() {
        return super.mo3547t();
    }

    public /* bridge */ /* synthetic */ dc mo3548u() {
        return super.mo3548u();
    }

    public /* bridge */ /* synthetic */ dg mo3549v() {
        return super.mo3549v();
    }

    public /* bridge */ /* synthetic */ cp mo3550w() {
        return super.mo3550w();
    }

    @TargetApi(14)
    public void m10171x() {
        if (mo3541n().getApplicationContext() instanceof Application) {
            Application application = (Application) mo3541n().getApplicationContext();
            if (this.f8600a == null) {
                this.f8600a = new C2800a();
            }
            application.unregisterActivityLifecycleCallbacks(this.f8600a);
            application.registerActivityLifecycleCallbacks(this.f8600a);
            mo3548u().m9786D().m9774a("Registered activity lifecycle callback");
        }
    }

    public C2428e<String> m10172y() {
        try {
            Object C = mo3549v().m9871C();
            return C != null ? C2434h.m7684a(C) : C2434h.m7685a(mo3547t().m9965z(), new C27933(this));
        } catch (Exception e) {
            mo3548u().m9817z().m9774a("Failed to schedule task for getAppInstanceId");
            return C2434h.m7683a(e);
        }
    }

    @WorkerThread
    public void m10173z() {
        mo3532e();
        mo3530c();
        m9448R();
        if (this.n.m10026b()) {
            mo3538k().m10274z();
            String F = mo3549v().m9874F();
            if (!TextUtils.isEmpty(F) && !F.equals(mo3537j().m9647y())) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", F);
                m10136a("auto", "_ou", bundle);
            }
        }
    }
}
