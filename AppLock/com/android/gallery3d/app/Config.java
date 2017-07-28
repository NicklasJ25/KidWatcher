package com.android.gallery3d.app;

import android.content.Context;
import android.content.res.Resources;
import com.android.gallery3d.C0488R;
import com.android.gallery3d.ui.AlbumSetSlotRenderer.LabelSpec;
import com.android.gallery3d.ui.SlotView.Spec;

public final class Config {
    public static final long MAX_SHARE_SIZE = 20971520;

    public static class AlbumPage {
        private static AlbumPage sInstance;
        public int placeholderColor;
        public Spec slotViewSpec = new Spec();

        private AlbumPage(Context context) {
            Resources resources = context.getResources();
            this.placeholderColor = resources.getColor(C0488R.color.album_placeholder);
            this.slotViewSpec.rowsLand = resources.getInteger(C0488R.integer.album_rows_land);
            this.slotViewSpec.rowsPort = resources.getInteger(C0488R.integer.album_rows_port);
            this.slotViewSpec.slotGap = resources.getDimensionPixelSize(C0488R.dimen.album_slot_gap);
        }

        public static synchronized AlbumPage get(Context context) {
            AlbumPage albumPage;
            synchronized (AlbumPage.class) {
                if (sInstance == null) {
                    sInstance = new AlbumPage(context);
                }
                albumPage = sInstance;
            }
            return albumPage;
        }
    }

    public static class AlbumSetPage {
        private static AlbumSetPage sInstance;
        public LabelSpec labelSpec;
        public int paddingBottom;
        public int paddingTop;
        public int placeholderColor;
        public Spec slotViewSpec;

        private AlbumSetPage(Context context) {
            Resources resources = context.getResources();
            this.placeholderColor = resources.getColor(C0488R.color.albumset_placeholder);
            this.slotViewSpec = new Spec();
            this.slotViewSpec.rowsLand = resources.getInteger(C0488R.integer.albumset_rows_land);
            this.slotViewSpec.rowsPort = resources.getInteger(C0488R.integer.albumset_rows_port);
            this.slotViewSpec.slotGap = resources.getDimensionPixelSize(C0488R.dimen.albumset_slot_gap);
            this.slotViewSpec.slotHeightAdditional = 0;
            this.paddingTop = resources.getDimensionPixelSize(C0488R.dimen.albumset_padding_top);
            this.paddingBottom = resources.getDimensionPixelSize(C0488R.dimen.albumset_padding_bottom);
            this.labelSpec = new LabelSpec();
            this.labelSpec.labelBackgroundHeight = resources.getDimensionPixelSize(C0488R.dimen.albumset_label_background_height);
            this.labelSpec.titleOffset = resources.getDimensionPixelSize(C0488R.dimen.albumset_title_offset);
            this.labelSpec.countOffset = resources.getDimensionPixelSize(C0488R.dimen.albumset_count_offset);
            this.labelSpec.titleFontSize = resources.getDimensionPixelSize(C0488R.dimen.albumset_title_font_size);
            this.labelSpec.countFontSize = resources.getDimensionPixelSize(C0488R.dimen.albumset_count_font_size);
            this.labelSpec.leftMargin = resources.getDimensionPixelSize(C0488R.dimen.albumset_left_margin);
            this.labelSpec.titleRightMargin = resources.getDimensionPixelSize(C0488R.dimen.albumset_title_right_margin);
            this.labelSpec.iconSize = resources.getDimensionPixelSize(C0488R.dimen.albumset_icon_size);
            this.labelSpec.backgroundColor = resources.getColor(C0488R.color.albumset_label_background);
            this.labelSpec.titleColor = resources.getColor(C0488R.color.albumset_label_title);
            this.labelSpec.countColor = resources.getColor(C0488R.color.albumset_label_count);
        }

        public static synchronized AlbumSetPage get(Context context) {
            AlbumSetPage albumSetPage;
            synchronized (AlbumSetPage.class) {
                if (sInstance == null) {
                    sInstance = new AlbumSetPage(context);
                }
                albumSetPage = sInstance;
            }
            return albumSetPage;
        }
    }

    public static class ManageCachePage extends AlbumSetPage {
        private static ManageCachePage sInstance;
        public final int cachePinMargin;
        public final int cachePinSize;

        public ManageCachePage(Context context) {
            super(context);
            Resources resources = context.getResources();
            this.cachePinSize = resources.getDimensionPixelSize(C0488R.dimen.cache_pin_size);
            this.cachePinMargin = resources.getDimensionPixelSize(C0488R.dimen.cache_pin_margin);
        }

        public static synchronized ManageCachePage get(Context context) {
            ManageCachePage manageCachePage;
            synchronized (ManageCachePage.class) {
                if (sInstance == null) {
                    sInstance = new ManageCachePage(context);
                }
                manageCachePage = sInstance;
            }
            return manageCachePage;
        }
    }
}
