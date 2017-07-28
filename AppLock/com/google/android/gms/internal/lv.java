package com.google.android.gms.internal;

public abstract class lv<M extends lv<M>> extends mb {
    protected lx ag;

    private void m9132a(int i, md mdVar) {
        ly lyVar = null;
        if (this.ag == null) {
            this.ag = new lx();
        } else {
            lyVar = this.ag.m12436a(i);
        }
        if (lyVar == null) {
            lyVar = new ly();
            this.ag.m12437a(i, lyVar);
        }
        lyVar.m12444a(mdVar);
    }

    protected int mo3505a() {
        int i = 0;
        if (this.ag == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.ag.m12435a()) {
            i2 += this.ag.m12438b(i).m12442a();
            i++;
        }
        return i2;
    }

    public void mo3506a(lu luVar) {
        if (this.ag != null) {
            for (int i = 0; i < this.ag.m12435a(); i++) {
                this.ag.m12438b(i).m12443a(luVar);
            }
        }
    }

    protected final boolean m9135a(lt ltVar, int i) {
        int r = ltVar.m12360r();
        if (!ltVar.m12340b(i)) {
            return false;
        }
        m9132a(me.m12507b(i), new md(i, ltVar.m12338a(r, ltVar.m12360r() - r)));
        return true;
    }

    public /* synthetic */ Object clone() {
        return mo3819d();
    }

    public M mo3819d() {
        lv lvVar = (lv) super.mo3508e();
        lz.m12450a(this, lvVar);
        return lvVar;
    }

    public /* synthetic */ mb mo3508e() {
        return (lv) clone();
    }
}
