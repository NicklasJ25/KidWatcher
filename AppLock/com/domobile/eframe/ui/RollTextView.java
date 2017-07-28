package com.domobile.eframe.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class RollTextView extends TextView {
    public RollTextView(Context context) {
        super(context);
    }

    public RollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RollTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean isFocused() {
        return true;
    }
}
