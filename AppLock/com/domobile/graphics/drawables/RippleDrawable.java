package com.domobile.graphics.drawables;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.domobile.p015b.C1168b.C1167k;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class RippleDrawable extends LayerDrawable {
    private static final int MASK_CONTENT = 1;
    private static final int MASK_EXPLICIT = 2;
    private static final int MASK_NONE = 0;
    private static final int MASK_UNKNOWN = -1;
    private static final int MAX_RIPPLES = 10;
    public static final int RADIUS_AUTO = -1;
    private RippleBackground mBackground;
    private boolean mBackgroundActive;
    private float mDensity;
    private final Rect mDirtyBounds;
    private final Rect mDrawingBounds;
    private Ripple[] mExitingRipples;
    private int mExitingRipplesCount;
    private boolean mHasPending;
    private boolean mHasValidMask;
    private final Rect mHotspotBounds;
    private Drawable mMask;
    private Bitmap mMaskBuffer;
    private Canvas mMaskCanvas;
    private PorterDuffColorFilter mMaskColorFilter;
    private Matrix mMaskMatrix;
    private BitmapShader mMaskShader;
    private boolean mOverrideBounds;
    private float mPendingX;
    private float mPendingY;
    private Ripple mRipple;
    private boolean mRippleActive;
    private Paint mRipplePaint;
    private RippleState mState;
    private final Rect mTempRect;

    static class RippleState extends LayerState {
        ColorStateList mColor = ColorStateList.valueOf(-65281);
        int mMaxRadius = -1;
        TypedValue[] mTouchThemeAttrs;

        public RippleState(LayerState layerState, RippleDrawable rippleDrawable, Resources resources) {
            super(layerState, rippleDrawable, resources);
            if (layerState != null && (layerState instanceof RippleState)) {
                RippleState rippleState = (RippleState) layerState;
                this.mTouchThemeAttrs = rippleState.mTouchThemeAttrs;
                this.mColor = rippleState.mColor;
                this.mMaxRadius = rippleState.mMaxRadius;
            }
        }

        public boolean canApplyTheme() {
            return this.mTouchThemeAttrs != null || super.canApplyTheme();
        }

        public Drawable newDrawable() {
            return new RippleDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new RippleDrawable(this, resources);
        }
    }

    RippleDrawable() {
        this(new RippleState(null, null, null), null);
    }

    public RippleDrawable(@NonNull ColorStateList colorStateList, @Nullable Drawable drawable, @Nullable Drawable drawable2) {
        this(new RippleState(null, null, null), null);
        if (colorStateList == null) {
            throw new IllegalArgumentException("RippleDrawable requires a non-null color");
        }
        if (drawable != null) {
            addLayer(drawable, null, 0, 0, 0, 0, 0);
        }
        if (drawable2 != null) {
            addLayer(drawable2, null, 16908334, 0, 0, 0, 0);
        }
        setColor(colorStateList);
        ensurePadding();
        initializeFromState();
    }

    private RippleDrawable(RippleState rippleState, Resources resources) {
        this.mTempRect = new Rect();
        this.mHotspotBounds = new Rect();
        this.mDrawingBounds = new Rect();
        this.mDirtyBounds = new Rect();
        this.mExitingRipplesCount = 0;
        this.mDensity = 1.0f;
        this.mState = new RippleState(rippleState, this, resources);
        this.mLayerState = this.mState;
        if (this.mState.mNum > 0) {
            ensurePadding();
        }
        if (resources != null) {
            this.mDensity = resources.getDisplayMetrics().density;
        }
        initializeFromState();
    }

    private boolean cancelExitingRipples() {
        int i = this.mExitingRipplesCount;
        Ripple[] rippleArr = this.mExitingRipples;
        for (int i2 = 0; i2 < i; i2++) {
            rippleArr[i2].cancel();
        }
        if (rippleArr != null) {
            Arrays.fill(rippleArr, 0, i, null);
        }
        this.mExitingRipplesCount = 0;
        return false;
    }

    private void clearHotspots() {
        if (this.mRipple != null) {
            this.mRipple.cancel();
            this.mRipple = null;
            this.mRippleActive = false;
        }
        if (this.mBackground != null) {
            this.mBackground.cancel();
            this.mBackground = null;
            this.mBackgroundActive = false;
        }
        cancelExitingRipples();
        invalidateSelf();
    }

    private void drawBackgroundAndRipples(Canvas canvas) {
        Ripple ripple = this.mRipple;
        RippleBackground rippleBackground = this.mBackground;
        int i = this.mExitingRipplesCount;
        if (ripple != null || i > 0 || (rippleBackground != null && rippleBackground.shouldDraw())) {
            float exactCenterX = this.mHotspotBounds.exactCenterX();
            float exactCenterY = this.mHotspotBounds.exactCenterY();
            canvas.translate(exactCenterX, exactCenterY);
            updateMaskShaderIfNeeded();
            if (this.mMaskShader != null) {
                this.mMaskMatrix.setTranslate(-exactCenterX, -exactCenterY);
                this.mMaskShader.setLocalMatrix(this.mMaskMatrix);
            }
            int colorForState = this.mState.mColor.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK);
            int alpha = (Color.alpha(colorForState) / 2) << 24;
            Paint ripplePaint = getRipplePaint();
            if (this.mMaskColorFilter != null) {
                this.mMaskColorFilter = DrawableReflectiveUtils.setColor(this.mMaskColorFilter, colorForState | ViewCompat.MEASURED_STATE_MASK, Mode.SRC_IN);
                ripplePaint.setColor(alpha);
                ripplePaint.setColorFilter(this.mMaskColorFilter);
                ripplePaint.setShader(this.mMaskShader);
            } else {
                ripplePaint.setColor((colorForState & ViewCompat.MEASURED_SIZE_MASK) | alpha);
                ripplePaint.setColorFilter(null);
                ripplePaint.setShader(null);
            }
            if (rippleBackground != null && rippleBackground.shouldDraw()) {
                rippleBackground.draw(canvas, ripplePaint);
            }
            if (i > 0) {
                Ripple[] rippleArr = this.mExitingRipples;
                for (int i2 = 0; i2 < i; i2++) {
                    rippleArr[i2].draw(canvas, ripplePaint);
                }
            }
            if (ripple != null) {
                ripple.draw(canvas, ripplePaint);
            }
            canvas.translate(-exactCenterX, -exactCenterY);
        }
    }

    private void drawContent(Canvas canvas) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        for (int i2 = 0; i2 < i; i2++) {
            if (childDrawableArr[i2].mId != 16908334) {
                childDrawableArr[i2].mDrawable.draw(canvas);
            }
        }
    }

    private void drawMask(Canvas canvas) {
        this.mMask.draw(canvas);
    }

    private int getMaskType() {
        if (this.mRipple == null && this.mExitingRipplesCount <= 0 && (this.mBackground == null || !this.mBackground.shouldDraw())) {
            return -1;
        }
        if (this.mMask != null) {
            return this.mMask.getOpacity() == -1 ? 0 : 2;
        } else {
            ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
            int i = this.mLayerState.mNum;
            for (int i2 = 0; i2 < i; i2++) {
                if (childDrawableArr[i2].mDrawable.getOpacity() != -1) {
                    return 1;
                }
            }
            return 0;
        }
    }

    private int getRippleIndex(Ripple ripple) {
        Ripple[] rippleArr = this.mExitingRipples;
        int i = this.mExitingRipplesCount;
        for (int i2 = 0; i2 < i; i2++) {
            if (rippleArr[i2] == ripple) {
                return i2;
            }
        }
        return -1;
    }

    private Paint getRipplePaint() {
        if (this.mRipplePaint == null) {
            this.mRipplePaint = new Paint();
            this.mRipplePaint.setAntiAlias(true);
            this.mRipplePaint.setStyle(Style.FILL);
        }
        return this.mRipplePaint;
    }

    private void initializeFromState() {
        this.mMask = findDrawableByLayerId(16908334);
    }

    private void onHotspotBoundsChanged() {
        int i = this.mExitingRipplesCount;
        Ripple[] rippleArr = this.mExitingRipples;
        for (int i2 = 0; i2 < i; i2++) {
            rippleArr[i2].onHotspotBoundsChanged();
        }
        if (this.mRipple != null) {
            this.mRipple.onHotspotBoundsChanged();
        }
        if (this.mBackground != null) {
            this.mBackground.onHotspotBoundsChanged();
        }
    }

    private void setBackgroundActive(boolean z, boolean z2) {
        if (this.mBackgroundActive != z) {
            this.mBackgroundActive = z;
            if (z) {
                tryBackgroundEnter(z2);
            } else {
                tryBackgroundExit();
            }
        }
    }

    private void setRippleActive(boolean z) {
        if (this.mRippleActive != z) {
            this.mRippleActive = z;
            if (z) {
                tryRippleEnter();
            } else {
                tryRippleExit();
            }
        }
    }

    private void setTargetDensity(DisplayMetrics displayMetrics) {
        if (this.mDensity != displayMetrics.density) {
            this.mDensity = displayMetrics.density;
            invalidateSelf();
        }
    }

    private void tryBackgroundEnter(boolean z) {
        if (this.mBackground == null) {
            this.mBackground = new RippleBackground(this, this.mHotspotBounds);
        }
        this.mBackground.setup(this.mState.mMaxRadius, this.mDensity);
        this.mBackground.enter(z);
    }

    private void tryBackgroundExit() {
        if (this.mBackground != null) {
            this.mBackground.exit();
        }
    }

    private void tryRippleEnter() {
        if (this.mExitingRipplesCount < 10) {
            if (this.mRipple == null) {
                float f;
                float f2;
                if (this.mHasPending) {
                    this.mHasPending = false;
                    f = this.mPendingX;
                    f2 = this.mPendingY;
                } else {
                    f = this.mHotspotBounds.exactCenterX();
                    f2 = this.mHotspotBounds.exactCenterY();
                }
                this.mRipple = new Ripple(this, this.mHotspotBounds, f, f2);
            }
            this.mRipple.setup(this.mState.mMaxRadius, this.mDensity);
            this.mRipple.enter();
        }
    }

    private void tryRippleExit() {
        if (this.mRipple != null) {
            if (this.mExitingRipples == null) {
                this.mExitingRipples = new Ripple[10];
            }
            Ripple[] rippleArr = this.mExitingRipples;
            int i = this.mExitingRipplesCount;
            this.mExitingRipplesCount = i + 1;
            rippleArr[i] = this.mRipple;
            this.mRipple.exit();
            this.mRipple = null;
        }
    }

    private void updateMaskShaderIfNeeded() {
        if (!this.mHasValidMask) {
            int maskType = getMaskType();
            if (maskType != -1) {
                this.mHasValidMask = true;
                Rect bounds = getBounds();
                if (maskType == 0 || bounds.isEmpty()) {
                    if (this.mMaskBuffer != null) {
                        this.mMaskBuffer.recycle();
                        this.mMaskBuffer = null;
                        this.mMaskShader = null;
                        this.mMaskCanvas = null;
                    }
                    this.mMaskMatrix = null;
                    this.mMaskColorFilter = null;
                    return;
                }
                if (this.mMaskBuffer != null && this.mMaskBuffer.getWidth() == bounds.width() && this.mMaskBuffer.getHeight() == bounds.height()) {
                    this.mMaskBuffer.eraseColor(0);
                } else {
                    if (this.mMaskBuffer != null) {
                        this.mMaskBuffer.recycle();
                    }
                    this.mMaskBuffer = Bitmap.createBitmap(bounds.width(), bounds.height(), Config.ALPHA_8);
                    this.mMaskShader = new BitmapShader(this.mMaskBuffer, TileMode.CLAMP, TileMode.CLAMP);
                    this.mMaskCanvas = new Canvas(this.mMaskBuffer);
                }
                if (this.mMaskMatrix == null) {
                    this.mMaskMatrix = new Matrix();
                } else {
                    this.mMaskMatrix.reset();
                }
                if (this.mMaskColorFilter == null) {
                    this.mMaskColorFilter = new PorterDuffColorFilter(0, Mode.SRC_IN);
                }
                if (maskType == 2) {
                    drawMask(this.mMaskCanvas);
                } else if (maskType == 1) {
                    drawContent(this.mMaskCanvas);
                }
            }
        }
    }

    private void updateStateFromTypedArray(Theme theme, TypedArray typedArray, TypedValue[] typedValueArr) {
        RippleState rippleState = this.mState;
        rippleState.mChangingConfigurations |= TypedArrayCompat.getChangingConfigurations(typedArray);
        rippleState.mTouchThemeAttrs = TypedArrayCompat.extractThemeAttrs(typedArray);
        ColorStateList colorStateList = TypedArrayCompat.getColorStateList(theme, typedArray, typedValueArr, C1167k.RippleDrawable_android_color);
        if (colorStateList != null) {
            this.mState.mColor = colorStateList;
        }
        verifyRequiredAttributes(typedArray);
    }

    private void verifyRequiredAttributes(TypedArray typedArray) {
        if (this.mState.mColor != null) {
            return;
        }
        if (this.mState.mTouchThemeAttrs == null || this.mState.mTouchThemeAttrs[C1167k.RippleDrawable_android_color].data == 0) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + ": <ripple> requires a valid color attribute");
        }
    }

    public void applyTheme(Theme theme) {
        super.applyTheme(theme);
        RippleState rippleState = this.mState;
        if (rippleState != null && rippleState.mTouchThemeAttrs != null) {
            try {
                updateStateFromTypedArray(theme, null, this.mState.mTouchThemeAttrs);
                initializeFromState();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean canApplyTheme() {
        return (this.mState != null && this.mState.canApplyTheme()) || super.canApplyTheme();
    }

    RippleState createConstantState(LayerState layerState, Resources resources) {
        return new RippleState(layerState, this, resources);
    }

    public void draw(@NonNull Canvas canvas) {
        Rect dirtyBounds = getDirtyBounds();
        int save = canvas.save(2);
        canvas.clipRect(dirtyBounds);
        drawContent(canvas);
        drawBackgroundAndRipples(canvas);
        canvas.restoreToCount(save);
    }

    public ConstantState getConstantState() {
        return this.mState;
    }

    public Rect getDirtyBounds() {
        if (!isProjected()) {
            return getBounds();
        }
        Rect rect = this.mDrawingBounds;
        Rect rect2 = this.mDirtyBounds;
        rect2.set(rect);
        rect.setEmpty();
        int exactCenterX = (int) this.mHotspotBounds.exactCenterX();
        int exactCenterY = (int) this.mHotspotBounds.exactCenterY();
        Rect rect3 = this.mTempRect;
        Ripple[] rippleArr = this.mExitingRipples;
        int i = this.mExitingRipplesCount;
        for (int i2 = 0; i2 < i; i2++) {
            rippleArr[i2].getBounds(rect3);
            rect3.offset(exactCenterX, exactCenterY);
            rect.union(rect3);
        }
        RippleBackground rippleBackground = this.mBackground;
        if (rippleBackground != null) {
            rippleBackground.getBounds(rect3);
            rect3.offset(exactCenterX, exactCenterY);
            rect.union(rect3);
        }
        rect2.union(rect);
        rect2.union(super.getDirtyBounds());
        return rect2;
    }

    public void getHotspotBounds(Rect rect) {
        rect.set(this.mHotspotBounds);
    }

    public int getMaxRadius() {
        return this.mState.mMaxRadius;
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(@NonNull Outline outline) {
        LayerState layerState = this.mLayerState;
        ChildDrawable[] childDrawableArr = layerState.mChildren;
        int i = layerState.mNum;
        for (int i2 = 0; i2 < i; i2++) {
            if (childDrawableArr[i2].mId != 16908334) {
                childDrawableArr[i2].mDrawable.getOutline(outline);
                if (!outline.isEmpty()) {
                    return;
                }
            }
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        TypedArray obtainAttributes = LayerDrawable.obtainAttributes(resources, theme, attributeSet, C1167k.RippleDrawable);
        updateStateFromTypedArray(null, obtainAttributes, null);
        obtainAttributes.recycle();
        setPaddingMode(1);
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        setTargetDensity(resources.getDisplayMetrics());
        initializeFromState();
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.mHasValidMask = false;
    }

    public boolean isProjected() {
        return getNumberOfLayers() == 0;
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        if (this.mRipple != null) {
            this.mRipple.jump();
        }
        if (this.mBackground != null) {
            this.mBackground.jump();
        }
        cancelExitingRipples();
        invalidateSelf();
    }

    public Drawable mutate() {
        super.mutate();
        this.mState = (RippleState) this.mLayerState;
        this.mMask = findDrawableByLayerId(16908334);
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (!this.mOverrideBounds) {
            this.mHotspotBounds.set(rect);
            onHotspotBoundsChanged();
        }
        invalidateSelf();
    }

    protected boolean onStateChange(int[] iArr) {
        boolean z;
        boolean z2 = false;
        boolean onStateChange = super.onStateChange(iArr);
        int length = iArr.length;
        int i = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (i < length) {
            int i2 = iArr[i];
            if (i2 == 16842910) {
                z5 = true;
            }
            z = i2 == 16842908 ? true : z3;
            if (i2 == 16842919) {
                z4 = true;
            }
            i++;
            z3 = z;
        }
        z = z5 && z4;
        setRippleActive(z);
        if (z3 || (z5 && z4)) {
            z2 = true;
        }
        setBackgroundActive(z2, z3);
        return onStateChange;
    }

    void removeRipple(Ripple ripple) {
        Object obj = this.mExitingRipples;
        int i = this.mExitingRipplesCount;
        int rippleIndex = getRippleIndex(ripple);
        if (rippleIndex >= 0) {
            System.arraycopy(obj, rippleIndex + 1, obj, rippleIndex, i - (rippleIndex + 1));
            obj[i - 1] = null;
            this.mExitingRipplesCount--;
            invalidateSelf();
        }
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
    }

    public void setColor(ColorStateList colorStateList) {
        this.mState.mColor = colorStateList;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public boolean setDrawableByLayerId(int i, Drawable drawable) {
        if (!super.setDrawableByLayerId(i, drawable)) {
            return false;
        }
        if (i == 16908334) {
            this.mMask = drawable;
        }
        return true;
    }

    public void setHotspot(float f, float f2) {
        if (this.mRipple == null || this.mBackground == null) {
            this.mPendingX = f;
            this.mPendingY = f2;
            this.mHasPending = true;
        }
        if (this.mRipple != null) {
            this.mRipple.move(f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.mOverrideBounds = true;
        this.mHotspotBounds.set(i, i2, i3, i4);
        onHotspotBoundsChanged();
    }

    public void setMaxRadius(int i) {
        if (i == -1 || i >= 0) {
            this.mState.mMaxRadius = i;
            return;
        }
        throw new IllegalArgumentException("maxRadius must be RADIUS_AUTO or >= 0");
    }

    public void setPaddingMode(int i) {
        super.setPaddingMode(i);
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!z) {
            clearHotspots();
        } else if (visible) {
            if (this.mRippleActive) {
                tryRippleEnter();
            }
            if (this.mBackgroundActive) {
                tryBackgroundEnter(false);
            }
            jumpToCurrentState();
        }
        return visible;
    }
}
