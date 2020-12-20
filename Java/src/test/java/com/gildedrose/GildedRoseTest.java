package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class GildedRoseTest {

    @Test
    void passageOfDayLowersSellInOfItem() {
        // Given
        Item[] items = new Item[]{new Item("normalItem", 10, 50)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).sellIn).isEqualTo(9);
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
