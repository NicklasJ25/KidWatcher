package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.internal.aac.C2632a;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@wh
public class aae implements C2632a {
    @Nullable
    private final String f7629a;

    public aae() {
        this(null);
    }

    public aae(@Nullable String str) {
        this.f7629a = str;
    }

    @WorkerThread
    public void mo3376a(String str) {
        String valueOf;
        HttpURLConnection httpURLConnection;
        try {
            String str2 = "Pinging URL: ";
            valueOf = String.valueOf(str);
            aad.m8421b(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            ol.m12979a().m8408a(true, httpURLConnection, this.f7629a);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                aad.m8426e(new StringBuilder(String.valueOf(str).length() + 65).append("Received non-success response code ").append(responseCode).append(" from pinging URL: ").append(str).toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            valueOf = String.valueOf(e.getMessage());
            aad.m8426e(new StringBuilder((String.valueOf(str).length() + 32) + String.valueOf(valueOf).length()).append("Error while parsing ping URL: ").append(str).append(". ").append(valueOf).toString());
        } catch (IOException e2) {
            valueOf = String.valueOf(e2.getMessage());
            aad.m8426e(new StringBuilder((String.valueOf(str).length() + 27) + String.valueOf(valueOf).length()).append("Error while pinging URL: ").append(str).append(". ").append(valueOf).toString());
        } catch (RuntimeException e3) {
            valueOf = String.valueOf(e3.getMessage());
            aad.m8426e(new StringBuilder((String.valueOf(str).length() + 27) + String.valueOf(valueOf).length()).append("Error while pinging URL: ").append(str).append(". ").append(valueOf).toString());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
