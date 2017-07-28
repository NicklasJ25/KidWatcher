package com.android.gallery3d.util;

public class LinkedNode {
    protected LinkedNode mNext = this;
    protected LinkedNode mPrev = this;

    public static class List<T extends LinkedNode> {
        private LinkedNode mHead = new LinkedNode();

        public T getFirst() {
            return this.mHead.mNext == this.mHead ? null : this.mHead.mNext;
        }

        public T getLast() {
            return this.mHead.mPrev == this.mHead ? null : this.mHead.mPrev;
        }

        public void insertLast(T t) {
            this.mHead.mPrev.insert(t);
        }

        public T nextOf(T t) {
            return t.mNext == this.mHead ? null : t.mNext;
        }

        public T previousOf(T t) {
            return t.mPrev == this.mHead ? null : t.mPrev;
        }
    }

    public static <T extends LinkedNode> List<T> newList() {
        return new List();
    }

    public void insert(LinkedNode linkedNode) {
        linkedNode.mNext = this.mNext;
        this.mNext.mPrev = linkedNode;
        linkedNode.mPrev = this;
        this.mNext = linkedNode;
    }

    public void remove() {
        if (this.mNext == this) {
            throw new IllegalStateException();
        }
        this.mPrev.mNext = this.mNext;
        this.mNext.mPrev = this.mPrev;
        this.mNext = null;
        this.mPrev = null;
    }
}
