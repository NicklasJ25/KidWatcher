package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

class nb implements ActivityLifecycleCallbacks {
    private final Application f9958a;
    private final WeakReference<ActivityLifecycleCallbacks> f9959b;
    private boolean f9960c = false;

    public interface C3085a {
        void mo3847a(ActivityLifecycleCallbacks activityLifecycleCallbacks);
    }

    public nb(Application application, ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f9959b = new WeakReference(activityLifecycleCallbacks);
        this.f9958a = application;
    }

    protected void m12749a(C3085a c3085a) {
        try {
            ActivityLifecycleCallbacks activityLifecycleCallbacks = (ActivityLifecycleCallbacks) this.f9959b.get();
            if (activityLifecycleCallbacks != null) {
                c3085a.mo3847a(activityLifecycleCallbacks);
            } else if (!this.f9960c) {
                this.f9958a.unregisterActivityLifecycleCallbacks(this);
                this.f9960c = true;
            }
        } catch (Throwable e) {
            aad.m8422b("Error while dispatching lifecycle callback.", e);
        }
    }

    public void onActivityCreated(final Activity activity, final Bundle bundle) {
        m12749a(new C3085a(this) {
            public void mo3847a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
                activityLifecycleCallbacks.onActivityCreated(activity, bundle);
            }
        });
    }

    public void onActivityDestroyed(final Activity activity) {
        m12749a(new C3085a(this) {
            public void mo3847a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
                activityLifecycleCallbacks.onActivityDestroyed(activity);
            }
        });
    }

    public void onActivityPaused(final Activity activity) {
        m12749a(new C3085a(this) {
            public void mo3847a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
                activityLifecycleCallbacks.onActivityPaused(activity);
            }
        });
    }

    public void onActivityResumed(final Activity activity) {
        m12749a(new C3085a(this) {
            public void mo3847a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
                activityLifecycleCallbacks.onActivityResumed(activity);
            }
        });
    }

    public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
        m12749a(new C3085a(this) {
            public void mo3847a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
                activityLifecycleCallbacks.onActivitySaveInstanceState(activity, bundle);
            }
        });
    }

    public void onActivityStarted(final Activity activity) {
        m12749a(new C3085a(this) {
            public void mo3847a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
                activityLifecycleCallbacks.onActivityStarted(activity);
            }
        });
    }

    public void onActivityStopped(final Activity activity) {
        m12749a(new C3085a(this) {
            public void mo3847a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
                activityLifecycleCallbacks.onActivityStopped(activity);
            }
        });
    }
}
