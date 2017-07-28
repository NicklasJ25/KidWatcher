package com.domobile.applock.p003a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.support.annotation.Nullable;
import com.domobile.applock.p013f.C0903a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class C0618g {

    public static class C0616a {
        public int f554a;
        public int f555b;
    }

    public static class C0617b {
        public List<C0616a> f556a;
        public List<C0616a> f557b;
    }

    public static Bitmap m715a(Bitmap bitmap, float f) {
        Bitmap a = C0903a.m1589a(bitmap, f);
        return Bitmap.createBitmap(a, 2, 2, a.getWidth() - 4, a.getHeight() - 4);
    }

    @Nullable
    public static NinePatchDrawable m716a(Resources resources, Bitmap bitmap, int i) {
        float height = ((float) i) / ((float) bitmap.getHeight());
        C0617b b = C0618g.m719b(bitmap, height);
        return C0618g.m717a(resources, C0618g.m715a(bitmap, height), b.f556a, b.f557b, null);
    }

    public static NinePatchDrawable m717a(Resources resources, Bitmap bitmap, List<C0616a> list, List<C0616a> list2, String str) {
        return new NinePatchDrawable(resources, bitmap, C0618g.m718a((List) list, (List) list2).array(), new Rect(), str);
    }

    private static ByteBuffer m718a(List<C0616a> list, List<C0616a> list2) {
        ByteBuffer order = ByteBuffer.allocate((((list.size() * 8) + 32) + (list2.size() * 8)) + 36).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) (list.size() * 2));
        order.put((byte) (list2.size() * 2));
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        for (C0616a c0616a : list) {
            order.putInt(c0616a.f554a);
            order.putInt(c0616a.f555b);
        }
        for (C0616a c0616a2 : list2) {
            order.putInt(c0616a2.f554a);
            order.putInt(c0616a2.f555b);
        }
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        return order;
    }

    public static C0617b m719b(Bitmap bitmap, float f) {
        int i = 1;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        List<C0616a> arrayList = new ArrayList();
        int i2 = -1;
        for (int i3 = 1; i3 < width - 1; i3++) {
            int pixel = bitmap.getPixel(i3, 0);
            int alpha = Color.alpha(pixel);
            int red = Color.red(pixel);
            int green = Color.green(pixel);
            pixel = Color.blue(pixel);
            if (alpha == 255 && red == 0 && green == 0 && pixel == 0) {
                if (i2 == -1) {
                    i2 = i3 - 1;
                }
            } else if (i2 != -1) {
                C0616a c0616a = new C0616a();
                c0616a.f554a = i2;
                c0616a.f555b = i3 - 1;
                arrayList.add(c0616a);
                i2 = -1;
            }
        }
        if (i2 != -1) {
            C0616a c0616a2 = new C0616a();
            c0616a2.f554a = i2;
            c0616a2.f555b = width - 2;
            arrayList.add(c0616a2);
        }
        for (C0616a c0616a3 : arrayList) {
            c0616a3.f554a = (int) (((float) c0616a3.f554a) * f);
            c0616a3.f555b = (int) (((float) c0616a3.f555b) * f);
        }
        List<C0616a> arrayList2 = new ArrayList();
        i2 = -1;
        while (i < height - 1) {
            width = bitmap.getPixel(0, i);
            pixel = Color.alpha(width);
            alpha = Color.red(width);
            red = Color.green(width);
            width = Color.blue(width);
            if (pixel == 255 && alpha == 0 && red == 0 && width == 0) {
                if (i2 == -1) {
                    i2 = i - 1;
                }
            } else if (i2 != -1) {
                C0616a c0616a4 = new C0616a();
                c0616a4.f554a = i2;
                c0616a4.f555b = i - 1;
                arrayList2.add(c0616a4);
                i2 = -1;
            }
            i++;
        }
        if (i2 != -1) {
            C0616a c0616a5 = new C0616a();
            c0616a5.f554a = i2;
            c0616a5.f555b = height - 2;
            arrayList2.add(c0616a5);
        }
        for (C0616a c0616a32 : arrayList2) {
            c0616a32.f554a = (int) (((float) c0616a32.f554a) * f);
            c0616a32.f555b = (int) (((float) c0616a32.f555b) * f);
        }
        C0617b c0617b = new C0617b();
        c0617b.f556a = arrayList;
        c0617b.f557b = arrayList2;
        return c0617b;
    }
}
