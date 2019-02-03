package com.soap.client.services;

import com.soap.client.model.*;
import com.soap.client.repository.DataRepository;
import com.soap.client.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.util.List;

@Service
public class RecordService {

    @Autowired
    RecordRepository recordRepository;

    @Autowired
    DataRepository dataRepository;

    @Autowired
    SoapService soapService;

    public List<Record> saveAndGetRecordsFromXml() {
        BicCode bicCode = null;
        try {
            JAXBContext contex = JAXBContext.newInstance(BicCode.class, Record.class);
            Unmarshaller unmarshaller = contex.createUnmarshaller();
            StreamSource xml = new StreamSource("src/main/resources/" + FileService.FILE_NAME);
            bicCode = unmarshaller.unmarshal(xml, BicCode.class).getValue();

        } catch (JAXBException e) {
            // noop
        }
        assert bicCode != null;
        recordRepository.saveAll(bicCode.getList());
        return bicCode.getList();
    }

    public Record getRecordByBic(final String bic) {
        return recordRepository.findByBic(bic);
    }

    public List<Record> getAllOrganizations() {
        return recordRepository.findAll();
    }

}
