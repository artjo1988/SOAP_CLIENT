package com.soap.client.repository;

import com.soap.client.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import com.soap.client.model.Record;

import java.util.List;

public interface DataRepository extends JpaRepository<Data, Long> {

    List<Data> findAllByOwner(Record owner);

}
