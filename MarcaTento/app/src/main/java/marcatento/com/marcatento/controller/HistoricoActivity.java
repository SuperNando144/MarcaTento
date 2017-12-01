package marcatento.com.marcatento.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import marcatento.com.marcatento.R;
import marcatento.com.marcatento.bll.TrucoBLL;
import marcatento.com.marcatento.model.Truco;

public class HistoricoActivity extends AppCompatActivity {

    protected TextView txtVencedor,
            txtNos,
            txtEles,
            txtDuracao;

    protected Button buttonAnterior,
            buttonProximo;

    public TrucoBLL trucoBLL;
    public Truco truco;

    private ArrayList<Truco> listaJogos = new ArrayList<Truco>();
    private Integer atual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
        trucoBLL = new TrucoBLL(this);
        truco = new Truco();

        txtVencedor = (TextView) findViewById(R.id.txtVencedor);
        txtNos = (TextView) findViewById(R.id.txtNos);
        txtEles = (TextView) findViewById(R.id.txtEles);
        txtDuracao = (TextView) findViewById(R.id.txtDuracao);
        buttonAnterior = (Button) findViewById(R.id.buttonAnterior);
        buttonProximo = (Button) findViewById(R.id.buttonProximo);
        listaJogos = trucoBLL.recuperarTodos();
        if(listaJogos.isEmpty()){
            buttonAnterior.setEnabled(false);
            buttonProximo.setEnabled(false);
        }
    }

    public void pesquisar(View view) {
        if(listaJogos.isEmpty()){
            txtVencedor.setText("Não disponível");
            txtNos.setText("Não disponível");
            txtEles.setText("Não disponível");
            txtDuracao.setText("Não disponível");
        }else{
            atual = 0;
            txtVencedor.setText(vencedor(listaJogos.get(atual).getVencedor()));
            txtNos.setText(listaJogos.get(atual).getPontosNos().toString());
            txtEles.setText(listaJogos.get(atual).getPontosEles().toString());
            txtDuracao.setText(listaJogos.get(atual).getDuracao());
        }
    }

    public void anterior(View view) {
        if(atual!=0){
            atual--;
            txtVencedor.setText(vencedor(listaJogos.get(atual).getVencedor()));
            txtNos.setText(listaJogos.get(atual).getPontosNos().toString());
            txtEles.setText(listaJogos.get(atual).getPontosEles().toString());
            txtDuracao.setText(listaJogos.get(atual).getDuracao());
        }
    }

    public void proximo(View view) {
        if(atual!=listaJogos.size()-1){
            atual++;
            txtVencedor.setText(vencedor(listaJogos.get(atual).getVencedor()));
            txtNos.setText(listaJogos.get(atual).getPontosNos().toString());
            txtEles.setText(listaJogos.get(atual).getPontosEles().toString());
            txtDuracao.setText(listaJogos.get(atual).getDuracao());
        }
    }

    public String vencedor(Integer venc){
        if(venc==1){
            return "Nós";
        }else{
            return "Eles";
        }
    }

    public void voltar(View view) {
        Intent intent = new Intent(HistoricoActivity.this,
                MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        this.finish();
        startActivity(intent);
    }
}
