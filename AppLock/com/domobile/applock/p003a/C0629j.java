package com.domobile.applock.p003a;

import android.support.annotation.NonNull;
import com.domobile.frame.p000a.C1258c;
import com.google.android.gms.p004b.C0625a;
import com.google.android.gms.p004b.C2428e;
import com.google.firebase.database.C0623m;
import com.google.firebase.database.C3535a;
import com.google.firebase.database.C3536b;
import com.google.firebase.database.C3576f;

public class C0629j {

    public interface C0627a {
        void mo2491a(boolean z);
    }

    public interface C0628b {
        void mo2492a(int i);
    }

    public static void m750a(@NonNull String str, @NonNull String str2, @NonNull final C0627a c0627a) {
        C3576f.m15583a().m15589b().m15581a("InviteCode").m15581a("UsedList").m15581a(str).m15579a(C0629j.m752b(str2)).mo3306a(new C0625a<Void>() {
            public void mo2380a(@NonNull C2428e<Void> c2428e) {
                c0627a.mo2491a(c2428e.mo3310a());
            }
        });
    }

    public static void m751a(@NonNull final String str, @NonNull final String str2, @NonNull final C0628b c0628b) {
        try {
            C3576f.m15583a().m15588a(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3576f.m15583a().m15589b().m15581a("InviteCode").m15574a(new C0623m() {
            public void mo2378a(C3535a c3535a) {
                int i;
                int i2;
                C1258c.m2987b("**** onDataChange ****");
                Iterable<C3535a> d = c3535a.m15455a("AllList").m15460d();
                Iterable<C3535a> d2 = c3535a.m15455a("UsedList").m15460d();
                String a = C0629j.m752b(str2);
                for (C3535a c3535a2 : d) {
                    if (c3535a2.m15459c().equals(str)) {
                        String str = (String) c3535a2.m15456a();
                        if (str.contains(",")) {
                            String[] split = str.split(",");
                            Object obj = split[0];
                            if ("1".equals(split[1])) {
                                c0628b.mo2492a(1);
                                return;
                            }
                            if ("ALL".equals(obj) || a.equals(obj)) {
                                i = 1;
                            }
                            i = 0;
                        } else {
                            i = 0;
                        }
                        for (C3535a c3535a22 : d2) {
                            if (c3535a22.m15459c().equals(str)) {
                                i2 = 1;
                                break;
                            }
                        }
                        i2 = 0;
                        if (i == 0) {
                            c0628b.mo2492a(0);
                        } else if (i2 == 0) {
                            c0628b.mo2492a(1);
                        } else {
                            c0628b.mo2492a(2);
                        }
                    }
                }
                i = 0;
                while (r4.hasNext()) {
                    if (c3535a22.m15459c().equals(str)) {
                        i2 = 1;
                        break;
                    }
                }
                i2 = 0;
                if (i == 0) {
                    c0628b.mo2492a(0);
                } else if (i2 == 0) {
                    c0628b.mo2492a(2);
                } else {
                    c0628b.mo2492a(1);
                }
            }

            public void mo2379a(C3536b c3536b) {
                c0628b.mo2492a(-1);
            }
        });
    }

    private static String m752b(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }
}
