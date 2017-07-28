package com.domobile.graphics.drawables;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class LollipopDrawablesCompat {
    private static final Map<String, Class<? extends Drawable>> CLASS_MAP = new HashMap();
    private static final IDrawable IMPL;
    private static final Object mAccessLock = new Object();
    private static final LongSparseArray<WeakReference<ConstantState>> sColorDrawableCache = new LongSparseArray();
    private static final LongSparseArray<WeakReference<ConstantState>> sDrawableCache = new LongSparseArray();

    private interface IDrawable {
        void applyTheme(Drawable drawable, Theme theme);

        boolean canApplyTheme(Drawable drawable);

        void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    static class BaseDrawableImpl implements IDrawable {
        BaseDrawableImpl() {
        }

        public void applyTheme(Drawable drawable, Theme theme) {
            if (drawable instanceof LollipopDrawable) {
                ((LollipopDrawable) drawable).applyTheme(theme);
            }
        }

        public boolean canApplyTheme(Drawable drawable) {
            return (drawable instanceof LollipopDrawable) && ((LollipopDrawable) drawable).canApplyTheme();
        }

        public void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            if (drawable instanceof LollipopDrawable) {
                ((LollipopDrawable) drawable).inflate(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable.inflate(resources, xmlPullParser, attributeSet);
            }
        }
    }

    @TargetApi(21)
    static class LollipopDrawableImpl extends BaseDrawableImpl {
        LollipopDrawableImpl() {
        }

        public void applyTheme(Drawable drawable, Theme theme) {
            drawable.applyTheme(theme);
        }

        public boolean canApplyTheme(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        public void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }
    }

    static {
        registerDrawable(RippleDrawable.class, "ripple");
        if (Android.isLollipop()) {
            IMPL = new LollipopDrawableImpl();
        } else {
            IMPL = new BaseDrawableImpl();
        }
    }

    public static void applyTheme(Drawable drawable, Theme theme) {
        IMPL.applyTheme(drawable, theme);
    }

    private static void cacheDrawable(TypedValue typedValue, Resources resources, Theme theme, boolean z, long j, Drawable drawable, LongSparseArray<WeakReference<ConstantState>> longSparseArray) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            synchronized (mAccessLock) {
                longSparseArray.put(j, new WeakReference(constantState));
            }
        }
    }

    public static boolean canApplyTheme(Drawable drawable) {
        return IMPL.canApplyTheme(drawable);
    }

    public static Drawable createFromPath(String str) {
        return Drawable.createFromPath(str);
    }

    public static Drawable createFromResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, String str) {
        return createFromResourceStream(resources, typedValue, inputStream, str, null);
    }

    public static Drawable createFromResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, String str, Options options) {
        return Drawable.createFromResourceStream(resources, typedValue, inputStream, str, options);
    }

    public static Drawable createFromStream(InputStream inputStream, String str) {
        return createFromResourceStream(null, null, inputStream, str);
    }

    public static Drawable createFromXml(Resources resources, XmlPullParser xmlPullParser) {
        return createFromXml(resources, xmlPullParser, null);
    }

    public static Drawable createFromXml(Resources resources, XmlPullParser xmlPullParser, Theme theme) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        Drawable createFromXmlInner = createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
        if (createFromXmlInner != null) {
            return createFromXmlInner;
        }
        throw new RuntimeException("Unknown initial tag: " + xmlPullParser.getName());
    }

    public static Drawable createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        Drawable drawable = null;
        String name = xmlPullParser.getName();
        try {
            Class cls = (Class) CLASS_MAP.get(name);
            if (cls != null) {
                drawable = (Drawable) cls.newInstance();
            } else if (name.indexOf(46) > 0) {
                drawable = (Drawable) Class.forName(name).newInstance();
            }
            if (drawable == null) {
                return Android.isLollipop() ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            } else {
                IMPL.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
                return drawable;
            }
        } catch (Throwable e) {
            throw new XmlPullParserException("Error while inflating drawable resource", xmlPullParser, e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.drawable.Drawable getCachedDrawable(android.support.v4.util.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState>> r3, long r4, android.content.res.Resources r6) {
        /*
        r1 = mAccessLock;
        monitor-enter(r1);
        r0 = r3.get(r4);	 Catch:{ all -> 0x001f }
        r0 = (java.lang.ref.WeakReference) r0;	 Catch:{ all -> 0x001f }
        if (r0 == 0) goto L_0x001c;
    L_0x000b:
        r0 = r0.get();	 Catch:{ all -> 0x001f }
        r0 = (android.graphics.drawable.Drawable.ConstantState) r0;	 Catch:{ all -> 0x001f }
        if (r0 == 0) goto L_0x0019;
    L_0x0013:
        r0 = r0.newDrawable(r6);	 Catch:{ all -> 0x001f }
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
    L_0x0018:
        return r0;
    L_0x0019:
        r3.delete(r4);	 Catch:{ all -> 0x001f }
    L_0x001c:
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
        r0 = 0;
        goto L_0x0018;
    L_0x001f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.domobile.graphics.drawables.LollipopDrawablesCompat.getCachedDrawable(android.support.v4.util.LongSparseArray, long, android.content.res.Resources):android.graphics.drawable.Drawable");
    }

    public static Drawable getDrawable(Resources resources, int i) {
        return getDrawable(resources, i, null);
    }

    public static Drawable getDrawable(Resources resources, int i, Theme theme) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        return loadDrawable(resources, typedValue, theme);
    }

    public static Drawable getDrawable(TypedArray typedArray, int i) {
        return getDrawable(typedArray, i, null);
    }

    public static Drawable getDrawable(TypedArray typedArray, int i, Theme theme) {
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return loadDrawable(typedArray.getResources(), typedValue, theme);
    }

    public static Drawable loadDrawable(Resources resources, TypedValue typedValue, Theme theme) {
        ConstantState constantState = null;
        if (typedValue == null || typedValue.resourceId == 0) {
            return constantState;
        }
        boolean z;
        LongSparseArray longSparseArray;
        long j;
        if (typedValue.type < 28 || typedValue.type > 31) {
            z = false;
            longSparseArray = sDrawableCache;
            j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        } else {
            z = true;
            longSparseArray = sColorDrawableCache;
            j = (long) typedValue.data;
        }
        Drawable cachedDrawable = getCachedDrawable(longSparseArray, j, resources);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        if (constantState != null) {
            Drawable newDrawable = constantState.newDrawable(resources);
            if (theme != null) {
                newDrawable = newDrawable.mutate();
                applyTheme(newDrawable, theme);
            }
            cachedDrawable = newDrawable;
        } else {
            cachedDrawable = z ? new ColorDrawable(typedValue.data) : loadDrawableForCookie(typedValue, typedValue.resourceId, resources, theme);
        }
        if (cachedDrawable == null) {
            return cachedDrawable;
        }
        cachedDrawable.setChangingConfigurations(typedValue.changingConfigurations);
        cacheDrawable(typedValue, resources, theme, z, j, cachedDrawable, longSparseArray);
        return cachedDrawable;
    }

    private static Drawable loadDrawableForCookie(TypedValue typedValue, int i, Resources resources, Theme theme) {
        if (typedValue.string == null) {
            throw new NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ")  is not a Drawable (color or path): " + typedValue);
        }
        String charSequence = typedValue.string.toString();
        if (charSequence.endsWith(".xml")) {
            try {
                Object openXmlResourceParser = resources.getAssets().openXmlResourceParser(typedValue.assetCookie, charSequence);
                Drawable createFromXml = createFromXml(resources, openXmlResourceParser, theme);
                openXmlResourceParser.close();
                return createFromXml;
            } catch (Throwable e) {
                Log.w(LollipopDrawablesCompat.class.getSimpleName(), "Failed to load drawable resource, using a fallback...", e);
                return resources.getDrawable(typedValue.resourceId);
            }
        }
        try {
            InputStream createInputStream = resources.getAssets().openNonAssetFd(typedValue.assetCookie, charSequence).createInputStream();
            createFromXml = createFromResourceStream(resources, typedValue, createInputStream, charSequence, null);
            createInputStream.close();
            return createFromXml;
        } catch (Throwable e2) {
            Log.w(LollipopDrawablesCompat.class.getSimpleName(), "Failed to load drawable resource, using a fallback...", e2);
            return resources.getDrawable(typedValue.resourceId);
        }
    }

    public static void registerDrawable(Class<? extends Drawable> cls, String str) {
        if (str == null || cls == null) {
            throw new NullPointerException("Class: " + cls + ". Name: " + str);
        }
        CLASS_MAP.put(str, cls);
    }

    public static void setBackground(View view, int i, @Nullable Theme theme) {
        setBackground(view, i, theme, false);
    }

    public static void setBackground(View view, int i, @Nullable Theme theme, boolean z) {
        if (VERSION.SDK_INT >= 14) {
            Drawable mutate = getDrawable(view.getResources(), i, theme).mutate();
            if (VERSION.SDK_INT >= 16) {
                view.setBackground(mutate);
            } else {
                view.setBackgroundDrawable(mutate);
            }
            view.setOnTouchListener(new DrawableHotspotTouch((LollipopDrawable) view.getBackground()).setInsideScrollContainer(z));
        }
    }

    public static void unregisterDrawable(String str) {
        CLASS_MAP.remove(str);
    }
}
