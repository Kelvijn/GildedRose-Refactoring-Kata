package com.gildedrose;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return Arrays.asList(items);
    }

    public void updateQuality() {
        getItems().stream().map(item -> Catalogue.withName(item.name).process(item)).toArray(Item[]::new);
    }
}