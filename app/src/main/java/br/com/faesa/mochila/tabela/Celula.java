package br.com.faesa.mochila.tabela;

import android.view.View;
import android.widget.TextView;

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;

import br.com.faesa.mochila.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wiliam on 4/23/18.
 */

class Celula extends AbstractViewHolder {

    @BindView(R.id.valorCelula)
    TextView valorCelula;

    public Celula(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
