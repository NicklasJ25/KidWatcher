package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.ArrayRes;
import android.support.annotation.AttrRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertController.AlertParams;
import android.support.v7.appcompat.C0280R;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AlertDialog extends AppCompatDialog implements DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    final AlertController mAlert;

    public static class Builder {
        private final AlertParams f12P;
        private final int mTheme;

        public Builder(@NonNull Context context) {
            this(context, AlertDialog.resolveDialogTheme(context, 0));
        }

        public Builder(@NonNull Context context, @StyleRes int i) {
            this.f12P = new AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, i)));
            this.mTheme = i;
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.f12P.mContext, this.mTheme);
            this.f12P.apply(alertDialog.mAlert);
            alertDialog.setCancelable(this.f12P.mCancelable);
            if (this.f12P.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f12P.mOnCancelListener);
            alertDialog.setOnDismissListener(this.f12P.mOnDismissListener);
            if (this.f12P.mOnKeyListener != null) {
                alertDialog.setOnKeyListener(this.f12P.mOnKeyListener);
            }
            return alertDialog;
        }

        @NonNull
        public Context getContext() {
            return this.f12P.mContext;
        }

        public Builder setAdapter(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.f12P.mAdapter = listAdapter;
            this.f12P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f12P.mCancelable = z;
            return this;
        }

        public Builder setCursor(Cursor cursor, OnClickListener onClickListener, String str) {
            this.f12P.mCursor = cursor;
            this.f12P.mLabelColumn = str;
            this.f12P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCustomTitle(@Nullable View view) {
            this.f12P.mCustomTitleView = view;
            return this;
        }

        public Builder setIcon(@DrawableRes int i) {
            this.f12P.mIconId = i;
            return this;
        }

        public Builder setIcon(@Nullable Drawable drawable) {
            this.f12P.mIcon = drawable;
            return this;
        }

        public Builder setIconAttribute(@AttrRes int i) {
            TypedValue typedValue = new TypedValue();
            this.f12P.mContext.getTheme().resolveAttribute(i, typedValue, true);
            this.f12P.mIconId = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean z) {
            this.f12P.mForceInverseBackground = z;
            return this;
        }

        public Builder setItems(@ArrayRes int i, OnClickListener onClickListener) {
            this.f12P.mItems = this.f12P.mContext.getResources().getTextArray(i);
            this.f12P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, OnClickListener onClickListener) {
            this.f12P.mItems = charSequenceArr;
            this.f12P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMessage(@StringRes int i) {
            this.f12P.mMessage = this.f12P.mContext.getText(i);
            return this;
        }

        public Builder setMessage(@Nullable CharSequence charSequence) {
            this.f12P.mMessage = charSequence;
            return this;
        }

        public Builder setMultiChoiceItems(@ArrayRes int i, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f12P.mItems = this.f12P.mContext.getResources().getTextArray(i);
            this.f12P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f12P.mCheckedItems = zArr;
            this.f12P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f12P.mCursor = cursor;
            this.f12P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f12P.mIsCheckedColumn = str;
            this.f12P.mLabelColumn = str2;
            this.f12P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f12P.mItems = charSequenceArr;
            this.f12P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f12P.mCheckedItems = zArr;
            this.f12P.mIsMultiChoice = true;
            return this;
        }

        public Builder setNegativeButton(@StringRes int i, OnClickListener onClickListener) {
            this.f12P.mNegativeButtonText = this.f12P.mContext.getText(i);
            this.f12P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f12P.mNegativeButtonText = charSequence;
            this.f12P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(@StringRes int i, OnClickListener onClickListener) {
            this.f12P.mNeutralButtonText = this.f12P.mContext.getText(i);
            this.f12P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f12P.mNeutralButtonText = charSequence;
            this.f12P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            this.f12P.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(OnDismissListener onDismissListener) {
            this.f12P.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
            this.f12P.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            this.f12P.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setPositiveButton(@StringRes int i, OnClickListener onClickListener) {
            this.f12P.mPositiveButtonText = this.f12P.mContext.getText(i);
            this.f12P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f12P.mPositiveButtonText = charSequence;
            this.f12P.mPositiveButtonListener = onClickListener;
            return this;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.f12P.mRecycleOnMeasure = z;
            return this;
        }

        public Builder setSingleChoiceItems(@ArrayRes int i, int i2, OnClickListener onClickListener) {
            this.f12P.mItems = this.f12P.mContext.getResources().getTextArray(i);
            this.f12P.mOnClickListener = onClickListener;
            this.f12P.mCheckedItem = i2;
            this.f12P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, OnClickListener onClickListener) {
            this.f12P.mCursor = cursor;
            this.f12P.mOnClickListener = onClickListener;
            this.f12P.mCheckedItem = i;
            this.f12P.mLabelColumn = str;
            this.f12P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, OnClickListener onClickListener) {
            this.f12P.mAdapter = listAdapter;
            this.f12P.mOnClickListener = onClickListener;
            this.f12P.mCheckedItem = i;
            this.f12P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, OnClickListener onClickListener) {
            this.f12P.mItems = charSequenceArr;
            this.f12P.mOnClickListener = onClickListener;
            this.f12P.mCheckedItem = i;
            this.f12P.mIsSingleChoice = true;
            return this;
        }

        public Builder setTitle(@StringRes int i) {
            this.f12P.mTitle = this.f12P.mContext.getText(i);
            return this;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            this.f12P.mTitle = charSequence;
            return this;
        }

        public Builder setView(int i) {
            this.f12P.mView = null;
            this.f12P.mViewLayoutResId = i;
            this.f12P.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view) {
            this.f12P.mView = view;
            this.f12P.mViewLayoutResId = 0;
            this.f12P.mViewSpacingSpecified = false;
            return this;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        @Deprecated
        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.f12P.mView = view;
            this.f12P.mViewLayoutResId = 0;
            this.f12P.mViewSpacingSpecified = true;
            this.f12P.mViewSpacingLeft = i;
            this.f12P.mViewSpacingTop = i2;
            this.f12P.mViewSpacingRight = i3;
            this.f12P.mViewSpacingBottom = i4;
            return this;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }
    }

    protected AlertDialog(@NonNull Context context) {
        this(context, 0);
    }

    protected AlertDialog(@NonNull Context context, @StyleRes int i) {
        super(context, resolveDialogTheme(context, i));
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    protected AlertDialog(@NonNull Context context, boolean z, @Nullable OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z);
        setOnCancelListener(onCancelListener);
    }

    static int resolveDialogTheme(@NonNull Context context, @StyleRes int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0280R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i) {
        return this.mAlert.getButton(i);
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.installContent();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mAlert.onKeyDown(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mAlert.onKeyUp(i, keyEvent) ? true : super.onKeyUp(i, keyEvent);
    }

    public void setButton(int i, CharSequence charSequence, OnClickListener onClickListener) {
        this.mAlert.setButton(i, charSequence, onClickListener, null);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.mAlert.setButton(i, charSequence, null, message);
    }

    void setButtonPanelLayoutHint(int i) {
        this.mAlert.setButtonPanelLayoutHint(i);
    }

    public void setCustomTitle(View view) {
        this.mAlert.setCustomTitle(view);
    }

    public void setIcon(int i) {
        this.mAlert.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.setIcon(drawable);
    }

    public void setIconAttribute(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.mAlert.setIcon(typedValue.resourceId);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.setMessage(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.setTitle(charSequence);
    }

    public void setView(View view) {
        this.mAlert.setView(view);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.mAlert.setView(view, i, i2, i3, i4);
    }
}
