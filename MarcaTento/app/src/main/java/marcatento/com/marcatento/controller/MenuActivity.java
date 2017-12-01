package marcatento.com.marcatento.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import marcatento.com.marcatento.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void abrirMarcador(View view){
        Intent intent = new Intent(MenuActivity.this,
                MarcadorActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        this.finish();
        startActivity(intent);
    }

    public void abrirHistorico(View view){
        Intent intent = new Intent(MenuActivity.this,
                HistoricoActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        this.finish();
        startActivity(intent);
    }
}
