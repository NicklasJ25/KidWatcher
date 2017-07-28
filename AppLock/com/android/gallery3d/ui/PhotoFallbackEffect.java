package com.android.gallery3d.ui;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.android.gallery3d.anim.Animation;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.ui.AlbumSlotRenderer.SlotFilter;
import java.util.ArrayList;

public class PhotoFallbackEffect extends Animation implements SlotFilter {
    private static final int ANIM_DURATION = 300;
    private static final Interpolator ANIM_INTERPOLATE = new DecelerateInterpolator(1.5f);
    private ArrayList<Entry> mList = new ArrayList();
    private PositionProvider mPositionProvider;
    private float mProgress;
    private RectF mSource = new RectF();
    private RectF mTarget = new RectF();

    public interface PositionProvider {
        int getItemIndex(Path path);

        Rect getPosition(int i);
    }

    public static class Entry {
        public Rect dest;
        public int index;
        public Path path;
        public Rect source;
        public RawTexture texture;

        public Entry(Path path, Rect rect, RawTexture rawTexture) {
            this.path = path;
            this.source = rect;
            this.texture = rawTexture;
        }
    }

    public PhotoFallbackEffect() {
        setDuration(ANIM_DURATION);
        setInterpolator(ANIM_INTERPOLATE);
    }

    private void drawEntry(GLCanvas gLCanvas, Entry entry) {
        if (entry.texture.isLoaded()) {
            int width = entry.texture.getWidth();
            int height = entry.texture.getHeight();
            Rect rect = entry.source;
            Rect rect2 = entry.dest;
            float f = this.mProgress;
            float height2 = ((((float) rect2.height()) / ((float) Math.min(rect.width(), rect.height()))) * f) + (1.0f * (1.0f - f));
            float centerX = (((float) rect2.centerX()) * f) + (((float) rect.centerX()) * (1.0f - f));
            float centerY = (((float) rect2.centerY()) * f) + (((float) rect.centerY()) * (1.0f - f));
            float height3 = ((float) rect.height()) * height2;
            float width2 = ((float) rect.width()) * height2;
            if (width > height) {
                this.mTarget.set(centerX - (height3 / 2.0f), centerY - (height3 / 2.0f), (height3 / 2.0f) + centerX, (height3 / 2.0f) + centerY);
                this.mSource.set((float) ((width - height) / 2), 0.0f, (float) ((width + height) / 2), (float) height);
                gLCanvas.drawTexture(entry.texture, this.mSource, this.mTarget);
                gLCanvas.save(1);
                gLCanvas.multiplyAlpha(1.0f - f);
                this.mTarget.set(centerX - (width2 / 2.0f), centerY - (height3 / 2.0f), centerX - (height3 / 2.0f), (height3 / 2.0f) + centerY);
                this.mSource.set(0.0f, 0.0f, (float) ((width - height) / 2), (float) height);
                gLCanvas.drawTexture(entry.texture, this.mSource, this.mTarget);
                this.mTarget.set((height3 / 2.0f) + centerX, centerY - (height3 / 2.0f), (width2 / 2.0f) + centerX, centerY + (height3 / 2.0f));
                this.mSource.set((float) ((width + height) / 2), 0.0f, (float) width, (float) height);
                gLCanvas.drawTexture(entry.texture, this.mSource, this.mTarget);
                gLCanvas.restore();
                return;
            }
            this.mTarget.set(centerX - (width2 / 2.0f), centerY - (width2 / 2.0f), (width2 / 2.0f) + centerX, (width2 / 2.0f) + centerY);
            this.mSource.set(0.0f, (float) ((height - width) / 2), (float) width, (float) ((height + width) / 2));
            gLCanvas.drawTexture(entry.texture, this.mSource, this.mTarget);
            gLCanvas.save(1);
            gLCanvas.multiplyAlpha(1.0f - f);
            this.mTarget.set(centerX - (width2 / 2.0f), centerY - (height3 / 2.0f), (width2 / 2.0f) + centerX, centerY - (width2 / 2.0f));
            this.mSource.set(0.0f, 0.0f, (float) width, (float) ((height - width) / 2));
            gLCanvas.drawTexture(entry.texture, this.mSource, this.mTarget);
            this.mTarget.set(centerX - (width2 / 2.0f), (width2 / 2.0f) + centerY, (width2 / 2.0f) + centerX, centerY + (height3 / 2.0f));
            this.mSource.set(0.0f, (float) ((width + height) / 2), (float) width, (float) height);
            gLCanvas.drawTexture(entry.texture, this.mSource, this.mTarget);
            gLCanvas.restore();
        }
    }

    public boolean acceptSlot(int i) {
        int size = this.mList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((Entry) this.mList.get(i2)).index == i) {
                return false;
            }
        }
        return true;
    }

    public void addEntry(Path path, Rect rect, RawTexture rawTexture) {
        this.mList.add(new Entry(path, rect, rawTexture));
    }

    public boolean draw(GLCanvas gLCanvas) {
        boolean calculate = calculate(AnimationTime.get());
        int size = this.mList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) this.mList.get(i);
            if (entry.index >= 0) {
                entry.dest = this.mPositionProvider.getPosition(entry.index);
                drawEntry(gLCanvas, entry);
            }
        }
        return calculate;
    }

    public Entry getEntry(Path path) {
        int size = this.mList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) this.mList.get(i);
            if (entry.path == path) {
                return entry;
            }
        }
        return null;
    }

    protected void onCalculate(float f) {
        this.mProgress = f;
    }

    public void setPositionProvider(PositionProvider positionProvider) {
        this.mPositionProvider = positionProvider;
        if (this.mPositionProvider != null) {
            int size = this.mList.size();
            for (int i = 0; i < size; i++) {
                Entry entry = (Entry) this.mList.get(i);
                entry.index = this.mPositionProvider.getItemIndex(entry.path);
            }
        }
    }
}
