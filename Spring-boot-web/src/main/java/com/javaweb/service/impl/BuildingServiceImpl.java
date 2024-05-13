package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingEntityConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.service.IBuildingService;
import com.javaweb.utils.UploadFileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Service
public class BuildingServiceImpl implements IBuildingService {

    @Autowired
    private BuildingSearchBuilderConverter buildingSearchBuilderConverter;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingEntityConverter buildingEntityConverter;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Autowired
    private AssignmentBuildingRepository assignmentBuildingRepository;

    @Autowired
    private UploadFileUtils uploadFileUtils;



//    @Override
//    public List<BuildingSearchResponse> searchBuilding(BuildingSearchRequest buildingSearchRequest) {
//        List<BuildingSearchResponse> res = new ArrayList<>();
//        BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(buildingSearchRequest);
////        List<BuildingEntity> buildingEntities = buildingRepository.searchBuilding(buildingSearchBuilder, pageable);
////        for(BuildingEntity buildingEntity : buildingEntities) {
////            BuildingSearchResponse buildingSearchResponse = buildingEntityConverter.toBuildingSearchResponse(buildingEntity);
////            res.add(buildingSearchResponse);
////        }
//        return res;
//    }

    @Override
    @Transactional
    public String insertBuilding(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntityEntity = buildingEntityConverter.toBuildingEntity(buildingDTO);
        saveThumbnail(buildingDTO, buildingEntityEntity);
        buildingRepository.save(buildingEntityEntity);
        rentAreaRepository.deleteAllByBuilding(buildingEntityEntity);
        rentAreaRepository.saveAll(buildingEntityEntity.getRentAreas());
        return "add success";
    }


    private void saveThumbnail(BuildingDTO buildingDTO, BuildingEntity buildingEntity) {
        String path = "/building/" + buildingDTO.getImageName();
        if (null != buildingDTO.getImageBase64()) {
            if (null != buildingEntity.getAvatar()) {
                if (!path.equals(buildingEntity.getAvatar())) {
                    File file = new File("C://home/office" + buildingEntity.getAvatar());
                    file.delete();
                }
            }
            byte[] bytes = Base64.decodeBase64(buildingDTO.getImageBase64().getBytes());
            uploadFileUtils.writeOrUpdate(path, bytes);
            buildingEntity.setAvatar(path);
        }
    }


    @Override
    public BuildingDTO findBuildingById(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findById(id).get();
        BuildingDTO res = buildingEntityConverter.toBuildingDTO(buildingEntity);
        return res;
    }

    @Override
    @Transactional
    public void deleteBuilding(List<Long> ids) {
        assignmentBuildingRepository.deleteByBuilding_IdIn(ids);
        rentAreaRepository.deleteByBuilding_IdIn(ids);
        buildingRepository.deleteBuildingEntityByIdIn(ids);
    }

    @Override
    public List<BuildingSearchResponse> searchBuilding(BuildingSearchRequest buildingSearchRequest, Pageable pageable) {
        List<BuildingSearchResponse> res = new ArrayList<>();
        BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(buildingSearchRequest);
        List<BuildingEntity> buildingEntities = buildingRepository.searchBuilding(buildingSearchBuilder, pageable);
        for(BuildingEntity buildingEntity : buildingEntities) {
            BuildingSearchResponse buildingSearchResponse = buildingEntityConverter.toBuildingSearchResponse(buildingEntity);
            res.add(buildingSearchResponse);
        }
        return res;
    }

    @Override
    public int countTotalItems(BuildingSearchRequest buildingSearchRequest) {
        BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(buildingSearchRequest);
        return buildingRepository.countBuilding(buildingSearchBuilder);
    }
}
