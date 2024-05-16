package com.javaweb.filter;

import com.javaweb.entity.RentAreaEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Filter {


    public  String toRentAreaString(List<RentAreaEntity> rentAreas){
        String rentArea = rentAreas.stream()
                .map(item -> item.getValue().toString())
                .collect(Collectors.joining(","));
        return rentArea;
    }


    public String toTypeCodeString(List<String> typeCode){
        String type = typeCode.stream()
                .map(item -> item)
                .collect(Collectors.joining(","));
        return type;
    }

    public List<String> toTypeCodeList(String type){
        if(type != null){
            String[] list = type.trim().split(",");
            List<String> typeCode = new ArrayList<>();
            for(String item : list) {
                typeCode.add(item);
            }
            return typeCode;
        }
        return null;
    }
}
