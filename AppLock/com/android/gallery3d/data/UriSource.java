package com.android.gallery3d.data;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.android.gallery3d.app.GalleryApp;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UriSource extends MediaSource {
    private static final String CHARSET_UTF_8 = "utf-8";
    private static final String IMAGE_TYPE_ANY = "image/*";
    private static final String IMAGE_TYPE_PREFIX = "image/";
    private static final String TAG = "UriSource";
    private GalleryApp mApplication;

    public UriSource(GalleryApp galleryApp) {
        super("uri");
        this.mApplication = galleryApp;
    }

    private String getMimeType(Uri uri) {
        String mimeTypeFromExtension;
        if ("file".equals(uri.getScheme())) {
            mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase());
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        mimeTypeFromExtension = this.mApplication.getContentResolver().getType(uri);
        return mimeTypeFromExtension == null ? "image/*" : mimeTypeFromExtension;
    }

    public MediaObject createMediaObject(Path path) {
        String[] split = path.split();
        if (split.length != 3) {
            throw new RuntimeException("bad path: " + path);
        }
        try {
            String decode = URLDecoder.decode(split[1], CHARSET_UTF_8);
            return new UriImage(this.mApplication, path, Uri.parse(decode), URLDecoder.decode(split[2], CHARSET_UTF_8));
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public Path findPathByUri(Uri uri, String str) {
        String mimeType = getMimeType(uri);
        if (str == null || ("image/*".equals(str) && mimeType.startsWith(IMAGE_TYPE_PREFIX))) {
            str = mimeType;
        }
        if (!str.startsWith(IMAGE_TYPE_PREFIX)) {
            return null;
        }
        try {
            return Path.fromString("/uri/" + URLEncoder.encode(uri.toString(), CHARSET_UTF_8) + "/" + URLEncoder.encode(str, CHARSET_UTF_8));
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
