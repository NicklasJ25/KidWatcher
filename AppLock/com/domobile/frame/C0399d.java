package com.domobile.frame;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1290d;
import java.lang.ref.WeakReference;

public abstract class C0399d extends Fragment implements OnClickListener {
    private static final int HANDLE_HIDE_LOADING_DIALOG = 100;
    private static final int HANDLE_SHOW_CANCEL_LOADING_DIALOG = 102;
    private static final int HANDLE_SHOW_LOADING_DIALOG = 101;
    private boolean isResumed;
    public C1263b mActionBar;
    private ActionBarHelper mActionBarHelper;
    public ActionBarActivity mActivity;
    public final Handler mHandler = new C12661(this);
    private C1290d progress;
    public View rootView;
    private boolean showBackButton;
    private C1267a tHandler;

    class C12661 extends Handler {
        final /* synthetic */ C0399d f2604a;

        C12661(C0399d c0399d) {
            this.f2604a = c0399d;
        }

        public void handleMessage(Message message) {
            this.f2604a.ui(message.what, message);
        }
    }

    public static class C1267a extends Handler {
        WeakReference<C0399d> f2605a;

        public C1267a(C0399d c0399d) {
            super(Looper.getMainLooper());
            this.f2605a = new WeakReference(c0399d);
        }

        public WeakReference<C0399d> m3019a() {
            return this.f2605a;
        }

        public void m3020a(C0399d c0399d) {
            this.f2605a = new WeakReference(c0399d);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 100:
                    if (this.f2605a.get() != null) {
                        ((C0399d) this.f2605a.get()).hideLoadingDialog_mt();
                        return;
                    }
                    return;
                case 101:
                    if (this.f2605a.get() != null) {
                        ((C0399d) this.f2605a.get()).showLoadingDialog_mt();
                        return;
                    }
                    return;
                case 102:
                    if (this.f2605a.get() != null) {
                        ((C0399d) this.f2605a.get()).showCancelableLoadingDialog_mt();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void initProgressHandler() {
        if (this.tHandler == null) {
            this.tHandler = new C1267a(this);
        }
        if (this.tHandler.m3019a().get() == null) {
            this.tHandler.m3020a(this);
        }
    }

    public final void call(int i) {
        call(i, new Message());
    }

    public final void call(int i, Message message) {
        call(i, message, 0);
    }

    public final void call(int i, Message message, long j) {
        message.what = i;
        this.mHandler.sendMessageDelayed(message, j);
    }

    public final void callDelayed(int i, long j) {
        call(i, new Message(), j);
    }

    public View findViewById(int i) {
        return this.rootView.findViewById(i);
    }

    public C1263b getActionBar() {
        return this.mActionBar;
    }

    public ActionBarHelper getActionBarHelper() {
        return this.mActionBarHelper;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mActivity.getLayoutInflater();
    }

    public LayoutInflater getLayoutInflater(Bundle bundle) {
        return this.mActivity.getLayoutInflater();
    }

    public MenuInflater getMenuInflater() {
        return this.mActivity.getMenuInflater();
    }

    public C1290d getProgressDialog() {
        return this.progress;
    }

    public void hideKeyboard(View view) {
        ((InputMethodManager) this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void hideLoadingDialog() {
        initProgressHandler();
        this.tHandler.sendEmptyMessageDelayed(100, 1000);
    }

    public void hideLoadingDialog_mt() {
        C1148d.m2517a(this.progress);
    }

    public abstract void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public boolean isFragmentResumed() {
        return this.isResumed;
    }

    public boolean isFragmentWithoutActionBar() {
        return false;
    }

    public boolean isInitDefaultTitleButtons() {
        return false;
    }

    public boolean isNeedSearch() {
        return false;
    }

    public boolean isShowOptionsMenu() {
        return true;
    }

    public boolean isToolBarFloat() {
        return true;
    }

    public void onClick(View view) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mActivity == null) {
            this.mActivity = (ActionBarActivity) getActivity();
        }
        if (this.mActivity instanceof C0384c) {
            this.mActionBarHelper = ((C0384c) this.mActivity).m68t();
        }
        if (this.mActionBar == null) {
            this.mActionBar = new C1263b(this.mActivity, isNeedSearch(), isToolBarFloat(), isInitDefaultTitleButtons());
            if (getArguments() != null) {
                this.showBackButton = getArguments().getBoolean("EXTRA_SHOW_BACK", false);
            }
            this.showBackButton = this.mActivity.getIntent().getBooleanExtra("EXTRA_SHOW_BACK", this.showBackButton);
            this.mActionBar.m3010d(this.showBackButton);
        }
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        if (this.mActionBarHelper != null) {
            this.mActionBarHelper.configureMenu(this.mActivity, menu);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (menu != null) {
            menu.clear();
        }
        onCreateCustomOptionsMenus(menu, menuInflater);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(isShowOptionsMenu());
        if (isFragmentWithoutActionBar()) {
            if (!(this.rootView == null || this.rootView.getParent() == null)) {
                ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
            }
            if (this.rootView != null) {
                return this.rootView;
            }
            init(layoutInflater, viewGroup, bundle);
            return this.rootView;
        }
        if (!(this.mActionBar == null || this.mActionBar.m2997a() == null)) {
            this.mActionBar.m2997a().removeView(this.mActionBar.m3004b());
        }
        if (this.rootView != null) {
            return this.mActionBar.m3004b();
        }
        this.mActionBar.m3016i();
        init(layoutInflater, viewGroup, bundle);
        this.mActionBar.m3014g().addView(this.rootView);
        return this.mActionBar.m3004b();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public void onPause() {
        super.onPause();
        this.isResumed = false;
    }

    public void onResume() {
        super.onResume();
        this.isResumed = true;
        this.mActivity.invalidateOptionsMenu();
    }

    public void showCancelableLoadingDialog() {
        initProgressHandler();
        this.tHandler.sendEmptyMessage(102);
    }

    public void showCancelableLoadingDialog_mt() {
        if (this.progress != null && this.progress.m3121c()) {
            this.progress.m3125e();
        }
        this.progress = C1148d.m2505a(this.mActivity, null, null);
        this.progress.m3117b(true);
    }

    public void showLoadingDialog() {
        initProgressHandler();
        this.tHandler.sendEmptyMessage(101);
    }

    public void showLoadingDialog_mt() {
        if (this.progress != null && this.progress.m3121c()) {
            this.progress.m3125e();
        }
        this.progress = C1148d.m2505a(this.mActivity, null, null);
        this.progress.m3117b(false);
    }

    public abstract void ui(int i, Message message);
}
