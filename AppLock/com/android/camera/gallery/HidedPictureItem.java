package com.android.camera.gallery;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.android.camera.C0411e;
import com.android.camera.C0423j;
import com.android.camera.C0433g;
import com.android.camera.C0433g.C0427a;
import com.android.camera.C0433g.C0432b;
import com.android.camera.C0487k;
import com.android.gallery3d.app.AbstractGalleryActivity;
import com.android.gallery3d.app.GalleryApp;
import com.android.gallery3d.common.Entry.Columns;
import com.android.gallery3d.data.DecodeUtils;
import com.android.gallery3d.data.HidedMediaItem;
import com.android.gallery3d.data.HidedMediaItem.OnActionDoneListener;
import com.android.gallery3d.data.ImageCacheRequest;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.data.MediaObject;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.ui.FadeTexture;
import com.android.gallery3d.util.GalleryUtils;
import com.android.gallery3d.util.ThreadPool.Job;
import com.android.gallery3d.util.ThreadPool.JobContext;
import com.android.gallery3d.util.UpdateHelper;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.C0386c;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.p003a.C0633m;
import com.domobile.applock.service.HidedMediasActionService;
import com.domobile.applock.service.HidedMediasActionService.C1054c;
import com.domobile.frame.C0384c;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1288c;
import com.domobile.p016c.C1170b;
import java.io.File;
import java.io.IOException;
import org.apache.p068a.p069a.C3613c;
import org.apache.p068a.p069a.C3614d;

public class HidedPictureItem extends MediaItem implements Parcelable, C0449h, HidedMediaItem {
    public static final Creator<HidedPictureItem> CREATOR = new C04341();
    public static final Path ITEM_PATH = Path.fromString("/applock");
    public String f182a;
    public String f183b;
    public String f184c;
    public String f185d;
    public String f186e;
    public String f187f;
    public String f188g;
    public String f189h;
    public String f190i;
    public int f191j;
    public int f192k;
    public boolean f193l;
    private int f194m;
    private int f195n;
    private GalleryApp f196o;
    private Handler f197p;
    private OnActionDoneListener f198q;

    static class C04341 implements Creator<HidedPictureItem> {
        C04341() {
        }

        public HidedPictureItem m252a(Parcel parcel) {
            return new HidedPictureItem(parcel);
        }

        public HidedPictureItem[] m253a(int i) {
            return new HidedPictureItem[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m252a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m253a(i);
        }
    }

    class C04467 implements C0432b {
        final /* synthetic */ HidedPictureItem f179a;

        C04467(HidedPictureItem hidedPictureItem) {
            this.f179a = hidedPictureItem;
        }

        public void mo2079a(C0427a c0427a) {
            c0427a.mo2078a(null, this.f179a);
        }
    }

    public static class C0447a extends ImageCacheRequest {
        private String f180a;

        C0447a(GalleryApp galleryApp, Path path, int i, String str) {
            super(galleryApp, path, i, MediaItem.getTargetSize(i));
            this.f180a = str;
        }

        public Bitmap onDecodeOriginal(JobContext jobContext, int i) {
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            int targetSize = MediaItem.getTargetSize(i);
            if (i == 2) {
                byte[] bArr = null;
                try {
                    ExifInterface exifInterface = new ExifInterface(this.f180a);
                    if (exifInterface != null) {
                        bArr = exifInterface.getThumbnail();
                    }
                } catch (Throwable th) {
                }
                if (bArr != null) {
                    Bitmap decodeIfBigEnough = DecodeUtils.decodeIfBigEnough(jobContext, bArr, options, targetSize);
                    if (decodeIfBigEnough != null) {
                        return decodeIfBigEnough;
                    }
                }
            }
            return DecodeUtils.decodeThumbnail(jobContext, this.f180a, options, targetSize, i);
        }
    }

    public static class C0448b implements Job<BitmapRegionDecoder> {
        String f181a;

        public C0448b(String str) {
            this.f181a = str;
        }

        public BitmapRegionDecoder m255a(JobContext jobContext) {
            return DecodeUtils.createBitmapRegionDecoder(jobContext, this.f181a, false);
        }

        public /* synthetic */ Object run(JobContext jobContext) {
            return m255a(jobContext);
        }
    }

    private HidedPictureItem(Parcel parcel) {
        super(Path.fromString(C1147a.m2480a("/applock/Camera/1")), MediaObject.nextVersionNumber());
        this.f191j = -1;
        this.f194m = -1;
        this.f195n = 0;
        this.f182a = parcel.readString();
        this.f183b = parcel.readString();
        this.f184c = parcel.readString();
        this.f185d = parcel.readString();
        this.f186e = parcel.readString();
        this.f187f = parcel.readString();
        this.f188g = parcel.readString();
        this.f189h = parcel.readString();
        this.f191j = parcel.readInt();
        this.f190i = parcel.readString();
        this.f195n = parcel.readInt();
    }

    public HidedPictureItem(HidedPictureItem hidedPictureItem) {
        super(hidedPictureItem.mPath, MediaObject.nextVersionNumber());
        this.f191j = -1;
        this.f194m = -1;
        this.f195n = 0;
        this.f182a = hidedPictureItem.f182a;
        this.f183b = hidedPictureItem.f183b;
        this.f184c = hidedPictureItem.f184c;
        this.f185d = hidedPictureItem.f185d;
        this.f186e = hidedPictureItem.f186e;
        this.f187f = hidedPictureItem.f187f;
        this.f188g = hidedPictureItem.f188g;
        this.f189h = hidedPictureItem.f189h;
        this.f191j = hidedPictureItem.f191j;
        this.f190i = hidedPictureItem.f190i;
        this.f195n = hidedPictureItem.f195n;
    }

    public HidedPictureItem(C0450f c0450f) {
        super(m265a(c0450f), MediaObject.nextVersionNumber());
        this.f191j = -1;
        this.f194m = -1;
        this.f195n = 0;
        this.f188g = c0450f.getMimeType();
        this.f187f = c0450f.mo2099h();
        this.f185d = c0450f.mo2082a();
        this.f189h = c0450f.mo2082a();
        this.f190i = c0450f.mo2108b().toString();
        this.f195n = c0450f.mo2085d();
        if (TextUtils.isEmpty(this.f184c)) {
            this.f184c = C3614d.m15751c(new File(this.f189h).getParent());
        }
    }

    public HidedPictureItem(Path path, Context context, Cursor cursor) {
        super(path, MediaObject.nextVersionNumber());
        this.f191j = -1;
        this.f194m = -1;
        this.f195n = 0;
        this.f196o = C1150y.m2566a(context);
        this.f182a = cursor.getString(cursor.getColumnIndex(Columns.ID));
        this.f184c = cursor.getString(cursor.getColumnIndex("album"));
        this.f185d = C0487k.m425c(context, cursor.getString(cursor.getColumnIndex("dest_path")));
        this.f189h = cursor.getString(cursor.getColumnIndex("from_path"));
        this.f187f = cursor.getString(cursor.getColumnIndex("thumb_path"));
        this.f188g = cursor.getString(cursor.getColumnIndex("file_type"));
        this.f195n = cursor.getInt(cursor.getColumnIndex("rotation"));
        File file = new File(this.f185d);
        this.f183b = C3614d.m15751c(this.f189h);
        this.f186e = Formatter.formatFileSize(context, file.length());
    }

    public HidedPictureItem(File file, String str) {
        super(m266a(file), MediaObject.nextVersionNumber());
        this.f191j = -1;
        this.f194m = -1;
        this.f195n = 0;
        this.f188g = str;
        this.f185d = file.getAbsolutePath();
        this.f189h = file.getAbsolutePath();
        this.f190i = null;
        this.f195n = 0;
        if (TextUtils.isEmpty(this.f184c)) {
            this.f184c = C3614d.m15751c(new File(this.f189h).getParent());
        }
    }

    public static Path m264a(Cursor cursor) {
        return Path.fromString(C1147a.m2480a("/applock/", cursor.getString(cursor.getColumnIndex("album")), "/", Integer.valueOf(cursor.getInt(cursor.getColumnIndex(Columns.ID)))));
    }

    public static Path m265a(C0450f c0450f) {
        return Path.fromString(C1147a.m2480a("/applock", c0450f.mo2082a()));
    }

    public static Path m266a(File file) {
        return Path.fromString(C1147a.m2480a("/applock", file.getAbsolutePath()));
    }

    private static String m267a(int i) {
        switch (i) {
            case 0:
                return String.valueOf(1);
            case 90:
                return String.valueOf(6);
            case FadeTexture.DURATION /*180*/:
                return String.valueOf(3);
            case 270:
                return String.valueOf(8);
            default:
                throw new AssertionError("invalid: " + i);
        }
    }

    private void m268a(Activity activity, String str) {
        C1288c c1288c = new C1288c(activity);
        c1288c.m3101a((int) R.string.operation_failed).mo2528a((CharSequence) str);
        c1288c.m3113b((int) R.drawable.icon_dialog_alert_holo_light);
        c1288c.m3114b(17039370, null);
        c1288c.m3117b(true).m3122d();
    }

    private void m269a(final Context context) {
        new Handler(context.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ HidedPictureItem f178b;

            public void run() {
                C1147a.m2486e(context, R.string.move_file_error);
            }
        });
    }

    public static void m270a(Context context, String str, String str2, boolean z) {
        Intent intent = new Intent("com.domobile.elock.action.ACTION_RELOAD_ALBUM_IMAGE");
        intent.putExtra("com.domobile.elock.EXTRA_DATA_STRING", str);
        intent.putExtra("com.domobile.elock.EXTRA_IS_VIDEO_TYPE", z);
        intent.putExtra("android.intent.extra.TEXT", str2);
        C1148d.m2510a(context, intent);
    }

    public static boolean m273a(String str) {
        return TextUtils.isEmpty(str) || !str.contains("image");
    }

    public static String m275b(String str) {
        return C1170b.m2685b(C1147a.m2480a(str, "com.domobile.applock")).toLowerCase();
    }

    private void m276i() {
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(this.f185d, options);
            this.f194m = options.outWidth;
            this.f191j = options.outHeight;
        } catch (Exception e) {
            this.f194m = 0;
            this.f191j = 0;
        }
    }

    public String mo2082a() {
        return this.f185d;
    }

    public void m278a(final Activity activity, final boolean z) {
        C0433g.m244a(activity, new Runnable(this) {
            final /* synthetic */ HidedPictureItem f176c;

            class C04431 extends Thread {
                final /* synthetic */ C04445 f173a;

                C04431(C04445 c04445) {
                    this.f173a = c04445;
                }

                public void run() {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    File file = new File(this.f173a.f176c.f185d);
                    if (HidedMediasActionService.m2144a(file)) {
                        this.f173a.f176c.m269a(activity);
                        if (this.f173a.f176c.f198q != null) {
                            this.f173a.f176c.f198q.deleteHidedMediaDone(false);
                        }
                    } else {
                        if (!file.exists() || file.delete()) {
                            if (!(TextUtils.isEmpty(this.f173a.f176c.f187f) || HidedMediasActionService.m2145a(this.f173a.f176c.f187f))) {
                                new File(this.f173a.f176c.f187f).delete();
                            }
                            this.f173a.f176c.m282b(activity, z);
                        }
                        C1150y.m2566a(activity).m598l().add(this.f173a.f176c.f182a);
                        if (this.f173a.f176c.f198q != null) {
                            this.f173a.f176c.f198q.deleteHidedMediaDone(true);
                        }
                    }
                    if (activity instanceof AbstractGalleryActivity) {
                        ((AbstractGalleryActivity) activity).hideLoadingDialog();
                    } else if (activity instanceof C0384c) {
                        ((C0384c) activity).m51E();
                    }
                }
            }

            public void run() {
                if (activity instanceof AbstractGalleryActivity) {
                    ((AbstractGalleryActivity) activity).showCancelableLoadingDialog();
                } else if (activity instanceof C0384c) {
                    ((C0384c) activity).m50D();
                }
                new C04431(this).start();
            }
        }, !m289g());
    }

    protected void m279a(Context context, Cursor cursor) {
        if (m283b(context, cursor)) {
            this.mDataVersion = MediaObject.nextVersionNumber();
        }
    }

    public void m280a(Context context, boolean z) {
        C0633m c0633m = new C0633m();
        c0633m.f575c = 2;
        this.f192k = 2;
        c0633m.f573a = this.f184c;
        c0633m.f574b.add(this);
        C1150y.m2566a(context).m596j().put(this.f184c, c0633m);
        HidedMediasActionService.m2136a(context, z);
    }

    public String m281b() {
        return this.f189h;
    }

    public void m282b(Context context, boolean z) {
        try {
            C0411e.m157a().delete("medias", C1147a.m2480a(Columns.ID, "=", this.f182a), null);
            if (z) {
                if (TextUtils.isEmpty(this.f184c)) {
                    this.f184c = C3614d.m15751c(new File(this.f189h).getParent());
                }
                Intent intent = new Intent(m289g() ? "com.domobile.elock.action.ACTION_HIDE_VIDEO_CHANGED" : "com.domobile.elock.action.ACTION_HIDE_IMAGE_CHANGED");
                intent.putExtra("com.domobile.elock.EXTRA_DATA_STRING", this.f184c);
                if (m289g()) {
                    C1148d.m2510a(context, intent);
                } else {
                    C1148d.m2510a(context, intent);
                }
            }
        } catch (Exception e) {
        }
    }

    protected boolean m283b(Context context, Cursor cursor) {
        UpdateHelper updateHelper = new UpdateHelper();
        this.f182a = (String) updateHelper.update(this.f182a, cursor.getString(cursor.getColumnIndex(Columns.ID)));
        this.f184c = (String) updateHelper.update(this.f184c, cursor.getString(cursor.getColumnIndex("album")));
        this.f185d = (String) updateHelper.update(this.f185d, C0487k.m425c(context, cursor.getString(cursor.getColumnIndex("dest_path"))));
        this.f189h = (String) updateHelper.update(this.f189h, cursor.getString(cursor.getColumnIndex("from_path")));
        this.f187f = (String) updateHelper.update(this.f187f, cursor.getString(cursor.getColumnIndex("thumb_path")));
        this.f188g = (String) updateHelper.update(this.f188g, cursor.getString(cursor.getColumnIndex("file_type")));
        this.f195n = ((Integer) updateHelper.update(this.f188g, Integer.valueOf(cursor.getInt(cursor.getColumnIndex("rotation"))))).intValue();
        this.f183b = (String) updateHelper.update(this.f183b, C3614d.m15751c(this.f189h));
        this.f186e = (String) updateHelper.update(this.f186e, Formatter.formatFileSize(context, new File(this.f185d).length()));
        return updateHelper.isUpdated();
    }

    public void broadcastAlbumThumbChanged(Context context, String str) {
        if (TextUtils.isEmpty(this.f184c)) {
            this.f184c = new File(this.f189h).getParentFile().getName();
        }
        m270a(context, this.f184c, str, m289g());
    }

    public long mo2084c() {
        return new File(this.f185d).lastModified();
    }

    public void m285c(final Context context, boolean z) {
        this.f192k = 1;
        if (TextUtils.isEmpty(this.f184c)) {
            this.f184c = C3614d.m15751c(new File(this.f189h).getParent());
        }
        AppLockApplication a = C1150y.m2566a(context);
        C0633m c0633m = (C0633m) a.m596j().get(this.f184c);
        if (c0633m == null) {
            c0633m = new C0633m();
        }
        c0633m.f573a = this.f184c;
        c0633m.f574b.add(this);
        a.m596j().put(this.f184c, c0633m);
        HidedMediasActionService.m2135a(context);
        this.f197p = new Handler(context.getMainLooper());
        this.f197p.post(new Runnable(this) {
            final /* synthetic */ HidedPictureItem f163b;

            public void run() {
                if (context instanceof AbstractGalleryActivity) {
                    ((AbstractGalleryActivity) context).hideLoadingDialog();
                } else if (context instanceof C0384c) {
                    ((C0384c) context).m51E();
                }
            }
        });
        if (this.f198q != null) {
            this.f198q.revertHidedMediaDone(true);
        }
    }

    public int mo2085d() {
        return this.f195n;
    }

    public void deleteHidedMedia(Activity activity) {
        m278a(activity, true);
    }

    public void deleteHidedMediaWithoutConfirm(Context context) {
        m282b(context, true);
    }

    public int describeContents() {
        return 0;
    }

    public String mo2088e() {
        return this.f183b;
    }

    public Bitmap mo2089f() {
        try {
            if (!TextUtils.isEmpty(this.f187f) && new File(this.f187f).exists()) {
                return BitmapFactory.decodeFile(this.f187f);
            }
        } catch (Exception e) {
        }
        if (m289g()) {
            return ThumbnailUtils.createVideoThumbnail(mo2082a(), 1);
        }
        return C0453c.m314a(new File(this.f185d).exists() ? this.f185d : this.f189h, C0423j.m173a());
    }

    public boolean m289g() {
        return m273a(this.f188g);
    }

    public Uri getContentUri() {
        return Uri.fromFile(new File(this.f185d));
    }

    public String getFilePath() {
        return this.f185d;
    }

    public int getHeight() {
        if (this.f191j == -1) {
            m276i();
        }
        return this.f191j;
    }

    public String getMediaID() {
        return this.f182a;
    }

    public String getMimeType() {
        return this.f188g;
    }

    public String getName() {
        return this.f183b;
    }

    public int getRotation() {
        return this.f195n;
    }

    public int getSupportedOperations() {
        return MediaItem.MIME_TYPE_JPEG.equalsIgnoreCase(this.f188g) ? 66 : 64;
    }

    public int getWidth() {
        if (this.f194m == -1) {
            m276i();
        }
        return this.f194m;
    }

    public String mo2099h() {
        return this.f187f;
    }

    public Job<Bitmap> requestImage(int i) {
        return new C0447a(this.f196o, this.mPath, i, this.f185d);
    }

    public Job<BitmapRegionDecoder> requestLargeImage() {
        return new C0448b(this.f185d);
    }

    public void revertHidedMedia(Context context) {
        m285c(context, true);
    }

    public void revertHidedMediaConfirm(final Activity activity) {
        C0433g.m243a(activity, new Runnable(this) {
            final /* synthetic */ HidedPictureItem f170b;

            class C04361 implements Runnable {
                final /* synthetic */ C04413 f164a;

                C04361(C04413 c04413) {
                    this.f164a = c04413;
                }

                public void run() {
                    if (activity instanceof AbstractGalleryActivity) {
                        ((AbstractGalleryActivity) activity).hideLoadingDialog();
                    } else if (activity instanceof C0384c) {
                        ((C0384c) activity).m51E();
                    }
                }
            }

            class C04402 extends Thread {
                final /* synthetic */ C04413 f168a;

                class C04371 implements Runnable {
                    final /* synthetic */ C04402 f165a;

                    C04371(C04402 c04402) {
                        this.f165a = c04402;
                    }

                    public void run() {
                        this.f165a.f168a.f170b.m268a(activity, activity.getString(R.string.not_enough_space));
                    }
                }

                class C04382 implements Runnable {
                    final /* synthetic */ C04402 f166a;

                    C04382(C04402 c04402) {
                        this.f166a = c04402;
                    }

                    public void run() {
                        this.f166a.f168a.f170b.m268a(activity, activity.getString(R.string.move_file_error));
                    }
                }

                class C04393 implements Runnable {
                    final /* synthetic */ C04402 f167a;

                    C04393(C04402 c04402) {
                        this.f167a = c04402;
                    }

                    public void run() {
                        if (activity instanceof AbstractGalleryActivity) {
                            ((AbstractGalleryActivity) activity).hideLoadingDialog();
                        } else if (activity instanceof C0384c) {
                            ((C0384c) activity).m51E();
                        }
                    }
                }

                C04402(C04413 c04413) {
                    this.f168a = c04413;
                }

                public void run() {
                    try {
                        C1150y.m2566a(activity).m598l().add(this.f168a.f170b.f182a);
                        HidedMediasActionService.m2141a(activity, this.f168a.f170b, true, null);
                        if (this.f168a.f170b.f198q != null) {
                            this.f168a.f170b.f198q.revertHidedMediaDone(true);
                        }
                    } catch (C1054c e) {
                        if (this.f168a.f170b.f198q != null) {
                            this.f168a.f170b.f198q.revertHidedMediaDone(false);
                        }
                        this.f168a.f170b.f197p.post(new C04371(this));
                    } catch (Exception e2) {
                        if (this.f168a.f170b.f198q != null) {
                            this.f168a.f170b.f198q.revertHidedMediaDone(false);
                        }
                        this.f168a.f170b.f197p.post(new C04382(this));
                    }
                    this.f168a.f170b.f197p.post(new C04393(this));
                }
            }

            public void run() {
                if (activity instanceof AbstractGalleryActivity) {
                    ((AbstractGalleryActivity) activity).showCancelableLoadingDialog();
                } else if (activity instanceof C0384c) {
                    ((C0384c) activity).m50D();
                }
                this.f170b.f197p = new Handler(activity.getMainLooper());
                if (this.f170b.m289g()) {
                    this.f170b.revertHidedMedia(activity);
                    this.f170b.f197p.post(new C04361(this));
                    return;
                }
                new C04402(this).start();
            }
        });
    }

    public void rotate(Context context, int i) {
        this.f195n = (this.f195n + i) % 360;
        if (this.f195n < 0) {
            this.f195n += 360;
        }
        if (MediaItem.MIME_TYPE_JPEG.equalsIgnoreCase(this.f188g)) {
            try {
                ExifInterface exifInterface = new ExifInterface(mo2082a());
                exifInterface.setAttribute("Orientation", m267a(this.f195n));
                exifInterface.saveAttributes();
            } catch (IOException e) {
            }
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("rotation", Integer.valueOf(this.f195n));
            C0411e.m157a().update("medias", contentValues, C1147a.m2480a(Columns.ID, "=", this.f182a), null);
            Intent intent = new Intent("com.domobile.elock.action.ACTION_HIDE_IMAGE_CHANGED");
            intent.putExtra("com.domobile.elock.EXTRA_DATA_STRING", this.f184c);
            C1148d.m2510a(context, intent);
        } catch (Exception e2) {
        }
    }

    public void setOnActionDoneListener(OnActionDoneListener onActionDoneListener) {
        this.f198q = onActionDoneListener;
    }

    public void shareHidedMedia(final Activity activity) {
        File file = new File(this.f185d);
        if (file.length() >= com.android.gallery3d.app.Config.MAX_SHARE_SIZE) {
            this.f197p = new Handler(activity.getMainLooper());
            this.f197p.post(new Runnable(this) {
                final /* synthetic */ HidedPictureItem f172b;

                public void run() {
                    C1147a.m2485d(activity, R.string.share_disabled_max_size);
                }
            });
            return;
        }
        File b = C0487k.m422b(activity, C1147a.m2480a(C1148d.m2526d(), ".", C3614d.m15752d(this.f189h)));
        Parcelable fromFile = Uri.fromFile(b);
        C3613c.m15729a(file, b);
        if (activity instanceof C0386c) {
            ((C0386c) activity).m80e();
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setFlags(268435456);
        intent.putExtra("android.intent.extra.STREAM", fromFile);
        if (m289g()) {
            intent.setType(GalleryUtils.MIME_TYPE_VIDEO);
        } else {
            intent.setType(GalleryUtils.MIME_TYPE_IMAGE);
        }
        activity.startActivity(Intent.createChooser(intent, activity.getString(R.string.share)));
    }

    public void showHidedMediaDetail(Activity activity) {
        C0433g.m249a(activity, new C04467(this));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f182a);
        parcel.writeString(this.f183b);
        parcel.writeString(this.f184c);
        parcel.writeString(this.f185d);
        parcel.writeString(this.f186e);
        parcel.writeString(this.f187f);
        parcel.writeString(this.f188g);
        parcel.writeString(this.f189h);
        parcel.writeInt(this.f191j);
        parcel.writeString(this.f190i);
        parcel.writeInt(this.f195n);
    }
}
