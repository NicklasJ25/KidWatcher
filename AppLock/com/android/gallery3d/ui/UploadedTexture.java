package com.android.gallery3d.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLUtils;
import com.android.gallery3d.common.Utils;
import java.util.HashMap;
import javax.microedition.khronos.opengles.GL11;

abstract class UploadedTexture extends BasicTexture {
    private static final String TAG = "Texture";
    private static final int UPLOAD_LIMIT = 100;
    private static BorderKey sBorderKey = new BorderKey();
    private static HashMap<BorderKey, Bitmap> sBorderLines = new HashMap();
    static float[] sCropRect = new float[4];
    static int[] sTextureId = new int[1];
    private static int sUploadedCount;
    protected Bitmap mBitmap;
    private int mBorder;
    private boolean mContentValid;
    private boolean mIsUploading;
    private boolean mOpaque;
    private boolean mThrottled;

    private static class BorderKey implements Cloneable {
        public Config config;
        public int length;
        public boolean vertical;

        private BorderKey() {
        }

        public BorderKey clone() {
            try {
                return (BorderKey) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof BorderKey)) {
                return false;
            }
            BorderKey borderKey = (BorderKey) obj;
            return this.vertical == borderKey.vertical && this.config == borderKey.config && this.length == borderKey.length;
        }

        public int hashCode() {
            int hashCode = this.config.hashCode() ^ this.length;
            return this.vertical ? hashCode : -hashCode;
        }
    }

    protected UploadedTexture() {
        this(false);
    }

    protected UploadedTexture(boolean z) {
        super(null, 0, 0);
        this.mContentValid = true;
        this.mIsUploading = false;
        this.mOpaque = true;
        this.mThrottled = false;
        if (z) {
            setBorder(true);
            this.mBorder = 1;
        }
    }

    private void freeBitmap() {
        if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
            onFreeBitmap(this.mBitmap);
        }
        this.mBitmap = null;
    }

    private Bitmap getBitmap() {
        if (this.mBitmap == null) {
            this.mBitmap = onGetBitmap();
            int width = this.mBitmap.getWidth() + (this.mBorder * 2);
            int height = this.mBitmap.getHeight() + (this.mBorder * 2);
            if (this.mWidth == -1) {
                setSize(width, height);
            }
        }
        return this.mBitmap;
    }

    private static Bitmap getBorderLine(boolean z, Config config, int i) {
        BorderKey borderKey = sBorderKey;
        borderKey.vertical = z;
        borderKey.config = config;
        borderKey.length = i;
        Bitmap bitmap = (Bitmap) sBorderLines.get(borderKey);
        if (bitmap == null) {
            bitmap = z ? Bitmap.createBitmap(1, i, config) : Bitmap.createBitmap(i, 1, config);
            sBorderLines.put(borderKey.clone(), bitmap);
        }
        return bitmap;
    }

    public static void resetUploadLimit() {
        sUploadedCount = 0;
    }

    public static boolean uploadLimitReached() {
        return sUploadedCount > 100;
    }

    private void uploadToCanvas(GLCanvas gLCanvas) {
        GL11 gLInstance = gLCanvas.getGLInstance();
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i = (this.mBorder * 2) + width;
                i = (this.mBorder * 2) + height;
                int textureWidth = getTextureWidth();
                int textureHeight = getTextureHeight();
                boolean z = width <= textureWidth && height <= textureHeight;
                Utils.assertTrue(z);
                sCropRect[0] = (float) this.mBorder;
                sCropRect[1] = (float) (this.mBorder + height);
                sCropRect[2] = (float) width;
                sCropRect[3] = (float) (-height);
                GLId.glGenTextures(1, sTextureId, 0);
                gLInstance.glBindTexture(3553, sTextureId[0]);
                gLInstance.glTexParameterfv(3553, 35741, sCropRect, 0);
                gLInstance.glTexParameteri(3553, 10242, 33071);
                gLInstance.glTexParameteri(3553, 10243, 33071);
                gLInstance.glTexParameterf(3553, 10241, 9729.0f);
                gLInstance.glTexParameterf(3553, 10240, 9729.0f);
                if (width == textureWidth && height == textureHeight) {
                    GLUtils.texImage2D(3553, 0, bitmap, 0);
                } else {
                    int internalFormat = GLUtils.getInternalFormat(bitmap);
                    int type = GLUtils.getType(bitmap);
                    Config config = bitmap.getConfig();
                    gLInstance.glTexImage2D(3553, 0, internalFormat, textureWidth, textureHeight, 0, internalFormat, type, null);
                    GLUtils.texSubImage2D(3553, 0, this.mBorder, this.mBorder, bitmap, internalFormat, type);
                    if (this.mBorder > 0) {
                        GLUtils.texSubImage2D(3553, 0, 0, 0, getBorderLine(true, config, textureHeight), internalFormat, type);
                        GLUtils.texSubImage2D(3553, 0, 0, 0, getBorderLine(false, config, textureWidth), internalFormat, type);
                    }
                    if (this.mBorder + width < textureWidth) {
                        GLUtils.texSubImage2D(3553, 0, this.mBorder + width, 0, getBorderLine(true, config, textureHeight), internalFormat, type);
                    }
                    if (this.mBorder + height < textureHeight) {
                        GLUtils.texSubImage2D(3553, 0, 0, this.mBorder + height, getBorderLine(false, config, textureWidth), internalFormat, type);
                    }
                }
                freeBitmap();
                setAssociatedCanvas(gLCanvas);
                this.mId = sTextureId[0];
                this.mState = 1;
                this.mContentValid = true;
            } catch (Throwable th) {
                freeBitmap();
            }
        } else {
            this.mState = -1;
            throw new RuntimeException("Texture load fail, no bitmap");
        }
    }

    public int getHeight() {
        if (this.mWidth == -1) {
            getBitmap();
        }
        return this.mHeight;
    }

    protected int getTarget() {
        return 3553;
    }

    public int getWidth() {
        if (this.mWidth == -1) {
            getBitmap();
        }
        return this.mWidth;
    }

    protected void invalidateContent() {
        if (this.mBitmap != null) {
            freeBitmap();
        }
        this.mContentValid = false;
        this.mWidth = -1;
        this.mHeight = -1;
    }

    public boolean isContentValid() {
        return isLoaded() && this.mContentValid;
    }

    public boolean isOpaque() {
        return this.mOpaque;
    }

    public boolean isUploading() {
        return this.mIsUploading;
    }

    protected boolean onBind(GLCanvas gLCanvas) {
        updateContent(gLCanvas);
        return isContentValid();
    }

    protected abstract void onFreeBitmap(Bitmap bitmap);

    protected abstract Bitmap onGetBitmap();

    public void recycle() {
        super.recycle();
        if (this.mBitmap != null) {
            freeBitmap();
        }
    }

    protected void setIsUploading(boolean z) {
        this.mIsUploading = z;
    }

    public void setOpaque(boolean z) {
        this.mOpaque = z;
    }

    protected void setThrottled(boolean z) {
        this.mThrottled = z;
    }

    public void updateContent(GLCanvas gLCanvas) {
        if (!isLoaded()) {
            if (this.mThrottled) {
                int i = sUploadedCount + 1;
                sUploadedCount = i;
                if (i > 100) {
                    return;
                }
            }
            uploadToCanvas(gLCanvas);
        } else if (!this.mContentValid) {
            Bitmap bitmap = getBitmap();
            int internalFormat = GLUtils.getInternalFormat(bitmap);
            int type = GLUtils.getType(bitmap);
            gLCanvas.getGLInstance().glBindTexture(3553, this.mId);
            GLUtils.texSubImage2D(3553, 0, this.mBorder, this.mBorder, bitmap, internalFormat, type);
            freeBitmap();
            this.mContentValid = true;
        }
    }
}
