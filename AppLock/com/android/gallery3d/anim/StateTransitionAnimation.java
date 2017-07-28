package com.android.gallery3d.anim;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.android.gallery3d.ui.GLCanvas;
import com.android.gallery3d.ui.GLView;
import com.android.gallery3d.ui.RawTexture;
import com.android.gallery3d.ui.TiledScreenNail;

public class StateTransitionAnimation extends Animation {
    private float mCurrentBackgroundAlpha;
    private float mCurrentBackgroundScale;
    private float mCurrentContentAlpha;
    private float mCurrentContentScale;
    private float mCurrentOverlayAlpha;
    private float mCurrentOverlayScale;
    private RawTexture mOldScreenTexture;
    private final Spec mTransitionSpec;

    public static class Spec {
        private static final Interpolator DEFAULT_INTERPOLATOR = new DecelerateInterpolator();
        public static final Spec INCOMING = new Spec();
        public static final Spec OUTGOING = new Spec();
        public static final Spec PHOTO_INCOMING = INCOMING;
        public float backgroundAlphaFrom = 0.0f;
        public float backgroundAlphaTo = 0.0f;
        public float backgroundScaleFrom = 0.0f;
        public float backgroundScaleTo = 0.0f;
        public float contentAlphaFrom = 1.0f;
        public float contentAlphaTo = 1.0f;
        public float contentScaleFrom = 1.0f;
        public float contentScaleTo = 1.0f;
        public int duration = 330;
        public Interpolator interpolator = DEFAULT_INTERPOLATOR;
        public float overlayAlphaFrom = 0.0f;
        public float overlayAlphaTo = 0.0f;
        public float overlayScaleFrom = 0.0f;
        public float overlayScaleTo = 0.0f;

        static {
            OUTGOING.backgroundAlphaFrom = 0.5f;
            OUTGOING.backgroundAlphaTo = 0.0f;
            OUTGOING.backgroundScaleFrom = 1.0f;
            OUTGOING.backgroundScaleTo = 0.0f;
            OUTGOING.contentAlphaFrom = 0.5f;
            OUTGOING.contentAlphaTo = 1.0f;
            OUTGOING.contentScaleFrom = 3.0f;
            OUTGOING.contentScaleTo = 1.0f;
            INCOMING.overlayAlphaFrom = 1.0f;
            INCOMING.overlayAlphaTo = 0.0f;
            INCOMING.overlayScaleFrom = 1.0f;
            INCOMING.overlayScaleTo = 3.0f;
            INCOMING.contentAlphaFrom = 0.0f;
            INCOMING.contentAlphaTo = 1.0f;
            INCOMING.contentScaleFrom = 0.25f;
            INCOMING.contentScaleTo = 1.0f;
        }

        private static Spec specForTransition(Transition transition) {
            switch (transition) {
                case Outgoing:
                    return OUTGOING;
                case Incoming:
                    return INCOMING;
                case PhotoIncoming:
                    return PHOTO_INCOMING;
                default:
                    return null;
            }
        }
    }

    public enum Transition {
        None,
        Outgoing,
        Incoming,
        PhotoIncoming
    }

    public StateTransitionAnimation(Spec spec, RawTexture rawTexture) {
        if (spec == null) {
            spec = Spec.OUTGOING;
        }
        this.mTransitionSpec = spec;
        setDuration(this.mTransitionSpec.duration);
        setInterpolator(this.mTransitionSpec.interpolator);
        this.mOldScreenTexture = rawTexture;
        TiledScreenNail.disableDrawPlaceholder();
    }

    public StateTransitionAnimation(Transition transition, RawTexture rawTexture) {
        this(Spec.specForTransition(transition), rawTexture);
    }

    private void applyOldTexture(GLView gLView, GLCanvas gLCanvas, float f, float f2, boolean z) {
        if (this.mOldScreenTexture != null) {
            if (z) {
                gLCanvas.clearBuffer(gLView.getBackgroundColor());
            }
            gLCanvas.save();
            gLCanvas.setAlpha(f);
            int width = gLView.getWidth() / 2;
            int height = gLView.getHeight() / 2;
            gLCanvas.translate((float) width, (float) height);
            gLCanvas.scale(f2, f2, 1.0f);
            this.mOldScreenTexture.draw(gLCanvas, -width, -height);
            gLCanvas.restore();
        }
    }

    public void applyBackground(GLView gLView, GLCanvas gLCanvas) {
        if (this.mCurrentBackgroundAlpha > 0.0f) {
            applyOldTexture(gLView, gLCanvas, this.mCurrentBackgroundAlpha, this.mCurrentBackgroundScale, true);
        }
    }

    public void applyContentTransform(GLView gLView, GLCanvas gLCanvas) {
        int width = gLView.getWidth() / 2;
        int height = gLView.getHeight() / 2;
        gLCanvas.translate((float) width, (float) height);
        gLCanvas.scale(this.mCurrentContentScale, this.mCurrentContentScale, 1.0f);
        gLCanvas.translate((float) (-width), (float) (-height));
        gLCanvas.setAlpha(this.mCurrentContentAlpha);
    }

    public void applyOverlay(GLView gLView, GLCanvas gLCanvas) {
        if (this.mCurrentOverlayAlpha > 0.0f) {
            applyOldTexture(gLView, gLCanvas, this.mCurrentOverlayAlpha, this.mCurrentOverlayScale, false);
        }
    }

    public boolean calculate(long j) {
        boolean calculate = super.calculate(j);
        if (!isActive()) {
            if (this.mOldScreenTexture != null) {
                this.mOldScreenTexture.recycle();
                this.mOldScreenTexture = null;
            }
            TiledScreenNail.enableDrawPlaceholder();
        }
        return calculate;
    }

    protected void onCalculate(float f) {
        this.mCurrentContentScale = this.mTransitionSpec.contentScaleFrom + ((this.mTransitionSpec.contentScaleTo - this.mTransitionSpec.contentScaleFrom) * f);
        this.mCurrentContentAlpha = this.mTransitionSpec.contentAlphaFrom + ((this.mTransitionSpec.contentAlphaTo - this.mTransitionSpec.contentAlphaFrom) * f);
        this.mCurrentBackgroundAlpha = this.mTransitionSpec.backgroundAlphaFrom + ((this.mTransitionSpec.backgroundAlphaTo - this.mTransitionSpec.backgroundAlphaFrom) * f);
        this.mCurrentBackgroundScale = this.mTransitionSpec.backgroundScaleFrom + ((this.mTransitionSpec.backgroundScaleTo - this.mTransitionSpec.backgroundScaleFrom) * f);
        this.mCurrentOverlayScale = this.mTransitionSpec.overlayScaleFrom + ((this.mTransitionSpec.overlayScaleTo - this.mTransitionSpec.overlayScaleFrom) * f);
        this.mCurrentOverlayAlpha = this.mTransitionSpec.overlayAlphaFrom + ((this.mTransitionSpec.overlayAlphaTo - this.mTransitionSpec.overlayAlphaFrom) * f);
    }
}
