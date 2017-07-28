package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

@wh
public class on extends AdListener {
    private final Object f10135a = new Object();
    private AdListener f10136b;

    public void m12987a(AdListener adListener) {
        synchronized (this.f10135a) {
            this.f10136b = adListener;
        }
    }

    public void onAdClosed() {
        synchronized (this.f10135a) {
            if (this.f10136b != null) {
                this.f10136b.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.f10135a) {
            if (this.f10136b != null) {
                this.f10136b.onAdFailedToLoad(i);
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.f10135a) {
            if (this.f10136b != null) {
                this.f10136b.onAdLeftApplication();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.f10135a) {
            if (this.f10136b != null) {
                this.f10136b.onAdLoaded();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.f10135a) {
            if (this.f10136b != null) {
                this.f10136b.onAdOpened();
            }
        }
    }
}
