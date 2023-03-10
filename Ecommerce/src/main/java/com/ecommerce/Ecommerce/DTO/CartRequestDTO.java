package com.ecommerce.Ecommerce.DTO;

public class CartRequestDTO
{


    private int customerId;
    private int productId;

    private int cardItemId;

    public int getCardItemId() {
        return cardItemId;
    }

    public void setCardItemId(int cardItemId) {
        this.cardItemId = cardItemId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }



}
