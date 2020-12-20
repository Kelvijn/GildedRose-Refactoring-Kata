package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    void degradeQualityWhenDayHasPassed() {

    }

    @Test
    void degradeQualityTwiceAsFastWhenSellDateHasPassed() {

    }

    @Test
    void qualityOfItemCannotBeNegative() {

    }

    @Test
    void agedBrieIncreasesInValueWhenDayHasPassed() {

    }

    @Test
    void qualityOfItemCannotBeMoreThan50() {

    }

    @Test
    void sulfarasDoesNotDecreaseInQuality() {

    }

    @Test
    void sulfarasQualityCannotBeChanged() {

    }

    @Test
    void qualityOfBrieImprovesWhenSellInValueApproaches() {

    }

    @Test
    void qualityOfBrieIncreasesByTwoWhenSellInValueIsTenOrLess() {

    }

    @Test
    void qualityOfBrieDropsToZeroWhenExpired() {

    }

    @Test
    void conjuredItemsDegradeInQualityTwiceAsFast() {

    }




}
