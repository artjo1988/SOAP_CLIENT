package com.soap.client.controller;

import com.soap.client.services.FileService;
import com.soap.client.services.RecordService;
import com.soap.client.services.SoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class SoapController {

    @Autowired
    SoapService soapService;

    @Autowired
    FileService fileService;

    @Autowired
    RecordService recordService;

    @GetMapping("/home")
    public String getHome(){
        return "home";
    }

    @GetMapping("/organizations")
    public String getOrganizations(ModelMap modelMap){
        try {
            fileService.downloadFile();
        } catch (IOException e) {
            //noop
        }
        double intCode = soapService.getBicToIntCode("040173725").getBicToIntCodeResult();
        return "organizations";
    }

    @GetMapping("/organizations/list")
    public String getListOrganizations(ModelMap modelMap){
        double intCode = soapService.getBicToIntCode("040173725").getBicToIntCodeResult();
        double x  = (double)soapService.getCreditInfoByIntCodeResponse(intCode).getCreditInfoByIntCodeResult().getAny();
        return "organizations";
    }
}
