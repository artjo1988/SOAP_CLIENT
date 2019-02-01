package com.soap.client.controller;

import com.soap.client.model.Data;
import com.soap.client.model.Record;
import com.soap.client.services.DataService;
import com.soap.client.services.FileService;
import com.soap.client.services.RecordService;
import com.soap.client.services.SoapService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/organizations")
	public String getOrganizations(ModelMap modelMap) {
		try {
			fileService.downloadFile();
		} catch (IOException e) {
			// noop
		}
		modelMap.addAttribute("organizations", recordService.saveAndGetRecordsFromXml());
		return "organizations";
	}

	@GetMapping("/organization/{bic}/dates")
	public String getListOrganizations(@PathVariable("bic") String bic, ModelMap modelMap) {
        Record record = recordService.getRecordByBic(bic);
        modelMap.addAttribute("organization", record);
        List<Data> dates = dataService.getDatesByBic(bic);
        if (!dates.isEmpty()){
            modelMap.addAttribute("dates", dates);
        }
		return "orgdates";
	}
}
