package com.android.gallery3d.ui;

public class FadeInTexture extends FadeTexture implements Texture {
    private static final String TAG = "FadeInTexture";
    private final int mColor;
    private final TiledTexture mTexture;

    public FadeInTexture(int i, TiledTexture tiledTexture) {
        super(tiledTexture.getWidth(), tiledTexture.getHeight(), tiledTexture.isOpaque());
        this.mColor = i;
        this.mTexture = tiledTexture;
    }

    public void draw(GLCanvas gLCanvas, int i, int i2, int i3, int i4) {
        if (isAnimating()) {
            this.mTexture.drawMixed(gLCanvas, this.mColor, getRatio(), i, i2, i3, i4);
            return;
        }
        this.mTexture.draw(gLCanvas, i, i2, i3, i4);
    }
}
