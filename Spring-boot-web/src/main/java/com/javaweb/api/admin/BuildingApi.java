package com.javaweb.api.admin;



import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.IBuildingService;

import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
public class BuildingApi {

    @Autowired
    private IBuildingService iBuildingService;

    @Autowired
    private IUserService iUserService;

    @PostMapping("")
    public String addUpdateBuilding(@RequestBody BuildingDTO buildingDTO) {
        String res = iBuildingService.insertBuilding(buildingDTO);
        return "Add Building successfully";
    }

    @GetMapping("/{id}/staffs")
    public ResponseDTO loadStaffs(@PathVariable Long id) {
        ResponseDTO responseDTO = iUserService.listStaff(id);
        return responseDTO;
    }

////    @PutMapping
////    public void updateAssigmentBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {
//////        iAssignmentBuildingService.updateAssigmentBuilding(assignmentBuildingDTO);
////    }
//
    @DeleteMapping("/{ids}")
    public String deleteBuilding(@PathVariable List<Long> ids) {

        iBuildingService.deleteBuilding(ids);
        return "Delete Building successfully";
    }
}
