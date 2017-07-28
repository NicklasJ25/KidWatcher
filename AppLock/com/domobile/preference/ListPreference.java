package com.domobile.preference;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.domobile.p015b.C1168b.C1167k;
import com.domobile.preference.Preference.BaseSavedState;

public class ListPreference extends DialogPreference {
    private int mClickedDialogEntryIndex;
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private String mValue;

    class C13891 implements OnClickListener {
        C13891() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ListPreference.this.mClickedDialogEntryIndex = i;
            ListPreference.this.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C13901();
        String value;

        static class C13901 implements Creator<SavedState> {
            C13901() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.value = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.value);
        }
    }

    public ListPreference(Context context) {
        this(context, null);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1167k.MyListPreference, 0, 0);
        this.mEntries = obtainStyledAttributes.getTextArray(C1167k.MyListPreference_android_entries);
        this.mEntryValues = obtainStyledAttributes.getTextArray(C1167k.MyListPreference_android_entryValues);
        obtainStyledAttributes.recycle();
    }

    private int getValueIndex() {
        return findIndexOfValue(this.mValue);
    }

    public int findIndexOfValue(String str) {
        if (!(str == null || this.mEntryValues == null)) {
            for (int length = this.mEntryValues.length - 1; length >= 0; length--) {
                if (this.mEntryValues[length].equals(str)) {
                    return length;
                }
            }
        }
        return -1;
    }

    public CharSequence[] getEntries() {
        return this.mEntries;
    }

    public CharSequence getEntry() {
        int valueIndex = getValueIndex();
        return (valueIndex < 0 || this.mEntries == null) ? null : this.mEntries[valueIndex];
    }

    public CharSequence[] getEntryValues() {
        return this.mEntryValues;
    }

    public String getValue() {
        return this.mValue;
    }

    protected void onDialogClosed(boolean z) {
        super.onDialogClosed(z);
        if (z && this.mClickedDialogEntryIndex >= 0 && this.mEntryValues != null) {
            String charSequence = this.mEntryValues[this.mClickedDialogEntryIndex].toString();
            if (callChangeListener(charSequence)) {
                setValue(charSequence);
            }
        }
    }

    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    protected void onPrepareDialogBuilder(Builder builder) {
        super.onPrepareDialogBuilder(builder);
        if (this.mEntries == null || this.mEntryValues == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.mClickedDialogEntryIndex = getValueIndex();
        builder.setSingleChoiceItems(this.mEntries, this.mClickedDialogEntryIndex, new C13891());
        builder.setPositiveButton(null, null);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setValue(savedState.value);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.value = getValue();
        return savedState;
    }

    protected void onSetInitialValue(boolean z, Object obj) {
        setValue(z ? getPersistedString(this.mValue) : (String) obj);
    }

    public void setEntries(int i) {
        setEntries(getContext().getResources().getTextArray(i));
    }

    public void setEntries(CharSequence[] charSequenceArr) {
        this.mEntries = charSequenceArr;
    }

    public void setEntryValues(int i) {
        setEntryValues(getContext().getResources().getTextArray(i));
    }

    public void setEntryValues(CharSequence[] charSequenceArr) {
        this.mEntryValues = charSequenceArr;
    }

    public void setValue(String str) {
        this.mValue = str;
        persistString(str);
    }

    public void setValueIndex(int i) {
        if (this.mEntryValues != null) {
            setValue(this.mEntryValues[i].toString());
        }
    }
}
