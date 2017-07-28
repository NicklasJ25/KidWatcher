package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.android.gallery3d.util.BucketNames;
import com.google.android.gms.C2315a.C2307b;
import com.google.android.gms.ads.internal.zzw;
import java.util.Map;

@wh
public class uu extends ux {
    private final Map<String, String> f10957a;
    private final Context f10958b;

    class C33452 implements OnClickListener {
        final /* synthetic */ uu f10956a;

        C33452(uu uuVar) {
            this.f10956a = uuVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f10956a.m14275b("User canceled the download.");
        }
    }

    public uu(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        super(com_google_android_gms_internal_aat, "storePicture");
        this.f10957a = map;
        this.f10958b = com_google_android_gms_internal_aat.mo3418f();
    }

    Request m14297a(String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        zzw.zzcO().mo4248a(request);
        return request;
    }

    String m14298a(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    public void m14299a() {
        if (this.f10958b == null) {
            m14275b("Activity context is not available");
        } else if (zzw.zzcM().m15153e(this.f10958b).m13210c()) {
            final String str = (String) this.f10957a.get("iurl");
            if (TextUtils.isEmpty(str)) {
                m14275b("Image url cannot be empty.");
            } else if (URLUtil.isValidUrl(str)) {
                final String a = m14298a(str);
                if (zzw.zzcM().m15148c(a)) {
                    Resources t = zzw.zzcQ().m15031t();
                    Builder d = zzw.zzcM().m15150d(this.f10958b);
                    d.setTitle(t != null ? t.getString(C2307b.store_picture_title) : "Save image");
                    d.setMessage(t != null ? t.getString(C2307b.store_picture_message) : "Allow Ad to store image in Picture gallery?");
                    d.setPositiveButton(t != null ? t.getString(C2307b.accept) : "Accept", new OnClickListener(this) {
                        final /* synthetic */ uu f10955c;

                        public void onClick(DialogInterface dialogInterface, int i) {
                            try {
                                ((DownloadManager) this.f10955c.f10958b.getSystemService(BucketNames.DOWNLOAD)).enqueue(this.f10955c.m14297a(str, a));
                            } catch (IllegalStateException e) {
                                this.f10955c.m14275b("Could not store picture.");
                            }
                        }
                    });
                    d.setNegativeButton(t != null ? t.getString(C2307b.decline) : "Decline", new C33452(this));
                    d.create().show();
                    return;
                }
                r1 = "Image type not recognized: ";
                str = String.valueOf(a);
                m14275b(str.length() != 0 ? r1.concat(str) : new String(r1));
            } else {
                r1 = "Invalid image url: ";
                str = String.valueOf(str);
                m14275b(str.length() != 0 ? r1.concat(str) : new String(r1));
            }
        } else {
            m14275b("Feature is not supported by the device.");
        }
    }
}
