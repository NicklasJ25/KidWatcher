package com.facebook.ads.internal.p030j.p032b;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.ads.internal.p030j.p032b.p033a.C1634a;
import com.facebook.ads.internal.p030j.p032b.p033a.C1637c;
import com.facebook.ads.internal.p030j.p032b.p033a.C1643f;
import com.facebook.ads.internal.p030j.p032b.p033a.C1644g;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class C1656f {
    private final Object f4080a;
    private final ExecutorService f4081b;
    private final Map<String, C1658g> f4082c;
    private final ServerSocket f4083d;
    private final int f4084e;
    private final Thread f4085f;
    private final C1646c f4086g;
    private boolean f4087h;

    public static final class C1651a {
        private File f4070a;
        private C1637c f4071b = new C1643f();
        private C1634a f4072c = new C1644g(67108864);

        public C1651a(Context context) {
            this.f4070a = C1667o.m4715a(context);
        }

        private C1646c m4660a() {
            return new C1646c(this.f4070a, this.f4071b, this.f4072c);
        }
    }

    private class C1652b implements Callable<Boolean> {
        final /* synthetic */ C1656f f4073a;

        private C1652b(C1656f c1656f) {
            this.f4073a = c1656f;
        }

        public Boolean m4662a() {
            return Boolean.valueOf(this.f4073a.m4673c());
        }

        public /* synthetic */ Object call() {
            return m4662a();
        }
    }

    private class C1653c implements Callable<Boolean> {
        final /* synthetic */ C1656f f4074a;
        private final String f4075b;

        public C1653c(C1656f c1656f, String str) {
            this.f4074a = c1656f;
            this.f4075b = str;
        }

        public Boolean m4663a() {
            return Boolean.valueOf(this.f4074a.m4674c(this.f4075b));
        }

        public /* synthetic */ Object call() {
            return m4663a();
        }
    }

    private final class C1654d implements Runnable {
        final /* synthetic */ C1656f f4076a;
        private final Socket f4077b;

        public C1654d(C1656f c1656f, Socket socket) {
            this.f4076a = c1656f;
            this.f4077b = socket;
        }

        public void run() {
            this.f4076a.m4667a(this.f4077b);
        }
    }

    private final class C1655e implements Runnable {
        final /* synthetic */ C1656f f4078a;
        private final CountDownLatch f4079b;

        public C1655e(C1656f c1656f, CountDownLatch countDownLatch) {
            this.f4078a = c1656f;
            this.f4079b = countDownLatch;
        }

        public void run() {
            this.f4079b.countDown();
            this.f4078a.m4679e();
        }
    }

    public C1656f(Context context) {
        this(new C1651a(context).m4660a());
    }

    private C1656f(C1646c c1646c) {
        Throwable e;
        this.f4080a = new Object();
        this.f4081b = Executors.newFixedThreadPool(8);
        this.f4082c = new ConcurrentHashMap();
        this.f4086g = (C1646c) C1663j.m4705a(c1646c);
        try {
            this.f4083d = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f4084e = this.f4083d.getLocalPort();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f4085f = new Thread(new C1655e(this, countDownLatch));
            this.f4085f.start();
            countDownLatch.await();
            Log.i("ProxyCache", "Proxy cache server started. Ping it...");
            m4669b();
        } catch (IOException e2) {
            e = e2;
            this.f4081b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        } catch (InterruptedException e3) {
            e = e3;
            this.f4081b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    private void m4666a(Throwable th) {
        Log.e("ProxyCache", "HttpProxyCacheServer error", th);
    }

    private void m4667a(Socket socket) {
        Throwable e;
        try {
            C1647d a = C1647d.m4637a(socket.getInputStream());
            Log.i("ProxyCache", "Request to cache proxy:" + a);
            String c = C1666m.m4713c(a.f4056a);
            if ("ping".equals(c)) {
                m4670b(socket);
            } else {
                m4678e(c).m4691a(a, socket);
            }
            m4672c(socket);
            Log.d("ProxyCache", "Opened connections: " + m4681f());
        } catch (SocketException e2) {
            Log.d("ProxyCache", "Closing socket... Socket is closed by client.");
            m4672c(socket);
            Log.d("ProxyCache", "Opened connections: " + m4681f());
        } catch (C1661l e3) {
            e = e3;
            m4666a(new C1661l("Error processing request", e));
            m4672c(socket);
            Log.d("ProxyCache", "Opened connections: " + m4681f());
        } catch (IOException e4) {
            e = e4;
            m4666a(new C1661l("Error processing request", e));
            m4672c(socket);
            Log.d("ProxyCache", "Opened connections: " + m4681f());
        } catch (Throwable th) {
            m4672c(socket);
            Log.d("ProxyCache", "Opened connections: " + m4681f());
        }
    }

    private void m4669b() {
        int i = 300;
        int i2 = 0;
        while (i2 < 3) {
            try {
                this.f4087h = ((Boolean) this.f4081b.submit(new C1652b()).get((long) i, TimeUnit.MILLISECONDS)).booleanValue();
                if (!this.f4087h) {
                    SystemClock.sleep((long) i);
                    i *= 2;
                    i2++;
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                Throwable e2 = e;
                Log.e("ProxyCache", "Error pinging server [attempt: " + i2 + ", timeout: " + i + "]. ", e2);
                i *= 2;
                i2++;
            } catch (ExecutionException e3) {
                e2 = e3;
                Log.e("ProxyCache", "Error pinging server [attempt: " + i2 + ", timeout: " + i + "]. ", e2);
                i *= 2;
                i2++;
            } catch (TimeoutException e4) {
                e2 = e4;
                Log.e("ProxyCache", "Error pinging server [attempt: " + i2 + ", timeout: " + i + "]. ", e2);
                i *= 2;
                i2++;
            }
        }
        Log.e("ProxyCache", "Shutdown server... Error pinging server [attempts: " + i2 + ", max timeout: " + (i / 2) + "].");
        m4683a();
    }

    private void m4670b(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    private void m4672c(Socket socket) {
        m4677d(socket);
        m4680e(socket);
        m4682f(socket);
    }

    private boolean m4673c() {
        boolean equals;
        C1660h c1660h = new C1660h(m4675d("ping"));
        try {
            byte[] bytes = "ping ok".getBytes();
            c1660h.mo2773a(0);
            byte[] bArr = new byte[bytes.length];
            c1660h.mo2772a(bArr);
            equals = Arrays.equals(bytes, bArr);
            Log.d("ProxyCache", "Ping response: `" + new String(bArr) + "`, pinged? " + equals);
            return equals;
        } catch (C1661l e) {
            equals = e;
            Log.e("ProxyCache", "Error reading ping response", equals);
            return false;
        } finally {
            c1660h.mo2774b();
        }
    }

    private boolean m4674c(String str) {
        C1660h c1660h = new C1660h(m4675d(str));
        try {
            c1660h.mo2773a(0);
            while (true) {
                if (c1660h.mo2772a(new byte[8192]) == -1) {
                    break;
                }
            }
            return true;
        } catch (Throwable e) {
            Log.e("ProxyCache", "Error reading url", e);
            return false;
        } finally {
            c1660h.mo2774b();
        }
    }

    private String m4675d(String str) {
        return String.format("http://%s:%d/%s", new Object[]{"127.0.0.1", Integer.valueOf(this.f4084e), C1666m.m4712b(str)});
    }

    private void m4676d() {
        synchronized (this.f4080a) {
            for (C1658g a : this.f4082c.values()) {
                a.m4690a();
            }
            this.f4082c.clear();
        }
    }

    private void m4677d(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException e) {
            Log.d("ProxyCache", "Releasing input stream... Socket is closed by client.");
        } catch (Throwable e2) {
            m4666a(new C1661l("Error closing socket input stream", e2));
        }
    }

    private C1658g m4678e(String str) {
        C1658g c1658g;
        synchronized (this.f4080a) {
            c1658g = (C1658g) this.f4082c.get(str);
            if (c1658g == null) {
                c1658g = new C1658g(str, this.f4086g);
                this.f4082c.put(str, c1658g);
            }
        }
        return c1658g;
    }

    private void m4679e() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f4083d.accept();
                Log.d("ProxyCache", "Accept new socket " + accept);
                this.f4081b.submit(new C1654d(this, accept));
            } catch (Throwable e) {
                m4666a(new C1661l("Error during waiting connection", e));
                return;
            }
        }
    }

    private void m4680e(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (Throwable e) {
            m4666a(new C1661l("Error closing socket output stream", e));
        }
    }

    private int m4681f() {
        int i;
        synchronized (this.f4080a) {
            i = 0;
            for (C1658g b : this.f4082c.values()) {
                i = b.m4692b() + i;
            }
        }
        return i;
    }

    private void m4682f(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (Throwable e) {
            m4666a(new C1661l("Error closing socket", e));
        }
    }

    public void m4683a() {
        Log.i("ProxyCache", "Shutdown proxy server");
        m4676d();
        this.f4085f.interrupt();
        try {
            if (!this.f4083d.isClosed()) {
                this.f4083d.close();
            }
        } catch (Throwable e) {
            m4666a(new C1661l("Error shutting down proxy server", e));
        }
    }

    public void m4684a(String str) {
        int i = 300;
        int i2 = 0;
        while (i2 < 3) {
            try {
                if (!((Boolean) this.f4081b.submit(new C1653c(this, str)).get()).booleanValue()) {
                    SystemClock.sleep((long) i);
                    i *= 2;
                    i2++;
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                Throwable e2 = e;
                Log.e("ProxyCache", "Error precaching url [attempt: " + i2 + ", url: " + str + "]. ", e2);
                i *= 2;
                i2++;
            } catch (ExecutionException e3) {
                e2 = e3;
                Log.e("ProxyCache", "Error precaching url [attempt: " + i2 + ", url: " + str + "]. ", e2);
                i *= 2;
                i2++;
            }
        }
        Log.e("ProxyCache", "Shutdown server... Error precaching url [attempts: " + i2 + ", url: " + str + "].");
        m4683a();
    }

    public String m4685b(String str) {
        if (!this.f4087h) {
            Log.e("ProxyCache", "Proxy server isn't pinged. Caching doesn't work.");
        }
        return this.f4087h ? m4675d(str) : str;
    }
}
