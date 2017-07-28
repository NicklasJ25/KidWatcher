package com.android.gallery3d.data;

import java.util.ArrayList;
import java.util.HashMap;

public class PathMatcher {
    public static final int NOT_FOUND = -1;
    private Node mRoot;
    private ArrayList<String> mVariables;

    private static class Node {
        private int mKind;
        private HashMap<String, Node> mMap;

        private Node() {
            this.mKind = -1;
        }

        Node addChild(String str) {
            Node node;
            if (this.mMap == null) {
                this.mMap = new HashMap();
            } else {
                node = (Node) this.mMap.get(str);
                if (node != null) {
                    return node;
                }
            }
            node = new Node();
            this.mMap.put(str, node);
            return node;
        }

        Node getChild(String str) {
            return this.mMap == null ? null : (Node) this.mMap.get(str);
        }

        int getKind() {
            return this.mKind;
        }

        void setKind(int i) {
            this.mKind = i;
        }
    }

    public PathMatcher() {
        this.mVariables = new ArrayList();
        this.mRoot = new Node();
        this.mRoot = new Node();
    }

    public void add(String str, int i) {
        String[] split = Path.split(str);
        Node node = this.mRoot;
        for (String addChild : split) {
            node = node.addChild(addChild);
        }
        node.setKind(i);
    }

    public int getIntVar(int i) {
        return Integer.parseInt((String) this.mVariables.get(i));
    }

    public long getLongVar(int i) {
        return Long.parseLong((String) this.mVariables.get(i));
    }

    public String getVar(int i) {
        return (String) this.mVariables.get(i);
    }

    public int match(Path path) {
        String[] split = path.split();
        this.mVariables.clear();
        Node node = this.mRoot;
        for (int i = 0; i < split.length; i++) {
            Node child = node.getChild(split[i]);
            if (child == null) {
                node = node.getChild("*");
                if (node == null) {
                    return -1;
                }
                this.mVariables.add(split[i]);
            } else {
                node = child;
            }
        }
        return node.getKind();
    }
}
