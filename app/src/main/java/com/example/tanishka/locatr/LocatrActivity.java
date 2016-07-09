package com.example.tanishka.locatr;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Connection;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class LocatrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locatr);
        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment=fragmentManager.findFragmentById(R.id.frame);
        if (fragment==null)
            fragmentManager.beginTransaction().replace(R.id.frame,LocatrFragment.newInstance(),"LocatrFragment").commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
     int errorCode= GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if(errorCode!= ConnectionResult.SUCCESS){
            Dialog errorDialog=GooglePlayServicesUtil.getErrorDialog(errorCode,this,0, new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                finish();
                }
            });
        errorDialog.show();
        }
    }
}
