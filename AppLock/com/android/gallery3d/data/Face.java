package com.android.gallery3d.data;

import android.graphics.Rect;
import com.android.gallery3d.common.Utils;
import java.util.StringTokenizer;

public class Face implements Comparable<Face> {
    private String mName;
    private String mPersonId;
    private Rect mPosition;

    public Face(String str, String str2, String str3) {
        this.mName = str;
        this.mPersonId = str2;
        boolean z = (this.mName == null || this.mPersonId == null || str3 == null) ? false : true;
        Utils.assertTrue(z);
        StringTokenizer stringTokenizer = new StringTokenizer(str3);
        this.mPosition = new Rect();
        while (stringTokenizer.hasMoreElements()) {
            this.mPosition.left = Integer.parseInt(stringTokenizer.nextToken());
            this.mPosition.top = Integer.parseInt(stringTokenizer.nextToken());
            this.mPosition.right = Integer.parseInt(stringTokenizer.nextToken());
            this.mPosition.bottom = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    public int compareTo(Face face) {
        return this.mName.compareTo(face.mName);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Face)) {
            return false;
        }
        return this.mPersonId.equals(((Face) obj).mPersonId);
    }

    public String getName() {
        return this.mName;
    }

    public Rect getPosition() {
        return this.mPosition;
    }
}
