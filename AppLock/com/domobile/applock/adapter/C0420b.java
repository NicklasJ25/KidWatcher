package com.domobile.applock.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import com.domobile.applock.R;

public abstract class C0420b extends C0419f {
    public static int m168a(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.image_gallery_item_space);
        return (displayMetrics.widthPixels - dimensionPixelOffset) / (resources.getDimensionPixelSize(R.dimen.image_gallery_item_height) + dimensionPixelOffset);
    }

    public static final void m169a(RecyclerView recyclerView, int i) {
        try {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            if (i != gridLayoutManager.getSpanCount()) {
                recyclerView.removeAllViews();
                recyclerView.getRecycledViewPool().clear();
                gridLayoutManager.setSpanCount(i);
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        } catch (Exception e) {
        }
    }

    public static int m170b(Context context) {
        int a = C0420b.m168a(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (displayMetrics.widthPixels - context.getResources().getDimensionPixelOffset(R.dimen.image_gallery_item_space)) / a;
    }
}
