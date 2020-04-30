package com.memory.Journal.controllers;

import com.memory.Journal.model.Memory;
import com.memory.Journal.repository.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
public class MemoryController {

    private MemoryRepository memoryRepository;

    @Autowired
    public MemoryController(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    @PostMapping("/add-memory")
    public HttpStatus addMemory(@Valid @NotBlank @RequestBody Memory memory) {
        memoryRepository.save(memory);
        return HttpStatus.OK;
    }

}
