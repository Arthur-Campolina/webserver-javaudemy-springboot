package com.webserver.webserver.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT("Aguardando Pagamento"),
    PAID("Pago"),
    SHIPPED("Enviado"),
    DELIVERED("Entregue"),
    CANCELED("Cancelado");

    private String description;

    private OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static OrderStatus content(String description) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getDescription().equals(description)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid order status!");
    }
}
