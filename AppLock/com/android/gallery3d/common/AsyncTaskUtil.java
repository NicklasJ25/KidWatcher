package com.android.gallery3d.common;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

public class AsyncTaskUtil {
    private static Executor sExecutor;
    private static Method sMethodExecuteOnExecutor;

    static {
        if (VERSION.SDK_INT >= 11) {
            try {
                sExecutor = (Executor) AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null);
                sMethodExecuteOnExecutor = AsyncTask.class.getMethod("executeOnExecutor", new Class[]{Executor.class, Object[].class});
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            }
        }
    }

    private AsyncTaskUtil() {
    }

    public static <Param> void executeInParallel(AsyncTask<Param, ?, ?> asyncTask, Param... paramArr) {
        if (VERSION.SDK_INT < 11) {
            asyncTask.execute(paramArr);
            return;
        }
        try {
            sMethodExecuteOnExecutor.invoke(asyncTask, new Object[]{sExecutor, paramArr});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }
}
