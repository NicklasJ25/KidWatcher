package android.support.v4.net;

import android.os.Build.VERSION;
import java.net.DatagramSocket;
import java.net.Socket;

public final class TrafficStatsCompat {
    private static final TrafficStatsCompatImpl IMPL;

    interface TrafficStatsCompatImpl {
        void clearThreadStatsTag();

        int getThreadStatsTag();

        void incrementOperationCount(int i);

        void incrementOperationCount(int i, int i2);

        void setThreadStatsTag(int i);

        void tagDatagramSocket(DatagramSocket datagramSocket);

        void tagSocket(Socket socket);

        void untagDatagramSocket(DatagramSocket datagramSocket);

        void untagSocket(Socket socket);
    }

    static class IcsTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        IcsTrafficStatsCompatImpl() {
        }

        public void clearThreadStatsTag() {
            TrafficStatsCompatIcs.clearThreadStatsTag();
        }

        public int getThreadStatsTag() {
            return TrafficStatsCompatIcs.getThreadStatsTag();
        }

        public void incrementOperationCount(int i) {
            TrafficStatsCompatIcs.incrementOperationCount(i);
        }

        public void incrementOperationCount(int i, int i2) {
            TrafficStatsCompatIcs.incrementOperationCount(i, i2);
        }

        public void setThreadStatsTag(int i) {
            TrafficStatsCompatIcs.setThreadStatsTag(i);
        }

        public void tagDatagramSocket(DatagramSocket datagramSocket) {
            TrafficStatsCompatIcs.tagDatagramSocket(datagramSocket);
        }

        public void tagSocket(Socket socket) {
            TrafficStatsCompatIcs.tagSocket(socket);
        }

        public void untagDatagramSocket(DatagramSocket datagramSocket) {
            TrafficStatsCompatIcs.untagDatagramSocket(datagramSocket);
        }

        public void untagSocket(Socket socket) {
            TrafficStatsCompatIcs.untagSocket(socket);
        }
    }

    static class Api24TrafficStatsCompatImpl extends IcsTrafficStatsCompatImpl {
        Api24TrafficStatsCompatImpl() {
        }

        public void tagDatagramSocket(DatagramSocket datagramSocket) {
            TrafficStatsCompatApi24.tagDatagramSocket(datagramSocket);
        }

        public void untagDatagramSocket(DatagramSocket datagramSocket) {
            TrafficStatsCompatApi24.untagDatagramSocket(datagramSocket);
        }
    }

    static class BaseTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        private ThreadLocal<SocketTags> mThreadSocketTags = new C01871();

        class C01871 extends ThreadLocal<SocketTags> {
            C01871() {
            }

            protected SocketTags initialValue() {
                return new SocketTags();
            }
        }

        private static class SocketTags {
            public int statsTag = -1;

            SocketTags() {
            }
        }

        BaseTrafficStatsCompatImpl() {
        }

        public void clearThreadStatsTag() {
            ((SocketTags) this.mThreadSocketTags.get()).statsTag = -1;
        }

        public int getThreadStatsTag() {
            return ((SocketTags) this.mThreadSocketTags.get()).statsTag;
        }

        public void incrementOperationCount(int i) {
        }

        public void incrementOperationCount(int i, int i2) {
        }

        public void setThreadStatsTag(int i) {
            ((SocketTags) this.mThreadSocketTags.get()).statsTag = i;
        }

        public void tagDatagramSocket(DatagramSocket datagramSocket) {
        }

        public void tagSocket(Socket socket) {
        }

        public void untagDatagramSocket(DatagramSocket datagramSocket) {
        }

        public void untagSocket(Socket socket) {
        }
    }

    static {
        if ("N".equals(VERSION.CODENAME)) {
            IMPL = new Api24TrafficStatsCompatImpl();
        } else if (VERSION.SDK_INT >= 14) {
            IMPL = new IcsTrafficStatsCompatImpl();
        } else {
            IMPL = new BaseTrafficStatsCompatImpl();
        }
    }

    private TrafficStatsCompat() {
    }

    public static void clearThreadStatsTag() {
        IMPL.clearThreadStatsTag();
    }

    public static int getThreadStatsTag() {
        return IMPL.getThreadStatsTag();
    }

    public static void incrementOperationCount(int i) {
        IMPL.incrementOperationCount(i);
    }

    public static void incrementOperationCount(int i, int i2) {
        IMPL.incrementOperationCount(i, i2);
    }

    public static void setThreadStatsTag(int i) {
        IMPL.setThreadStatsTag(i);
    }

    public static void tagDatagramSocket(DatagramSocket datagramSocket) {
        IMPL.tagDatagramSocket(datagramSocket);
    }

    public static void tagSocket(Socket socket) {
        IMPL.tagSocket(socket);
    }

    public static void untagDatagramSocket(DatagramSocket datagramSocket) {
        IMPL.untagDatagramSocket(datagramSocket);
    }

    public static void untagSocket(Socket socket) {
        IMPL.untagSocket(socket);
    }
}
