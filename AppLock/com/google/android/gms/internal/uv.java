package com.google.android.gms.internal;

import org.json.JSONObject;

@wh
public class uv {
    private final boolean f10964a;
    private final boolean f10965b;
    private final boolean f10966c;
    private final boolean f10967d;
    private final boolean f10968e;

    public static final class C3347a {
        private boolean f10959a;
        private boolean f10960b;
        private boolean f10961c;
        private boolean f10962d;
        private boolean f10963e;

        public C3347a m14305a(boolean z) {
            this.f10959a = z;
            return this;
        }

        public uv m14306a() {
            return new uv();
        }

        public C3347a m14307b(boolean z) {
            this.f10960b = z;
            return this;
        }

        public C3347a m14308c(boolean z) {
            this.f10961c = z;
            return this;
        }

        public C3347a m14309d(boolean z) {
            this.f10962d = z;
            return this;
        }

        public C3347a m14310e(boolean z) {
            this.f10963e = z;
            return this;
        }
    }

    private uv(C3347a c3347a) {
        this.f10964a = c3347a.f10959a;
        this.f10965b = c3347a.f10960b;
        this.f10966c = c3347a.f10961c;
        this.f10967d = c3347a.f10962d;
        this.f10968e = c3347a.f10963e;
    }

    public JSONObject m14311a() {
        try {
            return new JSONObject().put("sms", this.f10964a).put("tel", this.f10965b).put("calendar", this.f10966c).put("storePicture", this.f10967d).put("inlineVideo", this.f10968e);
        } catch (Throwable e) {
            aad.m8422b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
