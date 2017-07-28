package com.domobile.lockbean;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.BaseColumns;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import com.android.gallery3d.common.Entry.Columns;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.C1140x.C1137e;
import com.domobile.applock.R;
import com.domobile.eframe.C1149b;
import com.domobile.eframe.C1224e;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class Alarm implements Parcelable {
    public static final Creator<Alarm> CREATOR = new C13511();
    public int f2906a;
    public boolean f2907b;
    public int f2908c;
    public int f2909d;
    public C1353b f2910e;
    public long f2911f;
    public String f2912g;
    public String f2913h;

    static class C13511 implements Creator<Alarm> {
        C13511() {
        }

        public Alarm m3362a(Parcel parcel) {
            return new Alarm(parcel);
        }

        public Alarm[] m3363a(int i) {
            return new Alarm[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m3362a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m3363a(i);
        }
    }

    public static class C1352a implements BaseColumns {
        public static final String[] f2903a = new String[]{Columns.ID, "hour", "minutes", "daysofweek", "alarmtime", "enabled", "label", "code"};
    }

    public static final class C1353b {
        private static int[] f2904a = new int[]{2, 3, 4, 5, 6, 7, 1};
        private int f2905b;

        public C1353b(int i) {
            this.f2905b = i;
        }

        public static int m3364a(int i) {
            int length = f2904a.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (f2904a[i2] == i) {
                    return i2;
                }
            }
            return 0;
        }

        public int m3365a() {
            return this.f2905b;
        }

        public int m3366a(Calendar calendar) {
            if (this.f2905b == 0) {
                return -1;
            }
            int i = (calendar.get(7) + 5) % 7;
            int i2 = 0;
            while (i2 < 7 && !m3369b((i + i2) % 7)) {
                i2++;
            }
            return i2;
        }

        public String m3367a(Context context, boolean z) {
            int i = 0;
            C1137e c1137e;
            if (this.f2905b == 0) {
                if (!z) {
                    return "";
                }
                c1137e = C1149b.f2209G;
                return context.getString(R.string.never);
            } else if (this.f2905b == TransportMediator.KEYCODE_MEDIA_PAUSE) {
                c1137e = C1149b.f2209G;
                return context.getText(R.string.every_day).toString();
            } else {
                int i2 = 0;
                for (int i3 = this.f2905b; i3 > 0; i3 >>= 1) {
                    if ((i3 & 1) == 1) {
                        i2++;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                String[] shortWeekdays = new DateFormatSymbols(C1224e.m2873a(context)).getShortWeekdays();
                while (i < 7) {
                    if ((this.f2905b & (1 << i)) != 0) {
                        stringBuilder.append(shortWeekdays[f2904a[i]]);
                        i2--;
                        if (i2 > 0) {
                            stringBuilder.append(", ");
                        }
                    }
                    i++;
                }
                return stringBuilder.toString();
            }
        }

        public void m3368a(int i, boolean z) {
            if (z) {
                this.f2905b |= 1 << i;
            } else {
                this.f2905b &= (1 << i) ^ -1;
            }
        }

        public boolean m3369b(int i) {
            return (this.f2905b & (1 << i)) > 0;
        }

        public boolean[] m3370b() {
            boolean[] zArr = new boolean[7];
            for (int i = 0; i < 7; i++) {
                zArr[i] = m3369b(i);
            }
            return zArr;
        }

        public boolean m3371c() {
            return this.f2905b != 0;
        }
    }

    public Alarm() {
        this.f2906a = -1;
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        this.f2908c = instance.get(11);
        this.f2909d = instance.get(12);
        this.f2910e = new C1353b(0);
        this.f2913h = C1359b.m3414a(new Scene(-1, AppLockApplication.m577b().getString(R.string.default_profile)));
    }

    public Alarm(Cursor cursor) {
        boolean z = false;
        this.f2906a = cursor.getInt(0);
        if (cursor.getInt(5) == 1) {
            z = true;
        }
        this.f2907b = z;
        this.f2908c = cursor.getInt(1);
        this.f2909d = cursor.getInt(2);
        this.f2910e = new C1353b(cursor.getInt(3));
        this.f2911f = cursor.getLong(4);
        this.f2912g = cursor.getString(6);
        this.f2913h = cursor.getString(7);
    }

    public Alarm(Parcel parcel) {
        boolean z = true;
        this.f2906a = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f2907b = z;
        this.f2908c = parcel.readInt();
        this.f2909d = parcel.readInt();
        this.f2910e = new C1353b(parcel.readInt());
        this.f2911f = parcel.readLong();
        this.f2912g = parcel.readString();
        this.f2913h = parcel.readString();
    }

    public Alarm(Alarm alarm) {
        this.f2906a = alarm.f2906a;
        this.f2913h = alarm.f2913h;
        this.f2912g = alarm.f2912g;
        this.f2907b = alarm.f2907b;
        this.f2908c = alarm.f2908c;
        this.f2909d = alarm.f2909d;
        this.f2910e = alarm.f2910e;
        this.f2911f = alarm.f2911f;
    }

    public static String m3372a(long j) {
        return new SimpleDateFormat("HH:mm:ss.SSS aaa").format(new Date(j));
    }

    public String m3373a(Context context) {
        return TextUtils.isEmpty(this.f2912g) ? context.getString(R.string.timer_lock) : this.f2912g;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Alarm)) {
            return false;
        }
        return this.f2906a == ((Alarm) obj).f2906a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2906a);
        parcel.writeInt(this.f2907b ? 1 : 0);
        parcel.writeInt(this.f2908c);
        parcel.writeInt(this.f2909d);
        parcel.writeInt(this.f2910e.m3365a());
        parcel.writeLong(this.f2911f);
        parcel.writeString(this.f2912g);
        parcel.writeString(this.f2913h);
    }
}
