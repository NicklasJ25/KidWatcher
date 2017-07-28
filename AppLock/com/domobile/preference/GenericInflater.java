package com.domobile.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

abstract class GenericInflater<T, P extends Parent> {
    private static final Class[] mConstructorSignature = new Class[]{Context.class, AttributeSet.class};
    private static final HashMap sConstructorMap = new HashMap();
    private final boolean DEBUG;
    private final Object[] mConstructorArgs;
    protected final Context mContext;
    private String mDefaultPackage;
    private Factory<T> mFactory;
    private boolean mFactorySet;

    public interface Factory<T> {
        T onCreateItem(String str, Context context, AttributeSet attributeSet);
    }

    private static class FactoryMerger<T> implements Factory<T> {
        private final Factory<T> mF1;
        private final Factory<T> mF2;

        FactoryMerger(Factory<T> factory, Factory<T> factory2) {
            this.mF1 = factory;
            this.mF2 = factory2;
        }

        public T onCreateItem(String str, Context context, AttributeSet attributeSet) {
            T onCreateItem = this.mF1.onCreateItem(str, context, attributeSet);
            return onCreateItem != null ? onCreateItem : this.mF2.onCreateItem(str, context, attributeSet);
        }
    }

    public interface Parent<T> {
        void addItemFromInflater(T t);
    }

    protected GenericInflater(Context context) {
        this.DEBUG = false;
        this.mConstructorArgs = new Object[2];
        this.mContext = context;
    }

    protected GenericInflater(GenericInflater<T, P> genericInflater, Context context) {
        this.DEBUG = false;
        this.mConstructorArgs = new Object[2];
        this.mContext = context;
        this.mFactory = genericInflater.mFactory;
    }

    private final T createItemFromTag(XmlPullParser xmlPullParser, String str, AttributeSet attributeSet) {
        InflateException inflateException;
        T t = null;
        try {
            if (this.mFactory != null) {
                t = this.mFactory.onCreateItem(str, this.mContext, attributeSet);
            }
            return t == null ? -1 == str.indexOf(46) ? onCreateItem(str, attributeSet) : createItem(str, null, attributeSet) : t;
        } catch (InflateException e) {
            throw e;
        } catch (Throwable e2) {
            inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e2);
            throw inflateException;
        } catch (Throwable e22) {
            inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e22);
            throw inflateException;
        }
    }

    private void rInflate(XmlPullParser xmlPullParser, T t, AttributeSet attributeSet) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2 && !onCreateCustomFromTag(xmlPullParser, t, attributeSet)) {
                Object createItemFromTag = createItemFromTag(xmlPullParser, xmlPullParser.getName(), attributeSet);
                ((Parent) t).addItemFromInflater(createItemFromTag);
                rInflate(xmlPullParser, createItemFromTag, attributeSet);
            }
        }
    }

    public abstract GenericInflater cloneInContext(Context context);

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T createItem(java.lang.String r7, java.lang.String r8, android.util.AttributeSet r9) {
        /*
        r6 = this;
        r0 = sConstructorMap;
        r0 = r0.get(r7);
        r0 = (java.lang.reflect.Constructor) r0;
        if (r0 != 0) goto L_0x00aa;
    L_0x000a:
        r1 = r6.mContext;	 Catch:{ NoSuchMethodException -> 0x003e, ClassNotFoundException -> 0x0076, Exception -> 0x0078 }
        r2 = r1.getClassLoader();	 Catch:{ NoSuchMethodException -> 0x003e, ClassNotFoundException -> 0x0076, Exception -> 0x0078 }
        if (r8 == 0) goto L_0x003c;
    L_0x0012:
        r1 = new java.lang.StringBuilder;	 Catch:{ NoSuchMethodException -> 0x003e, ClassNotFoundException -> 0x0076, Exception -> 0x0078 }
        r1.<init>();	 Catch:{ NoSuchMethodException -> 0x003e, ClassNotFoundException -> 0x0076, Exception -> 0x0078 }
        r1 = r1.append(r8);	 Catch:{ NoSuchMethodException -> 0x003e, ClassNotFoundException -> 0x0076, Exception -> 0x0078 }
        r1 = r1.append(r7);	 Catch:{ NoSuchMethodException -> 0x003e, ClassNotFoundException -> 0x0076, Exception -> 0x0078 }
        r1 = r1.toString();	 Catch:{ NoSuchMethodException -> 0x003e, ClassNotFoundException -> 0x0076, Exception -> 0x0078 }
    L_0x0023:
        r1 = r2.loadClass(r1);	 Catch:{ NoSuchMethodException -> 0x003e, ClassNotFoundException -> 0x0076, Exception -> 0x0078 }
        r2 = mConstructorSignature;	 Catch:{ NoSuchMethodException -> 0x003e, ClassNotFoundException -> 0x0076, Exception -> 0x0078 }
        r1 = r1.getConstructor(r2);	 Catch:{ NoSuchMethodException -> 0x003e, ClassNotFoundException -> 0x0076, Exception -> 0x0078 }
        r0 = sConstructorMap;	 Catch:{ NoSuchMethodException -> 0x003e, ClassNotFoundException -> 0x0076, Exception -> 0x00a8 }
        r0.put(r7, r1);	 Catch:{ NoSuchMethodException -> 0x003e, ClassNotFoundException -> 0x0076, Exception -> 0x00a8 }
    L_0x0032:
        r0 = r6.mConstructorArgs;	 Catch:{ NoSuchMethodException -> 0x003e, ClassNotFoundException -> 0x0076, Exception -> 0x00a8 }
        r2 = 1;
        r0[r2] = r9;	 Catch:{ NoSuchMethodException -> 0x003e, ClassNotFoundException -> 0x0076, Exception -> 0x00a8 }
        r0 = r1.newInstance(r0);	 Catch:{ NoSuchMethodException -> 0x003e, ClassNotFoundException -> 0x0076, Exception -> 0x00a8 }
        return r0;
    L_0x003c:
        r1 = r7;
        goto L_0x0023;
    L_0x003e:
        r0 = move-exception;
        r1 = new android.view.InflateException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r9.getPositionDescription();
        r2 = r2.append(r3);
        r3 = ": Error inflating class ";
        r2 = r2.append(r3);
        if (r8 == 0) goto L_0x0067;
    L_0x0056:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3 = r3.append(r8);
        r3 = r3.append(r7);
        r7 = r3.toString();
    L_0x0067:
        r2 = r2.append(r7);
        r2 = r2.toString();
        r1.<init>(r2);
        r1.initCause(r0);
        throw r1;
    L_0x0076:
        r0 = move-exception;
        throw r0;
    L_0x0078:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x007c:
        r2 = new android.view.InflateException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r9.getPositionDescription();
        r3 = r3.append(r4);
        r4 = ": Error inflating class ";
        r3 = r3.append(r4);
        r1 = r1.getClass();
        r1 = r1.getName();
        r1 = r3.append(r1);
        r1 = r1.toString();
        r2.<init>(r1);
        r2.initCause(r0);
        throw r2;
    L_0x00a8:
        r0 = move-exception;
        goto L_0x007c;
    L_0x00aa:
        r1 = r0;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.domobile.preference.GenericInflater.createItem(java.lang.String, java.lang.String, android.util.AttributeSet):T");
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDefaultPackage() {
        return this.mDefaultPackage;
    }

    public final Factory<T> getFactory() {
        return this.mFactory;
    }

    public T inflate(int i, P p) {
        return inflate(i, (Parent) p, p != null);
    }

    public T inflate(int i, P p, boolean z) {
        XmlPullParser xml = getContext().getResources().getXml(i);
        try {
            T inflate = inflate(xml, (Parent) p, z);
            return inflate;
        } finally {
            xml.close();
        }
    }

    public T inflate(XmlPullParser xmlPullParser, P p) {
        return inflate(xmlPullParser, (Parent) p, p != null);
    }

    public T inflate(XmlPullParser xmlPullParser, P p, boolean z) {
        T onMergeRoots;
        synchronized (this.mConstructorArgs) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.mConstructorArgs[0] = this.mContext;
            int next;
            do {
                try {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (InflateException e) {
                    throw e;
                } catch (Throwable e2) {
                    InflateException inflateException = new InflateException(e2.getMessage());
                    inflateException.initCause(e2);
                    throw inflateException;
                } catch (Throwable e22) {
                    inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e22.getMessage());
                    inflateException.initCause(e22);
                    throw inflateException;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
            onMergeRoots = onMergeRoots(p, z, (Parent) createItemFromTag(xmlPullParser, xmlPullParser.getName(), asAttributeSet));
            rInflate(xmlPullParser, onMergeRoots, asAttributeSet);
        }
        return onMergeRoots;
    }

    protected boolean onCreateCustomFromTag(XmlPullParser xmlPullParser, T t, AttributeSet attributeSet) {
        return false;
    }

    protected T onCreateItem(String str, AttributeSet attributeSet) {
        return createItem(str, this.mDefaultPackage, attributeSet);
    }

    protected P onMergeRoots(P p, boolean z, P p2) {
        return p2;
    }

    public void setDefaultPackage(String str) {
        this.mDefaultPackage = str;
    }

    public void setFactory(Factory<T> factory) {
        if (this.mFactorySet) {
            throw new IllegalStateException("A factory has already been set on this inflater");
        } else if (factory == null) {
            throw new NullPointerException("Given factory can not be null");
        } else {
            this.mFactorySet = true;
            if (this.mFactory == null) {
                this.mFactory = factory;
            } else {
                this.mFactory = new FactoryMerger(factory, this.mFactory);
            }
        }
    }
}
