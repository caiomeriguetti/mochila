package br.com.faesa.mochila.global;

import java.util.List;

import br.com.faesa.mochila.model.Item;

public class MochilaUtil {
    public static Integer[][] criarTabela(List<Item> itens, int capacidadeMochila){
        int n = itens.size();
        int W = capacidadeMochila;

        Integer[][] V = new Integer[n + 1][W + 1];

        for (int j = 0; j < V[0].length; j++) {
            V[0][j] = 0;
        }

        for (int i = 1; i < V.length; i++) {
            V[i][0] = 0;
            continue;
        }

        for (int i = 1; i <= n; i++) {
            for(int w = 1; w <= W; w ++) {
                if(itens.get(i-1).getPeso() <= w) {
                    V[i][w] = Math.max(V[i-1][w], itens.get(i-1).getValor() + V[i-1][w - itens.get(i-1).getPeso()]);
                } else {
                    V[i][w] = V[i - 1][w];
                }
            }
        }

        return V;
    }
}
