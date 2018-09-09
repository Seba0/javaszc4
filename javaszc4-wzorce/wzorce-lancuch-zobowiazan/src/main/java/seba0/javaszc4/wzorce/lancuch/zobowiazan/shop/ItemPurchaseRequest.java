package seba0.javaszc4.wzorce.lancuch.zobowiazan.shop;

import java.util.Optional;

public class ItemPurchaseRequest {
    private final Item item;
    private Optional<ItemPurchasePower> seller = Optional.empty();

    public ItemPurchaseRequest(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setSeller(ItemPurchasePower seller) {
        this.seller = Optional.ofNullable(seller);
    }

    public Optional<ItemPurchasePower> getSeller() {
        return seller;
    }

    @Override
    public String toString() {
        return seller
                .map(x -> x + " can sell " + item)
                .orElse("Unable to find seller of " + item);
    }
}
