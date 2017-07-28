package com.google.android.exoplayer2.p057g;

import com.google.android.exoplayer2.p044b.C1957e;
import com.google.android.exoplayer2.p044b.C1958f;
import com.google.android.exoplayer2.p044b.C1960g;
import java.nio.ByteBuffer;

public abstract class C2164c extends C1960g<C2194i, C2160j, C2191g> implements C2156f {
    private final String f6061a;

    protected C2164c(String str) {
        super(new C2194i[2], new C2160j[2]);
        this.f6061a = str;
        m5721a(1024);
    }

    protected abstract C2159e mo3062a(byte[] bArr, int i);

    protected final C2191g m6639a(C2194i c2194i, C2160j c2160j, boolean z) {
        try {
            ByteBuffer byteBuffer = c2194i.b;
            C2159e a = mo3062a(byteBuffer.array(), byteBuffer.limit());
            c2160j.m6626a(c2194i.c, a, c2194i.f6181d);
            return null;
        } catch (C2191g e) {
            return e;
        }
    }

    public void mo3044a(long j) {
    }

    protected final void m6643a(C2160j c2160j) {
        super.mo3057a((C1958f) c2160j);
    }

    protected /* synthetic */ C1957e mo3058g() {
        return mo3060i();
    }

    protected /* synthetic */ C1958f mo3059h() {
        return mo3061j();
    }

    protected final C2194i mo3060i() {
        return new C2194i();
    }

    protected final C2160j mo3061j() {
        return new C2177d(this);
    }
}
