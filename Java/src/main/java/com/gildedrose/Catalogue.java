package com.gildedrose;

import com.gildedrose.exceptions.ItemValidationException;

import java.util.Arrays;

public enum Catalogue implements Processable {
    APPLE("Apple"),
    ORANGE("Orange"),
    BRIE("Aged Brie") {
        @Override
        public Item process(Item item) {
            item.sellIn = item.sellIn--;
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
            return item;
        }
    },
    SULFARAS("Sulfuras, Hand of Ragnaros") {
        @Override
        public Item process(Item item) {
            if (item.quality != 80) {
                throw new ItemValidationException("Sulfaras quality has to be 80");
            }
            return item;
        }
    },
    BACKSTAGE_PASS("Backstage passes to a TAFKAL80ETC concert") {
        @Override
        public Item process(Item item) {
            item.sellIn = item.sellIn--;
            if (item.quality < 50) {
                item.quality = item.quality + 1;
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
            if (item.sellIn <=0) {
                item.quality = 0;
            }
            return item;
        }
    },
    CONJURED("Conjured Mana Cake") {
        @Override
        public Item process(Item item) {
            item.sellIn = item.sellIn--;
            if (item.quality >= 0) {
                item.quality = item.quality - 1;
                if (item.quality >= 0) {
                    item.quality = item.quality - 1;
                }
            }
            return item;
        }
    };

    private String name;

    Catalogue(String name) {
        this.name = name;
    }

    public static Catalogue withName(String name) {
        return Arrays.stream(Catalogue.values())
                .filter(catalogue -> catalogue.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new ItemValidationException("Item not found in catalogue"));
    }

    public String getName() {
        return name;
    }
}
