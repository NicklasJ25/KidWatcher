package com.domobile.preference;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.domobile.p015b.C1168b.C1166j;
import com.domobile.p015b.C1168b.C1167k;
import com.domobile.preference.Preference.BaseSavedState;
import com.domobile.preference.PreferenceManager.OnActivityDestroyListener;

public abstract class DialogPreference extends Preference implements OnClickListener, OnDismissListener, OnActivityDestroyListener {
    private Builder mBuilder;
    private Dialog mDialog;
    private Drawable mDialogIcon;
    private int mDialogLayoutResId;
    private CharSequence mDialogMessage;
    private CharSequence mDialogTitle;
    private CharSequence mNegativeButtonText;
    private CharSequence mPositiveButtonText;
    private int mWhichButtonClicked;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C13871();
        Bundle dialogBundle;
        boolean isDialogShowing;

        static class C13871 implements Creator<SavedState> {
            C13871() {
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
            this.isDialogShowing = z;
            this.dialogBundle = parcel.readBundle();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isDialogShowing ? 1 : 0);
            parcel.writeBundle(this.dialogBundle);
        }
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1166j.DialogPreferenceStyle);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1167k.MyDialogPreference, i, 0);
        this.mDialogTitle = obtainStyledAttributes.getString(C1167k.MyDialogPreference_android_dialogTitle);
        if (this.mDialogTitle == null) {
            this.mDialogTitle = getTitle();
        }
        this.mDialogMessage = obtainStyledAttributes.getString(C1167k.MyDialogPreference_android_dialogMessage);
        this.mDialogIcon = obtainStyledAttributes.getDrawable(C1167k.MyDialogPreference_android_dialogIcon);
        this.mPositiveButtonText = obtainStyledAttributes.getString(C1167k.MyDialogPreference_android_positiveButtonText);
        this.mNegativeButtonText = obtainStyledAttributes.getString(C1167k.MyDialogPreference_android_negativeButtonText);
        this.mDialogLayoutResId = obtainStyledAttributes.getResourceId(C1167k.MyDialogPreference_android_dialogLayout, this.mDialogLayoutResId);
        obtainStyledAttributes.recycle();
    }

    private void requestInputMethod(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(21);
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public Drawable getDialogIcon() {
        return this.mDialogIcon;
    }

    public int getDialogLayoutResource() {
        return this.mDialogLayoutResId;
    }

    public CharSequence getDialogMessage() {
        return this.mDialogMessage;
    }

    public CharSequence getDialogTitle() {
        return this.mDialogTitle;
    }

    public CharSequence getNegativeButtonText() {
        return this.mNegativeButtonText;
    }

    public CharSequence getPositiveButtonText() {
        return this.mPositiveButtonText;
    }

    protected boolean needInputMethod() {
        return false;
    }

    public void onActivityDestroy() {
        if (this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    protected void onBindDialogView(View view) {
        View findViewById = view.findViewById(16908299);
        if (findViewById != null) {
            CharSequence dialogMessage = getDialogMessage();
            int i = 8;
            if (!TextUtils.isEmpty(dialogMessage)) {
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setText(dialogMessage);
                }
                i = 0;
            }
            if (findViewById.getVisibility() != i) {
                findViewById.setVisibility(i);
            }
        }
    }

    protected void onClick() {
        showDialog(null);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.mWhichButtonClicked = i;
    }

    protected View onCreateDialogView() {
        return this.mDialogLayoutResId == 0 ? null : ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.mDialogLayoutResId, null);
    }

    protected void onDialogClosed(boolean z) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        getPreferenceManager().unregisterOnActivityDestroyListener(this);
        this.mDialog = null;
        onDialogClosed(this.mWhichButtonClicked == -1);
    }

    protected void onPrepareDialogBuilder(Builder builder) {
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isDialogShowing) {
            showDialog(savedState.dialogBundle);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (this.mDialog == null || !this.mDialog.isShowing()) {
            return onSaveInstanceState;
        }
        Parcelable savedState = new SavedState(onSaveInstanceState);
        savedState.isDialogShowing = true;
        savedState.dialogBundle = this.mDialog.onSaveInstanceState();
        return savedState;
    }

    public void setDialogIcon(int i) {
        this.mDialogIcon = getContext().getResources().getDrawable(i);
    }

    public void setDialogIcon(Drawable drawable) {
        this.mDialogIcon = drawable;
    }

    public void setDialogLayoutResource(int i) {
        this.mDialogLayoutResId = i;
    }

    public void setDialogMessage(int i) {
        setDialogMessage(getContext().getString(i));
    }

    public void setDialogMessage(CharSequence charSequence) {
        this.mDialogMessage = charSequence;
    }

    public void setDialogTitle(int i) {
        setDialogTitle(getContext().getString(i));
    }

    public void setDialogTitle(CharSequence charSequence) {
        this.mDialogTitle = charSequence;
    }

    public void setNegativeButtonText(int i) {
        setNegativeButtonText(getContext().getString(i));
    }

    public void setNegativeButtonText(CharSequence charSequence) {
        this.mNegativeButtonText = charSequence;
    }

    public void setPositiveButtonText(int i) {
        setPositiveButtonText(getContext().getString(i));
    }

    public void setPositiveButtonText(CharSequence charSequence) {
        this.mPositiveButtonText = charSequence;
    }

    protected void showDialog(Bundle bundle) {
        Context context = getContext();
        this.mWhichButtonClicked = -2;
        this.mBuilder = new Builder(context).setTitle(this.mDialogTitle).setIcon(this.mDialogIcon).setPositiveButton(this.mPositiveButtonText, this).setNegativeButton(this.mNegativeButtonText, this);
        View onCreateDialogView = onCreateDialogView();
        if (onCreateDialogView != null) {
            onBindDialogView(onCreateDialogView);
            this.mBuilder.setView(onCreateDialogView);
        } else {
            this.mBuilder.setMessage(this.mDialogMessage);
        }
        onPrepareDialogBuilder(this.mBuilder);
        getPreferenceManager().registerOnActivityDestroyListener(this);
        Dialog create = this.mBuilder.create();
        this.mDialog = create;
        if (bundle != null) {
            create.onRestoreInstanceState(bundle);
        }
        if (needInputMethod()) {
            requestInputMethod(create);
        }
        create.setOnDismissListener(this);
        create.show();
    }
}
