package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

public class ed {
    private static final String[] f8817e = new String[]{"/aclk", "/pcs/click"};
    private String f8818a = "googleads.g.doubleclick.net";
    private String f8819b = "/pagead/ads";
    private String f8820c = "ad.doubleclick.net";
    private String[] f8821d = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private ch f8822f;

    public ed(ch chVar) {
        this.f8822f = chVar;
    }

    private Uri m10556a(Uri uri, Context context, String str, boolean z, View view) {
        try {
            boolean b = m10567b(uri);
            if (b) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new ee("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new ee("Query parameter already exists: ms");
            }
            String a = z ? this.f8822f.mo3152a(context, str, view) : this.f8822f.mo3151a(context);
            return b ? m10558b(uri, "dc_ms", a) : m10557a(uri, "ms", a);
        } catch (UnsupportedOperationException e) {
            throw new ee("Provided Uri is not in a valid state");
        }
    }

    private Uri m10557a(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private Uri m10558b(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append(";").append(uri2.substring(indexOf + 1)).toString());
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2)).append(";").append(str).append("=").append(str2).append(";").append(uri2.substring(encodedPath.length() + indexOf2)).toString());
    }

    public Uri m10559a(Uri uri, Context context) {
        return m10556a(uri, context, null, false, null);
    }

    public Uri m10560a(Uri uri, Context context, View view) {
        try {
            return m10556a(uri, context, uri.getQueryParameter("ai"), true, view);
        } catch (UnsupportedOperationException e) {
            throw new ee("Provided Uri is not in a valid state");
        }
    }

    public ch m10561a() {
        return this.f8822f;
    }

    public void m10562a(MotionEvent motionEvent) {
        this.f8822f.mo3154a(motionEvent);
    }

    public void m10563a(String str) {
        this.f8821d = str.split(",");
    }

    public void m10564a(String str, String str2) {
        this.f8818a = str;
        this.f8819b = str2;
    }

    public boolean m10565a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.f8818a) && uri.getPath().equals(this.f8819b);
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Deprecated
    public Uri m10566b(Uri uri, Context context) {
        return m10560a(uri, context, null);
    }

    public boolean m10567b(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.f8820c);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean m10568c(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.f8821d) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean m10569d(Uri uri) {
        if (!m10568c(uri)) {
            return false;
        }
        for (String endsWith : f8817e) {
            if (uri.getPath().endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }
}
