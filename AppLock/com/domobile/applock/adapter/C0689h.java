package com.domobile.applock.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.domobile.applock.R;

public class C0689h extends ViewHolder {
    public TextView f764a;
    public TextView f765b;
    public LinearLayout f766c;
    public ImageView f767d;
    public ImageView f768e;
    public TextView f769f;
    public TextView f770g;
    public TextView f771h;
    public TextView f772i;
    public ViewGroup f773j;
    public ViewGroup f774k;
    public SwitchCompat f775l;
    public View f776m;

    public C0689h(View view) {
        super(view);
        this.f764a = (TextView) view.findViewById(R.id.timer_item_name_editor);
        this.f765b = (TextView) view.findViewById(R.id.timer_item_time);
        this.f766c = (LinearLayout) view.findViewById(R.id.timer_item_summary);
        this.f767d = (ImageView) view.findViewById(R.id.timer_item_delete);
        this.f768e = (ImageView) view.findViewById(R.id.timer_item_expand);
        this.f775l = (SwitchCompat) view.findViewById(R.id.timer_item_switch);
        this.f770g = (TextView) view.findViewById(R.id.timer_item_action);
        this.f769f = (TextView) view.findViewById(R.id.timer_item_action_label);
        this.f772i = (TextView) view.findViewById(R.id.timer_item_action_out);
        this.f771h = (TextView) view.findViewById(R.id.timer_item_action_out_label);
        this.f773j = (ViewGroup) view.findViewById(R.id.timer_item_weekdays);
        this.f774k = (ViewGroup) view.findViewById(R.id.timer_item_weekdays_layout);
        this.f776m = view.findViewById(R.id.divider);
        view.setTag(R.id.tag_object, this);
    }
}
