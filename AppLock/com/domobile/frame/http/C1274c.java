package com.domobile.frame.http;

import android.content.Context;
import android.text.TextUtils;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class C1274c {
    public static String m3037a(Context context, String str, ArrayList<C1271g> arrayList, String str2) {
        OutputStream dataOutputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream2;
        String str3;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        Throwable th2;
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection3.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection3.setRequestProperty("Charset", "UTF-8");
                httpURLConnection3.setConnectTimeout(20000);
                if (arrayList == null || arrayList.size() <= 0) {
                    httpURLConnection3.setDoInput(true);
                    httpURLConnection3.connect();
                    Object obj = inputStream;
                } else {
                    httpURLConnection3.setRequestMethod("POST");
                    httpURLConnection3.setDoOutput(true);
                    httpURLConnection3.setDoInput(true);
                    dataOutputStream = new DataOutputStream(httpURLConnection3.getOutputStream());
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        int size = arrayList.size();
                        for (int i = 0; i < size; i++) {
                            C1271g c1271g = (C1271g) arrayList.get(i);
                            stringBuilder.append(c1271g.mo2523a()).append("=").append(c1271g.mo2524b()).append("&");
                        }
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        if (str2 == null) {
                            str2 = "UTF-8";
                        }
                        dataOutputStream.write(stringBuilder.toString().getBytes(str2));
                        httpURLConnection3.connect();
                        dataOutputStream.flush();
                        outputStream = dataOutputStream;
                    } catch (Exception e) {
                        OutputStream outputStream3 = dataOutputStream;
                        httpURLConnection = httpURLConnection3;
                        outputStream2 = outputStream3;
                        try {
                            str3 = "500";
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e2) {
                                }
                            }
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (Exception e3) {
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return str3;
                        } catch (Throwable th3) {
                            th = th3;
                            httpURLConnection2 = httpURLConnection;
                            dataOutputStream = outputStream2;
                            th2 = th;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e5) {
                                }
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            throw th2;
                        }
                    } catch (Throwable th32) {
                        th = th32;
                        httpURLConnection2 = httpURLConnection3;
                        th2 = th;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th2;
                    }
                }
                try {
                    if (httpURLConnection3.getResponseCode() == 200) {
                        inputStream = httpURLConnection3.getInputStream();
                        String a = C1273b.m3036a(inputStream);
                        str3 = !TextUtils.isEmpty(str2) ? new String(a.getBytes(str2), str2) : a;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e6) {
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e7) {
                            }
                        }
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                    } else {
                        str3 = "404";
                        if (inputStream != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e8) {
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e9) {
                            }
                        }
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                    }
                } catch (Exception e10) {
                    httpURLConnection = httpURLConnection3;
                    outputStream2 = outputStream;
                    str3 = "500";
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return str3;
                } catch (Throwable th322) {
                    dataOutputStream = outputStream;
                    th = th322;
                    httpURLConnection2 = httpURLConnection3;
                    th2 = th;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th2;
                }
            } catch (Exception e11) {
                httpURLConnection = httpURLConnection3;
                Object obj2 = inputStream;
                str3 = "500";
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return str3;
            } catch (Throwable th3222) {
                Object obj3 = inputStream;
                th = th3222;
                httpURLConnection2 = httpURLConnection3;
                th2 = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th2;
            }
        } catch (Exception e12) {
            outputStream2 = inputStream;
            httpURLConnection = inputStream;
            str3 = "500";
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return str3;
        } catch (Throwable th4) {
            th2 = th4;
            dataOutputStream = inputStream;
            httpURLConnection2 = inputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th2;
        }
        return str3;
    }
}
