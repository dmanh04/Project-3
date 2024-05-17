package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingEntityConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.IBuildingService;
import com.javaweb.utils.UploadFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.io.File;
import java.util.ArrayList;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class BuildingServiceImpl implements IBuildingService {


    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingSearchBuilderConverter buildingSearchBuilderConverter;

    @Autowired
    private BuildingEntityConverter buildingEntityConverter;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UploadFileUtils uploadFileUtils;

    @Override
    public List<BuildingSearchResponse> searchBuilding(BuildingSearchRequest buildingSearchRequest, Pageable pageable) {
        List<BuildingSearchResponse> res = new ArrayList<>();
        BuildingSearchBuilder builder = buildingSearchBuilderConverter.toBuildingSearchBuilder(buildingSearchRequest);
        List<BuildingEntity> buildingEntities = buildingRepository.searchBuilding(builder, pageable);
        for(BuildingEntity buildingEntity : buildingEntities) {
            BuildingSearchResponse buildingSearchResponse = buildingEntityConverter.toBuildingSearchResponse(buildingEntity);
            res.add(buildingSearchResponse);
        }
        return res;
    }

    @Override
    public int countTotalItems(BuildingSearchRequest buildingSearchRequest) {
        BuildingSearchBuilder builder = buildingSearchBuilderConverter.toBuildingSearchBuilder(buildingSearchRequest);
        return buildingRepository.countBuilding(builder);
    }

    @Override
    public BuildingDTO findBuildingById(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findById(id).get();
        BuildingDTO buildingDTO = buildingEntityConverter.toBuildingDTO(buildingEntity);
        return buildingDTO;
    }

    @Override
    @Transactional
    public void deleteBuilding(List<Long> ids) {
        buildingRepository.deleteAllByIdIn(ids);
        System.out.println("remove success");
    }

    @Override
    public void updateAssigmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO) {
        BuildingEntity buildingEntity = buildingRepository.findById(assignmentBuildingDTO.getBuildingId()).get();
        List<UserEntity> list = userRepository.findByIdIn(assignmentBuildingDTO.getStaffs());
        buildingEntity.setUsers(list);
        buildingRepository.save(buildingEntity);
    }

    @Override
    @Transactional
    public String insertBuilding(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntityEntity = buildingEntityConverter.toBuildingEntity(buildingDTO);
        if(buildingDTO.getImageName() != null) {
            saveThumbnail(buildingDTO, buildingEntityEntity);
        }
        else{
            BuildingEntity buildingEntityEntity2 = buildingRepository.findById(buildingEntityEntity.getId()).get();
            buildingEntityEntity.setAvatar(buildingEntityEntity2.getAvatar());
        }
        if(buildingEntityEntity.getId() != null) {
            List<UserEntity> list = userRepository.findByBuildings_Id(buildingEntityEntity.getId());
            buildingEntityEntity.setUsers(list);
        }
        buildingRepository.save(buildingEntityEntity);
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

}
