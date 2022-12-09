package com.valoy.leaking.usingStatic;

import android.content.Context;


public class ImportantSingleton {

    private static ImportantSingleton instance;
    private Context context;

    private ImportantSingleton(Context context) {
        this.context = context;
    }

    public static synchronized ImportantSingleton getInstance(Context context) {
        if (instance == null) {
            instance = new ImportantSingleton(context);
        }
        return instance;
    }

    public void unregister(Context context) {
        if (this.context == context) {
            this.context = null;
        }
    }
}
