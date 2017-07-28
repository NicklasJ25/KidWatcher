package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@wh
public final class sk implements sc {
    private final se f10576a;
    private final zzf f10577b;
    private final us f10578c;

    public static class C3239a {
        private final aat f10575a;

        public C3239a(aat com_google_android_gms_internal_aat) {
            this.f10575a = com_google_android_gms_internal_aat;
        }

        public Intent m13721a(Context context, Map<String, String> map) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str = (String) map.get("u");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (this.f10575a != null) {
                str = zzw.zzcM().m15107a(this.f10575a, str);
            }
            Uri parse = Uri.parse(str);
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean parseBoolean2 = Boolean.parseBoolean((String) map.get("use_running_process"));
            Uri build = "http".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("https").build() : "https".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("http").build() : null;
            ArrayList arrayList = new ArrayList();
            Intent a = m13723a(parse);
            Intent a2 = m13723a(build);
            ResolveInfo a3 = m13725a(context, a, arrayList);
            if (a3 != null) {
                return m13722a(a, a3);
            }
            if (a2 != null) {
                ResolveInfo a4 = m13724a(context, a2);
                if (a4 != null) {
                    Intent a5 = m13722a(a, a4);
                    if (m13724a(context, a5) != null) {
                        return a5;
                    }
                }
            }
            if (arrayList.size() == 0) {
                return a;
            }
            if (parseBoolean2 && activityManager != null) {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResolveInfo resolveInfo = (ResolveInfo) it.next();
                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.processName.equals(resolveInfo.activityInfo.packageName)) {
                                return m13722a(a, resolveInfo);
                            }
                        }
                    }
                }
            }
            return parseBoolean ? m13722a(a, (ResolveInfo) arrayList.get(0)) : a;
        }

        public Intent m13722a(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public Intent m13723a(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }

        public ResolveInfo m13724a(Context context, Intent intent) {
            return m13725a(context, intent, new ArrayList());
        }

        public ResolveInfo m13725a(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            ResolveInfo resolveInfo;
            Collection queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (!(queryIntentActivities == null || resolveActivity == null)) {
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                }
            }
            resolveInfo = null;
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        }
    }

    public sk(se seVar, zzf com_google_android_gms_ads_internal_zzf, us usVar) {
        this.f10576a = seVar;
        this.f10577b = com_google_android_gms_ads_internal_zzf;
        this.f10578c = usVar;
    }

    private void m13726a(boolean z) {
        if (this.f10578c != null) {
            this.f10578c.m14289a(z);
        }
    }

    private static boolean m13727a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int m13728b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzw.zzcO().mo4249b();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzw.zzcO().mo4247a();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzw.zzcO().mo4265c();
            }
        }
        return -1;
    }

    private static void m13729b(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        Context context = com_google_android_gms_internal_aat.getContext();
        if (TextUtils.isEmpty((String) map.get("u"))) {
            aad.m8426e("Destination url cannot be empty.");
            return;
        }
        try {
            com_google_android_gms_internal_aat.mo3424l().m8545a(new zzc(new C3239a(com_google_android_gms_internal_aat).m13721a(context, (Map) map)));
        } catch (ActivityNotFoundException e) {
            aad.m8426e(e.getMessage());
        }
    }

    public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        Object a;
        String str = (String) map.get("a");
        if (str == null) {
            aad.m8426e("Action missing from an open GMSG.");
        } else if (this.f10577b == null || this.f10577b.zzcd()) {
            aau l = com_google_android_gms_internal_aat.mo3424l();
            if ("expand".equalsIgnoreCase(str)) {
                if (com_google_android_gms_internal_aat.mo3433p()) {
                    aad.m8426e("Cannot expand WebView that is already expanded.");
                    return;
                }
                m13726a(false);
                l.m8554a(m13727a((Map) map), m13728b(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                str = (String) map.get("u");
                m13726a(false);
                if (str != null) {
                    l.m8555a(m13727a((Map) map), m13728b(map), str);
                } else {
                    l.m8556a(m13727a((Map) map), m13728b(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                str = (String) map.get("product_id");
                r1 = (String) map.get("report_urls");
                if (this.f10576a == null) {
                    return;
                }
                if (r1 == null || r1.isEmpty()) {
                    this.f10576a.zza(str, new ArrayList());
                } else {
                    this.f10576a.zza(str, new ArrayList(Arrays.asList(r1.split(" "))));
                }
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
                m13726a(true);
                m13729b(com_google_android_gms_internal_aat, map);
            } else {
                Intent parseUri;
                Uri data;
                Uri parse;
                m13726a(true);
                str = (String) map.get("intent_url");
                r1 = (String) map.get("u");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        parseUri = Intent.parseUri(str, 0);
                    } catch (Throwable e) {
                        String str2 = "Error parsing the url: ";
                        str = String.valueOf(str);
                        aad.m8422b(str.length() != 0 ? str2.concat(str) : new String(str2), e);
                    }
                    if (!(parseUri == null || parseUri.getData() == null)) {
                        data = parseUri.getData();
                        str = data.toString();
                        if (!TextUtils.isEmpty(str)) {
                            a = zzw.zzcM().m15107a(com_google_android_gms_internal_aat, str);
                            try {
                                parse = Uri.parse(a);
                            } catch (Throwable e2) {
                                String str3 = "Error parsing the uri: ";
                                str = String.valueOf(a);
                                aad.m8422b(str.length() != 0 ? str3.concat(str) : new String(str3), e2);
                            }
                            parseUri.setData(parse);
                        }
                        parse = data;
                        parseUri.setData(parse);
                    }
                    if (parseUri != null) {
                        l.m8545a(new zzc(parseUri));
                    } else {
                        l.m8545a(new zzc((String) map.get("i"), TextUtils.isEmpty(r1) ? zzw.zzcM().m15107a(com_google_android_gms_internal_aat, r1) : r1, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
                    }
                }
                parseUri = null;
                data = parseUri.getData();
                str = data.toString();
                if (TextUtils.isEmpty(str)) {
                    a = zzw.zzcM().m15107a(com_google_android_gms_internal_aat, str);
                    parse = Uri.parse(a);
                    parseUri.setData(parse);
                    if (parseUri != null) {
                        if (TextUtils.isEmpty(r1)) {
                        }
                        l.m8545a(new zzc((String) map.get("i"), TextUtils.isEmpty(r1) ? zzw.zzcM().m15107a(com_google_android_gms_internal_aat, r1) : r1, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
                    } else {
                        l.m8545a(new zzc(parseUri));
                    }
                }
                parse = data;
                parseUri.setData(parse);
                if (parseUri != null) {
                    l.m8545a(new zzc(parseUri));
                } else {
                    if (TextUtils.isEmpty(r1)) {
                    }
                    l.m8545a(new zzc((String) map.get("i"), TextUtils.isEmpty(r1) ? zzw.zzcM().m15107a(com_google_android_gms_internal_aat, r1) : r1, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
                }
            }
        } else {
            this.f10577b.zzx((String) map.get("u"));
        }
    }
}
