package com.memory.Journal.controllers;

import com.memory.Journal.model.MemoryImageData;
import com.memory.Journal.model.MemoryModelNoSql;
import com.memory.Journal.repository.MemoryNoSqlRepository;
import com.memory.Journal.util.AmazonStorageService;
import com.memory.Journal.util.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/memory-no-sql")
public class MemoryControllerWithNoSql {

    private MemoryNoSqlRepository memoryRepository;

    private StorageService storageService;

    @Autowired
    public MemoryControllerWithNoSql(MemoryNoSqlRepository memoryNoSqlRepository, AmazonStorageService amazonStorageService) {
        this.memoryRepository = memoryNoSqlRepository;
        this.storageService = amazonStorageService;
    }

    @PostMapping("/create")
    public HttpStatus createMemory(@RequestBody MemoryModelNoSql memory) {
        MemoryModelNoSql byMemoryDate = memoryRepository.findByMemoryDate(memory.getMemoryDate());
        if (byMemoryDate != null) {
            memory.setId(byMemoryDate.getId());
        }
        memoryRepository.save(memory);

        return HttpStatus.OK;
    }

    @DeleteMapping("/delete")
    public HttpStatus deleteMemory(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date memoryDate) {
        MemoryModelNoSql memory = memoryRepository.findByMemoryDate(memoryDate);
        if (memory != null) {
            memoryRepository.delete(memory);
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_FOUND;
    }

    @GetMapping("/get-by-date")
    public MemoryModelNoSql getMemory(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date memoryDate) {
        MemoryModelNoSql memory = memoryRepository.findByMemoryDate(memoryDate);

        if (memory != null) {
            return memory;
        }
        return null;
    }

    @GetMapping("/get-all")
    public List<MemoryModelNoSql> getAllMemory() {
        List<MemoryModelNoSql> memories = memoryRepository.findAll();
        if (memories != null) {
            return memories;
        }
        return null;
    }

    @PostMapping("/upload")
    public HttpStatus saveMemoryImage(@ModelAttribute MemoryImageData memoryImageData) {
        storageService.saveFile(memoryImageData);
        return HttpStatus.OK;
    }
}
