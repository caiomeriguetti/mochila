package br.com.faesa.mochila.tabela;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TableLayout;
import android.widget.Toast;

import br.com.faesa.mochila.R;
import br.com.faesa.mochila.global.MochilaUtil;
import br.com.faesa.mochila.global.Mockador;
import br.com.faesa.mochila.global.TableUtils;
import br.com.faesa.mochila.model.Item;
import br.com.faesa.mochila.model.Mochila;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TabelaActivity extends AppCompatActivity {

    @BindView(R.id.tblTabela)
    TableLayout tabela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabela);
        ButterKnife.bind(this);

        Mochila[][] mochilas = MochilaUtil.criarTabelaOO(Mockador.itens(), 25);
        TableUtils.montarTabela(tabela, mochilas, new TableUtils.Celulavel<Mochila>() {
            @Override
            public String getTexto(Mochila mochila) {
                return String.valueOf(mochila.getValor());
            }

            @Override
            public void onClick(Mochila mochila) {

                String joinIntens =  TextUtils.join(", ", mochila.getItens());

                Toast.makeText(TabelaActivity.this, joinIntens, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
