package com.example.prueba.alertdialog;

import android.app.Activity;
import android.content.DialogInterface;
import com.example.prueba.MainActivity;
import com.example.prueba.R;



/**
 * Created by nuonuo-jtl on 16/10/29.
 */
public class RestartDialog extends AlertDialog {

    @Override
    protected int[] setAlertDialog() {
        int[] i = new int[2];
        i[AlertDialog.TITLE] = R.string.txtDialogoFinalTitulo;
        i[AlertDialog.MESSAGE] = R.string.txtDialogoFinalPregunta;
        return i;
    }

    @Override
    protected void onConfirmClick(Activity activity, DialogInterface dialog, int which) {
        MainActivity main = (MainActivity) activity;
        main.juego.reiniciar();
        main.mostrarTablero();
    }

    @Override
    protected void onDenyClick(Activity activity, DialogInterface dialog, int which) {
        MainActivity main = (MainActivity) activity;
        main.finish();
    }

}