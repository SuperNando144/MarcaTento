package marcatento.com.marcatento.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import marcatento.com.marcatento.R;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progress;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBarThread();
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarMenu();
            }
        }, 5000);

    }

    private void mostrarMenu() {
        Intent intent = new Intent(MainActivity.this,
                MenuActivity.class);
        startActivity(intent);
        finish();
    }

    public void progressBarThread(){
        progress = (ProgressBar) findViewById(R.id.progressBar);

        handler = new Handler();

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= 50; i++) {
                            final int value = i;
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progress.setProgress(value);
                                }
                            });
                        }
                    }
                };
                //executa a thread
                new Thread(runnable).start();



    }
}

