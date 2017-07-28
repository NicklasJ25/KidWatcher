package com.facebook.ads.internal.p030j.p031a;

import android.os.AsyncTask;

public class C1625h extends AsyncTask<C1626l, Void, C1631n> implements C1620c {
    private C1618a f4026a;
    private C1619b f4027b;
    private Exception f4028c;

    public C1625h(C1618a c1618a, C1619b c1619b) {
        this.f4026a = c1618a;
        this.f4027b = c1619b;
    }

    protected C1631n m4577a(C1626l... c1626lArr) {
        if (c1626lArr != null) {
            try {
                if (c1626lArr.length > 0) {
                    return this.f4026a.m4546a(c1626lArr[0]);
                }
            } catch (Exception e) {
                this.f4028c = e;
                cancel(true);
                return null;
            }
        }
        throw new IllegalArgumentException("DoHttpRequestTask takes exactly one argument of type HttpRequest");
    }

    public void mo2759a(C1626l c1626l) {
        super.execute(new C1626l[]{c1626l});
    }

    protected void m4579a(C1631n c1631n) {
        this.f4027b.mo2775a(c1631n);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m4577a((C1626l[]) objArr);
    }

    protected void onCancelled() {
        this.f4027b.mo2776a(this.f4028c);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m4579a((C1631n) obj);
    }
}
