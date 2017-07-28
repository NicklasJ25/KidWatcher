package com.google.android.gms.internal;

import com.google.android.gms.internal.nk.C3101a;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

@wh
public class np {
    private final nj f10038a;
    private final int f10039b;
    private String f10040c;
    private String f10041d;
    private final boolean f10042e = false;
    private final int f10043f;
    private final int f10044g;

    public class C3103a implements Comparator<ni> {
        public C3103a(np npVar) {
        }

        public int m12830a(ni niVar, ni niVar2) {
            if (niVar.m12801b() < niVar2.m12801b()) {
                return -1;
            }
            if (niVar.m12801b() > niVar2.m12801b()) {
                return 1;
            }
            if (niVar.m12800a() < niVar2.m12800a()) {
                return -1;
            }
            if (niVar.m12800a() > niVar2.m12800a()) {
                return 1;
            }
            float d = (niVar.m12803d() - niVar.m12801b()) * (niVar.m12802c() - niVar.m12800a());
            float d2 = (niVar2.m12803d() - niVar2.m12801b()) * (niVar2.m12802c() - niVar2.m12800a());
            return d <= d2 ? d < d2 ? 1 : 0 : -1;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m12830a((ni) obj, (ni) obj2);
        }
    }

    public np(int i, int i2, int i3) {
        this.f10039b = i;
        if (i2 > 64 || i2 < 0) {
            this.f10043f = 64;
        } else {
            this.f10043f = i2;
        }
        if (i3 < 1) {
            this.f10044g = 1;
        } else {
            this.f10044g = i3;
        }
        this.f10038a = new no(this.f10043f);
    }

    String m12831a(String str, char c) {
        StringBuilder stringBuilder = new StringBuilder(str);
        Object obj = null;
        int i = 1;
        while (i + 2 <= stringBuilder.length()) {
            if (stringBuilder.charAt(i) == '\'') {
                if (stringBuilder.charAt(i - 1) == c || !((stringBuilder.charAt(i + 1) == 's' || stringBuilder.charAt(i + 1) == 'S') && (i + 2 == stringBuilder.length() || stringBuilder.charAt(i + 2) == c))) {
                    stringBuilder.setCharAt(i, c);
                } else {
                    stringBuilder.insert(i, c);
                    i += 2;
                }
                obj = 1;
            }
            i++;
        }
        return obj != null ? stringBuilder.toString() : null;
    }

    public String m12832a(ArrayList<String> arrayList, ArrayList<ni> arrayList2) {
        Collections.sort(arrayList2, new C3103a(this));
        HashSet hashSet = new HashSet();
        int i = 0;
        while (i < arrayList2.size() && m12833a(Normalizer.normalize((CharSequence) arrayList.get(((ni) arrayList2.get(i)).m12804e()), Form.NFKC).toLowerCase(Locale.US), hashSet)) {
            i++;
        }
        C3101a c3101a = new C3101a();
        this.f10040c = "";
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            try {
                c3101a.m12808a(this.f10038a.mo3848a((String) it.next()));
            } catch (Throwable e) {
                aad.m8422b("Error while writing hash to byteStream", e);
            }
        }
        return c3101a.toString();
    }

    boolean m12833a(String str, HashSet<String> hashSet) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return true;
        }
        for (String str2 : split) {
            String str22;
            String a;
            String[] a2;
            int i;
            Object obj;
            int i2;
            boolean z;
            if (str22.indexOf("'") != -1) {
                a = m12831a(str22, ' ');
                if (a != null) {
                    this.f10041d = a;
                    a2 = nl.m12815a(a, true);
                    if (a2.length < this.f10044g) {
                        for (i = 0; i < a2.length; i++) {
                            obj = "";
                            for (i2 = 0; i2 < this.f10044g; i2++) {
                                if (i + i2 >= a2.length) {
                                    z = false;
                                    break;
                                }
                                if (i2 > 0) {
                                    obj = String.valueOf(obj).concat(" ");
                                }
                                String valueOf = String.valueOf(obj);
                                str22 = String.valueOf(a2[i + i2]);
                                obj = str22.length() == 0 ? valueOf.concat(str22) : new String(valueOf);
                            }
                            z = true;
                            if (!z) {
                                break;
                            }
                            hashSet.add(obj);
                            if (hashSet.size() < this.f10039b) {
                                return false;
                            }
                        }
                        if (hashSet.size() >= this.f10039b) {
                            return false;
                        }
                    }
                }
            }
            a = str22;
            a2 = nl.m12815a(a, true);
            if (a2.length < this.f10044g) {
                for (i = 0; i < a2.length; i++) {
                    obj = "";
                    for (i2 = 0; i2 < this.f10044g; i2++) {
                        if (i + i2 >= a2.length) {
                            z = false;
                            break;
                        }
                        if (i2 > 0) {
                            obj = String.valueOf(obj).concat(" ");
                        }
                        String valueOf2 = String.valueOf(obj);
                        str22 = String.valueOf(a2[i + i2]);
                        if (str22.length() == 0) {
                        }
                    }
                    z = true;
                    if (!z) {
                        break;
                    }
                    hashSet.add(obj);
                    if (hashSet.size() < this.f10039b) {
                        return false;
                    }
                }
                if (hashSet.size() >= this.f10039b) {
                    return false;
                }
            }
        }
        return true;
    }
}
