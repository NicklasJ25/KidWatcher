package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.drm.C2113b;
import com.google.android.exoplayer2.drm.C2115d;
import com.google.android.exoplayer2.p063h.C2208h;

public final class C2154f {
    public static C2298o m6577a(Context context, C2208h<?> c2208h, C2096j c2096j) {
        return C2154f.m6578a(context, c2208h, c2096j, null);
    }

    public static C2298o m6578a(Context context, C2208h<?> c2208h, C2096j c2096j, C2113b<C2115d> c2113b) {
        return C2154f.m6579a(context, c2208h, c2096j, c2113b, false);
    }

    public static C2298o m6579a(Context context, C2208h<?> c2208h, C2096j c2096j, C2113b<C2115d> c2113b, boolean z) {
        return C2154f.m6580a(context, c2208h, c2096j, c2113b, z, 5000);
    }

    public static C2298o m6580a(Context context, C2208h<?> c2208h, C2096j c2096j, C2113b<C2115d> c2113b, boolean z, long j) {
        return new C2298o(context, c2208h, c2096j, c2113b, z, j);
    }
}
