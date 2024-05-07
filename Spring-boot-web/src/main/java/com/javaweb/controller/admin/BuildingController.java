package com.javaweb.controller.admin;



import com.javaweb.enums.DistrictCode;
import com.javaweb.enums.TypeCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller(value="buildingControllerOfAdmin")
public class BuildingController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IBuildingService iBuildingService;

    @GetMapping("/admin/building-list")
    public ModelAndView buildingList(@ModelAttribute("modelSearch")BuildingSearchRequest buildingSearchRequest){
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("staffs", iUserService.getStaffs());
        mav.addObject("districtCode", DistrictCode.district());
        mav.addObject("typeCodes", TypeCode.getTypeCode());
        List<BuildingSearchResponse> result = iBuildingService.searchBuilding(buildingSearchRequest);
        mav.addObject("buildings", result);
        return mav;
    }
    @GetMapping("/admin/building-edit")
    public ModelAndView buildingEdit(@ModelAttribute("buildingEdit") BuildingDTO buildingDTO){
        ModelAndView mav = new ModelAndView("admin/building/edit");
        buildingDTO.setRentArea("100,200");
        mav.addObject("districtCode", DistrictCode.district());
        mav.addObject("typeCodes", TypeCode.getTypeCode());
        return mav;
    }

    @GetMapping("/admin/building-edit-{id}")
    public ModelAndView buildingEditId(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("admin/building/edit");
        BuildingDTO buildingDTO = iBuildingService.findBuildingById(id);
        mav.addObject("buildingEdit", buildingDTO);
        mav.addObject("districtCode", DistrictCode.district());
        mav.addObject("typeCodes", TypeCode.getTypeCode());
        return mav;
    }
}
