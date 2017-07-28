package com.domobile.frame.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageButton;

public class C1280b implements MenuItem {
    private final int f2650a;
    private final int f2651b;
    private final int f2652c;
    private CharSequence f2653d;
    private CharSequence f2654e;
    private Intent f2655f;
    private char f2656g;
    private char f2657h;
    private Drawable f2658i;
    private ImageButton f2659j;
    private Context f2660k;
    private OnMenuItemClickListener f2661l;
    private boolean f2662m = true;
    private int f2663n = 16;

    public C1280b(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f2660k = context;
        this.f2650a = i2;
        this.f2651b = i;
        this.f2652c = i4;
        this.f2653d = charSequence;
    }

    public MenuItem m3071a(ImageButton imageButton) {
        this.f2659j = imageButton;
        return this;
    }

    public ImageButton m3072a() {
        return this.f2659j;
    }

    public C1280b m3073a(int i) {
        this.f2658i = this.f2660k.getResources().getDrawable(i);
        return this;
    }

    public C1280b m3074a(boolean z) {
        this.f2663n = (z ? 4 : 0) | (this.f2663n & -5);
        return this;
    }

    public boolean m3075b() {
        if (this.f2661l != null && this.f2661l.onMenuItemClick(this)) {
            return true;
        }
        if (this.f2655f == null) {
            return false;
        }
        this.f2660k.startActivity(this.f2655f);
        return true;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        return null;
    }

    public View getActionView() {
        return null;
    }

    public char getAlphabeticShortcut() {
        return this.f2657h;
    }

    public int getGroupId() {
        return this.f2651b;
    }

    public Drawable getIcon() {
        return this.f2658i;
    }

    public Intent getIntent() {
        return this.f2655f;
    }

    public int getItemId() {
        return this.f2650a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f2656g;
    }

    public int getOrder() {
        return this.f2652c;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f2653d;
    }

    public CharSequence getTitleCondensed() {
        return this.f2654e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f2663n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f2663n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f2663n & 16) != 0;
    }

    public boolean isVisible() {
        return this.f2662m;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        return null;
    }

    public MenuItem setActionView(int i) {
        return null;
    }

    public MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f2657h = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f2663n = (z ? 1 : 0) | (this.f2663n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f2663n = (z ? 2 : 0) | (this.f2663n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f2663n = (z ? 16 : 0) | (this.f2663n & -17);
        return this;
    }

    public /* synthetic */ MenuItem setIcon(int i) {
        return m3073a(i);
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f2658i = drawable;
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f2655f = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f2656g = c;
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        return null;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f2661l = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f2656g = c;
        this.f2657h = c2;
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public MenuItem setShowAsActionFlags(int i) {
        return null;
    }

    public MenuItem setTitle(int i) {
        this.f2653d = this.f2660k.getResources().getString(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f2653d = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2654e = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f2662m = z;
        return this;
    }
}
