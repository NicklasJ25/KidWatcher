package com.domobile.applock.theme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import com.domobile.applock.R;
import com.domobile.applock.p005b.C0719a;

public class C1101b extends C0719a implements TextWatcher, OnClickListener {
    private EditText f2111b;
    private C1089a f2112c;

    public interface C1089a {
        void mo2488a();

        void mo2489a(String str);

        void mo2490b();
    }

    public static C1101b m2375a(FragmentManager fragmentManager) {
        C1101b c1101b = new C1101b();
        c1101b.setArguments(new Bundle());
        c1101b.show(fragmentManager, "");
        return c1101b;
    }

    private void m2376c() {
        this.f2111b = (EditText) m988a(R.id.edtInvitationCode);
        m988a(R.id.btnGetCode).setOnClickListener(this);
        m988a(R.id.btnActivate).setOnClickListener(this);
        m988a(R.id.txvBuyVip).setOnClickListener(this);
        this.f2111b.addTextChangedListener(this);
    }

    public void m2377a(C1089a c1089a) {
        this.f2112c = c1089a;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onClick(View view) {
        if (this.f2112c != null) {
            if (view.getId() == R.id.btnGetCode) {
                dismiss();
                this.f2112c.mo2488a();
            } else if (view.getId() == R.id.btnActivate) {
                Object trim = this.f2111b.getText().toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    dismiss();
                    this.f2112c.mo2489a(trim);
                }
            } else if (view.getId() == R.id.txvBuyVip) {
                dismiss();
                this.f2112c.mo2490b();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_theme_activate, viewGroup, false);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        m988a(R.id.btnActivate).setEnabled(this.f2111b.getText().length() > 0);
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        m2376c();
    }
}
