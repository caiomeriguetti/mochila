package br.com.faesa.mochila.global;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import br.com.faesa.mochila.R;
import br.com.faesa.mochila.model.Mochila;

/**
 * Created by wiliam on 4/16/18.
 */

public final class TableUtils {

    private TableUtils() {}

    public static <T> void montarTabela(TableLayout tabela, T[][] arrItens, final Celulavel<T> celulavel) {
        Context context = tabela.getContext();

        for (T[] itens : arrItens) {
            TableRow linha = new TableRow(context);
            linha.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

            for (final T item : itens) {
                TextView textView = new TextView(context);
                textView.setText(celulavel.getTexto(item));
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(MetricsUtils.pxToDp(context, 2), MetricsUtils.pxToDp(context, 2), MetricsUtils.pxToDp(context, 2), MetricsUtils.pxToDp(context, 2));
                textView.setLayoutParams(layoutParams);
                textView.setPadding(MetricsUtils.pxToDp(context, 12), MetricsUtils.pxToDp(context, 2), MetricsUtils.pxToDp(context, 12), MetricsUtils.pxToDp(context, 2));
                textView.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_cell));
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        celulavel.onClick(item);
                    }
                });

                linha.addView(textView);
            }

            tabela.addView(linha, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }

    public interface Celulavel<T> {
        String getTexto(T t);
        void onClick(T t);
    }


}
