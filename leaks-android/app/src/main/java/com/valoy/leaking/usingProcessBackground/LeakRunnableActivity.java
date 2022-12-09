package com.valoy.leaking.usingProcessBackground;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;

import com.valoy.leaking.R;


/**
 * Activity con ejemplo clasico de fuga de memoria por una AsyncTask.
 * Para Fixear:
 *      1) Crear una clase static que herede de AsyncTask.
 *              La clase static no tiene referencias a la activity contenedora.
 *      2) Crear una variable global null de dicha clase creada
 *      3) Instanciar la variable global creada y ejecutarla en el onCreate
 *      4) Cancelar la AsyncTask, la variable global creada, en el metodo onDestroy() de la Activity.
 *      5) En el metodo "doInBackground(...)" de la AsyncTask tenemos que chequear si la tarea
 *            fue cancelada antes del siguiente loop.
 *                          protected Void doInBackground(Void... params) {
 *                                  while (!isCancelled()) {
 *                                      SystemClock.sleep(1000);
 *                                  }
 *                                  return null;
 *                          }
 */
public class LeakRunnableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_to_async_task);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                while (true) {
                    SystemClock.sleep(1000);
                }
            }
        }.execute();
    }
}
