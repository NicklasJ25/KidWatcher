package com.android.gallery3d.util;

import android.util.Log;
import com.android.gallery3d.common.Utils;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class ProfileData {
    private static final String TAG = "ProfileData";
    private HashMap<String, Integer> mNameToId = new HashMap();
    private int mNextId;
    private DataOutputStream mOut;
    private Node mRoot = new Node(null, -1);
    private byte[] mScratch = new byte[4];

    private static class Node {
        public ArrayList<Node> children;
        public int id;
        public Node parent;
        public int sampleCount;

        public Node(Node node, int i) {
            this.parent = node;
            this.id = i;
        }
    }

    private int nameToId(String str) {
        Integer num = (Integer) this.mNameToId.get(str);
        if (num == null) {
            int i = this.mNextId + 1;
            this.mNextId = i;
            num = Integer.valueOf(i);
            this.mNameToId.put(str, num);
        }
        return num.intValue();
    }

    private void writeAllStacks(Node node, int i) {
        if (node.sampleCount > 0) {
            writeOneStack(node, i);
        }
        ArrayList arrayList = node.children;
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                writeAllStacks((Node) arrayList.get(i2), i + 1);
            }
        }
    }

    private void writeAllSymbols() {
        for (Entry entry : this.mNameToId.entrySet()) {
            this.mOut.writeBytes(String.format("0x%x %s\n", new Object[]{entry.getValue(), entry.getKey()}));
        }
    }

    private void writeInt(int i) {
        this.mScratch[0] = (byte) i;
        this.mScratch[1] = (byte) (i >> 8);
        this.mScratch[2] = (byte) (i >> 16);
        this.mScratch[3] = (byte) (i >> 24);
        this.mOut.write(this.mScratch);
    }

    private void writeOneStack(Node node, int i) {
        writeInt(node.sampleCount);
        writeInt(i);
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                writeInt(node.id);
                node = node.parent;
                i = i2;
            } else {
                return;
            }
        }
    }

    public void addSample(String[] strArr) {
        int[] iArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            iArr[i] = nameToId(strArr[i]);
        }
        int length = strArr.length - 1;
        Node node = this.mRoot;
        while (length >= 0) {
            if (node.children == null) {
                node.children = new ArrayList();
            }
            int i2 = iArr[length];
            ArrayList arrayList = node.children;
            int i3 = 0;
            while (i3 < arrayList.size() && ((Node) arrayList.get(i3)).id != i2) {
                i3++;
            }
            if (i3 == arrayList.size()) {
                arrayList.add(new Node(node, i2));
            }
            length--;
            node = (Node) arrayList.get(i3);
        }
        node.sampleCount++;
    }

    public void dumpToFile(String str) {
        try {
            this.mOut = new DataOutputStream(new FileOutputStream(str));
            writeInt(0);
            writeInt(3);
            writeInt(1);
            writeInt(20000);
            writeInt(0);
            writeAllStacks(this.mRoot, 0);
            writeInt(0);
            writeInt(1);
            writeInt(0);
            writeAllSymbols();
        } catch (Throwable e) {
            Log.w("Failed to dump to file", e);
        } finally {
            Utils.closeSilently(this.mOut);
        }
    }

    public void reset() {
        this.mRoot = new Node(null, -1);
        this.mNameToId.clear();
        this.mNextId = 0;
    }
}
