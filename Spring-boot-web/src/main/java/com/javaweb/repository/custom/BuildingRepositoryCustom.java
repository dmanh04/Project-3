package com.javaweb.repository.custom;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuildingRepositoryCustom {

    List<BuildingEntity> searchBuilding(BuildingSearchBuilder builder, Pageable pageable);

    int countBuilding(BuildingSearchBuilder builder);
}
