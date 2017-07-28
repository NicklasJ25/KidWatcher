package com.domobile.widget.timepicker;

import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.domobile.applock.R;
import com.domobile.libs_ads.C1348d;
import com.domobile.widget.timepicker.RadialPickerLayout.C1415a;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class C1432f extends DialogFragment implements C1415a {
    private int f3261A;
    private String f3262B;
    private String f3263C;
    private String f3264D;
    private String f3265E;
    private C0732c f3266a;
    private C1419c f3267b;
    private TextView f3268c;
    private TextView f3269d;
    private TextView f3270e;
    private TextView f3271f;
    private TextView f3272g;
    private TextView f3273h;
    private View f3274i;
    private RadialPickerLayout f3275j;
    private int f3276k;
    private int f3277l;
    private String f3278m;
    private String f3279n;
    private boolean f3280o;
    private int f3281p;
    private int f3282q;
    private boolean f3283r;
    private boolean f3284s;
    private char f3285t;
    private String f3286u;
    private String f3287v;
    private boolean f3288w;
    private ArrayList<Integer> f3289x;
    private C1431b f3290y;
    private int f3291z;

    public interface C0732c {
        void mo2408a(RadialPickerLayout radialPickerLayout, int i, int i2);
    }

    class C14261 implements OnClickListener {
        final /* synthetic */ C1432f f3253a;

        C14261(C1432f c1432f) {
            this.f3253a = c1432f;
        }

        public void onClick(View view) {
            this.f3253a.m3632a(0, true, false, true);
            this.f3253a.m3654a();
        }
    }

    class C14272 implements OnClickListener {
        final /* synthetic */ C1432f f3254a;

        C14272(C1432f c1432f) {
            this.f3254a = c1432f;
        }

        public void onClick(View view) {
            this.f3254a.m3632a(1, true, false, true);
            this.f3254a.m3654a();
        }
    }

    class C14283 implements OnClickListener {
        final /* synthetic */ C1432f f3255a;

        C14283(C1432f c1432f) {
            this.f3255a = c1432f;
        }

        public void onClick(View view) {
            if (this.f3255a.f3288w && this.f3255a.m3645c()) {
                this.f3255a.m3636a(false);
            } else {
                this.f3255a.m3654a();
            }
            if (this.f3255a.f3266a != null) {
                this.f3255a.f3266a.mo2408a(this.f3255a.f3275j, this.f3255a.f3275j.getHours(), this.f3255a.f3275j.getMinutes());
            }
            this.f3255a.dismiss();
        }
    }

    class C14294 implements OnClickListener {
        final /* synthetic */ C1432f f3256a;

        C14294(C1432f c1432f) {
            this.f3256a = c1432f;
        }

        public void onClick(View view) {
            int i = 1;
            this.f3256a.m3654a();
            int isCurrentlyAmOrPm = this.f3256a.f3275j.getIsCurrentlyAmOrPm();
            if (isCurrentlyAmOrPm != 0) {
                i = isCurrentlyAmOrPm == 1 ? 0 : isCurrentlyAmOrPm;
            }
            this.f3256a.m3630a(i);
            this.f3256a.f3275j.setAmOrPm(i);
        }
    }

    private class C1430a implements OnKeyListener {
        final /* synthetic */ C1432f f3257a;

        private C1430a(C1432f c1432f) {
            this.f3257a = c1432f;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            return keyEvent.getAction() == 1 ? this.f3257a.m3646c(i) : false;
        }
    }

    private class C1431b {
        final /* synthetic */ C1432f f3258a;
        private int[] f3259b;
        private ArrayList<C1431b> f3260c = new ArrayList();

        public C1431b(C1432f c1432f, int... iArr) {
            this.f3258a = c1432f;
            this.f3259b = iArr;
        }

        public void m3626a(C1431b c1431b) {
            this.f3260c.add(c1431b);
        }

        public boolean m3627a(int i) {
            for (int i2 : this.f3259b) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public C1431b m3628b(int i) {
            if (this.f3260c == null) {
                return null;
            }
            Iterator it = this.f3260c.iterator();
            while (it.hasNext()) {
                C1431b c1431b = (C1431b) it.next();
                if (c1431b.m3627a(i)) {
                    return c1431b;
                }
            }
            return null;
        }
    }

    public static C1432f m3629a(C0732c c0732c, int i, int i2, boolean z) {
        C1432f c1432f = new C1432f();
        c1432f.m3656b(c0732c, i, i2, z);
        return c1432f;
    }

    private void m3630a(int i) {
        if (i == 0) {
            this.f3273h.setText(this.f3278m);
            C1434h.m3659a(this.f3275j, this.f3278m);
            this.f3274i.setContentDescription(this.f3278m);
        } else if (i == 1) {
            this.f3273h.setText(this.f3279n);
            C1434h.m3659a(this.f3275j, this.f3279n);
            this.f3274i.setContentDescription(this.f3279n);
        } else {
            this.f3273h.setText(this.f3286u);
        }
    }

    private void m3631a(int i, boolean z) {
        String str;
        if (this.f3283r) {
            str = "%02d";
        } else {
            str = "%d";
            i %= 12;
            if (i == 0) {
                i = 12;
            }
        }
        CharSequence format = String.format(str, new Object[]{Integer.valueOf(i)});
        this.f3269d.setText(format);
        this.f3270e.setText(format);
        if (z) {
            C1434h.m3659a(this.f3275j, format);
        }
    }

    private void m3632a(int i, boolean z, boolean z2, boolean z3) {
        int hours;
        View view;
        this.f3275j.m3601a(i, z);
        if (i == 0) {
            hours = this.f3275j.getHours();
            if (!this.f3283r) {
                hours %= 12;
            }
            this.f3275j.setContentDescription(this.f3262B + ": " + hours);
            if (z3) {
                C1434h.m3659a(this.f3275j, this.f3263C);
            }
            view = this.f3269d;
        } else {
            this.f3275j.setContentDescription(this.f3264D + ": " + this.f3275j.getMinutes());
            if (z3) {
                C1434h.m3659a(this.f3275j, this.f3265E);
            }
            view = this.f3271f;
        }
        int i2 = i == 0 ? this.f3276k : this.f3277l;
        hours = i == 1 ? this.f3276k : this.f3277l;
        this.f3269d.setTextColor(i2);
        this.f3271f.setTextColor(hours);
        if (C1348d.Q) {
            ObjectAnimator a = C1434h.m3658a(view, 0.85f, 1.1f);
            if (z2) {
                a.setStartDelay(300);
            }
            a.start();
        }
    }

    private void m3636a(boolean z) {
        this.f3288w = false;
        if (!this.f3289x.isEmpty()) {
            int[] a = m3638a(null);
            this.f3275j.m3600a(a[0], a[1]);
            if (!this.f3283r) {
                this.f3275j.setAmOrPm(a[2]);
            }
            this.f3289x.clear();
        }
        if (z) {
            m3640b(false);
            this.f3275j.m3604a(true);
        }
    }

    private int[] m3638a(Boolean[] boolArr) {
        int i;
        int i2;
        int intValue;
        if (this.f3283r || !m3645c()) {
            i = 1;
            i2 = -1;
        } else {
            intValue = ((Integer) this.f3289x.get(this.f3289x.size() - 1)).intValue();
            if (intValue == m3653g(0)) {
                intValue = 0;
            } else if (intValue == m3653g(1)) {
                boolean z = true;
            } else {
                intValue = -1;
            }
            i = 2;
            i2 = intValue;
        }
        int i3 = -1;
        int i4 = -1;
        for (int i5 = i; i5 <= this.f3289x.size(); i5++) {
            intValue = m3652f(((Integer) this.f3289x.get(this.f3289x.size() - i5)).intValue());
            if (i5 == i) {
                i4 = intValue;
            } else if (i5 == i + 1) {
                i4 += intValue * 10;
                if (boolArr != null && intValue == 0) {
                    boolArr[1] = Boolean.valueOf(true);
                }
            } else if (i5 == i + 2) {
                i3 = intValue;
            } else if (i5 == i + 3) {
                i3 += intValue * 10;
                if (boolArr != null && intValue == 0) {
                    boolArr[0] = Boolean.valueOf(true);
                }
            }
        }
        return new int[]{i3, i4, i2};
    }

    private void m3639b(int i) {
        if (i == 60) {
            i = 0;
        }
        CharSequence format = String.format(Locale.getDefault(), "%02d", new Object[]{Integer.valueOf(i)});
        C1434h.m3659a(this.f3275j, format);
        this.f3271f.setText(format);
        this.f3272g.setText(format);
    }

    private void m3640b(boolean z) {
        int i = 0;
        if (z || !this.f3289x.isEmpty()) {
            Boolean[] boolArr = new Boolean[]{Boolean.valueOf(false), Boolean.valueOf(false)};
            int[] a = m3638a(boolArr);
            String str = boolArr[0].booleanValue() ? "%02d" : "%2d";
            String str2 = boolArr[1].booleanValue() ? "%02d" : "%2d";
            CharSequence replace = a[0] == -1 ? this.f3286u : String.format(str, new Object[]{Integer.valueOf(a[0])}).replace(' ', this.f3285t);
            CharSequence replace2 = a[1] == -1 ? this.f3286u : String.format(str2, new Object[]{Integer.valueOf(a[1])}).replace(' ', this.f3285t);
            this.f3269d.setText(replace);
            this.f3270e.setText(replace);
            this.f3269d.setTextColor(this.f3277l);
            this.f3271f.setText(replace2);
            this.f3272g.setText(replace2);
            this.f3271f.setTextColor(this.f3277l);
            if (!this.f3283r) {
                m3630a(a[2]);
                return;
            }
            return;
        }
        int hours = this.f3275j.getHours();
        int minutes = this.f3275j.getMinutes();
        m3631a(hours, true);
        m3639b(minutes);
        if (!this.f3283r) {
            if (hours >= 12) {
                i = 1;
            }
            m3630a(i);
        }
        m3632a(this.f3275j.getCurrentItemShowing(), true, true, true);
        this.f3268c.setEnabled(true);
    }

    private boolean m3641b() {
        C1431b c1431b = this.f3290y;
        Iterator it = this.f3289x.iterator();
        C1431b c1431b2 = c1431b;
        while (it.hasNext()) {
            c1431b = c1431b2.m3628b(((Integer) it.next()).intValue());
            if (c1431b == null) {
                return false;
            }
            c1431b2 = c1431b;
        }
        return true;
    }

    private boolean m3645c() {
        boolean z = false;
        if (this.f3283r) {
            int[] a = m3638a(null);
            return a[0] >= 0 && a[1] >= 0 && a[1] < 60;
        } else {
            if (this.f3289x.contains(Integer.valueOf(m3653g(0))) || this.f3289x.contains(Integer.valueOf(m3653g(1)))) {
                z = true;
            }
            return z;
        }
    }

    private boolean m3646c(int i) {
        if (i == 111 || i == 4) {
            dismiss();
            return true;
        }
        if (i == 61) {
            if (this.f3288w) {
                if (m3645c()) {
                    m3636a(true);
                }
                return true;
            }
        } else if (i == 66) {
            if (this.f3288w) {
                if (!m3645c()) {
                    return true;
                }
                m3636a(false);
            }
            if (this.f3266a != null) {
                this.f3266a.mo2408a(this.f3275j, this.f3275j.getHours(), this.f3275j.getMinutes());
            }
            dismiss();
            return true;
        } else if (i == 67) {
            if (this.f3288w && !this.f3289x.isEmpty()) {
                String str;
                int d = m3647d();
                if (d == m3653g(0)) {
                    str = this.f3278m;
                } else if (d == m3653g(1)) {
                    str = this.f3279n;
                } else {
                    str = String.format("%d", new Object[]{Integer.valueOf(m3652f(d))});
                }
                C1434h.m3659a(this.f3275j, String.format(this.f3287v, new Object[]{str}));
                m3640b(true);
            }
        } else if (i == 7 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || (!this.f3283r && (i == m3653g(0) || i == m3653g(1)))) {
            if (this.f3288w) {
                if (m3651e(i)) {
                    m3640b(false);
                }
                return true;
            } else if (this.f3275j == null) {
                Log.e("TimePickerDialog", "Unable to initiate keyboard mode, TimePicker was null.");
                return true;
            } else {
                this.f3289x.clear();
                m3649d(i);
                return true;
            }
        }
        return false;
    }

    private int m3647d() {
        int intValue = ((Integer) this.f3289x.remove(this.f3289x.size() - 1)).intValue();
        if (!m3645c()) {
            this.f3268c.setEnabled(false);
        }
        return intValue;
    }

    private void m3649d(int i) {
        if (!this.f3275j.m3604a(false)) {
            return;
        }
        if (i == -1 || m3651e(i)) {
            this.f3288w = true;
            this.f3268c.setEnabled(false);
            m3640b(false);
        }
    }

    private void m3650e() {
        this.f3290y = new C1431b(this, new int[0]);
        if (this.f3283r) {
            C1431b c1431b = new C1431b(this, 7, 8, 9, 10, 11, 12);
            C1431b c1431b2 = new C1431b(this, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
            c1431b.m3626a(c1431b2);
            C1431b c1431b3 = new C1431b(this, 7, 8);
            this.f3290y.m3626a(c1431b3);
            C1431b c1431b4 = new C1431b(this, 7, 8, 9, 10, 11, 12);
            c1431b3.m3626a(c1431b4);
            c1431b4.m3626a(c1431b);
            c1431b4.m3626a(new C1431b(this, 13, 14, 15, 16));
            c1431b4 = new C1431b(this, 13, 14, 15, 16);
            c1431b3.m3626a(c1431b4);
            c1431b4.m3626a(c1431b);
            c1431b3 = new C1431b(this, 9);
            this.f3290y.m3626a(c1431b3);
            c1431b4 = new C1431b(this, 7, 8, 9, 10);
            c1431b3.m3626a(c1431b4);
            c1431b4.m3626a(c1431b);
            C1431b c1431b5 = new C1431b(this, 11, 12);
            c1431b3.m3626a(c1431b5);
            c1431b5.m3626a(c1431b2);
            c1431b5 = new C1431b(this, 10, 11, 12, 13, 14, 15, 16);
            this.f3290y.m3626a(c1431b5);
            c1431b5.m3626a(c1431b);
            return;
        }
        c1431b = new C1431b(this, m3653g(0), m3653g(1));
        c1431b2 = new C1431b(this, 8);
        this.f3290y.m3626a(c1431b2);
        c1431b2.m3626a(c1431b);
        c1431b3 = new C1431b(this, 7, 8, 9);
        c1431b2.m3626a(c1431b3);
        c1431b3.m3626a(c1431b);
        c1431b4 = new C1431b(this, 7, 8, 9, 10, 11, 12);
        c1431b3.m3626a(c1431b4);
        c1431b4.m3626a(c1431b);
        c1431b4 = new C1431b(this, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        c1431b4.m3626a(c1431b4);
        c1431b4.m3626a(c1431b);
        c1431b4 = new C1431b(this, 13, 14, 15, 16);
        c1431b3.m3626a(c1431b4);
        c1431b4.m3626a(c1431b);
        c1431b3 = new C1431b(this, 10, 11, 12);
        c1431b2.m3626a(c1431b3);
        c1431b2 = new C1431b(this, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        c1431b3.m3626a(c1431b2);
        c1431b2.m3626a(c1431b);
        c1431b2 = new C1431b(this, 9, 10, 11, 12, 13, 14, 15, 16);
        this.f3290y.m3626a(c1431b2);
        c1431b2.m3626a(c1431b);
        c1431b3 = new C1431b(this, 7, 8, 9, 10, 11, 12);
        c1431b2.m3626a(c1431b3);
        c1431b2 = new C1431b(this, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        c1431b3.m3626a(c1431b2);
        c1431b2.m3626a(c1431b);
    }

    private boolean m3651e(int i) {
        if (this.f3283r && this.f3289x.size() == 4) {
            return false;
        }
        if (!this.f3283r && m3645c()) {
            return false;
        }
        this.f3289x.add(Integer.valueOf(i));
        if (m3641b()) {
            int f = m3652f(i);
            C1434h.m3659a(this.f3275j, String.format("%d", new Object[]{Integer.valueOf(f)}));
            if (m3645c()) {
                if (!this.f3283r && this.f3289x.size() <= 3) {
                    this.f3289x.add(this.f3289x.size() - 1, Integer.valueOf(7));
                    this.f3289x.add(this.f3289x.size() - 1, Integer.valueOf(7));
                }
                this.f3268c.setEnabled(true);
            }
            return true;
        }
        m3647d();
        return false;
    }

    private int m3652f(int i) {
        switch (i) {
            case 7:
                return 0;
            case 8:
                return 1;
            case 9:
                return 2;
            case 10:
                return 3;
            case 11:
                return 4;
            case 12:
                return 5;
            case 13:
                return 6;
            case 14:
                return 7;
            case 15:
                return 8;
            case 16:
                return 9;
            default:
                return -1;
        }
    }

    private int m3653g(int i) {
        if (this.f3291z == -1 || this.f3261A == -1) {
            KeyCharacterMap load = KeyCharacterMap.load(-1);
            int i2 = 0;
            while (i2 < Math.max(this.f3278m.length(), this.f3279n.length())) {
                if (this.f3278m.toLowerCase(Locale.getDefault()).charAt(i2) != this.f3279n.toLowerCase(Locale.getDefault()).charAt(i2)) {
                    KeyEvent[] events = load.getEvents(new char[]{this.f3278m.toLowerCase(Locale.getDefault()).charAt(i2), this.f3279n.toLowerCase(Locale.getDefault()).charAt(i2)});
                    if (events == null || events.length != 4) {
                        Log.e("TimePickerDialog", "Unable to find keycodes for AM and PM.");
                    } else {
                        this.f3291z = events[0].getKeyCode();
                        this.f3261A = events[2].getKeyCode();
                    }
                } else {
                    i2++;
                }
            }
        }
        return i == 0 ? this.f3291z : i == 1 ? this.f3261A : -1;
    }

    public void m3654a() {
        this.f3267b.m3616c();
    }

    public void mo2615a(int i, int i2, boolean z) {
        if (i == 0) {
            m3631a(i2, false);
            CharSequence format = String.format("%d", new Object[]{Integer.valueOf(i2)});
            if (this.f3280o && z) {
                m3632a(1, true, true, false);
                format = format + ". " + this.f3265E;
            } else {
                this.f3275j.setContentDescription(this.f3262B + ": " + i2);
            }
            C1434h.m3659a(this.f3275j, format);
        } else if (i == 1) {
            m3639b(i2);
            this.f3275j.setContentDescription(this.f3264D + ": " + i2);
        } else if (i == 2) {
            m3630a(i2);
        } else if (i == 3) {
            if (!m3645c()) {
                this.f3289x.clear();
            }
            m3636a(true);
        }
    }

    public void m3656b(C0732c c0732c, int i, int i2, boolean z) {
        this.f3266a = c0732c;
        this.f3281p = i;
        this.f3282q = i2;
        this.f3283r = z;
        this.f3288w = false;
        this.f3284s = false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && bundle.containsKey("hour_of_day") && bundle.containsKey("minute") && bundle.containsKey("is_24_hour_view")) {
            this.f3281p = bundle.getInt("hour_of_day");
            this.f3282q = bundle.getInt("minute");
            this.f3283r = bundle.getBoolean("is_24_hour_view");
            this.f3288w = bundle.getBoolean("in_kb_mode");
            this.f3284s = bundle.getBoolean("dark_theme");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        View inflate = layoutInflater.inflate(R.layout.time_picker_dialog, null);
        OnKeyListener c1430a = new C1430a();
        inflate.findViewById(R.id.time_picker_dialog).setOnKeyListener(c1430a);
        Resources resources = getResources();
        this.f3262B = resources.getString(R.string.hour_picker_description);
        this.f3263C = resources.getString(R.string.select_hours);
        this.f3264D = resources.getString(R.string.minute_picker_description);
        this.f3265E = resources.getString(R.string.select_minutes);
        this.f3276k = resources.getColor(this.f3284s ? R.color.red : R.color.blue);
        this.f3277l = resources.getColor(this.f3284s ? R.color.white : R.color.numbers_text_color);
        this.f3269d = (TextView) inflate.findViewById(R.id.hours);
        this.f3269d.setOnKeyListener(c1430a);
        this.f3270e = (TextView) inflate.findViewById(R.id.hour_space);
        this.f3272g = (TextView) inflate.findViewById(R.id.minutes_space);
        this.f3271f = (TextView) inflate.findViewById(R.id.minutes);
        this.f3271f.setOnKeyListener(c1430a);
        this.f3273h = (TextView) inflate.findViewById(R.id.ampm_label);
        this.f3273h.setOnKeyListener(c1430a);
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.f3278m = amPmStrings[0];
        this.f3279n = amPmStrings[1];
        this.f3267b = new C1419c(getActivity());
        this.f3275j = (RadialPickerLayout) inflate.findViewById(R.id.time_picker);
        this.f3275j.setOnValueSelectedListener(this);
        this.f3275j.setOnKeyListener(c1430a);
        this.f3275j.m3602a(getActivity(), this.f3267b, this.f3281p, this.f3282q, this.f3283r);
        int i = 0;
        if (bundle != null) {
            if (bundle.containsKey("current_item_showing")) {
                i = bundle.getInt("current_item_showing");
            }
        }
        m3632a(i, false, true, true);
        this.f3275j.invalidate();
        this.f3269d.setOnClickListener(new C14261(this));
        this.f3271f.setOnClickListener(new C14272(this));
        this.f3268c = (TextView) inflate.findViewById(R.id.done_button);
        this.f3268c.setOnClickListener(new C14283(this));
        this.f3268c.setOnKeyListener(c1430a);
        this.f3274i = inflate.findViewById(R.id.ampm_hitspace);
        if (this.f3283r) {
            this.f3273h.setVisibility(8);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((TextView) inflate.findViewById(R.id.separator)).setLayoutParams(layoutParams);
        } else {
            this.f3273h.setVisibility(0);
            m3630a(this.f3281p < 12 ? 0 : 1);
            this.f3274i.setOnClickListener(new C14294(this));
        }
        this.f3280o = true;
        m3631a(this.f3281p, true);
        m3639b(this.f3282q);
        this.f3286u = resources.getString(R.string.time_placeholder);
        this.f3287v = resources.getString(R.string.deleted_key);
        this.f3285t = this.f3286u.charAt(0);
        this.f3261A = -1;
        this.f3291z = -1;
        m3650e();
        if (this.f3288w) {
            this.f3289x = bundle.getIntegerArrayList("typed_times");
            m3649d(-1);
            this.f3269d.invalidate();
        } else if (this.f3289x == null) {
            this.f3289x = new ArrayList();
        }
        this.f3275j.m3603a(getActivity().getApplicationContext(), this.f3284s);
        int color = resources.getColor(R.color.white);
        int color2 = resources.getColor(R.color.circle_background);
        int color3 = resources.getColor(R.color.line_background);
        int color4 = resources.getColor(R.color.numbers_text_color);
        ColorStateList colorStateList = resources.getColorStateList(R.color.done_text_color);
        int color5 = resources.getColor(R.color.dark_gray);
        int color6 = resources.getColor(R.color.light_gray);
        int color7 = resources.getColor(R.color.line_dark);
        ColorStateList colorStateList2 = resources.getColorStateList(R.color.done_text_color_dark);
        inflate.findViewById(R.id.time_display_background).setBackgroundColor(this.f3284s ? color5 : color);
        View findViewById = inflate.findViewById(R.id.time_display);
        if (!this.f3284s) {
            color5 = color;
        }
        findViewById.setBackgroundColor(color5);
        ((TextView) inflate.findViewById(R.id.separator)).setTextColor(this.f3284s ? color : color4);
        TextView textView = (TextView) inflate.findViewById(R.id.ampm_label);
        if (!this.f3284s) {
            color = color4;
        }
        textView.setTextColor(color);
        inflate.findViewById(R.id.line).setBackgroundColor(this.f3284s ? color7 : color3);
        this.f3268c.setTextColor(this.f3284s ? colorStateList2 : colorStateList);
        this.f3275j.setBackgroundColor(this.f3284s ? color6 : color2);
        this.f3268c.setBackgroundResource(this.f3284s ? R.drawable.done_background_color_dark : R.drawable.done_background_color);
        return inflate;
    }

    public void onPause() {
        super.onPause();
        this.f3267b.m3615b();
    }

    public void onResume() {
        super.onResume();
        this.f3267b.m3614a();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.f3275j != null) {
            bundle.putInt("hour_of_day", this.f3275j.getHours());
            bundle.putInt("minute", this.f3275j.getMinutes());
            bundle.putBoolean("is_24_hour_view", this.f3283r);
            bundle.putInt("current_item_showing", this.f3275j.getCurrentItemShowing());
            bundle.putBoolean("in_kb_mode", this.f3288w);
            if (this.f3288w) {
                bundle.putIntegerArrayList("typed_times", this.f3289x);
            }
            bundle.putBoolean("dark_theme", this.f3284s);
        }
    }
}
