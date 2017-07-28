package com.android.camera;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.VideoView;
import com.domobile.applock.R;
import com.domobile.frame.C0415f;
import java.util.Formatter;
import java.util.Locale;

public abstract class C0473h implements OnCompletionListener, OnErrorListener, OnClickListener, OnSeekBarChangeListener {
    private VideoView f259a;
    private View f260b;
    private View f261c;
    private TextView f262d;
    private TextView f263e;
    private ImageView f264f;
    private ImageView f265g;
    private ImageView f266h;
    private ImageView f267i;
    private ImageView f268j;
    private SeekBar f269k;
    private Uri f270l;
    private int f271m = -1;
    private boolean f272n;
    private StringBuilder f273o;
    private Formatter f274p;
    private final Handler f275q = new C04701(this);

    class C04701 extends Handler {
        final /* synthetic */ C0473h f256a;

        C04701(C0473h c0473h) {
            this.f256a = c0473h;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.f256a.f259a.isPlaying()) {
                        this.f256a.m367e();
                        this.f256a.f275q.sendEmptyMessage(2);
                        return;
                    }
                    this.f256a.f275q.sendEmptyMessageDelayed(1, 500);
                    return;
                case 2:
                    int d = this.f256a.m369f();
                    if (!this.f256a.f272n && this.f256a.f259a.isPlaying()) {
                        sendMessageDelayed(obtainMessage(2), (long) (1000 - (d % 1000)));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C04712 implements OnPreparedListener {
        final /* synthetic */ C0473h f257a;

        C04712(C0473h c0473h) {
            this.f257a = c0473h;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            this.f257a.m367e();
        }
    }

    class C04723 extends C0415f {
        final /* synthetic */ C0473h f258a;

        C04723(C0473h c0473h) {
            this.f258a = c0473h;
        }

        public void onAnimationEnd(Animation animation) {
            this.f258a.f260b.setVisibility(8);
            this.f258a.f261c.setVisibility(8);
        }
    }

    public C0473h(View view, Context context, Uri uri) {
        this.f259a = (VideoView) view.findViewById(R.id.surface_view);
        this.f265g = (ImageView) view.findViewById(R.id.movie_view_prev);
        this.f266h = (ImageView) view.findViewById(R.id.movie_view_backward);
        this.f264f = (ImageView) view.findViewById(R.id.movie_view_play);
        this.f267i = (ImageView) view.findViewById(R.id.movie_view_forward);
        this.f268j = (ImageView) view.findViewById(R.id.movie_view_next);
        this.f269k = (SeekBar) view.findViewById(R.id.movie_view_progress);
        this.f263e = (TextView) view.findViewById(R.id.movie_view_time);
        this.f262d = (TextView) view.findViewById(R.id.movie_view_duration);
        this.f260b = view.findViewById(R.id.movie_view_control1);
        this.f261c = view.findViewById(R.id.movie_view_control2);
        this.f269k.setOnSeekBarChangeListener(this);
        this.f265g.setOnClickListener(this);
        this.f267i.setOnClickListener(this);
        this.f266h.setOnClickListener(this);
        this.f264f.setOnClickListener(this);
        this.f268j.setOnClickListener(this);
        this.f273o = new StringBuilder();
        this.f274p = new Formatter(this.f273o, Locale.getDefault());
        this.f259a.setOnErrorListener(this);
        this.f259a.setOnCompletionListener(this);
        this.f259a.setOnPreparedListener(new C04712(this));
        this.f259a.requestFocus();
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        context.sendBroadcast(intent);
        m373a(uri);
    }

    private String m363a(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        i2 /= 3600;
        this.f273o.setLength(0);
        if (i2 > 0) {
            return this.f274p.format("%d:%02d:%02d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3)}).toString();
        }
        return this.f274p.format("%02d:%02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3)}).toString();
    }

    private void m367e() {
        if (this.f264f != null) {
            if (this.f259a.isPlaying()) {
                this.f264f.setImageResource(R.drawable.movie_view_stop);
            } else {
                this.f264f.setImageResource(R.drawable.movie_view_play);
            }
        }
    }

    private int m369f() {
        if (this.f259a == null) {
            return 0;
        }
        int currentPosition = this.f259a.getCurrentPosition();
        int duration = this.f259a.getDuration();
        if (this.f269k != null) {
            if (duration > 0) {
                this.f269k.setProgress((int) ((1000 * ((long) currentPosition)) / ((long) duration)));
            }
            this.f269k.setSecondaryProgress(this.f259a.getBufferPercentage() * 10);
        }
        if (this.f262d != null) {
            this.f262d.setText(m363a(duration));
        }
        if (this.f263e == null) {
            return currentPosition;
        }
        this.f263e.setText(m363a(currentPosition));
        return currentPosition;
    }

    public void m372a() {
        this.f275q.removeCallbacksAndMessages(null);
        this.f271m = this.f259a.getCurrentPosition();
        this.f259a.stopPlayback();
    }

    public void m373a(Uri uri) {
        this.f270l = uri;
        this.f259a.setVideoURI(this.f270l);
        this.f259a.start();
        this.f275q.sendEmptyMessageDelayed(1, 500);
        mo2126a(this.f265g, this.f268j);
    }

    public void mo2125a(View view) {
    }

    public abstract void mo2126a(@NonNull ImageView imageView, @NonNull ImageView imageView2);

    public void m376b() {
        if (this.f271m >= 0) {
            this.f259a.setVideoURI(this.f270l);
            this.f259a.seekTo(this.f271m);
            this.f271m = -1;
        }
    }

    public void mo2127b(View view) {
    }

    public void m378c() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f259a.getContext(), 17432577);
        loadAnimation.setAnimationListener(new C04723(this));
        this.f260b.startAnimation(loadAnimation);
        this.f261c.startAnimation(loadAnimation);
    }

    public void m379d() {
        this.f260b.setVisibility(0);
        this.f261c.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f259a.getContext(), 17432576);
        this.f260b.startAnimation(loadAnimation);
        this.f261c.startAnimation(loadAnimation);
    }

    public void onClick(View view) {
        if (view == this.f264f) {
            if (this.f259a.isPlaying()) {
                this.f259a.pause();
            } else {
                this.f259a.start();
                this.f275q.sendEmptyMessage(2);
            }
            m367e();
        } else if (view == this.f266h) {
            if (this.f259a.canSeekBackward()) {
                this.f259a.seekTo(this.f259a.getCurrentPosition() - 5000);
            }
        } else if (view == this.f267i) {
            if (this.f259a.canSeekForward()) {
                this.f259a.seekTo(this.f259a.getCurrentPosition() + 5000);
            }
        } else if (view == this.f265g) {
            mo2125a(this.f265g);
        } else if (view == this.f268j) {
            mo2127b(this.f268j);
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        m367e();
        this.f275q.removeMessages(2);
        this.f269k.setProgress(this.f269k.getMax());
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f275q.removeCallbacksAndMessages(null);
        return false;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            long duration = (((long) this.f259a.getDuration()) * ((long) i)) / 1000;
            if (this.f259a.canSeekBackward() && this.f259a.canSeekForward()) {
                this.f259a.seekTo((int) duration);
            }
            if (this.f263e != null) {
                this.f263e.setText(m363a((int) duration));
            }
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.f272n = true;
        this.f275q.removeMessages(2);
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f272n = false;
        m369f();
        m367e();
        this.f275q.sendEmptyMessage(2);
    }
}
