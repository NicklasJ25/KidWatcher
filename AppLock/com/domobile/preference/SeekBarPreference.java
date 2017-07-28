package com.domobile.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.domobile.p015b.C1168b.C1162f;
import com.domobile.p015b.C1168b.C1163g;

public class SeekBarPreference extends DialogPreference {
    private Drawable mMyIcon = getDialogIcon();

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setDialogLayoutResource(C1163g.preference_seekbar_dialog);
        setPositiveButtonText(17039370);
        setNegativeButtonText(17039360);
        setDialogIcon(null);
    }

    protected static SeekBar getSeekBar(View view) {
        return (SeekBar) view.findViewById(C1162f.preference_seekbar);
    }

    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        ImageView imageView = (ImageView) view.findViewById(16908294);
        if (this.mMyIcon != null) {
            imageView.setImageDrawable(this.mMyIcon);
        } else {
            imageView.setVisibility(8);
        }
    }
}
