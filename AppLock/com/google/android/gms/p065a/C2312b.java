package com.google.android.gms.p065a;

import android.os.IBinder;
import com.google.android.gms.p065a.C2309a.C2311a;
import java.lang.reflect.Field;

public final class C2312b<T> extends C2311a {
    private final T f6665a;

    private C2312b(T t) {
        this.f6665a = t;
    }

    public static <T> C2309a m7327a(T t) {
        return new C2312b(t);
    }

    public static <T> T m7328a(C2309a c2309a) {
        int i = 0;
        if (c2309a instanceof C2312b) {
            return ((C2312b) c2309a).f6665a;
        }
        IBinder asBinder = c2309a.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int length = declaredFields.length;
        int i2 = 0;
        while (i2 < length) {
            Field field2 = declaredFields[i2];
            if (field2.isSynthetic()) {
                field2 = field;
            } else {
                i++;
            }
            i2++;
            field = field2;
        }
        if (i != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        } else if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        } else {
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
            }
        }
    }
}
