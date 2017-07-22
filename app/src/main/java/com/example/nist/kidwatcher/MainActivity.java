package com.example.nist.kidwatcher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
