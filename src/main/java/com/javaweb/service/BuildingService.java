package com.javaweb.service;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    List<BuildingSearchResponse> findAll(BuildingSearchRequest buildingSearchRequest);
    ResponseDTO listStaffs (Long buildingId);
    void UpgradeOrAddBuilding(BuildingDTO buildingDTO);
    void DeleteBulding(List<Long> ids);
    void GiveBuildingForStaff(AssignmentBuildingDTO assignmentBuildingDTO);
}
