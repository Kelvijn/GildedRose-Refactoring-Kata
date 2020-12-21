package com.gildedrose;

public interface Processable {

    default Item process(Item item) {
        item.sellIn = item.sellIn - 1;
        if (item.quality > 0) {
            item.quality = item.quality - 1;
            if (item.sellIn <= 0) {
                item.quality = item.quality - 1;
            }
        }
        return item;
    }

}
