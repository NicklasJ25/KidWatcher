package com.google.android.gms.internal;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@wh
public class tl implements tk {
    private final tj f10768a;
    private final HashSet<SimpleEntry<String, sc>> f10769b = new HashSet();

    public tl(tj tjVar) {
        this.f10768a = tjVar;
    }

    public void mo4044a() {
        Iterator it = this.f10769b.iterator();
        while (it.hasNext()) {
            SimpleEntry simpleEntry = (SimpleEntry) it.next();
            String str = "Unregistering eventhandler: ";
            String valueOf = String.valueOf(((sc) simpleEntry.getValue()).toString());
            zh.m15051a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.f10768a.mo3409b((String) simpleEntry.getKey(), (sc) simpleEntry.getValue());
        }
        this.f10769b.clear();
    }

    public void mo3402a(String str, sc scVar) {
        this.f10768a.mo3402a(str, scVar);
        this.f10769b.add(new SimpleEntry(str, scVar));
    }

    public void mo3384a(String str, String str2) {
        this.f10768a.mo3384a(str, str2);
    }

    public void mo3385a(String str, JSONObject jSONObject) {
        this.f10768a.mo3385a(str, jSONObject);
    }

    public void mo3409b(String str, sc scVar) {
        this.f10768a.mo3409b(str, scVar);
        this.f10769b.remove(new SimpleEntry(str, scVar));
    }

    public void mo3410b(String str, JSONObject jSONObject) {
        this.f10768a.mo3410b(str, jSONObject);
    }
}
