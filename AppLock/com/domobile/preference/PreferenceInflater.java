package com.domobile.preference;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;

class PreferenceInflater extends GenericInflater<Preference, PreferenceGroup> {
    private static final String INTENT_TAG_NAME = "intent";
    private static final String TAG = "PreferenceInflater";
    private PreferenceManager mPreferenceManager;

    public PreferenceInflater(Context context, PreferenceManager preferenceManager) {
        super(context);
        init(preferenceManager);
    }

    PreferenceInflater(GenericInflater<Preference, PreferenceGroup> genericInflater, PreferenceManager preferenceManager, Context context) {
        super(genericInflater, context);
        init(preferenceManager);
    }

    private void init(PreferenceManager preferenceManager) {
        this.mPreferenceManager = preferenceManager;
        setDefaultPackage("android.preference.");
    }

    public GenericInflater<Preference, PreferenceGroup> cloneInContext(Context context) {
        return new PreferenceInflater(this, this.mPreferenceManager, context);
    }

    protected boolean onCreateCustomFromTag(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) {
        if (!xmlPullParser.getName().equals(INTENT_TAG_NAME)) {
            return false;
        }
        Intent parseIntent;
        try {
            parseIntent = Intent.parseIntent(getContext().getResources(), xmlPullParser, attributeSet);
        } catch (Throwable e) {
            Log.w(TAG, "Could not parse Intent.");
            Log.w(TAG, e);
            parseIntent = null;
        }
        if (parseIntent != null) {
            preference.setIntent(parseIntent);
        }
        return true;
    }

    protected PreferenceGroup onMergeRoots(PreferenceGroup preferenceGroup, boolean z, PreferenceGroup preferenceGroup2) {
        if (preferenceGroup != null) {
            return preferenceGroup;
        }
        preferenceGroup2.onAttachedToHierarchy(this.mPreferenceManager);
        return preferenceGroup2;
    }
}
