package com.google.android.gms.internal;

import android.os.RemoteException;

public abstract class bw<T> {
    private final int f8167a;
    private final String f8168b;
    private final T f8169c;

    public static class C2735a extends bw<Boolean> {
        public C2735a(int i, String str, Boolean bool) {
            super(i, str, bool);
        }

        public /* synthetic */ Object mo3513a(bz bzVar) {
            return m9243b(bzVar);
        }

        public Boolean m9243b(bz bzVar) {
            try {
                return Boolean.valueOf(bzVar.getBooleanFlagValue(m9238a(), ((Boolean) m9239b()).booleanValue(), m9241d()));
            } catch (RemoteException e) {
                return (Boolean) m9239b();
            }
        }
    }

    public static class C2736b extends bw<Integer> {
        public C2736b(int i, String str, Integer num) {
            super(i, str, num);
        }

        public /* synthetic */ Object mo3513a(bz bzVar) {
            return m9245b(bzVar);
        }

        public Integer m9245b(bz bzVar) {
            try {
                return Integer.valueOf(bzVar.getIntFlagValue(m9238a(), ((Integer) m9239b()).intValue(), m9241d()));
            } catch (RemoteException e) {
                return (Integer) m9239b();
            }
        }
    }

    public static class C2737c extends bw<Long> {
        public C2737c(int i, String str, Long l) {
            super(i, str, l);
        }

        public /* synthetic */ Object mo3513a(bz bzVar) {
            return m9247b(bzVar);
        }

        public Long m9247b(bz bzVar) {
            try {
                return Long.valueOf(bzVar.getLongFlagValue(m9238a(), ((Long) m9239b()).longValue(), m9241d()));
            } catch (RemoteException e) {
                return (Long) m9239b();
            }
        }
    }

    public static class C2738d extends bw<String> {
        public C2738d(int i, String str, String str2) {
            super(i, str, str2);
        }

        public /* synthetic */ Object mo3513a(bz bzVar) {
            return m9249b(bzVar);
        }

        public String m9249b(bz bzVar) {
            try {
                return bzVar.getStringFlagValue(m9238a(), (String) m9239b(), m9241d());
            } catch (RemoteException e) {
                return (String) m9239b();
            }
        }
    }

    private bw(int i, String str, T t) {
        this.f8167a = i;
        this.f8168b = str;
        this.f8169c = t;
        ca.m9276a().m9251a(this);
    }

    public static C2735a m9233a(int i, String str, Boolean bool) {
        return new C2735a(i, str, bool);
    }

    public static C2736b m9234a(int i, String str, int i2) {
        return new C2736b(i, str, Integer.valueOf(i2));
    }

    public static C2737c m9235a(int i, String str, long j) {
        return new C2737c(i, str, Long.valueOf(j));
    }

    public static C2738d m9236a(int i, String str, String str2) {
        return new C2738d(i, str, str2);
    }

    protected abstract T mo3513a(bz bzVar);

    public String m9238a() {
        return this.f8168b;
    }

    public T m9239b() {
        return this.f8169c;
    }

    public T m9240c() {
        return ca.m9278b().m9252a(this);
    }

    public int m9241d() {
        return this.f8167a;
    }
}
