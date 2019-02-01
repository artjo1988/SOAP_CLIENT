package com.soap.client.repository;

import com.soap.client.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.soap.client.model.Record;

public interface DataRepository extends JpaRepository<Data, Long> {
}
