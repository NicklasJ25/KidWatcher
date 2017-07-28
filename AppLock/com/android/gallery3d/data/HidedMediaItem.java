package com.android.gallery3d.data;

import android.app.Activity;
import android.content.Context;

public interface HidedMediaItem {

    public interface OnActionDoneListener {
        void deleteHidedMediaDone(boolean z);

        void revertHidedMediaDone(boolean z);
    }

    void broadcastAlbumThumbChanged(Context context, String str);

    void deleteHidedMedia(Activity activity);

    void deleteHidedMediaWithoutConfirm(Context context);

    String getMediaID();

    void revertHidedMedia(Context context);

    void revertHidedMediaConfirm(Activity activity);

    void setOnActionDoneListener(OnActionDoneListener onActionDoneListener);

    void shareHidedMedia(Activity activity);

    void showHidedMediaDetail(Activity activity);
}
