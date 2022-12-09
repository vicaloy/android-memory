package com.valoy.leaking.usingStatic;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.valoy.leaking.R;

/**
 * Android Studio nos anuncia que no debemos tener una referencia static del Contexto
 * Para Fixear, eliminar el modificador Static, en caso de que sea aun necesario, usar WeakReference.
 */

public class LeakStaticVariableContextActivity extends AppCompatActivity {
    private static final String TAG = "StaticContext";

    static Activity activity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leak_context_activity_static_variable);
        TextView textView = (TextView) findViewById(R.id.textView);

        if (activity == null) {
            activity = this;
        }
    }


}
