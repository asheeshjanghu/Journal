package com.memory.Journal.repository;

import com.memory.Journal.model.MemoryModelNoSql;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
public interface MemoryNoSqlRepository extends MongoRepository<MemoryModelNoSql, Integer> {

    // important method name must be findByFIELDNAME format
    public MemoryModelNoSql findByMemoryDate(Date memoryDate);
}
