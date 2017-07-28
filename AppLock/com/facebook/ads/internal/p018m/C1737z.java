package com.facebook.ads.internal.p018m;

import android.content.Context;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.facebook.ads.internal.p022h.C1608p;
import com.facebook.ads.internal.p028g.C1581g;
import com.facebook.ads.internal.p028g.C1583i;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class C1737z {
    private static final String f4385a = C1737z.class.getName();
    private static final Object f4386b = new Object();

    public static C1608p m4998a(Exception exception, Context context) {
        C1608p c1608p = new C1608p(C1581g.m4409b(), C1581g.m4410c(), new C1736y(C1710f.m4917a(exception), C1583i.f3925f, true));
        C1737z.m5001a(c1608p, context);
        return c1608p;
    }

    @WorkerThread
    public static JSONArray m4999a(Context context) {
        FileInputStream openFileInput;
        BufferedReader bufferedReader;
        Throwable e;
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader2 = null;
        JSONArray jSONArray = new JSONArray();
        synchronized (f4386b) {
            InputStreamReader inputStreamReader2;
            try {
                if (new File(context.getFilesDir(), "crasheslog").exists()) {
                    openFileInput = context.openFileInput("crasheslog");
                    try {
                        inputStreamReader2 = new InputStreamReader(openFileInput);
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader2);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    jSONArray.put(new JSONObject(readLine));
                                } catch (Exception e2) {
                                    e = e2;
                                    inputStreamReader = inputStreamReader2;
                                    fileInputStream = openFileInput;
                                } catch (Throwable th) {
                                    e = th;
                                    bufferedReader2 = bufferedReader;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            bufferedReader = null;
                            inputStreamReader = inputStreamReader2;
                            fileInputStream = openFileInput;
                            try {
                                Log.e(f4385a, "Failed to read crashes", e);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable e4) {
                                        Log.e(f4385a, "Failed to close buffers", e4);
                                    }
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return jSONArray;
                            } catch (Throwable th2) {
                                e4 = th2;
                                openFileInput = fileInputStream;
                                inputStreamReader2 = inputStreamReader;
                                bufferedReader2 = bufferedReader;
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (Throwable e5) {
                                        Log.e(f4385a, "Failed to close buffers", e5);
                                        throw e4;
                                    }
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                }
                                if (openFileInput != null) {
                                    openFileInput.close();
                                }
                                throw e4;
                            }
                        } catch (Throwable th3) {
                            e4 = th3;
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            if (inputStreamReader2 != null) {
                                inputStreamReader2.close();
                            }
                            if (openFileInput != null) {
                                openFileInput.close();
                            }
                            throw e4;
                        }
                    } catch (Exception e6) {
                        e4 = e6;
                        bufferedReader = null;
                        fileInputStream = openFileInput;
                        Log.e(f4385a, "Failed to read crashes", e4);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return jSONArray;
                    } catch (Throwable th4) {
                        e4 = th4;
                        inputStreamReader2 = null;
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                        }
                        if (openFileInput != null) {
                            openFileInput.close();
                        }
                        throw e4;
                    }
                }
                bufferedReader = null;
                inputStreamReader2 = null;
                openFileInput = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e42) {
                        Log.e(f4385a, "Failed to close buffers", e42);
                    }
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (openFileInput != null) {
                    openFileInput.close();
                }
            } catch (Exception e7) {
                e42 = e7;
                bufferedReader = null;
                fileInputStream = null;
                Log.e(f4385a, "Failed to read crashes", e42);
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return jSONArray;
            } catch (Throwable th5) {
                e42 = th5;
                inputStreamReader2 = null;
                openFileInput = null;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (openFileInput != null) {
                    openFileInput.close();
                }
                throw e42;
            }
        }
        return jSONArray;
    }

    private static JSONObject m5000a(C1608p c1608p) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", UUID.randomUUID().toString());
        jSONObject.put("type", c1608p.mo2733b());
        jSONObject.put("time", C1729s.m4960a(c1608p.m4424e()));
        jSONObject.put("session_time", C1729s.m4960a(c1608p.m4425f()));
        jSONObject.put("session_id", c1608p.m4426g());
        jSONObject.put("data", c1608p.m4427h() != null ? new JSONObject(c1608p.m4427h()) : new JSONObject());
        return jSONObject;
    }

    public static void m5001a(C1608p c1608p, Context context) {
        if (c1608p != null && context != null) {
            synchronized (f4386b) {
                try {
                    JSONObject a = C1737z.m5000a(c1608p);
                    FileOutputStream openFileOutput = context.openFileOutput("crasheslog", 32768);
                    openFileOutput.write((a.toString() + "\n").getBytes());
                    openFileOutput.close();
                } catch (Throwable e) {
                    Log.e(f4385a, "Failed to store crash", e);
                }
            }
        }
    }

    @WorkerThread
    public static void m5002b(Context context) {
        synchronized (f4386b) {
            File file = new File(context.getFilesDir(), "crasheslog");
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
