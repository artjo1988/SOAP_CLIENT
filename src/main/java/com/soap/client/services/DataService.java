package com.soap.client.services;

import com.soap.client.model.Data;
import com.soap.client.model.Record;
import com.soap.client.repository.DataRepository;
import com.soap.client.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

	@Autowired
	RecordRepository recordRepository;

	@Autowired
	DataRepository dataRepository;

	@Autowired
	SoapService soapService;

	public void saveAllDataFromAllOrganizations(final List<Record> records) {
		List<Data> list = new ArrayList<>();
		for (Record record : records) {
			try {
				list = dataRepository
						.saveAll(
								conversion(soapService
										.getDatesForF101Response((int) soapService
												.getCreditInfoByIntCodeResponse(soapService
														.getBicToIntCode(record.getBic()).getBicToIntCodeResult())
												.getCreditInfoByIntCodeXMLResult().getContent().get(0))
										.getGetDatesForF101Result().getDateTime(), record));
			} catch (Exception e) {
				Data data = new Data();
				data.setDate("00-00-00");
				data.setOwner(record);
				list.add(data);
				dataRepository.save(data);
			}
			if (list.isEmpty()) {
				throw new AssertionError("Запись дат органиации не прошла");
			}
		}
	}

	public List<Data> getDatesByBic(String bic) {
		return dataRepository.findAllByOwner(recordRepository.findByBic(bic));
	}

	private List<Data> conversion(final List<XMLGregorianCalendar> dates, final Record record) {
		List<Data> list = new ArrayList<>();
		for (XMLGregorianCalendar date : dates) {
			Data data = new Data();
			data.setDate(date.getYear() + "-" + date.getMonth() + "-" + date.getDay());
			data.setOwner(record);
			list.add(data);
		}
		return list;
	}
}
