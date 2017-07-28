package com.domobile.applock.chamber.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class DoWebView extends WebView {
    private C0887a f1311a;

    public interface C0887a {
        void m1533a(int i, int i2);
    }

    public DoWebView(Context context) {
        super(context);
    }

    public DoWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DoWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public DoWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public DoWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f1311a != null) {
            this.f1311a.m1533a(i - i3, i2 - i4);
        }
    }

    public void setOnScrollChangedListener(C0887a c0887a) {
        this.f1311a = c0887a;
    }
}
