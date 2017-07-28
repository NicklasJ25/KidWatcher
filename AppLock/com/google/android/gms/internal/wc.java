package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class wc {
    private AtomicInteger f11142a;
    private final Map<String, Queue<vb<?>>> f11143b;
    private final Set<vb<?>> f11144c;
    private final PriorityBlockingQueue<vb<?>> f11145d;
    private final PriorityBlockingQueue<vb<?>> f11146e;
    private final ej f11147f;
    private final px f11148g;
    private final xy f11149h;
    private qy[] f11150i;
    private mk f11151j;
    private List<Object> f11152k;

    public wc(ej ejVar, px pxVar) {
        this(ejVar, pxVar, 4);
    }

    public wc(ej ejVar, px pxVar, int i) {
        this(ejVar, pxVar, i, new pa(new Handler(Looper.getMainLooper())));
    }

    public wc(ej ejVar, px pxVar, int i, xy xyVar) {
        this.f11142a = new AtomicInteger();
        this.f11143b = new HashMap();
        this.f11144c = new HashSet();
        this.f11145d = new PriorityBlockingQueue();
        this.f11146e = new PriorityBlockingQueue();
        this.f11152k = new ArrayList();
        this.f11147f = ejVar;
        this.f11148g = pxVar;
        this.f11150i = new qy[i];
        this.f11149h = xyVar;
    }

    public <T> vb<T> m14468a(vb<T> vbVar) {
        vbVar.m9047a(this);
        synchronized (this.f11144c) {
            this.f11144c.add(vbVar);
        }
        vbVar.m9045a(m14472c());
        vbVar.m9053b("add-to-queue");
        if (vbVar.m9064l()) {
            synchronized (this.f11143b) {
                String d = vbVar.m9056d();
                if (this.f11143b.containsKey(d)) {
                    Queue queue = (Queue) this.f11143b.get(d);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(vbVar);
                    this.f11143b.put(d, queue);
                    if (abj.f7796b) {
                        abj.m8755a("Request for cacheKey=%s is in flight, putting on hold.", d);
                    }
                } else {
                    this.f11143b.put(d, null);
                    this.f11145d.add(vbVar);
                }
            }
        } else {
            this.f11146e.add(vbVar);
        }
        return vbVar;
    }

    public void m14469a() {
        m14470b();
        this.f11151j = new mk(this.f11145d, this.f11146e, this.f11147f, this.f11149h);
        this.f11151j.start();
        for (int i = 0; i < this.f11150i.length; i++) {
            qy qyVar = new qy(this.f11146e, this.f11148g, this.f11147f, this.f11149h);
            this.f11150i[i] = qyVar;
            qyVar.start();
        }
    }

    public void m14470b() {
        if (this.f11151j != null) {
            this.f11151j.m12564a();
        }
        for (int i = 0; i < this.f11150i.length; i++) {
            if (this.f11150i[i] != null) {
                this.f11150i[i].m13496a();
            }
        }
    }

    <T> void m14471b(vb<T> vbVar) {
        synchronized (this.f11144c) {
            this.f11144c.remove(vbVar);
        }
        synchronized (this.f11152k) {
            Iterator it = this.f11152k.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (vbVar.m9064l()) {
            synchronized (this.f11143b) {
                Queue queue = (Queue) this.f11143b.remove(vbVar.m9056d());
                if (queue != null) {
                    if (abj.f7796b) {
                        abj.m8755a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), r2);
                    }
                    this.f11145d.addAll(queue);
                }
            }
        }
    }

    public int m14472c() {
        return this.f11142a.incrementAndGet();
    }
}
