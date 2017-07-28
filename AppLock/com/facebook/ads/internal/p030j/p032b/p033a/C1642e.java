package com.facebook.ads.internal.p030j.p032b.p033a;

import android.util.Log;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

abstract class C1642e implements C1634a {
    private final ExecutorService f4049a = Executors.newSingleThreadExecutor();

    private class C1641a implements Callable<Void> {
        final /* synthetic */ C1642e f4047a;
        private final File f4048b;

        public C1641a(C1642e c1642e, File file) {
            this.f4047a = c1642e;
            this.f4048b = file;
        }

        public Void m4623a() {
            this.f4047a.m4627b(this.f4048b);
            return null;
        }

        public /* synthetic */ Object call() {
            return m4623a();
        }
    }

    C1642e() {
    }

    private void m4625a(List<File> list) {
        long b = m4626b((List) list);
        int size = list.size();
        int i = size;
        for (File file : list) {
            if (!mo2768a(file, b, i)) {
                long length = file.length();
                if (file.delete()) {
                    i--;
                    b -= length;
                    Log.i("ProxyCache", "Cache file " + file + " is deleted because it exceeds cache limit");
                    size = i;
                    i = size;
                } else {
                    Log.e("ProxyCache", "Error deleting file " + file + " for trimming cache");
                }
            }
            size = i;
            i = size;
        }
    }

    private long m4626b(List<File> list) {
        long j = 0;
        for (File length : list) {
            j = length.length() + j;
        }
        return j;
    }

    private void m4627b(File file) {
        C1640d.m4620c(file);
        m4625a(C1640d.m4619b(file.getParentFile()));
    }

    public void mo2766a(File file) {
        this.f4049a.submit(new C1641a(this, file));
    }

    protected abstract boolean mo2768a(File file, long j, int i);
}
