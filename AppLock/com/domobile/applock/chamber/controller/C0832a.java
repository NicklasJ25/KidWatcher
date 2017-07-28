package com.domobile.applock.chamber.controller;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import com.domobile.applock.C0400d;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.BookmarkInfo;
import com.domobile.applock.chamber.p010b.C0778a;

public class C0832a extends C0400d implements TextWatcher {
    private BookmarkInfo f1137a;
    private EditText f1138e;
    private EditText f1139f;

    public static void m1368a(@NonNull EditText editText) {
        editText.setText(editText.getText());
        Spannable text = editText.getText();
        Selection.setSelection(text, text.length());
    }

    private void m1369b() {
        this.f1138e = (EditText) findViewById(R.id.edtName);
        this.f1139f = (EditText) findViewById(R.id.edtURL);
        this.f1138e.setText(this.f1137a.f1283c);
        this.f1139f.setText(this.f1137a.f1282b);
        this.f1138e.requestFocus();
        this.f1138e.addTextChangedListener(this);
        this.f1139f.addTextChangedListener(this);
        C0832a.m1368a(this.f1138e);
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.init(layoutInflater, viewGroup, bundle);
        this.rootView = layoutInflater.inflate(R.layout.fragment_bookmark_edit, null);
        m1369b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.edit);
        this.b.m66r().setNavigationIcon((int) R.drawable.icon_close_white);
        this.f1137a = (BookmarkInfo) getArguments().getParcelable("EXTRA_BOOKMARK");
        C1150y.m2605b(this.mActivity, (int) R.string.event_bookmark_edit);
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.bookmark_edit_menus, menu);
        super.onCreateCustomOptionsMenus(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_action_save) {
            return false;
        }
        this.f1137a.f1283c = this.f1138e.getText().toString();
        this.f1137a.f1282b = this.f1139f.getText().toString();
        C0778a.m1186b(this.f1137a);
        this.b.mo2042a();
        return true;
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem findItem = menu.findItem(R.id.menu_action_save);
        if (this.f1138e.getText().length() <= 0 || this.f1139f.getText().length() <= 0) {
            findItem.setEnabled(false);
            Drawable drawable = ContextCompat.getDrawable(this.mActivity, R.drawable.toolbar_ok);
            drawable.setAlpha(85);
            findItem.setIcon(drawable);
            return;
        }
        findItem.setEnabled(true);
        drawable = ContextCompat.getDrawable(this.mActivity, R.drawable.toolbar_ok);
        drawable.setAlpha(255);
        findItem.setIcon(drawable);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.b.invalidateOptionsMenu();
    }
}
