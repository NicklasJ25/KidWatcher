package com.domobile.frame.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class C1279a implements Menu {
    private Context f2646a;
    private boolean f2647b;
    private ArrayList<C1280b> f2648c;
    private Comparator<MenuItem> f2649d = new C12781(this);

    class C12781 implements Comparator<MenuItem> {
        final /* synthetic */ C1279a f2645a;

        C12781(C1279a c1279a) {
            this.f2645a = c1279a;
        }

        public int m3064a(MenuItem menuItem, MenuItem menuItem2) {
            return menuItem.getOrder() - menuItem2.getOrder();
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m3064a((MenuItem) obj, (MenuItem) obj2);
        }
    }

    public C1279a(Context context) {
        this.f2646a = context;
        this.f2648c = new ArrayList();
    }

    private C1280b m3065a(int i, KeyEvent keyEvent) {
        boolean z = this.f2647b;
        ArrayList arrayList = this.f2648c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1280b c1280b = (C1280b) arrayList.get(i2);
            if (i == (z ? c1280b.getAlphabeticShortcut() : c1280b.getNumericShortcut())) {
                return c1280b;
            }
        }
        return null;
    }

    private int m3066c(int i) {
        ArrayList arrayList = this.f2648c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C1280b) arrayList.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public Context m3067a() {
        return this.f2646a;
    }

    public MenuItem m3068a(C1280b c1280b) {
        this.f2648c.add(c1280b);
        Collections.sort(this.f2648c, this.f2649d);
        return c1280b;
    }

    public C1280b m3069a(int i) {
        return (C1280b) this.f2648c.get(m3066c(i));
    }

    public MenuItem add(int i) {
        return add(0, 0, 0, i);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return add(i, i2, i3, this.f2646a.getResources().getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        MenuItem c1280b = new C1280b(m3067a(), i, i2, 0, i3, charSequence);
        this.f2648c.add(c1280b);
        Collections.sort(this.f2648c, this.f2649d);
        return c1280b;
    }

    public MenuItem add(CharSequence charSequence) {
        return add(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f2646a.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i) {
        return null;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return null;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return null;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return null;
    }

    public C1280b m3070b(int i) {
        return (C1280b) this.f2648c.get(i);
    }

    public void clear() {
        this.f2648c.clear();
    }

    public void close() {
    }

    public /* synthetic */ MenuItem findItem(int i) {
        return m3069a(i);
    }

    public /* synthetic */ MenuItem getItem(int i) {
        return m3070b(i);
    }

    public boolean hasVisibleItems() {
        ArrayList arrayList = this.f2648c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((C1280b) arrayList.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m3065a(i, keyEvent) != null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        int c = m3066c(i);
        return c < 0 ? false : ((C1280b) this.f2648c.get(c)).m3075b();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        C1280b a = m3065a(i, keyEvent);
        return a == null ? false : a.m3075b();
    }

    public void removeGroup(int i) {
        ArrayList arrayList = this.f2648c;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            if (((C1280b) arrayList.get(i2)).getGroupId() == i) {
                arrayList.remove(i2);
                size--;
            } else {
                i2++;
            }
        }
    }

    public void removeItem(int i) {
        this.f2648c.remove(m3066c(i));
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ArrayList arrayList = this.f2648c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1280b c1280b = (C1280b) arrayList.get(i2);
            if (c1280b.getGroupId() == i) {
                c1280b.setCheckable(z);
                c1280b.m3074a(z2);
            }
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        ArrayList arrayList = this.f2648c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1280b c1280b = (C1280b) arrayList.get(i2);
            if (c1280b.getGroupId() == i) {
                c1280b.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        ArrayList arrayList = this.f2648c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1280b c1280b = (C1280b) arrayList.get(i2);
            if (c1280b.getGroupId() == i) {
                c1280b.setVisible(z);
            }
        }
    }

    public void setQwertyMode(boolean z) {
        this.f2647b = z;
    }

    public int size() {
        return this.f2648c.size();
    }
}
