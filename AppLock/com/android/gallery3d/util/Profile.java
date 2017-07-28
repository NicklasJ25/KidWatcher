package com.android.gallery3d.util;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Profile {
    private static final int NS_PER_MS = 1000000;
    private static final String TAG = "Profile";
    private static Watchdog sWatchdog = new Watchdog();

    private static class WatchEntry {
        int cycleTime;
        ArrayList<String[]> holdingStacks;
        boolean isHolding;
        Thread thread;
        int wakeTime;

        private WatchEntry() {
            this.holdingStacks = new ArrayList();
        }
    }

    private static class Watchdog {
        private Handler mHandler;
        private HandlerThread mHandlerThread = new HandlerThread("Watchdog Handler", -2);
        private ArrayList<WatchEntry> mList = new ArrayList();
        private Runnable mProcessRunnable = new C05541();
        private ProfileData mProfileData = new ProfileData();
        private Random mRandom = new Random();

        class C05541 implements Runnable {
            C05541() {
            }

            public void run() {
                synchronized (Watchdog.this) {
                    Watchdog.this.processList();
                }
            }
        }

        public Watchdog() {
            this.mHandlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper());
        }

        private WatchEntry findEntry(Thread thread) {
            for (int i = 0; i < this.mList.size(); i++) {
                WatchEntry watchEntry = (WatchEntry) this.mList.get(i);
                if (watchEntry.thread == thread) {
                    return watchEntry;
                }
            }
            return null;
        }

        private void processList() {
            this.mHandler.removeCallbacks(this.mProcessRunnable);
            if (this.mList.size() != 0) {
                int nanoTime = (int) (System.nanoTime() / 1000000);
                Iterator it = this.mList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    WatchEntry watchEntry = (WatchEntry) it.next();
                    if (nanoTime > watchEntry.wakeTime) {
                        watchEntry.wakeTime += watchEntry.cycleTime;
                        Thread thread = watchEntry.thread;
                        sampleStack(watchEntry);
                    }
                    i = watchEntry.wakeTime > i ? watchEntry.wakeTime : i;
                }
                this.mHandler.postDelayed(this.mProcessRunnable, (long) (i - nanoTime));
            }
        }

        private void sampleStack(WatchEntry watchEntry) {
            StackTraceElement[] stackTrace = watchEntry.thread.getStackTrace();
            Object obj = new String[stackTrace.length];
            for (int i = 0; i < stackTrace.length; i++) {
                obj[i] = stackTrace[i].toString();
            }
            if (watchEntry.isHolding) {
                watchEntry.holdingStacks.add(obj);
            } else {
                this.mProfileData.addSample(obj);
            }
        }

        public synchronized void addWatchEntry(Thread thread, int i) {
            WatchEntry watchEntry = new WatchEntry();
            watchEntry.thread = thread;
            watchEntry.cycleTime = i;
            watchEntry.wakeTime = (this.mRandom.nextInt(i) + 1) + ((int) (System.nanoTime() / 1000000));
            this.mList.add(watchEntry);
            processList();
        }

        public synchronized void commit(Thread thread) {
            WatchEntry findEntry = findEntry(thread);
            if (findEntry != null) {
                ArrayList arrayList = findEntry.holdingStacks;
                for (int i = 0; i < arrayList.size(); i++) {
                    this.mProfileData.addSample((String[]) arrayList.get(i));
                }
                findEntry.isHolding = false;
                findEntry.holdingStacks.clear();
            }
        }

        public synchronized void drop(Thread thread) {
            WatchEntry findEntry = findEntry(thread);
            if (findEntry != null) {
                findEntry.isHolding = false;
                findEntry.holdingStacks.clear();
            }
        }

        public synchronized void dumpToFile(String str) {
            this.mProfileData.dumpToFile(str);
        }

        public synchronized void hold(Thread thread) {
            WatchEntry findEntry = findEntry(thread);
            if (findEntry != null) {
                findEntry.isHolding = true;
            }
        }

        public synchronized void removeAllWatchEntries() {
            this.mList.clear();
            processList();
        }

        public synchronized void removeWatchEntry(Thread thread) {
            for (int i = 0; i < this.mList.size(); i++) {
                if (((WatchEntry) this.mList.get(i)).thread == thread) {
                    this.mList.remove(i);
                    break;
                }
            }
            processList();
        }

        public synchronized void reset() {
            this.mProfileData.reset();
        }
    }

    public static void commit() {
        sWatchdog.commit(Thread.currentThread());
    }

    public static void disable() {
        sWatchdog.removeWatchEntry(Thread.currentThread());
    }

    public static void disableAll() {
        sWatchdog.removeAllWatchEntries();
    }

    public static void drop() {
        sWatchdog.drop(Thread.currentThread());
    }

    public static void dumpToFile(String str) {
        sWatchdog.dumpToFile(str);
    }

    public static void enable(int i) {
        sWatchdog.addWatchEntry(Thread.currentThread(), i);
    }

    public static void hold() {
        sWatchdog.hold(Thread.currentThread());
    }

    public static void reset() {
        sWatchdog.reset();
    }
}
