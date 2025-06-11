package com.nisum.model;

public class CartItem {
    private Integer cartItemId;
    private Integer cartId;
    private Integer productId;
    private Integer quantity;
    private Double unitPrice;
    private Double discount;
    private Double finalPrice;

    private Product product;

    public Integer getCartItemId() {

        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {

        this.cartItemId = cartItemId;
    }

    public Integer getCartId() {

        return cartId;
    }

    public void setCartId(Integer cartId) {

        this.cartId = cartId;
    }

    public Integer getProductId() {

        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Product getProduct() {

        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
