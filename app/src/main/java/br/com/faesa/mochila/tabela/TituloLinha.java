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

class TituloLinha extends AbstractViewHolder {

    @BindView(R.id.valorLinha)
    TextView valorLinha;

    public TituloLinha(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
