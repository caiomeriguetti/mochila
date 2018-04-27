package br.com.faesa.mochila.tabela;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.evrencoskun.tableview.TableView;

import java.util.ArrayList;
import java.util.List;

import br.com.faesa.mochila.R;
import br.com.faesa.mochila.global.MochilaUtil;
import br.com.faesa.mochila.global.Mockador;
import br.com.faesa.mochila.model.Item;
import br.com.faesa.mochila.model.Mochila;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TabelaActivity extends AppCompatActivity {

    @BindView(R.id.tblTabela)
    TableView tabela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabela);
        ButterKnife.bind(this);

        TableViewAdapter adapter = new TableViewAdapter(this);
        tabela.setAdapter(adapter);

        int capacidade = 25;
        List<Item> itens = Mockador.itens();
        List<List<Mochila>> mochilas = MochilaUtil.criarTabelaLOO(itens, capacidade);

        List<Integer> titulosColuna = new ArrayList<>(capacidade);
        for (int i = 0; i <= capacidade; i++) {
            titulosColuna.add(i);
        }

        List<String> titulosLinha = new ArrayList<>(itens.size() + 1);
        titulosLinha.add("Inicial");
        for (int i = 0; i < itens.size(); i++) {
            titulosLinha.add(itens.get(i).getNome());
        }

        adapter.setAllItems(titulosColuna, titulosLinha, mochilas);
    }
}
