package com.nist.kidwatcher;

import android.Manifest;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

import static android.app.AppOpsManager.MODE_ALLOWED;
import static android.app.AppOpsManager.OPSTR_GET_USAGE_STATS;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Permissions permissions = new Permissions(this);
        permissions.RequestPermissions(Manifest.permission.RECEIVE_SMS);
        permissions.RequestUsageAccess();

        Switch startServiceSwitch = (Switch) findViewById(R.id.startServiceSwitch);
        startServiceSwitch.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        if (isChecked)
        {
            Intent intent = new Intent(this, MyService.class);
            startService(intent);
        }
        else
        {
            Intent intent = new Intent(this, MyService.class);
            stopService(intent);
        }
    }
}
