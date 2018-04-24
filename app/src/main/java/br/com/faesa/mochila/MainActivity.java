package br.com.faesa.mochila;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.com.faesa.mochila.global.Mockador;
import br.com.faesa.mochila.model.Item;
import br.com.faesa.mochila.tabela.TabelaActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mainItens)
    TextView txtItens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<Item> itens = Mockador.itens();
        StringBuilder stb = new StringBuilder();

        stb.append("[");

        for (int i = 0; i < itens.size(); i++) {
            Item item = itens.get(i);
            stb.append("\n")
                    .append("\t{")
                    .append("\"nome\": \"")
                    .append(item.getNome())
                    .append("\", \"valor\": ")
                    .append(item.getValor())
                    .append(", \"peso\": ")
                    .append(item.getPeso())
                    .append("}");

            if(i < itens.size() - 1) stb.append(",");
        }

        stb.append("\n]");

        txtItens.setText(stb);
    }

    @OnClick(R.id.mainProximo)
    void proximoOnClick(){
        startActivity(new Intent(this, TabelaActivity.class));
    }
}
