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
        // Given

        // When

        // Then
    }

    @Test
    void degradeQualityTwiceAsFastWhenSellDateHasPassed() {
        // Given

        // When

        // Then
    }

    @Test
    void qualityOfItemCannotBeNegative() {
        // Given

        // When

        // Then
    }

    @Test
    void agedBrieIncreasesInValueWhenDayHasPassed() {
        // Given

        // When

        // Then
    }

    @Test
    void qualityOfItemCannotBeMoreThan50() {
        // Given

        // When

        // Then
    }

    @Test
    void sulfarasDoesNotDecreaseInQuality() {
        // Given

        // When

        // Then
    }

    @Test
    void sulfarasQualityCannotBeChanged() {
        // Given

        // When

        // Then
    }

    @Test
    void qualityOfBrieImprovesWhenSellInValueApproaches() {
        // Given

        // When

        // Then
    }

    @Test
    void qualityOfBrieIncreasesByTwoWhenSellInValueIsTenOrLess() {
        // Given

        // When

        // Then
    }

    @Test
    void qualityOfBrieDropsToZeroWhenExpired() {
        // Given

        // When

        // Then
    }

    @Test
    void conjuredItemsDegradeInQualityTwiceAsFast() {
        // Given

        // When

        // Then
    }
}
