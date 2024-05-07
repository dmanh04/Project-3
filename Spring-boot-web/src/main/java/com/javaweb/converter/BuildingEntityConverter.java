package com.javaweb.converter;


import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.enums.DistrictCode;
import com.javaweb.filter.Filter;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.utils.NumberUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BuildingEntityConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Filter filter;

    public BuildingSearchResponse toBuildingSearchResponse(BuildingEntity buildingEntity) {
        BuildingSearchResponse buildingSearchResponse = modelMapper.map(buildingEntity, BuildingSearchResponse.class);
        String district = buildingEntity.getDistrict();
        Map<String, String> mapDistrict= DistrictCode.district();
        buildingSearchResponse.setAddress(buildingEntity.getWard() + " " + buildingEntity.getStreet() + " " + mapDistrict.get(district));
        String rentArea = filter.toRentAreaString(buildingEntity.getRentAreas());
        buildingSearchResponse.setRentArea(rentArea);
        return buildingSearchResponse;
    }



    public BuildingEntity toBuildingEntity(BuildingDTO buildingDTO) {
            BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);
            String type = filter.toTypeCodeString(buildingDTO.getTypeCode());
            buildingEntity.setType(type);
            String rentArea = buildingDTO.getRentArea();
            String[] list = rentArea.trim().split(",");
            List<Long> rentAreaValue = new ArrayList<>();//100,200     200 300 400         200 300 400
            for(String item : list) {
                if(NumberUtils.isLong(item)){
                    rentAreaValue.add(Long.parseLong(item));
                }
            }
            List<RentAreaEntity> rentAreaEntities = new ArrayList<>();
            for(Long value : rentAreaValue) {
                RentAreaEntity rentAreaEntity = new RentAreaEntity();
                rentAreaEntity.setValue(value);
                rentAreaEntity.setBuilding(buildingEntity);
                rentAreaEntities.add(rentAreaEntity);
            }
            buildingEntity.setRentAreas(rentAreaEntities);
            return buildingEntity;
    }


    public BuildingDTO toBuildingDTO(BuildingEntity buildingEntity) {
        BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);
        String type = buildingEntity.getType();
        List<String> typeCode = filter.toTypeCodeList(type);
        buildingDTO.setTypeCode(typeCode);
        String rentArea = filter.toRentAreaString(buildingEntity.getRentAreas());
        buildingDTO.setRentArea(rentArea);
        return buildingDTO;
    }
}
