package com.google.android.gms.internal;

import java.io.IOException;

public class ma extends IOException {
    public ma(String str) {
        super(str);
    }

    static ma m12489a() {
        return new ma("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static ma m12490b() {
        return new ma("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static ma m12491c() {
        return new ma("CodedInputStream encountered a malformed varint.");
    }

    static ma m12492d() {
        return new ma("Protocol message contained an invalid tag (zero).");
    }

    static ma m12493e() {
        return new ma("Protocol message end-group tag did not match expected tag.");
    }

    static ma m12494f() {
        return new ma("Protocol message tag had invalid wire type.");
    }

    static ma m12495g() {
        return new ma("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
