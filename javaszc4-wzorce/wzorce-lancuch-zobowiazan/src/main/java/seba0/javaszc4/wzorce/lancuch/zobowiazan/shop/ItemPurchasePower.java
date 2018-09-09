package seba0.javaszc4.wzorce.lancuch.zobowiazan.shop;


import java.util.Optional;

public abstract class ItemPurchasePower {

    private Optional<ItemPurchasePower> successsor = Optional.empty();

    public Optional<ItemPurchasePower> getSuccesssor() {
        return successsor;
    }

    public void setSuccesssor(ItemPurchasePower successsor) {
        this.successsor = Optional.ofNullable(successsor);
    }

    public abstract boolean addItem(Item item, int count);

    public abstract boolean containsItem(Item item);

    public abstract Optional<Item> getItem(Item item);

    public void handleRequest(ItemPurchaseRequest request) {
        Item item = request.getItem();
        if (containsItem(item)) {
            request.setSeller(this);
        } else {
            successsor.ifPresent(e -> e.handleRequest(request));
        }
    }
}
