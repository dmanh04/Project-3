package com.javaweb.service;


import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;

import java.util.List;

public interface IBuildingService {

    List<BuildingSearchResponse> searchBuilding(BuildingSearchRequest buildingSearchRequest);

    String insertBuilding(BuildingDTO buildingDTO);

    BuildingDTO findBuildingById(Long id);

    void deleteBuilding(List<Long> ids);
}
