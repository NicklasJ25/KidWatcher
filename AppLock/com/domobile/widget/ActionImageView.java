package com.domobile.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import com.domobile.frame.p000a.C1147a;

public class ActionImageView extends ImageView implements OnLongClickListener {
    public ActionImageView(Context context) {
        super(context);
    }

    public ActionImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ActionImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public ActionImageView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setOnLongClickListener(this);
    }

    public boolean onLongClick(View view) {
        C1147a.m2487w(getContext(), getContentDescription().toString());
        return true;
    }
}
