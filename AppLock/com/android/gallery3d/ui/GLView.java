package com.android.gallery3d.ui;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.android.gallery3d.anim.CanvasAnimation;
import com.android.gallery3d.anim.StateTransitionAnimation;
import com.android.gallery3d.common.Utils;
import java.util.ArrayList;

public class GLView {
    private static final int FLAG_INVISIBLE = 1;
    private static final int FLAG_LAYOUT_REQUESTED = 4;
    private static final int FLAG_SET_MEASURED_SIZE = 2;
    public static final int INVISIBLE = 1;
    private static final String TAG = "GLView";
    public static final int VISIBLE = 0;
    private CanvasAnimation mAnimation;
    private float[] mBackgroundColor;
    protected final Rect mBounds = new Rect();
    private ArrayList<GLView> mComponents;
    private int mLastHeightSpec = -1;
    private int mLastWidthSpec = -1;
    protected int mMeasuredHeight = 0;
    protected int mMeasuredWidth = 0;
    private GLView mMotionTarget;
    protected final Rect mPaddings = new Rect();
    protected GLView mParent;
    private GLRoot mRoot;
    protected int mScrollHeight = 0;
    protected int mScrollWidth = 0;
    protected int mScrollX = 0;
    protected int mScrollY = 0;
    private StateTransitionAnimation mTransition;
    private int mViewFlags = 0;

    public interface OnClickListener {
        void onClick(GLView gLView);
    }

    private void removeOneComponent(GLView gLView) {
        if (this.mMotionTarget == gLView) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            dispatchTouchEvent(obtain);
            obtain.recycle();
        }
        gLView.onDetachFromRoot();
        gLView.mParent = null;
    }

    private boolean setBounds(int i, int i2, int i3, int i4) {
        boolean z = (i3 - i == this.mBounds.right - this.mBounds.left && i4 - i2 == this.mBounds.bottom - this.mBounds.top) ? false : true;
        this.mBounds.set(i, i2, i3, i4);
        return z;
    }

    public void addComponent(GLView gLView) {
        if (gLView.mParent != null) {
            throw new IllegalStateException();
        }
        if (this.mComponents == null) {
            this.mComponents = new ArrayList();
        }
        this.mComponents.add(gLView);
        gLView.mParent = this;
        if (this.mRoot != null) {
            gLView.onAttachToRoot(this.mRoot);
        }
    }

    public void attachToRoot(GLRoot gLRoot) {
        boolean z = this.mParent == null && this.mRoot == null;
        Utils.assertTrue(z);
        onAttachToRoot(gLRoot);
    }

    public Rect bounds() {
        return this.mBounds;
    }

    public void detachFromRoot() {
        boolean z = this.mParent == null && this.mRoot != null;
        Utils.assertTrue(z);
        onDetachFromRoot();
    }

    protected boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (this.mMotionTarget != null) {
            if (action == 0) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                dispatchTouchEvent(obtain, x, y, this.mMotionTarget, false);
                this.mMotionTarget = null;
            } else {
                dispatchTouchEvent(motionEvent, x, y, this.mMotionTarget, false);
                if (action == 3 || action == 1) {
                    this.mMotionTarget = null;
                }
                return true;
            }
        }
        if (action == 0) {
            for (action = getComponentCount() - 1; action >= 0; action--) {
                GLView component = getComponent(action);
                if (component.getVisibility() == 0 && dispatchTouchEvent(motionEvent, x, y, component, true)) {
                    this.mMotionTarget = component;
                    return true;
                }
            }
        }
        return onTouch(motionEvent);
    }

    protected boolean dispatchTouchEvent(MotionEvent motionEvent, int i, int i2, GLView gLView, boolean z) {
        Rect rect = gLView.mBounds;
        int i3 = rect.left;
        int i4 = rect.top;
        if (!z || rect.contains(i, i2)) {
            motionEvent.offsetLocation((float) (-i3), (float) (-i4));
            if (gLView.dispatchTouchEvent(motionEvent)) {
                motionEvent.offsetLocation((float) i3, (float) i4);
                return true;
            }
            motionEvent.offsetLocation((float) i3, (float) i4);
        }
        return false;
    }

    void dumpTree(String str) {
        Log.m451d(TAG, str + getClass().getSimpleName());
        int componentCount = getComponentCount();
        for (int i = 0; i < componentCount; i++) {
            getComponent(i).dumpTree(str + "....");
        }
    }

    public float[] getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public boolean getBoundsOf(GLView gLView, Rect rect) {
        int i = 0;
        int i2 = 0;
        for (GLView gLView2 = gLView; gLView2 != this; gLView2 = gLView2.mParent) {
            if (gLView2 == null) {
                return false;
            }
            Rect rect2 = gLView2.mBounds;
            i2 += rect2.left;
            i += rect2.top;
        }
        rect.set(i2, i, gLView.getWidth() + i2, gLView.getHeight() + i);
        return true;
    }

    public GLView getComponent(int i) {
        if (this.mComponents != null) {
            return (GLView) this.mComponents.get(i);
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public int getComponentCount() {
        return this.mComponents == null ? 0 : this.mComponents.size();
    }

    public GLRoot getGLRoot() {
        return this.mRoot;
    }

    public int getHeight() {
        return this.mBounds.bottom - this.mBounds.top;
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public Rect getPaddings() {
        return this.mPaddings;
    }

    public int getVisibility() {
        return (this.mViewFlags & 1) == 0 ? 0 : 1;
    }

    public int getWidth() {
        return this.mBounds.right - this.mBounds.left;
    }

    public void invalidate() {
        GLRoot gLRoot = getGLRoot();
        if (gLRoot != null) {
            gLRoot.requestRender();
        }
    }

    public void layout(int i, int i2, int i3, int i4) {
        boolean bounds = setBounds(i, i2, i3, i4);
        this.mViewFlags &= -5;
        onLayout(bounds, i, i2, i3, i4);
    }

    public void lockRendering() {
        if (this.mRoot != null) {
            this.mRoot.lockRenderThread();
        }
    }

    public void measure(int i, int i2) {
        if (i != this.mLastWidthSpec || i2 != this.mLastHeightSpec || (this.mViewFlags & 4) != 0) {
            this.mLastWidthSpec = i;
            this.mLastHeightSpec = i2;
            this.mViewFlags &= -3;
            onMeasure(i, i2);
            if ((this.mViewFlags & 2) == 0) {
                throw new IllegalStateException(getClass().getName() + " should call setMeasuredSize() in onMeasure()");
            }
        }
    }

    protected void onAttachToRoot(GLRoot gLRoot) {
        this.mRoot = gLRoot;
        int componentCount = getComponentCount();
        for (int i = 0; i < componentCount; i++) {
            getComponent(i).onAttachToRoot(gLRoot);
        }
    }

    protected void onDetachFromRoot() {
        int componentCount = getComponentCount();
        for (int i = 0; i < componentCount; i++) {
            getComponent(i).onDetachFromRoot();
        }
        this.mRoot = null;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    protected void onMeasure(int i, int i2) {
    }

    protected boolean onTouch(MotionEvent motionEvent) {
        return false;
    }

    protected void onVisibilityChanged(int i) {
        int componentCount = getComponentCount();
        for (int i2 = 0; i2 < componentCount; i2++) {
            GLView component = getComponent(i2);
            if (component.getVisibility() == 0) {
                component.onVisibilityChanged(i);
            }
        }
    }

    public void removeAllComponents() {
        int size = this.mComponents.size();
        for (int i = 0; i < size; i++) {
            removeOneComponent((GLView) this.mComponents.get(i));
        }
        this.mComponents.clear();
    }

    public boolean removeComponent(GLView gLView) {
        if (this.mComponents == null || !this.mComponents.remove(gLView)) {
            return false;
        }
        removeOneComponent(gLView);
        return true;
    }

    protected void render(GLCanvas gLCanvas) {
        boolean z;
        int i = 0;
        if (this.mTransition == null || !this.mTransition.calculate(AnimationTime.get())) {
            z = false;
        } else {
            invalidate();
            z = this.mTransition.isActive();
        }
        renderBackground(gLCanvas);
        gLCanvas.save();
        if (z) {
            this.mTransition.applyContentTransform(this, gLCanvas);
        }
        int componentCount = getComponentCount();
        while (i < componentCount) {
            renderChild(gLCanvas, getComponent(i));
            i++;
        }
        gLCanvas.restore();
        if (z) {
            this.mTransition.applyOverlay(this, gLCanvas);
        }
    }

    protected void renderBackground(GLCanvas gLCanvas) {
        if (this.mBackgroundColor != null) {
            gLCanvas.clearBuffer(this.mBackgroundColor);
        }
        if (this.mTransition != null && this.mTransition.isActive()) {
            this.mTransition.applyBackground(this, gLCanvas);
        }
    }

    protected void renderChild(GLCanvas gLCanvas, GLView gLView) {
        if (gLView.getVisibility() == 0 || gLView.mAnimation != null) {
            int i = gLView.mBounds.left - this.mScrollX;
            int i2 = gLView.mBounds.top - this.mScrollY;
            gLCanvas.translate((float) i, (float) i2);
            CanvasAnimation canvasAnimation = gLView.mAnimation;
            if (canvasAnimation != null) {
                gLCanvas.save(canvasAnimation.getCanvasSaveFlags());
                if (canvasAnimation.calculate(AnimationTime.get())) {
                    invalidate();
                } else {
                    gLView.mAnimation = null;
                }
                canvasAnimation.apply(gLCanvas);
            }
            gLView.render(gLCanvas);
            if (canvasAnimation != null) {
                gLCanvas.restore();
            }
            gLCanvas.translate((float) (-i), (float) (-i2));
        }
    }

    public void requestLayout() {
        this.mViewFlags |= 4;
        this.mLastHeightSpec = -1;
        this.mLastWidthSpec = -1;
        if (this.mParent != null) {
            this.mParent.requestLayout();
            return;
        }
        GLRoot gLRoot = getGLRoot();
        if (gLRoot != null) {
            gLRoot.requestLayoutContentPane();
        }
    }

    public void setBackgroundColor(float[] fArr) {
        this.mBackgroundColor = fArr;
    }

    public void setIntroAnimation(StateTransitionAnimation stateTransitionAnimation) {
        this.mTransition = stateTransitionAnimation;
        if (this.mTransition != null) {
            this.mTransition.start();
        }
    }

    protected void setMeasuredSize(int i, int i2) {
        this.mViewFlags |= 2;
        this.mMeasuredWidth = i;
        this.mMeasuredHeight = i2;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (i == 0) {
                this.mViewFlags &= -2;
            } else {
                this.mViewFlags |= 1;
            }
            onVisibilityChanged(i);
            invalidate();
        }
    }

    public void startAnimation(CanvasAnimation canvasAnimation) {
        GLRoot gLRoot = getGLRoot();
        if (gLRoot == null) {
            throw new IllegalStateException();
        }
        this.mAnimation = canvasAnimation;
        if (this.mAnimation != null) {
            this.mAnimation.start();
            gLRoot.registerLaunchedAnimation(this.mAnimation);
        }
        invalidate();
    }

    public void unlockRendering() {
        if (this.mRoot != null) {
            this.mRoot.unlockRenderThread();
        }
    }
}
