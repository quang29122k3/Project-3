package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.converter.UpgradeOrAddBuildingConverter;
import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BuildingDTOConverter buildingDTOConverter;
    @Autowired
    private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private AssignmentBuildingRepository assignmentBuildingRepository;
    @Override
    public ResponseDTO listStaffs(Long buildingId) {
        BuildingEntity building = buildingRepository.findById(buildingId).get();
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1,"STAFF");
        List<AssignmentBuildingEntity> assignmentBuildingEntities = building.getAssignmentBuildingEntities();
        List<UserEntity> staffAssignment = new ArrayList<>();
        List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();
        ResponseDTO responseDTO = new ResponseDTO();

        for(AssignmentBuildingEntity assignmentBuildingEntity : assignmentBuildingEntities){
            staffAssignment.add(assignmentBuildingEntity.getUserEntity());
        }
        for(UserEntity it: staffs){
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setFullName(it.getFullName());
            staffResponseDTO.setStaffId(it.getId());
            if(staffAssignment.contains(it)){
                staffResponseDTO.setChecked("checked");
            }
            else{
                staffResponseDTO.setChecked("");
            }
            staffResponseDTOS.add(staffResponseDTO);
        }
        responseDTO.setData(staffResponseDTOS);
        responseDTO.setMessage("success");
        return responseDTO;
    }

    private void toSolve(String[] s, BuildingEntity buildingEntity, BuildingDTO buildingDTO){
        buildingRepository.save(buildingEntity);
        if(buildingDTO.getId() != null){
            rentAreaRepository.deleteByBuilding1(buildingEntity);
        }
        for(String x : s){
            RentAreaEntity r = new RentAreaEntity();
            r.setBuilding1(buildingEntity);
            r.setValue(Long.parseLong(x));
            entityManager.persist(r);
        }
    }

    @Override
    public List<BuildingSearchResponse> findAll(BuildingSearchRequest buildingSearchRequest) {
        BuildingSearchBuilder buildingSearchBuider = buildingSearchBuilderConverter.toBuildingSearchBuilder(buildingSearchRequest);

        List<BuildingEntity> buildingEntities = buildingRepository.findAll(buildingSearchBuider);
        //lay ket qua cua building dau tien
        List<BuildingSearchResponse> result = new ArrayList<>();

        for (BuildingEntity item : buildingEntities) {//duyet ket qua tung building tra ve
            BuildingSearchResponse buildingSearchResponse = buildingDTOConverter.toBuildingDTO(item);
            result.add(buildingSearchResponse);
        }

        return result;

    }

    public void UpgradeOrAddBuilding(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = UpgradeOrAddBuildingConverter.toUpgradeOrAddBuildingConverter(buildingDTO);
        String[] s = buildingDTO.getRentArea().split(",");

        toSolve(s, buildingEntity, buildingDTO);
    }

    @Override
    public void GiveBuildingForStaff(AssignmentBuildingDTO assignmentBuildingDTO) {
        BuildingEntity buildingEntity = buildingRepository.findById(assignmentBuildingDTO.getBuildingId()).get();
        assignmentBuildingRepository.deleteByBuilding2(buildingEntity);
        for(Long id : assignmentBuildingDTO.getStaffs()){
            AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity();
            UserEntity userEntity = userRepository.findById(id).get();
            assignmentBuildingEntity.setBuilding2(buildingEntity);
            assignmentBuildingEntity.setUserEntity(userEntity);
            entityManager.persist(assignmentBuildingEntity);
        }
    }

    @Override
    public void DeleteBulding(List<Long> ids) {
        for(Long x : ids){
            BuildingEntity buildingEntity = buildingRepository.findById(x).get();
            rentAreaRepository.deleteByBuilding1(buildingEntity);
            assignmentBuildingRepository.deleteByBuilding2(buildingEntity);
            buildingRepository.deleteById(x);
        }
    }


}
