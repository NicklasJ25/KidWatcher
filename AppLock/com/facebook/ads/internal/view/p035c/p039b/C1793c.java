package com.facebook.ads.internal.view.p035c.p039b;

import android.content.Context;
import android.widget.TextView;
import com.facebook.ads.internal.p022h.C1511s;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.p035c.p036a.C1769n;
import java.util.concurrent.TimeUnit;

public class C1793c extends C1785n {
    private final TextView f4465b;
    private final String f4466c;
    private final C1511s<C1769n> f4467d = new C17921(this);

    class C17921 extends C1511s<C1769n> {
        final /* synthetic */ C1793c f4464a;

        C17921(C1793c c1793c) {
            this.f4464a = c1793c;
        }

        public Class<C1769n> mo2709a() {
            return C1769n.class;
        }

        public void m5072a(C1769n c1769n) {
            this.f4464a.f4465b.setText(this.f4464a.m5074a((long) (this.f4464a.getVideoView().getDuration() - this.f4464a.getVideoView().getCurrentPosition())));
        }
    }

    public C1793c(Context context, String str) {
        super(context);
        this.f4465b = new TextView(context);
        this.f4466c = str;
        addView(this.f4465b);
    }

    private String m5074a(long j) {
        if (j <= 0) {
            return "00:00";
        }
        long toMinutes = TimeUnit.MILLISECONDS.toMinutes(j);
        long toSeconds = TimeUnit.MILLISECONDS.toSeconds(j % 60000);
        if (this.f4466c.isEmpty()) {
            return String.format("%02d:%02d", new Object[]{Long.valueOf(toMinutes), Long.valueOf(toSeconds)});
        }
        return this.f4466c.replace("{{REMAINING_TIME}}", String.format("%02d:%02d", new Object[]{Long.valueOf(toMinutes), Long.valueOf(toSeconds)}));
    }

    protected void a_(C1864k c1864k) {
        c1864k.getEventBus().m4513a(this.f4467d);
        super.a_(c1864k);
    }

    public void setCountdownTextColor(int i) {
        this.f4465b.setTextColor(i);
    }
}
