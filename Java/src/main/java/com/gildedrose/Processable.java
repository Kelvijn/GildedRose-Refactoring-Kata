package com.gildedrose;

public interface Processable {

    default Item process(Item item) {
        return item;
    }

}
