package com.android.gallery3d.exif;

public class Rational {
    private final long mDenominator;
    private final long mNominator;

    public Rational(long j, long j2) {
        this.mNominator = j;
        this.mDenominator = j2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Rational)) {
            return false;
        }
        Rational rational = (Rational) obj;
        return this.mNominator == rational.mNominator && this.mDenominator == rational.mDenominator;
    }

    public long getDenominator() {
        return this.mDenominator;
    }

    public long getNominator() {
        return this.mNominator;
    }
}
