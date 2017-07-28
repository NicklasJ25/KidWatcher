package com.google.android.exoplayer2.p057g;

import com.google.android.exoplayer2.Format;

public interface C2192h {
    public static final C2192h f6180a = new C21931();

    static class C21931 implements C2192h {
        C21931() {
        }

        private Class<?> m6809a(String str) {
            Object obj = -1;
            try {
                switch (str.hashCode()) {
                    case -1004728940:
                        if (str.equals("text/vtt")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 691401887:
                        if (str.equals("application/x-quicktime-tx3g")) {
                            obj = 4;
                            break;
                        }
                        break;
                    case 1490991545:
                        if (str.equals("application/x-mp4vtt")) {
                            obj = 2;
                            break;
                        }
                        break;
                    case 1566015601:
                        if (str.equals("application/cea-608")) {
                            obj = 5;
                            break;
                        }
                        break;
                    case 1668750253:
                        if (str.equals("application/x-subrip")) {
                            obj = 3;
                            break;
                        }
                        break;
                    case 1693976202:
                        if (str.equals("application/ttml+xml")) {
                            obj = 1;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        return Class.forName("com.google.android.exoplayer2.g.e.g");
                    case 1:
                        return Class.forName("com.google.android.exoplayer2.g.c.a");
                    case 2:
                        return Class.forName("com.google.android.exoplayer2.g.e.b");
                    case 3:
                        return Class.forName("com.google.android.exoplayer2.g.b.a");
                    case 4:
                        return Class.forName("com.google.android.exoplayer2.g.d.a");
                    case 5:
                        return Class.forName("com.google.android.exoplayer2.g.a.a");
                    default:
                        return null;
                }
            } catch (ClassNotFoundException e) {
                return null;
            }
        }

        public boolean mo3063a(Format format) {
            return m6809a(format.f4947e) != null;
        }

        public C2156f mo3064b(Format format) {
            try {
                Class a = m6809a(format.f4947e);
                if (a != null) {
                    return (C2156f) a.asSubclass(C2156f.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                }
                throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            } catch (Throwable e) {
                throw new IllegalStateException("Unexpected error instantiating decoder", e);
            }
        }
    }

    boolean mo3063a(Format format);

    C2156f mo3064b(Format format);
}
