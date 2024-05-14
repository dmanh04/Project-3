package com.javaweb.service;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBuildingService {

    List<BuildingSearchResponse> searchBuilding(BuildingSearchRequest buildingSearchRequest, Pageable pageable);

    int countTotalItems(BuildingSearchRequest buildingSearchRequest);

    String insertBuilding(BuildingDTO buildingDTO);

    BuildingDTO findBuildingById(Long id);

    void deleteBuilding(List<Long> ids);

    void updateAssigmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO);
}
