package com.javaweb.converter;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.request.BuildingSearchRequest;
import org.springframework.stereotype.Component;

@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(BuildingSearchRequest buildingSearchRequest){
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
                .setName(buildingSearchRequest.getName())
                .setDistrictId(buildingSearchRequest.getDistrict())
                .setFloorArea(buildingSearchRequest.getFloorArea())
                .setStreet(buildingSearchRequest.getStreet())
                .setWard(buildingSearchRequest.getWard())
                .setNumberOfBasement(buildingSearchRequest.getNumberOfBasement())
                .setManagerName(buildingSearchRequest.getManagerName())
                .setManagerPhoneNumber(buildingSearchRequest.getManagerPhone())
                .setAreaTo(buildingSearchRequest.getAreaFrom())
                .setAreaFrom(buildingSearchRequest.getAreaTo())
                .setRentPriceTo(buildingSearchRequest.getRentPriceFrom())
                .setRentPriceFrom(buildingSearchRequest.getRentPriceFrom())
                .setStaffId(buildingSearchRequest.getStaffId())
                .setTypeCode(buildingSearchRequest.getTypeCode())
                .build();
        return buildingSearchBuilder;
    }
}