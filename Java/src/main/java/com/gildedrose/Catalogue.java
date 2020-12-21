package com.gildedrose;

public enum Catalogue implements Processable {
    APPLE("Apple"),
    ORANGE("Orange"),
    BRIE("Aged Brie") {
        @Override
        public Item process(Item item) {
            return item;
        }
    },
    SULFARAS("Sulfuras, Hand of Ragnaros") {
        @Override
        public Item process(Item item) {
            return item;
        }
    },
    BACKSTAGE_PASS("Backstage passes to a TAFKAL80ETC concert") {
        @Override
        public Item process(Item item) {
            return item;
        }
    },
    CONJURED("Conjured Mana Cake") {
        @Override
        public Item process(Item item) {
            return item;
        }
    };

    private String name;

    Catalogue(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
