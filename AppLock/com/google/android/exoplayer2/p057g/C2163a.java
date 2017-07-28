package com.google.android.exoplayer2.p057g;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.exoplayer2.p043j.C2273r;

public final class C2163a {
    public static final C2163a f6054a = new C2163a(-1, ViewCompat.MEASURED_STATE_MASK, 0, 0, -1, null);
    public final int f6055b;
    public final int f6056c;
    public final int f6057d;
    public final int f6058e;
    public final int f6059f;
    public final Typeface f6060g;

    public C2163a(int i, int i2, int i3, int i4, int i5, Typeface typeface) {
        this.f6055b = i;
        this.f6056c = i2;
        this.f6057d = i3;
        this.f6058e = i4;
        this.f6059f = i5;
        this.f6060g = typeface;
    }

    @TargetApi(19)
    public static C2163a m6635a(CaptionStyle captionStyle) {
        return C2273r.f6478a >= 21 ? C2163a.m6637c(captionStyle) : C2163a.m6636b(captionStyle);
    }

    @TargetApi(19)
    private static C2163a m6636b(CaptionStyle captionStyle) {
        return new C2163a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @TargetApi(21)
    private static C2163a m6637c(CaptionStyle captionStyle) {
        return new C2163a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f6054a.f6055b, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f6054a.f6056c, captionStyle.hasWindowColor() ? captionStyle.windowColor : f6054a.f6057d, captionStyle.hasEdgeType() ? captionStyle.edgeType : f6054a.f6058e, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f6054a.f6059f, captionStyle.getTypeface());
    }
}
