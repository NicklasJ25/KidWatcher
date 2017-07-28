package com.domobile.graphics.drawables;

import java.util.Random;

public final class MathUtils {
    private static final float DEG_TO_RAD = 0.017453292f;
    private static final float RAD_TO_DEG = 57.295784f;
    private static final Random sRandom = new Random();

    private MathUtils() {
    }

    public static float abs(float f) {
        return f > 0.0f ? f : -f;
    }

    public static float acos(float f) {
        return (float) Math.acos((double) f);
    }

    public static float asin(float f) {
        return (float) Math.asin((double) f);
    }

    public static float atan(float f) {
        return (float) Math.atan((double) f);
    }

    public static float atan2(float f, float f2) {
        return (float) Math.atan2((double) f, (double) f2);
    }

    public static float constrain(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public static int constrain(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static long constrain(long j, long j2, long j3) {
        return j < j2 ? j2 : j > j3 ? j3 : j;
    }

    public static float degrees(float f) {
        return RAD_TO_DEG * f;
    }

    public static float dist(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    public static float dist(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f4 - f;
        float f8 = f5 - f2;
        float f9 = f6 - f3;
        return (float) Math.sqrt((double) (((f7 * f7) + (f8 * f8)) + (f9 * f9)));
    }

    public static float exp(float f) {
        return (float) Math.exp((double) f);
    }

    public static float lerp(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    public static float log(float f) {
        return (float) Math.log((double) f);
    }

    public static float mag(float f, float f2) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }

    public static float mag(float f, float f2, float f3) {
        return (float) Math.sqrt((double) (((f * f) + (f2 * f2)) + (f3 * f3)));
    }

    public static float map(float f, float f2, float f3, float f4, float f5) {
        return ((f3 - f4) * ((f5 - f) / (f2 - f))) + f3;
    }

    public static float max(float f, float f2) {
        return f > f2 ? f : f2;
    }

    public static float max(float f, float f2, float f3) {
        return f > f2 ? f > f3 ? f : f3 : f2 > f3 ? f2 : f3;
    }

    public static float max(int i, int i2) {
        return i > i2 ? (float) i : (float) i2;
    }

    public static float max(int i, int i2, int i3) {
        if (i > i2) {
            if (i <= i3) {
                i = i3;
            }
            return (float) i;
        }
        if (i2 <= i3) {
            i2 = i3;
        }
        return (float) i2;
    }

    public static float min(float f, float f2) {
        return f < f2 ? f : f2;
    }

    public static float min(float f, float f2, float f3) {
        return f < f2 ? f < f3 ? f : f3 : f2 < f3 ? f2 : f3;
    }

    public static float min(int i, int i2) {
        return i < i2 ? (float) i : (float) i2;
    }

    public static float min(int i, int i2, int i3) {
        if (i < i2) {
            if (i >= i3) {
                i = i3;
            }
            return (float) i;
        }
        if (i2 >= i3) {
            i2 = i3;
        }
        return (float) i2;
    }

    public static float norm(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    public static float pow(float f, float f2) {
        return (float) Math.pow((double) f, (double) f2);
    }

    public static float radians(float f) {
        return DEG_TO_RAD * f;
    }

    public static float random(float f) {
        return sRandom.nextFloat() * f;
    }

    public static float random(float f, float f2) {
        return f >= f2 ? f : f + (sRandom.nextFloat() * (f2 - f));
    }

    public static int random(int i) {
        return (int) (sRandom.nextFloat() * ((float) i));
    }

    public static int random(int i, int i2) {
        return i >= i2 ? i : (int) ((sRandom.nextFloat() * ((float) (i2 - i))) + ((float) i));
    }

    public static void randomSeed(long j) {
        sRandom.setSeed(j);
    }

    public static float sq(float f) {
        return f * f;
    }

    public static float tan(float f) {
        return (float) Math.tan((double) f);
    }
}
