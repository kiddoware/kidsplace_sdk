package com.kiddoware.kidsplace.sdk.sample.app;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kiddoware.kidsplace.sdk.KPUtility;
import com.kiddoware.kidsplace.sdk.sample.R;

/**
 * Created by Shardul on 10/11/16.
 */

public class BasicSetupActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_setup);
    }

    public void startIntegration(View view) {
        KPUtility.handleKPIntegration(this, KPUtility.GOOGLE_MARKET);
    }
}
