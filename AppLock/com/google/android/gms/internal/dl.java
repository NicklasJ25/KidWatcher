package com.google.android.gms.internal;

import android.os.Binder;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.C2489m;
import com.google.android.gms.common.C2572n;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2594s;
import com.google.android.gms.internal.cy.C2755a;
import com.google.android.gms.measurement.AppMeasurement.C2803f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class dl extends C2755a {
    private final dk f8554a;
    private Boolean f8555b;
    @Nullable
    private String f8556c;

    public dl(dk dkVar) {
        this(dkVar, null);
    }

    public dl(dk dkVar, @Nullable String str) {
        C2513c.m7932a((Object) dkVar);
        this.f8554a = dkVar;
        this.f8556c = str;
    }

    @BinderThread
    private void m10062b(zzatd com_google_android_gms_internal_zzatd, boolean z) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatd);
        m10063b(com_google_android_gms_internal_zzatd.f11797a, z);
        this.f8554a.m10043o().m10433h(com_google_android_gms_internal_zzatd.f11798b);
    }

    @BinderThread
    private void m10063b(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.f8554a.m10034f().m9815x().m9774a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            m10076a(str, z);
        } catch (SecurityException e) {
            this.f8554a.m10034f().m9815x().m9775a("Measurement Service called with invalid calling package. appId", dc.m9779a(str));
            throw e;
        }
    }

    @BinderThread
    public List<zzauq> mo3552a(final zzatd com_google_android_gms_internal_zzatd, boolean z) {
        Object e;
        m10062b(com_google_android_gms_internal_zzatd, false);
        try {
            List<dx> list = (List) this.f8554a.m10036h().m9936a(new Callable<List<dx>>(this) {
                final /* synthetic */ dl f8546b;

                public List<dx> m10060a() {
                    this.f8546b.f8554a.m9997O();
                    return this.f8546b.f8554a.m10044p().m9567a(com_google_android_gms_internal_zzatd.f11797a);
                }

                public /* synthetic */ Object call() {
                    return m10060a();
                }
            }).get();
            List<zzauq> arrayList = new ArrayList(list.size());
            for (dx dxVar : list) {
                if (z || !dy.m10382l(dxVar.f8703c)) {
                    arrayList.add(new zzauq(dxVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.f8554a.m10034f().m9815x().m9776a("Failed to get user attributes. appId", dc.m9779a(com_google_android_gms_internal_zzatd.f11797a), e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.f8554a.m10034f().m9815x().m9776a("Failed to get user attributes. appId", dc.m9779a(com_google_android_gms_internal_zzatd.f11797a), e);
            return null;
        }
    }

    @BinderThread
    public List<zzatg> mo3553a(final String str, final String str2, final zzatd com_google_android_gms_internal_zzatd) {
        Object e;
        m10062b(com_google_android_gms_internal_zzatd, false);
        try {
            return (List) this.f8554a.m10036h().m9936a(new Callable<List<zzatg>>(this) {
                final /* synthetic */ dl f8523d;

                public List<zzatg> m10057a() {
                    this.f8523d.f8554a.m9997O();
                    return this.f8523d.f8554a.m10044p().m9593b(com_google_android_gms_internal_zzatd.f11797a, str, str2);
                }

                public /* synthetic */ Object call() {
                    return m10057a();
                }
            }).get();
        } catch (InterruptedException e2) {
            e = e2;
        } catch (ExecutionException e3) {
            e = e3;
        }
        this.f8554a.m10034f().m9815x().m9775a("Failed to get conditional user properties", e);
        return Collections.emptyList();
    }

    @BinderThread
    public List<zzatg> mo3554a(final String str, final String str2, final String str3) {
        Object e;
        m10063b(str, true);
        try {
            return (List) this.f8554a.m10036h().m9936a(new Callable<List<zzatg>>(this) {
                final /* synthetic */ dl f8527d;

                public List<zzatg> m10058a() {
                    this.f8527d.f8554a.m9997O();
                    return this.f8527d.f8554a.m10044p().m9593b(str, str2, str3);
                }

                public /* synthetic */ Object call() {
                    return m10058a();
                }
            }).get();
        } catch (InterruptedException e2) {
            e = e2;
        } catch (ExecutionException e3) {
            e = e3;
        }
        this.f8554a.m10034f().m9815x().m9775a("Failed to get conditional user properties", e);
        return Collections.emptyList();
    }

    @BinderThread
    public List<zzauq> mo3555a(final String str, final String str2, final String str3, boolean z) {
        Object e;
        m10063b(str, true);
        try {
            List<dx> list = (List) this.f8554a.m10036h().m9936a(new Callable<List<dx>>(this) {
                final /* synthetic */ dl f8519d;

                public List<dx> m10056a() {
                    this.f8519d.f8554a.m9997O();
                    return this.f8519d.f8554a.m10044p().m9571a(str, str2, str3);
                }

                public /* synthetic */ Object call() {
                    return m10056a();
                }
            }).get();
            List<zzauq> arrayList = new ArrayList(list.size());
            for (dx dxVar : list) {
                if (z || !dy.m10382l(dxVar.f8703c)) {
                    arrayList.add(new zzauq(dxVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.f8554a.m10034f().m9815x().m9776a("Failed to get user attributes. appId", dc.m9779a(str), e);
            return Collections.emptyList();
        } catch (ExecutionException e3) {
            e = e3;
            this.f8554a.m10034f().m9815x().m9776a("Failed to get user attributes. appId", dc.m9779a(str), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public List<zzauq> mo3556a(final String str, final String str2, boolean z, final zzatd com_google_android_gms_internal_zzatd) {
        Object e;
        m10062b(com_google_android_gms_internal_zzatd, false);
        try {
            List<dx> list = (List) this.f8554a.m10036h().m9936a(new Callable<List<dx>>(this) {
                final /* synthetic */ dl f8515d;

                public List<dx> m10055a() {
                    this.f8515d.f8554a.m9997O();
                    return this.f8515d.f8554a.m10044p().m9571a(com_google_android_gms_internal_zzatd.f11797a, str, str2);
                }

                public /* synthetic */ Object call() {
                    return m10055a();
                }
            }).get();
            List<zzauq> arrayList = new ArrayList(list.size());
            for (dx dxVar : list) {
                if (z || !dy.m10382l(dxVar.f8703c)) {
                    arrayList.add(new zzauq(dxVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.f8554a.m10034f().m9815x().m9776a("Failed to get user attributes. appId", dc.m9779a(com_google_android_gms_internal_zzatd.f11797a), e);
            return Collections.emptyList();
        } catch (ExecutionException e3) {
            e = e3;
            this.f8554a.m10034f().m9815x().m9776a("Failed to get user attributes. appId", dc.m9779a(com_google_android_gms_internal_zzatd.f11797a), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public void mo3557a(long j, String str, String str2, String str3) {
        final String str4 = str2;
        final String str5 = str3;
        final String str6 = str;
        final long j2 = j;
        this.f8554a.m10036h().m9938a(new Runnable(this) {
            final /* synthetic */ dl f8553e;

            public void run() {
                if (str4 == null) {
                    this.f8553e.f8554a.m10049u().m10184a(str5, null);
                    return;
                }
                C2803f c2803f = new C2803f();
                c2803f.f8611b = str6;
                c2803f.f8612c = str4;
                c2803f.f8613d = j2;
                this.f8553e.f8554a.m10049u().m10184a(str5, c2803f);
            }
        });
    }

    @BinderThread
    public void mo3558a(final zzatd com_google_android_gms_internal_zzatd) {
        m10062b(com_google_android_gms_internal_zzatd, false);
        this.f8554a.m10036h().m9938a(new Runnable(this) {
            final /* synthetic */ dl f8548b;

            public void run() {
                this.f8548b.f8554a.m9997O();
                this.f8548b.f8554a.m10020b(com_google_android_gms_internal_zzatd);
            }
        });
    }

    @BinderThread
    public void mo3559a(zzatg com_google_android_gms_internal_zzatg) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatg);
        C2513c.m7932a(com_google_android_gms_internal_zzatg.f11814d);
        m10063b(com_google_android_gms_internal_zzatg.f11812b, true);
        final zzatg com_google_android_gms_internal_zzatg2 = new zzatg(com_google_android_gms_internal_zzatg);
        if (com_google_android_gms_internal_zzatg.f11814d.m15354a() == null) {
            this.f8554a.m10036h().m9938a(new Runnable(this) {
                final /* synthetic */ dl f8509b;

                public void run() {
                    this.f8509b.f8554a.m9997O();
                    this.f8509b.f8554a.m10022b(com_google_android_gms_internal_zzatg2);
                }
            });
        } else {
            this.f8554a.m10036h().m9938a(new Runnable(this) {
                final /* synthetic */ dl f8511b;

                public void run() {
                    this.f8511b.f8554a.m9997O();
                    this.f8511b.f8554a.m10008a(com_google_android_gms_internal_zzatg2);
                }
            });
        }
    }

    @BinderThread
    public void mo3560a(zzatg com_google_android_gms_internal_zzatg, final zzatd com_google_android_gms_internal_zzatd) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatg);
        C2513c.m7932a(com_google_android_gms_internal_zzatg.f11814d);
        m10062b(com_google_android_gms_internal_zzatd, false);
        final zzatg com_google_android_gms_internal_zzatg2 = new zzatg(com_google_android_gms_internal_zzatg);
        com_google_android_gms_internal_zzatg2.f11812b = com_google_android_gms_internal_zzatd.f11797a;
        if (com_google_android_gms_internal_zzatg.f11814d.m15354a() == null) {
            this.f8554a.m10036h().m9938a(new Runnable(this) {
                final /* synthetic */ dl f8504c;

                public void run() {
                    this.f8504c.f8554a.m9997O();
                    this.f8504c.f8554a.m10023b(com_google_android_gms_internal_zzatg2, com_google_android_gms_internal_zzatd);
                }
            });
        } else {
            this.f8554a.m10036h().m9938a(new Runnable(this) {
                final /* synthetic */ dl f8507c;

                public void run() {
                    this.f8507c.f8554a.m9997O();
                    this.f8507c.f8554a.m10009a(com_google_android_gms_internal_zzatg2, com_google_android_gms_internal_zzatd);
                }
            });
        }
    }

    @BinderThread
    public void mo3561a(final zzatq com_google_android_gms_internal_zzatq, final zzatd com_google_android_gms_internal_zzatd) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatq);
        m10062b(com_google_android_gms_internal_zzatd, false);
        this.f8554a.m10036h().m9938a(new Runnable(this) {
            final /* synthetic */ dl f8532c;

            public void run() {
                this.f8532c.f8554a.m9997O();
                this.f8532c.f8554a.m10010a(com_google_android_gms_internal_zzatq, com_google_android_gms_internal_zzatd);
            }
        });
    }

    @BinderThread
    public void mo3562a(final zzatq com_google_android_gms_internal_zzatq, final String str, String str2) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatq);
        C2513c.m7934a(str);
        m10063b(str, true);
        this.f8554a.m10036h().m9938a(new Runnable(this) {
            final /* synthetic */ dl f8535c;

            public void run() {
                this.f8535c.f8554a.m9997O();
                this.f8535c.f8554a.m10011a(com_google_android_gms_internal_zzatq, str);
            }
        });
    }

    @BinderThread
    public void mo3563a(final zzauq com_google_android_gms_internal_zzauq, final zzatd com_google_android_gms_internal_zzatd) {
        C2513c.m7932a((Object) com_google_android_gms_internal_zzauq);
        m10062b(com_google_android_gms_internal_zzatd, false);
        if (com_google_android_gms_internal_zzauq.m15354a() == null) {
            this.f8554a.m10036h().m9938a(new Runnable(this) {
                final /* synthetic */ dl f8541c;

                public void run() {
                    this.f8541c.f8554a.m9997O();
                    this.f8541c.f8554a.m10025b(com_google_android_gms_internal_zzauq, com_google_android_gms_internal_zzatd);
                }
            });
        } else {
            this.f8554a.m10036h().m9938a(new Runnable(this) {
                final /* synthetic */ dl f8544c;

                public void run() {
                    this.f8544c.f8554a.m9997O();
                    this.f8544c.f8554a.m10012a(com_google_android_gms_internal_zzauq, com_google_android_gms_internal_zzatd);
                }
            });
        }
    }

    protected void m10076a(String str, boolean z) {
        if (z) {
            if (this.f8555b == null) {
                boolean z2 = "com.google.android.gms".equals(this.f8556c) || C2594s.m8324a(this.f8554a.m10047s(), Binder.getCallingUid()) || C2572n.m8220a(this.f8554a.m10047s()).m8225a(this.f8554a.m10047s().getPackageManager(), Binder.getCallingUid());
                this.f8555b = Boolean.valueOf(z2);
            }
            if (this.f8555b.booleanValue()) {
                return;
            }
        }
        if (this.f8556c == null && C2489m.m7861a(this.f8554a.m10047s(), Binder.getCallingUid(), str)) {
            this.f8556c = str;
        }
        if (!str.equals(this.f8556c)) {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
        }
    }

    @BinderThread
    public byte[] mo3564a(final zzatq com_google_android_gms_internal_zzatq, final String str) {
        Object e;
        C2513c.m7934a(str);
        C2513c.m7932a((Object) com_google_android_gms_internal_zzatq);
        m10063b(str, true);
        this.f8554a.m10034f().m9785C().m9775a("Log and bundle. event", com_google_android_gms_internal_zzatq.f11826a);
        long c = this.f8554a.m10048t().mo3362c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f8554a.m10036h().m9939b(new Callable<byte[]>(this) {
                final /* synthetic */ dl f8538c;

                public byte[] m10059a() {
                    this.f8538c.f8554a.m9997O();
                    return this.f8538c.f8554a.m10027b(com_google_android_gms_internal_zzatq, str);
                }

                public /* synthetic */ Object call() {
                    return m10059a();
                }
            }).get();
            if (bArr == null) {
                this.f8554a.m10034f().m9815x().m9775a("Log and bundle returned null. appId", dc.m9779a(str));
                bArr = new byte[0];
            }
            this.f8554a.m10034f().m9785C().m9777a("Log and bundle processed. event, size, time_ms", com_google_android_gms_internal_zzatq.f11826a, Integer.valueOf(bArr.length), Long.valueOf((this.f8554a.m10048t().mo3362c() / 1000000) - c));
            return bArr;
        } catch (InterruptedException e2) {
            e = e2;
            this.f8554a.m10034f().m9815x().m9777a("Failed to log and bundle. appId, event, error", dc.m9779a(str), com_google_android_gms_internal_zzatq.f11826a, e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.f8554a.m10034f().m9815x().m9777a("Failed to log and bundle. appId, event, error", dc.m9779a(str), com_google_android_gms_internal_zzatq.f11826a, e);
            return null;
        }
    }

    @BinderThread
    public void mo3565b(final zzatd com_google_android_gms_internal_zzatd) {
        m10062b(com_google_android_gms_internal_zzatd, false);
        this.f8554a.m10036h().m9938a(new Runnable(this) {
            final /* synthetic */ dl f8529b;

            public void run() {
                this.f8529b.f8554a.m9997O();
                this.f8529b.f8554a.m10006a(com_google_android_gms_internal_zzatd);
            }
        });
    }

    @BinderThread
    public String mo3566c(zzatd com_google_android_gms_internal_zzatd) {
        m10062b(com_google_android_gms_internal_zzatd, false);
        return this.f8554a.m10019b(com_google_android_gms_internal_zzatd.f11797a);
    }
}
