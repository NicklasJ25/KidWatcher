package com.domobile.applock;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.support.v7.widget.helper.ItemTouchHelper.SimpleCallback;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.domobile.applock.adapter.C0684e;
import com.domobile.applock.adapter.C0684e.C0682a;
import com.domobile.applock.p012e.C0896a;
import com.domobile.applock.p012e.C0896a.C0895a;
import com.domobile.applock.p012e.C0898c;
import com.domobile.applock.p012e.C0899d;
import com.domobile.applock.p012e.C0900e;
import com.domobile.frame.p000a.C1148d;
import com.domobile.widget.recyclerview.NpaLinearLayoutManager;
import java.util.ArrayList;
import java.util.Collection;

@TargetApi(18)
public class C1047s extends C0400d implements C0682a, C0895a {
    Callback f1892a = new SimpleCallback(this, 0, 12) {
        final /* synthetic */ C1047s f1887a;

        public boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder viewHolder2) {
            return false;
        }

        public void onSwiped(ViewHolder viewHolder, int i) {
            int adapterPosition = viewHolder.getAdapterPosition();
            C0899d b = this.f1887a.f1893e.m886b(adapterPosition);
            this.f1887a.f1893e.m883a(adapterPosition);
            C0896a.m1545a().m1556a(b);
            this.f1887a.m2112e();
        }
    };
    private C0684e f1893e;
    private LinearLayoutManager f1894f;
    private RecyclerView f1895g;
    private boolean f1896h = false;
    private AnimatorListener f1897i = new C10453(this);

    class C10431 extends AsyncTask<Object, Object, ArrayList<C0899d>> {
        final /* synthetic */ C1047s f1886a;

        C10431(C1047s c1047s) {
            this.f1886a = c1047s;
        }

        protected ArrayList<C0899d> m2102a(Object... objArr) {
            if (this.f1886a.f1896h) {
                SystemClock.sleep(900);
            }
            return C0900e.m1582b();
        }

        protected void m2103a(ArrayList<C0899d> arrayList) {
            this.f1886a.f1893e.m885a((ArrayList) arrayList);
            this.f1886a.m2112e();
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m2102a(objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m2103a((ArrayList) obj);
        }
    }

    class C10453 implements AnimatorListener {
        final /* synthetic */ C1047s f1888a;

        C10453(C1047s c1047s) {
            this.f1888a = c1047s;
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            C0896a.m1545a().m1561d();
            this.f1888a.f1893e.m882a();
            this.f1888a.m2112e();
            this.f1888a.f1896h = false;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public class C1046a extends ItemDecoration {
        final /* synthetic */ C1047s f1889a;
        private int f1890b;
        private int f1891c;

        C1046a(C1047s c1047s) {
            this.f1889a = c1047s;
            Resources resources = c1047s.mActivity.getResources();
            this.f1890b = resources.getDimensionPixelSize(R.dimen.PaddingSizeSmaller);
            this.f1891c = resources.getDimensionPixelSize(R.dimen.PaddingSizeSmall);
        }

        private boolean m2104a(View view, RecyclerView recyclerView) {
            return recyclerView.getChildAdapterPosition(view) == 0;
        }

        private boolean m2105b(View view, RecyclerView recyclerView) {
            return recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() + -1;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (m2105b(view, recyclerView)) {
                rect.set(this.f1891c, this.f1891c, this.f1891c, this.f1891c);
            } else if (m2104a(view, recyclerView)) {
                rect.set(this.f1891c, this.f1891c, this.f1891c, 0);
            } else {
                rect.set(this.f1891c, this.f1890b, this.f1891c, 0);
            }
        }
    }

    private void m2109c() {
        this.f1895g = (RecyclerView) this.rootView.findViewById(R.id.rcvNotificationList);
        this.f1895g.setItemViewCacheSize(0);
        this.f1895g.setHasFixedSize(true);
        this.f1894f = new NpaLinearLayoutManager(getContext());
        this.f1895g.setLayoutManager(this.f1894f);
        this.f1895g.addItemDecoration(new C1046a(this));
        this.f1893e = new C0684e();
        this.f1893e.m884a((C0682a) this);
        this.f1895g.setAdapter(this.f1893e);
        new ItemTouchHelper(this.f1892a).attachToRecyclerView(this.f1895g);
    }

    private void m2111d() {
        C1148d.m2521b(new C10431(this), new Object[0]);
    }

    private void m2112e() {
        if (this.f1893e.getItemCount() == 0) {
            findViewById(R.id.imvEmptyView).setVisibility(0);
        } else {
            findViewById(R.id.imvEmptyView).setVisibility(8);
        }
        try {
            this.mActivity.invalidateOptionsMenu();
        } catch (Exception e) {
        }
    }

    public void mo2475a(C0899d c0899d) {
        m2111d();
    }

    public void mo2476b() {
    }

    public void mo2477b(int i) {
        this.b.m80e();
        C0899d b = this.f1893e.m886b(i);
        this.f1893e.m883a(i);
        C0898c.m1567a(getContext(), b);
        C0896a.m1545a().m1556a(b);
        m2112e();
    }

    public void mo2478b(C0899d c0899d) {
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.init(layoutInflater, viewGroup, bundle);
        this.rootView = layoutInflater.inflate(R.layout.fragment_notification_center, null);
        m2109c();
        m2111d();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0896a.m1545a().m1555a((C0895a) this);
        C1150y.m2605b(this.mActivity, (int) R.string.event_notification_center);
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.notification_center_menus, menu);
        super.onCreateCustomOptionsMenus(menu, menuInflater);
    }

    public void onDestroy() {
        super.onDestroy();
        C0896a.m1545a().m1559b((C0895a) this);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_action_clear && !this.f1896h) {
            this.f1896h = true;
            int findFirstVisibleItemPosition = this.f1894f.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = (this.f1894f.findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1;
            long j = 600 / ((long) findLastVisibleItemPosition);
            long j2 = 0;
            Collection arrayList = new ArrayList();
            for (int i = findFirstVisibleItemPosition; i < findFirstVisibleItemPosition + findLastVisibleItemPosition; i++) {
                ViewHolder findViewHolderForAdapterPosition = this.f1895g.findViewHolderForAdapterPosition(i);
                if (findViewHolderForAdapterPosition != null) {
                    findViewHolderForAdapterPosition.setIsRecyclable(false);
                    View view = findViewHolderForAdapterPosition.itemView;
                    float x = ViewCompat.getX(view);
                    float measuredWidth = (float) this.f1895g.getMeasuredWidth();
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "x", new float[]{x, measuredWidth});
                    ofFloat.setDuration(600 - j2);
                    arrayList.add(ofFloat);
                    j2 += j;
                }
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.addListener(this.f1897i);
            animatorSet.start();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.menu_action_clear).setVisible(this.f1893e.getItemCount() > 0);
    }
}
