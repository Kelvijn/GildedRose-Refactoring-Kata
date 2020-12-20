package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.Catalogue.BRIE;
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
    void passageOfDayCountsHowManyDaysItemIsExpired() {
        // Given
        Item[] items = new Item[]{new Item("item", 0, 50)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).sellIn).isEqualTo(-1);
    }

    @Test
    void degradeQualityWhenDayHasPassed() {
        // Given
        Item[] items = new Item[]{new Item("item", 10, 50)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).quality).isEqualTo(49);
    }

    @Test
    void degradeQualityTwiceAsFastWhenSellDateHasPassed() {
        // Given
        Item[] items = new Item[]{new Item("item", 0, 50)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).quality).isEqualTo(48);
    }

    @Test
    void qualityOfItemCannotBeNegative() {
        // Given
        Item[] items = new Item[]{new Item("item", 0, 0)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).quality).isEqualTo(0);
    }

    @Test
    void agedBrieIncreasesInValueWhenDayHasPassed() {
        // Given
        Item[] items = new Item[]{new Item(BRIE, 20, 30)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).quality).isEqualTo(31);
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
