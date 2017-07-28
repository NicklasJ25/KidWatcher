package com.google.android.gms.internal;

import com.google.android.gms.internal.ox.C3124a;
import java.util.Random;

@wh
public class om extends C3124a {
    private final Random f10132a = new Random();
    private long f10133b;
    private Object f10134c = new Object();

    public om() {
        m12985a();
    }

    public void m12985a() {
        synchronized (this.f10134c) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                j = ((long) this.f10132a.nextInt()) + 2147483648L;
                if (j != this.f10133b && j != 0) {
                    break;
                }
            }
            this.f10133b = j;
        }
    }

    public long mo3864b() {
        return this.f10133b;
    }
}
