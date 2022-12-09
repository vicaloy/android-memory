package com.valoy.leaking.usingProcessBackground;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.valoy.leaking.R;

/**
 * LeakHandlerActivity
 * Esta actividad fuga la memoria de la Activity al Handler y a la clase interna.
 *
 * Para fixear en el metodo onDestroy eliminar el callback. Tambien, para el Runnable y el Handler, usar una
 * clase static en vez de una clase interna, ya que la clase static no
 * tiene referencias a la Activity contenedora.
 * Es decir, crear una clase static que herede de Handler y otra clase static que herede de Runnable
 * y luego crear variables globales de dichas clases creadas para posteriormente
 * hacer el postdelayed de la variable handler en el onCreate
 *
 */

public class LeakHandlerActivity extends AppCompatActivity {

    private static final String TAG = "LeakHandlerActivity";

    private final Handler mLeakyHandler = new Handler() {
        @Override
        public void handleMessage(Message message) {
            Log.d(TAG, "--- Inside handleMessage method: " + message + " ------");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_to_handler);

        mLeakyHandler.postDelayed(new Runnable() {   // postea un mensaje cada 5 minutos.
            @Override
            public void run() {
                Log.e(TAG, "--- Inside RUN method ------");
            }
        }, 1000 * 60 * 5);
    }
}
