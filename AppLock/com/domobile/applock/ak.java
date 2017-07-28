package com.domobile.applock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.PointerIconCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.domobile.applock.C0386c.C0745a;
import com.domobile.applock.adapter.C0419f;
import com.domobile.applock.adapter.C0689h;
import com.domobile.applock.p003a.C0612c;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1288c;
import com.domobile.lockbean.Alarm;
import com.domobile.lockbean.Alarm.C1353b;
import com.domobile.lockbean.C1358a;
import com.domobile.lockbean.C1359b;
import com.domobile.lockbean.Scene;
import com.domobile.widget.MyLinearLayoutManager;
import com.domobile.widget.timepicker.C1432f;
import com.domobile.widget.timepicker.C1432f.C0732c;
import com.domobile.widget.timepicker.C1433g;
import com.domobile.widget.timepicker.RadialPickerLayout;
import java.util.ArrayList;

public class ak extends C0704e {
    boolean f933a = true;
    boolean f934e = false;
    private RecyclerView f935f;
    private C0737a f936g;
    private ArrayList<Alarm> f937h = new ArrayList();
    private ArrayList<TextView> f938i = new ArrayList();
    private ArrayList<Scene> f939j;
    private Alarm f940k;
    private int f941l = -1;
    private long f942m = 0;
    private Resources f943n;
    private Runnable f944o = new C07253(this);
    private BroadcastReceiver f945p = new C07275(this);
    private OnCheckedChangeListener f946q = new C07286(this);

    class C07221 extends Thread {
        final /* synthetic */ ak f904a;

        C07221(ak akVar) {
            this.f904a = akVar;
        }

        public void run() {
            if (this.f904a.f933a) {
                this.f904a.f933a = false;
                this.f904a.f939j = Scene.m3388a(this.f904a.mActivity);
                if (this.f904a.f934e) {
                    this.f904a.call(0);
                }
            }
        }
    }

    class C07232 extends C0612c {
        final /* synthetic */ ak f905a;

        C07232(ak akVar) {
            this.f905a = akVar;
        }

        public void onChanged() {
            View findViewById = this.f905a.findViewById(16908292);
            if (this.f905a.f936g.getItemCount() > 0) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
        }
    }

    class C07253 implements Runnable {
        final /* synthetic */ ak f908a;

        C07253(ak akVar) {
            this.f908a = akVar;
        }

        public void run() {
            final ArrayList arrayList = new ArrayList();
            Cursor a = C1358a.m3399a("_id ASC");
            if (a != null) {
                while (a.moveToNext()) {
                    arrayList.add(new Alarm(a));
                }
                a.close();
            }
            this.f908a.mHandler.post(new Runnable(this) {
                final /* synthetic */ C07253 f907b;

                public void run() {
                    this.f907b.f908a.f937h.clear();
                    this.f907b.f908a.f937h.addAll(arrayList);
                    this.f907b.f908a.f936g.notifyDataSetChanged();
                }
            });
        }
    }

    class C07264 implements Runnable {
        final /* synthetic */ ak f909a;

        C07264(ak akVar) {
            this.f909a = akVar;
        }

        public void run() {
            this.f909a.f935f.smoothScrollToPosition(this.f909a.f941l);
        }
    }

    class C07275 extends BroadcastReceiver {
        final /* synthetic */ ak f910a;

        C07275(ak akVar) {
            this.f910a = akVar;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (("com.domobile.elock.action.ACTION_SCENE_CHANGED".equals(action) || "com.domobile.elock.action.ACTION_ALARM_LOCK_CHANGED".equals(action)) && System.currentTimeMillis() - this.f910a.f942m > 100000) {
                new Thread(this.f910a.f944o).start();
            }
        }
    }

    class C07286 implements OnCheckedChangeListener {
        final /* synthetic */ ak f911a;

        C07286(ak akVar) {
            this.f911a = akVar;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.f911a.f941l >= 0 && this.f911a.f941l <= this.f911a.f937h.size() - 1) {
                Alarm alarm = (Alarm) this.f911a.f937h.get(this.f911a.f941l);
                Alarm alarm2 = new Alarm(alarm);
                alarm2.f2910e = this.f911a.m1016a((ViewGroup) compoundButton.getParent());
                this.f911a.f942m = System.currentTimeMillis();
                if (this.f911a.m1013a(alarm2) > 0) {
                    alarm.f2910e = alarm2.f2910e;
                } else {
                    this.f911a.f936g.notifyItemChanged(this.f911a.f941l);
                }
            }
        }
    }

    private class C0737a extends C0419f implements OnClickListener, OnCheckedChangeListener {
        final /* synthetic */ ak f929a;
        private Resources f930b;
        private Point f931c;
        private C1432f f932k;

        class C07342 implements Runnable {
            final /* synthetic */ C0737a f924a;

            C07342(C0737a c0737a) {
                this.f924a = c0737a;
            }

            public void run() {
                if (this.f924a.f929a.f941l >= 0) {
                    this.f924a.f929a.f935f.smoothScrollToPosition(this.f924a.f929a.f941l);
                }
            }
        }

        public C0737a(ak akVar) {
            this.f929a = akVar;
            this.f930b = akVar.mActivity.getResources();
            this.f931c = C1148d.m2500a(akVar.mActivity.getWindowManager());
        }

        private void m1006a(Alarm alarm) {
            int indexOf = this.f929a.f937h.indexOf(alarm);
            if (this.f929a.f941l == -1 || this.f929a.f941l != indexOf) {
                int c = this.f929a.f941l;
                this.f929a.f941l = indexOf;
                this.f929a.f936g.notifyItemChanged(c);
                this.f929a.f936g.notifyItemChanged(this.f929a.f941l);
            } else {
                this.f929a.f941l = -1;
                this.f929a.f936g.notifyItemChanged(indexOf);
            }
            if (this.f929a.f941l >= 0) {
                this.f929a.mHandler.postDelayed(new C07342(this), 350);
            }
        }

        private void m1007a(Alarm alarm, C0689h c0689h) {
            int color = ResourcesCompat.getColor(this.f929a.f943n, alarm.f2910e.m3371c() ? R.color.material_deep_teal_500 : R.color.line_dark, null);
            String[] split = alarm.f2910e.m3367a(this.f929a.mActivity, true).split(",");
            for (int childCount = c0689h.f766c.getChildCount() - 1; childCount > -1; childCount--) {
                this.f929a.f938i.add((TextView) c0689h.f766c.getChildAt(childCount));
            }
            c0689h.f766c.removeAllViews();
            for (CharSequence charSequence : split) {
                View a = !this.f929a.f938i.isEmpty() ? (TextView) this.f929a.f938i.remove(0) : ak.m1014a(this.f929a.mActivity);
                a.setTextColor(color);
                a.setText(charSequence);
                c0689h.f766c.addView(a);
            }
        }

        private void m1008b(final Alarm alarm) {
            C1288c c1288c = new C1288c(this.f929a.mActivity);
            c1288c.m3101a((int) R.string.delete).mo2528a(this.f929a.getString(R.string.are_you_sure_delete, alarm.m3373a(this.f929a.mActivity)));
            c1288c.m3102a(17039360, null);
            c1288c.m3114b(17039370, new OnClickListener(this) {
                final /* synthetic */ C0737a f928b;

                public void onClick(View view) {
                    C1148d.m2489A(this.f928b.f929a.mActivity, "com.domobile.applock.ACTION_ALARM_LOCATION_EDITED");
                    if (C1358a.m3395a(this.f928b.f929a.mActivity, alarm.f2906a) > 0) {
                        int indexOf = this.f928b.f929a.f937h.indexOf(alarm);
                        this.f928b.f929a.f937h.remove(alarm);
                        this.f928b.f929a.f941l = -1;
                        this.f928b.notifyItemRemoved(indexOf);
                        this.f928b.m165a(150);
                    }
                }
            }).m3117b(true).m3122d();
        }

        public C0689h m1009a(ViewGroup viewGroup, int i) {
            C0689h c0689h = new C0689h(LayoutInflater.from(this.f929a.mActivity).inflate(R.layout.timer_item, viewGroup, false));
            c0689h.f775l.setOnCheckedChangeListener(this);
            c0689h.f765b.setOnClickListener(this);
            c0689h.f767d.setOnClickListener(this);
            c0689h.itemView.setOnClickListener(this);
            c0689h.f764a.setOnClickListener(this);
            c0689h.f770g.setOnClickListener(this);
            return c0689h;
        }

        public Alarm m1010a(int i) {
            return (Alarm) this.f929a.f937h.get(i);
        }

        public int getItemCount() {
            return this.f929a.f937h.size();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            int i2 = 0;
            C0689h c0689h = (C0689h) viewHolder;
            c0689h.f776m.setVisibility((i == getItemCount() + -1 ? 1 : 0) != 0 ? 8 : 0);
            if (this.f929a.f941l == i) {
                c0689h.f766c.setVisibility(8);
                c0689h.f774k.setVisibility(0);
                c0689h.f764a.setVisibility(0);
                c0689h.f770g.setVisibility(0);
                c0689h.f767d.setVisibility(0);
                c0689h.f768e.setImageResource(R.drawable.ic_expand_up);
            } else {
                c0689h.f766c.setVisibility(0);
                c0689h.f774k.setVisibility(8);
                c0689h.f764a.setVisibility(8);
                c0689h.f770g.setVisibility(8);
                c0689h.f767d.setVisibility(8);
                c0689h.f768e.setImageResource(R.drawable.ic_expand_down);
            }
            Alarm a = m1010a(i);
            m1007a(a, c0689h);
            c0689h.f764a.setText(a.f2912g);
            c0689h.f765b.setText(C1147a.m2480a(C1150y.m2573a(a.f2908c, 2), ":", C1150y.m2573a(a.f2909d, 2)));
            c0689h.f764a.setTag(a);
            c0689h.f767d.setTag(a);
            c0689h.f765b.setTag(a);
            c0689h.f770g.setTag(a);
            c0689h.itemView.setTag(a);
            c0689h.f770g.setText(R.string.protect_startup_mode);
            c0689h.f770g.setText(C1359b.m3420b(this.f929a.mActivity, a.f2913h));
            boolean[] b = a.f2910e.m3370b();
            int childCount = c0689h.f773j.getChildCount();
            while (i2 < childCount) {
                boolean z = b[i2 == 0 ? 6 : i2 - 1];
                CheckBox checkBox = (CheckBox) c0689h.f773j.getChildAt(i2);
                checkBox.setOnCheckedChangeListener(null);
                checkBox.setText(C1433g.m3657a(this.f929a.mActivity)[i2]);
                checkBox.setChecked(z);
                checkBox.setOnCheckedChangeListener(this.f929a.f946q);
                i2++;
            }
            c0689h.f775l.setOnCheckedChangeListener(null);
            c0689h.f775l.setChecked(a.f2907b);
            c0689h.f775l.setTag(a);
            c0689h.f775l.setOnCheckedChangeListener(this);
        }

        public void onCheckedChanged(final CompoundButton compoundButton, boolean z) {
            C1288c a_ = this.f929a.a_(0);
            if (a_ != null) {
                a_.m3107a(new OnDismissListener(this) {
                    final /* synthetic */ C0737a f926b;

                    public void onDismiss() {
                        compoundButton.setOnCheckedChangeListener(null);
                        compoundButton.setChecked(false);
                        compoundButton.setOnCheckedChangeListener(this.f926b);
                    }
                });
            } else if (compoundButton.getTag() != null) {
                Alarm alarm = (Alarm) compoundButton.getTag();
                C1358a.m3403a(this.f929a.mActivity, alarm.f2906a, z);
                alarm.f2907b = z;
                if (z) {
                    C1147a.m2487w(this.f929a.mActivity, this.f929a.mActivity.getString(R.string.startup_success, new Object[]{alarm.m3373a(this.f929a.mActivity)}));
                }
            }
        }

        public void onClick(View view) {
            if (view.getTag() == null) {
                return;
            }
            if (view.getId() == R.id.timer_item_delete) {
                m1008b((Alarm) view.getTag());
            } else if (view.getId() == R.id.timer_item_name_editor) {
                this.f929a.m1025c((Alarm) view.getTag());
            } else if (view.getId() == R.id.timer_item_action) {
                this.f929a.m1022b((Alarm) view.getTag());
            } else if (view.getId() == R.id.timer_item_time) {
                final Alarm alarm = (Alarm) view.getTag();
                this.f932k = C1432f.m3629a(new C0732c(this) {
                    final /* synthetic */ C0737a f923b;

                    public void mo2408a(RadialPickerLayout radialPickerLayout, int i, int i2) {
                        Alarm alarm = new Alarm(alarm);
                        alarm.f2908c = i;
                        alarm.f2909d = i2;
                        if (this.f923b.f929a.m1013a(alarm) > 0) {
                            alarm.f2908c = i;
                            alarm.f2909d = i2;
                            this.f923b.f929a.f936g.notifyItemChanged(this.f923b.f929a.f937h.indexOf(alarm));
                            this.f923b.f932k.dismissAllowingStateLoss();
                        }
                    }
                }, alarm.f2908c, alarm.f2909d, true);
                this.f932k.show(this.f929a.mActivity.getSupportFragmentManager(), "TimerPicker");
            } else if (view.getId() == -1) {
                m1006a((Alarm) view.getTag());
            }
        }

        public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return m1009a(viewGroup, i);
        }
    }

    private long m1013a(Alarm alarm) {
        C1148d.m2489A(this.mActivity, "com.domobile.applock.ACTION_ALARM_LOCATION_EDITED");
        if (alarm.f2906a != -1) {
            return C1358a.m3406b(this.mActivity, alarm);
        }
        alarm.f2907b = true;
        long a = C1358a.m3396a(this.mActivity, alarm);
        if (a == -1) {
            return a;
        }
        C1147a.m2487w(this.mActivity, this.mActivity.getString(R.string.startup_success, new Object[]{alarm.m3373a(this.mActivity)}));
        return a;
    }

    public static TextView m1014a(Context context) {
        TextView textView = new TextView(context);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = context.getResources().getDimensionPixelOffset(R.dimen.PaddingSizeSmaller);
        textView.setBackgroundResource(R.drawable.timer_weekday_background);
        textView.setMinimumWidth(C1148d.m2498a(context, 40.0f));
        textView.setTextSize(2, 13.0f);
        textView.setGravity(17);
        textView.setSingleLine(true);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private C1353b m1016a(ViewGroup viewGroup) {
        C1353b c1353b = new C1353b(0);
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (i < childCount) {
            c1353b.m3368a(i == 0 ? 6 : i - 1, ((CheckBox) viewGroup.getChildAt(i)).isChecked());
            i++;
        }
        return c1353b;
    }

    private void m1022b(final Alarm alarm) {
        final String[] a = C1150y.m2595a(this.mActivity, this.f939j);
        final C1288c c1288c = new C1288c(this.mActivity);
        c1288c.m3109a(this.mActivity.getString(R.string.startup, new Object[]{this.mActivity.getString(R.string.scenes_mode)}));
        c1288c.m3102a(17039360, null);
        c1288c.m3106a(new C0745a(this.mActivity, a), -1, new OnItemClickListener(this) {
            final /* synthetic */ ak f915d;

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == a.length - 1) {
                    c1288c.m3125e();
                    this.f915d.f940k = alarm;
                    this.f915d.m109a(this.f915d, (int) PointerIconCompat.TYPE_CONTEXT_MENU);
                    return;
                }
                Scene scene = (Scene) this.f915d.f939j.get(i);
                Alarm alarm = new Alarm(alarm);
                alarm.f2913h = C1359b.m3414a(scene);
                if (this.f915d.m1013a(alarm) > 0) {
                    c1288c.m3125e();
                    alarm.f2913h = alarm.f2913h;
                    this.f915d.f936g.notifyItemChanged(this.f915d.f937h.indexOf(alarm));
                }
            }
        }).m3117b(true).m3122d();
    }

    private void m1025c(final Alarm alarm) {
        View inflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_rename_profile, null);
        final EditText editText = (EditText) inflate.findViewById(R.id.dialog_rename_profine_text);
        editText.setText(alarm.f2912g);
        final C1288c c1288c = new C1288c(this.mActivity);
        c1288c.m3101a((int) R.string.trigger_name_label).m3105a(inflate);
        c1288c.m3114b(17039370, null);
        c1288c.m3102a(17039360, null);
        c1288c.m3104a(new OnClickListener(this) {
            final /* synthetic */ ak f919d;

            public void onClick(View view) {
                if (TextUtils.equals(alarm.f2912g, editText.getText())) {
                    c1288c.m3125e();
                    return;
                }
                Alarm alarm = new Alarm(alarm);
                alarm.f2912g = editText.getText().toString();
                long c = this.f919d.m1013a(alarm);
                if (c > 0) {
                    c1288c.m3125e();
                    alarm.f2912g = alarm.f2912g;
                    if (alarm.f2906a <= 0) {
                        alarm.f2906a = (int) c;
                        this.f919d.f937h.add(alarm);
                        this.f919d.f941l = this.f919d.f937h.size() - 1;
                        this.f919d.f936g.notifyItemRangeChanged(0, this.f919d.f937h.size() - 1);
                        this.f919d.f936g.notifyItemInserted(this.f919d.f937h.size() - 1);
                        return;
                    }
                    this.f919d.f936g.notifyItemChanged(this.f919d.f937h.indexOf(alarm));
                }
            }
        }, false).m3117b(true).m3122d();
        editText.requestFocus();
        this.mHandler.postDelayed(new Runnable(this) {
            final /* synthetic */ ak f921b;

            public void run() {
                C1148d.m2511a(this.f921b.mActivity, editText);
            }
        }, 500);
    }

    public boolean mo2400b() {
        return true;
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b.m56b(R.string.timer_lock);
        this.rootView = layoutInflater.inflate(R.layout.timer_activity, null);
        findViewById(R.id.timer_add).setOnClickListener(this);
        this.f935f = (RecyclerView) findViewById(R.id.timer_list);
        this.f935f.setLayoutManager(new MyLinearLayoutManager(this.mActivity));
        this.f936g = new C0737a(this);
        this.f935f.setAdapter(this.f936g);
        this.f936g.registerAdapterDataObserver(new C07232(this));
        new Thread(this.f944o).start();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1000 && i2 == -1) {
            new Thread(this.f944o).start();
        } else if (i != PointerIconCompat.TYPE_CONTEXT_MENU) {
        } else {
            if (i2 == -1) {
                this.f933a = true;
                this.f934e = true;
                return;
            }
            call(0);
        }
    }

    public void onClick(View view) {
        if (view.getId() != R.id.timer_add) {
            super.onClick(view);
        } else if (a_(0) == null) {
            Alarm alarm = new Alarm();
            alarm.f2907b = true;
            long a = m1013a(alarm);
            if (a > 0) {
                alarm.f2906a = (int) a;
                this.f937h.add(alarm);
                this.f941l = this.f937h.size() - 1;
                this.f936g.notifyItemRangeChanged(0, this.f941l);
                this.f936g.notifyItemInserted(this.f941l);
                this.mHandler.postDelayed(new C07264(this), 500);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f943n = this.mActivity.getResources();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.domobile.elock.action.ACTION_SCENE_CHANGED");
        intentFilter.addAction("com.domobile.elock.action.ACTION_ALARM_LOCK_CHANGED");
        this.mActivity.registerReceiver(this.f945p, intentFilter);
        C1150y.m2605b(this.mActivity, (int) R.string.event_timer);
    }

    public void onDestroy() {
        super.onDestroy();
        C1148d.m2509a(this.mActivity, this.f945p);
    }

    public void onResume() {
        super.onResume();
        new C07221(this).start();
    }

    public void ui(int i, Message message) {
        if (i == 0 && this.f940k != null) {
            m1022b(this.f940k);
        }
    }
}
