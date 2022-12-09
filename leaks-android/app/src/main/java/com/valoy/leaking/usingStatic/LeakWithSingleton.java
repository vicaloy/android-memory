package com.valoy.leaking.usingStatic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.valoy.leaking.R;

/**
 * Aca tenemos 2 opciones para fixear la fuga de memoria:
 *      1) Pasar al Singleton el contexto de la aplicacion, en lugar del contexto de Activity
 *      2) En el metodo onDestroy() realizar un unregister()
 */

public class LeakWithSingleton extends AppCompatActivity {

    private static final String TAG = "LeakSingleton";

    ImportantSingleton importantSingleton = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leak_with_singleton);

        importantSingleton = ImportantSingleton.getInstance(this);
    }


}
