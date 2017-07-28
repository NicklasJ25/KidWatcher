package com.domobile.graphics.drawables;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.domobile.p015b.C1168b.C1167k;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class LayerDrawable extends LollipopDrawable implements Callback {
    static final /* synthetic */ boolean $assertionsDisabled = (!LayerDrawable.class.desiredAssertionStatus());
    public static final int PADDING_MODE_NEST = 0;
    public static final int PADDING_MODE_STACK = 1;
    private Rect mHotspotBounds;
    LayerState mLayerState;
    private boolean mMutated;
    private int mOpacityOverride;
    private int[] mPaddingB;
    private int[] mPaddingL;
    private int[] mPaddingR;
    private int[] mPaddingT;
    private final Rect mTmpRect;

    static class ChildDrawable {
        public Drawable mDrawable;
        public int mId = -1;
        public int mInsetB;
        public int mInsetL;
        public int mInsetR;
        public int mInsetT;
        public TypedValue[] mThemeAttrs;

        ChildDrawable() {
        }

        ChildDrawable(ChildDrawable childDrawable, LayerDrawable layerDrawable, Resources resources) {
            if (resources != null) {
                this.mDrawable = childDrawable.mDrawable.getConstantState().newDrawable(resources);
            } else {
                this.mDrawable = childDrawable.mDrawable.getConstantState().newDrawable();
            }
            this.mDrawable.setCallback(layerDrawable);
            this.mDrawable.setBounds(childDrawable.mDrawable.getBounds());
            this.mDrawable.setLevel(childDrawable.mDrawable.getLevel());
            this.mThemeAttrs = childDrawable.mThemeAttrs;
            this.mInsetL = childDrawable.mInsetL;
            this.mInsetT = childDrawable.mInsetT;
            this.mInsetR = childDrawable.mInsetR;
            this.mInsetB = childDrawable.mInsetB;
            this.mId = childDrawable.mId;
        }
    }

    static class LayerState extends ConstantState {
        private boolean mAutoMirrored = false;
        int mChangingConfigurations;
        ChildDrawable[] mChildren;
        int mChildrenChangingConfigurations;
        private boolean mHaveIsStateful;
        private boolean mHaveOpacity;
        private boolean mIsStateful;
        int mNum;
        private int mOpacity;
        private int mPaddingMode = 0;
        TypedValue[] mThemeAttrs;

        LayerState(LayerState layerState, LayerDrawable layerDrawable, Resources resources) {
            int i = 0;
            if (layerState != null) {
                ChildDrawable[] childDrawableArr = layerState.mChildren;
                int i2 = layerState.mNum;
                this.mNum = i2;
                this.mChildren = new ChildDrawable[i2];
                this.mChangingConfigurations = layerState.mChangingConfigurations;
                this.mChildrenChangingConfigurations = layerState.mChildrenChangingConfigurations;
                while (i < i2) {
                    this.mChildren[i] = new ChildDrawable(childDrawableArr[i], layerDrawable, resources);
                    i++;
                }
                this.mHaveOpacity = layerState.mHaveOpacity;
                this.mOpacity = layerState.mOpacity;
                this.mHaveIsStateful = layerState.mHaveIsStateful;
                this.mIsStateful = layerState.mIsStateful;
                this.mAutoMirrored = layerState.mAutoMirrored;
                this.mPaddingMode = layerState.mPaddingMode;
                this.mThemeAttrs = layerState.mThemeAttrs;
                return;
            }
            this.mNum = 0;
            this.mChildren = null;
        }

        public boolean canApplyTheme() {
            if (this.mThemeAttrs != null || super.canApplyTheme()) {
                return true;
            }
            ChildDrawable[] childDrawableArr = this.mChildren;
            int i = this.mNum;
            for (int i2 = 0; i2 < i; i2++) {
                ChildDrawable childDrawable = childDrawableArr[i2];
                if (childDrawable.mThemeAttrs != null || LollipopDrawablesCompat.canApplyTheme(childDrawable.mDrawable)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean canConstantState() {
            ChildDrawable[] childDrawableArr = this.mChildren;
            int i = this.mNum;
            for (int i2 = 0; i2 < i; i2++) {
                if (childDrawableArr[i2].mDrawable.getConstantState() == null) {
                    return false;
                }
            }
            return true;
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public final int getOpacity() {
            if (this.mHaveOpacity) {
                return this.mOpacity;
            }
            ChildDrawable[] childDrawableArr = this.mChildren;
            int i = this.mNum;
            int opacity = i > 0 ? childDrawableArr[0].mDrawable.getOpacity() : -2;
            int i2 = 1;
            while (i2 < i) {
                int resolveOpacity = Drawable.resolveOpacity(opacity, childDrawableArr[i2].mDrawable.getOpacity());
                i2++;
                opacity = resolveOpacity;
            }
            this.mOpacity = opacity;
            this.mHaveOpacity = true;
            return opacity;
        }

        public void invalidateCache() {
            this.mHaveOpacity = false;
            this.mHaveIsStateful = false;
        }

        public final boolean isStateful() {
            boolean z = false;
            if (this.mHaveIsStateful) {
                return this.mIsStateful;
            }
            ChildDrawable[] childDrawableArr = this.mChildren;
            int i = this.mNum;
            for (int i2 = 0; i2 < i; i2++) {
                if (childDrawableArr[i2].mDrawable.isStateful()) {
                    z = true;
                    break;
                }
            }
            this.mIsStateful = z;
            this.mHaveIsStateful = true;
            return z;
        }

        public Drawable newDrawable() {
            return new LayerDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new LayerDrawable(this, resources);
        }
    }

    LayerDrawable() {
        this((LayerState) null, null);
    }

    LayerDrawable(LayerState layerState, Resources resources) {
        this.mOpacityOverride = 0;
        this.mTmpRect = new Rect();
        this.mLayerState = createConstantState(layerState, resources);
        if (this.mLayerState.mNum > 0) {
            ensurePadding();
        }
    }

    public LayerDrawable(Drawable[] drawableArr) {
        this(drawableArr, null);
    }

    LayerDrawable(Drawable[] drawableArr, LayerState layerState) {
        this(layerState, null);
        int length = drawableArr.length;
        ChildDrawable[] childDrawableArr = new ChildDrawable[length];
        for (int i = 0; i < length; i++) {
            childDrawableArr[i] = new ChildDrawable();
            childDrawableArr[i].mDrawable = drawableArr[i];
            drawableArr[i].setCallback(this);
            LayerState layerState2 = this.mLayerState;
            layerState2.mChildrenChangingConfigurations |= drawableArr[i].getChangingConfigurations();
        }
        this.mLayerState.mNum = length;
        this.mLayerState.mChildren = childDrawableArr;
        ensurePadding();
    }

    private void computeNestedPadding(Rect rect) {
        int i = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i2 = this.mLayerState.mNum;
        while (i < i2) {
            refreshChildPadding(i, childDrawableArr[i]);
            rect.left += this.mPaddingL[i];
            rect.top += this.mPaddingT[i];
            rect.right += this.mPaddingR[i];
            rect.bottom += this.mPaddingB[i];
            i++;
        }
    }

    private void computeStackedPadding(Rect rect) {
        int i = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i2 = this.mLayerState.mNum;
        while (i < i2) {
            refreshChildPadding(i, childDrawableArr[i]);
            rect.left = Math.max(rect.left, this.mPaddingL[i]);
            rect.top = Math.max(rect.top, this.mPaddingT[i]);
            rect.right = Math.max(rect.right, this.mPaddingR[i]);
            rect.bottom = Math.max(rect.bottom, this.mPaddingB[i]);
            i++;
        }
    }

    private void inflateLayers(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        LayerState layerState = this.mLayerState;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                    ChildDrawable childDrawable = new ChildDrawable();
                    TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, C1167k.LayerDrawableItem);
                    updateLayerFromTypedArray(theme, null, childDrawable, obtainAttributes);
                    obtainAttributes.recycle();
                    if (childDrawable.mDrawable == null) {
                        do {
                            depth2 = xmlPullParser.next();
                        } while (depth2 == 4);
                        if (depth2 != 2) {
                            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                        childDrawable.mDrawable = LollipopDrawablesCompat.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                    }
                    if (childDrawable.mDrawable != null) {
                        layerState.mChildrenChangingConfigurations |= childDrawable.mDrawable.getChangingConfigurations();
                        childDrawable.mDrawable.setCallback(this);
                    }
                    addLayer(childDrawable);
                }
            } else {
                return;
            }
        }
    }

    static TypedArray obtainAttributes(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private boolean refreshChildPadding(int i, ChildDrawable childDrawable) {
        Rect rect = this.mTmpRect;
        childDrawable.mDrawable.getPadding(rect);
        if (rect.left == this.mPaddingL[i] && rect.top == this.mPaddingT[i] && rect.right == this.mPaddingR[i] && rect.bottom == this.mPaddingB[i]) {
            return false;
        }
        this.mPaddingL[i] = rect.left;
        this.mPaddingT[i] = rect.top;
        this.mPaddingR[i] = rect.right;
        this.mPaddingB[i] = rect.bottom;
        return true;
    }

    private void updateLayerFromTypedArray(Theme theme, TypedValue[] typedValueArr, ChildDrawable childDrawable, TypedArray typedArray) {
        LayerState layerState = this.mLayerState;
        layerState.mChildrenChangingConfigurations |= TypedArrayCompat.getChangingConfigurations(typedArray);
        childDrawable.mThemeAttrs = TypedArrayCompat.extractThemeAttrs(typedArray);
        childDrawable.mInsetL = TypedArrayCompat.getDimensionPixelOffset(theme, typedArray, typedValueArr, C1167k.LayerDrawableItem_android_left, childDrawable.mInsetL);
        childDrawable.mInsetT = TypedArrayCompat.getDimensionPixelOffset(theme, typedArray, typedValueArr, C1167k.LayerDrawableItem_android_top, childDrawable.mInsetT);
        childDrawable.mInsetR = TypedArrayCompat.getDimensionPixelOffset(theme, typedArray, typedValueArr, C1167k.LayerDrawableItem_android_right, childDrawable.mInsetR);
        childDrawable.mInsetB = TypedArrayCompat.getDimensionPixelOffset(theme, typedArray, typedValueArr, C1167k.LayerDrawableItem_android_bottom, childDrawable.mInsetB);
        childDrawable.mId = TypedArrayCompat.getResourceId(theme, typedArray, typedValueArr, C1167k.LayerDrawableItem_android_id, childDrawable.mId);
        Drawable drawable = TypedArrayCompat.getDrawable(theme, typedArray, typedValueArr, C1167k.LayerDrawableItem_android_drawable);
        if (drawable != null) {
            childDrawable.mDrawable = drawable;
        }
    }

    private void updateStateFromTypedArray(Theme theme, TypedArray typedArray, TypedValue[] typedValueArr) {
        LayerState layerState = this.mLayerState;
        layerState.mChangingConfigurations |= TypedArrayCompat.getChangingConfigurations(typedArray);
        layerState.mThemeAttrs = TypedArrayCompat.extractThemeAttrs(typedArray);
        this.mOpacityOverride = typedArray.getInt(C1167k.LayerDrawable_android_opacity, this.mOpacityOverride);
        layerState.mAutoMirrored = typedArray.getBoolean(C1167k.LayerDrawable_android_autoMirrored, layerState.mAutoMirrored);
        layerState.mPaddingMode = typedArray.getInteger(C1167k.LayerDrawable_android_paddingMode, layerState.mPaddingMode);
    }

    ChildDrawable addLayer(Drawable drawable, TypedValue[] typedValueArr, int i, int i2, int i3, int i4, int i5) {
        ChildDrawable childDrawable = new ChildDrawable();
        childDrawable.mId = i;
        childDrawable.mThemeAttrs = typedValueArr;
        childDrawable.mDrawable = drawable;
        DrawableCompat.setAutoMirrored(childDrawable.mDrawable, isAutoMirrored());
        childDrawable.mInsetL = i2;
        childDrawable.mInsetT = i3;
        childDrawable.mInsetR = i4;
        childDrawable.mInsetB = i5;
        addLayer(childDrawable);
        LayerState layerState = this.mLayerState;
        layerState.mChildrenChangingConfigurations |= drawable.getChangingConfigurations();
        drawable.setCallback(this);
        return childDrawable;
    }

    void addLayer(ChildDrawable childDrawable) {
        LayerState layerState = this.mLayerState;
        int length = layerState.mChildren != null ? layerState.mChildren.length : 0;
        int i = layerState.mNum;
        if ($assertionsDisabled || layerState.mChildren != null) {
            if (i >= length) {
                Object obj = new ChildDrawable[(length + 10)];
                if (i > 0) {
                    System.arraycopy(layerState.mChildren, 0, obj, 0, i);
                }
                layerState.mChildren = obj;
            }
            layerState.mChildren[i] = childDrawable;
            layerState.mNum++;
            layerState.invalidateCache();
            return;
        }
        throw new AssertionError();
    }

    public void applyTheme(Theme theme) {
        super.applyTheme(theme);
        LayerState layerState = this.mLayerState;
        if (layerState != null) {
            if (layerState.mThemeAttrs != null) {
                updateStateFromTypedArray(theme, null, layerState.mThemeAttrs);
            }
            ChildDrawable[] childDrawableArr = layerState.mChildren;
            int i = layerState.mNum;
            for (int i2 = 0; i2 < i; i2++) {
                ChildDrawable childDrawable = childDrawableArr[i2];
                if (childDrawable.mThemeAttrs != null) {
                    updateLayerFromTypedArray(theme, childDrawable.mThemeAttrs, childDrawable, null);
                }
                Drawable drawable = childDrawable.mDrawable;
                if (LollipopDrawablesCompat.canApplyTheme(drawable)) {
                    LollipopDrawablesCompat.applyTheme(drawable, theme);
                }
            }
            ensurePadding();
            onStateChange(getState());
        }
    }

    public boolean canApplyTheme() {
        return (this.mLayerState != null && this.mLayerState.canApplyTheme()) || super.canApplyTheme();
    }

    LayerState createConstantState(LayerState layerState, Resources resources) {
        return new LayerState(layerState, this, resources);
    }

    public void draw(Canvas canvas) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        for (int i2 = 0; i2 < i; i2++) {
            childDrawableArr[i2].mDrawable.draw(canvas);
        }
    }

    void ensurePadding() {
        int i = this.mLayerState.mNum;
        if (this.mPaddingL == null || this.mPaddingL.length < i) {
            this.mPaddingL = new int[i];
            this.mPaddingT = new int[i];
            this.mPaddingR = new int[i];
            this.mPaddingB = new int[i];
        }
    }

    public Drawable findDrawableByLayerId(int i) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        for (int i2 = this.mLayerState.mNum - 1; i2 >= 0; i2--) {
            if (childDrawableArr[i2].mId == i) {
                return childDrawableArr[i2].mDrawable;
            }
        }
        return null;
    }

    @TargetApi(19)
    public int getAlpha() {
        if (!Android.isKitkat()) {
            return -1;
        }
        return this.mLayerState.mNum > 0 ? this.mLayerState.mChildren[0].mDrawable.getAlpha() : super.getAlpha();
    }

    public int getChangingConfigurations() {
        return (super.getChangingConfigurations() | this.mLayerState.mChangingConfigurations) | this.mLayerState.mChildrenChangingConfigurations;
    }

    public ConstantState getConstantState() {
        if (!this.mLayerState.canConstantState()) {
            return null;
        }
        this.mLayerState.mChangingConfigurations = getChangingConfigurations();
        return this.mLayerState;
    }

    public Drawable getDrawable(int i) {
        return this.mLayerState.mChildren[i].mDrawable;
    }

    public void getHotspotBounds(Rect rect) {
        if (this.mHotspotBounds != null) {
            rect.set(this.mHotspotBounds);
        }
    }

    public int getId(int i) {
        return this.mLayerState.mChildren[i].mId;
    }

    public int getIntrinsicHeight() {
        int i = 0;
        int i2 = -1;
        int i3 = this.mLayerState.mPaddingMode == 0 ? 1 : 0;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i4 = this.mLayerState.mNum;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            ChildDrawable childDrawable = childDrawableArr[i5];
            int intrinsicHeight = ((childDrawable.mInsetB + (childDrawable.mDrawable.getIntrinsicHeight() + childDrawable.mInsetT)) + i6) + i;
            if (intrinsicHeight <= i2) {
                intrinsicHeight = i2;
            }
            if (i3 != 0) {
                i6 += this.mPaddingT[i5];
                i += this.mPaddingB[i5];
            }
            i5++;
            i2 = intrinsicHeight;
        }
        return i2;
    }

    public int getIntrinsicWidth() {
        int i = 0;
        int i2 = -1;
        int i3 = this.mLayerState.mPaddingMode == 0 ? 1 : 0;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i4 = this.mLayerState.mNum;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            ChildDrawable childDrawable = childDrawableArr[i5];
            int intrinsicWidth = ((childDrawable.mInsetR + (childDrawable.mDrawable.getIntrinsicWidth() + childDrawable.mInsetL)) + i6) + i;
            if (intrinsicWidth <= i2) {
                intrinsicWidth = i2;
            }
            if (i3 != 0) {
                i6 += this.mPaddingL[i5];
                i += this.mPaddingR[i5];
            }
            i5++;
            i2 = intrinsicWidth;
        }
        return i2;
    }

    public int getNumberOfLayers() {
        return this.mLayerState.mNum;
    }

    public int getOpacity() {
        return this.mOpacityOverride != 0 ? this.mOpacityOverride : this.mLayerState.getOpacity();
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (Android.isLollipop()) {
            LayerState layerState = this.mLayerState;
            ChildDrawable[] childDrawableArr = layerState.mChildren;
            int i = layerState.mNum;
            int i2 = 0;
            while (i2 < i) {
                childDrawableArr[i2].mDrawable.getOutline(outline);
                if (outline.isEmpty()) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean getPadding(Rect rect) {
        if (this.mLayerState.mPaddingMode == 0) {
            computeNestedPadding(rect);
        } else {
            computeStackedPadding(rect);
        }
        return (rect.left == 0 && rect.top == 0 && rect.right == 0 && rect.bottom == 0) ? false : true;
    }

    public int getPaddingMode() {
        return this.mLayerState.mPaddingMode;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, C1167k.LayerDrawable);
        updateStateFromTypedArray(theme, obtainAttributes, null);
        obtainAttributes.recycle();
        inflateLayers(resources, xmlPullParser, attributeSet, theme);
        ensurePadding();
        onStateChange(getState());
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.mLayerState.mAutoMirrored;
    }

    public boolean isStateful() {
        return this.mLayerState.isStateful();
    }

    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mLayerState = createConstantState(this.mLayerState, null);
            ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
            int i = this.mLayerState.mNum;
            for (int i2 = 0; i2 < i; i2++) {
                childDrawableArr[i2].mDrawable.mutate();
            }
            this.mMutated = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        int i = 0;
        int i2 = this.mLayerState.mPaddingMode == 0 ? 1 : 0;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i3 = this.mLayerState.mNum;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            ChildDrawable childDrawable = childDrawableArr[i7];
            childDrawable.mDrawable.setBounds((rect.left + childDrawable.mInsetL) + i6, (rect.top + childDrawable.mInsetT) + i5, (rect.right - childDrawable.mInsetR) - i4, (rect.bottom - childDrawable.mInsetB) - i);
            if (i2 != 0) {
                i6 += this.mPaddingL[i7];
                i4 += this.mPaddingR[i7];
                i5 += this.mPaddingT[i7];
                i += this.mPaddingB[i7];
            }
        }
    }

    protected boolean onLevelChange(int i) {
        boolean z = false;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i2 = this.mLayerState.mNum;
        boolean z2 = false;
        for (int i3 = 0; i3 < i2; i3++) {
            ChildDrawable childDrawable = childDrawableArr[i3];
            if (childDrawable.mDrawable.setLevel(i)) {
                z = true;
            }
            if (refreshChildPadding(i3, childDrawable)) {
                z2 = true;
            }
        }
        if (z2) {
            onBoundsChange(getBounds());
        }
        return z;
    }

    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        boolean z2 = false;
        for (int i2 = 0; i2 < i; i2++) {
            ChildDrawable childDrawable = childDrawableArr[i2];
            if (childDrawable.mDrawable.isStateful() && childDrawable.mDrawable.setState(iArr)) {
                z = true;
            }
            if (refreshChildPadding(i2, childDrawable)) {
                z2 = true;
            }
        }
        if (z2) {
            onBoundsChange(getBounds());
        }
        return z;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i2 = this.mLayerState.mNum;
        for (int i3 = 0; i3 < i2; i3++) {
            childDrawableArr[i3].mDrawable.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        this.mLayerState.mAutoMirrored = z;
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        for (int i2 = 0; i2 < i; i2++) {
            DrawableCompat.setAutoMirrored(childDrawableArr[i2].mDrawable, z);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        for (int i2 = 0; i2 < i; i2++) {
            childDrawableArr[i2].mDrawable.setColorFilter(colorFilter);
        }
    }

    public void setDither(boolean z) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        for (int i2 = 0; i2 < i; i2++) {
            childDrawableArr[i2].mDrawable.setDither(z);
        }
    }

    public boolean setDrawableByLayerId(int i, Drawable drawable) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i2 = this.mLayerState.mNum;
        for (int i3 = 0; i3 < i2; i3++) {
            ChildDrawable childDrawable = childDrawableArr[i3];
            if (childDrawable.mId == i) {
                if (childDrawable.mDrawable != null) {
                    if (drawable != null) {
                        drawable.setBounds(childDrawable.mDrawable.getBounds());
                    }
                    childDrawable.mDrawable.setCallback(null);
                }
                if (drawable != null) {
                    drawable.setCallback(this);
                }
                childDrawable.mDrawable = drawable;
                this.mLayerState.invalidateCache();
                return true;
            }
        }
        return false;
    }

    public void setHotspot(float f, float f2) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        for (int i2 = 0; i2 < i; i2++) {
            DrawableCompat.setHotspot(childDrawableArr[i2].mDrawable, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i5 = this.mLayerState.mNum;
        for (int i6 = 0; i6 < i5; i6++) {
            DrawableCompat.setHotspotBounds(childDrawableArr[i6].mDrawable, i, i2, i3, i4);
        }
        if (this.mHotspotBounds == null) {
            this.mHotspotBounds = new Rect(i, i2, i3, i4);
        } else {
            this.mHotspotBounds.set(i, i2, i3, i4);
        }
    }

    public void setId(int i, int i2) {
        this.mLayerState.mChildren[i].mId = i2;
    }

    public void setLayerInset(int i, int i2, int i3, int i4, int i5) {
        ChildDrawable childDrawable = this.mLayerState.mChildren[i];
        childDrawable.mInsetL = i2;
        childDrawable.mInsetT = i3;
        childDrawable.mInsetR = i4;
        childDrawable.mInsetB = i5;
    }

    public void setOpacity(int i) {
        this.mOpacityOverride = i;
    }

    public void setPaddingMode(int i) {
        if (this.mLayerState.mPaddingMode != i) {
            this.mLayerState.mPaddingMode = i;
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        for (int i2 = 0; i2 < i; i2++) {
            DrawableCompat.setTintList(childDrawableArr[i2].mDrawable, colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        for (int i2 = 0; i2 < i; i2++) {
            DrawableCompat.setTintMode(childDrawableArr[i2].mDrawable, mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        ChildDrawable[] childDrawableArr = this.mLayerState.mChildren;
        int i = this.mLayerState.mNum;
        for (int i2 = 0; i2 < i; i2++) {
            childDrawableArr[i2].mDrawable.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
