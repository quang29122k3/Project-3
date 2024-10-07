package com.javaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "assignmentbuilding")
public class AssignmentBuildingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "staffid")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "buildingid")
    private BuildingEntity building2;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public BuildingEntity getBuildingEntity() {
        return building2;
    }

    public void setBuildingEntity(BuildingEntity buildingEntity) {
        this.building2 = buildingEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BuildingEntity getBuilding2() {
        return building2;
    }

    public void setBuilding2(BuildingEntity building2) {
        this.building2 = building2;
    }
}
