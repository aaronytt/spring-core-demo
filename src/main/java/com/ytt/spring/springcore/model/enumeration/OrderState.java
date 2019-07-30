package com.ytt.spring.springcore.model.enumeration;

public enum OrderState {
    INIT(0), PAID(1), BREWING(2), BREWED(3), TAKEN(4), CANCELLED(5),
    ;

    private int state;

    OrderState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

}
