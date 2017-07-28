package com.android.gallery3d.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

public class HelpUtils {
    private static final String PARAM_LANGUAGE_CODE = "hl";
    private static final String PARAM_VERSION = "version";
    private static final String TAG = HelpUtils.class.getName();
    private static String sCachedVersionCode = null;

    private HelpUtils() {
    }

    public static Intent getHelpIntent(Context context, int i) {
        Object string = context.getString(i);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW", uriWithAddedParameters(context, Uri.parse(string)));
        intent.setFlags(276824064);
        return intent;
    }

    private static Uri uriWithAddedParameters(Context context, Uri uri) {
        Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter(PARAM_LANGUAGE_CODE, Locale.getDefault().toString());
        if (sCachedVersionCode == null) {
            try {
                sCachedVersionCode = Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                buildUpon.appendQueryParameter(PARAM_VERSION, sCachedVersionCode);
            } catch (Throwable e) {
                Log.wtf(TAG, "Invalid package name for context", e);
            }
        } else {
            buildUpon.appendQueryParameter(PARAM_VERSION, sCachedVersionCode);
        }
        return buildUpon.build();
    }
}
