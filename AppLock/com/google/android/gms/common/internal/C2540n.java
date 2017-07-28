package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C2315a.C2307b;
import com.google.android.gms.common.C2490e;
import com.google.android.gms.common.util.C2583h;
import com.google.android.gms.internal.bm;

public final class C2540n {
    private static final SimpleArrayMap<String, String> f7453a = new SimpleArrayMap();

    public static String m8056a(Context context) {
        String str = context.getApplicationInfo().name;
        if (TextUtils.isEmpty(str)) {
            str = context.getPackageName();
            try {
                str = bm.m9120b(context).m9119b(context.getPackageName()).toString();
            } catch (NameNotFoundException e) {
            }
        }
        return str;
    }

    @Nullable
    public static String m8057a(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C2307b.common_google_play_services_install_title);
            case 2:
                return resources.getString(C2307b.common_google_play_services_update_title);
            case 3:
                return resources.getString(C2307b.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return C2540n.m8058a(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return C2540n.m8058a(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return C2540n.m8058a(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return C2540n.m8058a(context, "common_google_play_services_restricted_profile_title");
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }

    @Nullable
    private static String m8058a(Context context, String str) {
        synchronized (f7453a) {
            String str2 = (String) f7453a.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources a = C2490e.m7875a(context);
            if (a == null) {
                return null;
            }
            int identifier = a.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String str3 = "GoogleApiAvailability";
                String str4 = "Missing resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            Object string = a.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                str3 = "GoogleApiAvailability";
                str4 = "Got empty resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            f7453a.put(str, string);
            return string;
        }
    }

    private static String m8059a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String a = C2540n.m8058a(context, str);
        if (a == null) {
            a = resources.getString(C2307b.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, a, new Object[]{str2});
    }

    @NonNull
    public static String m8060b(Context context, int i) {
        String a = i == 6 ? C2540n.m8058a(context, "common_google_play_services_resolution_required_title") : C2540n.m8057a(context, i);
        return a == null ? context.getResources().getString(C2307b.common_google_play_services_notification_ticker) : a;
    }

    @NonNull
    public static String m8061c(Context context, int i) {
        Resources resources = context.getResources();
        String a = C2540n.m8056a(context);
        switch (i) {
            case 1:
                return resources.getString(C2307b.common_google_play_services_install_text, new Object[]{a});
            case 2:
                if (C2583h.m8294b(context)) {
                    return resources.getString(C2307b.common_google_play_services_wear_update_text);
                }
                return resources.getString(C2307b.common_google_play_services_update_text, new Object[]{a});
            case 3:
                return resources.getString(C2307b.common_google_play_services_enable_text, new Object[]{a});
            case 5:
                return C2540n.m8059a(context, "common_google_play_services_invalid_account_text", a);
            case 7:
                return C2540n.m8059a(context, "common_google_play_services_network_error_text", a);
            case 9:
                return resources.getString(C2307b.common_google_play_services_unsupported_text, new Object[]{a});
            case 16:
                return C2540n.m8059a(context, "common_google_play_services_api_unavailable_text", a);
            case 17:
                return C2540n.m8059a(context, "common_google_play_services_sign_in_failed_text", a);
            case 18:
                return resources.getString(C2307b.common_google_play_services_updating_text, new Object[]{a});
            case 20:
                return C2540n.m8059a(context, "common_google_play_services_restricted_profile_text", a);
            default:
                return resources.getString(C2307b.common_google_play_services_unknown_issue, new Object[]{a});
        }
    }

    @NonNull
    public static String m8062d(Context context, int i) {
        return i == 6 ? C2540n.m8059a(context, "common_google_play_services_resolution_required_text", C2540n.m8056a(context)) : C2540n.m8061c(context, i);
    }

    @NonNull
    public static String m8063e(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C2307b.common_google_play_services_install_button);
            case 2:
                return resources.getString(C2307b.common_google_play_services_update_button);
            case 3:
                return resources.getString(C2307b.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }
}
