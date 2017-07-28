package com.facebook.ads.internal.p018m;

import android.text.TextUtils;
import com.facebook.ads.internal.view.p037a.C1749d;

public class C1735x {
    private final C1749d f4380a;
    private boolean f4381b = true;

    public C1735x(C1749d c1749d) {
        this.f4380a = c1749d;
    }

    private static long m4993a(String str, String str2) {
        long j = -1;
        Object substring = str.substring(str2.length());
        if (!TextUtils.isEmpty(substring)) {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(substring));
                if (valueOf.longValue() >= 0) {
                    j = valueOf.longValue();
                }
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public void m4994a() {
        if (!this.f4381b) {
            return;
        }
        if (this.f4380a.canGoBack() || this.f4380a.canGoForward()) {
            this.f4381b = false;
        } else {
            this.f4380a.m5030b("void((function() {try {  if (!window.performance || !window.performance.timing || !document ||       !document.body || document.body.scrollHeight <= 0 ||       !document.body.children || document.body.children.length < 1) {    return;  }  var nvtiming__an_t = window.performance.timing;  if (nvtiming__an_t.responseEnd > 0) {    console.log('ANNavResponseEnd:'+nvtiming__an_t.responseEnd);  }  if (nvtiming__an_t.domContentLoadedEventStart > 0) {    console.log('ANNavDomContentLoaded:' + nvtiming__an_t.domContentLoadedEventStart);  }  if (nvtiming__an_t.loadEventEnd > 0) {    console.log('ANNavLoadEventEnd:' + nvtiming__an_t.loadEventEnd);  }} catch(err) {  console.log('an_navigation_timing_error:' + err.message);}})());");
        }
    }

    public void m4995a(String str) {
        if (!this.f4381b) {
            return;
        }
        if (str.startsWith("ANNavResponseEnd:")) {
            this.f4380a.m5027a(C1735x.m4993a(str, "ANNavResponseEnd:"));
        } else if (str.startsWith("ANNavDomContentLoaded:")) {
            this.f4380a.m5029b(C1735x.m4993a(str, "ANNavDomContentLoaded:"));
        } else if (str.startsWith("ANNavLoadEventEnd:")) {
            this.f4380a.m5031c(C1735x.m4993a(str, "ANNavLoadEventEnd:"));
        }
    }

    public void m4996a(boolean z) {
        this.f4381b = z;
    }
}
