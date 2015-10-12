package com.rodico.duke0808.rodicobarcodescannerv20;

/**
 * Created by duke0808 on 12.10.15.
 */
public class Item {
    String barCode;
    String price;
    String quantity;

    @Override
    public String toString() {
        return barCode+"-"+price+"-"+quantity;
    }

    public Item(long barCode, int price, int quantity) {
        this.barCode = String.valueOf(barCode);
        this.price = String.valueOf(price);
        this.quantity = String.valueOf(quantity);
    }
}
