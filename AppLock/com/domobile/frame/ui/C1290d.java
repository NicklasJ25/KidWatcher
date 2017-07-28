package com.domobile.frame.ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.domobile.p015b.C1168b.C1162f;
import com.domobile.p015b.C1168b.C1163g;
import java.text.NumberFormat;

public class C1290d extends C1288c {
    private ProgressBar f2708c;
    private TextView f2709d;
    private int f2710e = 0;
    private TextView f2711f;
    private String f2712g;
    private TextView f2713h;
    private NumberFormat f2714i;
    private int f2715j;
    private int f2716k;
    private int f2717l;
    private int f2718m;
    private int f2719n;
    private Drawable f2720o;
    private Drawable f2721p;
    private CharSequence f2722q;
    private boolean f2723r;
    private Handler f2724s;

    class C12891 extends Handler {
        final /* synthetic */ C1290d f2707a;

        C12891(C1290d c1290d) {
            this.f2707a = c1290d;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int progress = this.f2707a.f2708c.getProgress();
            int max = this.f2707a.f2708c.getMax();
            if (this.f2707a.f2712g != null) {
                String b = this.f2707a.f2712g;
                this.f2707a.f2711f.setText(String.format(b, new Object[]{Integer.valueOf(progress), Integer.valueOf(max)}));
            } else {
                this.f2707a.f2711f.setText("");
            }
            if (this.f2707a.f2714i != null) {
                CharSequence spannableString = new SpannableString(this.f2707a.f2714i.format(((double) progress) / ((double) max)));
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                this.f2707a.f2713h.setText(spannableString);
                return;
            }
            this.f2707a.f2713h.setText("");
        }
    }

    public C1290d(Activity activity) {
        super(activity);
    }

    public static C1290d m3130a(Activity activity, String str, String str2) {
        return C1290d.m3131a(activity, str, str2, false);
    }

    public static C1290d m3131a(Activity activity, String str, String str2, boolean z) {
        return C1290d.m3132a(activity, str, str2, z, false);
    }

    public static C1290d m3132a(Activity activity, String str, String str2, boolean z, boolean z2) {
        C1290d c1290d = new C1290d(activity);
        c1290d.m3109a(str).mo2528a((CharSequence) str2);
        c1290d.m3144f(z);
        c1290d.m3117b(z2).m3122d();
        return c1290d;
    }

    private void m3137f() {
        this.f2712g = "%1d/%2d";
        this.f2714i = NumberFormat.getPercentInstance();
        this.f2714i.setMaximumFractionDigits(0);
    }

    private void m3138g() {
        if (this.f2710e == 1 && this.f2724s != null && !this.f2724s.hasMessages(0)) {
            this.f2724s.sendEmptyMessage(0);
        }
    }

    public /* synthetic */ C1288c mo2528a(CharSequence charSequence) {
        return m3140b(charSequence);
    }

    public C1290d m3140b(CharSequence charSequence) {
        if (this.f2708c == null) {
            this.f2722q = charSequence;
        } else if (this.f2710e == 1) {
            super.mo2528a(charSequence);
        } else {
            this.f2709d.setText(charSequence);
        }
        return this;
    }

    public void mo2529b() {
        super.mo2529b();
        m3137f();
        LayoutInflater from = LayoutInflater.from(m3100a());
        View inflate;
        if (this.f2710e == 1) {
            this.f2724s = new C12891(this);
            inflate = from.inflate(C1163g.progress_dialog_horizontal, null);
            this.f2708c = (ProgressBar) inflate.findViewById(C1162f.progress);
            this.f2711f = (TextView) inflate.findViewById(C1162f.progress_number);
            this.f2713h = (TextView) inflate.findViewById(C1162f.progress_percent);
            m3105a(inflate);
        } else {
            inflate = from.inflate(C1163g.progress_dialog_spinner, null);
            this.f2708c = (ProgressBar) inflate.findViewById(C1162f.progress);
            this.f2709d = (TextView) inflate.findViewById(C1162f.message);
            m3105a(inflate);
        }
        if (this.f2715j > 0) {
            m3147i(this.f2715j);
        }
        if (this.f2716k > 0) {
            mo2530g(this.f2716k);
        }
        if (this.f2717l > 0) {
            m3146h(this.f2717l);
        }
        if (this.f2718m > 0) {
            m3148j(this.f2718m);
        }
        if (this.f2719n > 0) {
            m3149k(this.f2719n);
        }
        if (this.f2720o != null) {
            m3142b(this.f2720o);
        }
        if (this.f2721p != null) {
            m3143c(this.f2721p);
        }
        if (this.f2722q != null) {
            m3140b(this.f2722q);
        }
        m3144f(this.f2723r);
        m3138g();
    }

    public void m3142b(Drawable drawable) {
        if (this.f2708c != null) {
            this.f2708c.setProgressDrawable(drawable);
        } else {
            this.f2720o = drawable;
        }
    }

    public void m3143c(Drawable drawable) {
        if (this.f2708c != null) {
            this.f2708c.setIndeterminateDrawable(drawable);
        } else {
            this.f2721p = drawable;
        }
    }

    public void m3144f(boolean z) {
        if (this.f2708c != null) {
            this.f2708c.setIndeterminate(z);
        } else {
            this.f2723r = z;
        }
    }

    public void mo2530g(int i) {
        if (m3121c()) {
            this.f2708c.setProgress(i);
            m3138g();
            return;
        }
        this.f2716k = i;
    }

    public void m3146h(int i) {
        if (this.f2708c != null) {
            this.f2708c.setSecondaryProgress(i);
            m3138g();
            return;
        }
        this.f2717l = i;
    }

    public void m3147i(int i) {
        if (this.f2708c != null) {
            this.f2708c.setMax(i);
            m3138g();
            return;
        }
        this.f2715j = i;
    }

    public void m3148j(int i) {
        if (this.f2708c != null) {
            this.f2708c.incrementProgressBy(i);
            m3138g();
            return;
        }
        this.f2718m += i;
    }

    public void m3149k(int i) {
        if (this.f2708c != null) {
            this.f2708c.incrementSecondaryProgressBy(i);
            m3138g();
            return;
        }
        this.f2719n += i;
    }
}
