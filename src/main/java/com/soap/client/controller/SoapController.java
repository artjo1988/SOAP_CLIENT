package com.soap.client.controller;

import com.soap.client.model.Data;
import com.soap.client.model.Record;
import com.soap.client.services.DataService;
import com.soap.client.services.FileService;
import com.soap.client.services.RecordService;
import com.soap.client.services.SoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

@Controller
public class SoapController {

    @Autowired
    SoapService soapService;

    @Autowired
    FileService fileService;

    @Autowired
    RecordService recordService;

    @Autowired
    DataService dataService;

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/organizations/download")
    public ResponseEntity getOrganizations() {
        try {
            fileService.downloadFile();
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
        List<Record> listDb = recordService.getAllOrganizations();
        List<Record> listXml = recordService.getRecordsFromXml();
        if (!listDb.isEmpty() & !listXml.isEmpty()) {
            listDb.sort(Record::compareTo);
            listXml.sort(Record::compareTo);
            if (listDb.equals(listXml)) {
                return ResponseEntity.ok().build();
            }
        }
        List<Record> records = recordService.saveAndGetRecordsFromXml();
        dataService.saveAllDataFromAllOrganizations(records);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/organizations/list")
    public String getOrganizationsView(ModelMap modelMap) {
        List<Record> listDb = recordService.getAllOrganizations();
        List<Record> listXml = recordService.getRecordsFromXml();
        if (!listDb.isEmpty()) {
            modelMap.addAttribute("organizations", listDb);
        } else if (listXml.isEmpty()) {
            modelMap.addAttribute("message", "К сожелению, неактуальный список организаций пуст");
        } else {
            modelMap.addAttribute("message", "Предоставлен список с неактуальными данными");
            modelMap.addAttribute("organizations", listXml);
        }
        return "organizations";
    }

    // не производил проверку входных данных, т.к. запрос формируется автоматической
    // ссылкой
    @GetMapping("/organization/{bic}/dates")
    public String getListOrganizations(@PathVariable("bic") String bic, ModelMap modelMap) {
        Record record = recordService.getRecordByBic(bic);
        modelMap.addAttribute("organization", record);
        List<Data> dates = dataService.getDatesByBic(bic);
        if (!dates.isEmpty()) {
            modelMap.addAttribute("dates", dates);
        }
        return "orgdates";
    }
}
