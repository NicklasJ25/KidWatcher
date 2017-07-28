package com.domobile.applock.p012e;

import android.content.Context;
import android.net.Uri;
import android.text.format.DateUtils;
import java.io.File;

public class C0899d {
    public String f1340a = "";
    public int f1341b = -1;
    public String f1342c = "";
    public long f1343d;
    public String f1344e = "";
    public String f1345f = "";
    public String f1346g = "";
    public int f1347h;
    public int f1348i;
    public int f1349j;
    public String f1350k = "";
    public C0901f f1351l;

    public String m1574a() {
        return this.f1351l == null ? "" : this.f1351l.m1588a();
    }

    public String m1575a(Context context) {
        try {
            return context.getCacheDir().getAbsolutePath() + File.separator + this.f1346g;
        } catch (Exception e) {
            return "";
        }
    }

    public Uri m1576b(Context context) {
        return Uri.fromFile(new File(m1575a(context)));
    }

    public CharSequence m1577b() {
        return DateUtils.getRelativeTimeSpanString(this.f1343d, System.currentTimeMillis(), 60000, 262144);
    }

    public String toString() {
        return "NotificationInfo{logicId='" + this.f1340a + '\'' + ", notificationId=" + this.f1341b + ", packageName='" + this.f1342c + '\'' + ", postTime=" + this.f1343d + ", title='" + this.f1344e + '\'' + ", content='" + this.f1345f + '\'' + ", iconName='" + this.f1346g + '\'' + ", ledARGB=" + this.f1347h + ", ledOnMS=" + this.f1348i + ", ledOffMS=" + this.f1349j + ", jsonData='" + this.f1350k + '\'' + ", contentIntent=" + this.f1351l + '}';
    }
}
