package com.ytt.springcoredemo.model.enumeration;

public enum OrderState {

    UNKNOW(-1), INIT(0), PAID(1), BREWING(2), BREWED(3), TAKEN(4), CANCELLED(5),
    ;

    private byte state;

    OrderState(int state) {
        this.state = (byte) state;
    }

    public byte getState() {
        return state;
    }

    public static OrderState getOrderStateByState(int state){
        for (OrderState orderState: OrderState.values()) {
            if(state == orderState.getState()){
                return orderState;
            }
        }
        return null;
    }

}
