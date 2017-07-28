package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.internal.wh;

@wh
public abstract class NativeAdMapper {
    protected boolean f4902a;
    protected boolean f4903b;
    protected Bundle f4904c = new Bundle();
    protected View f4905d;

    public View getAdChoicesContent() {
        return this.f4905d;
    }

    public final Bundle getExtras() {
        return this.f4904c;
    }

    public final boolean getOverrideClickHandling() {
        return this.f4903b;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.f4902a;
    }

    public void handleClick(View view) {
    }

    public void recordImpression() {
    }

    public void setAdChoicesContent(View view) {
        this.f4905d = view;
    }

    public final void setExtras(Bundle bundle) {
        this.f4904c = bundle;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.f4903b = z;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.f4902a = z;
    }

    public void trackView(View view) {
    }

    public void untrackView(View view) {
    }
}
