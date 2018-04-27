package br.com.faesa.mochila.tabela;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.evrencoskun.tableview.adapter.AbstractTableAdapter;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;

import br.com.faesa.mochila.R;
import br.com.faesa.mochila.model.Mochila;

/**
 * Created by wiliam on 4/23/18.
 */

public class TableViewAdapter extends AbstractTableAdapter<Integer, String, Mochila> {

    private LayoutInflater inflater;

    public TableViewAdapter(Context context) {
        super(context);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateCellViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.celula, parent, false);
        return new Celula(layout);
    }

    @Override
    public void onBindCellViewHolder(AbstractViewHolder holder, Object cellItemModel, int columnPosition, int rowPosition) {
        Mochila mochila = (Mochila)cellItemModel;

        Celula viewHolder = (Celula) holder;
        viewHolder.valorCelula.setText(String.valueOf(mochila.getValor()));

        viewHolder.itemView.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
        viewHolder.valorCelula.requestLayout();
    }

    @Override
    public RecyclerView.ViewHolder onCreateColumnHeaderViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.titulo_colula, parent, false);
        return new TituloColuna(layout);
    }

    @Override
    public void onBindColumnHeaderViewHolder(AbstractViewHolder holder, Object columnHeaderItemModel, int columnPosition) {
        TituloColuna viewHolder = (TituloColuna) holder;
        viewHolder.valorColuna.setText(String.valueOf(columnPosition));

        viewHolder.itemView.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
        viewHolder.valorColuna.requestLayout();
    }

    @Override
    public RecyclerView.ViewHolder onCreateRowHeaderViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.titulo_linha, parent, false);
        return new TituloLinha(layout);
    }

    @Override
    public void onBindRowHeaderViewHolder(AbstractViewHolder holder, Object rowHeaderItemModel, int rowPosition) {
        String item = (String)rowHeaderItemModel;

        TituloLinha viewHolder = (TituloLinha) holder;
        viewHolder.valorLinha.setText(item);
    }

    @Override
    public View onCreateCornerView() {
        return inflater.inflate(R.layout.quina, null);
    }



    @Override
    public int getColumnHeaderItemViewType(int position) {
        return 0;
    }

    @Override
    public int getRowHeaderItemViewType(int position) {
        return 0;
    }

    @Override
    public int getCellItemViewType(int position) {
        return 0;
    }

}
