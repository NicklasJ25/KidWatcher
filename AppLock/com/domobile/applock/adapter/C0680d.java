package com.domobile.applock.adapter;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import com.domobile.applock.R;
import com.domobile.frame.http.image.CacheImageView;
import com.domobile.widget.AppLockSwitch;

public class C0680d extends ViewHolder {
    public TextView f721i;
    public TextView f722j;
    public TextView f723k;
    public CacheImageView f724l;
    public AppLockSwitch f725m;
    public View f726n;
    public View f727o;

    public C0680d(View view) {
        super(view);
        try {
            this.f721i = (TextView) view.findViewById(R.id.list_item_group_title);
            this.f722j = (TextView) view.findViewById(R.id.list_item_name);
            this.f723k = (TextView) view.findViewById(R.id.list_item_size);
            this.f724l = (CacheImageView) view.findViewById(R.id.list_item_icon);
            this.f724l.m3043a(ResourcesCompat.getDrawable(view.getResources(), 17301651, null));
            this.f724l.setAdjustViewBounds(true);
            this.f725m = (AppLockSwitch) view.findViewById(R.id.list_item_permission);
            this.f727o = view.findViewById(R.id.list_item_footer);
            this.f726n = view.findViewById(R.id.list_item_group_margin);
        } catch (Exception e) {
        }
    }
}
