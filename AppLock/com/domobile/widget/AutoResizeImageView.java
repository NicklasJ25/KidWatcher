package com.domobile.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class AutoResizeImageView extends ImageView {
    public AutoResizeImageView(Context context) {
        super(context);
    }

    public AutoResizeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoResizeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AutoResizeImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    private void m3529a(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            drawable = getBackground();
        }
        if (i2 != 0 && drawable != null && (drawable instanceof BitmapDrawable)) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            if (((int) (intrinsicWidth / intrinsicHeight)) != i / i2) {
                final LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = (int) ((intrinsicHeight * ((float) i)) / intrinsicWidth);
                postDelayed(new Runnable(this) {
                    final /* synthetic */ AutoResizeImageView f3046b;

                    public void run() {
                        this.f3046b.setLayoutParams(layoutParams);
                    }
                }, 200);
                postInvalidate();
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            drawable = getBackground();
        }
        if (i2 != 0 && drawable != null && (drawable instanceof BitmapDrawable)) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            if (((int) (intrinsicWidth / intrinsicHeight)) != i / i2) {
                final LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = (int) ((intrinsicHeight * ((float) i)) / intrinsicWidth);
                setLayoutParams(layoutParams);
                postDelayed(new Runnable(this) {
                    final /* synthetic */ AutoResizeImageView f3044b;

                    public void run() {
                        this.f3044b.setLayoutParams(layoutParams);
                    }
                }, 200);
            }
        }
    }

    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        m3529a(getWidth(), getHeight());
    }

    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        m3529a(getWidth(), getHeight());
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m3529a(getWidth(), getHeight());
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m3529a(getWidth(), getHeight());
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        m3529a(getWidth(), getHeight());
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m3529a(getWidth(), getHeight());
    }
}
