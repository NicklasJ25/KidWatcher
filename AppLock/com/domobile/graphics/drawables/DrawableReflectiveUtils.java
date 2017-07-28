package com.domobile.graphics.drawables;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.util.LruCache;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.lang.reflect.Method;

class DrawableReflectiveUtils {
    private static final ColorFilterLruCache COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    static final Class[] INT_ARG = new Class[]{Integer.TYPE};
    private static final String TAG = "DrawableReflectiveUtils";
    private static SimpleArrayMap<String, Method> sCachedMethods = new SimpleArrayMap();

    private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }

        private static int generateCacheKey(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter get(int i, Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(generateCacheKey(i, mode)));
        }

        PorterDuffColorFilter put(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(generateCacheKey(i, mode)), porterDuffColorFilter);
        }
    }

    DrawableReflectiveUtils() {
    }

    public static PorterDuffColorFilter setColor(PorterDuffColorFilter porterDuffColorFilter, int i, Mode mode) {
        if (Android.isLollipop()) {
            tryInvoke(porterDuffColorFilter, "setColor", INT_ARG, Integer.valueOf(i));
            return porterDuffColorFilter;
        }
        PorterDuffColorFilter porterDuffColorFilter2 = COLOR_FILTER_CACHE.get(i, mode);
        if (porterDuffColorFilter2 != null) {
            return porterDuffColorFilter2;
        }
        porterDuffColorFilter2 = new PorterDuffColorFilter(i, mode);
        COLOR_FILTER_CACHE.put(i, mode, porterDuffColorFilter2);
        return porterDuffColorFilter2;
    }

    public static <T> T tryInvoke(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = (Method) sCachedMethods.get(str);
            if (method != null) {
                return method.invoke(obj, objArr);
            }
            method = obj.getClass().getDeclaredMethod(str, clsArr);
            sCachedMethods.put(str, method);
            return method.invoke(obj, objArr);
        } catch (Throwable e) {
            Log.e(TAG, "Unable to invoke " + str + " on " + obj, e);
            return null;
        }
    }
}
