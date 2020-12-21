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

//        getItems().forEach(this::process);

        setItems(getItems()
                .stream()
                .map(item -> Catalogue.withName(item.name).process(item))
                .toArray(Item[]::new));
    }

    public void process(Item item) {
        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}