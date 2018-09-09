package seba0.javaszc4.wzorce.lancuch.zobowiazan.shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Shop extends ItemPurchasePower {

    private final String name;
    private final Map<Item, Integer> itemsCounts = new HashMap<>();

    public Shop(String name) {
        this.name = name;
    }

    @Override
    public boolean addItem(Item item, int count) {
        Objects.requireNonNull(item);
        if (count < 1) {
            return false;
        }
        int actualCount = itemsCounts.getOrDefault(item, 0);
        itemsCounts.put(item, actualCount + count);
        return true;
    }

    @Override
    public boolean containsItem(Item item) {
        Objects.requireNonNull(item);
        return itemsCounts.getOrDefault(item, 0) > 0;
    }

    @Override
    public Optional<Item> getItem(Item item) {
        Objects.requireNonNull(item);
        int count = itemsCounts.getOrDefault(item, 0);
        if (count < 1) {
            return Optional.empty();
        } else if (count == 1) {
            itemsCounts.remove(item);
        } else {
            itemsCounts.put(item, count - 1);
        }
        return Optional.of(item);
    }

    @Override
    public String toString() {
        return name;
    }
}
