package com.domobile.applock.theme;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.domobile.applock.R;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;

public class SpaceNumBoardInitialer extends BestNumBoardInitialer {
    private void m2327a(View view, String str) {
        TextView textView = (TextView) view.findViewById(R.id.numboard_pwd_edittext);
        if (textView != null) {
            textView.setTextColor(Color.parseColor(C1147a.m2480a("#", str)));
            textView.setHintTextColor(Color.parseColor(C1147a.m2480a("#77", str)));
        }
    }

    public void mo2487a(final Context context, final View view, Resources resources, boolean z, boolean z2) {
        String a = mo2486a(context);
        if (a.equals("com.domobile.aut.bnightclub")) {
            C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_appinfo), (int) R.style.style_appinfo_older_nightclub);
            C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_appicon_imageview), (int) R.style.style_appicon_older_nightcliub);
            C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_appicon_slot), (int) R.style.style_iconslot_older_nightcliub);
            C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_edittext_bg), (int) R.style.style_edittext_bgview_older_rect);
            C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_pwd_edittext), (int) R.style.style_password_older_nightclub);
        } else if (a.equals("com.domobile.aut.bxmas")) {
            if (!z) {
                m2327a(view, "c5a786");
                C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_edittext_bg), (int) R.style.style_edittext_bgview_older_rect);
            }
            r0 = view.findViewById(R.id.numboard_below_appinfo);
            if (z2) {
                r0.setVisibility(8);
                return;
            }
            C1102c.m2388a(context, context.getResources(), r0, (int) R.style.style_banner_older_xmas);
            C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_appinfo), (int) R.style.style_appinfo_older_xmas);
            C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_appicon_slot), (int) R.style.style_iconslot_older_xmas);
        } else if (a.equals("com.domobile.aut.bmerryxmas")) {
            C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_appicon_imageview), (int) R.style.style_appicon_older_merryxmas);
        } else if (a.equals("com.domobile.aut.bwhite")) {
            C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_pwd_edittext), (int) R.style.style_password_textcolor_white);
            C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_edittext_bg), (int) R.style.style_edittext_bgview_older_rect);
        } else if (a.equals("com.domobile.aut.bsnowman")) {
            if (z2) {
                C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_appicon_slot), (int) R.style.style_iconslot_older_snowman);
            }
            C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_pwd_edittext), (int) R.style.style_password_textcolor_white);
        } else if (a.equals("com.domobile.aut.bhalloween")) {
            if (!z2) {
                C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_appinfo), (int) R.style.style_appinfo_older_halloween);
            }
            C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_appicon_slot), (int) R.style.style_iconslot_older_halloween);
            C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_pwd_edittext), (int) R.style.style_password_older_halloween);
        } else if (!a.equals("com.domobile.aut.bgalaxy")) {
            C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_appicon_slot), (int) R.style.style_iconslot_older_space);
            if (z) {
                r0 = view.findViewById(R.id.numboard_below_appinfo);
                view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                    final /* synthetic */ SpaceNumBoardInitialer f2056d;

                    public void onGlobalLayout() {
                        C1148d.m2515a(view.getViewTreeObserver(), (OnGlobalLayoutListener) this);
                        int i = view.getWidth() < view.getHeight() ? 1 : 0;
                        r0.setVisibility(i != 0 ? 0 : 8);
                        if (i != 0) {
                            C1102c.m2393a(r0, 0, ((int) (((double) view.getHeight()) * 0.4d)) - C1148d.m2498a(context, 10.0f), 0, 0);
                        }
                    }
                });
                return;
            }
            View findViewById = view.findViewById(R.id.numboard_edittext_bg);
            if (!z2) {
                C1102c.m2384a(findViewById, -10, C1148d.m2498a(context, 70.0f));
            }
            C1102c.m2388a(context, context.getResources(), findViewById, (int) R.style.style_edittext_bgview_older_rect);
            if (a.equals("com.domobile.aut.bthanksgiving")) {
                m2327a(view, "c06809");
            }
            findViewById = view.findViewById(R.id.numboard_below_appinfo);
            C1102c.m2388a(context, context.getResources(), view.findViewById(R.id.numboard_below_appinfo), (int) R.style.style_appinfo_older_space);
            findViewById.setVisibility(z2 ? 8 : 0);
        }
    }
}
