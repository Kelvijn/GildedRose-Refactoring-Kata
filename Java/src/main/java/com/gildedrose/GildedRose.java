package com.gildedrose;

import com.gildedrose.exceptions.ItemValidationException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return Arrays.asList(items);
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        List<String> catalogue = Arrays.stream(Catalogue.values()).map(Catalogue::getName).collect(Collectors.toList());

        boolean itemsAreAddedToCatalogue = getItems()
                .stream()
                .map(item -> item.name)
                .allMatch(catalogue::contains);

        if (!itemsAreAddedToCatalogue) {
            throw new ItemValidationException("Please add all items to catalogue");
        }

        setItems(getItems()
                .stream()
                .map(item -> Catalogue.withName(item.name).process(item))
                .toArray(Item[]::new));
    }
}