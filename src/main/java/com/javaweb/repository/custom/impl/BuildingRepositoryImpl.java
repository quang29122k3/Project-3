package com.javaweb.repository.custom.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository
@Primary
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    public static void joinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
        Long staffId= buildingSearchBuilder.getStaffId();
        if(staffId!=null) {
            sql.append(" INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
            sql.append(" INNER JOIN user d ON d.id = assignmentbuilding.staffid ");
        }
//        List<String>typeCode = buildingSearchBuilder.getTypeCode();
//        if(typeCode!=null&&typeCode.size()!=0) {
//            sql.append( "INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
//            sql.append(" INNER JOIN renttype ON renttype.id = buildingrenttype.renttypeid ");
//        }
    }
    public static void normalQuery(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
        //su dung java reflection
        try {
            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
            for(Field item : fields) {
                item.setAccessible(true);
                String fieldName = item.getName();
                if(!fieldName.equals("staffId")&&!fieldName.startsWith("area")&&!fieldName.equals("typeCode")
                        &&!fieldName.startsWith("rentPrice")) {
                    Object value = item.get(buildingSearchBuilder);
                    if(value!=null) {
                        if(item.getType().getName().equals("java.lang.Long")||item.getType().getName().equals("java.lang.Integer")) {
                            where.append(" AND b." +fieldName +" = " +value );
                        }
                        else if(item.getType().getName().equals("java.lang.String")){
                            where.append(" AND b." +fieldName + " LIKE '%" +value +"%' ");

                        }
                    }
                }

            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void especialQuery(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
        // xuly cho nhung doi tuong can Join de lay gia tri va su dung toi <= >= hoac IN() doi voi List
        Long staffId= buildingSearchBuilder.getStaffId();
        if(staffId!=null) {
            where.append(" AND assignmentbuilding.staffid = " + staffId );
        }
        Long rentAreaTo= buildingSearchBuilder.getAreaTo();
        Long rentAreaFrom= buildingSearchBuilder.getAreaFrom();
        if(rentAreaTo!=null||rentAreaFrom!=null) {
            //su dung EXISTS muc dich khong can JOIN
            where.append(" AND EXISTS (SELECT * FROM rentarea  WHERE b.id = rentarea.buildingid ");
            if(rentAreaFrom!=null) {
                where.append(" AND rentarea.value >= "+ rentAreaFrom);
            }
            if(rentAreaTo!=null) {
                where.append(" AND rentarea.value <= "+ rentAreaTo);
            }
            where.append(") ");
        }
        Long rentPriceTo= buildingSearchBuilder.getRentPriceTo();
        Long rentPriceFrom= buildingSearchBuilder.getRentPriceFrom();
        if(rentPriceTo!=null||rentPriceFrom!=null) {
            if(rentPriceFrom!=null) {
                where.append(" AND b.rentprice >= "+ rentPriceFrom);
            }
            if(rentPriceTo!=null) {
                where.append(" AND b.rentprice <= "+ rentPriceTo);
            }
        }
        //xuly typeCode
        //vi typeCode la mot list, va quey su dung IN thi cac phan tu phai cach nhau boi dau "'"
        //vong for duoi day tao ra 1 list moi va cac phan tu cach nhau boi dau "'"
        //CACH 1:java7
//		if(typeCode!=null&&typeCode.size()!=0) {
//			List<String>code = new ArrayList<>();
//			for(String it:typeCode) {
//				code.add("'" + it +"'");
//			}
//			where.append(" AND renttype.code IN(" + String.join(",",code) + ")");// su dung lenh join de ghep xau theo ky tu ","
//		}
        //CACH 2:java8 su dung stream
//        List<String>typeCode = buildingSearchBuilder.getTypeCode();
//        if(typeCode!=null&&typeCode.size()!=0) {
//            where.append(" AND b.type IN (");
//            String sql = typeCode.stream().map(it -> "'"+it+"'").collect(Collectors.joining(","));
            //su dung OR hoac IN deu duoc, phan nay y tuong la su dung OR
        StringBuilder sql = new StringBuilder();
            List<String> typeCode = buildingSearchBuilder.getTypeCode();
            if(typeCode != null && typeCode.size() != 0) {
                sql.append(" AND b.type IN (");
                String s = typeCode.stream().map(it -> "'" + it + "'").collect(Collectors.joining(","));
                sql.append(s +")");
            }

            where.append(sql);
//            where.append(" ) ");
        }


    @PersistenceContext
    private EntityManager entityManager;
    public List<BuildingEntity> findAll (BuildingSearchBuilder buildingSearchBuilder){
        StringBuilder sql= new StringBuilder ("SELECT b.* FROM building b ");
        joinTable(buildingSearchBuilder,sql);
        StringBuilder where= new StringBuilder(" WHERE 1=1");
        normalQuery(buildingSearchBuilder,where);
        especialQuery(buildingSearchBuilder,where);
        where.append(" GROUP BY b.id ");
        sql.append(where);
        System.out.print(sql);
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);

        return query.getResultList();

    }
}



