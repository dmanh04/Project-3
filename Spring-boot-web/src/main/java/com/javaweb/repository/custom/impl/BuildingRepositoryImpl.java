package com.javaweb.repository.custom.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.utils.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {


    @PersistenceContext
    private EntityManager entityManager;


    public void queryJoin(BuildingSearchBuilder builder, StringBuilder sql) {
        Long rentAreaFrom = builder.getAreaFrom();
        Long rentAreaTo = builder.getAreaTo();
        Long staffId = builder.getStaffId();
        if (rentAreaFrom != null || rentAreaTo != null) {
            sql.append(" JOIN rentarea ra ON ra.buildingid = b.id");
        }
        if (staffId != null) {
            sql.append(" JOIN assignmentbuilding asb on asb.buildingid = b.id ");
        }

    }

    public void queryWhereNormal(BuildingSearchBuilder builder, StringBuilder where) {
        try {
            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
            for (Field item : fields) {
                item.setAccessible(true);
                String fieldName = item.getName();
                if (!fieldName.startsWith("area") && !fieldName.startsWith("rentPrice") && !fieldName.equals("staffId")
                        && !fieldName.equals("typeCode")) {
                    Object valueKey = item.get(builder);
                    if (valueKey != null) {
                        String value = valueKey.toString();
                        if (StringUtils.check(value)) {
                            if (item.getType().getName().equals("java.lang.Long")) {
                                where.append(" AND b." + fieldName + " = " + value);
                            }
                            if (item.getType().getName().equals("java.lang.Integer")) {
                                where.append(" AND b." + fieldName + " = " + value);
                            }
                            if (item.getType().getName().equals("java.lang.String")) {
                                where.append(" AND b." + fieldName + " like '%" + value + "%'");
                            }
                        }
                    }
                }

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void queryWhereSpecial(BuildingSearchBuilder builder, StringBuilder where) {
        Long areaFrom = builder.getAreaFrom();
        Long areaTo = builder.getAreaTo();
        Long staffId = builder.getStaffId();
        Long rentPriceFrom = builder.getRentPriceFrom();
        Long rentPriceTo = builder.getRentPriceTo();
//        List<String> typeCodes = builder.getTypeCode();
//        if(typeCodes != null && !typeCodes.isEmpty()){
//            String typeCode = typeCodes.stream().
//                    map(item -> item)
//                    .collect(Collectors.joining(","));
//                where.append(" AND b.type like '%" + typeCode + "%'");
//        }

        List<String> typeCode = builder.getTypeCode();
        if (typeCode != null && !typeCode.isEmpty()) {
            where.append(" AND (");
            String sqlJoin = typeCode.stream().map(item -> " b.type LIKE '%" + item + "%'")
                    .collect(Collectors.joining(" OR "));
            where.append(sqlJoin + ") ");
        }
        if (areaFrom != null) {
            where.append(" AND ra.value >= " + areaFrom);
        }
        if (areaTo != null) {
            where.append(" AND ra.value <= " + areaTo);
        }
        if (staffId != null) {
            where.append(" AND asb.staffid = " + staffId);
        }
        if (rentPriceFrom != null) {
            where.append(" AND b.rentprice >= " + rentPriceFrom);
        }
        if (rentPriceTo != null) {
            where.append(" AND b.rentprice <= " + rentPriceTo);
        }


    }

    @Override
    public List<BuildingEntity> searchBuilding(BuildingSearchBuilder builder, Pageable pageable) {
        StringBuilder sql = new StringBuilder("SELECT  b.id, b.name, b.street, b.ward, b.district, "
    + " b.servicefee, b.structure, b.direction, b.level, b.carfee, b.motofee,"
     + " b.overtimefee, b.waterfee, b.electricityfee, "
     + " b.deposit, b.payment, b.renttime, b.decorationtime, "
      + " b.brokeragefee, b.type, b.note, "
      + " b.linkofbuilding, b.map, b.avatar, b.createdDate, "
      + " b.modifieDdate, b.createdby, b.modifiedby,"
                + " b.numberofbasement, b.floorarea, b.rentprice, "
                + " b.rentpricedescription, b.managername, b.managerphone" + " FROM building b");
        StringBuilder join = new StringBuilder();
        StringBuilder where = new StringBuilder(" WHERE 1 = 1");
        queryJoin(builder, sql);
        queryWhereNormal(builder, where);
        queryWhereSpecial(builder, where);
        sql.append(where);
        sql.append(" group by b.id");
        int pageNumber = pageable.getPageNumber(); // Số trang
        int pageSize = pageable.getPageSize(); // Kích thước trang
        // Tính toán OFFSET dựa trên số trang và kích thước trang
        int offset = pageNumber * pageSize;

        sql.append(" LIMIT " + pageSize + " OFFSET " + offset);
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    @Override
    public int countBuilding(BuildingSearchBuilder builder) {
        StringBuilder sql = new StringBuilder("SELECT  b.id, b.name, b.street, b.ward, b.district, "
                + " b.servicefee, b.structure, b.direction, b.level, b.carfee, b.motofee,"
                + " b.overtimefee, b.waterfee, b.electricityfee, "
                + " b.deposit, b.payment, b.renttime, b.decorationtime, "
                + " b.brokeragefee, b.type, b.note, "
                + " b.linkofbuilding, b.map, b.avatar, b.createdDate, "
                + " b.modifieDdate, b.createdby, b.modifiedby,"
                + " b.numberofbasement, b.floorarea, b.rentprice, "
                + " b.rentpricedescription, b.managername, b.managerphone" + " FROM building b");
        StringBuilder join = new StringBuilder();
        StringBuilder where = new StringBuilder(" WHERE 1 = 1");
        queryJoin(builder, sql);
        queryWhereNormal(builder, where);
        queryWhereSpecial(builder, where);
        sql.append(where);
        sql.append(" group by b.id");
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList().size();
    }

}
