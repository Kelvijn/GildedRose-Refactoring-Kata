package com.gildedrose;

import com.gildedrose.exceptions.ItemValidationException;
import org.junit.jupiter.api.Test;

import static com.gildedrose.Catalogue.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


class GildedRoseTest {

    @Test
    void passageOfDayLowersSellInOfItem() {
        // Given
        Item[] items = new Item[]{new Item(APPLE.getName(), 10, 50)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).sellIn).isEqualTo(9);
    }

    @Test
    void passageOfDayCountsHowManyDaysItemIsExpired() {
        // Given
        Item[] items = new Item[]{new Item(APPLE.getName(), 0, 50)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).sellIn).isEqualTo(-1);
    }

    @Test
    void degradeQualityWhenDayHasPassed() {
        // Given
        Item[] items = new Item[]{new Item(APPLE.getName(), 10, 50)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).quality).isEqualTo(49);
    }

    @Test
    void degradeQualityTwiceAsFastWhenSellDateHasPassed() {
        // Given
        Item[] items = new Item[]{new Item(APPLE.getName(), 0, 50)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).quality).isEqualTo(48);
    }

    @Test
    void qualityOfItemCannotBeNegative() {
        // Given
        Item[] items = new Item[]{new Item(APPLE.getName(), 0, 0)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).quality).isEqualTo(0);
    }

    @Test
    void agedBrieIncreasesInValueWhenDayHasPassed() {
        // Given
        Item[] items = new Item[]{new Item(BRIE.getName(), 20, 30)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).quality).isEqualTo(31);
    }

    @Test
    void qualityOfItemCannotBeMoreThan50() {
        // Given
        Item[] items = new Item[]{new Item(BRIE.getName(), 5, 50)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).quality).isEqualTo(50);
    }

    @Test
    void sulfarasDoesNotDecreaseInQuality() {
        // Given
        Item[] items = new Item[]{new Item(SULFARAS.getName(), 0, 80)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).quality).isEqualTo(80);
    }

    @Test
    void failWhenItemsContainsSulfarasQualityIsNot80() {
        // Given
        Item[] items = new Item[]{new Item(SULFARAS.getName(), 0, 60)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        Throwable thrown = catchThrowable(gildedRose::updateQuality);

        // Then
        assertThat(thrown).isInstanceOf(ItemValidationException.class);
    }

    @Test
    void qualityOfBackStagePassIncreasesByOne() {
        // Given
        Item[] items = new Item[]{new Item(BACKSTAGE_PASS.getName(), 20, 30)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).quality).isEqualTo(31);
    }

    @Test
    void qualityOfBackStagePassIncreasesByTwoWhenSellInIsTenOrLess() {
        // Given
        Item[] items = new Item[]{new Item(BACKSTAGE_PASS.getName(), 10, 30)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).quality).isEqualTo(32);
    }

    @Test
    void qualityOfBackStagePassIncreasesByThreeWhenSellInIsFiveOrLess() {
        // Given
        Item[] items = new Item[]{new Item(BACKSTAGE_PASS.getName(), 5, 30)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).quality).isEqualTo(33);
    }

    @Test
    void qualityOfBackStagePassDropsToZeroWhenConcertHasPassed() {
        // Given
        Item[] items = new Item[]{new Item(BACKSTAGE_PASS.getName(), 0, 30)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).quality).isEqualTo(0);
    }

    @Test
    void conjuredItemDegradeTwiceAsFast() {
        // Given
        Item[] items = new Item[]{new Item(CONJURED.getName(), 10, 30)};
        GildedRose gildedRose = new GildedRose(items);

        // When
        gildedRose.updateQuality();

        // Then
        assertThat(gildedRose.getItems().get(0).quality).isEqualTo(28);
    }
}
