package com.domobile.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.domobile.p015b.C1168b.C1162f;
import com.domobile.p015b.C1168b.C1166j;
import com.domobile.preference.Preference.BaseSavedState;

public class EditTextPreference extends DialogPreference {
    private EditText mEditText;
    private String mText;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C13881();
        String text;

        static class C13881 implements Creator<SavedState> {
            C13881() {
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
            this.text = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.text);
        }
    }

    public EditTextPreference(Context context) {
        this(context, null);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1166j.EditTextPreferenceStyle);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEditText = new EditText(context, attributeSet);
        this.mEditText.setId(16908291);
        this.mEditText.setEnabled(true);
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    public String getText() {
        return this.mText;
    }

    protected boolean needInputMethod() {
        return true;
    }

    protected void onAddEditTextToDialogView(View view, EditText editText) {
        ViewGroup viewGroup = (ViewGroup) view.findViewById(C1162f.preference_edittext_container);
        if (viewGroup != null) {
            viewGroup.addView(editText, -1, -2);
        }
    }

    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        View view2 = this.mEditText;
        view2.setText(getText());
        View parent = view2.getParent();
        if (parent != view) {
            if (parent != null) {
                ((ViewGroup) parent).removeView(view2);
            }
            onAddEditTextToDialogView(view, view2);
        }
    }

    protected void onDialogClosed(boolean z) {
        super.onDialogClosed(z);
        if (z) {
            String obj = this.mEditText.getText().toString();
            if (callChangeListener(obj)) {
                setText(obj);
            }
        }
    }

    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.text);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.text = getText();
        return savedState;
    }

    protected void onSetInitialValue(boolean z, Object obj) {
        setText(z ? getPersistedString(this.mText) : (String) obj);
    }

    public void setText(String str) {
        boolean shouldDisableDependents = shouldDisableDependents();
        this.mText = str;
        persistString(str);
        boolean shouldDisableDependents2 = shouldDisableDependents();
        if (shouldDisableDependents2 != shouldDisableDependents) {
            notifyDependencyChange(shouldDisableDependents2);
        }
    }

    public boolean shouldDisableDependents() {
        return TextUtils.isEmpty(this.mText) || super.shouldDisableDependents();
    }
}
