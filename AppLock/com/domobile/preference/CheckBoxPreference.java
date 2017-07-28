package com.domobile.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.TextView;
import com.domobile.p015b.C1168b.C1163g;
import com.domobile.p015b.C1168b.C1166j;
import com.domobile.p015b.C1168b.C1167k;
import com.domobile.preference.Preference.BaseSavedState;

public class CheckBoxPreference extends Preference {
    private AccessibilityManager mAccessibilityManager;
    public boolean mChecked;
    private boolean mDisableDependentsState;
    public boolean mFirstChecked;
    public boolean mOldChecked;
    private boolean mSendAccessibilityEventViewClickedType;
    private CharSequence mSummaryOff;
    private CharSequence mSummaryOn;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C13861();
        boolean checked;

        static class C13861 implements Creator<SavedState> {
            C13861() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            boolean z = true;
            super(parcel);
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.checked = z;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.checked ? 1 : 0);
        }
    }

    public CheckBoxPreference(Context context) {
        this(context, null);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1166j.CheckBoxPreferenceStyle);
        setWidgetLayoutResource(C1163g.preference_widget_checkbox);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFirstChecked = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1167k.MyCheckBoxPreference, i, 0);
        this.mSummaryOn = obtainStyledAttributes.getString(C1167k.MyCheckBoxPreference_android_summaryOn);
        this.mSummaryOff = obtainStyledAttributes.getString(C1167k.MyCheckBoxPreference_android_summaryOff);
        this.mDisableDependentsState = obtainStyledAttributes.getBoolean(C1167k.MyCheckBoxPreference_android_disableDependentsState, false);
        obtainStyledAttributes.recycle();
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public boolean getDisableDependentsState() {
        return this.mDisableDependentsState;
    }

    public CharSequence getSummaryOff() {
        return this.mSummaryOff;
    }

    public CharSequence getSummaryOn() {
        return this.mSummaryOn;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    protected void onBindView(View view) {
        if (view != null) {
            super.onBindView(view);
            final View findViewById = view.findViewById(16908289);
            if (findViewById != null && (findViewById instanceof Checkable)) {
                if (this.mFirstChecked) {
                    ((Checkable) findViewById).setChecked(this.mChecked);
                    this.mOldChecked = this.mChecked;
                    this.mFirstChecked = false;
                } else if (this.mChecked != this.mOldChecked) {
                    findViewById.postDelayed(new Runnable() {
                        public void run() {
                            ((Checkable) findViewById).setChecked(CheckBoxPreference.this.mChecked);
                            CheckBoxPreference.this.mOldChecked = CheckBoxPreference.this.mChecked;
                        }
                    }, 100);
                } else {
                    ((Checkable) findViewById).setChecked(this.mChecked);
                }
                if (this.mSendAccessibilityEventViewClickedType && this.mAccessibilityManager.isEnabled() && findViewById.isEnabled()) {
                    this.mSendAccessibilityEventViewClickedType = false;
                    findViewById.sendAccessibilityEventUnchecked(AccessibilityEvent.obtain(1));
                }
            }
            TextView textView = (TextView) view.findViewById(16908304);
            if (textView != null) {
                boolean z;
                boolean z2;
                int i;
                if (this.mChecked && this.mSummaryOn != null) {
                    textView.setText(this.mSummaryOn);
                    z = false;
                } else if (this.mChecked || this.mSummaryOff == null) {
                    z = true;
                } else {
                    textView.setText(this.mSummaryOff);
                    z = false;
                }
                if (z) {
                    CharSequence summary = getSummary();
                    if (summary != null) {
                        textView.setText(summary);
                        z2 = false;
                        i = 8;
                        if (!z2) {
                            i = 0;
                        }
                        if (i != textView.getVisibility()) {
                            textView.setVisibility(i);
                        }
                    }
                }
                z2 = z;
                i = 8;
                if (z2) {
                    i = 0;
                }
                if (i != textView.getVisibility()) {
                    textView.setVisibility(i);
                }
            }
        }
    }

    protected void onClick() {
        super.onClick();
        boolean z = !isChecked();
        this.mSendAccessibilityEventViewClickedType = true;
        if (callChangeListener(Boolean.valueOf(z))) {
            setChecked(z);
        }
    }

    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.checked);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.checked = isChecked();
        return savedState;
    }

    protected void onSetInitialValue(boolean z, Object obj) {
        setChecked(z ? getPersistedBoolean(this.mChecked) : ((Boolean) obj).booleanValue());
    }

    public void setChecked(boolean z) {
        if (this.mChecked != z) {
            this.mChecked = z;
            persistBoolean(z);
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void setDisableDependentsState(boolean z) {
        this.mDisableDependentsState = z;
    }

    public void setSummaryOff(int i) {
        setSummaryOff(getContext().getString(i));
    }

    public void setSummaryOff(CharSequence charSequence) {
        this.mSummaryOff = charSequence;
        if (!isChecked()) {
            notifyChanged();
        }
    }

    public void setSummaryOn(int i) {
        setSummaryOn(getContext().getString(i));
    }

    public void setSummaryOn(CharSequence charSequence) {
        this.mSummaryOn = charSequence;
        if (isChecked()) {
            notifyChanged();
        }
    }

    public boolean shouldDisableDependents() {
        boolean z = this.mDisableDependentsState ? this.mChecked : !this.mChecked;
        return z || super.shouldDisableDependents();
    }
}
