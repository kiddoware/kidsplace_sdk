package com.kiddoware.kidsplace.sdk.sample.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kiddoware.kidsplace.sdk.KPUtility;
import com.kiddoware.kidsplace.sdk.sample.R;

/**
 * Created by Shardul on 17/08/16.
 */
public class CustomUI extends AppCompatActivity {

    private static final String DELETE_TAG = "D";
    private static final String ENTER_TAG = "E";

    private TextView mDescriptionTextView;
    private String pin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom_ui);

        mDescriptionTextView = (TextView) findViewById(R.id.launch_desc);

        mDescriptionTextView.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }


    public void actionButtonClicked(View view) {
        unlock();
    }

    public void pinButtonClicked(View view) {

        if (view instanceof Button) {
            Button button = (Button) view;
            try {
                int number = Integer.parseInt(button.getText().toString());

                mDescriptionTextView.append("" + number);

                pin = mDescriptionTextView.getText().toString();


            } catch (NumberFormatException e) {
                if (DELETE_TAG.equals(view.getTag())) {
                    if (pin != null && pin.length() > 0) {
                        pin = pin.substring(0, pin.length() - 1);
                        mDescriptionTextView.setText(pin);
                    }
                } else if (ENTER_TAG.equals(view.getTag())) {
                    unlock();
                }
            }
        } else {
            if (DELETE_TAG.equals(view.getTag())) {
                if (pin != null && pin.length() > 0) {
                    pin = pin.substring(0, pin.length() - 1);
                    mDescriptionTextView.setText(pin);
                }
            } else if (ENTER_TAG.equals(view.getTag())) {
                unlock();
            }
        }

    }

    private boolean validatePin() {
        return KPUtility.validatePin(this, pin);
    }

    private void unlock() {
        if (!KPUtility.isKidsPlaceRunning(this)) {
            KPUtility.handleKPIntegration(this,KPUtility.GOOGLE_MARKET);
            return;
        }
        if (validatePin()) {
            Toast.makeText(this, "Validation successfull, start your feature.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Invalid Pin", Toast.LENGTH_LONG).show();
        }
    }
}
