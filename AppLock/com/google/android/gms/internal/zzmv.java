package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.util.C2586k;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@wh
public final class zzmv extends zza {
    public static final Creator<zzmv> CREATOR = new wu();
    ParcelFileDescriptor f12068a;
    private Parcelable f12069b;
    private boolean f12070c;

    zzmv(ParcelFileDescriptor parcelFileDescriptor) {
        this.f12068a = parcelFileDescriptor;
        this.f12069b = null;
        this.f12070c = true;
    }

    public zzmv(SafeParcelable safeParcelable) {
        this.f12068a = null;
        this.f12069b = safeParcelable;
        this.f12070c = false;
    }

    protected <T> ParcelFileDescriptor m15390a(final byte[] bArr) {
        final Closeable autoCloseOutputStream;
        Throwable e;
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new Runnable(this) {
                    public void run() {
                        Closeable dataOutputStream;
                        Throwable e;
                        try {
                            dataOutputStream = new DataOutputStream(autoCloseOutputStream);
                            try {
                                dataOutputStream.writeInt(bArr.length);
                                dataOutputStream.write(bArr);
                                C2586k.m8301a(dataOutputStream);
                            } catch (IOException e2) {
                                e = e2;
                                try {
                                    aad.m8422b("Error transporting the ad response", e);
                                    zzw.zzcQ().m15000a(e, "LargeParcelTeleporter.pipeData.1");
                                    if (dataOutputStream != null) {
                                        C2586k.m8301a(autoCloseOutputStream);
                                    } else {
                                        C2586k.m8301a(dataOutputStream);
                                    }
                                } catch (Throwable th) {
                                    e = th;
                                    if (dataOutputStream != null) {
                                        C2586k.m8301a(autoCloseOutputStream);
                                    } else {
                                        C2586k.m8301a(dataOutputStream);
                                    }
                                    throw e;
                                }
                            }
                        } catch (IOException e3) {
                            e = e3;
                            dataOutputStream = null;
                            aad.m8422b("Error transporting the ad response", e);
                            zzw.zzcQ().m15000a(e, "LargeParcelTeleporter.pipeData.1");
                            if (dataOutputStream != null) {
                                C2586k.m8301a(dataOutputStream);
                            } else {
                                C2586k.m8301a(autoCloseOutputStream);
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            dataOutputStream = null;
                            if (dataOutputStream != null) {
                                C2586k.m8301a(dataOutputStream);
                            } else {
                                C2586k.m8301a(autoCloseOutputStream);
                            }
                            throw e;
                        }
                    }
                }).start();
                return createPipe[0];
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            autoCloseOutputStream = parcelFileDescriptor;
            aad.m8422b("Error transporting the ad response", e);
            zzw.zzcQ().m15000a(e, "LargeParcelTeleporter.pipeData.2");
            C2586k.m8301a(autoCloseOutputStream);
            return parcelFileDescriptor;
        }
    }

    public <T extends SafeParcelable> T m15391a(Creator<T> creator) {
        if (this.f12070c) {
            if (this.f12068a == null) {
                aad.m8423c("File descriptor is empty, returning null.");
                return null;
            }
            Closeable dataInputStream = new DataInputStream(new AutoCloseInputStream(this.f12068a));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                C2586k.m8301a(dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.f12069b = (SafeParcelable) creator.createFromParcel(obtain);
                    this.f12070c = false;
                } finally {
                    obtain.recycle();
                }
            } catch (Throwable e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th) {
                C2586k.m8301a(dataInputStream);
            }
        }
        return (SafeParcelable) this.f12069b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f12068a == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.f12069b.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                this.f12068a = m15390a(marshall);
            } finally {
                obtain.recycle();
            }
        }
        wu.m14555a(this, parcel, i);
    }
}
