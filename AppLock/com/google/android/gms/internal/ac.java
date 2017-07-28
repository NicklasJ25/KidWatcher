package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2456a.C2449c;
import com.google.android.gms.internal.C2859f.C2676a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public interface ac {

    public interface C2683a {
        void mo3800a(int i, boolean z);

        void mo3801a(Bundle bundle);

        void mo3802a(ConnectionResult connectionResult);
    }

    <A extends C2449c, T extends C2676a<? extends C2445g, A>> T mo3803a(@NonNull T t);

    void mo3804a();

    void mo3805a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    void mo3806b();

    boolean mo3807c();

    void mo3808d();
}
