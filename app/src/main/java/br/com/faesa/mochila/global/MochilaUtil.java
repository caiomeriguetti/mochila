package br.com.faesa.mochila.global;

import java.util.List;

import br.com.faesa.mochila.model.Item;
import br.com.faesa.mochila.model.Mochila;

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

    public static Mochila[][] criarTabelaOO(List<Item> itens, int capacidadeMochila){
        int n = itens.size();
        int W = capacidadeMochila;

        Mochila[][] V = new Mochila[n + 1][W + 1];

        for (int j = 0; j < V[0].length; j++) {
            V[0][j] = new Mochila(W);
        }

        for (int i = 1; i < V.length; i++) {
            V[i][0] = new Mochila(W);
            continue;
        }

        for (int i = 1; i <= n; i++) {
            for(int w = 1; w <= W; w ++) {
                if(itens.get(i-1).getPeso() <= w) {
                    Mochila mochilaAcima = V[i - 1][w];
                    Mochila mochilaComItemDoIndice = new Mochila(V[i - 1][w- itens.get(i - 1).getPeso()], itens.get(i-1));

                    V[i][w] = mochilaMaisValiosa(mochilaAcima, mochilaComItemDoIndice);
                } else {
                    V[i][w] = V[i - 1][w];
                }
            }
        }

        return V;
    }

    private static Mochila mochilaMaisValiosa(Mochila mochila1, Mochila mochila2) {
        if(mochila1.getValor() > mochila2.getValor()) {
            return mochila1;
        } else {
            return mochila2;
        }
    }
}
