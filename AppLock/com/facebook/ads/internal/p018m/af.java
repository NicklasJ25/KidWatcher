package com.facebook.ads.internal.p018m;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

public class af {
    public static Bitmap m4817a(Context context, ad adVar) {
        byte[] decode = Base64.decode(adVar.m4811a(context.getResources().getDisplayMetrics().density), 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Drawable m4818b(Context context, ad adVar) {
        return new BitmapDrawable(context.getResources(), af.m4817a(context, adVar));
    }
}
