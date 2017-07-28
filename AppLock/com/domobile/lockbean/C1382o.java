package com.domobile.lockbean;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.domobile.applock.R;
import com.domobile.frame.p000a.C1147a;

public class C1382o {
    private static C1382o f3011c;
    private Toast f3012a;
    private View f3013b;

    private C1382o() {
    }

    public static C1382o m3517a() {
        if (f3011c == null) {
            f3011c = new C1382o();
        }
        return f3011c;
    }

    public void m3518a(Context context, int i) {
        if (this.f3012a != null) {
            this.f3012a.cancel();
        }
        Intent intent = new Intent("com.domobile.applock.ACTION_SHOW_STEP_WINDOW");
        intent.setFlags(32);
        intent.putExtra("com.domobile.applock.EXTRA_STEP", i);
        context.sendBroadcast(intent);
    }

    public void m3519b(Context context, int i) {
        if (this.f3013b == null) {
            this.f3013b = LayoutInflater.from(context).inflate(R.layout.step_window, null);
        }
        TextView textView = (TextView) this.f3013b.findViewById(R.id.step_window_text);
        textView.setTextColor(context.getResources().getColor(R.color.step_window_right_textcolor));
        if (i == -1) {
            textView.setText("✔");
        } else if (i == -2) {
            textView.setTextColor(context.getResources().getColor(R.color.step_window_error_textcolor));
            textView.setText("✘");
        } else {
            textView.setText(C1147a.m2480a(Integer.valueOf(i), "/3"));
        }
        if (this.f3012a != null) {
            this.f3012a.cancel();
        }
        this.f3012a = new Toast(context);
        this.f3012a.setGravity(17, 0, 0);
        this.f3012a.setDuration(0);
        this.f3012a.setView(this.f3013b);
        this.f3012a.show();
    }
}
