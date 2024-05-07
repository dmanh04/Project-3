package com.javaweb.enums;

import java.util.HashMap;
import java.util.Map;

public enum DistrictCode {

    QUAN_1("Quận 1"),
    QUAN_2("Quận 2"),
    QUAN_3("Quận 3"),
    QUAN_4("Quận 4");

    private final String districtName;

     DistrictCode(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictName() {
         return districtName;
    }

    public static Map<String, String> district(){
         Map<String, String> district = new HashMap<String, String>();
         for (DistrictCode code : DistrictCode.values()) {
             district.put(code.toString(), code.getDistrictName());
         }
         return district;
    }
}
