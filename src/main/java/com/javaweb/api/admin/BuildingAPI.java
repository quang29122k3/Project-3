package com.javaweb.api.admin;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "BuildingAPIOfAdmin")
@RequestMapping("/api/building")
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;
    // Thêm mới, sửa tòa nhà
    @PostMapping
    public BuildingDTO addOrUpdateBuilding(@RequestBody BuildingDTO buildingDTO){
        buildingService.UpgradeOrAddBuilding(buildingDTO);
        return buildingDTO;
    }
    // Xóa tòa nhà dựa vào id
    @DeleteMapping("/{ids}")
    public void deleteBuilding(@PathVariable List<Long> ids){
        buildingService.DeleteBulding(ids);
    }
    //Thao tác hiển thị nhân viên lên modal
    @GetMapping("/{id}/staffs")
    public ResponseDTO loadStaffs(@PathVariable Long id){
        ResponseDTO result = buildingService.listStaffs(id);
        return result;
    }
    //THao tác giao nhân viên
    @PostMapping("/assignment")
    public void updateAssignmentBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO){
        buildingService.GiveBuildingForStaff(assignmentBuildingDTO);
    }

}
