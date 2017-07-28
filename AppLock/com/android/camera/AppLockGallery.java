package com.android.camera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.android.gallery3d.app.AbstractGalleryActivity;
import com.android.gallery3d.app.Gallery;
import com.android.gallery3d.app.PhotoPage;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.DataManager;
import com.android.gallery3d.data.Path;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.libs_ads.C1342b;

public final class AppLockGallery extends AbstractGalleryActivity implements OnMenuItemClickListener {
    public boolean f17a = true;
    public boolean f18b = false;
    private View f19c;
    private AppLockApplication f20d;

    private String m18a(Intent intent) {
        String type = intent.getType();
        if (type != null) {
            return type;
        }
        try {
            return getContentResolver().getType(intent.getData());
        } catch (Throwable th) {
            return null;
        }
    }

    private void m19a() {
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("android.intent.action.VIEW".equalsIgnoreCase(action) || Gallery.ACTION_REVIEW.equalsIgnoreCase(action)) {
            m20b(intent);
        } else {
            finish();
        }
    }

    private void m20b(Intent intent) {
        Bundle bundle = new Bundle();
        DataManager dataManager = getDataManager();
        Uri data = intent.getData();
        if (m18a(intent) == null) {
            C1147a.m2486e(this, R.string.no_such_item);
            finish();
            return;
        }
        Path fromString = Path.fromString(data.toString());
        Path defaultSetOf = fromString != null ? dataManager.getDefaultSetOf(fromString) : null;
        boolean z = defaultSetOf == null || intent.getBooleanExtra("SingleItemOnly", false);
        if (!z) {
            bundle.putString("media-set-path", defaultSetOf.toString());
            if (intent.getBooleanExtra(PhotoPage.KEY_TREAT_BACK_AS_UP, false) || (intent.getFlags() & 268435456) != 0) {
                bundle.putBoolean(PhotoPage.KEY_TREAT_BACK_AS_UP, true);
            }
            bundle.putString("media-item-path", fromString.toString());
            getStateManager().startState(PhotoPage.class, bundle);
        }
    }

    public void finish() {
        this.f17a = false;
        this.f18b = true;
        super.finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.gallery_main);
        this.f20d = C1150y.m2566a((Context) this);
        if (bundle != null) {
            getStateManager().restoreFromState(bundle);
        } else {
            m19a();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C1342b.m3328a(this.f19c);
        this.f20d.m598l().clear();
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onPause() {
        super.onPause();
        C1148d.m2520b((Context) this, "latest_leave_app_timemills", (Object) Long.valueOf(System.currentTimeMillis()));
    }

    protected void onResume() {
        Utils.assertTrue(getStateManager().getStateCount() > 0);
        this.f18b = false;
        this.f17a = true;
        C1150y.m2612c((Activity) this);
        super.onResume();
    }

    protected void onStop() {
        if (!this.f18b) {
            C1148d.m2489A(this, "com.domobile.elock.main_finish");
        }
        if (this.f17a) {
            finish();
        }
        this.f18b = false;
        this.f17a = true;
        super.onStop();
    }
}
