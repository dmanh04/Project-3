package com.javaweb.converter;


import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.request.BuildingSearchRequest;
import org.springframework.stereotype.Component;

@Component
public class BuildingSearchBuilderConverter {

    public BuildingSearchBuilder toBuildingSearchBuilder(BuildingSearchRequest buildingSearchRequest) {
        BuildingSearchBuilder buildingSearchBuilder =
                new BuildingSearchBuilder.Builder()
                        .setName(buildingSearchRequest.getName())
                        .setFloorArea(buildingSearchRequest.getFloorArea())
                        .setDistrict(buildingSearchRequest.getDistrict())
                        .setWard(buildingSearchRequest.getWard())
                        .setStreet(buildingSearchRequest.getStreet())
                        .setNumberOfBasement(buildingSearchRequest.getNumberOfBasement())
                        .setDirection(buildingSearchRequest.getDirection())
                        .setLevel(buildingSearchRequest.getLevel())
                        .setAreaFrom(buildingSearchRequest.getAreaFrom())
                        .setAreaTo(buildingSearchRequest.getAreaTo())
                        .setRentPriceFrom(buildingSearchRequest.getRentPriceFrom())
                        .setRentPriceTo(buildingSearchRequest.getRentPriceTo())
                        .setManagerName(buildingSearchRequest.getManagerName())
                        .setManagerPhoneNumber(buildingSearchRequest.getManagerPhone())
                        .setStaffId(buildingSearchRequest.getStaffId())
                        .setTypeCode(buildingSearchRequest.getTypeCode())
                        .build();

        return buildingSearchBuilder;
    }
}
