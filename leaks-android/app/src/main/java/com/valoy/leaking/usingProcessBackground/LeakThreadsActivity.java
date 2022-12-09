package com.valoy.leaking.usingProcessBackground;

import android.os.Bundle;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;

import com.valoy.leaking.R;

/**
 * Activity que lanza y crea un Thread, pero que nunca lo termina cuando es destruida la activity.
 * Para fixear hay que hacer un interrupt() del thread en el onDestroy de la activity
 */
public class LeakThreadsActivity extends AppCompatActivity {

    private MagicThreadLeaks magicThreadLeaks; // tambien puede ser variable local

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_thread);

        magicThreadLeaks = new MagicThreadLeaks();
        magicThreadLeaks.start();
    }

    private static class MagicThreadLeaks extends Thread {

        @Override
        public void run() {
            while (true) {
                SystemClock.sleep(5000);
            }
        }

    }

}
