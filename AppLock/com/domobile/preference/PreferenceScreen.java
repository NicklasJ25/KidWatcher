package com.domobile.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.domobile.preference.Preference.BaseSavedState;

public final class PreferenceScreen extends PreferenceGroup implements OnDismissListener, OnItemClickListener {
    private Dialog mDialog;
    private ListAdapter mRootAdapter;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C13961();
        Bundle dialogBundle;
        boolean isDialogShowing;

        static class C13961 implements Creator<SavedState> {
            C13961() {
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

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842891);
    }

    private void showDialog(Bundle bundle) {
        Context context = getContext();
        View listView = new ListView(context);
        bind(listView);
        CharSequence title = getTitle();
        Object dialog = new Dialog(context, TextUtils.isEmpty(title) ? 16973830 : 16973829);
        this.mDialog = dialog;
        dialog.setContentView(listView);
        if (!TextUtils.isEmpty(title)) {
            dialog.setTitle(title);
        }
        dialog.setOnDismissListener(this);
        if (bundle != null) {
            dialog.onRestoreInstanceState(bundle);
        }
        getPreferenceManager().addPreferencesScreen(dialog);
        dialog.show();
    }

    public void bind(ListView listView) {
        listView.setOnItemClickListener(this);
        listView.setAdapter(getRootAdapter());
        onAttachedToActivity();
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public ListAdapter getRootAdapter() {
        if (this.mRootAdapter == null) {
            this.mRootAdapter = onCreateRootAdapter();
        }
        return this.mRootAdapter;
    }

    protected boolean isOnSameScreenAsChildren() {
        return false;
    }

    protected void onClick() {
        if (getIntent() == null && getPreferenceCount() != 0) {
            showDialog(null);
        }
    }

    protected ListAdapter onCreateRootAdapter() {
        return new PreferenceGroupAdapter(this);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.mDialog = null;
        getPreferenceManager().removePreferencesScreen(dialogInterface);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Object item = getRootAdapter().getItem(i);
        if (item instanceof Preference) {
            ((Preference) item).performClick(this);
        }
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
        Dialog dialog = this.mDialog;
        if (dialog == null || !dialog.isShowing()) {
            return onSaveInstanceState;
        }
        Parcelable savedState = new SavedState(onSaveInstanceState);
        savedState.isDialogShowing = true;
        savedState.dialogBundle = dialog.onSaveInstanceState();
        return savedState;
    }
}
