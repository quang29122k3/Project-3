package com.javaweb.enums;

import java.util.Map;
import java.util.TreeMap;

public enum TypeCode {
    NOT_THAT("Nội thất"),
    NGUYEN_CAN("Nguyên căn"),
    TANG_TRET("Tầng trệt"),
    ;


    private final String TypeOfBuilding;
    TypeCode(String TypeOfBuilding){
        this.TypeOfBuilding=TypeOfBuilding;
    }
    public static Map<String,String> type(){
        Map<String,String> buildingTypes = new TreeMap<>();
        for(TypeCode it: TypeCode.values()){
            buildingTypes.put(it.toString(),it.TypeOfBuilding);
        }
        return buildingTypes;
    }
}
