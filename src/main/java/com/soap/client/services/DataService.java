package com.soap.client.services;

import com.soap.client.model.Data;
import com.soap.client.repository.DataRepository;
import com.soap.client.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    RecordRepository recordRepository;

    @Autowired
    DataRepository dataRepository;

    public List<Data> getDatesByBic(String bic){
        return dataRepository.findAllByOwner(recordRepository.findByBic(bic));
    }
}
