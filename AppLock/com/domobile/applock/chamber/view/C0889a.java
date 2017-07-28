package com.domobile.applock.chamber.view;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.domobile.applock.R;
import com.domobile.applock.p005b.C0719a;
import com.domobile.frame.http.image.CacheImageView;
import java.io.File;

public class C0889a extends C0719a implements OnClickListener {
    private C0888a f1326b;

    public interface C0888a {
        void mo2473a();
    }

    public static C0889a m1537a(FragmentManager fragmentManager, String str) {
        C0889a c0889a = new C0889a();
        Bundle bundle = new Bundle();
        bundle.putString("EXTRA_PATH", str);
        c0889a.setArguments(bundle);
        c0889a.show(fragmentManager, "");
        return c0889a;
    }

    private void m1538c() {
        CacheImageView cacheImageView = (CacheImageView) m988a(R.id.imvImage);
        m988a(R.id.btnOk).setOnClickListener(this);
        m988a(R.id.btnCheck).setOnClickListener(this);
        Object string = getArguments().getString("EXTRA_PATH");
        cacheImageView.m3052b(false);
        if (!TextUtils.isEmpty(string)) {
            cacheImageView.setImage(Uri.fromFile(new File(string)));
        }
    }

    public void m1539a(C0888a c0888a) {
        this.f1326b = c0888a;
    }

    public void onClick(View view) {
        dismiss();
        if (view.getId() == R.id.btnCheck && this.f1326b != null) {
            this.f1326b.mo2473a();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_invader_tips, viewGroup, false);
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        m1538c();
    }
}
