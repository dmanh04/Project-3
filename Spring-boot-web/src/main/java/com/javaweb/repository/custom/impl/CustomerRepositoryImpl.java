package com.javaweb.repository.custom.impl;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.repository.custom.CustomerRepositoryCustom;
import com.javaweb.utils.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<CustomerEntity> findCustomer(CustomerSearchRequest csr, Pageable pageable) {
        StringBuilder sql = new StringBuilder("SELECT * FROM customer ct ");
        queryJoin(sql, csr);
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        queryNormal(where, csr);
        querySpecial(where, csr);
        where.append(" AND ct.is_active = 1");
        sql.append(where);
        int pageNumber = pageable.getPageNumber(); // Số trang
        int pageSize = pageable.getPageSize(); // Kích thước trang
        // Tính toán OFFSET dựa trên số trang và kích thước trang
        int offset = pageNumber * pageSize;

        sql.append(" LIMIT " + pageSize + " OFFSET " + offset);
        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        System.out.println(sql.toString());
        return query.getResultList();
    }

    @Override
    public int countCustomer(CustomerSearchRequest csr) {
        StringBuilder sql = new StringBuilder("SELECT * FROM customer ct ");
        queryJoin(sql, csr);
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        queryNormal(where, csr);
        querySpecial(where, csr);
        where.append(" AND ct.is_active = 1");
        sql.append(where);
        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        System.out.println(sql.toString());
        return query.getResultList().size();
    }

    private void querySpecial(StringBuilder where, CustomerSearchRequest csr) {
        if(csr.getStaffId() != null){
            where.append("  and act.staffid = " + csr.getStaffId());
        }
    }

    private void queryJoin(StringBuilder sql, CustomerSearchRequest csr) {
        if(csr.getStaffId() != null){
            sql.append(" join assignmentcustomer act on act.customerid = ct.id ");
        }
    }

    private void queryNormal(StringBuilder sql, CustomerSearchRequest csr) {
        try{
            Field[] fields = CustomerSearchRequest.class.getDeclaredFields();
            for (Field item : fields) {
                item.setAccessible(true);
                String fieldName = item.getName();
                Object valueKey = item.get(csr);
                if(fieldName != "staffId"){
                    if(valueKey != null){
                        String value = valueKey.toString();
                        if (StringUtils.check(value)){
                            if (item.getType().getName().equals("java.lang.Long")) {
                                sql.append(" AND ct." + fieldName + " = " + value);
                            }
                            if (item.getType().getName().equals("java.lang.Integer")) {
                                sql.append(" AND ct." + fieldName + " = " + value);
                            }
                            if (item.getType().getName().equals("java.lang.String")) {
                                sql.append(" AND ct." + fieldName + " like '%" + value + "%'");
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
