package com.domobile.applock;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import com.android.camera.C0401b;
import com.android.camera.C0409d;
import com.domobile.applock.chamber.controller.C0843d;
import com.domobile.applock.chamber.controller.C0860g;
import com.domobile.applock.chamber.controller.C0863h;
import com.domobile.applock.fake.C0920a;
import com.domobile.applock.fake.C0928b;
import com.domobile.applock.fake.FakePagePickerFragment;
import com.domobile.applock.theme.ThemePickerFragment;
import com.domobile.frame.C0399d;

public class AgentActivity extends C0386c {
    private int f411d = -1;
    private String f412e = "AgentActivity";

    public static Intent m570a(Context context, int i) {
        if (i == 260) {
            return new Intent(context, ScenesActivity.class);
        }
        Intent intent = new Intent(context, AgentActivity.class);
        intent.putExtra("extra_fragment", i);
        return intent;
    }

    public boolean mo2046b() {
        switch (this.f411d) {
            case 256:
            case 289:
            case 291:
            case 295:
            case 304:
                return true;
            default:
                return super.mo2046b();
        }
    }

    public void onCreate(Bundle bundle) {
        C0399d c1155z;
        requestWindowFeature(1);
        this.f411d = getIntent().getIntExtra("extra_fragment", -1);
        Object stringExtra = getIntent().getStringExtra("extra_fragment_classname");
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        switch (this.f411d) {
            case 256:
                c1155z = new C1155z();
                break;
            case InputDeviceCompat.SOURCE_KEYBOARD /*257*/:
                c1155z = new C0954j();
                break;
            case 259:
                c1155z = new C1119v();
                break;
            case 260:
                getSupportActionBar().setHomeAsUpIndicator((int) R.drawable.ic_clear_mtrl_alpha);
                c1155z = new ae();
                break;
            case 261:
                getSupportActionBar().setHomeAsUpIndicator((int) R.drawable.ic_clear_mtrl_alpha);
                c1155z = new ak();
                break;
            case 262:
                getSupportActionBar().setHomeAsUpIndicator((int) R.drawable.ic_clear_mtrl_alpha);
                c1155z = new C1016m();
                break;
            case 263:
                c1155z = new af();
                break;
            case 264:
                c1155z = new aa();
                break;
            case 265:
                c1155z = new FakePagePickerFragment();
                break;
            case 272:
                c1155z = new C0958k();
                break;
            case 273:
                c1155z = new C0959l();
                break;
            case 274:
                c1155z = new ah();
                break;
            case 276:
                c1155z = new C0634a();
                break;
            case 288:
                c1155z = new C1119v();
                extras.putInt("com.domobile.elock.EXTRA_TYPE", 1);
                break;
            case 289:
                c1155z = new ThemePickerFragment();
                break;
            case 290:
                c1155z = new C0947g();
                break;
            case 291:
                c1155z = new PluginsPagerSimpleFragment();
                break;
            case 292:
                c1155z = new C0401b();
                break;
            case 293:
                c1155z = new C0409d();
                break;
            case 294:
                c1155z = new C1132w();
                break;
            case 295:
                c1155z = new C1083t();
                break;
            case 296:
                c1155z = new C0920a();
                break;
            case 297:
                c1155z = new C0928b();
                break;
            case 304:
                c1155z = new C1040r();
                break;
            case 305:
                c1155z = new C0843d();
                break;
            case 306:
                c1155z = new C0863h();
                break;
            case 307:
                c1155z = new C0860g();
                break;
            default:
                try {
                    if (!TextUtils.isEmpty(stringExtra)) {
                        c1155z = (C0399d) Class.forName(stringExtra).newInstance();
                        break;
                    } else {
                        c1155z = null;
                        break;
                    }
                } catch (Exception e) {
                    c1155z = null;
                    break;
                }
        }
        if (c1155z != null) {
            this.f412e = c1155z.getClass().getSimpleName();
            c1155z.setArguments(extras);
            m52a(c1155z);
            return;
        }
        finish();
    }

    protected void onResume() {
        super.onResume();
        if (this.f411d == 276) {
            m72x();
        }
    }
}
