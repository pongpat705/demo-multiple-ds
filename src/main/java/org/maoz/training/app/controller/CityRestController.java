package org.maoz.training.app.controller;

import org.maoz.training.app.model.CityInquiryModel;
import org.maoz.training.app.model.CityModel;
import org.maoz.training.app.model.ResponseModel;
import org.maoz.training.app.service.CityService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/my-api")
public class CityRestController {

    private CityService cityService;

    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @CrossOrigin("*")
    @RequestMapping(path = "/get-all-city", method = RequestMethod.GET)
    public ResponseModel<List<CityModel>> getAllCity(){
        ResponseModel<List<CityModel>> result = new ResponseModel<>();
        List<CityModel> data = cityService.getAllCity();
        result.setData(data);
        result.setResponseCode(200);
        result.setResponseMessage("OK");

        return result;
    }

    @RequestMapping(path = "/get-by-countryCode", method = RequestMethod.GET)
    public ResponseModel<List<CityModel>> getByContryCode(@RequestParam String countryCode, HttpServletRequest request){
        String param = request.getParameter("countryCode");

        System.out.println("param "+param);
        System.out.println("countryCode "+countryCode);

        ResponseModel<List<CityModel>> result = new ResponseModel<>();
        List<CityModel> data = cityService.getByContryCode(countryCode);
        result.setData(data);
        result.setResponseCode(200);
        result.setResponseMessage("OK");

        return result;
    }

    @RequestMapping(path = "/country/{countryCode}", method = RequestMethod.GET)
    public ResponseModel<List<CityModel>> getByContryCode2(@PathVariable("countryCode") String countryCode, HttpServletRequest request){
        String param = request.getRequestURI();

        System.out.println("param "+param);
        System.out.println("countryCode "+countryCode);

        ResponseModel<List<CityModel>> result = new ResponseModel<>();
        List<CityModel> data = cityService.getByContryCode(countryCode);
        result.setData(data);
        result.setResponseCode(200);
        result.setResponseMessage("OK");

        return result;
    }

    @RequestMapping(path = "/country/{countryCode}/newds", method = RequestMethod.GET)
    public ResponseModel<List<CityModel>> getByContryCode3(@PathVariable("countryCode") String countryCode, HttpServletRequest request){
        String param = request.getRequestURI();

        System.out.println("param "+param);
        System.out.println("countryCode "+countryCode);

        ResponseModel<List<CityModel>> result = new ResponseModel<>();
        List<CityModel> data = cityService.getByContryCodeWithNewDs(countryCode);
        result.setData(data);
        result.setResponseCode(200);
        result.setResponseMessage("OK");

        return result;
    }

    @RequestMapping(path = "/inquiry/city", method = RequestMethod.POST)
    public ResponseModel<List<CityModel>> inquiryCity(@RequestBody CityInquiryModel cityInquiryModel, HttpServletRequest request){
        String param = request.getRequestURI();

        System.out.println("param "+param);
        System.out.println("cityInquiryModel "+cityInquiryModel.toString());

        ResponseModel<List<CityModel>> result = new ResponseModel<>();
        List<CityModel> data = cityService.getCityByModel(cityInquiryModel);
        result.setData(data);
        result.setResponseCode(200);
        result.setResponseMessage("OK");

        return result;
    }

}
