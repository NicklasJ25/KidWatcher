package com.domobile.applock;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.domobile.frame.C0384c;
import com.domobile.frame.C0399d;
import com.domobile.frame.p000a.C1147a;

public class aa extends C0399d {
    Button f576a;
    EditText f577b;
    EditText f578c;
    EditText f579d;

    private String m757a(EditText editText) {
        try {
            return editText.getText().toString().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.retrieve, null);
        this.f577b = (EditText) findViewById(R.id.retrieve_security_question_edittext);
        this.f578c = (EditText) findViewById(R.id.retrieve_security_answer_edittext);
        this.f579d = (EditText) findViewById(R.id.retrieve_security_email_edittext);
        this.f577b.setText(C1150y.m2602b(this.mActivity, "security_question"));
        this.f578c.setText(C1150y.m2611c(C1150y.ab(this.mActivity)));
        this.f579d.setText(C1150y.aa(this.mActivity));
        this.f576a = (Button) findViewById(R.id.retrieve_password_setting_save_button);
        this.f576a.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view == this.f576a) {
            String a = m757a(this.f577b);
            String a2 = m757a(this.f578c);
            String a3 = m757a(this.f579d);
            boolean isEmpty = TextUtils.isEmpty(a);
            boolean isEmpty2 = TextUtils.isEmpty(a2);
            if ((!isEmpty && isEmpty2) || (isEmpty && !isEmpty2)) {
                C1147a.m2485d(this.mActivity, R.string.security_cannot_empty);
                return;
            } else if (TextUtils.isEmpty(a3) || !C1150y.m2631h(a3)) {
                C1147a.m2485d(this.mActivity, R.string.email_error);
                return;
            } else {
                C1150y.m2583a(this.mActivity, "security_question", a);
                C1150y.m2660v(this.mActivity, C1150y.m2603b(a2));
                C1150y.m2657u(this.mActivity, a3);
                C1147a.m2485d(this.mActivity, R.string.save_done);
                return;
            }
        }
        super.onClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActionBar.m3006b(false);
        ((C0384c) this.mActivity).m56b(R.string.secure_answer_setting_title);
        C1150y.m2605b(this.mActivity, (int) R.string.event_retrieve);
    }

    public void ui(int i, Message message) {
    }
}
