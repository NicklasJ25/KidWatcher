package com.domobile.frame;

import android.app.Activity;
import android.app.SearchManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import com.domobile.p015b.C1168b.C1162f;

public class ActionBarHelper {
    private C0655a mActionBarController;
    protected ActionBarActivity mActivity;
    private MenuItem mSearchItem;
    private SearchView mSearchView;

    class C12481 implements OnActionExpandListener {
        final /* synthetic */ ActionBarHelper f2544a;

        C12481(ActionBarHelper actionBarHelper) {
            this.f2544a = actionBarHelper;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            if (this.f2544a.mActionBarController != null) {
                this.f2544a.mActionBarController.mo2387g();
            }
            return true;
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            if (this.f2544a.mActionBarController != null) {
                this.f2544a.mActionBarController.mo2386f();
            }
            return true;
        }
    }

    protected ActionBarHelper(ActionBarActivity actionBarActivity) {
        this.mActivity = actionBarActivity;
    }

    public void clearSearch() {
        if (this.mSearchView != null) {
            this.mSearchView.setQuery("", false);
            this.mSearchView.setIconified(true);
            if (this.mSearchItem != null) {
                MenuItemCompat.collapseActionView(this.mSearchItem);
            }
        }
    }

    public void configureMenu(Activity activity, Menu menu) {
        if (menu == null) {
            this.mSearchItem = null;
            this.mSearchView = null;
            this.mActionBarController = null;
            return;
        }
        this.mSearchItem = menu.findItem(C1162f.menu_actionbar_search);
        if (this.mSearchItem != null) {
            MenuItemCompat.setOnActionExpandListener(this.mSearchItem, new C12481(this));
            this.mSearchView = (SearchView) MenuItemCompat.getActionView(this.mSearchItem);
            this.mSearchView.setSearchableInfo(((SearchManager) activity.getSystemService("search")).getSearchableInfo(this.mActivity.getComponentName()));
        }
    }

    public MenuItem getSearchItem() {
        return this.mSearchItem;
    }

    public SearchView getSearchView() {
        return this.mSearchView;
    }

    public boolean isInSearchMode() {
        return this.mSearchItem != null && MenuItemCompat.isActionViewExpanded(this.mSearchItem);
    }

    public void setActionBarController(C0655a c0655a) {
        this.mActionBarController = c0655a;
    }
}
