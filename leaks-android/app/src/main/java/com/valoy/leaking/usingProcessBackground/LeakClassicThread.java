package com.valoy.leaking.usingProcessBackground;

import android.os.Bundle;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;

import com.valoy.leaking.R;


/**
 * Esta Activity crea y lanza una clase interna, que fuga memoria en la instancia Activity.
 * Las clases anónimas no estáticas tienen una referencia implícita a su clase adjunta.
 * Para Fixear, matar el thread  en el metodo onDestroy() y tambien hacer el Thread static,
 * asi no queda referencias a la activity contenedora.
 */
public class LeakClassicThread extends AppCompatActivity {

    private static final String TAG = "LeakThread";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leak_classic_thread);

        new MagicThreadLeaks().start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    private class MagicThreadLeaks extends Thread {
        @Override
        public void run() {
            while (true) {
                SystemClock.sleep(1000);
            }
        }
    }
}
