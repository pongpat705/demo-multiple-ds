package org.maoz.training.app.service;

import net.bytebuddy.asm.Advice;
import org.maoz.training.app.entity.City;
import org.maoz.training.app.model.CityInquiryModel;
import org.maoz.training.app.model.CityModel;
import org.maoz.training.app.repository.AppRepository;
import org.maoz.training.app.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> citeria = new HashMap<>();
        try {
            citeria.put("countryCode", countryCode);
            cityList = appRepository.findByCriteria(citeria);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cityList;

    }

    public List<CityModel> getCityByModel(CityInquiryModel cityInquiryModel) {

        List<CityModel> cityList = null;
        Map<String, Object> citeria = new HashMap<>();
        try {
            if(null != cityInquiryModel.getCountryCode()){
                citeria.put("countryCode", cityInquiryModel.getCountryCode());
            }
            if(null != cityInquiryModel.getName()){
                citeria.put("name", cityInquiryModel.getCountryCode());
            }
            cityList = appRepository.findByCriteria(citeria);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cityList;

    }

    public List<CityModel> getByNameWithNewDs(String name) {

        List<CityModel> cityList = null;
        Map<String, Object> citeria = new HashMap<>();
        try {
            citeria.put("name", name);
            cityList = appRepository.findByCriteria(citeria);
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
