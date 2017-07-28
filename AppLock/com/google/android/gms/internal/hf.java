package com.google.android.gms.internal;

import com.google.android.gms.internal.gp.C2900a;
import com.google.android.gms.internal.jq.C3008a;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

enum hf implements hi {
    INSTANCE;
    
    static ThreadFactory f9188b;
    static final ht f9189c = null;

    class C29341 implements ht {
        C29341() {
        }

        public void mo3701a(Thread thread, String str) {
        }

        public void mo3702a(Thread thread, UncaughtExceptionHandler uncaughtExceptionHandler) {
            thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }

        public void mo3703a(Thread thread, boolean z) {
        }
    }

    class C29352 implements ko {
        C29352(hf hfVar) {
        }

        public void mo3704a(Thread thread, String str) {
            hf.f9189c.mo3701a(thread, str);
        }
    }

    static {
        f9189c = new C29341();
    }

    public static boolean m11357a() {
        return m11358c() != null;
    }

    private static ThreadFactory m11358c() {
        if (f9188b == null) {
            try {
                Class cls = Class.forName("com.google.appengine.api.ThreadManager");
                if (cls != null) {
                    f9188b = (ThreadFactory) cls.getMethod("backgroundThreadFactory", new Class[0]).invoke(null, new Object[0]);
                }
            } catch (ClassNotFoundException e) {
                return null;
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            } catch (Throwable e222) {
                throw new RuntimeException(e222);
            }
        }
        return f9188b;
    }

    public gp mo3605a(ha haVar, gl glVar, gn gnVar, C2900a c2900a) {
        return new gq(haVar.m11322g(), gnVar, c2900a);
    }

    public gw mo3606a(ScheduledExecutorService scheduledExecutorService) {
        throw new RuntimeException("Authentication is not implemented yet");
    }

    public he mo3607a(ha haVar) {
        return new hu(m11358c(), f9189c);
    }

    public im mo3608a(ha haVar, String str) {
        return null;
    }

    public jq mo3609a(ha haVar, C3008a c3008a, List<String> list) {
        return new jo(c3008a, list);
    }

    public hm mo3610b(ha haVar) {
        final jp a = haVar.m11314a("RunLoop");
        return new lb(this) {
            protected ThreadFactory mo3705a() {
                return hf.f9188b;
            }

            public void mo3603a(Throwable th) {
                a.m11958a(lb.m10813b(th), th);
            }

            protected ht mo3706b() {
                return hf.f9189c;
            }
        };
    }

    public void m11365b() {
        kp.m12221a(f9188b, new C29352(this));
    }

    public String mo3611c(ha haVar) {
        String str = "AppEngine";
        String property = System.getProperty("java.specification.version", "Unknown");
        return new StringBuilder((String.valueOf(property).length() + 1) + String.valueOf(str).length()).append(property).append("/").append(str).toString();
    }
}
