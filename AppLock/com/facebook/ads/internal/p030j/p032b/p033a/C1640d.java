package com.facebook.ads.internal.p030j.p032b.p033a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class C1640d {

    private static final class C1639a implements Comparator<File> {
        private C1639a() {
        }

        private int m4616a(long j, long j2) {
            return j < j2 ? -1 : j == j2 ? 0 : 1;
        }

        public int m4617a(File file, File file2) {
            return m4616a(file.lastModified(), file2.lastModified());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4617a((File) obj, (File) obj2);
        }
    }

    static void m4618a(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " is not directory!");
            }
        } else if (!file.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", new Object[]{file.getAbsolutePath()}));
        }
    }

    static List<File> m4619b(File file) {
        List linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new C1639a());
        return asList;
    }

    static void m4620c(File file) {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                C1640d.m4621d(file);
                if (file.lastModified() < currentTimeMillis) {
                    throw new IOException("Error set last modified date to " + file);
                }
            }
        }
    }

    static void m4621d(File file) {
        long length = file.length();
        if (length == 0) {
            C1640d.m4622e(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        randomAccessFile.seek(length - 1);
        byte readByte = randomAccessFile.readByte();
        randomAccessFile.seek(length - 1);
        randomAccessFile.write(readByte);
        randomAccessFile.close();
    }

    private static void m4622e(File file) {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file " + file);
        }
    }
}
