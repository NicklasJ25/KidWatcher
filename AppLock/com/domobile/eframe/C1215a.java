package com.domobile.eframe;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.Window;
import android.view.WindowManager;
import com.domobile.applock.AppLockApplication;
import java.io.File;

public class C1215a extends Activity {
    public C1215a() {
        attachBaseContext(AppLockApplication.m577b());
    }

    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return getApplicationContext().bindService(intent, serviceConnection, i);
    }

    public Context createPackageContext(String str, int i) {
        return getApplicationContext().createPackageContext(str, i);
    }

    public Context getApplicationContext() {
        Context b = AppLockApplication.m577b();
        return b.m590d() != null ? b.m590d() : b;
    }

    public ApplicationInfo getApplicationInfo() {
        return getApplicationContext().getApplicationInfo();
    }

    public AssetManager getAssets() {
        return getApplicationContext().getAssets();
    }

    public Context getBaseContext() {
        return getApplicationContext();
    }

    public File getCacheDir() {
        return getApplicationContext().getCacheDir();
    }

    public ComponentName getCallingActivity() {
        Context applicationContext = getApplicationContext();
        return applicationContext instanceof Activity ? ((Activity) applicationContext).getCallingActivity() : null;
    }

    public String getCallingPackage() {
        Context applicationContext = getApplicationContext();
        return applicationContext instanceof Activity ? ((Activity) applicationContext).getCallingPackage() : null;
    }

    public int getChangingConfigurations() {
        Context applicationContext = getApplicationContext();
        return applicationContext instanceof Activity ? ((Activity) applicationContext).getChangingConfigurations() : 0;
    }

    public ClassLoader getClassLoader() {
        return getApplicationContext().getClassLoader();
    }

    public ContentResolver getContentResolver() {
        return getApplicationContext().getContentResolver();
    }

    public File getDatabasePath(String str) {
        return getApplicationContext().getDatabasePath(str);
    }

    public File getDir(String str, int i) {
        return getApplicationContext().getDir(str, i);
    }

    public File getExternalCacheDir() {
        return getApplicationContext().getExternalCacheDir();
    }

    public File[] getExternalCacheDirs() {
        return getApplicationContext().getExternalCacheDirs();
    }

    public File getExternalFilesDir(String str) {
        return getApplicationContext().getExternalFilesDir(str);
    }

    public File[] getExternalFilesDirs(String str) {
        return getApplicationContext().getExternalFilesDirs(str);
    }

    public File getFileStreamPath(String str) {
        return getApplicationContext().getFileStreamPath(str);
    }

    public File getFilesDir() {
        return getApplicationContext().getFilesDir();
    }

    public LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(getApplicationContext());
    }

    public Looper getMainLooper() {
        return getApplicationContext().getMainLooper();
    }

    public MenuInflater getMenuInflater() {
        return new MenuInflater(getApplicationContext());
    }

    public File getObbDir() {
        return getApplicationContext().getObbDir();
    }

    public File[] getObbDirs() {
        return getApplicationContext().getObbDirs();
    }

    public String getPackageCodePath() {
        return getApplicationContext().getPackageCodePath();
    }

    public PackageManager getPackageManager() {
        return getApplicationContext().getPackageManager();
    }

    public String getPackageName() {
        return getApplicationContext().getPackageName();
    }

    public String getPackageResourcePath() {
        return getApplicationContext().getPackageResourcePath();
    }

    public Resources getResources() {
        return getApplicationContext().getResources();
    }

    public SharedPreferences getSharedPreferences(String str, int i) {
        return getApplicationContext().getSharedPreferences(str, i);
    }

    public Object getSystemService(String str) {
        return getApplicationContext().getSystemService(str);
    }

    public Window getWindow() {
        Context applicationContext = getApplicationContext();
        return applicationContext instanceof Activity ? ((Activity) applicationContext).getWindow() : null;
    }

    public WindowManager getWindowManager() {
        return (WindowManager) getApplicationContext().getSystemService("window");
    }

    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return getApplicationContext().registerReceiver(broadcastReceiver, intentFilter);
    }

    public void startActivity(Intent intent) {
        Context applicationContext = getApplicationContext();
        if (applicationContext instanceof Activity) {
            applicationContext.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        applicationContext.startActivity(intent);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        Context applicationContext = getApplicationContext();
        if (applicationContext instanceof Activity) {
            applicationContext.startActivity(intent, bundle);
            return;
        }
        intent.setFlags(268435456);
        applicationContext.startActivity(intent, bundle);
    }

    public void unbindService(ServiceConnection serviceConnection) {
        getApplicationContext().unbindService(serviceConnection);
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        getApplicationContext().unregisterReceiver(broadcastReceiver);
    }
}
