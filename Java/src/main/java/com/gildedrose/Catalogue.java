package com.gildedrose;

public enum Catalogue {
    BRIE("Aged Brie"),
    APPLE("Apple"),
    SULFARAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASS("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured")
    ;
    private String name;

    Catalogue(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
