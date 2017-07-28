package com.domobile.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

public class NpaLinearLayoutManager extends LinearLayoutManager {
    public NpaLinearLayoutManager(Context context) {
        super(context);
    }

    public NpaLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public NpaLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public boolean supportsPredictiveItemAnimations() {
        return false;
    }
}
