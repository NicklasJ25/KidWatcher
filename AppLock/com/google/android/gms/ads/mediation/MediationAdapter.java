package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public interface MediationAdapter {

    public static class zza {
        private int f7134a;

        public zza zzam(int i) {
            this.f7134a = i;
            return this;
        }

        public Bundle zzmm() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.f7134a);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
