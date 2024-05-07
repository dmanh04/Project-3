package com.javaweb.enums;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public enum TypeCode {

    TANG_TRET("Tầng Trệt"),
    NGUYEN_CAN("Nguyên Căn"),
    NOI_THAT("Nội thất");


    public final String typeCodeName;

    TypeCode(String typeCodeName) {
        this.typeCodeName = typeCodeName;
    }

    public String getTypeCodeName(){
        return this.typeCodeName;
    }

    public static Map<String, String> getTypeCode(){
        Map<String, String> map = new LinkedHashMap<>();
        for(TypeCode item : TypeCode.values()){
            map.put(item.toString(), item.getTypeCodeName());
        }
        return map;
    }

}
