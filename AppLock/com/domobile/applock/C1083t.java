package com.domobile.applock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.android.gallery3d.app.Gallery;
import com.domobile.applock.adapter.C0419f;
import com.domobile.eframe.widget.pagetabs.C0917b;
import com.domobile.frame.http.image.CacheImageView;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.p000a.C1257b.C0421b;
import com.domobile.frame.p000a.C1257b.C0422e;
import com.domobile.frame.ui.C1288c;
import com.domobile.widget.OverscrollRecyclerView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.OutputStream;
import java.util.ArrayList;

public class C1083t extends C0400d {
    public ViewPager f2041a;
    public C1072a f2042e;
    public String f2043f = null;
    public String f2044g = null;
    public boolean f2045h = false;
    private int[] f2046i = new int[]{R.string.portrait, R.string.landscape};
    private int f2047j;
    private int f2048k;
    private C1082d[] f2049l = new C1082d[2];

    class C10711 implements Runnable {
        final /* synthetic */ C1083t f2007a;

        C10711(C1083t c1083t) {
            this.f2007a = c1083t;
        }

        public void run() {
            this.f2007a.a_(0);
        }
    }

    private class C1072a extends PagerAdapter implements C0917b {
        final /* synthetic */ C1083t f2008a;

        private C1072a(C1083t c1083t) {
            this.f2008a = c1083t;
        }

        public String mo2441a(int i) {
            return this.f2008a.mActivity.getString(this.f2008a.f2046i[i]);
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return this.f2008a.f2046i.length;
        }

        public CharSequence getPageTitle(int i) {
            return mo2441a(i);
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            boolean z = true;
            C1082d[] a = this.f2008a.f2049l;
            C1083t c1083t = this.f2008a;
            Context context = this.f2008a.mActivity;
            if (i != 1) {
                z = false;
            }
            a[i] = new C1082d(c1083t, context, z);
            viewGroup.addView(this.f2008a.f2049l[i].m2300a());
            this.f2008a.f2049l[i].m2302b();
            return this.f2008a.f2049l[i].m2300a();
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    private class C1074b extends C0419f implements OnClickListener, C0421b, C0422e {
        final /* synthetic */ C1083t f2011a;
        private boolean f2012b;
        private int f2013c;
        private int f2014k;
        private ArrayList<String> f2015l = new ArrayList();

        public C1074b(C1083t c1083t, String[] strArr, boolean z) {
            this.f2011a = c1083t;
            this.f2012b = z;
            for (String a : strArr) {
                this.f2015l.add(C1083t.m2305a(c1083t.mActivity, a).getAbsolutePath());
            }
            m2286a();
        }

        private void m2281a(boolean z, String str) {
            String str2 = !z ? "lock_bgimage_portrait" : "lock_bgimage_landscape";
            if (TextUtils.isEmpty(str)) {
                C1148d.m2534y(this.f2011a.mActivity, str2);
            } else {
                C1150y.m2583a(this.f2011a.mActivity, str2, str);
            }
            if (z) {
                this.f2011a.f2044g = str;
            } else {
                this.f2011a.f2043f = str;
            }
        }

        private void m2282b(int i) {
            CharSequence a = m2285a(i);
            if (new File(a).delete()) {
                if (TextUtils.equals(a, this.f2011a.f2044g)) {
                    C1148d.m2489A(this.f2011a.mActivity, "com.domobile.elock.ACTION_LOCK_BGIMAGE_CHANGED");
                    C1148d.m2534y(this.f2011a.mActivity, "lock_bgimage_landscape");
                    this.f2011a.f2044g = null;
                } else if (TextUtils.equals(a, this.f2011a.f2043f)) {
                    C1148d.m2489A(this.f2011a.mActivity, "com.domobile.elock.ACTION_LOCK_BGIMAGE_CHANGED");
                    C1148d.m2534y(this.f2011a.mActivity, "lock_bgimage_portrait");
                    this.f2011a.f2043f = null;
                }
                this.f2015l.remove(a);
                notifyDataSetChanged();
            }
        }

        public BitmapDrawable mo2069a(Object obj) {
            Options options = new Options();
            options.inSampleSize = 2;
            return new BitmapDrawable(this.f2011a.mActivity.getResources(), BitmapFactory.decodeFile((String) obj, options));
        }

        public C1075c m2284a(ViewGroup viewGroup, int i) {
            C1075c c1075c = new C1075c(this.f2011a, LayoutInflater.from(this.f2011a.mActivity).inflate(R.layout.pick_lock_background_item, viewGroup, false));
            c1075c.f2018c.m3044a((C0421b) this).m3045a((C0422e) this);
            c1075c.f2016a.setOnClickListener(this);
            c1075c.f2019d.setOnClickListener(this);
            return c1075c;
        }

        public String m2285a(int i) {
            try {
                return (String) this.f2015l.get(i - 1);
            } catch (Exception e) {
                return "";
            }
        }

        public void m2286a() {
            Resources resources = this.f2011a.mActivity.getResources();
            if (this.f2012b) {
                float min = ((((float) Math.min(this.f2011a.f2048k, this.f2011a.f2047j)) * 1.0f) / ((float) Math.max(this.f2011a.f2048k, this.f2011a.f2047j))) + 0.05f;
                this.f2013c = (this.f2011a.f2047j - resources.getDimensionPixelSize(R.dimen.pick_lockbg_items_whitespace_size_land)) / 2;
                this.f2014k = (int) (((float) this.f2013c) * min);
                return;
            }
            min = ((((float) Math.max(this.f2011a.f2048k, this.f2011a.f2047j)) * 1.0f) / ((float) Math.min(this.f2011a.f2048k, this.f2011a.f2047j))) - 0.1f;
            this.f2013c = (this.f2011a.f2047j - resources.getDimensionPixelSize(R.dimen.pick_lockbg_items_whitespace_size_port)) / 3;
            this.f2014k = (int) (((float) this.f2013c) * min);
        }

        public boolean mo2070a(CacheImageView cacheImageView, BitmapDrawable bitmapDrawable) {
            C1148d.m2514a((View) cacheImageView, (Drawable) bitmapDrawable);
            return true;
        }

        public boolean m2288b() {
            return this.f2012b;
        }

        public int getItemCount() {
            return this.f2015l.size() + 2;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            C1075c c1075c = (C1075c) viewHolder;
            LayoutParams layoutParams = c1075c.f2016a.getLayoutParams();
            layoutParams.width = this.f2013c;
            layoutParams.height = this.f2014k;
            c1075c.f2016a.setTag(Integer.valueOf(i));
            c1075c.f2019d.setTag(Integer.valueOf(i));
            c1075c.f2020e.setVisibility(8);
            c1075c.f2019d.setVisibility(8);
            c1075c.f2018c.setImageDrawable(null);
            C1148d.m2514a(c1075c.f2018c, null);
            CharSequence charSequence = this.f2012b ? this.f2011a.f2044g : this.f2011a.f2043f;
            if (i != 0 && i != getItemCount() - 1) {
                c1075c.f2019d.setVisibility(0);
                CharSequence a = m2285a(i);
                if (TextUtils.equals(a, charSequence)) {
                    c1075c.f2020e.setVisibility(0);
                }
                c1075c.f2018c.setImage(a);
            } else if (i == 0) {
                c1075c.f2018c.setBackgroundResource(R.drawable.num_background);
                if (TextUtils.isEmpty(charSequence)) {
                    c1075c.f2020e.setVisibility(0);
                }
            } else if (i == getItemCount() - 1) {
                c1075c.f2018c.setImageResource(R.drawable.ic_fab_plus);
                c1075c.f2018c.setBackgroundColor(ResourcesCompat.getColor(this.f2011a.mActivity.getResources(), R.color.pick_lockbg_item_new_bgcolor, null));
            }
        }

        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof Integer)) {
                final int intValue = ((Integer) tag).intValue();
                if (view.getId() != R.id.pick_lock_background_item_imgcontainer) {
                    C1288c c1288c = new C1288c(this.f2011a.mActivity);
                    c1288c.m3117b(true);
                    c1288c.mo2528a(this.f2011a.mActivity.getString(R.string.are_you_sure_delete, new Object[]{""}));
                    c1288c.m3102a(17039360, null);
                    c1288c.m3114b(17039370, new OnClickListener(this) {
                        final /* synthetic */ C1074b f2010b;

                        public void onClick(View view) {
                            this.f2010b.m2282b(intValue);
                        }
                    }).m3122d();
                } else if (intValue == 0) {
                    m2281a(this.f2012b, null);
                    notifyDataSetChanged();
                    C1148d.m2489A(this.f2011a.mActivity, "com.domobile.elock.ACTION_LOCK_BGIMAGE_CHANGED");
                } else if (intValue == getItemCount() - 1) {
                    this.f2011a.b.m80e();
                    try {
                        this.f2011a.startActivityForResult(new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI), m2288b() ? 101 : 100);
                    } catch (Exception e) {
                    }
                } else if (this.f2011a.a_(0) == null) {
                    m2281a(this.f2012b, m2285a(intValue));
                    C1148d.m2489A(this.f2011a.mActivity, "com.domobile.elock.ACTION_LOCK_BGIMAGE_CHANGED");
                    notifyDataSetChanged();
                }
            }
        }

        public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return m2284a(viewGroup, i);
        }
    }

    private class C1075c extends ViewHolder {
        public FrameLayout f2016a;
        final /* synthetic */ C1083t f2017b;
        private CacheImageView f2018c;
        private ImageButton f2019d;
        private ImageView f2020e;

        public C1075c(C1083t c1083t, View view) {
            this.f2017b = c1083t;
            super(view);
            this.f2016a = (FrameLayout) view.findViewById(R.id.pick_lock_background_item_imgcontainer);
            this.f2018c = (CacheImageView) view.findViewById(R.id.pick_lock_background_item_image);
            this.f2019d = (ImageButton) view.findViewById(R.id.pick_lock_background_item_delete);
            this.f2020e = (ImageView) view.findViewById(R.id.pick_lock_background_item_checked);
        }
    }

    public class C1082d {
        final /* synthetic */ C1083t f2031a;
        private View f2032b;
        private RecyclerView f2033c;
        private C1074b f2034d;
        private boolean f2035e = false;
        private byte[] f2036f = new byte[0];
        private Handler f2037g = new Handler();
        private BroadcastReceiver f2038h = new C10794(this);
        private FilenameFilter f2039i = new C10805(this);
        private FilenameFilter f2040j = new C10816(this);

        class C10794 extends BroadcastReceiver {
            final /* synthetic */ C1082d f2028a;

            C10794(C1082d c1082d) {
                this.f2028a = c1082d;
            }

            public void onReceive(Context context, Intent intent) {
                if (TextUtils.equals(intent.getAction(), "com.domobile.elock.ACTION_RELOAD_LOCK_BGIMAGES")) {
                    this.f2028a.m2298b(((C1074b) this.f2028a.f2033c.getAdapter()).m2288b());
                }
            }
        }

        class C10805 implements FilenameFilter {
            final /* synthetic */ C1082d f2029a;

            C10805(C1082d c1082d) {
                this.f2029a = c1082d;
            }

            public boolean accept(File file, String str) {
                return str.endsWith("_land.png");
            }
        }

        class C10816 implements FilenameFilter {
            final /* synthetic */ C1082d f2030a;

            C10816(C1082d c1082d) {
                this.f2030a = c1082d;
            }

            public boolean accept(File file, String str) {
                return str.endsWith("_port.png");
            }
        }

        public C1082d(final C1083t c1083t, Context context, boolean z) {
            this.f2031a = c1083t;
            this.f2035e = z;
            m2301a(c1083t.mActivity.getResources().getConfiguration());
            this.f2032b = c1083t.mActivity.getLayoutInflater().inflate(R.layout.pick_lock_background_fragment, null);
            this.f2033c = (RecyclerView) this.f2032b.findViewById(R.id.pick_lock_background_grid);
            this.f2033c.setLayoutManager(new GridLayoutManager(c1083t.mActivity, this.f2035e ? 2 : 3));
            this.f2033c.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ C1082d f2022b;

                public void onGlobalLayout() {
                    C1148d.m2515a(this.f2022b.f2033c.getViewTreeObserver(), (OnGlobalLayoutListener) this);
                    ((OverscrollRecyclerView) this.f2022b.f2033c).m3553a(this.f2022b.f2031a.b.m66r().getHeight(), this.f2022b.f2031a.b.m67s());
                }
            });
            m2298b(this.f2035e);
        }

        private void m2295a(final boolean z) {
            final String[] list = C1083t.m2305a(this.f2031a.mActivity, null).list(z ? this.f2039i : this.f2040j);
            this.f2037g.post(new Runnable(this) {
                final /* synthetic */ C1082d f2025c;

                public void run() {
                    this.f2025c.f2034d = new C1074b(this.f2025c.f2031a, list, z);
                    this.f2025c.f2033c.setAdapter(this.f2025c.f2034d);
                    this.f2025c.f2034d.notifyDataSetChanged();
                }
            });
        }

        private void m2298b(final boolean z) {
            new Thread(this) {
                final /* synthetic */ C1082d f2027b;

                public void run() {
                    synchronized (this.f2027b.f2036f) {
                        this.f2027b.m2295a(z);
                    }
                }
            }.start();
        }

        public View m2300a() {
            return this.f2032b;
        }

        public void m2301a(Configuration configuration) {
            int c = this.f2031a.f2047j;
            int d = this.f2031a.f2048k;
            if (configuration.orientation == 2) {
                this.f2031a.f2047j = Math.max(c, d);
                this.f2031a.f2048k = Math.min(c, d);
            } else {
                this.f2031a.f2047j = Math.min(c, d);
                this.f2031a.f2048k = Math.max(c, d);
            }
            if (this.f2034d != null) {
                this.f2034d.m2286a();
                this.f2034d.notifyDataSetChanged();
            }
        }

        public void m2302b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.domobile.elock.ACTION_RELOAD_LOCK_BGIMAGES");
            this.f2031a.mActivity.registerReceiver(this.f2038h, intentFilter);
        }

        public void m2303c() {
            C1148d.m2509a(this.f2031a.mActivity, this.f2038h);
        }
    }

    public static File m2305a(Context context, String str) {
        File dir = context.getDir("lock_bg_images", 0);
        if (TextUtils.isEmpty(str)) {
            return dir;
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = str.endsWith(".png") ? "" : ".png";
        return new File(dir, C1147a.m2480a(objArr));
    }

    public static boolean m2306a(Context context, Bitmap bitmap, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        try {
            Object[] objArr = new Object[3];
            objArr[0] = "custom_";
            objArr[1] = C1148d.m2526d();
            objArr[2] = z ? "_land" : "_port";
            OutputStream fileOutputStream3 = new FileOutputStream(C1083t.m2305a(context, C1147a.m2480a(objArr)));
            try {
                bitmap.compress(CompressFormat.JPEG, 60, fileOutputStream3);
                fileOutputStream3.flush();
                if (fileOutputStream3 == null) {
                    return true;
                }
                try {
                    fileOutputStream3.close();
                    return true;
                } catch (Exception e) {
                    return true;
                }
            } catch (Exception e2) {
                OutputStream outputStream = fileOutputStream3;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                OutputStream outputStream2 = fileOutputStream3;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(R.layout.pick_lock_background, null);
        this.f2041a = (ViewPager) findViewById(R.id.pick_lock_background_pages);
        this.f2042e = new C1072a();
        this.f2041a.setAdapter(this.f2042e);
        this.b.m65q().setVisibility(0);
        this.b.m65q().setViewPager(this.f2041a);
        this.f2041a.addOnPageChangeListener(this.b.m65q());
        this.f2041a.addOnPageChangeListener(this);
    }

    public boolean isShowOptionsMenu() {
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        if (i2 == -1) {
            if (i == 101 || i == 100) {
                this.f2045h = true;
                if (i != 101) {
                    z = false;
                }
                int min = Math.min(this.f2047j, this.f2048k);
                int max = Math.max(this.f2047j, this.f2048k);
                int i3 = z ? max : min;
                int i4 = z ? min : max;
                Uri data = intent.getData();
                Intent intent2 = new Intent(this.mActivity, CropImageActivity.class);
                intent2.setData(data);
                intent2.putExtra(Gallery.EXTRA_CROP, "true");
                intent2.putExtra("aspectX", i3);
                intent2.putExtra("aspectY", i4);
                intent2.putExtra("outputX", i3);
                intent2.putExtra("outputY", i4);
                startActivity(intent2);
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        for (C1082d c1082d : this.f2049l) {
            if (c1082d != null) {
                c1082d.m2301a(configuration);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b.m56b(R.string.unlock_background);
        this.f2043f = C1150y.m2602b(this.mActivity, "lock_bgimage_portrait");
        this.f2044g = C1150y.m2602b(this.mActivity, "lock_bgimage_landscape");
        Point a = C1148d.m2500a(this.mActivity.getWindowManager());
        this.f2047j = a.x;
        this.f2048k = a.y;
        this.b.m66r().post(new C10711(this));
        C1150y.m2605b(this.mActivity, (int) R.string.event_pick_lock_backgroud);
    }

    public void onCreateCustomOptionsMenus(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.pick_background_actionbar_menus, menu);
        super.onCreateCustomOptionsMenus(menu, menuInflater);
    }

    public void onDestroy() {
        for (C1082d c1082d : this.f2049l) {
            if (c1082d != null) {
                c1082d.m2303c();
            }
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_actionbar_number_color) {
            this.b.m80e();
            this.mActivity.startActivity(new Intent(this.mActivity, PickNumBoardColorActivity.class));
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onPageSelected(int i) {
        ViewCompat.animate(this.b.m67s()).translationY(0.0f).setDuration(300).start();
    }

    public void onResume() {
        super.onResume();
        this.b.m72x();
        if (this.f2045h) {
            this.f2045h = false;
            this.b.m80e();
        }
    }
}
