package marcatento.com.marcatento.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import marcatento.com.marcatento.R;
import marcatento.com.marcatento.bll.TrucoBLL;
import marcatento.com.marcatento.model.Truco;

public class MarcadorActivity extends AppCompatActivity {
    public TrucoBLL trucoBLL;
    public Truco truco;
    //TEXT VIEWS
    public TextView textViewNos,
            textViewEles,
            textViewPlaceholder;

    //BUTTONS
    public Button buttonMaisNos,
            buttonMaisEles,
            buttonMenosNos,
            buttonMenosEles,
            buttonMaisTres,
            buttonMaisSeis,
            buttonMaisNove,
            buttonMaisDoze;

    protected Vibrator vibrator;

    protected AlertDialog.Builder mensagem;
    protected Chronometer cronometro;

    protected boolean pausado = false;
    protected long time = 0;

    public Integer pontosEles = null;
    public Integer pontosNos = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        trucoBLL = new TrucoBLL(this);
        truco = new Truco();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcador);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        textViewEles = (TextView) findViewById(R.id.marcadorEles);
        textViewNos = (TextView) findViewById(R.id.marcadorNos);
        textViewPlaceholder = (TextView) findViewById(R.id.placeholder);
        buttonMaisNos = (Button) findViewById(R.id.btnMaisNos);
        buttonMaisEles = (Button) findViewById(R.id.btnMaisEles);
        buttonMenosNos = (Button) findViewById(R.id.btnMenosNos);
        buttonMenosEles = (Button) findViewById(R.id.btnMenosEles);
        buttonMaisTres = (Button) findViewById(R.id.btnMais3);
        buttonMaisSeis = (Button) findViewById(R.id.btnMais6);
        buttonMaisNove = (Button) findViewById(R.id.btnMais9);
        buttonMaisDoze = (Button) findViewById(R.id.btnMais12);
        cronometro = (Chronometer) findViewById(R.id.cronometro);
        cronometro.setBase(SystemClock.elapsedRealtime());
        cronometro.start();
    }


    public void adicionarPtsNos(View view) {
        pontosNos = Integer.parseInt(textViewNos.getText().toString());
        if (pontosNos == 12) {
            finalizarJogo(1);
        } else {
            pontosNos++;
            textViewNos.setText(pontosNos.toString());
        }

    }

    public void retirarPtsNos(View view) {
        pontosNos = Integer.parseInt(textViewNos.getText().toString());
        if (pontosNos != 0) {
            pontosNos--;
            textViewNos.setText(pontosNos.toString());
        }
    }

    public void adicionarPtsEles(View view) {
        pontosEles = Integer.parseInt(textViewEles.getText().toString());
        if (pontosEles == 12) {
            finalizarJogo(2);
        } else {
            pontosEles++;
            textViewEles.setText(pontosEles.toString());
        }
    }

    public void retirarPtsEles(View view) {
        pontosEles = Integer.parseInt(textViewEles.getText().toString());
        if (pontosEles != 0) {
            pontosEles--;
            textViewEles.setText(pontosEles.toString());
        }
    }

    public void adicionarTres(View view) {
        vibrator.vibrate(1000);
        mensagem = new AlertDialog.Builder(this);
        pontosEles = Integer.parseInt(textViewEles.getText().toString());
        pontosNos = Integer.parseInt(textViewNos.getText().toString());
        if (pontosEles == 11 || pontosNos == 11) {
            mensagem.setTitle("Erro!");
            mensagem.setNeutralButton("OK", null);
            mensagem.setMessage("Você não pode trucar em mão de 11!");
            mensagem.show();
        } else {
            mensagem.setTitle("Truco!");
            mensagem.setPositiveButton("Nós", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    pontosNos += 3;
                    textViewNos.setText(pontosNos.toString());

                    if(pontosNos>=12){
                        finalizarJogo(1);
                    }
                }
            });
            mensagem.setNegativeButton("Eles", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    pontosEles += 3;
                    textViewEles.setText(pontosEles.toString());

                    if(pontosEles>=12){
                        finalizarJogo(2);
                    }
                }
            });
            mensagem.setMessage("Para quem são os pontos?");
            mensagem.show();
        }
    }

    public void adicionarSeis(View view) {
        vibrator.vibrate(1000);
        mensagem = new AlertDialog.Builder(this);
        pontosEles = Integer.parseInt(textViewEles.getText().toString());
        pontosNos = Integer.parseInt(textViewNos.getText().toString());
        if (pontosEles == 11 || pontosNos == 11) {
            mensagem.setTitle("Erro!");
            mensagem.setNeutralButton("OK", null);
            mensagem.setMessage("Você não pode trucar em mão de 11!");
            mensagem.show();
        } else {
            mensagem.setTitle("Truco!");
            mensagem.setPositiveButton("Nós", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    pontosNos += 6;
                    textViewNos.setText(pontosNos.toString());

                    if(pontosNos>=12){
                        finalizarJogo(1);
                    }
                }
            });
            mensagem.setNegativeButton("Eles", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    pontosEles += 6;
                    textViewEles.setText(pontosEles.toString());

                    if(pontosEles>=12){
                        finalizarJogo(2);
                    }
                }
            });
            mensagem.setMessage("Para quem são os pontos?");
            mensagem.show();
        }
    }

    public void adicionarNove(View view) {
        vibrator.vibrate(1000);
        mensagem = new AlertDialog.Builder(this);
        pontosEles = Integer.parseInt(textViewEles.getText().toString());
        pontosNos = Integer.parseInt(textViewNos.getText().toString());
        if (pontosEles == 11 || pontosNos == 11) {
            mensagem.setTitle("Erro!");
            mensagem.setNeutralButton("OK", null);
            mensagem.setMessage("Você não pode trucar em mão de 11!");
            mensagem.show();
        } else {
            mensagem.setTitle("Truco!");
            mensagem.setPositiveButton("Nós", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    pontosNos += 9;
                    textViewNos.setText(pontosNos.toString());

                    if(pontosNos>=12){
                        finalizarJogo(1);
                    }
                }
            });
            mensagem.setNegativeButton("Eles", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    pontosEles += 9;
                    textViewEles.setText(pontosEles.toString());

                    if(pontosEles>=12){
                        finalizarJogo(2);
                    }
                }
            });
            mensagem.setMessage("Para quem são os pontos?");
            mensagem.show();
        }
    }

    public void adicionarDoze(View view) {
        vibrator.vibrate(1000);
        mensagem = new AlertDialog.Builder(this);
        pontosEles = Integer.parseInt(textViewEles.getText().toString());
        pontosNos = Integer.parseInt(textViewNos.getText().toString());
        if (pontosEles == 11 || pontosNos == 11) {
            mensagem.setTitle("Erro!");
            mensagem.setNeutralButton("OK", null);
            mensagem.setMessage("Você não pode trucar em mão de 11!");
            mensagem.show();
        } else {
            mensagem.setTitle("Truco!");
            mensagem.setPositiveButton("Nós", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finalizarJogo(1);
                }
            });
            mensagem.setNegativeButton("Eles", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finalizarJogo(2);
                }
            });
            mensagem.setMessage("Para quem são os pontos?");
            mensagem.show();
        }
    }

    public void finalizarJogo(int i){
        pontosEles = Integer.parseInt(textViewEles.getText().toString());
        pontosNos = Integer.parseInt(textViewNos.getText().toString());

        cronometro.stop();

        vibrator.vibrate(1500);
        buttonMaisNos.setEnabled(false);
        buttonMaisEles.setEnabled(false);
        buttonMenosNos.setEnabled(false);
        buttonMenosEles.setEnabled(false);
        buttonMaisTres.setEnabled(false);
        buttonMaisSeis.setEnabled(false);
        buttonMaisNove.setEnabled(false);
        buttonMaisDoze.setEnabled(false);

        if(i==1){
            textViewPlaceholder.setText("Vencedores: Nós");
            textViewPlaceholder.setTextColor(ResourcesCompat.getColor(getResources(),R.color.darkRed,null));
            truco.setVencedor(1);
        }else{
            textViewPlaceholder.setText("Vencedores: Eles");
            textViewPlaceholder.setTextColor(ResourcesCompat.getColor(getResources(),R.color.black,null));
            truco.setVencedor(2);

        }
        truco.setPontosNos(pontosNos);
        truco.setPontosEles(pontosEles);
        truco.setDuracao(cronometro.getText().toString());
        trucoBLL.gravar(truco);
    }

    public void voltar(View view) {
        Intent intent = new Intent(MarcadorActivity.this,
                MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        this.finish();
        startActivity(intent);
    }

}
