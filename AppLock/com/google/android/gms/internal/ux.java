package com.google.android.gms.internal;

import org.json.JSONObject;

@wh
public class ux {
    private final aat f10921a;
    private final String f10922b;

    public ux(aat com_google_android_gms_internal_aat) {
        this(com_google_android_gms_internal_aat, "");
    }

    public ux(aat com_google_android_gms_internal_aat, String str) {
        this.f10921a = com_google_android_gms_internal_aat;
        this.f10922b = str;
    }

    public void m14272a(int i, int i2, int i3, int i4) {
        try {
            this.f10921a.mo3410b("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            aad.m8422b("Error occured while dispatching size change.", e);
        }
    }

    public void m14273a(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.f10921a.mo3410b("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (Throwable e) {
            aad.m8422b("Error occured while obtaining screen information.", e);
        }
    }

    public void m14274b(int i, int i2, int i3, int i4) {
        try {
            this.f10921a.mo3410b("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            aad.m8422b("Error occured while dispatching default position.", e);
        }
    }

    public void m14275b(String str) {
        try {
            this.f10921a.mo3410b("onError", new JSONObject().put("message", str).put("action", this.f10922b));
        } catch (Throwable e) {
            aad.m8422b("Error occurred while dispatching error event.", e);
        }
    }

    public void m14276c(String str) {
        try {
            this.f10921a.mo3410b("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (Throwable e) {
            aad.m8422b("Error occured while dispatching ready Event.", e);
        }
    }

    public void m14277d(String str) {
        try {
            this.f10921a.mo3410b("onStateChanged", new JSONObject().put("state", str));
        } catch (Throwable e) {
            aad.m8422b("Error occured while dispatching state change.", e);
        }
    }
}
