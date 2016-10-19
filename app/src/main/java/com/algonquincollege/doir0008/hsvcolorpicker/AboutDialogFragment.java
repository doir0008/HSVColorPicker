/**
 *  HSV Color Picker App - adjustable hue, saturation, value/lightness channels with
 *  a select range of color quick buttons.
 *  @author Ryan Doiron (doir0008@algonquinlive.com)
 *  */
package com.algonquincollege.doir0008.hsvcolorpicker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class AboutDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("About")
                .setMessage("Ryan Doiron (doir0008)")
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }
}
