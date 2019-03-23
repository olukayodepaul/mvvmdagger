package com.mobiletraderv.paul.di.util;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class AppUtil {

    static Toast mToast;

    public static void showToast(Context context, String statusMsg) {
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(context, statusMsg, Toast.LENGTH_SHORT);
        mToast.show();
    }

    public static void showAlertDialog(Context context, String title, String msg, String buttons) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(title)
                .setMessage(msg)
                .setNegativeButton(buttons, (paramDialogInterface, paramInt) -> {
                });
        dialog.show();
    }

    public static void showAlertDialogWithIntent(Context context, String title, String msg, String buttons, Class object) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(title)
                .setMessage(msg)
                .setNegativeButton(buttons, (DialogInterface paramDialogInterface, int paramInt) -> {
                    Intent intent = new Intent(context, object);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(intent);
                });
        dialog.show();
    }

    public static boolean checkConnection(Context context) {
        return ((ConnectivityManager) context.getSystemService
                (Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }

}