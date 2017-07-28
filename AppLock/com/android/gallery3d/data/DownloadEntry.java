package com.android.gallery3d.data;

import com.android.gallery3d.common.Entry;
import com.android.gallery3d.common.Entry.Column;
import com.android.gallery3d.common.Entry.Table;
import com.android.gallery3d.common.EntrySchema;

@Table("download")
public class DownloadEntry extends Entry {
    public static final EntrySchema SCHEMA = new EntrySchema(DownloadEntry.class);
    @Column("_size")
    public long contentSize;
    @Column("content_url")
    public String contentUrl;
    @Column("etag")
    public String eTag;
    @Column(indexed = true, value = "hash_code")
    public long hashCode;
    @Column(indexed = true, value = "last_access")
    public long lastAccessTime;
    @Column("last_updated")
    public long lastUpdatedTime;
    @Column("_data")
    public String path;

    public interface Columns extends com.android.gallery3d.common.Entry.Columns {
        public static final String CONTENT_SIZE = "_size";
        public static final String CONTENT_URL = "content_url";
        public static final String DATA = "_data";
        public static final String ETAG = "etag";
        public static final String HASH_CODE = "hash_code";
        public static final String LAST_ACCESS = "last_access";
        public static final String LAST_UPDATED = "last_updated";
    }

    public String toString() {
        return "hash_code: " + this.hashCode + ", " + "content_url" + this.contentUrl + ", " + Columns.CONTENT_SIZE + this.contentSize + ", " + Columns.ETAG + this.eTag + ", " + "last_access" + this.lastAccessTime + ", " + Columns.LAST_UPDATED + this.lastUpdatedTime + "," + Columns.DATA + this.path;
    }
}
