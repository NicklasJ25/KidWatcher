package com.domobile.applock.chamber.p008a;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.domobile.applock.R;
import com.domobile.applock.chamber.model.FileInfo;
import com.domobile.applock.chamber.p009c.C0795c;
import com.domobile.applock.chamber.p009c.C0795c.C0769b;
import com.domobile.applock.chamber.p010b.C0781d;
import com.domobile.applock.chamber.view.DownloadProgressView;
import com.domobile.applock.p003a.C0614e;
import com.domobile.frame.http.image.CacheImageView;
import java.io.File;
import java.util.ArrayList;

public class C0770c extends Adapter<ViewHolder> implements C0769b {
    private ArrayList<FileInfo> f1010a = new ArrayList();
    private ArrayList<FileInfo> f1011b = new ArrayList();
    private boolean f1012c = false;
    private RecyclerView f1013d;
    private C0766a f1014e;
    private C0767b f1015f;

    public interface C0766a {
        void mo2432a(View view, int i);

        void mo2433b(View view, int i);
    }

    public interface C0767b {
        void b_();
    }

    private class C0768c extends ViewHolder implements OnClickListener, OnLongClickListener {
        CacheImageView f1001a;
        ImageView f1002b;
        TextView f1003c;
        TextView f1004d;
        DownloadProgressView f1005e;
        View f1006f;
        ImageView f1007g;
        ObjectAnimator f1008h;
        final /* synthetic */ C0770c f1009i;

        C0768c(C0770c c0770c, View view) {
            this.f1009i = c0770c;
            super(view);
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            this.f1001a = (CacheImageView) view.findViewById(R.id.imvIcon);
            this.f1003c = (TextView) view.findViewById(R.id.txvName);
            this.f1004d = (TextView) view.findViewById(R.id.txvSize);
            this.f1002b = (ImageView) view.findViewById(R.id.imvState);
            this.f1005e = (DownloadProgressView) view.findViewById(R.id.progressView);
            this.f1006f = view.findViewById(R.id.vgProgress);
            this.f1007g = (ImageView) view.findViewById(R.id.imvProgress);
            this.f1006f.setOnClickListener(this);
        }

        public void m1134a() {
            FileInfo fileInfo = (FileInfo) this.f1009i.f1010a.get(getAdapterPosition());
            if (fileInfo.m1515b() == 10) {
                this.f1001a.setImageResource(R.drawable.icon_file_photo);
            } else if (fileInfo.m1515b() == 11) {
                this.f1001a.setImageResource(R.drawable.icon_file_vedio);
            } else if (fileInfo.m1515b() == 12) {
                this.f1001a.setImageResource(R.drawable.icon_file_audio);
            } else if (fileInfo.m1515b() == 13) {
                this.f1001a.setImageResource(R.drawable.icon_file_app);
            } else {
                this.f1001a.setImageResource(R.drawable.icon_file_common);
            }
            this.f1005e.setStatus(fileInfo.f1293g);
            if (fileInfo.f1291e > 0 || fileInfo.f1293g != 1) {
                this.f1005e.setVisibility(0);
                this.f1007g.setVisibility(8);
                m1137d();
            } else {
                this.f1007g.setVisibility(0);
                this.f1005e.setVisibility(4);
                m1136c();
            }
            this.f1003c.setText(fileInfo.f1288b);
            if (fileInfo.f1291e <= 0) {
                this.f1004d.setVisibility(4);
            } else {
                this.f1004d.setVisibility(0);
                this.f1004d.setText(C0614e.m702a(fileInfo.f1291e));
            }
            if (this.f1009i.f1012c) {
                this.f1002b.setVisibility(0);
                this.f1002b.setSelected(this.f1009i.f1011b.contains(fileInfo));
                return;
            }
            this.f1002b.setVisibility(8);
        }

        public void m1135b() {
            FileInfo fileInfo = (FileInfo) this.f1009i.f1010a.get(getAdapterPosition());
            this.f1005e.setStatus(fileInfo.f1293g);
            if (fileInfo.f1293g == 1) {
                this.f1005e.setProgress(fileInfo.m1514a());
            }
            if (fileInfo.f1293g == 2 || fileInfo.f1293g == 0) {
                this.f1006f.setEnabled(false);
            } else {
                this.f1006f.setEnabled(true);
            }
            if (fileInfo.f1291e <= 0) {
                this.f1004d.setVisibility(4);
            } else {
                this.f1004d.setVisibility(0);
                this.f1004d.setText(C0614e.m702a(fileInfo.f1291e));
            }
            if (fileInfo.f1291e > 0 || fileInfo.f1293g != 1) {
                this.f1005e.setVisibility(0);
                this.f1007g.setVisibility(8);
                m1137d();
                return;
            }
            this.f1007g.setVisibility(0);
            this.f1005e.setVisibility(4);
            m1136c();
        }

        public void m1136c() {
            if (this.f1008h == null) {
                this.f1008h = ObjectAnimator.ofFloat(this.f1007g, "rotation", new float[]{0.0f, 360.0f});
                this.f1008h.setInterpolator(new LinearInterpolator());
                this.f1008h.setRepeatMode(1);
                this.f1008h.setRepeatCount(-1);
                this.f1008h.setDuration(1000);
            }
            if (!this.f1008h.isRunning()) {
                this.f1008h.start();
            }
        }

        public void m1137d() {
            if (this.f1008h != null) {
                this.f1008h.cancel();
            }
        }

        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition != -1) {
                FileInfo fileInfo = (FileInfo) this.f1009i.f1010a.get(adapterPosition);
                if (view == this.f1006f) {
                    if (fileInfo.f1293g == 1) {
                        C0795c.m1241a().m1245a(fileInfo.f1287a);
                        fileInfo.f1293g = 3;
                        m1135b();
                        C0781d.m1198a(fileInfo.f1287a, fileInfo.f1293g);
                    } else if (fileInfo.f1293g == 4 || fileInfo.f1293g == 3) {
                        C0795c.m1241a().m1246a(fileInfo);
                        fileInfo.f1293g = 0;
                        m1135b();
                        C0781d.m1198a(fileInfo.f1287a, fileInfo.f1293g);
                    }
                } else if (this.f1009i.m1156c()) {
                    if (this.f1009i.f1011b.contains(fileInfo)) {
                        this.f1009i.f1011b.remove(fileInfo);
                        this.f1002b.setSelected(false);
                    } else {
                        this.f1009i.f1011b.add(fileInfo);
                        this.f1002b.setSelected(true);
                    }
                    if (this.f1009i.f1015f != null) {
                        this.f1009i.f1015f.b_();
                    }
                } else if (this.f1009i.f1014e != null) {
                    this.f1009i.f1014e.mo2432a(view, adapterPosition);
                }
            }
        }

        public boolean onLongClick(View view) {
            if (!(this.f1009i.m1156c() || this.f1009i.f1014e == null)) {
                this.f1009i.f1014e.mo2433b(view, getAdapterPosition());
            }
            return false;
        }
    }

    public C0770c() {
        C0795c.m1241a().m1244a((C0769b) this);
    }

    public void m1145a() {
        if (m1157d()) {
            this.f1011b.clear();
        } else {
            this.f1011b.clear();
            this.f1011b.addAll(this.f1010a);
        }
        notifyDataSetChanged();
        if (this.f1015f != null) {
            this.f1015f.b_();
        }
    }

    public void m1146a(int i) {
        if (i != -1) {
            this.f1010a.remove(i);
            notifyItemRemoved(i);
            notifyItemRangeChanged(i, getItemCount());
        }
    }

    public void m1147a(C0766a c0766a) {
        this.f1014e = c0766a;
    }

    public void m1148a(C0767b c0767b) {
        this.f1015f = c0767b;
    }

    public void m1149a(FileInfo fileInfo) {
        m1146a(this.f1010a.indexOf(fileInfo));
    }

    public void mo2421a(String str, int i) {
        FileInfo fileInfo;
        int i2;
        FileInfo fileInfo2 = null;
        for (int i3 = 0; i3 < this.f1010a.size(); i3++) {
            fileInfo2 = (FileInfo) this.f1010a.get(i3);
            if (fileInfo2.f1287a.equals(str)) {
                fileInfo = fileInfo2;
                i2 = i3;
                break;
            }
        }
        i2 = -1;
        fileInfo = fileInfo2;
        if (fileInfo != null) {
            fileInfo.f1293g = i;
            if (i == 2) {
                File file = new File(fileInfo.f1289c);
                fileInfo.f1291e = file.exists() ? file.length() : 0;
            }
            C0768c c0768c = (C0768c) this.f1013d.findViewHolderForAdapterPosition(i2);
            if (c0768c != null) {
                c0768c.m1135b();
            }
        }
    }

    public void mo2422a(String str, long j, long j2) {
        FileInfo fileInfo = null;
        int i = 0;
        while (i < this.f1010a.size()) {
            fileInfo = (FileInfo) this.f1010a.get(i);
            if (fileInfo.f1287a.equals(str)) {
                break;
            }
            i++;
        }
        i = -1;
        if (fileInfo != null) {
            fileInfo.f1293g = 1;
            fileInfo.f1294h = j;
            fileInfo.f1295i = j2;
            C0768c c0768c = (C0768c) this.f1013d.findViewHolderForAdapterPosition(i);
            if (c0768c != null) {
                c0768c.m1135b();
            }
        }
    }

    public void m1152a(ArrayList<FileInfo> arrayList) {
        this.f1010a = arrayList;
        notifyDataSetChanged();
    }

    public void m1153a(boolean z) {
        this.f1012c = z;
        if (!this.f1012c) {
            this.f1011b.clear();
        }
        notifyDataSetChanged();
    }

    public FileInfo m1154b(int i) {
        return (FileInfo) this.f1010a.get(i);
    }

    public boolean m1155b() {
        m1153a(!this.f1012c);
        return this.f1012c;
    }

    public boolean m1156c() {
        return this.f1012c;
    }

    public boolean m1157d() {
        return this.f1010a.size() == this.f1011b.size();
    }

    public ArrayList<FileInfo> m1158e() {
        return this.f1011b;
    }

    public int getItemCount() {
        return this.f1010a.size();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f1013d = recyclerView;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C0768c c0768c = (C0768c) viewHolder;
        c0768c.m1134a();
        c0768c.m1135b();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0768c(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_download_list_item, viewGroup, false));
    }
}
