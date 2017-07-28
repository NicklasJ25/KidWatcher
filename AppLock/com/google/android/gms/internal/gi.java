package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

public class gi {
    private final List<List<String>> f9014a;
    private final List<String> f9015b;

    public gi(List<List<String>> list, List<String> list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.f9014a = list;
        this.f9015b = list2;
    }

    public List<List<String>> m11041a() {
        return Collections.unmodifiableList(this.f9014a);
    }

    public List<String> m11042b() {
        return Collections.unmodifiableList(this.f9015b);
    }
}
