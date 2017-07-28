package com.domobile.applock;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import com.domobile.frame.p000a.C1148d;

public abstract class C0386c extends C0385b implements OnClickListener {
    public int f44a = -1;
    public boolean f45b = true;
    public boolean f46c = false;
    private BroadcastReceiver f47d = new C07441(this);

    class C07441 extends BroadcastReceiver {
        final /* synthetic */ C0386c f965a;

        C07441(C0386c c0386c) {
            this.f965a = c0386c;
        }

        public void onReceive(Context context, Intent intent) {
            if ("com.domobile.elock.main_finish".equals(intent.getAction())) {
                this.f965a.mo2042a();
            }
        }
    }

    public static class C0745a extends BaseAdapter {
        private Drawable f966a;
        private String[] f967b;
        private Context f968c;
        private boolean f969d;
        private Resources f970e;

        public C0745a(Context context, String[] strArr) {
            this(context, strArr, false);
        }

        public C0745a(Context context, String[] strArr, boolean z) {
            this.f968c = context;
            this.f970e = context.getResources();
            if (strArr == null) {
                strArr = new String[0];
            }
            this.f967b = strArr;
            this.f966a = C1148d.m2502a(this.f970e, (int) R.drawable.btn_arrow);
            this.f969d = z;
        }

        public String m1064a(int i) {
            return this.f969d ? this.f967b[i - 1] : this.f967b[i];
        }

        public int getCount() {
            return (this.f969d ? 1 : 0) + this.f967b.length;
        }

        public /* synthetic */ Object getItem(int i) {
            return m1064a(i);
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(this.f968c).inflate(R.layout.codeset_list_item, null);
            }
            ImageView imageView = (ImageView) view.findViewById(16908294);
            CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(16908308);
            checkedTextView.setCheckMarkDrawable(null);
            if (this.f969d && i == 0) {
                checkedTextView.setText(R.string.none_operation);
            } else {
                checkedTextView.setText(m1064a(i));
            }
            if (i == getCount() - 1) {
                Drawable mutate = this.f966a.mutate();
                mutate.setColorFilter(ResourcesCompat.getColor(this.f970e, R.color.code_list_item_checker_tintcolor, null), Mode.SRC_ATOP);
                checkedTextView.setCheckMarkDrawable(mutate);
                imageView.setImageResource(R.drawable.toolbar_add);
            } else if (this.f969d) {
                if (i == 0) {
                    imageView.setImageResource(R.drawable.toolbar_noimage);
                } else if (i == 1) {
                    imageView.setImageResource(R.drawable.toolbar_unlock_all);
                } else if (i == 2) {
                    imageView.setImageResource(R.drawable.toolbar_guest);
                } else {
                    imageView.setImageResource(R.drawable.toolbar_profile);
                }
            } else if (i == 0) {
                imageView.setImageResource(R.drawable.toolbar_unlock_all);
            } else if (i == 1) {
                imageView.setImageResource(R.drawable.toolbar_guest);
            } else {
                imageView.setImageResource(R.drawable.toolbar_profile);
            }
            return view;
        }
    }

    public void mo2042a() {
        this.f46c = true;
        this.f45b = false;
        ActivityCompat.finishAfterTransition(this);
    }

    public void m78a(boolean z) {
        m80e();
        startActivity(C0947g.m1672a((Context) this, z));
    }

    public void mo2041d() {
    }

    public void m80e() {
        this.f46c = true;
        this.f45b = false;
    }

    public boolean mo2043f() {
        m80e();
        return false;
    }

    public void finish() {
        super.finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerReceiver(this.f47d, new IntentFilter("com.domobile.elock.main_finish"));
    }

    protected void onDestroy() {
        C1148d.m2509a((Context) this, this.f47d);
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (m55a(i, keyEvent)) {
            return true;
        }
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        if (m68t().isInSearchMode()) {
            m68t().clearSearch();
            return true;
        }
        this.f46c = true;
        mo2042a();
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        if (onOptionsItemSelected || menuItem.getItemId() != 16908332) {
            return onOptionsItemSelected;
        }
        mo2042a();
        return true;
    }

    protected void onPause() {
        super.onPause();
        C1148d.m2520b((Context) this, "latest_leave_app_timemills", (Object) Long.valueOf(System.currentTimeMillis()));
    }

    protected void onResume() {
        super.onResume();
        m69u();
        this.f46c = false;
        this.f45b = true;
        C1150y.m2612c((Activity) this);
    }

    protected void onStop() {
        if (!this.f46c) {
            C1148d.m2489A(this, "com.domobile.elock.main_finish");
        }
        if (this.f45b) {
            finish();
        }
        this.f46c = false;
        this.f45b = true;
        super.onStop();
    }
}
