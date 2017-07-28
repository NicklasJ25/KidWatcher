package com.domobile.applock.chamber.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.InputDeviceCompat;
import com.domobile.applock.C0386c;
import com.domobile.applock.chamber.model.BookmarkInfo;
import com.domobile.applock.chamber.model.FileInfo;
import com.domobile.applock.chamber.model.SocialInfo;
import com.domobile.frame.C0399d;

public class BrowserHostActivity extends C0386c {
    private int f1090d;

    public static void m1306a(Activity activity, int i) {
        Intent intent = new Intent(activity, BrowserHostActivity.class);
        intent.putExtra("EXTRA_FRAGMENT", InputDeviceCompat.SOURCE_KEYBOARD);
        activity.startActivityForResult(intent, i);
    }

    public static void m1307a(Context context) {
        Intent intent = new Intent(context, BrowserHostActivity.class);
        intent.putExtra("EXTRA_FRAGMENT", 260);
        context.startActivity(intent);
    }

    public static void m1308a(Context context, BookmarkInfo bookmarkInfo) {
        Intent intent = new Intent(context, BrowserHostActivity.class);
        intent.putExtra("EXTRA_FRAGMENT", 259);
        intent.putExtra("EXTRA_BOOKMARK", bookmarkInfo);
        context.startActivity(intent);
    }

    public static void m1309a(Context context, SocialInfo socialInfo) {
        Intent intent = new Intent(context, BrowserHostActivity.class);
        intent.putExtra("EXTRA_FRAGMENT", 264);
        intent.putExtra("EXTRA_SOCIAL_INFO", socialInfo);
        context.startActivity(intent);
    }

    public static void m1310a(Fragment fragment, int i) {
        Intent intent = new Intent(fragment.getContext(), BrowserHostActivity.class);
        intent.putExtra("EXTRA_FRAGMENT", InputDeviceCompat.SOURCE_KEYBOARD);
        fragment.startActivityForResult(intent, i);
    }

    public static void m1311a(Fragment fragment, int i, FileInfo fileInfo) {
        Intent intent = new Intent(fragment.getContext(), BrowserHostActivity.class);
        intent.putExtra("EXTRA_FRAGMENT", 261);
        intent.putExtra("EXTRA_FILE_INFO", fileInfo);
        fragment.startActivityForResult(intent, i);
    }

    public static void m1312b(Context context) {
        Intent intent = new Intent(context, BrowserHostActivity.class);
        intent.putExtra("EXTRA_FRAGMENT", 263);
        context.startActivity(intent);
    }

    public static void m1313b(Fragment fragment, int i, FileInfo fileInfo) {
        Intent intent = new Intent(fragment.getContext(), BrowserHostActivity.class);
        intent.putExtra("EXTRA_FRAGMENT", 262);
        intent.putExtra("EXTRA_FILE_INFO", fileInfo);
        fragment.startActivityForResult(intent, i);
    }

    public boolean mo2046b() {
        switch (this.f1090d) {
            case 261:
            case 262:
                return true;
            default:
                return super.mo2046b();
        }
    }

    public void onCreate(Bundle bundle) {
        this.f1090d = getIntent().getIntExtra("EXTRA_FRAGMENT", -1);
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        C0399d c0399d = null;
        switch (this.f1090d) {
            case 256:
                c0399d = new C0842c();
                break;
            case InputDeviceCompat.SOURCE_KEYBOARD /*257*/:
                c0399d = new C0837b();
                break;
            case 259:
                c0399d = new C0832a();
                break;
            case 260:
                c0399d = new C0851e();
                break;
            case 261:
                c0399d = new C0857f();
                break;
            case 262:
                c0399d = new C0881l();
                break;
            case 263:
                c0399d = new C0868j();
                break;
            case 264:
                c0399d = new C0864i();
                break;
            case 265:
                c0399d = new C0874k();
                break;
        }
        if (c0399d != null) {
            c0399d.setArguments(extras);
            m52a(c0399d);
        }
    }

    protected void onStop() {
        m80e();
        super.onStop();
    }
}
