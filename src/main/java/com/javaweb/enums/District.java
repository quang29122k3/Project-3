package com.javaweb.enums;

import java.util.Map;
import java.util.TreeMap;

public enum District {
    QUAN_1("Quận 1"),
    QUAN_2("Quận 2"),
    QUAN_3("Quận 3"),
    QUAN_4("Quận 4"),
    QUAN_5("Quận 5"),
    QUAN_6("Quận 6"),
    QUAN_HOANG_MAI("Quận HOÀNG MAI"),
    ;


    private final String DistrictName;
    District(String DistrictName){
        this.DistrictName=DistrictName;
    }
    public static Map<String,String> type(){
        Map<String,String>districts = new TreeMap<>();
        for(District it: District.values()){
            districts.put(it.toString(),it.DistrictName);

        }
        return districts;
    }



}
