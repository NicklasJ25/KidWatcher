package com.domobile.applock.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.camera.C0397c;
import com.android.camera.C0487k;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.frame.http.image.CacheImageView;
import com.domobile.frame.p000a.C1257b.C0421b;
import com.domobile.frame.p000a.C1257b.C0422e;
import java.util.ArrayList;

public class C0670a extends Adapter<C0669a> implements OnClickListener, C0421b, C0422e {
    private ArrayList<C0397c> f705a = new ArrayList();
    private LayoutInflater f706b;
    private Context f707c;
    private Point f708d;

    protected class C0669a extends ViewHolder {
        public TextView f701a;
        public TextView f702b;
        public CacheImageView f703c;
        final /* synthetic */ C0670a f704d;

        public C0669a(C0670a c0670a, View view) {
            this.f704d = c0670a;
            super(view);
            this.f703c = (CacheImageView) view.findViewById(R.id.thumbnail);
            this.f702b = (TextView) view.findViewById(R.id.quantity);
            this.f701a = (TextView) view.findViewById(R.id.title);
        }
    }

    public C0670a(Context context, ArrayList<C0397c> arrayList) {
        this.f707c = context.getApplicationContext();
        this.f706b = LayoutInflater.from(context);
        if (arrayList != null) {
            this.f705a.addAll(arrayList);
        }
        this.f708d = C1150y.m2548M(this.f707c);
    }

    public static int m867a(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.PaddingSizeMiddle);
        return displayMetrics.widthPixels / (resources.getDimensionPixelSize(R.dimen.gallery_picker_thumb_width) + dimensionPixelOffset);
    }

    public static Bitmap m868a(Context context, int i, int i2, C0397c c0397c) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.gallery_picker_thumb_width);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.gallery_picker_thumb_height);
        int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.gallery_picker_thumb_translation_distance);
        Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize2, Config.ARGB_8888);
        if (c0397c == null) {
            return createBitmap;
        }
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        canvas.drawColor(0);
        Paint paint = new Paint(7);
        Resources resources = context.getResources();
        Drawable drawable = ResourcesCompat.getDrawable(resources, R.drawable.vault_image_border, null);
        Rect rect = new Rect();
        drawable.getPadding(rect);
        int b = c0397c.mo2049b();
        int i3 = b < 3 ? b - 1 : 2;
        int i4 = dimensionPixelSize - (((2 - i3) * dimensionPixelSize3) / 2);
        for (int i5 = i3; i5 > -1; i5--) {
            Bitmap a = c0397c.mo2047a(i5);
            dimensionPixelSize = c0397c.mo2050b(i5);
            if (a != null) {
                if (dimensionPixelSize != 0) {
                    a = C0487k.m404a(a, dimensionPixelSize);
                }
                int i6 = (i5 * 2) * dimensionPixelSize3;
                a = C0487k.m405a(matrix, a, i - i6, i2 - i6, true, true);
                if (i5 == 0 && c0397c.mo2054e()) {
                    Canvas canvas2 = new Canvas(a);
                    Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.vault_video_album);
                    canvas2.drawBitmap(decodeResource, (float) ((a.getWidth() - decodeResource.getWidth()) - (dimensionPixelSize3 / 2)), (float) ((a.getHeight() - decodeResource.getHeight()) - (dimensionPixelSize3 / 2)), paint);
                    decodeResource.recycle();
                }
            }
            if (!(a == null || a.isRecycled())) {
                Bitmap createBitmap2 = Bitmap.createBitmap(a.getWidth(), a.getHeight(), Config.ARGB_8888);
                Canvas canvas3 = new Canvas(createBitmap2);
                if (a != null) {
                    paint.setAlpha((int) (255.0d * (1.0d - (((double) i5) * 0.2d))));
                    drawable.setBounds(0, 0, a.getWidth(), a.getHeight());
                    drawable.draw(canvas3);
                    canvas3.drawBitmap(a, new Rect(0, 0, a.getWidth(), a.getHeight()), new Rect(rect.left, rect.top, a.getWidth() - rect.right, a.getHeight() - rect.bottom), paint);
                    i6 = (i3 - i5) * dimensionPixelSize3;
                    int width = createBitmap2.getWidth();
                    int height = createBitmap2.getHeight();
                    i6 = (i4 - width) - i6;
                    int i7 = i5 * dimensionPixelSize3;
                    canvas.drawBitmap(createBitmap2, new Rect(0, 0, width, height), new Rect(i6, i7, width + i6, height + i7), paint);
                    createBitmap2.recycle();
                }
            }
            if (a != null) {
                a.recycle();
            }
        }
        return createBitmap;
    }

    public BitmapDrawable mo2069a(Object obj) {
        if (obj == null || !(obj instanceof C0397c)) {
            return null;
        }
        return new BitmapDrawable(this.f707c.getResources(), C0670a.m868a(this.f707c, this.f708d.x, this.f708d.y, (C0397c) obj));
    }

    public C0669a m870a(ViewGroup viewGroup, int i) {
        C0669a c0669a = new C0669a(this, this.f706b.inflate(R.layout.gallery_picker_item, viewGroup, false));
        c0669a.itemView.setOnClickListener(this);
        c0669a.f703c.m3044a((C0421b) this).m3045a((C0422e) this).m3043a(ResourcesCompat.getDrawable(c0669a.f703c.getResources(), R.drawable.vault_placeholder, null));
        return c0669a;
    }

    public ArrayList<C0397c> m871a() {
        return this.f705a;
    }

    public void m872a(C0397c c0397c) {
        this.f705a.add(c0397c);
        notifyItemInserted(getItemCount() - 1);
    }

    public void m873a(C0669a c0669a, int i) {
        C0397c c0397c = (C0397c) this.f705a.get(i);
        c0669a.f702b.setVisibility(c0397c.mo2053d() > 1 ? 0 : 8);
        c0669a.f702b.setText(String.valueOf(c0397c.mo2053d()));
        c0669a.f701a.setText(c0397c.mo2051c());
        c0669a.f701a.requestLayout();
        c0669a.itemView.setTag(c0397c);
        c0669a.f703c.setImageResource(R.drawable.transparent);
        c0669a.f703c.setImage(c0397c);
    }

    public void m874a(ArrayList<C0397c> arrayList) {
        this.f705a.clear();
        if (arrayList != null) {
            this.f705a.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public boolean mo2070a(CacheImageView cacheImageView, BitmapDrawable bitmapDrawable) {
        if (bitmapDrawable != null) {
            cacheImageView.setImageDrawable(C1150y.m2565a(bitmapDrawable, null, Color.parseColor("#44000000")));
        }
        return true;
    }

    public int getItemCount() {
        return this.f705a.size();
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        m873a((C0669a) viewHolder, i);
    }

    public void onClick(View view) {
        if (view.getTag() != null) {
            ((C0397c) view.getTag()).mo2048a();
        }
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m870a(viewGroup, i);
    }
}
