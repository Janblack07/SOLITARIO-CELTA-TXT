package com.example.prueba.models;
import android.os.Handler;
import android.widget.Toast;

public class GameTimer {
    private static final long MAX_GAME_DURATION = 7 * 60 * 1000; // 5 minutos en milisegundos
    private long startTimeMillis;
    private long pauseTimeMillis;

    public void gameTimerStart() {
        startTimeMillis = System.currentTimeMillis() + MAX_GAME_DURATION;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gameTimerStop();
            }
        }, MAX_GAME_DURATION);
    }

    public String getTimerString() {
        String format = "%d%d:%d%d.%d%d";
        long time = startTimeMillis - System.currentTimeMillis();
        if (time <= 0) {
            return "00:00.00";

        }
        int min = (int) (time / 60000);
        int sec = (int) ((time - min * 60000) / 1000);
        int hun = (int) ((time - min * 60000 - sec * 1000) / 10);
        return String.format(format, min / 10, min % 10, sec / 10, sec % 10, hun / 10, hun % 10);
    }

    public boolean isTimeUp() {
        return System.currentTimeMillis() >= startTimeMillis;
    }

    private long setTimer(String s) {
        int minA = Integer.parseInt(s.charAt(0) + "");
        int minB = Integer.parseInt(s.charAt(1) + "");
        int secA = Integer.parseInt(s.charAt(3) + "");
        int secB = Integer.parseInt(s.charAt(4) + "");
        int hunA = Integer.parseInt(s.charAt(6) + "");
        int hunB = Integer.parseInt(s.charAt(7) + "");
        long millis = minA * 600000 + minB * 60000 + secA * 10000 + secB * 1000 + hunA * 100 + hunB * 10;
        return millis;
    }

    public void gameTimerRestartFromTimer(String s) {
        long millis = setTimer(s);
        startTimeMillis = System.currentTimeMillis() + millis;
    }

    public void gameTimerStop() {
        pauseTimeMillis = System.currentTimeMillis();

    }

    public void gameTimerRestart() {
        long nowTimeMillis = System.currentTimeMillis();
        startTimeMillis = nowTimeMillis + (startTimeMillis - pauseTimeMillis);
    }
}