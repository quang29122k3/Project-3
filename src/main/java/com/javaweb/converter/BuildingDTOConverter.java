package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildingDTOConverter {
    //giup clean code trong part filter cua service
    @Autowired
    private ModelMapper modelMapper;
    public BuildingSearchResponse toBuildingDTO(BuildingEntity item) {
        BuildingSearchResponse buildingSearchResponse = modelMapper.map(item,BuildingSearchResponse.class);	//doi tuong lay du lieu, va noi nhan du lieu
        buildingSearchResponse.setAddress(item.getStreet() + " , " + item.getWard() + " , " + item.getDistrict());
        List<RentAreaEntity> temp =item.getRentAreaEntities();
        //CACH 2 java8
        //su dung stream de duyet temp va kem them collectors kem' vs joining de phan tach cac element kem dau "'"
        String rentAreas = temp.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
        buildingSearchResponse.setRentArea(rentAreas);
        return buildingSearchResponse;
    }

}
