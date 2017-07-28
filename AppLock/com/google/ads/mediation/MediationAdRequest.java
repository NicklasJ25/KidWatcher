package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest {
    private final Date f4930a;
    private final Gender f4931b;
    private final Set<String> f4932c;
    private final boolean f4933d;
    private final Location f4934e;

    public MediationAdRequest(Date date, Gender gender, Set<String> set, boolean z, Location location) {
        this.f4930a = date;
        this.f4931b = gender;
        this.f4932c = set;
        this.f4933d = z;
        this.f4934e = location;
    }

    public Integer getAgeInYears() {
        if (this.f4930a == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.f4930a);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.f4930a;
    }

    public Gender getGender() {
        return this.f4931b;
    }

    public Set<String> getKeywords() {
        return this.f4932c;
    }

    public Location getLocation() {
        return this.f4934e;
    }

    public boolean isTesting() {
        return this.f4933d;
    }
}
