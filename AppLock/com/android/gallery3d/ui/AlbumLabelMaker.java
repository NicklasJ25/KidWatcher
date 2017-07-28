package com.android.gallery3d.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.android.gallery3d.C0488R;
import com.android.gallery3d.data.BitmapPool;
import com.android.gallery3d.ui.AlbumSetSlotRenderer.LabelSpec;
import com.android.gallery3d.util.ThreadPool.Job;
import com.android.gallery3d.util.ThreadPool.JobContext;

public class AlbumLabelMaker {
    private static final int BORDER_SIZE = 0;
    private BitmapPool mBitmapPool;
    private final LazyLoadedBitmap mCameraIcon = new LazyLoadedBitmap(C0488R.drawable.transparent);
    private final Context mContext;
    private final TextPaint mCountPaint;
    private int mLabelWidth;
    private final LazyLoadedBitmap mLocalSetIcon = new LazyLoadedBitmap(C0488R.drawable.transparent);
    private final LazyLoadedBitmap mMtpIcon = new LazyLoadedBitmap(C0488R.drawable.transparent);
    private final LazyLoadedBitmap mPicasaIcon = new LazyLoadedBitmap(C0488R.drawable.transparent);
    private final LabelSpec mSpec;
    private final TextPaint mTitlePaint;

    private class AlbumLabelJob implements Job<Bitmap> {
        private final String mCount;
        private final int mSourceType;
        private final String mTitle;

        public AlbumLabelJob(String str, String str2, int i) {
            this.mTitle = str;
            this.mCount = str2;
            this.mSourceType = i;
        }

        public Bitmap run(JobContext jobContext) {
            int access$300;
            Bitmap bitmap;
            LabelSpec access$100 = AlbumLabelMaker.this.mSpec;
            String str = this.mTitle;
            String str2 = this.mCount;
            Bitmap access$200 = AlbumLabelMaker.this.getOverlayAlbumIcon(this.mSourceType);
            synchronized (this) {
                access$300 = AlbumLabelMaker.this.mLabelWidth;
                bitmap = AlbumLabelMaker.this.mBitmapPool.getBitmap();
            }
            Bitmap createBitmap = bitmap == null ? Bitmap.createBitmap(access$300 + 0, access$100.labelBackgroundHeight + 0, Config.ARGB_8888) : bitmap;
            Canvas canvas = new Canvas(createBitmap);
            canvas.clipRect(0, 0, createBitmap.getWidth() + 0, createBitmap.getHeight() + 0);
            canvas.drawColor(AlbumLabelMaker.this.mSpec.backgroundColor, Mode.SRC);
            canvas.translate(0.0f, 0.0f);
            if (jobContext.isCancelled()) {
                return null;
            }
            int i = access$100.leftMargin + access$100.iconSize;
            AlbumLabelMaker.drawText(canvas, i, (access$100.labelBackgroundHeight - access$100.titleFontSize) / 2, str, ((access$300 - access$100.leftMargin) - i) - access$100.titleRightMargin, AlbumLabelMaker.this.mTitlePaint);
            if (jobContext.isCancelled()) {
                return null;
            }
            i = access$300 - access$100.titleRightMargin;
            AlbumLabelMaker.drawText(canvas, i, (access$100.labelBackgroundHeight - access$100.countFontSize) / 2, str2, access$300 - i, AlbumLabelMaker.this.mCountPaint);
            if (access$200 == null) {
                return createBitmap;
            }
            if (jobContext.isCancelled()) {
                return null;
            }
            float width = ((float) access$100.iconSize) / ((float) access$200.getWidth());
            canvas.translate((float) access$100.leftMargin, ((float) (access$100.labelBackgroundHeight - Math.round(((float) access$200.getHeight()) * width))) / 2.0f);
            canvas.scale(width, width);
            canvas.drawBitmap(access$200, 0.0f, 0.0f, null);
            return createBitmap;
        }
    }

    private class LazyLoadedBitmap {
        private Bitmap mBitmap;
        private int mResId;

        public LazyLoadedBitmap(int i) {
            this.mResId = i;
        }

        public synchronized Bitmap get() {
            if (this.mBitmap == null) {
                Options options = new Options();
                options.inPreferredConfig = Config.ARGB_8888;
                this.mBitmap = BitmapFactory.decodeResource(AlbumLabelMaker.this.mContext.getResources(), this.mResId, options);
            }
            return this.mBitmap;
        }
    }

    public AlbumLabelMaker(Context context, LabelSpec labelSpec) {
        this.mContext = context;
        this.mSpec = labelSpec;
        this.mTitlePaint = getTextPaint(labelSpec.titleFontSize, labelSpec.titleColor, false);
        this.mCountPaint = getTextPaint(labelSpec.countFontSize, labelSpec.countColor, false);
    }

    static void drawText(Canvas canvas, int i, int i2, String str, int i3, TextPaint textPaint) {
        synchronized (textPaint) {
            canvas.drawText(TextUtils.ellipsize(str, textPaint, (float) i3, TruncateAt.END).toString(), (float) i, (float) (i2 - textPaint.getFontMetricsInt().ascent), textPaint);
        }
    }

    public static int getBorderSize() {
        return 0;
    }

    private Bitmap getOverlayAlbumIcon(int i) {
        switch (i) {
            case 1:
                return this.mLocalSetIcon.get();
            case 2:
                return this.mPicasaIcon.get();
            case 3:
                return this.mMtpIcon.get();
            case 4:
                return this.mCameraIcon.get();
            default:
                return null;
        }
    }

    private static TextPaint getTextPaint(int i, int i2, boolean z) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize((float) i);
        textPaint.setAntiAlias(true);
        textPaint.setColor(i2);
        if (z) {
            textPaint.setTypeface(Typeface.defaultFromStyle(1));
        }
        return textPaint;
    }

    public void clearRecycledLabels() {
        if (this.mBitmapPool != null) {
            this.mBitmapPool.clear();
        }
    }

    public void recycleLabel(Bitmap bitmap) {
        this.mBitmapPool.recycle(bitmap);
    }

    public Job<Bitmap> requestLabel(String str, String str2, int i) {
        return new AlbumLabelJob(str, str2, i);
    }

    public synchronized void setLabelWidth(int i) {
        if (this.mLabelWidth != i) {
            this.mLabelWidth = i;
            this.mBitmapPool = new BitmapPool(i + 0, 0 + this.mSpec.labelBackgroundHeight, 16);
        }
    }
}
