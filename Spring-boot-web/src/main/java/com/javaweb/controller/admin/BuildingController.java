package com.javaweb.controller.admin;



import com.javaweb.enums.DistrictCode;
import com.javaweb.enums.TypeCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.IUserService;
import com.javaweb.utils.DisplayTagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller(value="buildingControllerOfAdmin")
public class BuildingController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IBuildingService iBuildingService;

    @GetMapping("/admin/building-list")
    public ModelAndView buildingList(@ModelAttribute("modelSearch")BuildingSearchRequest buildingSearchRequest, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/list");
        DisplayTagUtils.of(request, buildingSearchRequest);
        List<BuildingSearchResponse> result = new ArrayList<>();
        mav.addObject("staffs", iUserService.getStaffs());
        mav.addObject("districtCode", DistrictCode.district());
        mav.addObject("typeCodes", TypeCode.getTypeCode());
        if(SecurityUtils.getAuthorities().contains("ROLE_STAFF")){
            Long staffId = SecurityUtils.getPrincipal().getId();
            buildingSearchRequest.setStaffId(staffId);
            result = iBuildingService.searchBuilding(buildingSearchRequest, PageRequest.of(buildingSearchRequest.getPage() - 1, buildingSearchRequest.getMaxPageItems()));
        }
        else{
            result = iBuildingService.searchBuilding(buildingSearchRequest, PageRequest.of(buildingSearchRequest.getPage() - 1, buildingSearchRequest.getMaxPageItems()));
        }
        buildingSearchRequest.setListResult(result);
        buildingSearchRequest.setTotalItems(iBuildingService.countTotalItems(buildingSearchRequest));
        mav.addObject("buildings", result);
        return mav;
    }
    @GetMapping("/admin/building-edit")
    public ModelAndView buildingEdit(@ModelAttribute("buildingEdit") BuildingDTO buildingDTO){
        ModelAndView mav = new ModelAndView("admin/building/edit");
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
