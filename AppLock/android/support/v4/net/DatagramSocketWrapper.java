package android.support.v4.net;

import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;

class DatagramSocketWrapper extends Socket {

    private static class DatagramSocketImplWrapper extends SocketImpl {
        public DatagramSocketImplWrapper(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) {
            this.localport = datagramSocket.getLocalPort();
            this.fd = fileDescriptor;
        }

        protected void accept(SocketImpl socketImpl) {
            throw new UnsupportedOperationException();
        }

        protected int available() {
            throw new UnsupportedOperationException();
        }

        protected void bind(InetAddress inetAddress, int i) {
            throw new UnsupportedOperationException();
        }

        protected void close() {
            throw new UnsupportedOperationException();
        }

        protected void connect(String str, int i) {
            throw new UnsupportedOperationException();
        }

        protected void connect(InetAddress inetAddress, int i) {
            throw new UnsupportedOperationException();
        }

        protected void connect(SocketAddress socketAddress, int i) {
            throw new UnsupportedOperationException();
        }

        protected void create(boolean z) {
            throw new UnsupportedOperationException();
        }

        protected InputStream getInputStream() {
            throw new UnsupportedOperationException();
        }

        public Object getOption(int i) {
            throw new UnsupportedOperationException();
        }

        protected OutputStream getOutputStream() {
            throw new UnsupportedOperationException();
        }

        protected void listen(int i) {
            throw new UnsupportedOperationException();
        }

        protected void sendUrgentData(int i) {
            throw new UnsupportedOperationException();
        }

        public void setOption(int i, Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    public DatagramSocketWrapper(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) {
        super(new DatagramSocketImplWrapper(datagramSocket, fileDescriptor));
    }
}
