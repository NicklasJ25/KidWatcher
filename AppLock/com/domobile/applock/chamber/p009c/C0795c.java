package com.domobile.applock.chamber.p009c;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.media.session.PlaybackStateCompat;
import android.widget.Toast;
import com.android.camera.C0487k;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.FileInfo;
import com.domobile.applock.chamber.p010b.C0781d;
import com.domobile.applock.p011d.C0890a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C0795c {
    private static C0795c f1046a;
    private HashMap<String, AsyncTask> f1047b = new HashMap();
    private ExecutorService f1048c = Executors.newFixedThreadPool(3);
    private C0769b f1049d;

    public interface C0769b {
        void mo2421a(String str, int i);

        void mo2422a(String str, long j, long j2);
    }

    private class C0794a extends AsyncTask<Void, Long, Boolean> {
        final /* synthetic */ C0795c f1044a;
        private FileInfo f1045b;

        public C0794a(C0795c c0795c, FileInfo fileInfo) {
            this.f1044a = c0795c;
            this.f1045b = fileInfo;
        }

        protected Boolean m1236a(Void... voidArr) {
            Closeable bufferedInputStream;
            IOException e;
            Closeable closeable;
            Throwable th;
            boolean z = false;
            Closeable closeable2 = null;
            File file = new File(this.f1045b.f1289c);
            long j = 0;
            long currentTimeMillis = System.currentTimeMillis();
            publishProgress(new Long[]{Long.valueOf(0), Long.valueOf(0)});
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                bufferedInputStream = new BufferedInputStream(C0890a.m1540a(this.f1045b.f1290d).getInputStream());
                try {
                    closeable2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        byte[] bArr = new byte[16384];
                        long j2 = 0;
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            closeable2.write(bArr, 0, read);
                            long j3 = ((long) read) + j;
                            j2 += (long) read;
                            if (isCancelled()) {
                                file.delete();
                                Boolean valueOf = Boolean.valueOf(false);
                                C0890a.m1541a(bufferedInputStream);
                                C0890a.m1541a(closeable2);
                                return valueOf;
                            } else if (j2 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                                j = j3;
                            } else {
                                j2 = 0;
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                if (currentTimeMillis2 > 0) {
                                    j2 = (j3 / currentTimeMillis2) * 1000;
                                }
                                publishProgress(new Long[]{Long.valueOf(j3), Long.valueOf(j2)});
                                j2 = 0;
                                j = j3;
                            }
                        }
                        closeable2.flush();
                        C0781d.m1199a(this.f1045b.f1287a, 2, j);
                        z = true;
                        C0890a.m1541a(bufferedInputStream);
                        C0890a.m1541a(closeable2);
                    } catch (IOException e2) {
                        e = e2;
                        closeable = bufferedInputStream;
                        bufferedInputStream = closeable2;
                        closeable2 = closeable;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e3) {
                    e = e3;
                    closeable2 = bufferedInputStream;
                    bufferedInputStream = null;
                    try {
                        e.printStackTrace();
                        file.delete();
                        C0781d.m1198a(this.f1045b.f1287a, 4);
                        C0890a.m1541a(closeable2);
                        C0890a.m1541a(bufferedInputStream);
                        return Boolean.valueOf(z);
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = closeable2;
                        closeable2 = bufferedInputStream;
                        bufferedInputStream = closeable;
                        C0890a.m1541a(bufferedInputStream);
                        C0890a.m1541a(closeable2);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    closeable2 = null;
                    C0890a.m1541a(bufferedInputStream);
                    C0890a.m1541a(closeable2);
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                bufferedInputStream = null;
                e.printStackTrace();
                file.delete();
                C0781d.m1198a(this.f1045b.f1287a, 4);
                C0890a.m1541a(closeable2);
                C0890a.m1541a(bufferedInputStream);
                return Boolean.valueOf(z);
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = null;
                closeable2 = null;
                C0890a.m1541a(bufferedInputStream);
                C0890a.m1541a(closeable2);
                throw th;
            }
            return Boolean.valueOf(z);
        }

        protected void m1237a(Boolean bool) {
            super.onCancelled(bool);
            this.f1044a.m1243b(this.f1045b.f1287a);
        }

        protected void m1238a(Long... lArr) {
            super.onProgressUpdate(lArr);
            if (this.f1044a.f1049d != null) {
                this.f1044a.f1049d.mo2422a(this.f1045b.f1287a, lArr[0].longValue(), lArr[1].longValue());
            }
        }

        protected void m1239b(Boolean bool) {
            super.onPostExecute(bool);
            this.f1044a.m1243b(this.f1045b.f1287a);
            if (this.f1044a.f1049d != null) {
                this.f1044a.f1049d.mo2421a(this.f1045b.f1287a, bool.booleanValue() ? 2 : 4);
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m1236a((Void[]) objArr);
        }

        protected /* synthetic */ void onCancelled(Object obj) {
            m1237a((Boolean) obj);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m1239b((Boolean) obj);
        }

        protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
            m1238a((Long[]) objArr);
        }
    }

    private C0795c() {
    }

    public static synchronized C0795c m1241a() {
        C0795c c0795c;
        synchronized (C0795c.class) {
            if (f1046a == null) {
                f1046a = new C0795c();
            }
            c0795c = f1046a;
        }
        return c0795c;
    }

    private void m1243b(String str) {
        this.f1047b.remove(str);
    }

    public void m1244a(C0769b c0769b) {
        this.f1049d = c0769b;
    }

    public void m1245a(String str) {
        AsyncTask asyncTask = (AsyncTask) this.f1047b.remove(str);
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        C0781d.m1198a(str, 3);
    }

    public boolean m1246a(FileInfo fileInfo) {
        Context c = AppLockApplication.m578c();
        if (C0487k.m416a(c, fileInfo.f1291e, new File(fileInfo.f1289c))) {
            this.f1047b.put(fileInfo.f1287a, new C0794a(this, fileInfo).executeOnExecutor(this.f1048c, new Void[0]));
            return true;
        }
        Toast.makeText(c, c.getString(R.string.error_storage_not_enough, new Object[]{c.getString(R.string.download_list_title)}), 0).show();
        return false;
    }
}
