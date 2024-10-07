package com.javaweb.builder;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchBuilder {
    private String name;
    private Long floorarea;
    private String ward;
    private String street;
    private String district;
    private Long numberofbasement;
    private List<String> typeCode = new ArrayList<>();
    private String managername;
    private String managerphone;
    private Long rentPriceFrom;
    private Long rentPriceTo;
    private Long areaFrom;
    private Long areaTo;
    private Long staffId;

    private BuildingSearchBuilder(Builder builder) {
        this.name=builder.name;
        this.floorarea=builder.floorarea;
        this.ward=builder.ward;
        this.street=builder.street;
        this.district=builder.district;
        this.numberofbasement=builder.numberofbasement;
        this.typeCode=builder.typeCode;
        this.managername=builder.managername;
        this.managerphone=builder.managerphone;
        this.rentPriceFrom=builder.rentPriceFrom;
        this.rentPriceTo=builder.rentPriceTo;
        this.areaFrom=builder.areaFrom;
        this.areaTo=builder.areaTo;
        this.staffId=builder.staffId;
    }

    public String getName() {
        return name;
    }
    public Long getFloorArea() {
        return floorarea;
    }
    public String getWard() {
        return ward;
    }

    public String getStreet() {
        return street;
    }

    public String getDistrictId() {
        return district;
    }

    public Long getNumberOfBasement() {
        return numberofbasement;
    }

    public List<String> getTypeCode() {
        return typeCode;
    }

    public String getManagerName() {
        return managername;
    }

    public String getManagerPhoneNumber() {
        return managerphone;
    }

    public Long getRentPriceFrom() {
        return rentPriceFrom;
    }

    public Long getRentPriceTo() {
        return rentPriceTo;
    }

    public Long getAreaFrom() {
        return areaFrom;
    }

    public Long getAreaTo() {
        return areaTo;
    }

    public Long getStaffId() {
        return staffId;
    }

    public static class Builder{
        private String name;
        private Long floorarea;
        private String ward;
        private String street;
        private String district;
        private Long numberofbasement;
        private List<String> typeCode = new ArrayList<>();
        private String managername;
        private String managerphone;
        private Long rentPriceFrom;
        private Long rentPriceTo;
        private Long areaFrom;
        private Long areaTo;
        private Long staffId;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setFloorArea(Long floorArea) {
            this.floorarea = floorArea;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setDistrictId(String districtId) {
            this.district = districtId;
            return this;
        }

        public Builder setNumberOfBasement(Long numberOfBasement) {
            this.numberofbasement = numberOfBasement;
            return this;
        }

        public Builder setTypeCode(List<String> typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder setManagerName(String managerName) {
            this.managername = managerName;
            return this;
        }

        public Builder setManagerPhoneNumber(String managerPhoneNumber) {
            this.managerphone = managerPhoneNumber;
            return this;
        }

        public Builder setRentPriceFrom(Long rentPriceFrom) {
            this.rentPriceFrom = rentPriceFrom;
            return this;
        }

        public Builder setRentPriceTo(Long rentPriceTo) {
            this.rentPriceTo = rentPriceTo;
            return this;
        }

        public Builder setAreaFrom(Long areaFrom) {
            this.areaFrom = areaFrom;
            return this;
        }

        public Builder setAreaTo(Long areaTo) {
            this.areaTo = areaTo;
            return this;
        }

        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public BuildingSearchBuilder build(){
            return new BuildingSearchBuilder(this);
        }

    }

}
