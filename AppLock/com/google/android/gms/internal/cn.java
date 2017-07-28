package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.dc.C2759a;
import com.google.android.gms.internal.dz.C2828a;
import com.google.android.gms.internal.dz.C2829b;
import com.google.android.gms.internal.dz.C2830c;
import com.google.android.gms.internal.dz.C2831d;
import com.google.android.gms.internal.dz.C2832e;
import com.google.android.gms.internal.dz.C2833f;
import com.google.android.gms.internal.eb.C2839a;
import com.google.android.gms.internal.eb.C2840b;
import com.google.android.gms.internal.eb.C2841c;
import com.google.android.gms.internal.eb.C2844f;
import com.google.android.gms.internal.eb.C2845g;
import com.google.android.gms.measurement.AppMeasurement.C3517a;
import com.google.android.gms.measurement.AppMeasurement.C3521e;
import com.google.android.gms.measurement.AppMeasurement.C3523g;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

class cn extends dn {
    cn(dk dkVar) {
        super(dkVar);
    }

    private Boolean m9451a(C2829b c2829b, C2840b c2840b, long j) {
        Boolean a;
        if (c2829b.f8717e != null) {
            a = m9458a(j, c2829b.f8717e);
            if (a == null) {
                return null;
            }
            if (!a.booleanValue()) {
                return Boolean.valueOf(false);
            }
        }
        Set hashSet = new HashSet();
        for (C2830c c2830c : c2829b.f8715c) {
            if (TextUtils.isEmpty(c2830c.f8722d)) {
                mo3548u().m9817z().m9775a("null or empty param name in filter. event", c2840b.f8761b);
                return null;
            }
            hashSet.add(c2830c.f8722d);
        }
        Map arrayMap = new ArrayMap();
        for (C2841c c2841c : c2840b.f8760a) {
            if (hashSet.contains(c2841c.f8766a)) {
                if (c2841c.f8768c != null) {
                    arrayMap.put(c2841c.f8766a, c2841c.f8768c);
                } else if (c2841c.f8770e != null) {
                    arrayMap.put(c2841c.f8766a, c2841c.f8770e);
                } else if (c2841c.f8767b != null) {
                    arrayMap.put(c2841c.f8766a, c2841c.f8767b);
                } else {
                    mo3548u().m9817z().m9776a("Unknown value for param. event, param", c2840b.f8761b, c2841c.f8766a);
                    return null;
                }
            }
        }
        for (C2830c c2830c2 : c2829b.f8715c) {
            boolean equals = Boolean.TRUE.equals(c2830c2.f8721c);
            CharSequence charSequence = c2830c2.f8722d;
            if (TextUtils.isEmpty(charSequence)) {
                mo3548u().m9817z().m9775a("Event has empty param name. event", c2840b.f8761b);
                return null;
            }
            Object obj = arrayMap.get(charSequence);
            if (obj instanceof Long) {
                if (c2830c2.f8720b == null) {
                    mo3548u().m9817z().m9776a("No number filter for long param. event, param", c2840b.f8761b, charSequence);
                    return null;
                }
                a = m9458a(((Long) obj).longValue(), c2830c2.f8720b);
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof Double) {
                if (c2830c2.f8720b == null) {
                    mo3548u().m9817z().m9776a("No number filter for double param. event, param", c2840b.f8761b, charSequence);
                    return null;
                }
                a = m9457a(((Double) obj).doubleValue(), c2830c2.f8720b);
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof String) {
                if (c2830c2.f8719a != null) {
                    a = m9460a((String) obj, c2830c2.f8719a);
                } else if (c2830c2.f8720b == null) {
                    mo3548u().m9817z().m9776a("No filter for String param. event, param", c2840b.f8761b, charSequence);
                    return null;
                } else if (dy.m10383n((String) obj)) {
                    a = m9459a((String) obj, c2830c2.f8720b);
                } else {
                    mo3548u().m9817z().m9776a("Invalid param value for number filter. event, param", c2840b.f8761b, charSequence);
                    return null;
                }
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj == null) {
                mo3548u().m9786D().m9776a("Missing param for filter. event, param", c2840b.f8761b, charSequence);
                return Boolean.valueOf(false);
            } else {
                mo3548u().m9817z().m9776a("Unknown param type. event, param", c2840b.f8761b, charSequence);
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    private Boolean m9452a(C2832e c2832e, C2845g c2845g) {
        C2830c c2830c = c2832e.f8731c;
        if (c2830c == null) {
            mo3548u().m9817z().m9775a("Missing property filter. property", c2845g.f8811b);
            return null;
        }
        boolean equals = Boolean.TRUE.equals(c2830c.f8721c);
        if (c2845g.f8813d != null) {
            if (c2830c.f8720b != null) {
                return m9453a(m9458a(c2845g.f8813d.longValue(), c2830c.f8720b), equals);
            }
            mo3548u().m9817z().m9775a("No number filter for long property. property", c2845g.f8811b);
            return null;
        } else if (c2845g.f8815f != null) {
            if (c2830c.f8720b != null) {
                return m9453a(m9457a(c2845g.f8815f.doubleValue(), c2830c.f8720b), equals);
            }
            mo3548u().m9817z().m9775a("No number filter for double property. property", c2845g.f8811b);
            return null;
        } else if (c2845g.f8812c == null) {
            mo3548u().m9817z().m9775a("User property has no value, property", c2845g.f8811b);
            return null;
        } else if (c2830c.f8719a != null) {
            return m9453a(m9460a(c2845g.f8812c, c2830c.f8719a), equals);
        } else {
            if (c2830c.f8720b == null) {
                mo3548u().m9817z().m9775a("No string or number filter defined. property", c2845g.f8811b);
                return null;
            } else if (dy.m10383n(c2845g.f8812c)) {
                return m9453a(m9459a(c2845g.f8812c, c2830c.f8720b), equals);
            } else {
                mo3548u().m9817z().m9776a("Invalid user property value for Numeric number filter. property, value", c2845g.f8811b, c2845g.f8812c);
                return null;
            }
        }
    }

    static Boolean m9453a(Boolean bool, boolean z) {
        return bool == null ? null : Boolean.valueOf(bool.booleanValue() ^ z);
    }

    private Boolean m9454a(String str, int i, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!(z || i == 1)) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private Boolean m9455a(BigDecimal bigDecimal, int i, BigDecimal bigDecimal2, BigDecimal bigDecimal3, BigDecimal bigDecimal4, double d) {
        boolean z = true;
        if (bigDecimal == null) {
            return null;
        }
        if (i == 4) {
            if (bigDecimal3 == null || bigDecimal4 == null) {
                return null;
            }
        } else if (bigDecimal2 == null) {
            return null;
        }
        switch (i) {
            case 1:
                if (bigDecimal.compareTo(bigDecimal2) != -1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                if (bigDecimal.compareTo(bigDecimal2) != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 3:
                if (d != 0.0d) {
                    if (!(bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) == -1)) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
                if (bigDecimal.compareTo(bigDecimal2) != 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 4:
                if (bigDecimal.compareTo(bigDecimal3) == -1 || bigDecimal.compareTo(bigDecimal4) == 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }

    private List<String> m9456a(String[] strArr, boolean z) {
        if (z) {
            return Arrays.asList(strArr);
        }
        List<String> arrayList = new ArrayList();
        for (String toUpperCase : strArr) {
            arrayList.add(toUpperCase.toUpperCase(Locale.ENGLISH));
        }
        return arrayList;
    }

    public Boolean m9457a(double d, C2831d c2831d) {
        try {
            return m9461a(new BigDecimal(d), c2831d, Math.ulp(d));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Boolean m9458a(long j, C2831d c2831d) {
        try {
            return m9461a(new BigDecimal(j), c2831d, 0.0d);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Boolean m9459a(String str, C2831d c2831d) {
        Boolean bool = null;
        if (dy.m10383n(str)) {
            try {
                bool = m9461a(new BigDecimal(str), c2831d, 0.0d);
            } catch (NumberFormatException e) {
            }
        }
        return bool;
    }

    Boolean m9460a(String str, C2833f c2833f) {
        String str2 = null;
        C2513c.m7932a((Object) c2833f);
        if (str == null || c2833f.f8732a == null || c2833f.f8732a.intValue() == 0) {
            return null;
        }
        if (c2833f.f8732a.intValue() == 6) {
            if (c2833f.f8735d == null || c2833f.f8735d.length == 0) {
                return null;
            }
        } else if (c2833f.f8733b == null) {
            return null;
        }
        int intValue = c2833f.f8732a.intValue();
        boolean z = c2833f.f8734c != null && c2833f.f8734c.booleanValue();
        String toUpperCase = (z || intValue == 1 || intValue == 6) ? c2833f.f8733b : c2833f.f8733b.toUpperCase(Locale.ENGLISH);
        List a = c2833f.f8735d == null ? null : m9456a(c2833f.f8735d, z);
        if (intValue == 1) {
            str2 = toUpperCase;
        }
        return m9454a(str, intValue, z, toUpperCase, a, str2);
    }

    Boolean m9461a(BigDecimal bigDecimal, C2831d c2831d, double d) {
        C2513c.m7932a((Object) c2831d);
        if (c2831d.f8723a == null || c2831d.f8723a.intValue() == 0) {
            return null;
        }
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        if (c2831d.f8723a.intValue() == 4) {
            if (c2831d.f8726d == null || c2831d.f8727e == null) {
                return null;
            }
        } else if (c2831d.f8725c == null) {
            return null;
        }
        int intValue = c2831d.f8723a.intValue();
        if (c2831d.f8723a.intValue() == 4) {
            if (!dy.m10383n(c2831d.f8726d) || !dy.m10383n(c2831d.f8727e)) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(c2831d.f8726d);
                bigDecimal3 = new BigDecimal(c2831d.f8727e);
                bigDecimal4 = null;
            } catch (NumberFormatException e) {
                return null;
            }
        } else if (!dy.m10383n(c2831d.f8725c)) {
            return null;
        } else {
            try {
                bigDecimal4 = new BigDecimal(c2831d.f8725c);
                bigDecimal3 = null;
                bigDecimal2 = null;
            } catch (NumberFormatException e2) {
                return null;
            }
        }
        return m9455a(bigDecimal, intValue, bigDecimal4, bigDecimal2, bigDecimal3, d);
    }

    protected void mo3551a() {
    }

    @WorkerThread
    void m9463a(String str, C2828a[] c2828aArr) {
        C2513c.m7932a((Object) c2828aArr);
        for (C2828a c2828a : c2828aArr) {
            for (C2829b c2829b : c2828a.f8711c) {
                String str2 = (String) C3517a.f12109a.get(c2829b.f8714b);
                if (str2 != null) {
                    c2829b.f8714b = str2;
                }
                for (C2830c c2830c : c2829b.f8715c) {
                    str2 = (String) C3521e.f12110a.get(c2830c.f8722d);
                    if (str2 != null) {
                        c2830c.f8722d = str2;
                    }
                }
            }
            for (C2832e c2832e : c2828a.f8710b) {
                str2 = (String) C3523g.f12111a.get(c2832e.f8730b);
                if (str2 != null) {
                    c2832e.f8730b = str2;
                }
            }
        }
        mo3543p().m9582a(str, c2828aArr);
    }

    @WorkerThread
    C2839a[] m9464a(String str, C2840b[] c2840bArr, C2845g[] c2845gArr) {
        int intValue;
        BitSet bitSet;
        BitSet bitSet2;
        Map map;
        Map map2;
        Boolean a;
        Object obj;
        C2513c.m7934a(str);
        Set hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Map f = mo3543p().m9602f(str);
        if (f != null) {
            for (Integer intValue2 : f.keySet()) {
                intValue = intValue2.intValue();
                C2844f c2844f = (C2844f) f.get(Integer.valueOf(intValue));
                bitSet = (BitSet) arrayMap2.get(Integer.valueOf(intValue));
                bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(intValue));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    arrayMap2.put(Integer.valueOf(intValue), bitSet);
                    bitSet2 = new BitSet();
                    arrayMap3.put(Integer.valueOf(intValue), bitSet2);
                }
                for (int i = 0; i < c2844f.f8807a.length * 64; i++) {
                    if (dy.m10375a(c2844f.f8807a, i)) {
                        mo3548u().m9786D().m9776a("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (dy.m10375a(c2844f.f8808b, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                C2839a c2839a = new C2839a();
                arrayMap.put(Integer.valueOf(intValue), c2839a);
                c2839a.f8758d = Boolean.valueOf(false);
                c2839a.f8757c = c2844f;
                c2839a.f8756b = new C2844f();
                c2839a.f8756b.f8808b = dy.m10376a(bitSet);
                c2839a.f8756b.f8807a = dy.m10376a(bitSet2);
            }
        }
        if (c2840bArr != null) {
            ArrayMap arrayMap4 = new ArrayMap();
            for (C2840b c2840b : c2840bArr) {
                cu cuVar;
                cu a2 = mo3543p().m9566a(str, c2840b.f8761b);
                if (a2 == null) {
                    mo3548u().m9817z().m9776a("Event aggregate wasn't created during raw event logging. appId, event", dc.m9779a(str), c2840b.f8761b);
                    cuVar = new cu(str, c2840b.f8761b, 1, 1, c2840b.f8762c.longValue());
                } else {
                    cuVar = a2.m9651a();
                }
                mo3543p().m9577a(cuVar);
                long j = cuVar.f8290c;
                map = (Map) arrayMap4.get(c2840b.f8761b);
                if (map == null) {
                    map = mo3543p().m9603f(str, c2840b.f8761b);
                    if (map == null) {
                        map = new ArrayMap();
                    }
                    arrayMap4.put(c2840b.f8761b, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                for (Integer intValue22 : r7.keySet()) {
                    int intValue3 = intValue22.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue3))) {
                        mo3548u().m9786D().m9775a("Skipping failed audience ID", Integer.valueOf(intValue3));
                    } else {
                        bitSet = (BitSet) arrayMap2.get(Integer.valueOf(intValue3));
                        bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(intValue3));
                        if (((C2839a) arrayMap.get(Integer.valueOf(intValue3))) == null) {
                            C2839a c2839a2 = new C2839a();
                            arrayMap.put(Integer.valueOf(intValue3), c2839a2);
                            c2839a2.f8758d = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue3), bitSet);
                            bitSet2 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue3), bitSet2);
                        }
                        for (C2829b c2829b : (List) r7.get(Integer.valueOf(intValue3))) {
                            if (mo3548u().m9792a(2)) {
                                mo3548u().m9786D().m9777a("Evaluating filter. audience, filter, event", Integer.valueOf(intValue3), c2829b.f8713a, c2829b.f8714b);
                                mo3548u().m9786D().m9775a("Filter definition", dy.m10359a(c2829b));
                            }
                            if (c2829b.f8713a == null || c2829b.f8713a.intValue() > 256) {
                                mo3548u().m9817z().m9776a("Invalid event filter ID. appId, id", dc.m9779a(str), String.valueOf(c2829b.f8713a));
                            } else if (bitSet.get(c2829b.f8713a.intValue())) {
                                mo3548u().m9786D().m9776a("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), c2829b.f8713a);
                            } else {
                                a = m9451a(c2829b, c2840b, j);
                                C2759a D = mo3548u().m9786D();
                                String str2 = "Event filter result";
                                if (a == null) {
                                    obj = "null";
                                } else {
                                    Boolean bool = a;
                                }
                                D.m9775a(str2, obj);
                                if (a == null) {
                                    hashSet.add(Integer.valueOf(intValue3));
                                } else {
                                    bitSet2.set(c2829b.f8713a.intValue());
                                    if (a.booleanValue()) {
                                        bitSet.set(c2829b.f8713a.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (c2845gArr != null) {
            Map arrayMap5 = new ArrayMap();
            for (C2845g c2845g : c2845gArr) {
                map = (Map) arrayMap5.get(c2845g.f8811b);
                if (map == null) {
                    map = mo3543p().m9604g(str, c2845g.f8811b);
                    if (map == null) {
                        map = new ArrayMap();
                    }
                    arrayMap5.put(c2845g.f8811b, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                for (Integer intValue222 : r7.keySet()) {
                    int intValue4 = intValue222.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue4))) {
                        mo3548u().m9786D().m9775a("Skipping failed audience ID", Integer.valueOf(intValue4));
                    } else {
                        bitSet = (BitSet) arrayMap2.get(Integer.valueOf(intValue4));
                        bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(intValue4));
                        if (((C2839a) arrayMap.get(Integer.valueOf(intValue4))) == null) {
                            c2839a2 = new C2839a();
                            arrayMap.put(Integer.valueOf(intValue4), c2839a2);
                            c2839a2.f8758d = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue4), bitSet);
                            bitSet2 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue4), bitSet2);
                        }
                        for (C2832e c2832e : (List) r7.get(Integer.valueOf(intValue4))) {
                            if (mo3548u().m9792a(2)) {
                                mo3548u().m9786D().m9777a("Evaluating filter. audience, filter, property", Integer.valueOf(intValue4), c2832e.f8729a, c2832e.f8730b);
                                mo3548u().m9786D().m9775a("Filter definition", dy.m10360a(c2832e));
                            }
                            if (c2832e.f8729a == null || c2832e.f8729a.intValue() > 256) {
                                mo3548u().m9817z().m9776a("Invalid property filter ID. appId, id", dc.m9779a(str), String.valueOf(c2832e.f8729a));
                                hashSet.add(Integer.valueOf(intValue4));
                                break;
                            } else if (bitSet.get(c2832e.f8729a.intValue())) {
                                mo3548u().m9786D().m9776a("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue4), c2832e.f8729a);
                            } else {
                                a = m9452a(c2832e, c2845g);
                                C2759a D2 = mo3548u().m9786D();
                                String str3 = "Property filter result";
                                if (a == null) {
                                    obj = "null";
                                } else {
                                    bool = a;
                                }
                                D2.m9775a(str3, obj);
                                if (a == null) {
                                    hashSet.add(Integer.valueOf(intValue4));
                                } else {
                                    bitSet2.set(c2832e.f8729a.intValue());
                                    if (a.booleanValue()) {
                                        bitSet.set(c2832e.f8729a.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        C2839a[] c2839aArr = new C2839a[arrayMap2.size()];
        int i2 = 0;
        for (Integer intValue2222 : arrayMap2.keySet()) {
            intValue = intValue2222.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue))) {
                c2839a2 = (C2839a) arrayMap.get(Integer.valueOf(intValue));
                c2839a = c2839a2 == null ? new C2839a() : c2839a2;
                int i3 = i2 + 1;
                c2839aArr[i2] = c2839a;
                c2839a.f8755a = Integer.valueOf(intValue);
                c2839a.f8756b = new C2844f();
                c2839a.f8756b.f8808b = dy.m10376a((BitSet) arrayMap2.get(Integer.valueOf(intValue)));
                c2839a.f8756b.f8807a = dy.m10376a((BitSet) arrayMap3.get(Integer.valueOf(intValue)));
                mo3543p().m9579a(str, intValue, c2839a.f8756b);
                i2 = i3;
            }
        }
        return (C2839a[]) Arrays.copyOf(c2839aArr, i2);
    }
}
