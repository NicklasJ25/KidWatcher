package com.android.camera;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.camera.C0423j.C0481a;
import com.android.camera.gallery.C0457j;
import com.android.camera.gallery.C0468o;
import com.android.camera.gallery.HidedPictureItem;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.C0400d;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.adapter.C0420b;
import com.domobile.applock.p003a.C0633m;
import com.domobile.applock.service.HidedMediasActionService;
import com.domobile.applock.service.HidedMediasActionService.C0425d;
import com.domobile.frame.C0415f;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1257b;
import com.domobile.frame.ui.C1288c;
import com.domobile.libs_ads.C1342b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.p068a.p069a.C3614d;

public class C0426f extends C0400d implements C0425d {
    private Handler f133A = new C04175(this);
    public boolean f134a = false;
    private View f135e;
    private RecyclerView f136f;
    private TextView f137g;
    private ArrayList<HidedPictureItem> f138h = new ArrayList();
    private ArrayList<HidedPictureItem> f139i = new ArrayList();
    private ArrayList<HidedPictureItem> f140j = new ArrayList();
    private ArrayList<HidedPictureItem> f141k = new ArrayList();
    private HidedMediasActionService f142l;
    private C0424a f143m;
    private C1288c f144n;
    private Animation f145o;
    private Intent f146p;
    private Resources f147q;
    private AppLockApplication f148r;
    private long f149s = 0;
    private int f150t = 0;
    private int f151u = 0;
    private HidedPictureItem f152v;
    private String f153w = "";
    private boolean f154x = true;
    private boolean f155y = true;
    private C0415f f156z = new C04164(this);

    class C04121 implements OnClickListener {
        final /* synthetic */ C0426f f110a;

        C04121(C0426f c0426f) {
            this.f110a = c0426f;
        }

        public void onClick(View view) {
            C1148d.m2489A(this.f110a.b, "com.domobile.applock.ACTION_MEDIAS_ACTION_ABORT");
            this.f110a.b.mo2042a();
        }
    }

    class C04132 implements OnClickListener {
        final /* synthetic */ C0426f f111a;

        C04132(C0426f c0426f) {
            this.f111a = c0426f;
        }

        public void onClick(View view) {
            this.f111a.b.mo2042a();
        }
    }

    class C04143 implements OnClickListener {
        final /* synthetic */ C0426f f112a;

        C04143(C0426f c0426f) {
            this.f112a = c0426f;
        }

        public void onClick(View view) {
            this.f112a.b.mo2042a();
        }
    }

    class C04164 extends C0415f {
        final /* synthetic */ C0426f f113a;

        C04164(C0426f c0426f) {
            this.f113a = c0426f;
        }

        public void onAnimationEnd(Animation animation) {
            this.f113a.f155y = true;
            this.f113a.f133A.sendEmptyMessageDelayed(100, 300);
        }

        public void onAnimationStart(Animation animation) {
            this.f113a.f155y = false;
        }
    }

    class C04175 extends Handler {
        final /* synthetic */ C0426f f114a;

        C04175(C0426f c0426f) {
            this.f114a = c0426f;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 102:
                    this.f114a.m213e();
                    return;
                case 103:
                    if (message.obj != null) {
                        this.f114a.m202a((String) message.obj, message.arg1);
                        return;
                    } else {
                        this.f114a.m202a("", message.arg1);
                        return;
                    }
                case 104:
                    this.f114a.m210c();
                    return;
                case 105:
                    this.f114a.f150t = this.f114a.f150t - 1;
                    removeMessages(105);
                    if (this.f114a.f150t >= 0) {
                        if (this.f114a.f150t > 1) {
                            sendEmptyMessageDelayed(105, 1000);
                        }
                        this.f114a.f137g.setText(this.f114a.mActivity.getString(R.string.move_video_remain_time, new Object[]{this.f114a.f153w, this.f114a.m205b(this.f114a.f150t)}));
                        this.f114a.f137g.setVisibility(0);
                        return;
                    }
                    this.f114a.f137g.setText(this.f114a.f154x ? R.string.operation_success : R.string.operation_failed);
                    return;
                case 106:
                    if (message.obj != null) {
                        HidedPictureItem hidedPictureItem = (HidedPictureItem) message.obj;
                        this.f114a.f140j.add(hidedPictureItem);
                        if (hidedPictureItem.f192k == 0) {
                            this.f114a.f141k.add(hidedPictureItem);
                        }
                        this.f114a.f133A.sendEmptyMessage(100);
                        return;
                    }
                    return;
                default:
                    if (message.what == 100) {
                        if (this.f114a.f143m != null) {
                            this.f114a.f143m.mo2399j();
                            return;
                        }
                        return;
                    } else if (message.what == 101) {
                        this.f114a.f143m = new C0424a(this.f114a, this.f114a.mActivity, this.f114a.f138h);
                        this.f114a.f136f.setAdapter(this.f114a.f143m);
                        if (this.f114a.f138h.size() > 0) {
                            this.f114a.f134a = ((HidedPictureItem) this.f114a.f138h.get(0)).m289g();
                            this.f114a.f152v = (HidedPictureItem) this.f114a.f138h.get(0);
                        }
                        if (this.f114a.f134a) {
                            this.f114a.m212d();
                        }
                        this.f114a.m207b();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    private class C0424a extends C0423j {
        final /* synthetic */ C0426f f131a;
        private int f132k = -1;

        public C0424a(C0426f c0426f, Activity activity, ArrayList arrayList) {
            this.f131a = c0426f;
            super(activity, arrayList, true);
        }

        private int m186h() {
            if (this.f132k > 0) {
                return this.f132k;
            }
            GridLayoutManager gridLayoutManager = (GridLayoutManager) this.f131a.f136f.getLayoutManager();
            this.f132k = Math.min(gridLayoutManager.findFirstVisibleItemPosition() - gridLayoutManager.findFirstVisibleItemPosition(), m185g().size());
            return this.f132k;
        }

        public BitmapDrawable mo2069a(Object obj) {
            if (obj == null || !(obj instanceof HidedPictureItem)) {
                return null;
            }
            if (m185g().indexOf(obj) >= this.f131a.f143m.m186h() - 1 && this.f131a.f142l != null) {
                this.f131a.f142l.f1905a = true;
            }
            return super.mo2069a(obj);
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            int i2 = 0;
            final C0481a c0481a = (C0481a) viewHolder;
            HidedPictureItem hidedPictureItem = (HidedPictureItem) m185g().get(i);
            boolean z = this.f131a.f152v == hidedPictureItem && this.f131a.f155y && this.f131a.f149s > 52428800;
            ProgressBar progressBar = c0481a.f294d;
            if (!z) {
                i2 = 8;
            }
            progressBar.setVisibility(i2);
            c0481a.f292b.setImageDrawable(null);
            if (this.f131a.f140j.contains(hidedPictureItem)) {
                c0481a.f292b.setImageResource(R.drawable.green_flag);
                if (!hidedPictureItem.f193l) {
                    hidedPictureItem.f193l = true;
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.c, R.anim.vault_state_anim);
                    loadAnimation.setAnimationListener(this.f131a.f156z);
                    c0481a.f292b.startAnimation(loadAnimation);
                }
            } else if (this.f131a.f139i.contains(hidedPictureItem)) {
                c0481a.f292b.setImageResource(R.drawable.toolbar_delete);
            }
            if (this.f131a.f141k.contains(hidedPictureItem)) {
                this.f131a.f145o = AnimationUtils.loadAnimation(this.c, R.anim.custom_dialog_disappear);
                this.f131a.f145o.setAnimationListener(new C0415f(this) {
                    final /* synthetic */ C0424a f116b;

                    public void onAnimationEnd(Animation animation) {
                        c0481a.f293c.setImageDrawable(null);
                    }
                });
                c0481a.f293c.startAnimation(this.f131a.f145o);
                this.f131a.f141k.remove(hidedPictureItem);
            }
            if (hidedPictureItem != c0481a.f291a.getTag()) {
                if (this.f131a.f142l != null) {
                    if (c0481a.f291a.getTag() != null) {
                        this.f131a.f142l.m2157c().remove(c0481a.f291a.getTag());
                    }
                    this.f131a.f142l.m2157c().add(hidedPictureItem);
                }
                c0481a.f291a.setTag(hidedPictureItem);
                c0481a.f293c.setImageResource(R.drawable.transparent);
                c0481a.f293c.setImage(hidedPictureItem);
            }
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            C0481a c0481a = (C0481a) super.onCreateViewHolder(viewGroup, i);
            c0481a.f292b.setVisibility(0);
            return c0481a;
        }
    }

    private HidedPictureItem m198a(Uri uri, String str) {
        Cursor query;
        Throwable th;
        Cursor cursor = null;
        try {
            if ("content".equals(uri.getScheme())) {
                ContentResolver contentResolver = this.mActivity.getContentResolver();
                HidedPictureItem hidedPictureItem;
                if (uri.toString().contains("video")) {
                    query = contentResolver.query(uri, C0468o.f255h, null, null, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                hidedPictureItem = new HidedPictureItem(C0468o.m354a(this.mActivity, query, uri));
                                if (query != null) {
                                    query.close();
                                }
                                return hidedPictureItem;
                            }
                        } catch (Exception e) {
                            if (query != null) {
                                query.close();
                            }
                            return cursor;
                        } catch (Throwable th2) {
                            cursor = query;
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                }
                query = contentResolver.query(uri, C0457j.f231h, null, null, null);
                if (query != null) {
                    if (query.moveToFirst()) {
                        hidedPictureItem = new HidedPictureItem(C0457j.m320a(this.mActivity, query, uri));
                        if (query != null) {
                            query.close();
                        }
                        return hidedPictureItem;
                    }
                }
            } else if ("file".equals(uri.getScheme())) {
                HidedPictureItem hidedPictureItem2 = new HidedPictureItem(new File(uri.toString().substring(7)), str);
                if (cursor == null) {
                    return hidedPictureItem2;
                }
                cursor.close();
                return hidedPictureItem2;
            } else {
                query = cursor;
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e2) {
            query = cursor;
            if (query != null) {
                query.close();
            }
            return cursor;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return cursor;
    }

    private void m200a(Intent intent, String str) {
        if (HidedMediasActionService.m2151d()) {
            this.b.mo2042a();
        } else if (str.equals("android.intent.action.SEND")) {
            String type = intent.getType();
            Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
            if (uri == null || type == null) {
                this.b.mo2042a();
                return;
            }
            HidedPictureItem a = m198a(uri, type);
            if (a != null) {
                a.m280a(this.mActivity, false);
            } else {
                this.b.mo2042a();
            }
        } else if (str.equals("android.intent.action.SEND_MULTIPLE")) {
            String type2 = intent.getType();
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            if (type2 == null || parcelableArrayListExtra == null) {
                this.b.mo2042a();
            } else {
                m208b(parcelableArrayListExtra, type2);
            }
        }
    }

    private void m202a(String str, int i) {
        CharSequence string;
        C1288c c1288c = new C1288c(this.mActivity);
        c1288c.m3101a((int) R.string.operation_failed);
        c1288c.m3113b((int) R.drawable.icon_dialog_alert_holo_light);
        if (i != 101) {
            string = this.mActivity.getString(R.string.medias_action_error, new Object[]{str});
            c1288c.m3102a(17039360, null);
        }
        c1288c.mo2528a(string);
        c1288c.m3114b(17039370, new C04143(this)).m3117b(true).m3122d();
        this.f144n = c1288c;
    }

    private String m205b(int i) {
        int i2 = i % 60;
        return C1147a.m2480a(C1150y.m2573a(i / 60, 2), ":", C1150y.m2573a(i2, 2));
    }

    private void m207b() {
        if (!this.f138h.isEmpty()) {
            int i = ((HidedPictureItem) this.f138h.get(0)).f192k;
            if (i == 0) {
                this.b.m56b(R.string.delete);
            } else if (i == 1) {
                this.b.m56b(R.string.revert);
            } else {
                this.b.m56b(R.string.hide);
            }
        }
    }

    private void m208b(ArrayList<Uri> arrayList, String str) {
        showLoadingDialog();
        Collection arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            HidedPictureItem a = m198a((Uri) it.next(), str);
            if (a != null) {
                a.f192k = 2;
                arrayList2.add(a);
            }
        }
        if (arrayList2.isEmpty()) {
            this.b.mo2042a();
        } else {
            String c;
            CharSequence charSequence = ((HidedPictureItem) arrayList2.get(0)).f184c;
            if (TextUtils.isEmpty(charSequence)) {
                c = C3614d.m15751c(new File(((HidedPictureItem) arrayList2.get(0)).f189h).getParent());
            } else {
                CharSequence charSequence2 = charSequence;
            }
            C0633m c0633m = (C0633m) this.f148r.m596j().get(c);
            if (c0633m == null) {
                c0633m = new C0633m();
            }
            c0633m.f573a = c;
            c0633m.f574b.addAll(arrayList2);
            this.f148r.m596j().put(c, c0633m);
            HidedMediasActionService.m2136a(this.mActivity, false);
        }
        hideLoadingDialog();
    }

    private void m210c() {
        this.f142l = HidedMediasActionService.m2133a();
        if (this.f142l != null) {
            if (!(this.f142l.m2156b() == null || this.f142l.m2156b().isEmpty())) {
                this.f138h.addAll(this.f142l.m2156b());
                this.f133A.sendEmptyMessage(101);
            }
            this.f142l.m2154a((C0425d) this);
            return;
        }
        this.f133A.sendEmptyMessageDelayed(104, 500);
    }

    private void m212d() {
        int i = 0;
        if (this.f134a && !this.f138h.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.f138h);
            arrayList.removeAll(this.f140j);
            int i2 = ((HidedPictureItem) this.f138h.get(0)).f192k;
            if (i2 != 0) {
                if (i2 == 2) {
                    i = 1;
                }
                Iterator it = arrayList.iterator();
                long j = 0;
                while (it.hasNext()) {
                    HidedPictureItem hidedPictureItem = (HidedPictureItem) it.next();
                    long length = i == 0 ? new File(hidedPictureItem.f185d).length() : new File(hidedPictureItem.m281b()).length();
                    this.f149s = Math.max(length, this.f149s);
                    j += length;
                }
                if (j != 0 && this.f149s >= 52428800) {
                    if (TextUtils.isEmpty(this.f153w)) {
                        this.f153w = Formatter.formatFileSize(this.mActivity, j);
                    }
                    this.f150t = ((int) Math.ceil((double) ((((((float) j) / 1024.0f) / 1024.0f) - ((float) this.f151u)) / ((float) (i != 0 ? (long) C1150y.m2546K(this.mActivity) : (long) C1150y.m2547L(this.mActivity)))))) + 1;
                    this.f133A.sendEmptyMessage(105);
                }
            }
        }
    }

    private void m213e() {
        C1288c c1288c = new C1288c(this.mActivity);
        c1288c.m3101a((int) R.string.operation_success);
        c1288c.m3113b((int) R.drawable.ic_dialog_ok_holo_light);
        c1288c.m3123d((int) R.string.medias_action_done);
        c1288c.m3114b(17039370, new C04132(this)).m3117b(true).m3122d();
        this.f144n = c1288c;
    }

    public void mo2071a(int i, int i2) {
        this.f151u = i2;
        if (this.f149s > 52428800 && i != 0 && !this.f138h.isEmpty()) {
            int i3 = ((HidedPictureItem) this.f138h.get(0)).f192k;
            if (i3 == 2) {
                C1148d.m2520b(this.mActivity, "move_in_vault_speed", (Object) Integer.valueOf(i));
                m212d();
            } else if (i3 == 1) {
                C1148d.m2520b(this.mActivity, "move_out_vault_speed", (Object) Integer.valueOf(i));
                m212d();
            }
        }
    }

    public void mo2072a(HidedPictureItem hidedPictureItem) {
        if (hidedPictureItem != null) {
            if (hidedPictureItem.f192k != 0) {
                m212d();
            }
            this.f155y = false;
            this.f133A.sendMessageDelayed(this.f133A.obtainMessage(106, hidedPictureItem), 300);
        }
    }

    public void mo2073a(ArrayList<HidedPictureItem> arrayList) {
        this.f138h.clear();
        this.f138h.addAll(arrayList);
        this.f133A.sendEmptyMessage(101);
    }

    public void mo2074a(ArrayList<HidedPictureItem> arrayList, String str) {
        boolean z = false;
        this.f150t = 0;
        this.f154x = false;
        this.f133A.sendEmptyMessage(105);
        if (arrayList != null) {
            if (TextUtils.isEmpty(this.f146p.getStringExtra("com.domobile.applock.EXTRA_BUNDLE"))) {
                z = true;
            }
            this.f139i.addAll(arrayList);
            Message obtainMessage = this.f133A.obtainMessage(103, str);
            obtainMessage.arg1 = z ? 100 : 101;
            this.f133A.sendEmptyMessage(100);
            this.f133A.sendMessage(obtainMessage);
        }
    }

    public void mo2075b(HidedPictureItem hidedPictureItem) {
        if (this.f149s >= 52428800) {
            this.f152v = hidedPictureItem;
            this.f133A.sendEmptyMessage(100);
        }
    }

    public void mo2076b(ArrayList<HidedPictureItem> arrayList) {
        this.f150t = 0;
        this.f133A.sendEmptyMessage(105);
        if (TextUtils.isEmpty(this.f146p.getStringExtra("com.domobile.applock.EXTRA_BUNDLE"))) {
            this.f133A.sendEmptyMessageDelayed(102, 500);
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f139i.addAll(arrayList);
                this.f133A.sendEmptyMessage(100);
                return;
            }
            return;
        }
        this.b.mo2042a();
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.image_gallery, null);
        this.f137g = (TextView) findViewById(R.id.remain_time_textview);
        this.f136f = (RecyclerView) findViewById(R.id.listview);
        this.f136f.setLayoutManager(new GridLayoutManager(this.mActivity, C0420b.m168a(this.mActivity)));
        this.f136f.setAdapter(this.f143m);
        if (C1150y.m2598b(this.mActivity).f2224i) {
            this.mActionBar.m3010d(false);
            this.mActionBar.m3008c(false);
            m207b();
        } else {
            this.mActionBar.m3010d(false);
            this.mActionBar.m3008c(false);
            m207b();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0420b.m169a(this.f136f, C0420b.m168a(this.mActivity));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f147q = this.mActivity.getResources();
        this.f148r = C1150y.m2566a(this.mActivity);
        this.mActivity.getWindow().addFlags(128);
        this.f146p = this.mActivity.getIntent();
        String action = this.f146p.getAction();
        if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
            this.f146p.putExtra("com.domobile.applock.EXTRA_BUNDLE", "android.intent.action.VIEW");
            m200a(this.f146p, action);
        }
        m210c();
        if (this.f138h == null) {
            this.b.mo2042a();
        }
        this.f143m = new C0424a(this, this.mActivity, this.f138h);
        C1257b.m2966a(this.mActivity).m2980a(1).m2981a(true);
    }

    public void onDestroy() {
        C1342b.m3328a(this.f135e);
        this.f133A.removeCallbacksAndMessages(null);
        this.f135e = null;
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        if (this.f144n == null) {
            C1288c c1288c = new C1288c(this.mActivity);
            c1288c.m3123d((int) R.string.cancel_all_medias_action);
            c1288c.m3102a(17039360, null);
            c1288c.m3114b(17039370, new C04121(this)).m3117b(true).m3122d();
            return true;
        } else if (this.f144n.m3121c()) {
            return true;
        } else {
            this.b.mo2042a();
            return true;
        }
    }

    public void ui(int i, Message message) {
    }
}
