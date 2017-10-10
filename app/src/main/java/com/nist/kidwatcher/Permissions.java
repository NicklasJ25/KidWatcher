package com.nist.kidwatcher;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Process;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.app.AppOpsManager.MODE_ALLOWED;
import static android.app.AppOpsManager.OPSTR_GET_USAGE_STATS;

public class Permissions extends AppCompatActivity
{
    private static final int MY_PERMISSIONS_REQUEST = 1;
    private Activity activity;

    public Permissions(Activity activity)
    {
        this.activity = activity;
    }

    public void RequestPermissions(String permission)
    {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED)
        {
            // Should we show an explanation?
            boolean test = ActivityCompat.shouldShowRequestPermissionRationale(activity, permission);
            if (test)
            {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            }
            else
            {
                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(activity,
                        new String[]{permission},
                        MY_PERMISSIONS_REQUEST);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults)
    {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                }
                else
                {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public void RequestUsageAccess()
    {
        AppOpsManager appOps = (AppOpsManager) activity.getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow(OPSTR_GET_USAGE_STATS, Process.myUid(), activity.getPackageName());
        if (mode != MODE_ALLOWED)
        {
            final Dialog dialog = new Dialog(activity);
            dialog.setContentView(R.layout.custom_dialog);
            dialog.setTitle(R.string.usageAccessTitle);

            TextView text = (TextView) dialog.findViewById(R.id.textView);
            text.setText(R.string.usageAccessContent);

            Button cancelButton = (Button) dialog.findViewById(R.id.cancelButton);
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            Button okButton = (Button) dialog.findViewById(R.id.okButton);
            okButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS));
                    dialog.dismiss();
                }
            });

            dialog.show();
        }



    }
}
