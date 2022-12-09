package com.valoy.leaking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.valoy.leaking.usingProcessBackground.LeakClassicThread;
import com.valoy.leaking.usingProcessBackground.LeakHandlerActivity;
import com.valoy.leaking.usingProcessBackground.LeakRunnableActivity;
import com.valoy.leaking.usingProcessBackground.LeakThreadsActivity;
import com.valoy.leaking.usingStatic.LeakStaticInnerClass;
import com.valoy.leaking.usingStatic.LeakStaticVariableContextActivity;
import com.valoy.leaking.usingStatic.LeakStaticViewInActivity;
import com.valoy.leaking.usingStatic.LeakWithSingleton;

public class MainActivity extends AppCompatActivity {

    Button buttonLeakActivityStaticView;
    Button buttonLeakActivityStaticVariable;
    Button buttonLeakActivityContext;
    Button buttonLeakActivityToStaticVariableToInnerClass;
    Button buttonLeakActivityToInnerClassRunnable;
    Button buttonLeakActivityToHandler;
    Button buttonLeakActivityToAsyncTask;
    Button buttonLeakThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonLeakActivityStaticView = (Button) findViewById(R.id.buttonLeakActivityStaticView);
        buttonLeakActivityStaticView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakStaticViewInActivity.class);
                startActivity(intent);
            }
        });

        buttonLeakActivityStaticVariable = (Button) findViewById(R.id.buttonLeakActivityStaticVariable);
        buttonLeakActivityStaticVariable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakStaticVariableContextActivity.class);
                startActivity(intent);
            }
        });

        buttonLeakActivityContext = (Button) findViewById(R.id.buttonLeakActivityToSingleton);
        buttonLeakActivityContext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakWithSingleton.class);
                startActivity(intent);
            }
        });

        buttonLeakActivityToStaticVariableToInnerClass = (Button) findViewById(R.id.buttonLeakActivityToStaticVariableToInnerClass);
        buttonLeakActivityToStaticVariableToInnerClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakStaticInnerClass.class);
                startActivity(intent);
            }
        });

        buttonLeakActivityToInnerClassRunnable = (Button) findViewById(R.id.buttonLeakActivityToThread);
        buttonLeakActivityToInnerClassRunnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakClassicThread.class);
                startActivity(intent);
            }
        });

        buttonLeakActivityToHandler = (Button) findViewById(R.id.buttonLeakActivityToHandler);
        buttonLeakActivityToHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakHandlerActivity.class);
                startActivity(intent);
            }
        });

        buttonLeakActivityToAsyncTask = (Button) findViewById(R.id.buttonLeakActivityToAsyncTask);
        buttonLeakActivityToAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakRunnableActivity.class);
                startActivity(intent);
            }
        });

        buttonLeakThread = (Button) findViewById(R.id.buttonLeakThread);
        buttonLeakThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeakThreadsActivity.class);
                startActivity(intent);
            }
        });
    }
}