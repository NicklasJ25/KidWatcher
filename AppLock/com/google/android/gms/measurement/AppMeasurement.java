package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import com.android.gallery3d.common.Entry.Columns;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2581f;
import com.google.android.gms.internal.ab;
import com.google.android.gms.internal.dk;
import com.google.android.gms.internal.dy;
import com.google.android.gms.internal.zzauq;
import com.google.firebase.analytics.FirebaseAnalytics.C3516a;
import com.google.firebase.analytics.FirebaseAnalytics.C3520b;
import com.google.firebase.analytics.FirebaseAnalytics.C3522c;
import java.util.List;
import java.util.Map;

@Keep
@Deprecated
public class AppMeasurement {
    private final dk zzbqb;

    public static class C2803f {
        public String f8611b;
        public String f8612c;
        public long f8613d;

        public C2803f(C2803f c2803f) {
            this.f8611b = c2803f.f8611b;
            this.f8612c = c2803f.f8612c;
            this.f8613d = c2803f.f8613d;
        }
    }

    public interface C2861c {
        @WorkerThread
        void mo3588a(String str, String str2, Bundle bundle, long j);
    }

    public static class ConditionalUserProperty {
        @Keep
        public boolean mActive;
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @Keep
        public String mName;
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @Keep
        public Object mValue;

        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            C2513c.m7932a((Object) conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            if (conditionalUserProperty.mValue != null) {
                this.mValue = dy.m10377b(conditionalUserProperty.mValue);
                if (this.mValue == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mValue = conditionalUserProperty.mValue;
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            if (conditionalUserProperty.mTimedOutEventParams != null) {
                this.mTimedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            if (conditionalUserProperty.mTriggeredEventParams != null) {
                this.mTriggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            if (conditionalUserProperty.mExpiredEventParams != null) {
                this.mExpiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
            }
        }
    }

    public static final class C3517a extends C3516a {
        public static final Map<String, String> f12109a = C2581f.m8278a(new String[]{"app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "firebase_ad_exposure", "firebase_adunit_exposure", "firebase_extra_parameter"}, new String[]{"_cd", "_ae", "_ui", "_in", "_ug", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_ep"});
    }

    public interface C3518b {
        @WorkerThread
        void m15404a(String str, String str2, Bundle bundle, long j);
    }

    public interface C3519d {
        @MainThread
        boolean m15405a(C2803f c2803f, C2803f c2803f2);
    }

    public static final class C3521e extends C3520b {
        public static final Map<String, String> f12110a = C2581f.m8278a(new String[]{"firebase_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "firebase_error", "firebase_error_value", "firebase_error_length", "debug", "realtime", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic", "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "firebase_event_id", "firebase_extra_params_ct", "firebase_group_name", "firebase_list_length", "firebase_index", "firebase_event_name"}, new String[]{"_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_dbg", "_r", "_o", "_sn", "_sc", "_si", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en"});
    }

    public static final class C3523g extends C3522c {
        public static final Map<String, String> f12111a = C2581f.m8278a(new String[]{"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id"}, new String[]{"_ln", "_fot", "_fvt", "_ldl", Columns.ID});
    }

    public AppMeasurement(dk dkVar) {
        C2513c.m7932a((Object) dkVar);
        this.zzbqb = dkVar;
    }

    @Keep
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return dk.m9976a(context).m10041m();
    }

    private void zzc(String str, String str2, Object obj) {
        this.zzbqb.m10040l().m10139a(str, str2, obj);
    }

    @Keep
    public void beginAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.zzbqb.m9984B().m9370a(str);
    }

    @Keep
    protected void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        this.zzbqb.m10040l().m10147b(str, str2, bundle);
    }

    @Keep
    protected void clearConditionalUserPropertyAs(@Size(min = 1) @NonNull String str, @Size(max = 24, min = 1) @NonNull String str2, @Nullable String str3, @Nullable Bundle bundle) {
        this.zzbqb.m10040l().m10140a(str, str2, str3, bundle);
    }

    @Keep
    public void endAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.zzbqb.m9984B().m9372b(str);
    }

    @Keep
    public long generateEventId() {
        return this.zzbqb.m10043o().m10455x();
    }

    @Keep
    @Nullable
    @WorkerThread
    public String getAppInstanceId() {
        return this.zzbqb.m10040l().m10123a(null);
    }

    @Keep
    @WorkerThread
    protected List<ConditionalUserProperty> getConditionalUserProperties(@Nullable String str, @Nullable @Size(max = 23, min = 1) String str2) {
        return this.zzbqb.m10040l().m10124a(str, str2);
    }

    @Keep
    @WorkerThread
    protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(@Size(min = 1) @NonNull String str, @Nullable String str2, @Nullable @Size(max = 23, min = 1) String str3) {
        return this.zzbqb.m10040l().m10125a(str, str2, str3);
    }

    @Keep
    @Nullable
    public String getCurrentScreenClass() {
        C2803f y = this.zzbqb.m10049u().m10213y();
        return y != null ? y.f8612c : null;
    }

    @Keep
    @Nullable
    public String getCurrentScreenName() {
        C2803f y = this.zzbqb.m10049u().m10213y();
        return y != null ? y.f8611b : null;
    }

    @Keep
    @Nullable
    public String getGmpAppId() {
        try {
            return ab.m8741a();
        } catch (IllegalStateException e) {
            this.zzbqb.m10034f().m9815x().m9775a("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    @Keep
    @WorkerThread
    protected int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        return this.zzbqb.m10040l().m10142b(str);
    }

    @Keep
    @WorkerThread
    protected Map<String, Object> getUserProperties(@Nullable String str, @Nullable @Size(max = 24, min = 1) String str2, boolean z) {
        return this.zzbqb.m10040l().m10127a(str, str2, z);
    }

    @Keep
    @WorkerThread
    protected Map<String, Object> getUserPropertiesAs(@Size(min = 1) @NonNull String str, @Nullable String str2, @Nullable @Size(max = 23, min = 1) String str3, boolean z) {
        return this.zzbqb.m10040l().m10126a(str, str2, str3, z);
    }

    public void logEvent(@Size(max = 40, min = 1) @NonNull String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzbqb.m10030d().m9490W();
        if (!"_iap".equals(str)) {
            int b = this.zzbqb.m10043o().m10413b(str);
            if (b != 0) {
                this.zzbqb.m10043o().m10394a(b, "_ev", this.zzbqb.m10043o().m10392a(str, this.zzbqb.m10030d().m9531y(), true), str != null ? str.length() : 0);
                return;
            }
        }
        this.zzbqb.m10040l().m10138a("app", str, bundle, true);
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzbqb.m10040l().m10136a(str, str2, bundle);
    }

    @Keep
    public void registerOnScreenChangeCallback(@NonNull C3519d c3519d) {
        this.zzbqb.m10049u().m10183a(c3519d);
    }

    @Keep
    protected void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
        this.zzbqb.m10040l().m10130a(conditionalUserProperty);
    }

    @Keep
    protected void setConditionalUserPropertyAs(@NonNull ConditionalUserProperty conditionalUserProperty) {
        this.zzbqb.m10040l().m10146b(conditionalUserProperty);
    }

    @Deprecated
    public void setMeasurementEnabled(boolean z) {
        this.zzbqb.m10040l().m10141a(z);
    }

    public void setMinimumSessionDuration(long j) {
        this.zzbqb.m10040l().m10129a(j);
    }

    public void setSessionTimeoutDuration(long j) {
        this.zzbqb.m10040l().m10145b(j);
    }

    public void setUserId(String str) {
        zzb("app", Columns.ID, str);
    }

    public void setUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable @Size(max = 36) String str2) {
        int d = this.zzbqb.m10043o().m10423d(str);
        if (d != 0) {
            this.zzbqb.m10043o().m10394a(d, "_ev", this.zzbqb.m10043o().m10392a(str, this.zzbqb.m10030d().m9532z(), true), str != null ? str.length() : 0);
        } else {
            zzb("app", str, str2);
        }
    }

    @Keep
    public void unregisterOnScreenChangeCallback(@NonNull C3519d c3519d) {
        this.zzbqb.m10049u().m10188b(c3519d);
    }

    @WorkerThread
    public void zza(C3518b c3518b) {
        this.zzbqb.m10040l().m10131a(c3518b);
    }

    public void zza(C2861c c2861c) {
        this.zzbqb.m10040l().m10132a(c2861c);
    }

    public void zza(String str, String str2, Bundle bundle, long j) {
        this.zzbqb.m10040l().m10137a(str, str2, bundle == null ? new Bundle() : bundle, j);
    }

    @WorkerThread
    public Map<String, Object> zzaI(boolean z) {
        List<zzauq> b = this.zzbqb.m10040l().m10143b(z);
        Map<String, Object> arrayMap = new ArrayMap(b.size());
        for (zzauq com_google_android_gms_internal_zzauq : b) {
            arrayMap.put(com_google_android_gms_internal_zzauq.f11831b, com_google_android_gms_internal_zzauq.m15354a());
        }
        return arrayMap;
    }

    public void zzb(String str, String str2, Object obj) {
        zzc(str, str2, obj);
    }
}
