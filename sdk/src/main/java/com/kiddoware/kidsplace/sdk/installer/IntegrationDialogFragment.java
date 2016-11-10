package com.kiddoware.kidsplace.sdk.installer;

import android.support.v4.app.DialogFragment;

/**
 * Created by Shardul on 10/11/16.
 */

public class IntegrationDialogFragment extends DialogFragment {

    public static IntegrationDialogFragment newInstance(IntegrationRequestBuilder builder) {
        IntegrationDialogFragment fragment = new IntegrationDialogFragment();
        return fragment;
    }
}
