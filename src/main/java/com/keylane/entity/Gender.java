package com.keylane.entity;

public enum Gender {
    MALE(1), FEMALE(2);
 
    private int code;
     
    Gender(int code) {
        this.code = code;
    }
 
    public int getCode() {
        return code;
    }
}
