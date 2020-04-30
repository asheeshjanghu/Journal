package com.memory.Journal.repository;

import com.memory.Journal.model.Memory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryRepository extends CrudRepository<Memory, Integer> {

}
