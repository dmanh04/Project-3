package com.javaweb.enums;

import java.util.HashMap;
import java.util.Map;

public enum TransactionType {

    CSKH("Chăm sách khách hàng"),
    DDX("Dẫn đi xem");

    private final String type;

    TransactionType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Map<String, String> type(){
        Map<String, String> typeMap = new HashMap<String, String>();
        for (TransactionType code : TransactionType.values()) {
            typeMap.put(code.toString(), code.getType());
        }
        return typeMap;
    }
}
