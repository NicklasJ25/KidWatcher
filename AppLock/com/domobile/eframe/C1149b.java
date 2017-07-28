package com.domobile.eframe;

import com.domobile.applock.C1140x.C1133a;
import com.domobile.applock.C1140x.C1134b;
import com.domobile.applock.C1140x.C1135c;
import com.domobile.applock.C1140x.C1136d;
import com.domobile.applock.C1140x.C1137e;
import com.domobile.applock.C1140x.C1138f;
import com.domobile.applock.C1140x.C1139g;
import com.domobile.frame.p000a.C1148d;

public class C1149b extends C1148d {
    public static final String[] f2205C = new String[]{"CREATE TABLE IF NOT EXISTS lock (_id INTEGER PRIMARY KEY, pname TEXT, type INTEGER)", "CREATE TABLE IF NOT EXISTS scenes (_id INTEGER PRIMARY KEY, name TEXT)", "CREATE TABLE IF NOT EXISTS locks (_id INTEGER PRIMARY KEY,sid INTEGER, pname TEXT, type INTEGER,FOREIGN KEY(sid) REFERENCES scenes(_id))", "CREATE TABLE IF NOT EXISTS alarms (_id INTEGER PRIMARY KEY, hour INTEGER, minutes INTEGER, daysofweek INTEGER, alarmtime INTEGER, enabled INTEGER, label TEXT, code TEXT)", "CREATE TABLE IF NOT EXISTS locations (_id INTEGER PRIMARY KEY,wifi TEXT, enabled INTEGER, label TEXT, code TEXT,out_code TEXT)", "create index idxScenesId on scenes(_id);", "create index idxLocksSid on locks(sid);"};
    public static final String[][] f2206D;
    public static final C1139g f2207E = new C1139g();
    public static final C1133a f2208F = new C1133a();
    public static final C1137e f2209G = new C1137e();
    public static final C1135c f2210H = new C1135c();
    public static final C1138f f2211I = new C1138f();
    public static final C1136d f2212J = new C1136d();
    public static final C1134b f2213K = new C1134b();

    static {
        r0 = new String[4][];
        r0[0] = new String[]{"CREATE TABLE IF NOT EXISTS scenes (_id INTEGER PRIMARY KEY, name TEXT)", "CREATE TABLE IF NOT EXISTS locks (_id INTEGER PRIMARY KEY,sid INTEGER, pname TEXT, type INTEGER,FOREIGN KEY(sid) REFERENCES scenes(_id))", "CREATE TABLE IF NOT EXISTS alarms (_id INTEGER PRIMARY KEY, hour INTEGER, minutes INTEGER, daysofweek INTEGER, alarmtime INTEGER, enabled INTEGER, label TEXT, code TEXT)", "CREATE TABLE IF NOT EXISTS locations (_id INTEGER PRIMARY KEY,wifi TEXT, enabled INTEGER, label TEXT, code TEXT)", "create index idxScenesId on scenes(_id);", "create index idxLocksSid on locks(sid);"};
        r0[1] = new String[]{"ALTER TABLE locations ADD out_code TEXT"};
        r0[2] = new String[0];
        r0[3] = new String[0];
        f2206D = r0;
    }
}
