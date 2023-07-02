package com.example.prueba.alertdialog;

import android.app.Activity;
import android.content.DialogInterface;

import com.example.prueba.Activities.ResultsListActivity;
import com.example.prueba.R;
import com.example.prueba.utils.FileUtils;


/**
 * Created by nuonuo-jtl on 16/10/30.
 */
public class DeleteDialog extends AlertDialog {
    @Override
    protected int[] setAlertDialog() {
        int[] s = new int[2];
        s[TITLE] = R.string.txtDeleteDialogoTitulo;
        s[MESSAGE] = R.string.txtDeleteDialogoPregunta;
        return  s;
    }

    @Override
    protected void onConfirmClick(Activity activity, DialogInterface dialog, int which) {
        new FileUtils(activity).deleteFile("SolitarioResults");
        ResultsListActivity resultsListActivity = (ResultsListActivity) activity;
        ((ResultsListActivity) activity).resultsAdapter.updateAdapter();
    }

    @Override
    protected void onDenyClick(Activity activity, DialogInterface dialog, int which) {
        dialog.dismiss();
    }
}