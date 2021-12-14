//# COMP 4521    #  TO, Kai Yuen 20410782 kytoac@connect.ust.hk
//# COMP 4521    #  WONG, Lap Wong 20602036 lwwongaf@connect.ust.hk

package com.example.sportsfacilitiesfinderhk.utilities;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.example.sportsfacilitiesfinderhk.ui.MainActivity;

public class AlertHelper {
    public static void showErrorAlert(Context context, String errorMsg) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage(errorMsg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public static void showSimpleAlert(Context context,String title, String errorMsg) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(errorMsg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
