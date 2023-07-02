package com.example.prueba.alertdialog;
import android.app.Activity;
import android.content.DialogInterface;
import com.example.prueba.MainActivity;
import com.example.prueba.R;



/**
 * Created by nuonuo-jtl on 16/10/29.
 */

public class ReiniciarDialog extends AlertDialog{


    @Override
    protected int[] setAlertDialog() {
        int[] s = new int[2];
        s[TITLE] = R.string.txtDialogoFinalTitulo;
        s[MESSAGE] = R.string.txtDialogoFinalPregunta;
        return  s;
    }

    @Override
    protected void onConfirmClick(Activity activity, DialogInterface dialog, int which) {
        MainActivity main = (MainActivity) activity;
        main.juego.reiniciar();
        main.mostrarTablero();
        main.inicialGameSettring();
    }

    @Override
    protected void onDenyClick(Activity activity, DialogInterface dialog, int which) {
        dialog.dismiss();

    }
}