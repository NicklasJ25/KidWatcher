package com.domobile.applock.chamber.controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.domobile.applock.C0400d;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.SocialInfo;
import com.domobile.applock.chamber.p010b.C0782e;

public class C0864i extends C0400d implements TextWatcher {
    private SocialInfo f1226a;
    private EditText f1227e;
    private EditText f1228f;
    private TextView f1229g;

    private void m1463a(@NonNull EditText editText) {
        editText.setText(editText.getText());
        Spannable text = editText.getText();
        Selection.setSelection(text, text.length());
    }

    private void m1464b() {
        TextView textView = (TextView) findViewById(R.id.txvPlatformName);
        ((ImageView) findViewById(R.id.imvPlatformIcon)).setImageResource(this.f1226a.m1528b().intValue());
        textView.setText(this.f1226a.m1527a(this.mActivity));
        this.f1229g = (TextView) findViewById(R.id.txvSave);
        this.f1229g.setOnClickListener(this);
        this.f1227e = (EditText) findViewById(R.id.edtAccount);
        this.f1228f = (EditText) findViewById(R.id.edtNickname);
        this.f1227e.addTextChangedListener(this);
        this.f1228f.addTextChangedListener(this);
        this.f1227e.setText(this.f1226a.f1301c);
        this.f1228f.setText(this.f1226a.f1302d);
        this.f1228f.requestFocus();
        m1463a(this.f1228f);
    }

    private void m1465c() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mActivity.getSystemService("input_method");
        View currentFocus = this.mActivity.getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getApplicationWindowToken(), 2);
        }
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.init(layoutInflater, viewGroup, bundle);
        this.rootView = layoutInflater.inflate(R.layout.fragment_social_edit, null);
        m1464b();
    }

    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f1229g) {
            m1465c();
            this.f1226a.f1301c = this.f1227e.getText().toString();
            this.f1226a.f1302d = this.f1228f.getText().toString();
            this.f1226a.f1303e = System.currentTimeMillis() + "";
            this.f1226a.f1304f = this.f1226a.f1303e;
            C0782e.m1211c(this.f1226a);
            this.b.mo2042a();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m66r().setNavigationIcon((int) R.drawable.icon_close_white);
        this.b.m56b(R.string.edit);
        this.f1226a = (SocialInfo) getArguments().getParcelable("EXTRA_SOCIAL_INFO");
        C1150y.m2605b(this.mActivity, (int) R.string.event_social_edit);
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.social_edit_menus, menu);
        super.onCreateCustomOptionsMenus(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_action_delete) {
            return false;
        }
        C0782e.m1206a(this.f1226a.f1299a);
        this.b.mo2042a();
        return true;
    }

    public void onResume() {
        super.onResume();
        this.b.m72x();
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f1229g.setEnabled(this.f1227e.getText().length() > 0);
    }
}
