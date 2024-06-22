package com.javaweb.enums;


import java.util.LinkedHashMap;
import java.util.Map;

public enum Status {

    CHUA_XU_LY("Chưa xử lý"),
    DANG_XU_LY("Đang xử lý"),
    DA_XU_LY("Đã xử lý");


    private final String nameStatus;

    Status(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    public String getNameStatus() {
        return nameStatus;
    }

    public static Map<String, String> getStatus(){
        Map<String, String> map = new LinkedHashMap<>();
        for(Status status : Status.values()){
            map.put(status.getNameStatus(), status.getNameStatus());
        }
        return map;
    }
}
