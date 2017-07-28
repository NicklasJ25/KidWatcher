package com.domobile.graphics.drawables;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public abstract class LollipopDrawable extends Drawable {
    private ColorFilter mColorFilter;

    public void applyTheme(Theme theme) {
    }

    public boolean canApplyTheme() {
        return false;
    }

    public int getAlpha() {
        return 255;
    }

    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    public void getHotspotBounds(Rect rect) {
        rect.set(getBounds());
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
    }

    public void setHotspot(float f, float f2) {
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
    }

    public void setTintMode(Mode mode) {
    }
}
