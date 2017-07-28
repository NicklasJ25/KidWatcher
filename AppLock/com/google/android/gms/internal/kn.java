package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.List;

class kn {

    interface C3027b {
        kt mo3813a();

        boolean mo3814a(byte[] bArr);
    }

    static class C3028a implements C3027b {
        private List<byte[]> f9638a = new ArrayList();
        private int f9639b = 0;

        C3028a() {
        }

        public kt mo3813a() {
            byte[] bArr = new byte[this.f9639b];
            int i = 0;
            for (int i2 = 0; i2 < this.f9638a.size(); i2++) {
                byte[] bArr2 = (byte[]) this.f9638a.get(i2);
                System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
                i += bArr2.length;
            }
            return new kt(bArr);
        }

        public boolean mo3814a(byte[] bArr) {
            this.f9638a.add(bArr);
            this.f9639b += bArr.length;
            return true;
        }
    }

    static class C3031c implements C3027b {
        private static ThreadLocal<CharsetDecoder> f9640a = new C30291();
        private static ThreadLocal<CharsetEncoder> f9641b = new C30302();
        private StringBuilder f9642c = new StringBuilder();

        class C30291 extends ThreadLocal<CharsetDecoder> {
            C30291() {
            }

            protected CharsetDecoder m12211a() {
                CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
                newDecoder.onMalformedInput(CodingErrorAction.REPORT);
                newDecoder.onUnmappableCharacter(CodingErrorAction.REPORT);
                return newDecoder;
            }

            protected /* synthetic */ Object initialValue() {
                return m12211a();
            }
        }

        class C30302 extends ThreadLocal<CharsetEncoder> {
            C30302() {
            }

            protected CharsetEncoder m12212a() {
                CharsetEncoder newEncoder = Charset.forName("UTF8").newEncoder();
                newEncoder.onMalformedInput(CodingErrorAction.REPORT);
                newEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
                return newEncoder;
            }

            protected /* synthetic */ Object initialValue() {
                return m12212a();
            }
        }

        C3031c() {
        }

        private String m12213b(byte[] bArr) {
            try {
                return ((CharsetDecoder) f9640a.get()).decode(ByteBuffer.wrap(bArr)).toString();
            } catch (CharacterCodingException e) {
                return null;
            }
        }

        public kt mo3813a() {
            return new kt(this.f9642c.toString());
        }

        public boolean mo3814a(byte[] bArr) {
            String b = m12213b(bArr);
            if (b == null) {
                return false;
            }
            this.f9642c.append(b);
            return true;
        }
    }

    static C3027b m12216a(byte b) {
        return b == (byte) 2 ? new C3028a() : new C3031c();
    }
}
