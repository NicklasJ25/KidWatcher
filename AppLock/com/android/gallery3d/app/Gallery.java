package com.android.gallery3d.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.android.gallery3d.C0488R;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.DataManager;
import com.android.gallery3d.data.Path;

public final class Gallery extends AbstractGalleryActivity implements OnMenuItemClickListener {
    public static final String ACTION_REVIEW = "com.android.camera.action.REVIEW";
    public static final String EXTRA_CROP = "crop";
    public static final String KEY_DISMISS_KEYGUARD = "dismiss-keyguard";
    public static final String KEY_GET_ALBUM = "get-album";
    public static final String KEY_GET_CONTENT = "get-content";
    public static final String KEY_MEDIA_TYPES = "mediaTypes";

    private String getContentType(Intent intent) {
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

    private void initializeByIntent() {
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("android.intent.action.VIEW".equalsIgnoreCase(action) || ACTION_REVIEW.equalsIgnoreCase(action)) {
            startViewAction(intent);
        } else {
            finish();
        }
    }

    private void startViewAction(Intent intent) {
        Bundle bundle = new Bundle();
        DataManager dataManager = getDataManager();
        Uri data = intent.getData();
        if (getContentType(intent) == null) {
            Toast.makeText(this, C0488R.string.no_such_item, 1).show();
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

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0488R.layout.gallery_main);
        if (bundle != null) {
            getStateManager().restoreFromState(bundle);
        } else {
            initializeByIntent();
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

    protected void onResume() {
        Utils.assertTrue(getStateManager().getStateCount() > 0);
        super.onResume();
    }
}
