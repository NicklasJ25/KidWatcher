package com.domobile.cropimage;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public class C0590n extends Activity {
    private final ArrayList<C1200b> f453a = new ArrayList();

    public interface C1200b {
        void mo2517a(C0590n c0590n);

        void mo2518b(C0590n c0590n);

        void mo2519c(C0590n c0590n);

        void mo2520d(C0590n c0590n);
    }

    public static class C1201a implements C1200b {
        public void mo2517a(C0590n c0590n) {
        }

        public void mo2518b(C0590n c0590n) {
        }

        public void mo2519c(C0590n c0590n) {
        }

        public void mo2520d(C0590n c0590n) {
        }
    }

    public void m601a(C1200b c1200b) {
        if (!this.f453a.contains(c1200b)) {
            this.f453a.add(c1200b);
        }
    }

    public void m602b(C1200b c1200b) {
        this.f453a.remove(c1200b);
    }

    public void onBackPressed() {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iterator it = this.f453a.iterator();
        while (it.hasNext()) {
            ((C1200b) it.next()).mo2520d(this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        Iterator it = this.f453a.iterator();
        while (it.hasNext()) {
            ((C1200b) it.next()).mo2517a(this);
        }
    }

    public boolean onSearchRequested() {
        return false;
    }

    protected void onStart() {
        super.onStart();
        Iterator it = this.f453a.iterator();
        while (it.hasNext()) {
            ((C1200b) it.next()).mo2519c(this);
        }
    }

    protected void onStop() {
        super.onStop();
        Iterator it = this.f453a.iterator();
        while (it.hasNext()) {
            ((C1200b) it.next()).mo2518b(this);
        }
    }
}
