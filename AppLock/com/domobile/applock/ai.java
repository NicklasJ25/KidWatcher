package com.domobile.applock;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.domobile.applock.p005b.C0719a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ai extends C0719a implements OnClickListener {
    private C0718a f896b;

    public interface C0718a {
        void mo2445a();

        void mo2446b();
    }

    public static ai m990a(FragmentManager fragmentManager, String str, String str2) {
        ai aiVar = new ai();
        Bundle bundle = new Bundle();
        bundle.putString("EXTRA_MONTH_PRICE", str);
        bundle.putString("EXTRA_YEAR_PRICE", str2);
        aiVar.setArguments(bundle);
        aiVar.show(fragmentManager, "");
        return aiVar;
    }

    private void m991a(String str, TextView textView) {
        Matcher matcher = Pattern.compile("\\d{1,}\\.\\d{1,}").matcher(str);
        if (matcher.find()) {
            String group = matcher.group(0);
            int indexOf = str.indexOf(group);
            int length = group.length() + indexOf;
            CharSequence spannableString = new SpannableString(str);
            spannableString.setSpan(new AbsoluteSizeSpan(30, true), indexOf, length, 33);
            spannableString.setSpan(new StyleSpan(1), indexOf, length, 33);
            textView.setText(spannableString);
        }
    }

    private void m992c() {
        int a = (m987a() - (getResources().getDimensionPixelSize(R.dimen.PaddingSizeXLarge) * 3)) / 2;
        View a2 = m988a(R.id.vgMonthLayer);
        View a3 = m988a(R.id.vgYearLayer);
        LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
        layoutParams.height = a;
        a2.setLayoutParams(layoutParams);
        ((LayoutParams) a3.getLayoutParams()).height = a;
        a3.setLayoutParams(layoutParams);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        Bundle arguments = getArguments();
        String string = arguments.getString("EXTRA_MONTH_PRICE");
        String string2 = arguments.getString("EXTRA_YEAR_PRICE");
        m991a(string, (TextView) m988a(R.id.txvMonthPrice));
        ((TextView) m988a(R.id.txvMonthText)).setText(getString(R.string.advance_user_monthly, ""));
        m991a(string2, (TextView) m988a(R.id.txvYearPrice));
        ((TextView) m988a(R.id.txvYearText)).setText(getString(R.string.advance_user_yearly, ""));
    }

    public void m993a(C0718a c0718a) {
        this.f896b = c0718a;
    }

    public void onClick(View view) {
        dismiss();
        if (this.f896b != null) {
            if (view.getId() == R.id.vgMonthLayer) {
                this.f896b.mo2445a();
            } else if (view.getId() == R.id.vgYearLayer) {
                this.f896b.mo2446b();
            }
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_subscription_choose, viewGroup, false);
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        m992c();
    }
}
