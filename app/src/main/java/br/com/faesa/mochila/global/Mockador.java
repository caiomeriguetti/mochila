package br.com.faesa.mochila.global;

import java.util.Arrays;
import java.util.List;

import br.com.faesa.mochila.model.Item;

/**
 * Created by wiliam on 4/16/18.
 */

public class Mockador {
    public static List<Item> itens() {
        return Arrays.asList(
                new Item("Anel", 20, 4),
                new Item("Colar", 22, 6),
                new Item("Carteira", 14, 8),
                new Item("Camisa", 5, 10),
                new Item("Sapato", 30, 12),
                new Item("Meia", 1, 7),
                new Item("Carro", 1000, 1000),
                new Item("Relogio", 25, 9)
        );
    }
}
