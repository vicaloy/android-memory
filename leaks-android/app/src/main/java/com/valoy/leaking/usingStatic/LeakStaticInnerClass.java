package com.valoy.leaking.usingStatic;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.valoy.leaking.R;

/**
 * Esta Activity crea y lanza una clase interna, que fuga memoria en la instancia Activity ya que se declara
 * una variable global del tipo de clase interna como static.
 * Para Fixear, se puede remover el static de la variable CallBackListenerFromServer
 */

public class LeakStaticInnerClass extends AppCompatActivity {

    private static CallBackListenerFromServer listenerFromServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leak_static_inner_class);

        if (listenerFromServer == null) {
            listenerFromServer = new CallBackListenerFromServer();
        }
    }

    class CallBackListenerFromServer {
    }


}
