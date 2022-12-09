package com.valoy.leaking.usingStatic;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.valoy.leaking.R;

/**
 * Android Studio nos anuncia que no debemos tener una referencia static a una vista
 * Para Fixear, eliminar el modificador Static, Android Studio ayuda con un tip.
 */
public class LeakStaticViewInActivity extends AppCompatActivity {
    private static final String TAG = "StaticView";

    static TextView sampleTextViewLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sampleTextViewLabel = new TextView(this);
        sampleTextViewLabel.setText(getString(R.string.explicacion_static_view, getString(R.string.instruction_check_for_leaks)));

        setContentView(sampleTextViewLabel);

        Log.d(TAG, "------ eliminar el static de la variable ------");
    }


}
