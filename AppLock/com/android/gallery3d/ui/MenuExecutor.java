package com.android.gallery3d.ui;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import com.android.gallery3d.app.AbstractGalleryActivity;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.DataManager;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.util.Future;
import com.android.gallery3d.util.GalleryUtils;
import com.android.gallery3d.util.ThreadPool.Job;
import com.android.gallery3d.util.ThreadPool.JobContext;
import java.util.ArrayList;

public class MenuExecutor {
    public static final int EXECUTION_RESULT_CANCEL = 3;
    public static final int EXECUTION_RESULT_FAIL = 2;
    public static final int EXECUTION_RESULT_SUCCESS = 1;
    private static final int MSG_DO_SHARE = 4;
    private static final int MSG_TASK_COMPLETE = 1;
    private static final int MSG_TASK_START = 3;
    private static final int MSG_TASK_UPDATE = 2;
    private static final String TAG = "MenuExecutor";
    private final AbstractGalleryActivity mActivity;
    private ProgressDialog mDialog;
    private final Handler mHandler = new SynchronizedHandler(this.mActivity.getGLRoot()) {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    MenuExecutor.this.stopTaskAndDismissDialog();
                    if (message.obj != null) {
                        ((ProgressListener) message.obj).onProgressComplete(message.arg1);
                    }
                    MenuExecutor.this.mSelectionManager.leaveSelectionMode();
                    return;
                case 2:
                    if (MenuExecutor.this.mDialog != null) {
                        MenuExecutor.this.mDialog.setProgress(message.arg1);
                    }
                    if (message.obj != null) {
                        ((ProgressListener) message.obj).onProgressUpdate(message.arg1);
                        return;
                    }
                    return;
                case 3:
                    if (message.obj != null) {
                        ((ProgressListener) message.obj).onProgressStart();
                        return;
                    }
                    return;
                case 4:
                    MenuExecutor.this.mActivity.startActivity((Intent) message.obj);
                    return;
                default:
                    return;
            }
        }
    };
    private final SelectionManager mSelectionManager;
    private Future<?> mTask;
    private boolean mWaitOnStop;

    private class ConfirmDialogListener implements OnCancelListener, OnClickListener {
        private final int mActionId;
        private final ProgressListener mListener;

        public ConfirmDialogListener(int i, ProgressListener progressListener) {
            this.mActionId = i;
            this.mListener = progressListener;
        }

        public void onCancel(DialogInterface dialogInterface) {
            if (this.mListener != null) {
                this.mListener.onConfirmDialogDismissed(false);
            }
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -1) {
                if (this.mListener != null) {
                    this.mListener.onConfirmDialogDismissed(true);
                }
                MenuExecutor.this.onMenuClicked(this.mActionId, this.mListener);
            } else if (this.mListener != null) {
                this.mListener.onConfirmDialogDismissed(false);
            }
        }
    }

    private class MediaOperation implements Job<Void> {
        private final ArrayList<Path> mItems;
        private final ProgressListener mListener;
        private final int mOperation;

        public MediaOperation(int i, ArrayList<Path> arrayList, ProgressListener progressListener) {
            this.mOperation = i;
            this.mItems = arrayList;
            this.mListener = progressListener;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void run(com.android.gallery3d.util.ThreadPool.JobContext r8) {
            /*
            r7 = this;
            r0 = 0;
            r1 = com.android.gallery3d.ui.MenuExecutor.this;
            r1 = r1.mActivity;
            r3 = r1.getDataManager();
            r1 = 1;
            r2 = com.android.gallery3d.ui.MenuExecutor.this;	 Catch:{ Throwable -> 0x004c }
            r4 = r7.mListener;	 Catch:{ Throwable -> 0x004c }
            r2.onProgressStart(r4);	 Catch:{ Throwable -> 0x004c }
            r2 = r7.mItems;	 Catch:{ Throwable -> 0x004c }
            r4 = r2.iterator();	 Catch:{ Throwable -> 0x004c }
            r2 = r0;
        L_0x001a:
            r0 = r4.hasNext();	 Catch:{ Throwable -> 0x004c }
            if (r0 == 0) goto L_0x0082;
        L_0x0020:
            r0 = r4.next();	 Catch:{ Throwable -> 0x004c }
            r0 = (com.android.gallery3d.data.Path) r0;	 Catch:{ Throwable -> 0x004c }
            r5 = r8.isCancelled();	 Catch:{ Throwable -> 0x004c }
            if (r5 == 0) goto L_0x0036;
        L_0x002c:
            r0 = 3;
        L_0x002d:
            r1 = com.android.gallery3d.ui.MenuExecutor.this;
            r2 = r7.mListener;
            r1.onProgressComplete(r0, r2);
        L_0x0034:
            r0 = 0;
            return r0;
        L_0x0036:
            r5 = com.android.gallery3d.ui.MenuExecutor.this;	 Catch:{ Throwable -> 0x004c }
            r6 = r7.mOperation;	 Catch:{ Throwable -> 0x004c }
            r0 = r5.execute(r3, r8, r6, r0);	 Catch:{ Throwable -> 0x004c }
            if (r0 != 0) goto L_0x0041;
        L_0x0040:
            r1 = 2;
        L_0x0041:
            r5 = com.android.gallery3d.ui.MenuExecutor.this;	 Catch:{ Throwable -> 0x004c }
            r0 = r2 + 1;
            r2 = r7.mListener;	 Catch:{ Throwable -> 0x004c }
            r5.onProgressUpdate(r0, r2);	 Catch:{ Throwable -> 0x004c }
            r2 = r0;
            goto L_0x001a;
        L_0x004c:
            r0 = move-exception;
            r2 = "MenuExecutor";
            r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0079 }
            r3.<init>();	 Catch:{ all -> 0x0079 }
            r4 = "failed to execute operation ";
            r3 = r3.append(r4);	 Catch:{ all -> 0x0079 }
            r4 = r7.mOperation;	 Catch:{ all -> 0x0079 }
            r3 = r3.append(r4);	 Catch:{ all -> 0x0079 }
            r4 = " : ";
            r3 = r3.append(r4);	 Catch:{ all -> 0x0079 }
            r0 = r3.append(r0);	 Catch:{ all -> 0x0079 }
            r0 = r0.toString();	 Catch:{ all -> 0x0079 }
            com.android.gallery3d.ui.Log.m453e(r2, r0);	 Catch:{ all -> 0x0079 }
            r0 = com.android.gallery3d.ui.MenuExecutor.this;
            r2 = r7.mListener;
            r0.onProgressComplete(r1, r2);
            goto L_0x0034;
        L_0x0079:
            r0 = move-exception;
            r2 = com.android.gallery3d.ui.MenuExecutor.this;
            r3 = r7.mListener;
            r2.onProgressComplete(r1, r3);
            throw r0;
        L_0x0082:
            r0 = r1;
            goto L_0x002d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.gallery3d.ui.MenuExecutor.MediaOperation.run(com.android.gallery3d.util.ThreadPool$JobContext):java.lang.Void");
        }
    }

    public interface ProgressListener {
        void onConfirmDialogDismissed(boolean z);

        void onConfirmDialogShown();

        void onProgressComplete(int i);

        void onProgressStart();

        void onProgressUpdate(int i);
    }

    public MenuExecutor(AbstractGalleryActivity abstractGalleryActivity, SelectionManager selectionManager) {
        this.mActivity = (AbstractGalleryActivity) Utils.checkNotNull(abstractGalleryActivity);
        this.mSelectionManager = (SelectionManager) Utils.checkNotNull(selectionManager);
    }

    private static ProgressDialog createProgressDialog(Context context, int i, int i2) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(i);
        progressDialog.setMax(i2);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        if (i2 > 1) {
            progressDialog.setProgressStyle(1);
        }
        return progressDialog;
    }

    private boolean execute(DataManager dataManager, JobContext jobContext, int i, Path path) {
        Log.m457v(TAG, "Execute cmd: " + i + " for " + path);
        System.currentTimeMillis();
        return true;
    }

    private Intent getIntentBySingleSelectedPath(String str) {
        DataManager dataManager = this.mActivity.getDataManager();
        Path singleSelectedPath = getSingleSelectedPath();
        return new Intent(str).setDataAndType(dataManager.getContentUri(singleSelectedPath), getMimeType(dataManager.getMediaType(singleSelectedPath)));
    }

    public static String getMimeType(int i) {
        switch (i) {
            case 2:
                return GalleryUtils.MIME_TYPE_IMAGE;
            case 4:
                return GalleryUtils.MIME_TYPE_VIDEO;
            default:
                return GalleryUtils.MIME_TYPE_ALL;
        }
    }

    private Path getSingleSelectedPath() {
        boolean z = true;
        ArrayList selected = this.mSelectionManager.getSelected(true);
        if (selected.size() != 1) {
            z = false;
        }
        Utils.assertTrue(z);
        return (Path) selected.get(0);
    }

    private void onMenuClicked(int i, ProgressListener progressListener) {
        onMenuClicked(i, progressListener, false, true);
    }

    private void onProgressComplete(int i, ProgressListener progressListener) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, 0, progressListener));
    }

    private void onProgressStart(ProgressListener progressListener) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, progressListener));
    }

    private void onProgressUpdate(int i, ProgressListener progressListener) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, i, 0, progressListener));
    }

    private static void setMenuItemVisible(Menu menu, int i, boolean z) {
        MenuItem findItem = menu.findItem(i);
        if (findItem != null) {
            findItem.setVisible(z);
        }
    }

    private void stopTaskAndDismissDialog() {
        if (this.mTask != null) {
            if (!this.mWaitOnStop) {
                this.mTask.cancel();
            }
            this.mTask.waitDone();
            this.mDialog.dismiss();
            this.mDialog = null;
            this.mTask = null;
        }
    }

    public void onMenuClicked(int i, ProgressListener progressListener, boolean z, boolean z2) {
    }

    public void onMenuClicked(MenuItem menuItem, String str, ProgressListener progressListener) {
        int itemId = menuItem.getItemId();
        if (str != null) {
            if (progressListener != null) {
                progressListener.onConfirmDialogShown();
            }
            OnClickListener confirmDialogListener = new ConfirmDialogListener(itemId, progressListener);
            new Builder(this.mActivity.getAndroidContext()).setMessage(str).setOnCancelListener(confirmDialogListener).setPositiveButton(17039370, confirmDialogListener).setNegativeButton(17039360, confirmDialogListener).create().show();
            return;
        }
        onMenuClicked(itemId, progressListener);
    }

    public void pause() {
        stopTaskAndDismissDialog();
    }

    public void startAction(int i, int i2, ProgressListener progressListener) {
        startAction(i, i2, progressListener, false, true);
    }

    public void startAction(int i, int i2, ProgressListener progressListener, boolean z, boolean z2) {
        ArrayList selected = this.mSelectionManager.getSelected(false);
        stopTaskAndDismissDialog();
        this.mDialog = createProgressDialog(this.mActivity, i2, selected.size());
        if (z2) {
            this.mDialog.show();
        }
        this.mTask = this.mActivity.getThreadPool().submit(new MediaOperation(i, selected, progressListener), null);
        this.mWaitOnStop = z;
    }
}
