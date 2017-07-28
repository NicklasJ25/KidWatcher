package com.google.android.gms.internal;

import android.os.Parcel;
import android.util.Base64;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@wh
class te {
    final zzec f10698a;
    final String f10699b;
    final int f10700c;

    te(tb tbVar) {
        this(tbVar.m13875a(), tbVar.m13879c(), tbVar.m13878b());
    }

    te(zzec com_google_android_gms_internal_zzec, String str, int i) {
        this.f10698a = com_google_android_gms_internal_zzec;
        this.f10699b = str;
        this.f10700c = i;
    }

    static te m13899a(String str) {
        String[] split = str.split("\u0000");
        if (split.length != 3) {
            throw new IOException("Incorrect field count for QueueSeed.");
        }
        Parcel obtain = Parcel.obtain();
        try {
            String str2 = new String(Base64.decode(split[0], 0), "UTF-8");
            int parseInt = Integer.parseInt(split[1]);
            byte[] decode = Base64.decode(split[2], 0);
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            te teVar = new te((zzec) zzec.CREATOR.createFromParcel(obtain), str2, parseInt);
            obtain.recycle();
            return teVar;
        } catch (Throwable th) {
            obtain.recycle();
        }
    }

    String m13900a() {
        String encodeToString;
        Parcel obtain = Parcel.obtain();
        try {
            encodeToString = Base64.encodeToString(this.f10699b.getBytes("UTF-8"), 0);
            String num = Integer.toString(this.f10700c);
            this.f10698a.writeToParcel(obtain, 0);
            String encodeToString2 = Base64.encodeToString(obtain.marshall(), 0);
            encodeToString = new StringBuilder(((String.valueOf(encodeToString).length() + 2) + String.valueOf(num).length()) + String.valueOf(encodeToString2).length()).append(encodeToString).append("\u0000").append(num).append("\u0000").append(encodeToString2).toString();
            return encodeToString;
        } catch (UnsupportedEncodingException e) {
            encodeToString = "QueueSeed encode failed because UTF-8 is not available.";
            aad.m8423c(encodeToString);
            return "";
        } finally {
            obtain.recycle();
        }
    }
}
