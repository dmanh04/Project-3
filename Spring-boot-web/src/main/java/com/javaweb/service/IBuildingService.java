package com.javaweb.service;


import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBuildingService {

//    List<BuildingSearchResponse> searchBuilding(BuildingSearchRequest buildingSearchRequest);

    String insertBuilding(BuildingDTO buildingDTO);

    BuildingDTO findBuildingById(Long id);

    void deleteBuilding(List<Long> ids);

    List<BuildingSearchResponse> searchBuilding(BuildingSearchRequest buildingSearchRequest, Pageable pageable);

    int countTotalItems(BuildingSearchRequest buildingSearchRequest);
}
