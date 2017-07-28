package com.domobile.applock;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.IPackageDataObserver;
import android.content.pm.IPackageDataObserver.Stub;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.Formatter;
import android.view.View;
import android.view.View.OnClickListener;
import com.domobile.frame.C0384c;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.ui.C1288c;
import com.domobile.preference.Preference;
import com.domobile.preference.Preference.OnPreferenceClickListener;
import com.domobile.preference.PreferenceFragment;
import org.apache.p068a.p069a.C3613c;

public class C1038q extends PreferenceFragment implements OnPreferenceClickListener {
    Preference f1869a;
    Preference f1870b;
    Handler f1871c = new Handler();
    PackageManager f1872d;
    int f1873e = 3;

    class C10321 extends Thread {
        final /* synthetic */ C1038q f1861a;

        C10321(C1038q c1038q) {
            this.f1861a = c1038q;
        }

        public void run() {
            final long i = C3613c.m15745i(this.f1861a.mActivity.getCacheDir());
            final String formatFileSize = Formatter.formatFileSize(this.f1861a.mActivity, i);
            this.f1861a.f1871c.post(new Runnable(this) {
                final /* synthetic */ C10321 f1860c;

                public void run() {
                    this.f1860c.f1861a.f1870b.setEnabled(i > 0);
                    this.f1860c.f1861a.f1870b.setSummary(C1147a.m2480a(this.f1860c.f1861a.mActivity.getString(R.string.cache_size_label), " ", formatFileSize));
                }
            });
        }
    }

    class C10342 extends Thread {
        final /* synthetic */ C1038q f1865a;

        C10342(C1038q c1038q) {
            this.f1865a = c1038q;
        }

        public void run() {
            final long i = C3613c.m15745i(this.f1865a.mActivity.getFilesDir().getParentFile());
            final String formatFileSize = Formatter.formatFileSize(this.f1865a.mActivity, i);
            this.f1865a.f1871c.post(new Runnable(this) {
                final /* synthetic */ C10342 f1864c;

                public void run() {
                    this.f1864c.f1865a.f1869a.setEnabled(i > 0);
                    this.f1864c.f1865a.f1869a.setSummary(C1147a.m2480a(this.f1864c.f1865a.mActivity.getString(R.string.data_size_label), " ", formatFileSize));
                }
            });
        }
    }

    class C10353 implements OnClickListener {
        final /* synthetic */ C1038q f1866a;

        C10353(C1038q c1038q) {
            this.f1866a = c1038q;
        }

        public void onClick(View view) {
            this.f1866a.f1869a.setEnabled(false);
            this.f1866a.f1870b.setEnabled(false);
            this.f1866a.m2079f();
        }
    }

    class C10364 implements Runnable {
        final /* synthetic */ C1038q f1867a;

        C10364(C1038q c1038q) {
            this.f1867a = c1038q;
        }

        public void run() {
            this.f1867a.f1873e--;
            this.f1867a.m2079f();
        }
    }

    class C10375 extends Stub {
        final /* synthetic */ C1038q f1868a;

        C10375(C1038q c1038q) {
            this.f1868a = c1038q;
        }

        public void onRemoveCompleted(String str, boolean z) {
        }
    }

    private void m2076c() {
        this.f1870b.setEnabled(false);
        new C10321(this).start();
    }

    private void m2077d() {
        this.f1869a.setEnabled(false);
        new C10342(this).start();
    }

    private void m2078e() {
        C1288c c1288c = new C1288c(this.mActivity);
        c1288c.m3101a((int) R.string.clear_data_dlg_title).m3117b(true);
        c1288c.m3102a(17039360, null);
        c1288c.m3123d((int) R.string.clear_data_dlg_text);
        c1288c.m3114b(17039370, new C10353(this)).m3122d();
    }

    @SuppressLint({"StringFormatMatches"})
    private void m2079f() {
        if (this.f1873e >= 1) {
            C1147a.m2487w(this.mActivity, this.mActivity.getString(R.string.quit_app_delay_3second, new Object[]{Integer.valueOf(this.f1873e)}));
            this.f1871c.postDelayed(new C10364(this), 1500);
            return;
        }
        m2081b();
    }

    public void m2080a() {
        this.f1870b.setEnabled(false);
        try {
            C3613c.m15739c(this.mActivity.getCacheDir());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            m2076c();
        }
    }

    public void m2081b() {
        this.f1870b.setEnabled(false);
        try {
            Intent intent = new Intent("com.domobile.applock.START_RECEIVER");
            intent.setFlags(32);
            intent.putExtra("extra_not_start", true);
            this.mActivity.sendBroadcast(intent);
            ActivityManager activityManager = (ActivityManager) this.mActivity.getSystemService("activity");
            activityManager.getClass().getMethod("clearApplicationUserData", new Class[]{String.class, IPackageDataObserver.class}).invoke(activityManager, new Object[]{this.mActivity.getPackageName(), new C10375(this)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mActivity.getIntent().getBooleanExtra("com.domobile.elock.EXTRA_MANAGER_SPACE", false)) {
            this.f1872d = this.mActivity.getPackageManager();
            ((C0384c) this.mActivity).m54a(this.mActivity.getApplicationInfo().loadLabel(this.f1872d).toString());
            addPreferencesFromResource(R.xml.manage_space);
            this.f1869a = findPreference("clear_user_data_pref");
            this.f1870b = findPreference("clear_cache_pref");
            this.f1869a.setOnPreferenceClickListener(this);
            this.f1870b.setOnPreferenceClickListener(this);
            m2077d();
            m2076c();
            return;
        }
        Intent intent = new Intent(this.mActivity, MainActivity.class);
        intent.putExtra("com.domobile.elock.EXTRA_MANAGER_SPACE", true);
        this.mActivity.startActivity(intent);
        ((C0386c) this.mActivity).mo2042a();
    }

    public boolean onPreferenceClick(Preference preference) {
        String key = preference.getKey();
        if ("clear_user_data_pref".equals(key)) {
            m2078e();
        } else if ("clear_cache_pref".equals(key)) {
            m2080a();
        }
        return false;
    }

    public void ui(int i, Message message) {
    }
}
