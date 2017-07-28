package com.domobile.applock.chamber.controller;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.domobile.applock.C0400d;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.InvaderBean;
import com.domobile.applock.chamber.p009c.C0814g;
import com.domobile.applock.p003a.C0614e;
import com.domobile.applock.p013f.C0903a;
import com.domobile.frame.p000a.C1148d;

public class C0860g extends C0400d {
    private InvaderBean f1217a;
    private ImageView f1218e;
    private ViewGroup f1219f;

    class C08581 extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ C0860g f1212a;

        C08581(C0860g c0860g) {
            this.f1212a = c0860g;
        }

        protected Object doInBackground(Object... objArr) {
            C0814g.m1296a(this.f1212a.mActivity, this.f1212a.f1217a);
            return null;
        }

        protected void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            this.f1212a.hideLoadingDialog();
        }

        protected void onPreExecute() {
            super.onPreExecute();
            this.f1212a.showLoadingDialog();
        }
    }

    private void m1449b() {
        this.f1219f = (ViewGroup) findViewById(R.id.vlgContainer);
        this.f1218e = (ImageView) findViewById(R.id.imvImage);
        ((TextView) findViewById(R.id.txvTime)).setText(this.f1217a.m1521b());
    }

    private void m1451c() {
        int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.PaddingSizeMiddle);
        final int i = this.mActivity.getResources().getDisplayMetrics().widthPixels - (dimensionPixelSize * 2);
        dimensionPixelSize = this.mActivity.getResources().getDisplayMetrics().heightPixels - (dimensionPixelSize * 2);
        final int i2 = this.mActivity.getResources().getConfiguration().orientation;
        C1148d.m2521b(new AsyncTask<Object, Object, Bitmap>(this) {
            final /* synthetic */ C0860g f1216d;

            protected Bitmap m1445a(Object... objArr) {
                Bitmap decodeFile = BitmapFactory.decodeFile(this.f1216d.f1217a.f1297a);
                if (decodeFile == null) {
                    return null;
                }
                return C0903a.m1589a(decodeFile, i2 == 2 ? ((float) dimensionPixelSize) / ((float) decodeFile.getHeight()) : ((float) i) / ((float) decodeFile.getWidth()));
            }

            protected void m1446a(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                this.f1216d.f1218e.setImageBitmap(bitmap);
                this.f1216d.f1219f.setVisibility(0);
            }

            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return m1445a(objArr);
            }

            protected /* synthetic */ void onPostExecute(Object obj) {
                m1446a((Bitmap) obj);
            }

            protected void onPreExecute() {
                super.onPreExecute();
                this.f1216d.f1219f.setVisibility(4);
            }
        }, new Object[0]);
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.init(layoutInflater, viewGroup, bundle);
        this.rootView = layoutInflater.inflate(R.layout.fragment_invade_detail, null);
        m1449b();
        m1451c();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f1218e != null) {
            m1451c();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.intruder_hint_title);
        this.f1217a = (InvaderBean) getArguments().getParcelable("EXTRA_INVADER");
        C1150y.m2651r(this.mActivity);
        C1150y.m2605b(this.mActivity, (int) R.string.event_invader_detail);
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.invader_detail_menus, menu);
        super.onCreateCustomOptionsMenus(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_action_delete) {
            C0614e.m707a(this.f1217a.f1297a);
            this.b.mo2042a();
            return true;
        } else if (itemId != R.id.menu_action_save) {
            return false;
        } else {
            C1148d.m2521b(new C08581(this), new Object[0]);
            return true;
        }
    }

    public void onStart() {
        super.onStart();
    }
}
