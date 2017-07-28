package com.android.camera;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.camera.gallery.C0449h;
import com.domobile.applock.R;
import com.domobile.frame.ui.C1288c;

public class C0433g {

    public interface C0427a {
        void mo2078a(Uri uri, C0449h c0449h);
    }

    public interface C0432b {
        void mo2079a(C0427a c0427a);
    }

    private static View m240a(Context context, int i, String str, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.vault_dialog, null);
        TextView textView = (TextView) inflate.findViewById(16908314);
        TextView textView2 = (TextView) inflate.findViewById(16908315);
        ((TextView) inflate.findViewById(16908313)).setOnClickListener(onClickListener);
        textView.setOnClickListener(onClickListener2);
        if (!TextUtils.isEmpty(str3)) {
            textView.setVisibility(8);
            textView2.setText(str3);
            textView2.setVisibility(0);
            textView2.setOnClickListener(onClickListener2);
        }
        ((ImageView) inflate.findViewById(16908294)).setImageResource(i);
        ((TextView) inflate.findViewById(16908310)).setText(str);
        ((TextView) inflate.findViewById(16908299)).setText(str2);
        return inflate;
    }

    public static String m241a(Context context, int i) {
        int i2 = i / 1000;
        int i3 = i2 / 3600;
        i2 -= (i3 * 3600) + (((i2 - (i3 * 3600)) / 60) * 60);
        if (i3 == 0) {
            return String.format(context.getString(R.string.details_ms), new Object[]{Integer.valueOf(r2), Integer.valueOf(i2)});
        }
        return String.format(context.getString(R.string.details_hms), new Object[]{Integer.valueOf(i3), Integer.valueOf(r2), Integer.valueOf(i2)});
    }

    public static void m242a(Activity activity, int i, String str, String str2, final Runnable runnable, String str3) {
        final C1288c c1288c = new C1288c(activity);
        c1288c.m3111a(true).m3115b(C0433g.m240a(activity, i, str, str2, str3, new OnClickListener() {
            public void onClick(View view) {
                c1288c.m3125e();
            }
        }, new OnClickListener() {
            public void onClick(View view) {
                c1288c.m3125e();
                if (runnable != null) {
                    runnable.run();
                }
            }
        })).m3117b(true).m3122d();
    }

    public static void m243a(Activity activity, Runnable runnable) {
        C0433g.m242a(activity, R.drawable.toolbar_unlock, activity.getString(R.string.revert), activity.getString(R.string.confirm_revert_medias), runnable, activity.getString(17039370));
    }

    public static void m244a(Activity activity, Runnable runnable, boolean z) {
        C0433g.m242a(activity, R.drawable.toolbar_trash, activity.getString(R.string.confirm_delete_title), activity.getString(z ? R.string.confirm_delete_message : R.string.confirm_delete_video_message), runnable, null);
    }

    public static void m245a(Activity activity, String str, String str2, final Runnable runnable) {
        new C1288c(activity).m3111a(true).m3109a(str).mo2528a((CharSequence) str2).m3102a(17039360, null).m3114b(17039370, new OnClickListener() {
            public void onClick(View view) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        }).m3117b(true).m3122d();
    }

    public static void m246a(Activity activity, boolean z, Runnable runnable) {
        C0433g.m242a(activity, R.drawable.toolbar_lock, activity.getString(R.string.hide), activity.getString(R.string.confirm_hide_medias), runnable, activity.getString(17039370));
    }

    public static boolean m249a(final Activity activity, C0432b c0432b) {
        c0432b.mo2079a(new C0427a() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo2078a(android.net.Uri r12, com.android.camera.gallery.C0449h r13) {
                /*
                r11 = this;
                r9 = 2131099943; // 0x7f060127 float:1.7812253E38 double:1.0529032697E-314;
                r8 = 8;
                r2 = 0;
                r10 = 1;
                r3 = 0;
                if (r13 != 0) goto L_0x000b;
            L_0x000a:
                return;
            L_0x000b:
                r4 = new com.domobile.frame.ui.c;
                r0 = r1;
                r4.<init>(r0);
                r0 = r1;
                r1 = 2130903103; // 0x7f03003f float:1.7413015E38 double:1.052806018E-314;
                r5 = android.view.View.inflate(r0, r1, r2);
                r4.m3119c(r10);
                r0 = 2131099939; // 0x7f060123 float:1.7812245E38 double:1.0529032677E-314;
                r0 = r5.findViewById(r0);
                r0 = (android.widget.TextView) r0;
                r1 = r13.mo2088e();
                r0.setText(r1);
                r0 = new java.io.File;
                r1 = r13.mo2082a();
                r0.<init>(r1);
                r0 = r0.length();
                r6 = 0;
                r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
                if (r6 >= 0) goto L_0x00ca;
            L_0x0041:
                r0 = "";
                r1 = r0;
            L_0x0044:
                r0 = 2131099940; // 0x7f060124 float:1.7812247E38 double:1.052903268E-314;
                r0 = r5.findViewById(r0);
                r0 = (android.widget.TextView) r0;
                r0.setText(r1);
                r0 = com.android.camera.C0487k.m408a(r13);
                r1 = com.android.camera.C0487k.C0486a.TYPE_IMAGE;
                if (r0 != r1) goto L_0x00d3;
            L_0x0058:
                r1 = r13.getWidth();
                r0 = r13.getHeight();
                r6 = r5.findViewById(r9);
                r6.setVisibility(r8);
            L_0x0067:
                if (r1 <= 0) goto L_0x0138;
            L_0x0069:
                if (r0 <= 0) goto L_0x0138;
            L_0x006b:
                r6 = r1;
                r7 = 2131296791; // 0x7f090217 float:1.8211509E38 double:1.0530005255E-314;
                r6 = r6.getString(r7);
                r7 = 2;
                r7 = new java.lang.Object[r7];
                r1 = java.lang.Integer.valueOf(r1);
                r7[r3] = r1;
                r0 = java.lang.Integer.valueOf(r0);
                r7[r10] = r0;
                r0 = java.lang.String.format(r6, r7);
            L_0x0087:
                if (r0 == 0) goto L_0x0127;
            L_0x0089:
                r1 = 2131099942; // 0x7f060126 float:1.7812251E38 double:1.052903269E-314;
                com.android.camera.C0433g.m251b(r5, r0, r1);
            L_0x008f:
                r0 = "";
                r6 = r13.mo2084c();
                r8 = 0;
                r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
                if (r1 == 0) goto L_0x00ad;
            L_0x009b:
                r0 = new java.util.Date;
                r6 = r13.mo2084c();
                r0.<init>(r6);
                r1 = new java.text.SimpleDateFormat;
                r1.<init>();
                r0 = r1.format(r0);
            L_0x00ad:
                r1 = "";
                if (r0 == r1) goto L_0x012f;
            L_0x00b1:
                r1 = 2131099946; // 0x7f06012a float:1.781226E38 double:1.052903271E-314;
                com.android.camera.C0433g.m251b(r5, r0, r1);
            L_0x00b7:
                r0 = 17039370; // 0x104000a float:2.42446E-38 double:8.4185673E-317;
                r4.m3102a(r0, r2);
                r0 = r4.m3105a(r5);
                r0 = r0.m3117b(r10);
                r0.m3122d();
                goto L_0x000a;
            L_0x00ca:
                r6 = r1;
                r0 = android.text.format.Formatter.formatFileSize(r6, r0);
                r1 = r0;
                goto L_0x0044;
            L_0x00d3:
                r1 = new android.media.MediaMetadataRetriever;
                r1.<init>();
                r0 = r13.mo2082a();	 Catch:{ RuntimeException -> 0x0110, all -> 0x0122 }
                r1.setDataSource(r0);	 Catch:{ RuntimeException -> 0x0110, all -> 0x0122 }
                r0 = 9;
                r0 = r1.extractMetadata(r0);	 Catch:{ NumberFormatException -> 0x0102 }
                r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0102 }
                r6 = r1;	 Catch:{ NumberFormatException -> 0x0102 }
                r6 = com.android.camera.C0433g.m241a(r6, r0);	 Catch:{ NumberFormatException -> 0x0102 }
                r0 = 2131099944; // 0x7f060128 float:1.7812256E38 double:1.05290327E-314;
                r0 = r5.findViewById(r0);	 Catch:{ NumberFormatException -> 0x0102 }
                r0 = (android.widget.TextView) r0;	 Catch:{ NumberFormatException -> 0x0102 }
                r0.setText(r6);	 Catch:{ NumberFormatException -> 0x0102 }
            L_0x00fb:
                r1.release();	 Catch:{ RuntimeException -> 0x0118 }
                r0 = r3;
                r1 = r3;
                goto L_0x0067;
            L_0x0102:
                r0 = move-exception;
                r0 = 2131099943; // 0x7f060127 float:1.7812253E38 double:1.0529032697E-314;
                r0 = r5.findViewById(r0);	 Catch:{ RuntimeException -> 0x0110, all -> 0x0122 }
                r6 = 8;
                r0.setVisibility(r6);	 Catch:{ RuntimeException -> 0x0110, all -> 0x0122 }
                goto L_0x00fb;
            L_0x0110:
                r0 = move-exception;
                r1.release();	 Catch:{ RuntimeException -> 0x011d }
                r0 = r3;
                r1 = r3;
                goto L_0x0067;
            L_0x0118:
                r0 = move-exception;
                r0 = r3;
                r1 = r3;
                goto L_0x0067;
            L_0x011d:
                r0 = move-exception;
                r0 = r3;
                r1 = r3;
                goto L_0x0067;
            L_0x0122:
                r0 = move-exception;
                r1.release();	 Catch:{ RuntimeException -> 0x0136 }
            L_0x0126:
                throw r0;
            L_0x0127:
                r0 = 2131099941; // 0x7f060125 float:1.781225E38 double:1.0529032687E-314;
                com.android.camera.C0433g.m250b(r5, r0);
                goto L_0x008f;
            L_0x012f:
                r0 = 2131099945; // 0x7f060129 float:1.7812258E38 double:1.0529032707E-314;
                com.android.camera.C0433g.m250b(r5, r0);
                goto L_0x00b7;
            L_0x0136:
                r1 = move-exception;
                goto L_0x0126;
            L_0x0138:
                r0 = r2;
                goto L_0x0087;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.camera.g.1.a(android.net.Uri, com.android.camera.gallery.h):void");
            }
        });
        return true;
    }

    private static void m250b(View view, int i) {
        view.findViewById(i).setVisibility(8);
    }

    private static void m251b(View view, String str, int i) {
        ((TextView) view.findViewById(i)).setText(str);
    }
}
