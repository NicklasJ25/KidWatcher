package com.android.gallery3d.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class Entry {
    public static final String[] ID_PROJECTION = new String[]{Columns.ID};
    @Column("_id")
    public long id = 0;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Column {
        String defaultValue() default "";

        boolean fullText() default false;

        boolean indexed() default false;

        boolean unique() default false;

        String value();
    }

    public interface Columns {
        public static final String ID = "_id";
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Table {
        String value();
    }

    public void clear() {
        this.id = 0;
    }
}
