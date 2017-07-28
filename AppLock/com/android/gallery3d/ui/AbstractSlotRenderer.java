package com.android.gallery3d.ui;

import android.content.Context;
import android.graphics.Rect;
import com.android.gallery3d.C0488R;
import com.android.gallery3d.ui.SlotView.SlotRenderer;

public abstract class AbstractSlotRenderer implements SlotRenderer {
    private final NinePatchTexture mFramePressed;
    private FadeOutTexture mFramePressedUp;
    private final NinePatchTexture mFrameSelected;

    protected AbstractSlotRenderer(Context context) {
        this.mFramePressed = new NinePatchTexture(context, C0488R.drawable.transparent);
        this.mFrameSelected = new NinePatchTexture(context, C0488R.drawable.transparent);
    }

    protected static void drawFrame(GLCanvas gLCanvas, Rect rect, Texture texture, int i, int i2, int i3, int i4) {
        texture.draw(gLCanvas, i - rect.left, i2 - rect.top, (rect.left + i3) + rect.right, (rect.top + i4) + rect.bottom);
    }

    protected void drawContent(GLCanvas gLCanvas, Texture texture, int i, int i2, int i3) {
        gLCanvas.save(2);
        int min = Math.min(i, i2);
        if (i3 != 0) {
            gLCanvas.translate((float) (min / 2), (float) (min / 2));
            gLCanvas.rotate((float) i3, 0.0f, 0.0f, 1.0f);
            gLCanvas.translate((float) ((-min) / 2), (float) ((-min) / 2));
        }
        float min2 = Math.min(((float) min) / ((float) texture.getWidth()), ((float) min) / ((float) texture.getHeight()));
        gLCanvas.scale(min2, min2, 1.0f);
        texture.draw(gLCanvas, 0, 0);
        gLCanvas.restore();
    }

    protected void drawPressedFrame(GLCanvas gLCanvas, int i, int i2) {
        drawFrame(gLCanvas, this.mFramePressed.getPaddings(), this.mFramePressed, 0, 0, i, i2);
    }

    protected void drawPressedUpFrame(GLCanvas gLCanvas, int i, int i2) {
        if (this.mFramePressedUp == null) {
            this.mFramePressedUp = new FadeOutTexture(this.mFramePressed);
        }
        drawFrame(gLCanvas, this.mFramePressed.getPaddings(), this.mFramePressedUp, 0, 0, i, i2);
    }

    protected void drawSelectedFrame(GLCanvas gLCanvas, int i, int i2) {
        drawFrame(gLCanvas, this.mFrameSelected.getPaddings(), this.mFrameSelected, 0, 0, i, i2);
    }

    protected boolean isPressedUpFrameFinished() {
        if (this.mFramePressedUp != null) {
            if (this.mFramePressedUp.isAnimating()) {
                return false;
            }
            this.mFramePressedUp = null;
        }
        return true;
    }
}
