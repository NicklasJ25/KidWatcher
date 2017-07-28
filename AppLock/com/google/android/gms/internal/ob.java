package com.google.android.gms.internal;

public class ob implements yw {
    private int f10062a;
    private int f10063b;
    private final int f10064c;
    private final float f10065d;

    public ob() {
        this(2500, 1, 1.0f);
    }

    public ob(int i, int i2, float f) {
        this.f10062a = i;
        this.f10064c = i2;
        this.f10065d = f;
    }

    public int mo3858a() {
        return this.f10062a;
    }

    public void mo3859a(abi com_google_android_gms_internal_abi) {
        this.f10063b++;
        this.f10062a = (int) (((float) this.f10062a) + (((float) this.f10062a) * this.f10065d));
        if (!m12892c()) {
            throw com_google_android_gms_internal_abi;
        }
    }

    public int mo3860b() {
        return this.f10063b;
    }

    protected boolean m12892c() {
        return this.f10063b <= this.f10064c;
    }
}
