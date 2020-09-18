package org.maoz.training.app.ws.service;

import https.maoz_developer_com.ws.*;
import org.maoz.training.app.model.CityModel;
import org.maoz.training.app.service.CityService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "https://maoz-developer.com/ws";

    private CityService cityService;

    public CountryEndpoint(CityService cityService) {
        this.cityService = cityService;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryByCodeRequest")
    @ResponsePayload
    public GetCountryByCodeResponse getCountryByCode(@RequestPayload GetCountryByCodeRequest request) {
        GetCountryByCodeResponse response = new GetCountryByCodeResponse();
        List<CityModel> cityModelList = cityService.getByContryCodeWithNewDs(request.getCountryCode());
        for (CityModel x: cityModelList) {
            Country c = new Country();
            c.setCountryCode(x.getCountryCode());
            c.setDistrict(x.getDistrict());
            c.setName(x.getName());
            c.setPopulation(x.getPopulation());

            response.getCountries().add(c);
        }


        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryByNameRequest")
    @ResponsePayload
    public GetCountryByNameResponse getCountryByName(@RequestPayload GetCountryByNameRequest request) {
        GetCountryByNameResponse response = new GetCountryByNameResponse();
        List<CityModel> cityModelList = cityService.getByNameWithNewDs(request.getName());
        for (CityModel x: cityModelList) {
            Country c = new Country();
            c.setCountryCode(x.getCountryCode());
            c.setDistrict(x.getDistrict());
            c.setName(x.getName());
            c.setPopulation(x.getPopulation());

            response.getCountries().add(c);
        }


        return response;
    }
}
