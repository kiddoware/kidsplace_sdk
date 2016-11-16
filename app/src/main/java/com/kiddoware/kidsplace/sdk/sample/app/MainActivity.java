package com.kiddoware.kidsplace.sdk.sample.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.kiddoware.kidsplace.sdk.KPUtility;
import com.kiddoware.kidsplace.sdk.sample.R;

/**
 * Created by Shardul on 10/11/16.
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_setup);
    }

    public void startIntegration(View view) {
        KPUtility.handleKPIntegration(this, KPUtility.GOOGLE_MARKET);
    }

    public void pinRestricted(View view) {
        Intent intent = new Intent(this,CustomUI.class);
        startActivity(intent);
    }

    public void pinDialog(View view) {
        KPUtility.verifyPin(getSupportFragmentManager(), new KPUtility.PinDialogFragment.ValidationListener() {
            @Override
            public void onValidate(KPUtility.PinDialogFragment pinDialogFragment, boolean b) {
                Toast.makeText(MainActivity.this, "Authenticated: " + String.valueOf(b), Toast.LENGTH_LONG).show();
            }
        });
    }
}
