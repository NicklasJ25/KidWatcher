package com.domobile.applock.chamber.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.domobile.applock.R;

public class SocialInfo implements Parcelable {
    public static final Creator<SocialInfo> CREATOR = new C08851();
    public static final String FACEBOOK_HOME_URL = "https://m.facebook.com/login/save-device/#_=_";
    public static final String FACEBOOK_LOGIN_URL = "https://m.facebook.com/login/";
    public static final String GOOGLE_HOME_URL = "https://plus.google.com";
    public static final String GOOGLE_PLUS_LOGIN_URL = "https://accounts.google.com/ServiceLogin?continue=https://plus.google.com";
    public static final String JS_PREFIX = "DoMobile";
    public static final String LINKEDIN_HOME_URL = "https://www.linkedin.com/nhome/?trk=";
    public static final String LINKEDIN_LOGIN_URL = "https://www.linkedin.com/uas/login";
    public static final int PLATFORM_FACEBOOK = 10;
    public static final int PLATFORM_GOOGLE_PLUS = 13;
    public static final int PLATFORM_LINKEDIN = 12;
    public static final int PLATFORM_TWITTER = 11;
    public static final String TWITTER_HOME_URL = "https://mobile.twitter.com/";
    public static final String TWITTER_LOGIN_URL = "https://mobile.twitter.com/login";
    public String f1299a;
    public int f1300b;
    public String f1301c = "";
    public String f1302d = "";
    public String f1303e = "";
    public String f1304f = "";
    public String f1305g = "";

    static class C08851 implements Creator<SocialInfo> {
        C08851() {
        }

        public SocialInfo m1522a(Parcel parcel) {
            return new SocialInfo(parcel);
        }

        public SocialInfo[] m1523a(int i) {
            return new SocialInfo[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1522a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1523a(i);
        }
    }

    protected SocialInfo(Parcel parcel) {
        this.f1299a = parcel.readString();
        this.f1300b = parcel.readInt();
        this.f1301c = parcel.readString();
        this.f1302d = parcel.readString();
        this.f1303e = parcel.readString();
        this.f1304f = parcel.readString();
        this.f1305g = parcel.readString();
    }

    @DrawableRes
    public static Integer m1524a(int i) {
        return i == 10 ? Integer.valueOf(R.drawable.icon_circle_facebook) : i == 11 ? Integer.valueOf(R.drawable.icon_circle_twitter) : i == 12 ? Integer.valueOf(R.drawable.icon_circle_linkedin) : i == 13 ? Integer.valueOf(R.drawable.icon_circle_google) : Integer.valueOf(0);
    }

    @Nullable
    public static String m1525a(Context context, int i) {
        return i == 10 ? context.getString(R.string.facebook) : i == 11 ? context.getString(R.string.twitter) : i == 12 ? context.getString(R.string.linkedin) : i == 13 ? context.getString(R.string.goole_plus) : "";
    }

    @DrawableRes
    public Integer m1526a() {
        return TextUtils.isEmpty(this.f1301c) ? m1528b() : this.f1300b == 10 ? Integer.valueOf(R.drawable.pic_headpic_facebook) : this.f1300b == 11 ? Integer.valueOf(R.drawable.pic_headpic_twitter) : this.f1300b == 12 ? Integer.valueOf(R.drawable.pic_headpic_linkedin) : this.f1300b == 13 ? Integer.valueOf(R.drawable.pic_headpic_google) : Integer.valueOf(0);
    }

    @Nullable
    public String m1527a(Context context) {
        return m1525a(context, this.f1300b);
    }

    @DrawableRes
    public Integer m1528b() {
        return m1524a(this.f1300b);
    }

    public String m1529b(Context context) {
        return !TextUtils.isEmpty(this.f1302d) ? this.f1302d : !TextUtils.isEmpty(this.f1301c) ? this.f1301c : m1527a(context);
    }

    public String m1530c() {
        return this.f1300b == 10 ? FACEBOOK_LOGIN_URL : this.f1300b == 11 ? TWITTER_LOGIN_URL : this.f1300b == 12 ? LINKEDIN_LOGIN_URL : this.f1300b == 13 ? GOOGLE_PLUS_LOGIN_URL : "";
    }

    public String m1531d() {
        return this.f1300b == 10 ? "javascript:var elements = document.getElementsByName('email')[0].value='" + this.f1301c + "';" : this.f1300b == 11 ? "javascript:var elements = document.getElementsByClassName('_1hXXD236 _1YGC8xFq ktZMpANQ _1VqMahaT _2Z8UymHS')[0].value='" + this.f1301c + "';" : this.f1300b == 12 ? "javascript:var element = document.getElementById('session_key-login').value='" + this.f1301c + "';" : this.f1300b == 13 ? "javascript:var element = document.getElementById('identifierId').value='" + this.f1301c + "';var elements = document.getElementsByClassName('RveJvd snByac')[0].click();" : "";
    }

    public int describeContents() {
        return 0;
    }

    public String m1532e() {
        return this.f1300b == 10 ? "javascript:var element = document.getElementsByName('email')[0];DoMobile.onJsInputAccount(element.value);" : this.f1300b == 11 ? "javascript:var element = document.getElementsByClassName('_1hXXD236 _1YGC8xFq ktZMpANQ _1VqMahaT _2Z8UymHS')[0];DoMobile.onJsInputAccount(element.value);" : this.f1300b == 12 ? "javascript:var element = document.getElementById('session_key-login');DoMobile.onJsInputAccount(element.value);" : this.f1300b == 13 ? "javascript:var element = document.getElementById('profileIdentifier');DoMobile.onJsInputAccount(element.innerHTML);" : "";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1299a);
        parcel.writeInt(this.f1300b);
        parcel.writeString(this.f1301c);
        parcel.writeString(this.f1302d);
        parcel.writeString(this.f1303e);
        parcel.writeString(this.f1304f);
        parcel.writeString(this.f1305g);
    }
}
