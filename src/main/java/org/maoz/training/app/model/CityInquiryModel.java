package org.maoz.training.app.model;

public class CityInquiryModel {
    private String name;
    private String countryCode;
    private String district;
    private Integer populationFrom;
    private Integer populationTo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulationFrom() {
        return populationFrom;
    }

    public void setPopulationFrom(Integer populationFrom) {
        this.populationFrom = populationFrom;
    }

    public Integer getPopulationTo() {
        return populationTo;
    }

    public void setPopulationTo(Integer populationTo) {
        this.populationTo = populationTo;
    }
}
