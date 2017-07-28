package com.domobile.preference;

public class CharSequences {
    public static int compareToIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        int i = 0;
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i2 = length < length2 ? length : length2;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 + 1;
            char toLowerCase = Character.toLowerCase(charSequence.charAt(i3));
            i3 = i + 1;
            i = toLowerCase - Character.toLowerCase(charSequence2.charAt(i));
            if (i != 0) {
                return i;
            }
            i = i3;
            i3 = i4;
        }
        return length - length2;
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static CharSequence forAsciiBytes(final byte[] bArr) {
        return new CharSequence() {
            public char charAt(int i) {
                return (char) bArr[i];
            }

            public int length() {
                return bArr.length;
            }

            public CharSequence subSequence(int i, int i2) {
                return CharSequences.forAsciiBytes(bArr, i, i2);
            }

            public String toString() {
                return new String(bArr);
            }
        };
    }

    public static CharSequence forAsciiBytes(final byte[] bArr, final int i, final int i2) {
        validate(i, i2, bArr.length);
        return new CharSequence() {
            public char charAt(int i) {
                return (char) bArr[i + i];
            }

            public int length() {
                return i2 - i;
            }

            public CharSequence subSequence(int i, int i2) {
                int i3 = i - i;
                int i4 = i2 - i;
                CharSequences.validate(i3, i4, length());
                return CharSequences.forAsciiBytes(bArr, i3, i4);
            }

            public String toString() {
                return new String(bArr, i, length());
            }
        };
    }

    static void validate(int i, int i2, int i3) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 > i3) {
            throw new IndexOutOfBoundsException();
        } else if (i > i2) {
            throw new IndexOutOfBoundsException();
        }
    }
}
