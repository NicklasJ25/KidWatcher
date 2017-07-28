package com.domobile.applock.theme;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.percent.PercentLayoutHelper.PercentLayoutInfo;
import android.support.percent.PercentLayoutHelper.PercentLayoutParams;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.theme.ThemePickerFragment.ThemeBean;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import java.io.File;
import org.apache.p068a.p069a.C3613c;
import org.json.JSONArray;
import org.json.JSONObject;

public class C1102c {
    public static int m2378a(Context context, TypedArray typedArray, Resources resources, int i) {
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        if (typedValue.resourceId <= 0) {
            return typedValue.data;
        }
        try {
            return resources.getColor(typedValue.resourceId);
        } catch (Exception e) {
            return context.getResources().getColor(typedValue.resourceId);
        }
    }

    public static int m2379a(TypedArray typedArray, int i) {
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type == 16 ? typedValue.data : typedArray.getDimensionPixelSize(i, -10);
    }

    public static int m2380a(boolean z, int i) {
        return i == 1 ? z ? R.layout.best_numboard_land : R.layout.best_numboard : i == 2 ? z ? R.layout.best_pattern_board_land : R.layout.best_pattern_board : 0;
    }

    public static XmlResourceParser m2381a(Context context, String str, int i) {
        try {
            return context.getPackageManager().getResourcesForApplication(str).getLayout(i);
        } catch (Exception e) {
            C1147a.m2482b("未安装皮肤包或皮肤包中没有对应的Layout资源：", str);
            return context.getResources().getLayout(i);
        }
    }

    public static Drawable m2382a(Context context, Resources resources, int i) {
        try {
            return C1148d.m2502a(resources, i);
        } catch (Exception e) {
            return C1148d.m2502a(context.getResources(), i);
        }
    }

    public static LayoutParams m2383a(View view, float f, float f2) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof PercentLayoutParams) {
            PercentLayoutInfo percentLayoutInfo = ((PercentLayoutParams) layoutParams).getPercentLayoutInfo();
            if (f2 != -10.0f) {
                percentLayoutInfo.heightPercent = f2;
            }
            if (f != -10.0f) {
                percentLayoutInfo.widthPercent = f;
            }
            view.setLayoutParams(layoutParams);
        }
        return layoutParams;
    }

    public static LayoutParams m2384a(View view, int i, int i2) {
        if (view == null) {
            return null;
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (i2 != -10) {
            layoutParams.height = i2;
        }
        if (i != -10) {
            layoutParams.width = i;
        }
        view.setLayoutParams(layoutParams);
        return layoutParams;
    }

    public static String m2385a(Context context) {
        if (C1150y.m2643m(context)) {
            return context.getPackageName();
        }
        String a = C1102c.m2386a(context, "applock_themepkg", context.getPackageName());
        if (C1102c.m2394a(context.getPackageManager(), a)) {
            return a;
        }
        C1102c.m2409g(context, "applock_themepkg");
        return context.getPackageName();
    }

    public static String m2386a(Context context, String str, String str2) {
        return context.getSharedPreferences("applock_theme", 0).getString(str, str2);
    }

    public static void m2387a(Context context, Resources resources, View view) {
        if (view != null) {
            try {
                if (view.getTag() != null) {
                    C1102c.m2388a(context, resources, view, Integer.parseInt(view.getTag().toString().substring(2), 16));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m2388a(android.content.Context r14, android.content.res.Resources r15, android.view.View r16, int r17) {
        /*
        if (r15 == 0) goto L_0x0006;
    L_0x0002:
        if (r16 == 0) goto L_0x0006;
    L_0x0004:
        if (r14 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r7 = r16.getPaddingLeft();
        r6 = r16.getPaddingRight();
        r5 = r16.getPaddingTop();
        r4 = r16.getPaddingBottom();
        r0 = r17;
        r15.getResourceName(r0);	 Catch:{ Exception -> 0x0044 }
        r1 = r15.newTheme();	 Catch:{ Exception -> 0x0044 }
        r2 = com.domobile.applock.C1140x.C1139g.CustomeUnlockSkinView;	 Catch:{ Exception -> 0x0044 }
        r0 = r17;
        r1 = r1.obtainStyledAttributes(r0, r2);	 Catch:{ Exception -> 0x0044 }
        r3 = r1;
    L_0x0029:
        r1 = 0;
        r9 = r3.getIndexCount();
        r8 = r1;
    L_0x002f:
        if (r8 >= r9) goto L_0x0290;
    L_0x0031:
        r10 = r3.getIndex(r8);
        switch(r10) {
            case 0: goto L_0x00bf;
            case 1: goto L_0x007a;
            case 2: goto L_0x008b;
            case 3: goto L_0x01ac;
            case 4: goto L_0x0163;
            case 5: goto L_0x00d6;
            case 6: goto L_0x0114;
            case 7: goto L_0x0127;
            case 8: goto L_0x0136;
            case 9: goto L_0x0145;
            case 10: goto L_0x0155;
            case 11: goto L_0x0262;
            case 12: goto L_0x018a;
            case 13: goto L_0x019b;
            case 14: goto L_0x01dc;
            case 15: goto L_0x01ec;
            case 16: goto L_0x01ff;
            case 17: goto L_0x0212;
            case 18: goto L_0x0225;
            case 19: goto L_0x00f8;
            case 20: goto L_0x004f;
            case 21: goto L_0x0064;
            case 22: goto L_0x0272;
            case 23: goto L_0x0238;
            case 24: goto L_0x024d;
            default: goto L_0x0038;
        };
    L_0x0038:
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
    L_0x003c:
        r6 = r8 + 1;
        r8 = r6;
        r7 = r5;
        r5 = r2;
        r6 = r4;
        r4 = r1;
        goto L_0x002f;
    L_0x0044:
        r1 = move-exception;
        r1 = com.domobile.applock.C1140x.C1139g.CustomeUnlockSkinView;
        r0 = r17;
        r1 = r14.obtainStyledAttributes(r0, r1);
        r3 = r1;
        goto L_0x0029;
    L_0x004f:
        r1 = -1;
        r2 = r3.getResourceId(r10, r1);
        r1 = r16;
        r1 = (android.widget.ImageView) r1;
        r2 = com.domobile.applock.theme.C1102c.m2382a(r14, r15, r2);
        r1.setImageDrawable(r2);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x0064:
        r0 = r16;
        r1 = r0 instanceof android.widget.ImageView;
        if (r1 == 0) goto L_0x0038;
    L_0x006a:
        r2 = com.domobile.applock.theme.C1102c.m2378a(r14, r3, r15, r10);
        r1 = r16;
        r1 = (android.widget.ImageView) r1;
        r1.setColorFilter(r2);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x007a:
        r1 = r16;
        r1 = (android.widget.TextView) r1;
        r2 = -1;
        r2 = r3.getColor(r10, r2);
        r1.setTextColor(r2);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x008b:
        r1 = 4;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r11 = "hint:";
        r1[r2] = r11;
        r2 = 1;
        r1[r2] = r16;
        r2 = 2;
        r11 = "  tag:";
        r1[r2] = r11;
        r2 = 3;
        r11 = java.lang.Integer.valueOf(r17);
        r1[r2] = r11;
        com.domobile.frame.p000a.C1147a.m2482b(r1);
        r0 = r16;
        r1 = r0 instanceof android.widget.TextView;
        if (r1 == 0) goto L_0x0038;
    L_0x00ab:
        r1 = -3355444; // 0xffffffffffcccccc float:NaN double:NaN;
        r2 = r3.getColor(r10, r1);
        r1 = r16;
        r1 = (android.widget.TextView) r1;
        r1.setHintTextColor(r2);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x00bf:
        r1 = -1;
        r2 = r3.getDimensionPixelSize(r10, r1);
        r1 = -1;
        if (r2 == r1) goto L_0x0038;
    L_0x00c7:
        r1 = r16;
        r1 = (android.widget.TextView) r1;
        r10 = 0;
        r2 = (float) r2;
        r1.setTextSize(r10, r2);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x00d6:
        r1 = -1;
        r2 = r3.getResourceId(r10, r1);
        r1 = com.domobile.applock.theme.C1102c.m2382a(r14, r15, r2);
        r10 = 2130837532; // 0x7f02001c float:1.728002E38 double:1.0527736214E-314;
        if (r2 != r10) goto L_0x00ed;
    L_0x00e4:
        if (r1 != 0) goto L_0x00ed;
    L_0x00e6:
        r1 = 2130837522; // 0x7f020012 float:1.728E38 double:1.0527736165E-314;
        r1 = com.domobile.applock.theme.C1102c.m2382a(r14, r15, r1);
    L_0x00ed:
        r0 = r16;
        com.domobile.frame.p000a.C1148d.m2514a(r0, r1);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x00f8:
        r1 = -1;
        r2 = r3.getResourceId(r10, r1);
        r0 = r16;
        r1 = r0 instanceof android.widget.FrameLayout;
        if (r1 == 0) goto L_0x0038;
    L_0x0103:
        r1 = r16;
        r1 = (android.widget.FrameLayout) r1;
        r2 = com.domobile.applock.theme.C1102c.m2382a(r14, r15, r2);
        r1.setForeground(r2);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x0114:
        r1 = -1;
        r1 = r3.getDimensionPixelSize(r10, r1);
        r2 = -1;
        if (r1 == r2) goto L_0x0038;
    L_0x011c:
        r0 = r16;
        r0.setPadding(r1, r1, r1, r1);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x0127:
        r1 = r3.getDimensionPixelSize(r10, r7);
        r0 = r16;
        r0.setPadding(r1, r5, r6, r4);
        r2 = r5;
        r5 = r1;
        r1 = r4;
        r4 = r6;
        goto L_0x003c;
    L_0x0136:
        r1 = r3.getDimensionPixelSize(r10, r5);
        r0 = r16;
        r0.setPadding(r7, r1, r6, r4);
        r2 = r1;
        r5 = r7;
        r1 = r4;
        r4 = r6;
        goto L_0x003c;
    L_0x0145:
        r1 = r3.getDimensionPixelSize(r10, r6);
        r0 = r16;
        r0.setPadding(r7, r5, r1, r4);
        r2 = r5;
        r5 = r7;
        r13 = r1;
        r1 = r4;
        r4 = r13;
        goto L_0x003c;
    L_0x0155:
        r1 = r3.getDimensionPixelSize(r10, r4);
        r0 = r16;
        r0.setPadding(r7, r5, r6, r1);
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x0163:
        r2 = r16.getLayoutParams();
        r1 = -1;
        r10 = r3.getInt(r10, r1);
        r1 = r2 instanceof android.widget.LinearLayout.LayoutParams;
        if (r1 == 0) goto L_0x0180;
    L_0x0170:
        r1 = r2;
        r1 = (android.widget.LinearLayout.LayoutParams) r1;
        r1.gravity = r10;
    L_0x0175:
        r0 = r16;
        r0.setLayoutParams(r2);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x0180:
        r1 = r2 instanceof android.widget.FrameLayout.LayoutParams;
        if (r1 == 0) goto L_0x0175;
    L_0x0184:
        r1 = r2;
        r1 = (android.widget.FrameLayout.LayoutParams) r1;
        r1.gravity = r10;
        goto L_0x0175;
    L_0x018a:
        r1 = com.domobile.applock.theme.C1102c.m2379a(r3, r10);
        r2 = -10;
        r0 = r16;
        com.domobile.applock.theme.C1102c.m2384a(r0, r1, r2);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x019b:
        r1 = -10;
        r2 = com.domobile.applock.theme.C1102c.m2379a(r3, r10);
        r0 = r16;
        com.domobile.applock.theme.C1102c.m2384a(r0, r1, r2);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x01ac:
        r0 = r16;
        r1 = r0 instanceof android.widget.LinearLayout;
        if (r1 == 0) goto L_0x01c4;
    L_0x01b2:
        r1 = r16;
        r1 = (android.widget.LinearLayout) r1;
        r2 = -1;
        r2 = r3.getInt(r10, r2);
        r1.setGravity(r2);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x01c4:
        r0 = r16;
        r1 = r0 instanceof android.widget.TextView;
        if (r1 == 0) goto L_0x0038;
    L_0x01ca:
        r1 = r16;
        r1 = (android.widget.TextView) r1;
        r2 = -1;
        r2 = r3.getInt(r10, r2);
        r1.setGravity(r2);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x01dc:
        r1 = -1;
        r1 = r3.getDimensionPixelSize(r10, r1);
        r0 = r16;
        com.domobile.applock.theme.C1102c.m2393a(r0, r1, r1, r1, r1);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x01ec:
        r1 = -1;
        r1 = r3.getDimensionPixelSize(r10, r1);
        r2 = -1;
        r10 = -1;
        r11 = -1;
        r0 = r16;
        com.domobile.applock.theme.C1102c.m2393a(r0, r1, r2, r10, r11);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x01ff:
        r1 = -1;
        r2 = -1;
        r2 = r3.getDimensionPixelSize(r10, r2);
        r10 = -1;
        r11 = -1;
        r0 = r16;
        com.domobile.applock.theme.C1102c.m2393a(r0, r1, r2, r10, r11);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x0212:
        r1 = -1;
        r2 = -1;
        r11 = -1;
        r10 = r3.getDimensionPixelSize(r10, r11);
        r11 = -1;
        r0 = r16;
        com.domobile.applock.theme.C1102c.m2393a(r0, r1, r2, r10, r11);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x0225:
        r1 = -1;
        r2 = -1;
        r11 = -1;
        r12 = -1;
        r10 = r3.getDimensionPixelSize(r10, r12);
        r0 = r16;
        com.domobile.applock.theme.C1102c.m2393a(r0, r1, r2, r11, r10);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x0238:
        r1 = 1;
        r2 = 1;
        r11 = -1054867456; // 0xffffffffc1200000 float:-10.0 double:NaN;
        r1 = r3.getFraction(r10, r1, r2, r11);
        r2 = -1054867456; // 0xffffffffc1200000 float:-10.0 double:NaN;
        r0 = r16;
        com.domobile.applock.theme.C1102c.m2383a(r0, r1, r2);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x024d:
        r1 = -1054867456; // 0xffffffffc1200000 float:-10.0 double:NaN;
        r2 = 1;
        r11 = 1;
        r12 = -1054867456; // 0xffffffffc1200000 float:-10.0 double:NaN;
        r2 = r3.getFraction(r10, r2, r11, r12);
        r0 = r16;
        com.domobile.applock.theme.C1102c.m2383a(r0, r1, r2);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x0262:
        r1 = 0;
        r1 = r3.getInt(r10, r1);
        r0 = r16;
        r0.setVisibility(r1);
        r1 = r4;
        r2 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x003c;
    L_0x0272:
        r2 = r16.getLayoutParams();
        r1 = r2 instanceof android.widget.RelativeLayout.LayoutParams;
        if (r1 == 0) goto L_0x0038;
    L_0x027a:
        r1 = 0;
        r1 = r3.getBoolean(r10, r1);
        if (r1 == 0) goto L_0x0289;
    L_0x0281:
        r1 = r2;
        r1 = (android.widget.RelativeLayout.LayoutParams) r1;
        r10 = 12;
        r1.addRule(r10);
    L_0x0289:
        r0 = r16;
        r0.setLayoutParams(r2);
        goto L_0x0038;
    L_0x0290:
        if (r3 == 0) goto L_0x0006;
    L_0x0292:
        r3.recycle();
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.domobile.applock.theme.c.a(android.content.Context, android.content.res.Resources, android.view.View, int):void");
    }

    public static void m2389a(Context context, ImageView imageView, String str, int i) {
        C1148d.m2514a((View) imageView, null);
        imageView.setScaleType(ScaleType.CENTER_INSIDE);
        imageView.setImageDrawable(C1102c.m2395b(context, str, i));
    }

    public static void m2390a(Context context, ThemeBean themeBean) {
        if (themeBean == null) {
            C1102c.m2392a(context, "applock_themepkg", context.getPackageName());
        } else {
            C1102c.m2392a(context, "applock_themepkg", themeBean.f2076e);
            C1147a.m2487w(context, context.getString(R.string.applied_theme, new Object[]{themeBean.f2073b}));
        }
        C1148d.m2489A(context, "com.domobile.elock.ACTION_LOCK_THEME_CHANGED");
    }

    public static void m2391a(Context context, String str) {
        String str2 = "applock_themepkg_list";
        C1102c.m2392a(context, str2, C1102c.m2386a(context, "applock_themepkg_list", "") + "," + str);
    }

    public static void m2392a(Context context, String str, Object obj) {
        Editor edit = context.getSharedPreferences("applock_theme", 0).edit();
        if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else {
            throw new UnsupportedOperationException();
        }
        edit.commit();
    }

    public static void m2393a(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            if (i != -1) {
                ((MarginLayoutParams) layoutParams).leftMargin = i;
            }
            if (i2 != -1) {
                ((MarginLayoutParams) layoutParams).topMargin = i2;
            }
            if (i3 != -1) {
                ((MarginLayoutParams) layoutParams).rightMargin = i3;
            }
            if (i4 != -1) {
                ((MarginLayoutParams) layoutParams).bottomMargin = i4;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static boolean m2394a(PackageManager packageManager, String str) {
        try {
            return packageManager.getPackageInfo(str, 0) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static Drawable m2395b(Context context, String str, int i) {
        try {
            return C1148d.m2502a(context.getPackageManager().getResourcesForApplication(str), i);
        } catch (Exception e) {
            C1147a.m2482b("未安装皮肤包或皮肤包中没有对应的Drawable资源：", str, " : ", Integer.valueOf(i));
            return C1148d.m2502a(context.getResources(), i);
        }
    }

    public static String m2396b(Context context) {
        try {
            return C3613c.m15742f(new File(context.getFilesDir(), "unlock_json"));
        } catch (Exception e) {
            return C1148d.m2494F(context, "unlock_page_themes.json");
        }
    }

    public static boolean m2397b(Context context, String str) {
        Object a = C1102c.m2386a(context, "applock_themepkg_list", "");
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        try {
            for (Object equals : a.split(",")) {
                if (str.equals(equals)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static Bitmap m2398c(Context context, String str, int i) {
        try {
            return BitmapFactory.decodeResource(context.getPackageManager().getResourcesForApplication(str), i);
        } catch (Exception e) {
            C1147a.m2482b("未安装皮肤包或皮肤包中没有对应的Bitmap资源：", str);
            try {
                return BitmapFactory.decodeResource(context.getResources(), i);
            } catch (Exception e2) {
                return null;
            }
        }
    }

    public static void m2399c(Context context, String str) {
        try {
            JSONArray optJSONArray = new JSONObject(C1102c.m2396b(context)).optJSONArray("unlock_skin");
            PackageManager packageManager = context.getPackageManager();
            int ad = C1148d.ad(context);
            int i = 0;
            int length = optJSONArray.length();
            while (i < length) {
                ThemeBean themeBean = new ThemeBean(packageManager, optJSONArray.getJSONObject(i), "");
                if (!TextUtils.equals(str, themeBean.f2076e)) {
                    i++;
                } else if (((long) ad) >= themeBean.f2078g && C1150y.m2593a(packageManager, str)) {
                    if (!themeBean.f2081j || C1150y.m2638k(context) || C1102c.m2397b(context, themeBean.f2076e)) {
                        C1102c.m2390a(context, themeBean);
                        C1148d.m2489A(context, "com.domobile.applock.ACTION_STARTUP_THEME_SUCCESS");
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
        }
    }

    public static boolean m2400c(Context context) {
        return C1102c.m2408f(context, C1102c.m2385a(context));
    }

    public static C1084a m2401d(Context context) {
        String a = C1102c.m2385a(context);
        if (a == null || "com.domobile.applock".equals(a)) {
            return new DefaultNumBoardInitialer();
        }
        try {
            return (C1084a) Class.forName(C1102c.m2407f(context, C1102c.m2385a(context), R.string.initialer_class)).newInstance();
        } catch (Exception e) {
            C1102c.m2390a(context, null);
            return new DefaultNumBoardInitialer();
        }
    }

    public static Object m2402d(Context context, String str, int i) {
        Resources resources;
        try {
            try {
                return Integer.valueOf(context.getPackageManager().getResourcesForApplication(str).getColor(i));
            } catch (NotFoundException e) {
                return resources.getColorStateList(i);
            }
        } catch (Exception e2) {
            C1147a.m2482b("未安装皮肤包或皮肤包中没有对应的Color资源：", str);
            resources = context.getResources();
            try {
                return Integer.valueOf(resources.getColor(i));
            } catch (NotFoundException e3) {
                return resources.getColorStateList(i);
            }
        }
    }

    public static void m2403d(Context context, String str) {
        try {
            C1148d.m2518a(str, new File(context.getFilesDir(), "unlock_json").getAbsolutePath());
        } catch (Exception e) {
        }
    }

    public static int m2404e(Context context, String str, int i) {
        try {
            return context.getPackageManager().getResourcesForApplication(str).getInteger(i);
        } catch (Exception e) {
            C1147a.m2482b("未安装皮肤包或皮肤包中没有对应的Integer资源：", str);
            return context.getResources().getInteger(i);
        }
    }

    public static boolean m2405e(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static boolean m2406e(Context context, String str) {
        CharSequence a = C1102c.m2385a(context);
        return TextUtils.isEmpty(a) ? TextUtils.equals(str, "com.domobile.applock") : TextUtils.equals(str, a);
    }

    public static String m2407f(Context context, String str, int i) {
        try {
            return context.getPackageManager().getResourcesForApplication(str).getString(i);
        } catch (Exception e) {
            C1147a.m2482b("未安装皮肤包或皮肤包中没有对应的String资源：", str);
            return context.getResources().getString(i);
        }
    }

    public static boolean m2408f(Context context, String str) {
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(str);
            return resourcesForApplication.getBoolean(resourcesForApplication.getIdentifier("style_live_skin", "bool", str));
        } catch (Exception e) {
            return false;
        }
    }

    public static void m2409g(Context context, String str) {
        context.getSharedPreferences("applock_theme", 0).edit().remove(str).commit();
    }

    public static Resources m2410h(Context context, String str) {
        try {
            return context.getPackageManager().getResourcesForApplication(str);
        } catch (Exception e) {
            return context.getResources();
        }
    }
}
