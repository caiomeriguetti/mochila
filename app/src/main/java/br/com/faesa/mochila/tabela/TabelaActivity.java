package br.com.faesa.mochila.tabela;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import br.com.faesa.mochila.R;
import br.com.faesa.mochila.global.MetricsUtils;
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

        List<String> lista1 = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h" );
        List<String> lista2 = Arrays.asList("aaaaaaaaaa", "bbbbbbbbb", "cccccccc", "ddddddd", "eeeeee", "fffff", "gggg", "hhh");
        List<String> lista3 = Arrays.asList("aa", "bb", "ccc", "dddd", "eeeee", "ffffff", "ggggggg", "hhhhhhhh");

        montarLinha(tabela, lista1);
        montarLinha(tabela, lista2);
        montarLinha(tabela, lista3);
        montarLinha(tabela, lista1);
        montarLinha(tabela, lista2);
        montarLinha(tabela, lista3);
        montarLinha(tabela, lista1);
        montarLinha(tabela, lista2);
        montarLinha(tabela, lista3);
        montarLinha(tabela, lista1);
        montarLinha(tabela, lista2);
        montarLinha(tabela, lista3);
        montarLinha(tabela, lista1);
        montarLinha(tabela, lista2);
        montarLinha(tabela, lista3);
        montarLinha(tabela, lista1);
        montarLinha(tabela, lista2);
        montarLinha(tabela, lista3);
        montarLinha(tabela, lista1);
        montarLinha(tabela, lista2);
        montarLinha(tabela, lista3);
    }


    private void montarLinha(TableLayout tabela, List<String> textos) {
        TableRow linha = new TableRow(this);
        linha.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

        for (int i = 0; i < textos.size(); i++) {
            TextView textView = new TextView(this);
            textView.setText(textos.get(i));
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(MetricsUtils.pxToDp(this, 2), MetricsUtils.pxToDp(this, 2), MetricsUtils.pxToDp(this, 2), MetricsUtils.pxToDp(this, 2));
            textView.setLayoutParams(layoutParams);
            textView.setPadding(MetricsUtils.pxToDp(this, 12), MetricsUtils.pxToDp(this, 2), MetricsUtils.pxToDp(this, 12), MetricsUtils.pxToDp(this, 2));
            textView.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_cell));

            linha.addView(textView);
        }

        tabela.addView(linha, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
    }
}
