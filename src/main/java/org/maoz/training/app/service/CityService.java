package org.maoz.training.app.service;

import net.bytebuddy.asm.Advice;
import org.maoz.training.app.entity.City;
import org.maoz.training.app.model.CityModel;
import org.maoz.training.app.repository.AppRepository;
import org.maoz.training.app.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Autowired private CityRepository cityRepository;
    @Autowired private AppRepository appRepository;

    public List<CityModel> getAllCity() {

        List<City> cityList = cityRepository.findAll();

        return transformEntityToModel(cityList);

    }

    public List<CityModel> getByContryCode(String countryCode) {

        List<City> cityList = cityRepository.findByCountryCode(countryCode);

        return transformEntityToModel(cityList);

    }

    public List<CityModel> getByContryCodeWithNewDs(String countryCode) {

        List<CityModel> cityList = null;
        try {
            cityList = appRepository.findByCountryCode(countryCode);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cityList;

    }

    public List<CityModel> transformEntityToModel(List<City> cityList) {
        List<CityModel> cityModelList = new ArrayList<>();

        for (City c: cityList) {
            CityModel x = new CityModel();
            x.setCountryCode(c.getCountryCode());
            x.setDistrict(c.getDistrict());
            x.setId(c.getId());
            x.setName(c.getName());
            x.setPopulation(c.getPopulation());

            cityModelList.add(x);
        }

        return cityModelList;
    }

}
