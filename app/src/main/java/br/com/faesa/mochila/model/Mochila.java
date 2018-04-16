package br.com.faesa.mochila.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wiliam on 4/16/18.
 */

public class Mochila {
    private List<Item> itens;
    private int capacidade;
    private int valor;

    public Mochila(int capacidade) {
        this(new ArrayList(), capacidade);
    }

    public Mochila(List<Item> itens, int capacidade) {
        this.itens = itens;
        this.capacidade = capacidade;

        for (Item item : itens) {
            this.valor += item.getValor();
        }
    }

    public Mochila(Mochila mochila, Item item) {
        this.capacidade = mochila.getCapacidade() - item.getPeso();
        this.valor = mochila.getValor() + item.getValor();
        this.itens = mochila.getItens();
        this.itens.add(item);
    }

    public int getValor() {
        return valor;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public List<Item> getItens() {
        return itens;
    }
}
