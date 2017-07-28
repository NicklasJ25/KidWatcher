package com.domobile.applock.theme;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.view.View;
import com.domobile.applock.R;
import com.domobile.frame.p000a.C1148d;

public class GirlsNumBoardInitialer extends BestNumBoardInitialer {
    public void mo2487a(Context context, View view, Resources resources, boolean z, boolean z2) {
        C1148d.m2514a(view.findViewById(R.id.numboard_whole_layout), C1148d.m2501a(context, BitmapFactory.decodeResource(resources, R.drawable.num_background)));
        C1148d.m2514a(view.findViewById(R.id.numboard_below_appinfo), C1148d.m2501a(context, BitmapFactory.decodeResource(resources, R.drawable.num_banner)));
        C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_below_appinfo), (int) R.style.style_banner_older_girls);
        C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_appinfo), (int) R.style.style_appinfo_older_girls);
        C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_appicon_slot), (int) R.style.style_iconslot_older_girls);
        C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_edittext_bg), (int) R.style.style_edittext_bgview_older_rect);
    }
}
