package com.google.firebase.iid;

@Deprecated
public class C3598c {
    private final FirebaseInstanceId f12246a;

    private C3598c(FirebaseInstanceId firebaseInstanceId) {
        this.f12246a = firebaseInstanceId;
    }

    public static C3598c m15655a() {
        return new C3598c(FirebaseInstanceId.m15605a());
    }

    public String m15656b() {
        return this.f12246a.m15617c();
    }
}
