package com.domobile.applock.fake;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.domobile.applock.AgentActivity;
import com.domobile.applock.C0400d;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.frame.p000a.C1148d;
import com.domobile.libs_ads.C1342b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class FakePagePickerFragment extends C0400d {
    private RecyclerView f1379a;
    private View f1380e;
    private C0912b f1381f;
    private String f1382g;

    class C09081 extends Thread {
        final /* synthetic */ FakePagePickerFragment f1367a;

        C09081(FakePagePickerFragment fakePagePickerFragment) {
            this.f1367a = fakePagePickerFragment;
        }

        public void run() {
            this.f1367a.m1618c();
        }
    }

    public static class FakeBean implements Parcelable {
        public static final Creator<FakeBean> CREATOR = new C09101();
        public static final String FC_TYPE = "com.domobile.applock.fake.FCFakeViewInitialer";
        public String f1370a;
        public String f1371b;
        public String f1372c;
        private String f1373d;

        static class C09101 implements Creator<FakeBean> {
            C09101() {
            }

            public FakeBean m1605a(Parcel parcel) {
                return new FakeBean(parcel);
            }

            public FakeBean[] m1606a(int i) {
                return new FakeBean[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1605a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1606a(i);
            }
        }

        public FakeBean(Parcel parcel) {
            this.f1373d = parcel.readString();
            this.f1370a = parcel.readString();
            this.f1371b = parcel.readString();
            this.f1372c = parcel.readString();
        }

        public FakeBean(JSONObject jSONObject) {
            this.f1373d = jSONObject.optString("name");
            this.f1370a = jSONObject.optString("pic");
            this.f1371b = jSONObject.optString("type");
            this.f1372c = jSONObject.optString("summary");
        }

        public String m1608a(Context context) {
            return context.getString(context.getResources().getIdentifier(this.f1373d, null, context.getPackageName()));
        }

        public String m1609b(Context context) {
            return context.getString(context.getResources().getIdentifier(this.f1373d, null, context.getPackageName()));
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f1373d);
            parcel.writeString(this.f1370a);
            parcel.writeString(this.f1371b);
            parcel.writeString(this.f1372c);
        }
    }

    private class C0911a extends ViewHolder {
        final /* synthetic */ FakePagePickerFragment f1374a;

        public C0911a(FakePagePickerFragment fakePagePickerFragment, View view) {
            this.f1374a = fakePagePickerFragment;
            super(view);
        }
    }

    private class C0912b extends Adapter<C0911a> implements OnClickListener {
        final /* synthetic */ FakePagePickerFragment f1375a;
        private Resources f1376b;
        private Activity f1377c;
        private ArrayList<FakeBean> f1378d = new ArrayList();

        public C0912b(FakePagePickerFragment fakePagePickerFragment, Activity activity, ArrayList<FakeBean> arrayList) {
            this.f1375a = fakePagePickerFragment;
            this.f1377c = activity;
            if (arrayList != null) {
                this.f1378d.addAll(arrayList);
            }
            this.f1376b = this.f1377c.getResources();
        }

        public FakeBean m1610a(int i) {
            return (FakeBean) this.f1378d.get(i);
        }

        public C0911a m1611a(ViewGroup viewGroup, int i) {
            return new C0911a(this.f1375a, this.f1377c.getLayoutInflater().inflate(R.layout.theme_picker_item, viewGroup, false));
        }

        public void m1612a(C0911a c0911a, int i) {
            View view = c0911a.itemView;
            FakeBean a = m1610a(i);
            String packageName = this.f1377c.getPackageName();
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.theme_picker_item_imgcontainer);
            ImageView imageView = (ImageView) view.findViewById(R.id.theme_picker_item_image);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.theme_picker_item_checked);
            TextView textView = (TextView) view.findViewById(R.id.theme_picker_item_name);
            frameLayout.setTag(a);
            frameLayout.setOnClickListener(this);
            try {
                textView.setText(this.f1377c.getString(this.f1376b.getIdentifier(a.f1373d, null, packageName)));
            } catch (Exception e) {
                textView.setText("");
            }
            imageView2.setVisibility(8);
            if ((TextUtils.isEmpty(this.f1375a.f1382g) && TextUtils.isEmpty(a.f1371b)) || TextUtils.equals(this.f1375a.f1382g, a.f1371b)) {
                imageView2.setVisibility(0);
            }
            if (view.getTag() != a) {
                view.setTag(a);
                imageView.setImageDrawable(null);
                C1148d.m2514a((View) imageView, null);
                imageView.setTag(Uri.parse(a.f1370a));
                try {
                    C1148d.m2514a((View) imageView, C1148d.m2502a(this.f1376b, this.f1376b.getIdentifier(a.f1370a, null, packageName)));
                } catch (Exception e2) {
                    imageView.setBackgroundResource(R.color.default_fakeview_forground_color);
                }
            }
        }

        public int getItemCount() {
            return this.f1378d.size();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
            m1612a((C0911a) viewHolder, i);
        }

        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof FakeBean)) {
                this.f1375a.b.m80e();
                Intent a = AgentActivity.m570a(this.f1377c, 296);
                a.putExtra("com.domobile.elock.EXTRA_PARCELABLE", this.f1378d);
                a.putExtra("com.domobile.elock.EXTRA_POSITION", this.f1378d.indexOf(tag));
                this.f1377c.startActivityForResult(a, 4101);
            }
        }

        public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return m1611a(viewGroup, i);
        }
    }

    public void m1617b() {
        new C09081(this).start();
    }

    public void m1618c() {
        final ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(C1148d.m2494F(this.mActivity, "fake_pages.json"));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(new FakeBean(jSONArray.getJSONObject(i)));
            }
        } catch (Exception e) {
        }
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ FakePagePickerFragment f1369b;

            public void run() {
                this.f1369b.f1381f = new C0912b(this.f1369b, this.f1369b.mActivity, arrayList);
                this.f1369b.f1379a.setAdapter(this.f1369b.f1381f);
            }
        });
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b.m56b(R.string.fake_page_picker);
        this.rootView = layoutInflater.inflate(R.layout.pick_lock_background_fragment, null);
        this.f1379a = (RecyclerView) findViewById(R.id.pick_lock_background_grid);
        this.f1379a.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        m1617b();
        C1150y.m2566a(this.mActivity);
        if (!C1150y.m2598b(this.mActivity).f2224i) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1150y.m2605b(this.mActivity, (int) R.string.event_fake_page_picker);
        this.f1382g = C1150y.m2629h(this.mActivity);
    }

    public void onDestroy() {
        C1342b.m3328a(this.f1380e);
        this.f1380e = null;
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.f1381f != null) {
            this.f1382g = C1150y.m2629h(this.mActivity);
            this.f1381f.notifyDataSetChanged();
        }
    }

    public void ui(int i, Message message) {
    }
}
